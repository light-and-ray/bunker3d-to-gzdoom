
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
        Json.export("DOORS_SPEED", loader.dt); // -1 - closed, 8 - fast, 24 - slow
        Json.export("CRATES_START_LINE_IDX", loader.CRATES_START_LINE_IDX);
        Json.export("CRATES_CONTENT", loader.CRATES_CONTENT); // 0 - nothing, 1 - ammo, 2 - health, 3 - health+ammo, 7 - health+ammo, 6 - unknown
        Json.export("CRATES_ANGLE", loader.CRATES_ANGLE);
        Json.export("CIRCLES_IDX", loader.CIRCLES_IDX);
        Json.export("FOOTER", loader.FOOTER);

        Json.export("TEXTURES_DATA", loader.TEXTURES_DATA);
        Json.export("TEXTURES_W", loader.TEXTURES_W);
        Json.export("TEXTURES_H", loader.TEXTURES_H);
        Json.export("ANIMATED_FRAMES", loader.fG);

        // THINGS SPECIALS
        // lamp: 127 (on), -2 (off), -1 (flick);
        // npc: -20 (foe), -2 (boss), 26 (friendly1), 32 (final boss), 30 (friendly2)
        Json.export("THINGS_SPECIAL", loader.ca);
        Json.export("THINGS_SPRITE", loader.cg); // 0-15 (npc), 16-31 (lamp), 32-47 (decoration), 48+ (crate content)
        Json.export("THINGS_POS", loader.bT);
        Json.export("THINGS_VISIBLE", loader.cm);
        // Json.export("THINGS_cd", loader.cd);
        Json.export("THINGS_COLOR", loader.ch);

        Json.export("SPRITES_DATA_COLOR_1", loader.SPRITES_DATA_COLOR_1);
        Json.export("SPRITES_DATA_COLOR_2", loader.SPRITES_DATA_COLOR_2);
        Json.export("SPRITES_W", loader.SPRITES_W);
        Json.export("SPRITES_H", loader.SPRITES_H);

        Json.export("SPAWN_POS", loader.fz);
        Json.export("SPAWN_ANGLE", loader.eR);

        Json.export("FOE_SPRITES_DATA_COLOR_1", loader.FOE_SPRITES_DATA_COLOR_1);
        Json.export("FOE_SPRITES_DATA_COLOR_2", loader.FOE_SPRITES_DATA_COLOR_2);
        Json.export("FOE_SPRITES_W", loader.FOE_SPRITES_W);
        Json.export("FOE_SPRITES_H", loader.FOE_SPRITES_H);
        Json.export("FOE_ANGLES", loader.bW);

        // Json.export("UNKNOWN_cD", loader.cD);
        // Json.export("UNKNOWN_cE", loader.cE);
        // Json.export("UNKNOWN_bZ", loader.bZ);
        // Json.export("UNKNOWN_bX", loader.bX);
        // Json.export("UNKNOWN_cb", loader.cb);
        // Json.export("UNKNOWN_cj", loader.cj);
        // Json.export("UNKNOWN_cc", loader.cc);
        // Json.export("UNKNOWN_cl", loader.cl);
        // Json.export("UNKNOWN_ce", loader.ce);
        // Json.export("UNKNOWN_ck", loader.ck);
        // Json.export("UNKNOWN_cf", loader.cf);
        // Json.export("UNKNOWN_z", loader.z);
        // Json.export("UNKNOWN_ei", loader.ei);

        // Json.export("FOE2_bq", loader.bq);
        // Json.export("FOE2_M", loader.M);
        // Json.export("FOE2_bY", loader.bY);
        // Json.export("FOE2_bt", loader.bt);
        // Json.export("FOE2_bu", loader.bu);
        // Json.export("FOE2_bj", loader.bj);
        // Json.export("FOE2_foeW", loader.foeW);
        // Json.export("FOE2_foeH", loader.foeH);
    }
}
