import sys
from PIL import Image

def scale2x(image: Image.Image) -> Image.Image:
    width, height = image.size
    src_pixels = image.load()

    # Create a new image with doubled dimensions
    new_image = Image.new(image.mode, (width * 2, height * 2))
    dst_pixels = new_image.load()

    for y in range(height):
        for x in range(width):
            # Get the central pixel E and its neighbors.
            # For edges, we use the original pixel if a neighbor is out of bounds.
            E = src_pixels[x, y]
            A = src_pixels[x, y - 1] if y - 1 >= 0 else E
            B = src_pixels[x - 1, y] if x - 1 >= 0 else E
            C = src_pixels[x + 1, y] if x + 1 < width else E
            D = src_pixels[x, y + 1] if y + 1 < height else E

            # Compute the four output pixels based on Scale2x algorithm.
            # This implementation uses one variant of the Scale2x algorithm.
            E0 = B if (B == A and B != D) else E
            E1 = A if (A == C and A != B) else E
            E2 = D if (D == B and D != C) else E
            E3 = C if (C == D and C != A) else E

            # Set the pixels in the output image.
            dst_pixels[2 * x, 2 * y] = E0
            dst_pixels[2 * x + 1, 2 * y] = E1
            dst_pixels[2 * x, 2 * y + 1] = E2
            dst_pixels[2 * x + 1, 2 * y + 1] = E3

    return new_image

def main():
    if len(sys.argv) < 2:
        print("Usage: python scale2x.py image1 [image2 ...]")
        sys.exit(1)

    for image_path in sys.argv[1:]:
        try:
            with Image.open(image_path) as img:
                print(f"Processing {image_path} with size {img.size}...")
                upscaled_img = scale2x(img)
                # Replace the original image with the upscaled one.
                upscaled_img.save(image_path)
                print(f"Upscaled {image_path} saved successfully.")
        except Exception as e:
            print(f"Error processing {image_path}: {e}")

if __name__ == '__main__':
    main()
