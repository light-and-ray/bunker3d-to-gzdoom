class BaseFloorDecoration : Actor
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


class BaseCeilingDecoration : BaseFloorDecoration
{
    Default
    {
        +NOGRAVITY;
        +SPAWNCEILING;
    }
}
