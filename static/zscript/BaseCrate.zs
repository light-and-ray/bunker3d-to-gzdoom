class CrateCrate : Actor
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
        Spawn:
            M000 A 25;
            loop;
    }
}

