class BaseNPC : Actor
{
    double deathScale;

    Default
    {
        Health 5;
        GibHealth 30;
        Scale 1.3;
        +SOLID;
        +SHOOTABLE;
        +DONTTHRUST;
    }
    States
    {
        XDeath:
            GIB1 A 25 onXDeath();
            loop;
    }

    void onXDeath()
    {
        bSOLID = false;
        bSHOOTABLE = false;
        Vector2 newScale;
        newScale.x = 1.0;
        newScale.y = 1.0;
        Scale = newScale;
    }

    virtual void onDeathScale()
    {
        Vector2 newScale;
        newScale.x = deathScale;
        newScale.y = deathScale;
        Scale = newScale;
    }
}


class BaseHandsUpFriendlyNPC : BaseNPC
{
    const SEE_DISTANCE = 125;
    States
    {
        SpawnBase:
            #### A 1 A_LookEx(0, 0, SEE_DISTANCE, SEE_DISTANCE, 360);
            loop;
        See:
            #### B 25;
            loop;
        Death:
            #### C 6 {bSOLID = false; bSHOOTABLE = false; }
            #### D 0 onDeathScale();
            goto DeathLoop;
        DeathLoop:
            #### D 25;
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


class BaseMartyrNPC : BaseNPC
{
    States
    {
        SpawnBase:
            #### AB 6;
            loop;
        Death:
            #### C 6 {bSOLID = false; bSHOOTABLE = false; }
            goto DeathLoop;
        DeathLoop:
            #### D 25;
            loop;
    }
}


class BaseFlamethrowerGuyNPC : BaseNPC
{
    Default
    {
        Health 50;
    }

    States
    {
        SpawnBase:
            #### A 25;
            loop;
        Death:
            GIB2 A 0 onDeath();
            goto DeathLoop;
        DeathLoop:
            GIB2 A 25;
            loop;
        XDeath:
            goto Death;
    }

    void onDeath()
    {
        Vector2 newScale;
        newScale.x = 1.0;
        newScale.y = 1.0;
        Scale = newScale;
        bSOLID = false;
        bSHOOTABLE = false;
        Spawn('Explosion_t', self.pos);
    }
}
