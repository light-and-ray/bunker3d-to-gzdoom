enum CrateContent
{
    CRATE_NONE = 0,
    CRATE_HEALTH = 1,
    CRATE_AMMO = 2,
    CRATE_BOTH = 3
}

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
            #### A -1;
            loop;
        BrokenNone:
            #### BC 6;
            #### D -1;
            loop;
        BrokenAmmo:
            #### BC 6;
            #### E -1;
            loop;
        BrokenHealth:
            #### BC 6;
            #### F -1;
            loop;
        BrokenBoth:
            #### BC 6;
            #### G -1;
            loop;
    }

    bool isBroken;
    CrateContent content;

    override void PostBeginPlay()
    {
        Super.PostBeginPlay();
        if (angle % 90 != 0) {
            double factor = 2 - abs(angle % 90 - 45) / 45;
            A_SetSize(Radius/factor+4);
        }
        content = args[0];
    }

    override bool CanCollideWith(Actor other, bool passive)
    {
        if (isBroken) {
            return false;
        }
        if (level.time % 5 != 0) {
            return true;
        }
        if (isFrozen()) {
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
        switch(content)
        {
            case CRATE_NONE:
                SetState(ResolveState("BrokenNone"));
                break;
            case CRATE_AMMO:
                SetState(ResolveState("BrokenAmmo"));
                break;
            case CRATE_HEALTH:
                SetState(ResolveState("BrokenHealth"));
                break;
            case CRATE_BOTH:
                SetState(ResolveState("BrokenBoth"));
                break;
            default:
                SetState(ResolveState("BrokenNone"));
                break;
        }

        isBroken = true;
    }

}

