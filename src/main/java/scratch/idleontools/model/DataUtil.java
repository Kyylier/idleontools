package scratch.idleontools.model;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public final class DataUtil {

    private DataUtil() {}

    public static JsonObject getDocumentMainFields(JsonObject firebaseDocument) {
        return firebaseDocument.getAsJsonObject("fields");
    }

    public static Integer getFieldAsInt(JsonObject jsonObject, String field) {
        return Integer.parseInt(jsonObject.getAsJsonObject(field).get("integerValue").getAsString());
    }

    public static String getFieldAsString(JsonObject jsonObject, String field) {
        return jsonObject.getAsJsonObject(field).get("stringValue").getAsString();
    }

    public static JsonArray getFieldAsArray(JsonObject jsonObject, String field) {
        return jsonObject.getAsJsonObject(field).getAsJsonObject("arrayValue").getAsJsonArray("values");
    }

    public static double getNumericObjectAsDouble(JsonObject jsonObject) {
        Preconditions.checkArgument(jsonObject.size() == 1);
        if (jsonObject.has("doubleValue")) {
            return jsonObject.get("doubleValue").getAsDouble();
        } else if (jsonObject.has("integerValue")) {
            return jsonObject.get("integerValue").getAsInt();
        } else {
            throw new RuntimeException("Unknown numeric object: %s".formatted(jsonObject));
        }
    }

    public static JsonObject flattenMapValue(JsonObject jsonObject) {
        Preconditions.checkArgument(jsonObject.size() == 1);
        Preconditions.checkArgument(jsonObject.has("mapValue"));

        JsonObject mapValueJsonObject = jsonObject.getAsJsonObject("mapValue");
        Preconditions.checkArgument(mapValueJsonObject.size() == 1);
        Preconditions.checkArgument(mapValueJsonObject.has("fields"));

        JsonObject fieldsJsonObject = mapValueJsonObject.getAsJsonObject("fields");
        Preconditions.checkArgument(fieldsJsonObject.has("length"));
        Preconditions.checkArgument(fieldsJsonObject.getAsJsonObject("length").get("integerValue").getAsInt() == fieldsJsonObject.size() - 1);

        JsonObject flattenedResult = new JsonObject();
        fieldsJsonObject.entrySet().forEach(entry -> {
            if (!entry.getKey().equals("length")) {
                flattenedResult.add(entry.getKey(), entry.getValue());
            }
        });
        return flattenedResult;
    }

    public static double[] parseNumericArray(JsonArray jsonArray) {
        double[] result = new double[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject arrayCell = jsonArray.get(i).getAsJsonObject();
            Preconditions.checkArgument(arrayCell.keySet().size() == 1);
            if (arrayCell.has("doubleValue")) {
                result[i] = arrayCell.get("doubleValue").getAsDouble();
            } else if (arrayCell.has("integerValue")) {
                result[i] = arrayCell.get("integerValue").getAsInt();
            } else {
                throw new RuntimeException("Unknown element in numeric array: %s".formatted(jsonArray));
            }
        }
        return result;
    }

    public static int[] parseIntegerArray(JsonArray jsonArray) {
        int[] result = new int[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject arrayCell = jsonArray.get(i).getAsJsonObject();
            Preconditions.checkArgument(arrayCell.keySet().size() == 1);
            if (arrayCell.has("integerValue")) {
                result[i] = arrayCell.get("integerValue").getAsInt();
            } else {
                throw new RuntimeException("Unknown element in integer array: %s".formatted(jsonArray));
            }
        }
        return result;
    }
}
