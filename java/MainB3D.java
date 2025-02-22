
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
        Json.export("LINES_MIRRORING", loader.bz);
        Json.export("LINES_bs", loader.bs);
        Json.export("LINES_bk", loader.bk);
        Json.export("LINES_br", loader.br);
        Json.export("LINES_bA", loader.bA);
        Json.export("LINES_ANIMATED", loader.fE);
        Json.export("LINES_HEIGHT", loader.by); // 0 - full, 1 - bottom half, 2 - top half
        Json.export("DOORS_START_LINE_IDX", loader.DOORS_START_LINE_IDX);
        Json.export("CRATES_START_LINE_IDX", loader.CRATES_START_LINE_IDX);
        Json.export("CRATES_CONTENT", loader.CRATES_CONTENT); // 0 - nothing, 1 - ammo, 2 - health, 3 - health+ammo, 7 - health+ammo, 6 - unknown
        Json.export("CRATES_ANGLE", loader.CRATES_ANGLE);
        Json.export("CIRCLES_IDX", loader.CIRCLES_IDX);
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

        Json.export("TEXTURES_DATA", loader.TEXTURES_DATA);
        Json.export("TEXTURES_W", loader.TEXTURES_W);
        Json.export("TEXTURES_H", loader.TEXTURES_H);
        Json.export("ANIMATED_FRAMES", loader.fG);

        Json.export("DOORS_dr", loader.dr);
        Json.export("DOORS_ds", loader.ds);
        Json.export("DOORS_dv", loader.dv);
        Json.export("DOORS_dw", loader.dw);
        Json.export("DOORS_SPEED", loader.dt); // -1 - closed, 8 - fast, 24 - slow
        Json.export("DOORS_dx", loader.dx);
        Json.export("DOORS_dy", loader.dy);
        Json.export("DOORS_dz", loader.dz);
        Json.export("DOORS_dA", loader.dA);
        Json.export("DOORS_dB", loader.dB);
        Json.export("DOORS_du", loader.du);

        // Json.export("UNKNOWN_cg", loader.cg);
        // Json.export("UNKNOWN_bT", loader.bT);
        // Json.export("UNKNOWN_cm", loader.cm);
        // Json.export("UNKNOWN_cd", loader.cd);
        // Json.export("UNKNOWN_ch", loader.ch);

        Json.export("SPRITES_DATA", loader.SPRITES_DATA);
        Json.export("SPRITES_W", loader.SPRITES_W);
        Json.export("SPRITES_H", loader.SPRITES_H);
    }
}
