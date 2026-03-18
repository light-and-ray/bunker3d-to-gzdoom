#include "zscript/Helpers.zs"

class GlassBreakerActor_t : Actor
{
    Default
    {
        +NOGRAVITY;
    }
    States
    {
        Spawn:
            LSPT A 1;
            loop;
    }
}


class GlassBreakHandler : EventHandler
{
    Helpers_t helpers;

    void attachGlassBreakerActor(Line linkedLine, double x, double y)
    {
        Vector3 pos;
        pos.x = x;
        pos.y = y;
        pos.z = 48;
        GlassBreakerActor_t spawned = GlassBreakerActor_t(Actor.Spawn('GlassBreakerActor_t', pos));
    }

    override void WorldLoaded(WorldEvent event)
    {
        for (int i = 0; i < Level.lines.size(); i++)
        {
            String altTextureType = Level.lines[i].GetUDMFString("user_b3d_alt_texture_type");
            if (altTextureType == "glass_break")
            {
                Array<double> spawnPointsX;
                helpers.getPosForLineHandlers(spawnPointsX,
                    Level.lines[i].v1.p.x, Level.lines[i].v1.p.y,
                    Level.lines[i].v2.p.x, Level.lines[i].v2.p.y,
                    30, true
                );
                Array<double> spawnPointsY;
                helpers.getPosForLineHandlers(spawnPointsY,
                    Level.lines[i].v1.p.x, Level.lines[i].v1.p.y,
                    Level.lines[i].v2.p.x, Level.lines[i].v2.p.y,
                    30, false
                );
                for (int j = 0; j < spawnPointsX.size(); j++)
                {
                    attachGlassBreakerActor(Level.lines[i], spawnPointsX[j], spawnPointsY[j]);
                }
            }
        }
    }
}

