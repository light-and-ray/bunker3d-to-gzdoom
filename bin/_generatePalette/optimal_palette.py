#!/usr/bin/env python3
"""
This script generates an optimal 256-color palette from a list of PNG images
using k-means clustering. The clustering automatically averages similar colors,
yielding a palette that better represents the overall distribution of colors,
even when multiple images have similar gray, black, or white tones.
"""

import sys
import random
from PIL import Image

try:
    import numpy as np
except ImportError:
    sys.exit("Error: numpy is required to run this script. Please install it via pip (pip install numpy).")

def kmeans_palette(colors, k, max_iter=20, sample_size=100000):
    """
    Perform k-means clustering on the list of colors to extract k representative colors.

    Args:
        colors (list of tuple): List of (r, g, b) tuples.
        k (int): Number of triggers (palette colors).
        max_iter (int): Maximum number of iterations.
        sample_size (int): Maximum number of pixels to use for clustering (random sample if needed).

    Returns:
        list: List of k colors as (r, g, b) tuples (averaged and converted to integers).
    """
    # If the number of colors is huge, sample a subset for efficiency.
    if len(colors) > sample_size:
        colors = random.sample(colors, sample_size)

    # Convert list of colors to a numpy array of shape (N, 3)
    data = np.array(colors, dtype=np.float32)
    n_points = data.shape[0]

    # Randomly initialize k centroids from the data.
    indices = np.random.choice(n_points, k, replace=False)
    centroids = data[indices]

    for iteration in range(max_iter):
        # Compute squared Euclidean distances between each point and centroid
        # Using broadcasting trick: (data - centroid)**2 and summing up along axis 1.
        # Resulting in a (n_points, k) matrix.
        diff = data[:, np.newaxis, :] - centroids[np.newaxis, :, :]
        distances = np.sum(diff**2, axis=2)

        # Assign each point to the nearest centroid
        labels = np.argmin(distances, axis=1)

        new_centroids = np.zeros_like(centroids)
        for i in range(k):
            # If no point is assigned to a centroid, reinitialize it randomly.
            if np.any(labels == i):
                new_centroids[i] = data[labels == i].mean(axis=0)
            else:
                new_centroids[i] = data[np.random.choice(n_points)]

        # Check for convergence: if centroids haven't changed significantly, then break.
        if np.allclose(centroids, new_centroids, atol=1e-2):
            break
        centroids = new_centroids

    # Convert centroids to integer RGB tuples.
    palette = [tuple(map(lambda x: int(round(x)), centroid)) for centroid in centroids]
    return palette

def get_optimal_palette(*png_paths):
    """
    Generate an optimal 256-color palette from a list of PNG images using k-means clustering.

    The palette is generated such that similar colors (for instance similar gray, black, and white tones)
    are averaged naturally by the clustering process.

    Args:
        *png_paths: Variable length argument list containing paths to PNG files.

    Returns:
        bytes: A binary string representing the final palette. The palette is
               256 RGB colors, with 3 bytes per color.
    """
    colors = []
    for path in png_paths:
        try:
            with Image.open(path) as im:
                im = im.convert("RGB")
                colors.extend(list(im.getdata()))
        except Exception as e:
            print(f"Error processing image {path}: {e}", file=sys.stderr)

    if not colors:
        raise ValueError("No colors were found in any of the provided images.")

    # Run k-means clustering to get 256 optimal colors.
    palette = kmeans_palette(colors, 256)

    # In case fewer than 256 unique triggers were produced, pad with black.
    while len(palette) < 256:
        palette.append((0, 0, 0))
    # If more than 256 colors are produced (shouldn't happen), truncate.
    if len(palette) > 256:
        palette = palette[:256]

    # Creating a binary palette: each color is 3 bytes (R, G, B)
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

