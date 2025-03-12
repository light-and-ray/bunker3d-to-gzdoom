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
    int poMirrorNum;
    void print()
    {
        Console.printf("start=(%f, %f), isOpened=%d, target=(%f, %f), speed=%f, timeEngaged=%d, timeOpened=%d, poNum=%d",
            start.x, start.y, isOpened, target.x, target.y, speed, timeEngaged, timeOpened, poNum);
    }
    const IMPRECISE_THRESHOLD = 200;
    bool isCloseImprecise(int playerX, int playerY)
    {
        return (playerX > start.x - IMPRECISE_THRESHOLD && playerX < start.x + IMPRECISE_THRESHOLD
          && playerY > start.y - IMPRECISE_THRESHOLD && playerY < start.y + IMPRECISE_THRESHOLD);
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
    const CLOSE_DELAY = 26;
    const CLOSE_WAIT_TO_OPEN_FACTOR = 700;
    Array<DoorSide_t> doorSides;
    Array<Door_t> doors;
    Map<Int, Door_t> doorsMap;
    PlayerPawn player;
    DoorsOpenerHelper helper;
    Actor freezeChecker;

    void initCopy(DoorsOpener other)
    {
        doorSides = other.doorSides;
        doors = other.doors;
        doorsMap = other.doorsMap;
        freezeChecker = other.freezeChecker;
    }

    void initDoors()
    {
        Vector3 freezeCheckerPos;
        freezeChecker = Actor.Spawn("FreezeChecker", freezeCheckerPos);

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
                    side.door.poMirrorNum = Level.lines[i].GetUDMFInt("user_b3d_door_po_mirror_num");
                    Vector2 targetPoint = helper.getTargetPoint(side.sideVA.x, side.sideVA.y,
                            side.sideVB.x, side.sideVB.y, side.door.start.x, side.door.start.y);
                    side.door.target = targetPoint;
                    side.door.speed = speed;
                    doorsMap.insert(poNum, side.door);
                    doors.push(side.door);
                }
                doorSides.push(side);
            }
        }
    }


    void doOpenDoor(Door_t door)
    {
        if ((Level.time - door.timeEngaged) > CLOSE_WAIT_TO_OPEN_FACTOR / door.speed) { // is fully closed
            door.timeEngaged = Level.time;
        } else {
            door.timeEngaged = Level.time - (CLOSE_WAIT_TO_OPEN_FACTOR / door.speed) + (Level.time - door.timeEngaged);
        }
        Polyobj_Stop(door.poNum);
        Polyobj_MoveTo(door.poNum, door.speed, door.target.x, door.target.y);
        door.isOpened = true;
    }

    void checkDoorsForOpen()
    {
        for (int i = 0; i < doorSides.size(); i++)
        {
            DoorSide_t side = doorSides[i];
            if (side.door.isCloseImprecise(player.pos.x, player.pos.y) &&
                helper.isPlayerCloseEnough(player.pos.x, player.pos.y,
                side.sideVA.x, side.sideVA.y,
                side.sideVB.x, side.sideVB.y
            ))
            {
                side.door.timeOpened = Level.time;
                if (side.door.poMirrorNum != 0)
                {
                    Door_t mirrorDoor = doorsMap.get(side.door.poMirrorNum);
                    mirrorDoor.timeOpened = Level.time;
                }

                if (!side.door.isOpened) {
                    doOpenDoor(side.door);
                    if (side.door.poMirrorNum != 0)
                    {
                        doOpenDoor(doorsMap.get(side.door.poMirrorNum));
                    }
                }
            }
        }
    }


    void doCloseDoor(Door_t door)
    {
        door.timeEngaged = Level.time;
        Polyobj_Stop(door.poNum);
        Polyobj_MoveTo(door.poNum, door.speed, door.start.x, door.start.y);
        door.isOpened = false;
    }

    void checkDoorsForClose()
    {
        for (int i = 0; i < doors.size(); i++)
        {
            Door_t door = doors[i];
            if (door.isOpened && (Level.time - door.timeEngaged) > CLOSE_WAIT_TO_OPEN_FACTOR / door.speed + CLOSE_DELAY)
            {
                if ((Level.time - door.timeOpened) > CLOSE_DELAY)
                {
                    doCloseDoor(door);
                    if (door.poMirrorNum != 0)
                    {
                        doCloseDoor(doorsMap.get(door.poMirrorNum));
                    }
                }
            }
        }
    }

    override void Tick()
    {
        super.Tick();
        if (freezeChecker.isFrozen() && !(player.player.cmd.buttons & BT_USE)) {
            return;
        }
        checkDoorsForOpen();
        checkDoorsForClose();
    }
}


class DoorsOpenerHandler : EventHandler
{
    Array<DoorsOpener> openers;
    bool firstInitialized;
    override void PlayerEntered(PlayerEvent e)
    {
        PlayerInfo player = players[e.PlayerNumber];
        if (!player) return;
        DoorsOpener opener = new("DoorsOpener");;
        opener.player = player.mo;
        if (!firstInitialized) {
            opener.initDoors();
            firstInitialized = true;
        } else {
            opener.initCopy(openers[0]);
        }
        openers.push(opener);
    }
}
