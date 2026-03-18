#include "zscript/Helpers.zs"

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
        +FORCEXYBILLBOARD;
        +THRUGHOST;
        Scale 1.3;
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


class L3DBulletPuff : B3DBulletPuff
{
    Default
    {    }
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

    action GlobalVars_t getGlobalVars()
    {
        if(!invoker.globalVars) invoker.globalVars = GlobalVars_t(EventHandler.Find("GlobalVars_t"));
        return invoker.globalVars;
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
            MP40 B 0 A_FireBullets(2, 1, 1, random(3, 5), getGlobalVars().puffClass);
            MP40 B 2 A_GunFlash;
            MP40 B 2;
            MP40 A 0 A_ReFire;
            Goto Ready;
        Flash:
            TNT1 A 0;
            Goto LightDone;
        Spawn:
            MP40 A -1;
            Stop;
    }
}


class Explosion_t : Actor
{
    Default
    {
        Height 72;
        Radius 36;
        Damage 100;
        Scale 1.2;
        +FORCEXYBILLBOARD;
        +NOGRAVITY;
    }
    States
    {
        Spawn:
            EXPL ABCDE 5 A_Explode;
            stop;
    }

}


class BazookaProjectile : Actor
{
    Helpers_t helpers;

    Default
    {
        Projectile;
        Height 4;
        Radius 2;
        Damage 5;
        Speed 130;
        +THRUGHOST;
    }
    States
    {
        Spawn:
            TNT1 A 4;
            loop;
        Death:
            TNT1 A 0 SpawnExplosion();
            stop;
    }

    void SpawnExplosion()
    {
        Vector2 newPos2D;
        newPos2D.x = pos.x;
        newPos2D.y = pos.y;
        newPos2D = helpers.getUnstuckPos(newPos2D, 36, Level);
        Vector3 newPos;
        newPos.x = newPos2D.x;
        newPos.y = newPos2D.y;
        newPos.z = pos.z - 72;
        if (newPos.z < 0) {
            newPos.z = 0;
        }
        Explosion_t explosion = Explosion_t(Spawn('Explosion_t', newPos));
    }
}



class Bazooka : DoomWeapon
{
    Default
    {
        Weapon.SelectionOrder 1300;
        Weapon.AmmoUse 1;
        Weapon.AmmoGive 8;
        Tag "Bazooka";
        Weapon.AmmoType "B3DClip";
        // Inventory.PickupMessage "$GOTSHOTGUN";
        Obituary "$OB_MPSHOTGUN";
        // Decal "BulletChip";
        Weapon.WeaponScaleX 1.0;
        Weapon.WeaponScaleY 1.0;
        +WEAPON.NOAUTOAIM;
        +WEAPON.NOAUTOFIRE;
    }

    GlobalVars_t globalVars;

    action GlobalVars_t getGlobalVars()
    {
        if(!invoker.globalVars) invoker.globalVars = GlobalVars_t(EventHandler.Find("GlobalVars_t"));
        return invoker.globalVars;
    }

    States
    {
        Ready:
            BZKA A 1 A_WeaponReady;
            Loop;
        Deselect:
            BZKA A 1 A_Lower;
            Loop;
        Select:
            BZKA A 1 A_Raise;
            Loop;
        Fire:
            BZKA A 2;
            // BZKA B 0 A_StartSound("MP40_fire");
            BZKA B 0 A_FireProjectile('BazookaProjectile');
            BZKA B 0 A_GunFlash;
            BZKA B 0 A_GunFlash;
            BZKA B 4 A_WeaponOffset(50, 0, WOF_ADD);
            BZKA C 4 A_GunFlash;
            BZKA A 0 A_WeaponOffset(-50, 0, WOF_ADD);
            BZKA AAAAAAAAAAAAAAAAAAAAAAAAA 1 A_WeaponOffset(0, 5, WOF_ADD|WOF_INTERPOLATE);
            BZKA AAAAAAAAAAAAAAAAAAAAAAAAA 1 A_WeaponOffset(0, -5, WOF_ADD|WOF_INTERPOLATE);
            Goto Ready;
        Flash:
            BZKA A 0;
            Goto LightDone;
        Spawn:
            BZKA A -1;
            Stop;
    }
}

