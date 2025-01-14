import math

def readShort(data, offset):
    return (data[offset] & 0xFF) | ((data[offset + 1] & 0xFF) << 8)

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

def get2DListValueRange(list_: list[list]):
    min = math.inf
    max = -math.inf
    for i in range(len(list_)):
        for j in range(len(list_[i])):
            value = list_[i][j]
            if value < min:
                min = value
            if value > max:
                max = value
    return (min, max)


def printBigLump(bigLump):
    for i in range(len(bigLump)):
        list_ = bigLump[i]
        print(f"Fragment {i} of size {len(list_)} in range {get2DListValueRange(list_)}: {list_}\n")


def create2DList(a, b, default=0):
    return [[default for _ in range(b)] for _ in range(a)]

def create1DList(a, default=0):
    return [default for _ in range(a)]
