class BaseFoe : Actor
{
    Default
    {
        Scale 1.2;
    }
    States
    {
        SpawnBase:
            #### A 0 A_JumpIf(args[0] <= 0, "Standing");
            #### A 0 A_JumpIf(args[0] > 0, "Walking");
        Standing:
            #### C 25;
            loop;
        Walking:
            #### A 14;
            #### B 14;
            loop;
    }
}
