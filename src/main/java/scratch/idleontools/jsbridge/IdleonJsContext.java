package scratch.idleontools.jsbridge;

import com.google.common.base.Preconditions;
import org.mozilla.javascript.*;
import org.mozilla.javascript.ast.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public final class IdleonJsContext {

    private final String defaultSrcName;

    private boolean initialized = false;

    private Context context;
    private Scriptable globalScope;
    private NativeObject godObject;

    private IdleonJsContext(String appJsLocation) {
        this.defaultSrcName = appJsLocation + ":ApplicationMainBlock:";
    }

    private void initialize(IdleonSrcNodeVisitor srcNodeVisitor) {
        Preconditions.checkState(!initialized);
        initialized = true;

        this.context = Context.enter();
        this.context.setOptimizationLevel(-1); // Set interpreted mode due to script complexity.
        this.globalScope = context.initStandardObjects();

        AstNode mainBlockChild = (AstNode) (srcNodeVisitor.getMainBlock().getFirstChild());
        int childIdx = 0;
        while (mainBlockChild != null) {
            String mainBlockChildSrc = mainBlockChild.toSource();
            try {
                context.evaluateString(
                        globalScope, mainBlockChildSrc,defaultSrcName + "child_" + childIdx,1,null);
            } catch (Exception ex) {
                System.out.printf(
                        "Could not execute ApplicationMainBlock child %d (size=%d) [%s]%n%s%n",
                        childIdx, mainBlockChildSrc.length(), JsBridgeUtil.trimmedSrc(mainBlockChild), ex.getMessage());
            }
            childIdx++;
            mainBlockChild = (AstNode) mainBlockChild.getNext();
        }

        this.godObject = (NativeObject) context.evaluateString(
                globalScope, srcNodeVisitor.getGodObjectName(), "", 1, null);
    }

    public Context getContext() {
        return context;
    }

    public Scriptable getGlobalScope() {
        return globalScope;
    }

    public NativeObject getGodObject() {
        return godObject;
    }

    public static IdleonJsContext initFromSource(String appJsLocation) throws IOException {
        String gameJs = new String(Objects.requireNonNull(Main.class.getClassLoader()
                .getResourceAsStream(appJsLocation)).readAllBytes(), StandardCharsets.UTF_8);
        AstRoot astRoot = (new Parser()).parse(gameJs, appJsLocation, 1);

        IdleonSrcNodeVisitor srcNodeVistor = new IdleonSrcNodeVisitor();
        astRoot.visit(srcNodeVistor);

        IdleonJsContext idleonJsContext = new IdleonJsContext(appJsLocation);
        idleonJsContext.initialize(srcNodeVistor);
        return idleonJsContext;
    }

    /**
     * Finds and extracts the main application code block, as well associated metadata for initializing the application
     * and interacting with it.
     */
    private static class IdleonSrcNodeVisitor implements NodeVisitor {

        private boolean done = false;

        private String godObjectName = null;
        private Block mainBlock = null;

        @Override
        public boolean visit(AstNode node) {
            if (done) {
                return true;
            }

            if (Token.STRING == node.getType()) {
                StringLiteral stringLiteralNode = (StringLiteral) node;
                if (stringLiteralNode.getValue().equals("ApplicationMain")) {
                    ExpressionStatement applicationMainAssign = (ExpressionStatement) node.getParent().getParent();
                    System.out.printf("Found ApplicationMain name definition [%s]%n", JsBridgeUtil.trimmedSrc(applicationMainAssign));

                    ExpressionStatement godObjectAssign = (ExpressionStatement) applicationMainAssign.getParent().getChildBefore(applicationMainAssign);
                    System.out.printf("Found ApplicationMain definition on god object [%s]%n", JsBridgeUtil.trimmedSrc(godObjectAssign));

                    this.godObjectName = ((Name) ((PropertyGet) ((Assignment) godObjectAssign.getExpression()).getLeft()).getLeft()).getIdentifier();
                    this.mainBlock = (Block) applicationMainAssign.getParent();
                    this.done = true;
                    return false;
                }
            }

            return true;
        }

        public String getGodObjectName() {
            return godObjectName;
        }

        public Block getMainBlock() {
            return mainBlock;
        }
    }
}
