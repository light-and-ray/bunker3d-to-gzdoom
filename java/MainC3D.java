import java.util.Random;

public class MainC3D {
    public static void main(String[] args) {
        int selectedMap = Integer.parseInt(args[0]);
        ResourcesLoaderC3D loader = new ResourcesLoaderC3D();
        loader.selectedMap = selectedMap;
        if (selectedMap == 13) {
            loader.ji = true;
        }
        loader.fg = new Random();
        loader.readMetadata();
        loader.initCosTable();
        loader.loadMap();
        Json.export("LINES_VERTEXES", loader.dP);
        Json.export("LINES_TEXTURES", loader.dW);
        Json.export("LINES_MIRRORING", loader.bS);
        Json.export("LINES_TEXTURES_HELP_1", loader.bL);
        Json.export("LINES_TEXTURES_HELP_2", loader.bD);
        Json.export("LINES_TEXTURES_HELP_3", loader.bK);
        Json.export("LINES_TEXTURES_HELP_4", loader.bT);
        Json.export("LINES_ANIMATED", loader.hN);
        Json.export("LINES_HEIGHT", loader.bR); // 0 - full, 1 - bottom half, 2 - top half
        Json.export("DOORS_START_LINE_IDX", loader.DOORS_START_LINE_IDX);
        Json.export("DOORS_SPEED", loader.eF); // -1 - closed, 8 - fast, 24 - slow
        Json.export("CRATES_START_LINE_IDX", loader.CRATES_START_LINE_IDX);
        Json.export("CRATES_CONTENT", loader.CRATES_CONTENT); // 0 - nothing, 1 - ammo, 2 - health, 3 - health+ammo, 7 - health+ammo, 6 - unknown
        Json.export("CRATES_ANGLE", loader.CRATES_ANGLE);
        Json.export("CIRCLES_IDX", loader.CIRCLES_IDX);

        Json.export("TEXTURES_DATA", loader.TEXTURES_DATA);
        Json.export("TEXTURES_W", loader.TEXTURES_W);
        Json.export("TEXTURES_H", loader.TEXTURES_H);
        Json.export("ANIMATED_FRAMES", loader.hP);
        Json.export("FOOTER", loader.FOOTER);

        // THINGS SPECIALS
        // lamp: 127 (on), -2 (off), -1 (flick);
        // npc: -20 (foe), -2 (boss), 26 (friendly1), 32 (final boss), 30 (friendly2)
        Json.export("THINGS_SPECIAL", loader.cG);
        Json.export("THINGS_SPRITE", loader.cO); // 0-15 (npc), 16-31 (lamp), 32-47 (decoration), 48+ (crate content)
        Json.export("THINGS_POS", loader.cx);
        Json.export("THINGS_VISIBLE", loader.cW);
        Json.export("THINGS_COLOR", loader.cP);

        Json.export("SPRITES_DATA_COLOR_1", loader.SPRITES_DATA_COLOR_1);
        Json.export("SPRITES_DATA_COLOR_2", loader.SPRITES_DATA_COLOR_2);
        Json.export("SPRITES_W", loader.SPRITES_W);
        Json.export("SPRITES_H", loader.SPRITES_H);

        Json.export("SPAWN_POS", loader.hF);
        Json.export("SPAWN_ANGLE", loader.gJ);

        Json.export("FOE_SPRITES_DATA_COLOR_1", loader.FOE_SPRITES_DATA_COLOR_1);
        Json.export("FOE_SPRITES_DATA_COLOR_2", loader.FOE_SPRITES_DATA_COLOR_2);
        Json.export("FOE_SPRITES_W", loader.FOE_SPRITES_W);
        Json.export("FOE_SPRITES_H", loader.FOE_SPRITES_H);
        Json.export("FOE_ANGLES", loader.cC);
        Json.export("FOE_WALK_DISTANCE", loader.cG); // !!! FOE_WALK_DISTANCE == THINGS_SPECIAL

        Json.export("VISIBLE_THING_SETS", loader.cR);
        Json.export("VISIBLE_THING_SET_START", loader.hh);
        Json.export("TRIGGERS", loader.eC); // rect (C_x - 75000, C_y - 75000, C_x + 75000, C_y + 75000)
        Json.export("TRIGGER_END_OF_LEVEL", loader.gK);
        Json.export("TRIGGER_VISIBLE_THING_SET", loader.eG);

        Json.export("UNKNOWN_cD", loader.cD); // maybe door side texture
        Json.export("UNKNOWN_hp", loader.hp);

        // Json.export("DEBUG_dn", loader.dn); // sets of lines. Maybe ranges of visible lines
        // Json.export("DEBUG_do_", loader.do_);

        // Json.export("DEBUG_cL", loader.cL); // something interesting for things

        // Json.export("DEBUG_hQ", loader.hQ); // more for animation (not useful on level 7)
        // Json.export("DEBUG_hM", loader.hM);
        // Json.export("DEBUG_hK", loader.hK);

        // Json.export("DEBUG_dR", loader.dR); // maybe tall doors, but no line numbers
        // Json.export("DEBUG_dT", loader.dT);
        // Json.export("DEBUG_dS", loader.dS);
        // Json.export("DEBUG_dN", loader.dN);
        // Json.export("DEBUG_dO", loader.dO);
        // Json.export("DEBUG_dQ", loader.dQ);
        // Json.export("DEBUG_dX", loader.dX);
        // Json.export("DEBUG_dU", loader.dU);
        // Json.export("DEBUG_dV", loader.dV);
        // Json.export("DEBUG_cQ", loader.cQ);

        // Json.export("DEBUG_cy", loader.cy); // maybe decoration animations

    }

}
