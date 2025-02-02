#include "zscript/DoorsOpenerHelper.zs"

class Door_t
{
    Vector2 start;
    bool isOpened;
    Vector2 target;
    double speed;
    int timeEngaged;
    int timeOpened;
    int poNum;
    const WAIT_TIME = 35;
    void print()
    {
        Console.printf("start=(%f, %f), isOpened=%d, target=(%f, %f), speed=%f, timeEngaged=%d, timeOpened=%d, poNum=%d",
            start.x, start.y, isOpened, target.x, target.y, speed, timeEngaged, timeOpened, poNum);
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
    const ENGAGED_DELAY = 10;
    const CLOSE_WAIT_TO_OPEN_FACTOR = 700;
    Array<DoorSide_t> doorSides;
    Array<Door_t> doors;
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

                if (doorsMap.checkKey(poNum))
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
                    doorsMap.insert(poNum, side.door);
                    doors.push(side.door);
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
                if (!side.door.isOpened && (Level.time - side.door.timeEngaged) > ENGAGED_DELAY) {
                    side.door.timeEngaged = Level.time;
                    side.door.print();
                    Polyobj_Stop(side.door.poNum);
                    Polyobj_MoveTo(side.door.poNum, side.door.speed, side.door.target.x, side.door.target.y);
                    side.door.isOpened = true;
                }
            }
        }
    }

    void checkDoorsForClose()
    {
        for (int i = 0; i < doors.size(); i++)
        {
            Door_t door = doors[i];
            // if (door.poNum == 4)
            // {
            //     Console.printf("%f - %f", (Level.time - door.timeOpened), door.speed * CLOSE_WAIT_TO_OPEN_FACTOR);
            //     door.print();
            // }
            if (door.isOpened && (Level.time - door.timeEngaged) > CLOSE_WAIT_TO_OPEN_FACTOR / door.speed)
            {
                if ((Level.time - door.timeOpened) > ENGAGED_DELAY)
                {
                    door.timeEngaged = Level.time;
                    Polyobj_Stop(door.poNum);
                    Polyobj_MoveTo(door.poNum, door.speed, door.start.x, door.start.y);
                    door.isOpened = false;
                }
            }
        }
    }

    override void Tick()
    {
        super.Tick();
        checkDoorsForOpen();
        checkDoorsForClose();
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
