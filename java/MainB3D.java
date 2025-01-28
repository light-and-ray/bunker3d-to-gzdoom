
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
        Json.export("LINES_bz", loader.bz); // Lines: unknown (somehow connected with right doors, maybe texture mirroring)
        Json.export("LINES_HEIGHT", loader.by); // 0 - full, 1 - bottom half, 2 - top half
        Json.export("DOORS_START_LINE_IDX", loader.DOORS_START_LINE_IDX);
        Json.export("CRATES_START_LINE_IDX", loader.CRATES_START_LINE_IDX);
        Json.export("CRATES_CONTENT", loader.CRATES_CONTENT); // 0 - nothing, 1 - ammo, 2 - health, 3 - health+ammo, 7 - health+ammo, 6 - unknown
        Json.export("CRATES_ANGLE", loader.CRATES_ANGLE);
        Json.export("FOOTER", loader.FOOTER);

        Json.export("FOE1_bZ", loader.bZ);
        Json.export("FOE1_bW", loader.bW);
        Json.export("FOE1_ca", loader.ca);
        Json.export("FOE1_bX", loader.bX);
        Json.export("FOE1_cb", loader.cb);
        Json.export("FOE1_cj", loader.cj);
        Json.export("FOE1_cc", loader.cc);
        Json.export("FOE1_cl", loader.cl);
        Json.export("FOE1_ce", loader.ce);
        Json.export("FOE1_ck", loader.ck);
        Json.export("FOE1_cf", loader.cf);
        Json.export("FOE1_z", loader.z);
        Json.export("FOE1_ei", loader.ei);

        Json.export("FOE2_bq", loader.bq);
        Json.export("FOE2_M", loader.M);
        Json.export("FOE2_bY", loader.bY);
        Json.export("FOE2_bt", loader.bt);
        Json.export("FOE2_bu", loader.bu);
        Json.export("FOE2_bj", loader.bj);
        Json.export("FOE2_foeW", loader.foeW);
        Json.export("FOE2_foeH", loader.foeH);

        Json.export("BIG_LUMP_0", loader.E[0]);
        Json.export("BIG_LUMP_1", loader.E[1]);
        Json.export("BIG_LUMP_2", loader.E[2]);
    }
}
