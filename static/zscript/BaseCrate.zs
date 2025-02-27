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
            D000 A 25;
            D000 B 25;
            loop;
    }
}

