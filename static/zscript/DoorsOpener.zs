#include "./DoorsOpenerHelper.zs"

class DoorSide_t
{
    double xA;
    double yA;
    double xB;
    double yB;
    bool isOpened;
    double targetX;
    double targetY;
    int poStartLine;
    double speed;
    int timeOpened;
    const WAIT_TIME = 35;
}

class DoorsOpener : Thinker
{
    Array<DoorSide_t> doorSides;
    int doorSidesLastIdx;
    PlayerPawn player;
    DoorsOpenerHelper helper;

    void initDoorSides()
    {
        int totalLines = Level.lines.size();
        for (int i = 0; i < totalLines; i++)
        {
            double speed = Level.lines[i].GetUDMFFloat("b3dDoorSpeed");
            if (speed != 0.0)
            {
                DoorSide_t side = new("DoorSide_t");
                side.xA = Level.lines[i].v1.p.x;
                side.yA = Level.lines[i].v1.p.y;
                side.xB = Level.lines[i].v2.p.x;
                side.yB = Level.lines[i].v2.p.y;
                side.poStartLine = Level.lines[i].GetUDMFInt("b3dDoorPOStartLine");
                side.speed = speed;
                doorSides.push(side);
                doorSidesLastIdx += 1;
            }
        }
    }

    void checkDoorsForOpen()
    {
        for (int i = 0; i < doorSides.size(); i++)
        {
            if (helper.isPlayerCloseEnough(player.pos.x, player.pos.y,
                doorSides[i].xA, doorSides[i].yA,
                doorSides[i].xB, doorSides[i].yB
            ))
            {
                doorSides[i].isOpened = true;
                doorSides[i].timeOpened = Level.time;
                Line poStartLine = Level.lines[doorSides[i].poStartLine];
                Vector2 targetPoint = helper.getTargetPoint(
                    poStartLine.v1.p.x, poStartLine.v1.p.y,
                    poStartLine.v2.p.x, poStartLine.v2.p.y
                );
                doorSides[i].targetX = targetPoint.x;
                doorSides[i].targetY = targetPoint.y;
                Polyobj_OR_MoveTo(poStartLine.args[0], doorSides[i].speed, doorSides[i].targetX, doorSides[i].targetY);
            }
        }
    }

    override void Tick()
    {
        super.Tick();
        checkDoorsForOpen();
    }
}


class DoorsOpenerHandler : EventHandler
{
    Array<DoorsOpener> openers;
	override void PlayerEntered(PlayerEvent e)
	{
		PlayerInfo player = players[e.PlayerNumber];
		if (!player) return;
        DoorsOpener opener = new("DoorsOpener");;
        opener.player = player.mo;
        opener.initDoorSides();
        openers.push(opener);
	}
}
