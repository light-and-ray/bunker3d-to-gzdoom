def read_short(data, offset):
    return (data[offset] & 0xFF) | (data[offset + 1] & 0xFF) << 8

def read_byte(data, offset):
    return data[offset]

def read_binary(file_name):
    try:
        with open(file_name, 'rb') as file_stream:
            # Read the file length (2 bytes)
            length_low_byte = file_stream.read(1)[0]
            length_high_byte = file_stream.read(1)[0]
            file_length = (length_high_byte << 8) | length_low_byte

            file_data = file_stream.read(file_length)
            return file_data
    except Exception as e:
        print(f"Error reading file: {e}")
        return None


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


def load_map(file_path):
    data = read_binary(file_path)

    # Read header
    header_number_a = read_short(data, 0)
    header_number_b = read_short(data, 2)
    header_number_c = read_short(data, 4)
    print(f"Map file: {file_path}")
    print(f"Header: A={header_number_a}, B={header_number_b}, C={header_number_c}")

    # Read lumps
    lumps = []
    offset = 6

    # Lump 0
    lump0_size = header_number_a * 4
    lump0 = [None] * lump0_size
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
        raw_value = read_short(data, offset)
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

    print("Lumps:")
    for i, lump in enumerate(lumps):
        print(f"Lump {i}: {lump}")

    # Read footer
    footer_size = 8
    footer = []
    for i in range(footer_size):
        footer.append(read_short(data, offset))
        offset += 2

    print("Footer:")
    print(footer)

load_map("1 d (склад).b3d")
