
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
    {    }
    States
    {
        SpawnBase:
            #### AB 4 onLightOn();
            #### C 10 onLightOff();
            #### AB 4 onLightOn();
            #### C 30 onLightOff();
            loop;
    }
}

class BaseCurrentDischargeCutScene : BaseFloorLamp
{
    Default
    {    }
    States
    {
        SpawnBase:
            #### AB 2 onLightOn();
            #### C 2 onLightOff();
            loop;
    }
}
