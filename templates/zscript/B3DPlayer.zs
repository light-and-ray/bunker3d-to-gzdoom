
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
    // Console.printf("%f", autoCrouchData.HEIGHT_THRESHOLD);
    let player = self.player;
    UserCmd cmd = player.cmd;
    if (cursector.CenterCeiling() - pos.z <= autoCrouchData.HEIGHT_THRESHOLD)
    {
        if (!autoCrouchData.wasCrouched) {
            Console.printf('do crouch');
            autoCrouchData.wasCrouched = true;
        }
    } else {
        if (autoCrouchData.wasCrouched) {
            Console.printf('do uncrouch');
            player.crouching = 0;
            autoCrouchData.wasCrouched = false;
        }
    }
}

}
