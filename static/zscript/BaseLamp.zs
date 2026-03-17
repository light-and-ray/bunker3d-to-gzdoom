#include "zscript/Helpers.zs"

class LightSpot_t : Actor
{
    bool isOn;
    Default
    {
        +FORCEXYBILLBOARD;
    }
    States
    {
        Spawn:
            goto Off;
        On:
            LSPT A 1 A_JumpIf(!isOn, "Off");
            loop;
        Off:
            TNT1 A 1 A_JumpIf(isOn, "On");
            loop;
    }
}


class _BaseLamp : Actor
{
    Array<int> lineIndexesToChange;
    Array<TextureID> onTextureForLines;
    Array<TextureID> offTextureForLines;
    bool needLightSpot;
    LightSpot_t lightSpot;
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
            #### C 0 onLightOff();
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
        if (needLightSpot) {
            initLightSpot();
        }
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

    void initLightSpot()
    {
        Vector3 spawnPos = Pos;
        spawnPos.z = 0;
        lightSpot = LightSpot_t(Spawn('LightSpot_t', spawnPos));
    }

    TextureID getLineTexture(int lineIndex)
    {
        return Level.lines[lineIndex].sidedef[Line.front].GetTexture(Side.mid);
    }

    void setLineTexture(int lineIndex, TextureID texture)
    {
        Level.lines[lineIndex].sidedef[Line.front].SetTexture(Side.mid, texture);
    }


    virtual void onLightOff()
    {
        for (int i = 0; i < lineIndexesToChange.size(); i++)
        {
            int lineIndex = lineIndexesToChange[i];
            setLineTexture(lineIndex, offTextureForLines[i]);
        }
        if (needLightSpot) {
            lightSpot.isOn = false;
        }
    }

    virtual void onLightOn()
    {
        for (int i = 0; i < lineIndexesToChange.size(); i++)
        {
            int lineIndex = lineIndexesToChange[i];
            setLineTexture(lineIndex, onTextureForLines[i]);
        }
        if (needLightSpot) {
            lightSpot.isOn = true;
        }
    }
}

class BaseFloorLamp : _BaseLamp { }

class BaseCeilingLamp : _BaseLamp
{
    Default
    {
        +NOGRAVITY;
        +DONTFALL;
        +SPAWNCEILING;
    }

}

