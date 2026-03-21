
class BaseDecoration : Actor
{
    Default
    {    }
    States
    {
        SpawnBase:
            #### A 25;
            loop;
    }
}


class BaseDrippingDecoration : BaseDecoration
{
    Default
    {    }
    States
    {
        SpawnBase:
            #### A 3;
            #### B 3;
            #### C 3;
            loop;
    }
}

class BaseSmallRadiusDecoration : BaseDecoration
{
    override void PostBeginPlay()
    {
        self.A_SetSize(self.Radius/3);
        super.PostBeginPlay();
    }
}

class BaseXYBillboardDecoration : BaseDecoration
{
    Default
    {
        +FORCEXYBILLBOARD;
    }
}

class BaseCurrentDischarge : BaseFloorLamp
{
    Default
    {
        Health 50;
    }
    States
    {
        SpawnBase:
            #### AB 4 onLightOn();
            #### C 10 onLightOff();
            #### AB 4 onLightOn();
            #### C 30 onLightOff();
            loop;
    }
    override bool CanCollideWith(Actor other, bool passive)
    {
        if (self.health > 0) {
            other.DamageMobj(self, self, 1.5, 'Normal');
        }
        return super.CanCollideWith(other, passive);
    }
}

class BaseCurrentDischargeCutScene : BaseCurrentDischarge
{
    Default
    {    }
    States
    {
        SpawnBase:
            #### AC 2 onLightOn();
            #### B 2 onLightOff();
            loop;
        Death:
            #### B 2 onLightOff();
        XDeath:
            goto Death;
    }
}
