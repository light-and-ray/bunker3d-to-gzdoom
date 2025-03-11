class B3DClip : Ammo replaces Clip
{
    Default
    {
        Inventory.PickupMessage "$GOTCLIP";
        Inventory.Amount 10;
        Inventory.MaxAmount 1000;
        Ammo.BackpackAmount 10;
        Ammo.BackpackMaxAmount 2000;
        Inventory.Icon "CLIPA0";
        Tag "$AMMO_CLIP";
    }
    States
    {
    Spawn:
        CLIP A -1;
        Stop;
    }
}


class B3DBulletPuff : Actor
{
	Default
	{
		+NOBLOCKMAP;
		+NOGRAVITY;
		+RANDOMIZE;
	}
	States
	{
	Spawn:
        TNT1 A 4;
        Stop;
	Melee:
		TNT1 A 4;
		Stop;
	}
}


class L3DBulletPuff : Actor
{
    GlobalVars_t globalVars;

    override void PostBeginPlay()
    {
        globalVars = GlobalVars_t(EventHandler.Find("GlobalVars_t"));
        super.PostBeginPlay();
    }

	Default
	{
		+NOBLOCKMAP;
		+NOGRAVITY;
		+RANDOMIZE;
        Scale 1.3;
	}
	States
	{
	Spawn:
        TNT1 A 0 NoDelay A_JumpIf(globalVars.lastPuffFrame == 2, "FrameA");
        TNT1 A 0 A_JumpIf(globalVars.lastPuffFrame == 0, "FrameB");
        TNT1 A 0 A_JumpIf(globalVars.lastPuffFrame == 1, "FrameC");
    FrameA:
        TNT1 A 0 {globalVars.lastPuffFrame = 0;}
        PUFL A 6;
        Stop;
    FrameB:
        TNT1 A 0 {globalVars.lastPuffFrame = 1;}
        PUFL B 6;
        Stop;
    FrameC:
        TNT1 A 0 {globalVars.lastPuffFrame = 2;}
        PUFL C 6;
        Stop;
	Melee:
		TNT1 A 4;
		Stop;
	}
}


class MachineGun : DoomWeapon
{
    Default
    {
        Weapon.SelectionOrder 1300;
        Weapon.AmmoUse 1;
        Weapon.AmmoGive 8;
        Tag "Machine Gun";
        Weapon.AmmoType "B3DClip";
        Inventory.PickupMessage "$GOTSHOTGUN";
        Obituary "$OB_MPSHOTGUN";
        Decal "BulletChip";
        Weapon.WeaponScaleX 1.2;
        Weapon.WeaponScaleY 1.2;
        +WEAPON.NOAUTOAIM;
    }

    GlobalVars_t globalVars;

    override void PostBeginPlay()
    {
        globalVars = GlobalVars_t(EventHandler.Find("GlobalVars_t"));
        super.PostBeginPlay();
    }

    States
    {
        Ready:
            MP40 A 1 A_WeaponReady;
            Loop;
        Deselect:
            MP40 A 1 A_Lower;
            Loop;
        Select:
            MP40 A 1 A_Raise;
            Loop;
        Fire:
            MP40 A 2;
            MP40 B 0 A_StartSound("MP40_fire");
            MP40 B 0 A_FireBullets(2, 1, 1, random(3, 5), invoker.globalVars.puffClass);
            MP40 B 2 A_GunFlash;
            MP40 B 2;
            MP40 A 0 A_ReFire;
            Goto Ready;
        Flash:
            TNT1 A 2 A_Light1;
            Goto LightDone;
        Spawn:
            MP40 A -1;
            Stop;
    }
}

