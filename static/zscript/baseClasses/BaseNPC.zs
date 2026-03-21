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
        bFORCEXYBILLBOARD = true;
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
    const SEE_DISTANCE = 92;
    States
    {
        SpawnBase:
            #### A 25 A_LookEx(0, 0, SEE_DISTANCE, SEE_DISTANCE, 360);
            loop;
        See:
            #### B 25;
            loop;
        Death:
            #### C 0 onDeathScale();
            #### C 6 {bSOLID = false; bSHOOTABLE = false; }
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
