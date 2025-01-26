
struct AutoCrouchData
{
    bool wasCrouched;
    const HEIGHT_THRESHOLD = 48.;
}


class B3DPlayer : DoomPlayer
{
    AutoCrouchData autoCrouchData;
    const MAXBOB = 8.;

    Default
    {
        Height 48;
        // Speed 0.7;
        Speed 1.2;
        Radius 24;
        Player.ViewHeight 48;
        Player.AttackZOffset 24;
        Player.ViewBob 0.5;
    }

	override void Tick()
	{
		super.Tick();
        performAutoCrouch();

	}

    void performAutoCrouch()
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

    override void CheckCrouch(bool totallyfrozen)
    {
        if (autoCrouchData.wasCrouched) {
            player.cmd.buttons |= BT_CROUCH;
        }
        super.CheckCrouch(totallyfrozen);
    }

}
