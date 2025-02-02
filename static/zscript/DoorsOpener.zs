#include "zscript/DoorsOpenerHelper.zs"

class Door_t
{
    Vector2 start;
    bool isOpened;
    Vector2 target;
    double speed;
    int timeOpened;
    int timeEngaged;
    int poNum;
    const WAIT_TIME = 35;
    void print()
    {
        Console.printf("start=(%f, %f), isOpened=%d, target=(%f, %f), speed=%f, timeOpened=%d, poNum=%d",
            start.x, start.y, isOpened, target.x, target.y, speed, timeOpened, poNum);
    }
}

class DoorSide_t
{
    Vector2 sideVA;
    Vector2 sideVB;
    Door_t door;
}

class DoorsOpener : Thinker
{
    const OPEN_ENGAGED_DELAY = 10;
    Array<DoorSide_t> doorSides;
    Map<Int, Door_t> doorsMap;
    int doorSidesLastIdx;
    PlayerPawn player;
    DoorsOpenerHelper helper;

    void initDoors()
    {
        int totalLines = Level.lines.size();
        for (int i = 0; i < totalLines; i++)
        {
            double speed = Level.lines[i].GetUDMFFloat("user_b3d_door_speed");
            if (speed != 0.0)
            {
                DoorSide_t side = new("DoorSide_t");
                if (Level.lines[i].GetUDMFInt("user_b3d_door_back_side") != 0){
                    side.sideVA = Level.lines[i].v1.p;
                    side.sideVB = Level.lines[i].v2.p;
                } else {
                    side.sideVA = Level.lines[i].v2.p;
                    side.sideVB = Level.lines[i].v1.p;
                }

                int poNum = Level.lines[i].GetUDMFInt("user_b3d_door_po_num");

                if (doorsMap.CheckKey(poNum))
                {
                    side.door = doorsMap.get(poNum);
                }
                else
                {
                    side.door = new("Door_t");
                    side.door.poNum = poNum;
                    side.door.start.x = Level.lines[i].GetUDMFFloat("user_b3d_door_po_x");
                    side.door.start.y = Level.lines[i].GetUDMFFloat("user_b3d_door_po_y");
                    Vector2 targetPoint = helper.getTargetPoint(side.sideVA.x, side.sideVA.y,
                            side.sideVB.x, side.sideVB.y, side.door.start.x, side.door.start.y);
                    side.door.target = targetPoint;
                    side.door.speed = speed;
                    doorsMap.Insert(poNum, side.door);
                }
                doorSides.push(side);
                side.door.print();
            }
        }
    }

    void checkDoorsForOpen()
    {
        for (int i = 0; i < doorSides.size(); i++)
        {
            if (helper.isPlayerCloseEnough(player.pos.x, player.pos.y,
                doorSides[i].sideVA.x, doorSides[i].sideVA.y,
                doorSides[i].sideVB.x, doorSides[i].sideVB.y
            ))
            {
                DoorSide_t side = doorSides[i];
                side.door.timeOpened = Level.time;
                if (!side.door.isOpened && (Level.time - side.door.timeEngaged) > OPEN_ENGAGED_DELAY) {
                    side.door.timeEngaged = Level.time;
                    side.door.print();
                    Polyobj_OR_MoveTo(side.door.poNum, side.door.speed, side.door.target.x, side.door.target.y);
                    side.door.isOpened = true;
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
        opener.initDoors();
        openers.push(opener);
	}
}
