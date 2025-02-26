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
            #### A 0 A_JumpIf(args[0] > 1, "Walking");
        Standing:
            #### C 25 { bSPRITEANGLE = true; }
            loop;
        Walking:
            #### A 14 { bSPRITEANGLE = false; }
            #### B 14;
            loop;
    }
}
