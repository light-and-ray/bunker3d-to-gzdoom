class CrateCrate : Actor
{
    Default
    {
        Height 48;
        Radius 0;
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

