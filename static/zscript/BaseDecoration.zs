class BaseFloorDecoration : Actor
{
    Default
    {    }
    States
    {
        SpawnBase:
            #### A 25;
            Loop;
    }
}


class BaseCeilingDecoration : Actor
{
    Default
    {
        +NOGRAVITY;
        +SPAWNCEILING;
    }
    States
    {
        SpawnBase:
            #### A 25;
            loop;
    }
}
