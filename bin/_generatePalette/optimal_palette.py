#!/usr/bin/env python3
"""
This script generates a vibrant, optimal 256-color palette from a list of PNG images
using chroma-weighted sampling and k-means clustering.
"""

import sys
import colorsys
from PIL import Image

try:
    import numpy as np
except ImportError:
    sys.exit("Error: numpy is required to run this script. Please install it via pip (pip install numpy).")


def get_chroma_weights(data):
    """
    Calculate weights based on color saturation and value to favor vibrant colors
    over dull grays and pure blacks/whites.
    """
    rgb_norm = data / 255.0
    cmax = np.max(rgb_norm, axis=1)
    cmin = np.min(rgb_norm, axis=1)
    chroma = cmax - cmin
    weights = chroma + 0.05
    return weights / np.sum(weights)


def kmeans_palette(colors, k, max_iter=25, sample_size=100000):
    """
    Perform k-means clustering on weighted samples to favor vibrant colors.
    """
    data = np.array(colors, dtype=np.float32)
    n_points = data.shape[0]

    if n_points > sample_size:
        weights = get_chroma_weights(data)
        indices = np.random.choice(n_points, sample_size, replace=False, p=weights)
        data = data[indices]
        n_points = sample_size

    indices = [np.random.choice(n_points)]
    for _ in range(1, k):
        distances = np.min([np.sum((data - data[i])**2, axis=1) for i in indices], axis=0)
        probabilities = distances / np.sum(distances)
        indices.append(np.random.choice(n_points, p=probabilities))

    centroids = data[indices]

    for iteration in range(max_iter):
        diff = data[:, np.newaxis, :] - centroids[np.newaxis, :, :]
        distances = np.sum(diff**2, axis=2)
        labels = np.argmin(distances, axis=1)

        new_centroids = np.zeros_like(centroids)
        for i in range(k):
            if np.any(labels == i):
                new_centroids[i] = data[labels == i].mean(axis=0)
            else:
                new_centroids[i] = data[np.random.choice(n_points)]

        if np.allclose(centroids, new_centroids, atol=0.5):
            break
        centroids = new_centroids

    palette = [tuple(map(lambda x: int(round(x)), centroid)) for centroid in centroids]
    return palette


def get_semantic_bucket(h, s, v):
    if v < 0.1:
        return 7  # Black/Dark Gray
    if s < 0.1:
        if v > 0.85:
            return 9  # White/Light Gray
        return 8      # Mid Grays
    hue_deg = h * 360.0
    if hue_deg < 15 or hue_deg >= 330:
        return 1  # Red
    elif hue_deg < 45:
        return 2  # Orange/Brown
    elif hue_deg < 70:
        return 3  # Yellow
    elif hue_deg < 160:
        return 4  # Green
    elif hue_deg < 260:
        return 5  # Blue
    elif hue_deg < 330:
        return 6  # Purple/Violet
    return 10  # Fallback


def sort_palette(palette):
    threshold = 0.07
    def step_sort(color):
        r, g, b = color
        h, s, v = colorsys.rgb_to_hsv(r / 255.0, g / 255.0, b / 255.0)
        bucket = get_semantic_bucket(h, s, v)
        return (bucket, int(v/threshold), int(s/threshold), h, v, s)
    return sorted(palette, key=step_sort)


def get_optimal_palette(*png_paths):
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

    palette = kmeans_palette(colors, 256)

    while len(palette) < 256:
        palette.append((0, 0, 0))
    if len(palette) > 256:
        palette = palette[:256]

    palette = sort_palette(palette)

    palette_bytes = bytearray()
    for r, g, b in palette:
        palette_bytes.extend([r, g, b])

    return bytes(palette_bytes)


if __name__ == '__main__':
    if len(sys.argv) < 3:
        print("Usage: {} out_file image1.png image2.png ...".format(sys.argv[0]))
        sys.exit(1)

    result = get_optimal_palette(*sys.argv[2:])

    out_file = sys.argv[1]
    with open(out_file, "wb") as f:
        f.write(result)
    print(f"Palette generated and written to {out_file} (size: {len(result)} bytes)")