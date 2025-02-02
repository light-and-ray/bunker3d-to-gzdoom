
struct AutoCrouchData_t
{
    bool wasCrouched;
    const HEIGHT_THRESHOLD = 48.;
}


class B3DPlayer : DoomPlayer replaces DoomPlayer
{
    const MAXBOB = 6.;
    AutoCrouchData_t autoCrouchData;

    Default
    {
        Height 48;
        Speed 0.7;
        // Speed 1.2;
        Radius 24;
        Player.ViewHeight 48;
        Player.AttackZOffset 24;
        Player.ViewBob 0.5;
        Player.StartItem "Z_NashMove";
        Player.StartItem "MachineGun";
        Player.StartItem "Clip", 1000;
        Player.WeaponSlot 3, "MachineGun";
    }

    // overrides

    override void Tick()
    {
        super.Tick();
        performAutoCrouch_Tick();

    }

    override void CheckCrouch(bool totallyfrozen)
    {
        performAutoCrouch_CheckCrouch();
        super.CheckCrouch(totallyfrozen);
    }


    // own functions

    void performAutoCrouch_Tick()
    {
        if (cursector.CenterCeiling() - pos.z <= autoCrouchData.HEIGHT_THRESHOLD)
        {
            if (!autoCrouchData.wasCrouched) {
                autoCrouchData.wasCrouched = true;
            }
        } else {
            if (autoCrouchData.wasCrouched) {
                player.crouching = 0;
                autoCrouchData.wasCrouched = false;
            }
        }
    }

    void performAutoCrouch_CheckCrouch()
    {
        if (autoCrouchData.wasCrouched) {
            player.cmd.buttons |= BT_CROUCH;
        }
    }

}
