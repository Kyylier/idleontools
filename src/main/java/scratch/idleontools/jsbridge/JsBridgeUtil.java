package scratch.idleontools.jsbridge;

import org.mozilla.javascript.ast.AstNode;

public final class JsBridgeUtil {

    public static String trimmedSrc(AstNode node) {
        String result = node.toSource();
        result = result.substring(0, Math.min(result.length(), 100));
        return result.replaceAll("\n", "").trim();
    }

    private JsBridgeUtil() {}
}
