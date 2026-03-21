
class Explosion_t : Actor
{
    Helpers_t helpers;

    Default
    {
        Height 72;
        Radius 37;
        Damage 100;
        Scale 1.2;
        +FORCEXYBILLBOARD;
        +NOGRAVITY;
    }
    States
    {
        Spawn:
            EXPL A 0 NoDelay A_Explode;
            EXPL ABCDE 5 Bright;
            stop;
    }
    override void BeginPlay()
    {
        Vector2 newPos2D;
        newPos2D.x = pos.x;
        newPos2D.y = pos.y;
        newPos2D = helpers.getUnstuckPos(newPos2D, Radius, Level);
        Vector3 newPos;
        newPos.x = newPos2D.x;
        newPos.y = newPos2D.y;
        newPos.z = pos.z - 72;
        if (newPos.z < 0) {
            newPos.z = 0;
        }
        SetXYZ(newPos);
        Super.BeginPlay();
    }
}


class BazookaProjectile : Actor
{
    Default
    {
        Projectile;
        Height 4;
        Radius 2;
        Damage 0;
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
        Explosion_t explosion = Explosion_t(Spawn('Explosion_t', pos));
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

