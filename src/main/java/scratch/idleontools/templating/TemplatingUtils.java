package scratch.idleontools.templating;

import java.util.Locale;

public final class TemplatingUtils {

    public static String formatAsEnumFieldName(String s) {
        s = s.toUpperCase(Locale.ROOT);
        if (Character.isDigit(s.charAt(0))) {
            s = "_" + s;
        }
        return s.replaceAll("-", "_")
                .replaceAll("\"", "_")
                .replaceAll("'", "_")
                .replaceAll("\\\\", "_");
    }

    private TemplatingUtils() {}
}
