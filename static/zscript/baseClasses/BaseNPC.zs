
class B3DBlodeNone : Actor replaces Blood
{    }

class B3DBlood : Actor
{
    GlobalVars_t globalVars;

    Default
    {
        +NOGRAVITY;
        +DONTTHRUST;
        +FORCEXYBILLBOARD;
    }

    States
    {
        Spawn:
            TNT1 A 0 NoDelay A_JumpIf(random(0, 1) == 1, "Frame1");
            goto Frame2;
        Frame1:
            BLOD A 6;
            TNT1 A 0 releaseGlobalLock();
            stop;
        Frame2:
            BLOD B 6;
            TNT1 A 0 releaseGlobalLock();
            stop;
    }

    override void PostBeginPlay()
    {
        if (getGlobalVars().bloodActive)
        {
            self.destroy();
        } else
        {
            self.vel = (0, 0, 0);
            getGlobalVars().bloodActive = true;
            Super.PostBeginPlay();
        }
    }

    action GlobalVars_t getGlobalVars()
    {
        if(!invoker.globalVars) invoker.globalVars = GlobalVars_t(EventHandler.Find("GlobalVars_t"));
        return invoker.globalVars;
    }

    void releaseGlobalLock()
    {
        self.getGlobalVars().bloodActive = false;
    }
}


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
            #### CD 8 {bSOLID = false; bSHOOTABLE = false; onDeathScale(); }
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
        +NOBLOODDECALS;
    }
    States
    {
        SpawnBase:
            #### A 25;
            loop;
        Death:
            #### CDE 6 {bSOLID = false; bSHOOTABLE = false; }
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
            #### CD 8 {bSOLID = false; bSHOOTABLE = false; }
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
        BloodType "B3DBlood";
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
