from dataclasses import dataclass
from enum import Enum
from typing import Any
from PIL import Image
import copy
from ClassesB3D import MapB3D, CrateB3D, ThingCategory
from algebraFunctions import (resolveSegmentsOverlap, isInside, areOppositelyDirected, fixVertex, segmentAngle,
    calculateOffset, vertexWithOffset, segmentLength, findFourthVertex, vertexWithOffset_checkInside,
)
from ClassesShared import Vertex, HeightType
from drawMap import drawMap
from tools import SCALE_FACTOR
from fixes import BrokenTextureData


@dataclass
class TextureInterim:
    names : list[str]
    offset : float = 0.0
    stretch : float = 1.0
    def trimOffset(self, textures: dict[str, Image.Image]):
        while self.offset >= textures[self.names[0]].width*self.stretch:
            self.offset -= textures[self.names[0]].width*self.stretch
            if len(self.names) > 1:
                self.names = self.names[1:]


@dataclass
class LineInterim:
    v1 : Vertex
    v2 : Vertex
    height : HeightType
    texture : TextureInterim


@dataclass
class DoorInterim:
    lines: list[LineInterim]
    speed: int
    startingSpot: Vertex
    boxLines: list[LineInterim] = None
    nextIsMirror: bool = False


@dataclass
class DecorationInterim:
    pos: Vertex
    spriteIdx: int
    colorIdx: int

class LampSpecial(Enum):
    ON = 127
    OFF = -2
    FLICK = -1

@dataclass
class LampInterim:
    pos: Vertex
    spriteIdx: int
    colorIdx: int
    special: LampSpecial

class NpcSpecial(Enum):
    FOE = -20
    BOSS = -2
    FRIENDLY1 = 26
    FRIENDLY2 = 30
    FINALBOSS = 32

@dataclass
class FoeInterim:
    pos: Vertex
    colorIdx: int
    isBoss: bool
    angle: int
    walkDistance: int

@dataclass
class FriendlyInterim:
    pos: Vertex
    colorIdx: int
    spriteIdx: int
    isSecond: bool

class CrateContent(Enum):
    NONE = 0
    HEALTH = 1
    AMMO = 2
    BOTH = 3

@dataclass
class CrateInterim:
    pos: Vertex
    colorIdx: int
    spriteIdx: int
    content: CrateContent
    textureName: str
    angle: int


