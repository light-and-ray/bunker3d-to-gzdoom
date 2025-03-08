public class MainL3D {
    public static void main(String[] args) {
        int selectedMap = Integer.parseInt(args[0]);
        ResourcesLoaderL3D loader = new ResourcesLoaderL3D();
        loader.selectedMap = selectedMap;
        loader.readMetadata();
        loader.initCosTable();
        loader.loadMap();
        Json.export("LINES_VERTEXES", loader.dg);
        Json.export("LINES_TEXTURES", loader.dh);
        Json.export("LINES_MIRRORING", loader.bw);
        Json.export("LINES_TEXTURES_HELP_1", loader.bp);
        Json.export("LINES_TEXTURES_HELP_2", loader.bh);
        Json.export("LINES_TEXTURES_HELP_3", loader.bo);
        Json.export("LINES_TEXTURES_HELP_4", loader.bx);
        Json.export("LINES_ANIMATED", loader.gv);
        Json.export("LINES_HEIGHT", loader.bv); // 0 - full, 1 - bottom half, 2 - top half
        Json.export("DOORS_START_LINE_IDX", loader.DOORS_START_LINE_IDX);
        Json.export("DOORS_SPEED", loader.dL); // -1 - closed, 8 - fast, 24 - slow
        Json.export("CRATES_START_LINE_IDX", loader.CRATES_START_LINE_IDX);
        Json.export("CRATES_CONTENT", loader.CRATES_CONTENT); // 0 - nothing, 1 - ammo, 2 - health, 3 - health+ammo, 7 - health+ammo, 6 - unknown
        Json.export("CRATES_ANGLE", loader.CRATES_ANGLE);
        Json.export("CIRCLES_IDX", loader.CIRCLES_IDX);
        // Json.export("LAST_BASE_GEOMETRY_LINE", loader.LAST_BASE_GEOMETRY_LINE);

        Json.export("TEXTURES_DATA", loader.TEXTURES_DATA);
        Json.export("TEXTURES_W", loader.TEXTURES_W);
        Json.export("TEXTURES_H", loader.TEXTURES_H);
        Json.export("ANIMATED_FRAMES", loader.gx);
        Json.export("FOOTER", loader.FOOTER);

        // THINGS SPECIALS
        // lamp: 127 (on), -2 (off), -1 (flick);
        // npc: -20 (foe), -2 (boss), 26 (friendly1), 32 (final boss), 30 (friendly2)
        Json.export("THINGS_SPECIAL", loader.ck); // !!! 64 instead of 32
        // this.cc maybe animated
        Json.export("THINGS_SPRITE", loader.cq); // 0-15 (npc), 16-31 (lamp), 32-47 (decoration), 48+ (crate content)
        Json.export("THINGS_POS", loader.cb);
        Json.export("THINGS_VISIBLE", loader.cw);
        // Json.export("THINGS_cd", loader.cd);
        Json.export("THINGS_COLOR", loader.cr);

        // Json.export("SPRITES_DATA_COLOR_1", loader.SPRITES_DATA_COLOR_1);
        // Json.export("SPRITES_DATA_COLOR_2", loader.SPRITES_DATA_COLOR_2);
        // Json.export("SPRITES_W", loader.SPRITES_W);
        // Json.export("SPRITES_H", loader.SPRITES_H);

        Json.export("SPAWN_POS", loader.gn);
        Json.export("SPAWN_ANGLE", loader.fz);

        // Json.export("FOE_SPRITES_DATA_COLOR_1", loader.FOE_SPRITES_DATA_COLOR_1);
        // Json.export("FOE_SPRITES_DATA_COLOR_2", loader.FOE_SPRITES_DATA_COLOR_2);
        // Json.export("FOE_SPRITES_W", loader.FOE_SPRITES_W);
        // Json.export("FOE_SPRITES_H", loader.FOE_SPRITES_H);
        // Json.export("FOE_ANGLES", loader.bW);
        // Json.export("FOE_WALK_DISTANCE", loader.bZ);
    }

}
