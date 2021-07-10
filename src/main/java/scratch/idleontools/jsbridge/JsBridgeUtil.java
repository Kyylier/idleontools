package scratch.idleontools.jsbridge;

import com.google.common.base.Preconditions;
import org.mozilla.javascript.NativeObject;
import org.mozilla.javascript.ast.AstNode;

import java.util.LinkedHashMap;
import java.util.Map;

public final class JsBridgeUtil {

    public static String trimmedSrc(AstNode node) {
        String result = node.toSource();
        result = result.substring(0, Math.min(result.length(), 100));
        return result.replaceAll("\n", "").trim();
    }

    public static NativeObject flattenOnce(NativeObject o) {
        Preconditions.checkArgument(o.keySet().size() == 1);
        String extraLayer = (String) o.keySet().stream().findFirst().get();
        return (NativeObject) o.get(extraLayer);
    }

    public static LinkedHashMap<String, Object> convertToMap(NativeObject nativeObject) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        nativeObject.keySet().forEach(key -> {
            Object property = nativeObject.get(key);
            resultMap.put((String) key, property instanceof NativeObject ? convertToMap((NativeObject) property) : property);
        });
        return resultMap;
    }

    private JsBridgeUtil() {}
}
