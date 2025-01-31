#include "./DoorsOpenerHelp.zs"

struct DoorSide_t
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
    PlayerPawn player;

    void initDoorSides()
    {
        int totalLines = Level.lines.size();
        for (int i = 0; i < totalLines; i++)
        {
            double speed = Level.lines[i].GetUDMFFloat("b3dDoorSpeed");
            if (speed != 0.0)
            {
                doorSides.push(DoorSide_t(
                    Level.lines[i].v1.x, Level.lines[i].v1.y,
                    Level.lines[i].v2.x, Level.lines[i].v2.y,
                    false,
                    -1.0,
                    -1.0, // <--- line 36
                    Level.lines[i].GetUDMFInt("b3dDoorPOStartLine"),
                    speed,
                    0
                ));
            }
        }
    }

    void checkDoorsForOpen()
    {
        for (int i = 0; i < doorSides.size(); i++)
        {
            if (isPlayerCloseEnough(player.pos.x, player.pos.y,
                doorSides[i].xA, doorSides[i].yA,
                doorSides[i].xB, doorSides[i].yB,
            ))
            {
                doorSides[i].isOpened = true;
                doorSides[i].timeOpened = Timer();
                Line poStartLine = Level.lines[doorSides[i].poStartLine];
                Point_t targetPoint = getTargetPoint(
                    poStartLine.v1.x, poStartLine.v1.y,
                    poStartLine.v2.x, poStartLine.v2.y
                );
                doorSides[i].targetX = targetPoint.x;
                doorSides[i].targetY = targetPoint.y;
                Polyobj_OR_MoveTo(poStartLine.arg0, doorSides[i].speed, doorSides[i].targetX, doorSides[i].targetY);
            }
        }
    }
}