class MapInterim:
    def __init__(self, mapB3D: MapB3D, brokenLines: list[int], doorsSpeed: list[int], doorsStartLineIdx: list[int],
            brokenTextures: dict[int, BrokenTextureData], foeAngles: list[int], foeWalkDistances: list[int]):
        self.textures = mapB3D.textures
        self.lines: list[LineInterim] = []
        allCircleLines = []
        for circle in mapB3D.circles:
            allCircleLines.extend(circle)

        for index, line in enumerate(mapB3D.lines):
            texture = TextureInterim(names=line.texturesNames)
            line = LineInterim(v1=copy.copy(line.v1), v2=copy.copy(line.v2), height=line.height, texture=texture)
            if texture.names[0] in self.textures and index not in allCircleLines:
                self._fillStretch(texture, line, index)
            self.lines.append(line)

        self._fixBrokenTextures(brokenTextures)
        self._fillCirclesOffsets(mapB3D.circles)
        self._initDoors(doorsStartLineIdx, doorsSpeed)
        self._removeCratesDoorsAndBrokenLines(mapB3D.crates, doorsStartLineIdx, brokenLines)
        # self._fixVertexes()
        self._cutMultitextureLines()
        self._removeOverlaps()

        self.sprites = mapB3D.sprites
        self.foeSprites = mapB3D.foeSprites

        self.decorations: list[DecorationInterim] = []
        for thing in mapB3D.things:
            if thing.category != ThingCategory.DECORATION: continue
            self.decorations.append(DecorationInterim(pos=thing.pos, spriteIdx=thing.sprite, colorIdx=thing.color))

        self.lamps: list[LampInterim] = []
        for thing in mapB3D.things:
            if thing.category != ThingCategory.LAMP: continue
            self.lamps.append(LampInterim(pos=thing.pos, spriteIdx=thing.sprite, colorIdx=thing.color, special=LampSpecial(thing.special)))

        self.foes: list[FoeInterim] = []
        for thing in mapB3D.things:
            if thing.category != ThingCategory.NPC: continue
            special = NpcSpecial(thing.special)
            if special not in (NpcSpecial.FOE, NpcSpecial.BOSS): continue
            isBoss = (special == NpcSpecial.BOSS)
            angle = foeAngles[thing.index]
            walkDistance = foeWalkDistances[thing.index]
            self.foes.append(FoeInterim(pos=thing.pos, colorIdx=thing.color, isBoss=isBoss, angle=angle, walkDistance=walkDistance))

        self.friendlies: list[FriendlyInterim] = []
        for thing in mapB3D.things:
            if thing.category != ThingCategory.NPC: continue
            special = NpcSpecial(thing.special)
            if special not in (NpcSpecial.FRIENDLY1, NpcSpecial.FRIENDLY2): continue
            isSecond = (special == NpcSpecial.FRIENDLY2)
            self.friendlies.append(FriendlyInterim(pos=thing.pos, colorIdx=thing.color, isSecond=isSecond, spriteIdx=thing.sprite))

        self.crates: list[CrateInterim] = []
        for crate in mapB3D.crates:
            content: CrateContent = None
            isAmmo = (crate.content & 0b001) != 0
            isHealth = (crate.content & 0b010) != 0
            isSecondColor = (crate.content & 0b100) != 0
            if isAmmo and isHealth:
                content = CrateContent.BOTH
            elif isAmmo:
                content = CrateContent.AMMO
            elif isHealth:
                content = CrateContent.HEALTH
            else:
                content = CrateContent.NONE
            v1 = mapB3D.lines[crate.startLineIdx].v1
            v2 = mapB3D.lines[crate.startLineIdx+1].v2
            angle = segmentAngle(*self.lineToTuple(mapB3D.lines[crate.startLineIdx]))
            pos = Vertex(x=(v1.x+v2.x)/2, y=(v1.y+v2.y)/2)
            self.crates.append(CrateInterim(pos=pos, colorIdx=int(isSecondColor), content=content,
                                    spriteIdx=crate.spriteIdx, textureName=crate.textureName, angle=int(angle)))


    def _fixBrokenTextures(self, brokenTextures: dict[int, BrokenTextureData]):
        for lineNum, line in enumerate(self.lines):
            if line.texture.names[0].startswith("NONE_"):
                brokenNum = int(line.texture.names[0].removeprefix("NONE_"))
                newNames = []
                if brokenNum in brokenTextures:
                    data = brokenTextures[brokenNum]
                    for newNum in data.nums:
                        newNames.append(list(self.textures.keys())[newNum])
                    line.texture.names = newNames
                    line.texture.offset = data.offset
                    line.texture.stretch = data.stretch
                else:
                    print(f"warning: no fixing data for {lineNum} texture. Broken num = {brokenNum}")


    def _fillCirclesOffsets(self, circles: list[list[int]]):
        for circle in circles:
            lineLengthScaled = segmentLength(*self.lineToTuple(self.lines[circle[0]])) * SCALE_FACTOR
            offset = 0
            for index in circle[:len(circle)//2]:
                self.lines[index].texture.offset = offset
                self.lines[index].texture.trimOffset(self.textures)
                offset += lineLengthScaled
            offset = 0
            for index in circle[len(circle)//2:]:
                self.lines[index].texture.names = self.lines[circle[len(circle)//2-1]].texture.names
                self.lines[index].texture.offset = offset
                self.lines[index].texture.trimOffset(self.textures)
                offset += lineLengthScaled


    def _removeCratesDoorsAndBrokenLines(self, crates: list[CrateB3D], doorsStartLineIdx: list[int], brokenLines: list[int]):
        linesToRemove: set[int] = set(brokenLines)

        for crate in crates:
            linesToRemove.add(crate.startLineIdx)
            linesToRemove.add(crate.startLineIdx+1)
            linesToRemove.add(crate.startLineIdx+2)
            linesToRemove.add(crate.startLineIdx+3)
        for doorLineIdx in doorsStartLineIdx:
            linesToRemove.add(doorLineIdx)
            linesToRemove.add(doorLineIdx+1)
            linesToRemove.add(doorLineIdx+2)

        newLines: list[LineInterim] = []
        for index, line in enumerate(self.lines):
            if index not in linesToRemove:
                newLines.append(line)
        self.lines = newLines


    def _fixVertexes(self):
        THRESHOLD = 100
        for i in range(len(self.lines)):
            v1 = self.lines[i].v1
            v2 = self.lines[i].v2
            for j in range(len(self.lines)):
                if i == j: continue
                if (v1.pair in [self.lines[j].v1.pair, self.lines[j].v2.pair] or
                    v2.pair in [self.lines[j].v1.pair, self.lines[j].v2.pair]
                ): continue

                x, y = v1.pair()
                fixed = fixVertex(x, y, *self.lineToTuple(self.lines[j]), THRESHOLD)
                if fixed:
                    self.lines[i].v1 = Vertex(*fixed)

                x, y = v2.pair()
                fixed = fixVertex(x, y, *self.lineToTuple(self.lines[j]), THRESHOLD)
                if fixed:
                    self.lines[i].v2 = Vertex(*fixed)


    @staticmethod
    def lineToTuple(line: LineInterim) -> tuple[int]:
        return (line.v1.x, line.v1.y, line.v2.x, line.v2.y)

    @staticmethod
    def _tuplesToLines(tuples, oldLine1: LineInterim, oldLine2: LineInterim) -> list[LineInterim]:
        lines: list[LineInterim] = []
        for tup in tuples:
            height : HeightType = None
            changed = False
            if isInside(*tup, *MapInterim.lineToTuple(oldLine1)) and isInside(*tup, *MapInterim.lineToTuple(oldLine2)):
                if oldLine1.height == oldLine2.height:
                    if areOppositelyDirected(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                        height = None
                    else:
                        height = oldLine1.height
                else:
                    heights = set([oldLine1.height, oldLine2.height])
                    if heights == set([HeightType.TOP, HeightType.BOTTOM]):
                        if areOppositelyDirected(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            raise Exception("Oppositely directed TOP and BOTTOM")
                        else:
                            height = HeightType.FULL
                    elif heights == set([HeightType.TOP, HeightType.FULL]):
                        if areOppositelyDirected(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            height = HeightType.BOTTOM
                            changed = True
                        else:
                            print('Warning: top and full lines are not oppositely directed')
                            height = HeightType.FULL
                    elif heights == set([HeightType.BOTTOM, HeightType.FULL]):
                        if areOppositelyDirected(*MapInterim.lineToTuple(oldLine1), *MapInterim.lineToTuple(oldLine2)):
                            height = HeightType.TOP
                            changed = True
                        else:
                            print('Warning: bottom and full lines are not oppositely directed')
                            height = HeightType.FULL
                    else:
                        raise Exception("Can't be here")
            else:
                if isInside(*tup, *MapInterim.lineToTuple(oldLine1)):
                    height = oldLine1.height
                elif isInside(*tup, *MapInterim.lineToTuple(oldLine2)):
                    height = oldLine2.height
                else:
                    raise Exception("Tuple is not inside either oldLine1 or oldLine2")

            if height:
                newLine = None
                if changed and height in (HeightType.TOP, HeightType.BOTTOM):
                    for oldLine in (oldLine1, oldLine2):
                        if oldLine.height != HeightType.FULL:
                            continue
                        if ((tup[0], tup[1]) in [oldLine.v1.pair(), oldLine.v2.pair()]
                            and (tup[2], tup[3]) in [oldLine.v1.pair(), oldLine.v2.pair()]
                        ):
                            newLine = oldLine
                            newLine.height = height
                            break
                if not newLine:
                    if not changed:
                        lines.append(LineInterim(
                            v1=Vertex(tup[0], tup[1]),
                            v2=Vertex(tup[2], tup[3]),
                            height=height,
                            texture=None
                        ))
                    else:
                        lines.append(LineInterim(
                            v1=Vertex(tup[2], tup[3]),
                            v2=Vertex(tup[0], tup[1]),
                            height=height,
                            texture=None,
                        ))
                else:
                    lines.append(newLine)

        return lines

    def _restoreTextures(self, newLines: list[LineInterim], oldLines: list[LineInterim]):
        for newLine in newLines:
            restored = False
            if newLine.texture is not None: continue
            for oldLine in oldLines:
                if isInside(*self.lineToTuple(newLine), *self.lineToTuple(oldLine)):
                    newLine.texture = oldLine.texture
                    newLine.texture.offset += calculateOffset(*self.lineToTuple(newLine), *self.lineToTuple(oldLine)) * SCALE_FACTOR
                    newLine.texture.trimOffset(self.textures)
                    restored = True
                    break
            if not restored:
                print(f"Warning: cannot restore line texture {newLine=}, {oldLine=}")

    def _removeOverlaps(self):
        i = 0
        while i < len(self.lines):
            j = i + 1
            isBroken = False
            while j < len(self.lines):
                resolved = resolveSegmentsOverlap(*self.lineToTuple(self.lines[i]), *self.lineToTuple(self.lines[j]))
                if not resolved:
                    j += 1
                    continue
                else:
                    # print(i, j)
                    # if i > 98:
                    #     drawMap(self, wait=True)
                    oldLine1 = self.lines[i]
                    oldLine2 = self.lines[j]
                    del self.lines[j]
                    newLines = self._tuplesToLines(resolved, oldLine1, oldLine2)
                    self._restoreTextures(newLines, [oldLine1, oldLine2])
                    # print(i, j, (self.lineToTuple(oldLine1), self.lineToTuple(oldLine2)), "->\n     ",
                    #       tuple((self.lineToTuple(line) for line in newLines)))
                    # print(self.lines[100])
                    self.lines = self.lines[:i] + newLines + self.lines[i+1:]
                    isBroken = True
                    break
            if isBroken:
                continue
            else:
                i += 1
                continue


    def _cutMultitextureLines(self):
        i = 0
        while i < len(self.lines):
            if len(self.lines[i].texture.names) > 1:
                offset = self.textures[self.lines[i].texture.names[0]].width - self.lines[i].texture.offset
                newV = vertexWithOffset_checkInside(*self.lineToTuple(self.lines[i]), offset / SCALE_FACTOR)
                if newV:
                    newLine1 = self.lines[i]
                    newLine2 = copy.deepcopy(self.lines[i])
                    newLine1.v2 = Vertex(*newV)
                    newLine1.texture.names = newLine1.texture.names[:1]
                    newLine2.v1 = Vertex(*newV)
                    newLine2.texture.offset = 0
                    newLine2.texture.names = newLine2.texture.names[1:]
                    self.lines = self.lines[:i] + [newLine1, newLine2] + self.lines[i+1:]
                    continue
                else:
                    i += 1
                    continue
            else:
                i += 1
                continue

    def getAllLines(self):
        newList = self.lines[:]
        for x in self.doors:
            newList.extend(x.lines)
            if x.boxLines:
                newList.extend(x.boxLines)
        return newList

    def _moveDoorOnNewPosition(self, door: DoorInterim):
        newX = max([x.v1.x for x in self.getAllLines()]) + 200 / SCALE_FACTOR
        newY = max([x.v1.y for x in self.getAllLines()]) + 200 / SCALE_FACTOR
        offsetX = newX - door.lines[0].v1.x
        offsetY = newY - door.lines[0].v1.y
        for line in door.lines:
            line.v1.x += offsetX
            line.v1.y += offsetY
            line.v2.x += offsetX
            line.v2.y += offsetY


    def _generateBoxAroundDoor(self, POLines: list[LineInterim]):
        """
            |ay                       |by
        ax--A-------------------------B--bx
            |                         |
        dx--D-------------------------C--cx
            |dy                       |cy
        """
        OFFSET = 50 / SCALE_FACTOR
        DC = POLines[0]
        CB = POLines[1]
        BA = POLines[2]
        AD = POLines[3]
        dx = vertexWithOffset(*MapInterim.lineToTuple(DC), -OFFSET)
        cx = vertexWithOffset(*MapInterim.lineToTuple(DC), segmentLength(*MapInterim.lineToTuple(DC))+OFFSET)
        bx = vertexWithOffset(*MapInterim.lineToTuple(BA), -OFFSET)
        ax = vertexWithOffset(*MapInterim.lineToTuple(BA), segmentLength(*MapInterim.lineToTuple(BA))+OFFSET)
        cy = vertexWithOffset(*MapInterim.lineToTuple(CB), -OFFSET)
        by = vertexWithOffset(*MapInterim.lineToTuple(CB), segmentLength(*MapInterim.lineToTuple(CB))+OFFSET)
        ay = vertexWithOffset(*MapInterim.lineToTuple(AD), -OFFSET)
        dy = vertexWithOffset(*MapInterim.lineToTuple(AD), segmentLength(*MapInterim.lineToTuple(AD))+OFFSET)
        A = AD.v1.pair()
        B = BA.v1.pair()
        C = CB.v1.pair()
        D = DC.v1.pair()
        newAVertex = findFourthVertex([ay, A, ax])
        newBVertex = findFourthVertex([by, B, bx])
        newCVertex = findFourthVertex([cx, C, cy])
        newDVertex = findFourthVertex([dy, D, dx])
        newLines : list[LineInterim] = []
        def getNewLine(new1Vertex, new2Vertex):
            return LineInterim(Vertex(*new1Vertex), Vertex(*new2Vertex), POLines[0].height, TextureInterim([list(self.textures.keys())[0]]))
        newLines.append(getNewLine(newAVertex, newBVertex))
        newLines.append(getNewLine(newBVertex, newCVertex))
        newLines.append(getNewLine(newCVertex, newDVertex))
        newLines.append(getNewLine(newDVertex, newAVertex))
        return newLines


    def _initDoors(self, doorsStartLineIdx: list[int], doorsSpeed: list[int]):
        self.doors : list[DoorInterim] = []
        for startIndex, speed in zip(doorsStartLineIdx, doorsSpeed):
            lines : list[LineInterim] = []
            for i in range(startIndex, startIndex+3):
                lines.append(self.lines[i])
            lines.append(LineInterim(v1=copy.copy(lines[2].v2), v2=copy.copy(lines[0].v1),
                                    texture=copy.deepcopy(lines[1].texture), height=lines[0].height))
            if speed != -1:
                startingSpot=Vertex(
                    x = (lines[0].v1.x + lines[2].v1.x) // 2,
                    y = (lines[0].v1.y + lines[2].v1.y) // 2,
                )
                self.doors.append(DoorInterim(lines=lines, speed=speed, startingSpot=startingSpot))
            else:
                self.lines.extend(lines)

        for i in range(1, len(self.doors)):
            if self.doors[i-1].lines[1].v1 == self.doors[i].lines[1].v2 and self.doors[i-1].lines[1].v2 == self.doors[i].lines[1].v1:
                self.doors[i-1].nextIsMirror = True

        for door in self.doors:
            self._moveDoorOnNewPosition(door)
            door.boxLines = self._generateBoxAroundDoor(door.lines)


    def _fillStretch(self, texture: TextureInterim, line: LineInterim, index: int):
        textureW = self.textures[texture.names[0]].width
        length = round(segmentLength(*self.lineToTuple(line)) * SCALE_FACTOR)
        rem = length % textureW
        tile = length//textureW
        # print(index, rem, tile)
        rems_to_stretch = [40, 23, 48, 7, 47]
        rems_to_squeeze = [80, 9]
        rems_to_ignore = [0, 45, 10, 32]
        if rem in rems_to_stretch:
            if tile > 0:
                texture.stretch = (textureW+rem/tile)/textureW
        elif rem in rems_to_squeeze:
            texture.stretch = length/((tile+1)*textureW)
        elif rem in rems_to_ignore:
            pass
        else:
            print(f"Warning: unknown texture rem={rem} on line {index}")

