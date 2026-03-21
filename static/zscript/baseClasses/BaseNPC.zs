class BaseNPC : Actor
{
    Default
    {
        Health 5;
        GibHealth 20;
        Scale 1.3;
        +SOLID;
        +SHOOTABLE;
        +DONTTHRUST;
    }
    States
    {
        XDeath:
            GIB1 A 25 {bSOLID = false; bSHOOTABLE = false; }
            loop;
    }
}

class BaseHandsUpFriendlyNPC : BaseNPC
{
    States
    {
        SpawnBase:
            #### ABCD 25;
            loop;
    }
}

class BaseMeatFalseNPC : BaseNPC
{
    Default
    {
        +NOBLOOD;
        +NOBLOODDECALS;
    }
    States
    {
        SpawnBase:
            #### A 25;
            loop;
        Death:
            #### C 0 {bSOLID = false; bSHOOTABLE = false; }
            #### CD 6;
            goto DeathLoop;
        DeathLoop:
            #### E 25;
            loop;
    }
}
