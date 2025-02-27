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
    }

    override void PostBeginPlay()
    {
        Super.PostBeginPlay();
        if (angle % 90 != 0) {
            A_SetSize(Radius/2);
        }
    }

}

