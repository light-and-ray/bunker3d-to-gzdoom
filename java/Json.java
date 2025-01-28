import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Json {

    public static String ROOT_TMP = "../tmp";

    public static void export(String filename, Object array) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ROOT_TMP + "/" + filename + ".json"))) {
            out.print(toJson(array));
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
            System.exit(1);
        }
    }

    private static String toJson(Object array) {
        if (array == null) {
            return "null";
        }
        if (array instanceof ArrayList) {
            return toJsonArrayList((ArrayList<?>) array);
        } else if (array.getClass().isArray()) {
            return toJsonArray(array);
        } else {
            return "\"" + array.toString() + "\"";
        }
    }

    private static String toJsonArrayList(ArrayList<?> array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.size(); i++) {
            Object element = array.get(i);
            if (element == null) {
                sb.append("null");
            } else if (element instanceof ArrayList) {
                sb.append(toJsonArrayList((ArrayList<?>) element));
            } else if (element instanceof Byte || element instanceof Short || element instanceof Integer || element instanceof Long || element instanceof Float || element instanceof Double || element instanceof Boolean) {
                sb.append(element.toString());
            } else {
                sb.append("\"" + element.toString() + "\"");
            }
            if (i < array.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String toJsonArray(Object array) {
        int length = Array.getLength(array);
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            Object element = Array.get(array, i);
            if (element == null) {
                sb.append("null");
            } else if (element.getClass().isArray()) {
                sb.append(toJsonArray(element));
            } else if (element instanceof Byte || element instanceof Short || element instanceof Integer || element instanceof Long || element instanceof Float || element instanceof Double || element instanceof Boolean) {
                sb.append(element.toString());
            } else {
                sb.append("\"" + element.toString() + "\"");
            }
            if (i < length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}