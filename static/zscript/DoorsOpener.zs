#include "zscript/DoorsOpenerHelper.zs"

class DoorSide_t
{
    Vector2 sideA;
    Vector2 sideB;
    Vector2 start;
    bool isOpened;
    Vector2 target;
    double speed;
    int timeOpened;
    int poNum;
    const WAIT_TIME = 35;

    void print()
    {
        Console.printf("start=(%f, %f), isOpened=%d, target=(%f, %f), speed=%f, timeOpened=%d, poNum=%d",
            start.x, start.y, isOpened, target.x, target.y, speed, timeOpened, poNum);
    }
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
            double speed = Level.lines[i].GetUDMFFloat("user_b3d_door_speed");
            if (speed != 0.0)
            {
                DoorSide_t side = new("DoorSide_t");
                side.sideA = Level.lines[i].v1.p;
                side.sideB = Level.lines[i].v2.p;
                side.poNum = Level.lines[i].GetUDMFInt("user_b3d_door_po_num");
                side.start.x = Level.lines[i].GetUDMFFloat("user_b3d_door_po_x");
                side.start.y = Level.lines[i].GetUDMFFloat("user_b3d_door_po_x");
                Vector2 targetPoint = helper.getTargetPoint(side.sideA.x, side.sideA.y,
                        side.sideB.x, side.sideB.y, side.start.x, side.start.y);
                side.target = targetPoint;
                side.speed = speed;
                doorSides.push(side);
                doorSidesLastIdx += 1;
                side.print();
            }
        }
    }

    void checkDoorsForOpen()
    {
        for (int i = 0; i < doorSides.size(); i++)
        {
            // if (helper.isPlayerCloseEnough(player.pos.x, player.pos.y,
            //     doorSides[i].A, doorSides[i].A,
            //     doorSides[i].B, doorSides[i].B
            // ))
            // {
            //     doorSides[i].isOpened = true;
            //     doorSides[i].timeOpened = Level.time;
            //     Line poStartLine = Level.lines[doorSides[i].poStartLine];
            //     Polyobj_OR_MoveTo(poStartLine.args[0], doorSides[i].speed, doorSides[i].target.x, doorSides[i].target.y);
            // }
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
