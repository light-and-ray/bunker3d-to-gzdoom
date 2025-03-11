import sys
from tools import addOffsets

def main():
    if len(sys.argv) != 4:
        print("Usage: python offset_wrapper.py <path_to_png> <x_offset> <y_offset>")
        sys.exit(1)

    file_path = sys.argv[1]
    try:
        x_offset = int(sys.argv[2])
        y_offset = int(sys.argv[3])
    except ValueError:
        print("Offsets must be integers.")
        sys.exit(1)

    # Read the PNG image data as binary.
    with open(file_path, "rb") as f:
        png_data = f.read()

    # Process the PNG data with the specified offsets.
    updated_png_data = addOffsets(png_data, x_offset, y_offset)

    # Write the updated PNG data back, replacing the original file.
    with open(file_path, "wb") as f:
        f.write(updated_png_data)

if __name__ == "__main__":
    main()
