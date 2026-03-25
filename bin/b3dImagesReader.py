import glob

def convertToPNG(file_path):
    with open(file_path, 'rb') as file:
        data = file.read()
    png_start = data.find(b'IHDR')
    png_data = b'\x89\x50\x4e\x47\x0d\x0a\x1a\x0a\x00\x00\x00\x0d' + data[png_start:]
    with open(file_path + '.png', 'wb') as f:
        f.write(png_data)


def main():
    b3d_files = glob.glob("*.b3d")
    for b3d_file in b3d_files:
        convertToPNG(b3d_file)

if __name__ == "__main__":
    main()
