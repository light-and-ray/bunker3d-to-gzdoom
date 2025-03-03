#!/usr/bin/env python3
import sys
from PIL import Image

def average_color(colors):
    """Calculate the average RGB color from a list of colors.
    
    Args:
        colors (list of tuple): List of (r, g, b) tuples.
        
    Returns:
        tuple: (avg_r, avg_g, avg_b) as integers.
    """
    if not colors:
        return (0, 0, 0)
    total_r = total_g = total_b = 0
    for r, g, b in colors:
        total_r += r
        total_g += g
        total_b += b
    n = len(colors)
    return (total_r // n, total_g // n, total_b // n)

def median_cut(colors, depth):
    """Apply the median cut algorithm recursively to generate a palette.
    
    Args:
        colors (list of tuple): List of (r, g, b) tuples.
        depth (int): Number of splits to perform.
        
    Returns:
        list: List of average colors for each box.
    """
    if depth == 0 or len(colors) == 0:
        return [average_color(colors)]
    
    # Determine the range of colors along each channel
    reds   = [r for r, _, _ in colors]
    greens = [g for _, g, _ in colors]
    blues  = [b for _, _, b in colors]

    r_range = max(reds) - min(reds)
    g_range = max(greens) - min(greens)
    b_range = max(blues) - min(blues)
    
    # Choose the channel with the greatest range to split upon
    if r_range >= g_range and r_range >= b_range:
        key = lambda color: color[0]
    elif g_range >= r_range and g_range >= b_range:
        key = lambda color: color[1]
    else:
        key = lambda color: color[2]
    
    # Sort colors by the selected channel
    colors.sort(key=key)
    median_index = len(colors) // 2
    
    # Recursively process the two halves
    left = median_cut(colors[:median_index], depth - 1)
    right = median_cut(colors[median_index:], depth - 1)
    
    return left + right

def get_optimal_palette(*png_paths):
    """Generate an optimal 256-color palette from a list of PNG images.
    
    The palette is generated using a median cut algorithm.
    
    Args:
        *png_paths: Variable length argument list containing paths to PNG files.
        
    Returns:
        bytes: A binary string representing the final palette. The palette is 
               256 (16x16) RGB pixels, written in a row (3 bytes per color).
    """
    colors = []
    for path in png_paths:
        try:
            with Image.open(path) as im:
                im = im.convert("RGB")
                # Extend the colors list with all pixels from the image.
                colors.extend(list(im.getdata()))
        except Exception as e:
            print(f"Error processing image {path}: {e}", file=sys.stderr)
    
    if not colors:
        raise ValueError("No colors were found in any of the provided images.")
    
    # Use median cut algorithm with depth=8 to yield 2^8 = 256 colors.
    palette = median_cut(colors, 8)
    
    # If the number of colors is fewer than 256 because of limited image data, pad with black.
    while len(palette) < 256:
        palette.append((0, 0, 0))
    # If more than 256 colors are produced, truncate the extra ones.
    if len(palette) > 256:
        palette = palette[:256]
    
    # Create the binary palette: each color is 3 bytes (R, G, B)
    palette_bytes = bytearray()
    for r, g, b in palette:
        palette_bytes.extend([r, g, b])
        
    return bytes(palette_bytes)

if __name__ == '__main__':
    if len(sys.argv) < 3:
        print("Usage: {} out_file image1.png image2.png ...".format(sys.argv[0]))
        sys.exit(1)
    
    # Calculate the palette for the provided PNG files.
    result = get_optimal_palette(*sys.argv[2:])
    
    # Write the resulting binary palette to a file.
    out_file = sys.argv[1]
    with open(out_file, "wb") as f:
        f.write(result)
    print(f"Palette generated and written to {out_file} (size: {len(result)} bytes)")
