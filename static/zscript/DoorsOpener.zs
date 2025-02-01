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
                if (Level.lines[i].GetUDMFInt("user_b3d_door_back_side") != 0){
                    side.sideA = Level.lines[i].v1.p;
                    side.sideB = Level.lines[i].v2.p;
                } else {
                    side.sideA = Level.lines[i].v2.p;
                    side.sideB = Level.lines[i].v1.p;
                }
                side.poNum = Level.lines[i].GetUDMFInt("user_b3d_door_po_num");
                side.start.x = Level.lines[i].GetUDMFFloat("user_b3d_door_po_x");
                side.start.y = Level.lines[i].GetUDMFFloat("user_b3d_door_po_y");
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
            if (helper.isPlayerCloseEnough(player.pos.x, player.pos.y,
                doorSides[i].sideA.x, doorSides[i].sideA.y,
                doorSides[i].sideB.x, doorSides[i].sideB.y
            ))
            {
                DoorSide_t side = doorSides[i];
                side.timeOpened = Level.time;
                if (!side.isOpened) {
                    side.print();
                    Polyobj_OR_MoveTo(side.poNum, side.speed, side.target.x, side.target.y);
                    side.isOpened = true;
                }
                break;
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
