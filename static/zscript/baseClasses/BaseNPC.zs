class BaseHandsUpFriendlyNPC : Actor
{
    Default
    {
        Scale 1.3;
        +SOLID;
        +BILLBOARDFACECAMERA;
    }
    States
    {
        SpawnBase:
            #### ABCD 25;
            loop;
    }
}

class BaseMeatFalseNPC : Actor
{
    Default
    {
        +SOLID;
        Scale 1.3;
    }
    States
    {
        SpawnBase:
            #### ABCDE 25;
            loop;
    }
}
