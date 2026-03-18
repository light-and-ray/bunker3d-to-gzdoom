
class GlassBreakerActor_t : Actor
{
    Line connectedLine;
    Default
    {
        Health 50;
        GibHealth 99999999;
        ProjectilePassHeight 0;

        +SHOOTABLE;
        +DONTTHRUST;
        +NOBLOOD;
        +NOBLOODDECALS;

        +NOGRAVITY;
        +DONTFALL;

        +NOTAUTOAIMED;
        +GHOST;
    }
    States
    {
        Spawn:
            TNT1 A 25;
            loop;
        Death:
            TNT1 A 25;
            loop;
    }

    override int DamageMobj(Actor inflictor, Actor source, int damage, Name mod, int flags, double angle)
    {
        if (damage > 50){
            String altTextureStr = connectedLine.GetUDMFString("user_b3d_alt_texture_name");
            TextureID altTexture = TexMan.CheckForTexture(altTextureStr);
            connectedLine.sidedef[Line.front].SetTexture(Side.mid, altTexture);
            return super.DamageMobj(inflictor, source, damage, mod, flags, angle);
        }
        return 0;
    }
}


class GlassBreakHandler : EventHandler
{
    Helpers_t helpers;

    void attachGlassBreakerActor(Line line_, double x, double y)
    {
        Vector3 pos;
        pos.x = x;
        pos.y = y;
        pos.z = 48;
        GlassBreakerActor_t spawned = GlassBreakerActor_t(Actor.Spawn('GlassBreakerActor_t', pos));
        spawned.connectedLine = line_;
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

