class BaseLamp : Actor
{
    Default
    {
        Health 1;
        GibHealth 11;
        +NOGRAVITY;
        +DONTFALL;
        +SHOOTABLE;
        +DONTTHRUST;
        +NOBLOOD;
        +NOBLOODDECALS;
        +SPAWNCEILING;
    }
    States
    {
        SpawnBase:
            #### A 0 A_JumpIf(args[0] == 127, "LightON");
            #### A 0 A_JumpIf(args[0] == -2, "LightOFF");
            #### A 0 A_JumpIf(args[0] == -1, "LightFlickOn");
        LightON:
            #### A 5;
            loop;
        LightOFF:
            #### B 5;
            loop;
        LightFlickOn:
            #### A 3 A_JumpIf(random(0, 2) == 0, "LightFlickOff");
            loop;
        LightFlickOff:
            #### B 3 A_JumpIf(random(0, 2) == 0, "LightFlickOn");
            loop;
        Death:
            #### C 5;
            loop;
        XDeath:
            #### C 0 A_Jump(145, "Death");
            #### C 5  { bDONTFALL = false; bNOGRAVITY = false; }
            goto Death;
    }
}
