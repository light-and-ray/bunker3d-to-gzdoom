public class Main {
    public static void main(String[] args) {
        int selectedMap = Integer.parseInt(args[0]);
        ResourcesLoaderB3D loader = new ResourcesLoaderB3D();
        loader.selectedMap = selectedMap;
        loader.readMetadata();
        loader.initCosTable();
        loader.loadMap();
        Json.export("cW", loader.cW); // Lines: vertexes
        Json.export("cX", loader.cX); // Lines: textures
        Json.export("bz", loader.bz); // Lines: unknown (somehow connected with right doors, maybe texture mirroring)
        Json.export("by", loader.by); // Lines: height: 0 - full, 1 - bottom half, 2 - top half
    }
}