from tools import read_binary, readShort, printBigLump, get2DListValueRange
from readMetadata import read_metadata
import obfuscatedMagic



def loadMapPart(lumpA, lumpB, map_metadata):
    bigLump = []
    pos = 0
    lumpB_size = len(lumpB)

    for i in range(lumpB_size):
        lumpFragmentSize = 127 - lumpB[i] if lumpB[i] < 0 else lumpB[i]
        bigLump.append([])

        for j in range(lumpFragmentSize):
            var11 = map_metadata[i]

            row = []
            for k in range(var11):
                row.append(lumpA[pos])
                pos += 1
            bigLump[i].append(row)

    return bigLump



"""
        -----------------------------------
        | header, 3 shorts: A, B, C       |
        -----------------------------------
    0   | 5 shorts, can be negative       |
        -----------------------------------
    1   | A*4 nibbles                     |
        -----------------------------------
    2   | B bytes                         |
        -----------------------------------
    3   | 72 bytes                        |
        -----------------------------------
    4   | C bytes                         |
        -----------------------------------
    5   | 10 bytes                        |
        -----------------------------------
        | footer, 8 shorts                |
        -----------------------------------
"""


def loadMap(file_path):
    data = read_binary(file_path)

    # Read header
    header_number_a = readShort(data, 0)
    header_number_b = readShort(data, 2)
    header_number_c = readShort(data, 4)
    print(f"Map file: {file_path}")
    print(f"Header: A={header_number_a}, B={header_number_b}, C={header_number_c}")

    # Read lumps
    lumps = []
    offset = 6

    # Lump 0
    lump0_size = header_number_a * 4
    lump0 = bytearray(lump0_size)
    for i in range(0, lump0_size, 4):
        high_nibble1 = (data[offset + 1] & 0xF0) >> 4
        low_nibble1 = data[offset + 1] & 0x0F
        high_nibble2 = (data[offset] & 0xF0) >> 4
        low_nibble2 = data[offset] & 0x0F
        lump0[i] = high_nibble1
        lump0[i + 1] = low_nibble1
        lump0[i + 2] = high_nibble2
        lump0[i + 3] = low_nibble2
        offset += 2
    lumps.append(lump0)

    # Lump 1
    lump1_size = 5
    lump1 = [None] * lump1_size
    for i in range(lump1_size):
        raw_value = readShort(data, offset)
        value = raw_value if raw_value < 128 else 127 - raw_value
        lump1[i] = value
        offset += 2
    lumps.append(lump1)

    # Lump 2
    lump2_size = header_number_b
    lump2 = list(data[offset : offset + lump2_size])
    offset += lump2_size
    lumps.append(lump2)

    # Lump 3
    lump3_size = 72
    lump3 = list(data[offset : offset + lump3_size])
    offset += lump3_size
    lumps.append(lump3)

    # Lump 4
    lump4_size = header_number_c
    lump4 = list(data[offset : offset + lump4_size])
    offset += lump4_size
    lumps.append(lump4)

    # Lump 5
    lump5_size = 10
    lump5 = list(data[offset : offset + lump5_size])
    offset += lump5_size
    lumps.append(lump5)

    # print("Lumps:")
    # for i, lump in enumerate(lumps):
    #     print(f"Lump {i} of size {len(lump)}: {lump}\n")

    # Read footer
    footer_size = 8
    footer = []
    for i in range(footer_size):
        footer.append(readShort(data, offset))
        offset += 2

    print("Footer:", footer)

    metadata = read_metadata("a.b3d")

    bigLump0 = loadMapPart(lump0, lump1, metadata['o'])
    bigLump1 = loadMapPart(lump2, lump3, metadata['p'])
    bigLump2 = loadMapPart(lump4, lump5, metadata['n'])

    modifier = obfuscatedMagic.BigLumpModifier(metadata)
    modifier.modifyBigLump01(bigLump0, bigLump1)
    modifier.modifyBigLump1(bigLump1)

    # print("\nbigLump 0\n")
    # printBigLump(bigLump0)

    # print("\nbigLump 1\n")
    # printBigLump(bigLump1)

    # print("\nbigLump 2\n")
    # printBigLump(bigLump2)

    # print(len(modifier.cX))
    # for x in modifier.cW:
    #     print(len(x))

    # print(get2DListValueRange(modifier.cW))
    # return obfuscatedMagic.modifyBigLumps01(bigLump0, bigLump1)[0]
    return modifier.cW

