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
