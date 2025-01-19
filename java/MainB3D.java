import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainB3D {

    public static void main(String[] args) {
        int selectedMap = Integer.parseInt(args[0]);
        ResourcesLoaderB3D loader = new ResourcesLoaderB3D();
        loader.selectedMap = selectedMap;
        loader.readMetadata();
        loader.initPrecalculatedAngles();
        loader.loadMap();
        Json.export("cW", loader.cW);
    }
}