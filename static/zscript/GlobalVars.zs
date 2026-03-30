
class GlobalVars_t : EventHandler
{
    int lastPuffFrame;
    string puffClass;
}

class FillB3DDefaults : EventHandler
{
    GlobalVars_t globalVars;

    override void WorldLoaded (WorldEvent e) {
        globalVars = GlobalVars_t(EventHandler.Find("GlobalVars_t"));
        globalVars.puffClass = "B3DBulletPuff";
    }
}

class FillL3DDefaults : EventHandler
{
    GlobalVars_t globalVars;

    override void WorldLoaded (WorldEvent e) {
        globalVars = GlobalVars_t(EventHandler.Find("GlobalVars_t"));
        globalVars.puffClass = "L3DBulletPuff";
    }
}

class FillC3DDefaults : EventHandler
{
    GlobalVars_t globalVars;

    override void WorldLoaded (WorldEvent e) {
        globalVars = GlobalVars_t(EventHandler.Find("GlobalVars_t"));
        globalVars.puffClass = "C3DBulletPuff";
    }
}

