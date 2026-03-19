
class BaseBarrel : Actor
{
    Default
    {
        Health 100;
        Height 48;
        Radius 27.817490;
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
    }

    override bool CanCollideWith(Actor other, bool passive)
    {
        return true;
    }

    // override int DamageMobj(Actor inflictor, Actor source, int damage, Name mod, int flags, double angle)
    // {
    //     if (!isBroken){
    //         doBrake();
    //     }
    //     return 0;
    // }

}

