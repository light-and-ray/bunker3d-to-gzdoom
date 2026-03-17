#include "zscript/Helpers.zs"

class BaseFloorLamp : Actor
{
    Array<int> lineIndexesToChange;
    Array<TextureID> onTextureForLines;
    Array<TextureID> offTextureForLines;
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
            #### A 0 onLightOn();
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
        initWallFlickering();
        super.PostBeginPlay();
    }

    void initWallFlickering()
    {
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
            String altTextureStr = Level.lines[lineIndex].GetUDMFString("user_b3d_alt_texture_name");
            if (distance < THRESHOLD && altTextureStr)
            {
                TextureID altTexture = TexMan.CheckForTexture(altTextureStr);
                lineIndexesToChange.push(lineIndex);
                onTextureForLines.push(texture);
                offTextureForLines.push(altTexture);
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
            setLineTexture(lineIndex, offTextureForLines[i]);
        }
    }

    void onLightOn()
    {
        for (int i = 0; i < lineIndexesToChange.size(); i++)
        {
            int lineIndex = lineIndexesToChange[i];
            setLineTexture(lineIndex, onTextureForLines[i]);
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
