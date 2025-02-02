class MachineGun : DoomWeapon
{
    Default
    {
        Weapon.SelectionOrder 1300;
        Weapon.AmmoUse 1;
        Weapon.AmmoGive 8;
        Tag "Machine Gun";
        Weapon.AmmoType "Clip";
        +DontGib;
        Inventory.PickupMessage "$GOTSHOTGUN";
        Obituary "$OB_MPSHOTGUN";
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
            MP40 B 0 A_PlaySound("weapons/shotgf", CHAN_WEAPON);
            MP40 B 0 Bright A_FireBullets(2, 1, 1, random (3, 5), "BulletPuff");
            MP40 B 2 A_GunFlash;
            MP40 A 2;
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
