class BaseHandsUpFriendlyNPC : Actor
{
    Default
    {
        Scale 1.3;
        +BILLBOARDFACECAMERA;
    }
    States
    {
        SpawnBase:
            #### A 25;
            loop;
    }
}
