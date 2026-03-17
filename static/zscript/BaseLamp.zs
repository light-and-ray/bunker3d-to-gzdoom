#include "zscript/Helpers.zs"

class BaseFloorLamp : Actor
{
    Array<String> wallTexturesStrOff;
    Array<String> wallTexturesStrOn;
    Array<TextureID> wallTexturesOff;
    Array<TextureID> wallTexturesOn;
    Array<int> lineIndexesToChange;
    Array<int> textureIndexesForLines;
    Helpers_t helpers;

    Default
    {
        Health 1;
        GibHealth 11;
        +SHOOTABLE;
        +DONTTHRUST;
        +NOBLOOD;
        +NOBLOODDECALS;
    }
    States
    {
        SpawnBase:
            #### A 0 A_JumpIf(args[0] == 127, "LightON");
            #### A 0 A_JumpIf(args[0] == -2, "LightOFF");
            #### A 0 A_JumpIf(args[0] == -1, "LightFlickOn");
        LightON:
            #### A 5;
            loop;
        LightOFF:
            #### B 0 onLightOff();
            #### B 5;
            loop;
        LightFlickOn:
            #### A 0 onLightOn();
            #### A 3 A_JumpIf(random(0, 2) == 0, "LightFlickOff");
            loop;
        LightFlickOff:
            #### B 0 onLightOff();
            #### B 3 A_JumpIf(random(0, 2) == 0, "LightFlickOn");
            loop;
        DeathLoop:
            #### C 5;
            loop;
        Death:
            #### B 0 onLightOff();
            goto DeathLoop;
        XDeath:
            #### C 0 A_Jump(145, "Death");
            #### C 5 { bDONTFALL = false; bNOGRAVITY = false; }
            goto Death;
    }

    override void PostBeginPlay()
    {
        wallTexturesStrOff.push("TEXT_268");
        wallTexturesStrOff.push("TEXT_268");
        wallTexturesStrOn.push("TEXT_269");
        wallTexturesStrOn.push("MDFC_72");
        initWallFlickering();
        super.PostBeginPlay();
    }

    void initWallFlickering()
    {
        if (wallTexturesStrOff.size() != wallTexturesStrOn.size()) {
            Console.printf("wallTexturesStrOff.size() != wallTexturesStrOn.size()");
            return;
        }
        for (int i = 0; i < wallTexturesStrOff.size(); i++) {
            TextureID texture = TexMan.CheckForTexture(wallTexturesStrOff[i]);
            if (!texture.IsValid()) {
                Console.printf("invalid off texture: %s", wallTexturesStrOff[i]);
            }
            wallTexturesOff.push(texture);
        }
        for (int i = 0; i < wallTexturesStrOn.size(); i++) {
            TextureID texture = TexMan.CheckForTexture(wallTexturesStrOn[i]);
            if (!texture.IsValid()) {
                Console.printf("invalid off texture: %s", wallTexturesStrOn[i]);
            }
            wallTexturesOn.push(texture);
        }

        double THRESHOLD = 100.0;
        int totalLines = Level.lines.size();
        for (int lineIndex = 0; lineIndex < totalLines; lineIndex++)
        {
            double distance = helpers.distanceToSegment(
                Pos.x, Pos.y,
                Level.lines[lineIndex].v1.p.x, Level.lines[lineIndex].v1.p.y,
                Level.lines[lineIndex].v2.p.x, Level.lines[lineIndex].v2.p.y
            );
            TextureID texture = getLineTexture(lineIndex);
            String textureStr = TexMan.GetName(texture);
            int textureIndex = wallTexturesStrOn.find(textureStr);
            if (distance < THRESHOLD && textureIndex != wallTexturesStrOn.size())
            {
                lineIndexesToChange.push(lineIndex);
                textureIndexesForLines.push(textureIndex);
            }
        }
    }


    TextureID getLineTexture(int lineIndex)
    {
        return Level.lines[lineIndex].sidedef[Line.front].GetTexture(Side.mid);
    }

    void setLineTexture(int lineIndex, TextureID texture)
    {
        Level.lines[lineIndex].sidedef[Line.front].SetTexture(Side.mid, texture);
    }


    void onLightOff()
    {
        for (int i = 0; i < lineIndexesToChange.size(); i++)
        {
            int lineIndex = lineIndexesToChange[i];
            TextureID texture = getLineTexture(lineIndex);
            int textureIndex = textureIndexesForLines[i];
            if (textureIndex != wallTexturesOn.size())
            {
                setLineTexture(lineIndex, wallTexturesOff[textureIndex]);
            }
        }
    }

    void onLightOn()
    {
        for (int i = 0; i < lineIndexesToChange.size(); i++)
        {
            int lineIndex = lineIndexesToChange[i];
            TextureID texture = getLineTexture(lineIndex);
            int textureIndex = textureIndexesForLines[i];
            if (textureIndex != wallTexturesOff.size())
            {
                setLineTexture(lineIndex, wallTexturesOn[textureIndex]);
            }
        }
    }
}

class BaseCeilingLamp : BaseFloorLamp
{
    Default
    {
        +NOGRAVITY;
        +DONTFALL;
        +SPAWNCEILING;
    }
}
