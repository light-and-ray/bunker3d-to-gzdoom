import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        if (array instanceof byte[]) {
            return toJson((byte[]) array);
        } else if (array instanceof int[]) {
            return toJson((int[]) array);
        } else if (array instanceof byte[][]) {
            return toJson((byte[][]) array);
        } else if (array instanceof int[][]) {
            return toJson((int[][]) array);
        } else if (array instanceof ArrayList) {
            return toJson((ArrayList<?>) array);
        } else {
            return "Unsupported type";
        }
    }

    private static String toJson(byte[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String toJson(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String toJson(byte[][] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append("[");
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]);
                if (j < array[i].length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String toJson(int[][] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append("[");
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]);
                if (j < array[i].length - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            if (i < array.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static String toJson(ArrayList<?> array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.size(); i++) {
            Object obj = array.get(i);
            if (obj instanceof Integer) {
                sb.append(obj);
            } else if (obj instanceof Byte) {
                sb.append(obj);
            } else if (obj instanceof ArrayList) {
                sb.append(toJson((ArrayList<?>) obj));
            } else {
                sb.append("\"" + obj.toString() + "\"");
            }
            if (i < array.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
