
class BaseBarrel : Actor
{
    Default
    {
        Health 5;
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
        Death:
            #### A 15;
            TNT1 A 0 SpawnExplosion();
            stop;
    }

    override bool CanCollideWith(Actor other, bool passive)
    {
        return true;
    }

    void SpawnExplosion()
    {
        Explosion_t explosion = Explosion_t(Spawn('Explosion_t', pos));
    }

}

