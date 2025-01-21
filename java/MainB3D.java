
public class MainB3D {
    public static void main(String[] args) {
        int selectedMap = Integer.parseInt(args[0]);
        ResourcesLoaderB3D loader = new ResourcesLoaderB3D();
        loader.selectedMap = selectedMap;
        loader.readMetadata();
        loader.initCosTable();
        loader.loadMap();
        Json.export("LINES_VERTEXES", loader.cW);
        Json.export("LINES_TEXTURES", loader.cX);
        Json.export("bz", loader.bz); // Lines: unknown (somehow connected with right doors, maybe texture mirroring)
        Json.export("LINES_HEIGHT", loader.by); // 0 - full, 1 - bottom half, 2 - top half
        Json.export("DOORS_START_LINE_IDX", loader.DOORS_START_LINE_IDX);
        Json.export("CRATES_START_LINE_IDX", loader.CRATES_START_LINE_IDX);
        Json.export("CRATES_CONTENT", loader.CRATES_CONTENT); // 0 - nothing, 1 - ammo, 2 - health, 3 - health+ammo, 7 - health+ammo, 6 - unknown
        Json.export("CRATES_ANGLE", loader.CRATES_ANGLE);
    }
}
