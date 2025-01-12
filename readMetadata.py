from tools import read_binary, read_short


def read_metadata(metadata_file_path):
    pos = 0
    header = []
    file = read_binary(metadata_file_path)

    for _ in range(12):
        header.append(read_short(file, pos))
        pos += 2

    metadata = {
        'FOE_METADATA': [],
        'l': [],
        'n': [],
        'o': [],
        'p': [],
        'q': [],
        'm': [],
        'r': [],
        's': [],
        't': [],
        'u': [],
        'a': []
    }

    metadata['FOE_METADATA'] = [read_short(file, pos) for pos in range(pos, pos + header[0]*2, 2)]
    pos += header[0]*2

    metadata['l'] = [file[pos] for pos in range(pos, pos + header[1])]
    pos += header[1]

    metadata['n'] = [file[pos] for pos in range(pos, pos + header[2])]
    pos += header[2]

    metadata['o'] = [file[pos] for pos in range(pos, pos + header[3])]
    pos += header[3]

    metadata['p'] = [file[pos] for pos in range(pos, pos + header[4])]
    pos += header[4]

    metadata['q'] = [file[pos] for pos in range(pos, pos + header[5])]
    pos += header[5]

    metadata['m'] = [(x if x >= 0 else 256 + x) * 2 for x in file[pos:pos + header[6]]]
    pos += header[6]

    metadata['r'] = [file[pos] for pos in range(pos, pos + header[7])]
    pos += header[7]

    metadata['s'] = [file[pos] for pos in range(pos, pos + header[8])]
    pos += header[8]

    metadata['t'] = [file[pos] for pos in range(pos, pos + header[9])]
    pos += header[9]

    metadata['u'] = [file[pos] for pos in range(pos, pos + header[10])]
    pos += header[10]

    metadata['a'] = [file[pos] for pos in range(pos, pos + header[11])]

    return metadata
