class BaseCrate : Actor
{
    Default
    {
        Height 48;
        Radius 24;
        +SOLID;
        +SHOOTABLE;
        +DONTTHRUST;
        +NOBLOOD;
        +NOBLOODDECALS;
    }
    States
    {
        SpawnBase:
            #### A 25;
            // #### C 25;
            loop;
        Broken:
            #### BC 6;
            #### D -1;
            loop;
    }

    bool isBroken;

    override void PostBeginPlay()
    {
        Super.PostBeginPlay();
        if (angle % 90 != 0) {
            double factor = 2 - abs(angle % 90 - 45) / 45;
            A_SetSize(Radius/factor+4);
        }
    }

    override bool CanCollideWith(Actor other, bool passive)
    {
        if (isBroken) {
            return false;
        }
        if (level.time % 5 != 0) {
            return true;
        }
        doBrake();
        return false;
    }

    override int DamageMobj(Actor inflictor, Actor source, int damage, Name mod, int flags, double angle)
    {
        if (!isBroken){
            doBrake();
        }
        return 0;
    }

    void doBrake()
    {
        SetState(ResolveState("Broken"));
        isBroken = true;
    }

}

