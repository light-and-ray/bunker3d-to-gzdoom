
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


class Base3FramesDecoration : BaseDecoration
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
