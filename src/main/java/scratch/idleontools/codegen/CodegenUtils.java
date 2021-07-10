package scratch.idleontools.codegen;

import java.util.Locale;

public final class CodegenUtils {

    public static String formatAsEnumFieldName(String s) {
        s = s.toUpperCase(Locale.ROOT).replaceAll("[^a-zA-Z0-9]", "_");
        if (Character.isDigit(s.charAt(0))) {
            s = "_" + s;
        }
        return s;
    }

    private CodegenUtils() {}
}
