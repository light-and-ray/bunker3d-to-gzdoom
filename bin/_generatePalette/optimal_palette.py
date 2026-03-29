#!/usr/bin/env python3
"""
This script generates a vibrant, optimal 256-color palette from a list of PNG images
using chroma-weighted sampling and k-means clustering.
"""

import sys
import random
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
    # Normalize RGB to 0-1
    rgb_norm = data / 255.0

    # Calculate Max and Min for HSL conversion
    cmax = np.max(rgb_norm, axis=1)
    cmin = np.min(rgb_norm, axis=1)
    chroma = cmax - cmin

    # We want to give higher weight to colors with high chroma (vibrancy)
    # Adding a small constant prevents zero-division and allows some grays to exist
    weights = chroma + 0.05

    # Normalize weights so they sum to 1
    return weights / np.sum(weights)

def kmeans_palette(colors, k, max_iter=25, sample_size=100000):
    """
    Perform k-means clustering on weighted samples to favor vibrant colors.
    """
    data = np.array(colors, dtype=np.float32)
    n_points = data.shape[0]

    # STAGE 1: Favor vibrant colors during sampling
    if n_points > sample_size:
        weights = get_chroma_weights(data)
        indices = np.random.choice(n_points, sample_size, replace=False, p=weights)
        data = data[indices]
        n_points = sample_size

    # Initialize centroids using K-Means++ style spread (heuristic)
    # Pick the first point randomly, then pick points far from it
    indices = [np.random.choice(n_points)]
    for _ in range(1, k):
        distances = np.min([np.sum((data - data[i])**2, axis=1) for i in indices], axis=0)
        probabilities = distances / np.sum(distances)
        indices.append(np.random.choice(n_points, p=probabilities))

    centroids = data[indices]

    # Standard K-means loop
    for iteration in range(max_iter):
        diff = data[:, np.newaxis, :] - centroids[np.newaxis, :, :]
        distances = np.sum(diff**2, axis=2)
        labels = np.argmin(distances, axis=1)

        new_centroids = np.zeros_like(centroids)
        for i in range(k):
            if np.any(labels == i):
                new_centroids[i] = data[labels == i].mean(axis=0)
            else:
                # If a cluster dies, revive it with a random point
                new_centroids[i] = data[np.random.choice(n_points)]

        if np.allclose(centroids, new_centroids, atol=0.5):
            break
        centroids = new_centroids

    palette = [tuple(map(lambda x: int(round(x)), centroid)) for centroid in centroids]
    return palette

def sort_palette(palette, threshold=0.15):
    """
    Sorts a palette by Hue, Luma, and Saturation using a threshold to group
    perceptually similar colors together without harsh jumps.
    """
    def step_sort(color):
        r, g, b = color
        h, l, s = colorsys.rgb_to_hls(r / 255.0, g / 255.0, b / 255.0)

        h_bucket = int(h / threshold)
        l_bucket = int(l / threshold)
        s_bucket = int(s / threshold)

        return (h_bucket, l_bucket, s_bucket, h, l, s)

    return sorted(palette, key=step_sort)

def get_optimal_palette(*png_paths):
    """
    Generate an optimal 256-color palette from PNGs using weighted k-means.
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

    palette = kmeans_palette(colors, 256)

    # Padding or trimming to hit exactly 256
    while len(palette) < 256:
        palette.append((0, 0, 0))
    if len(palette) > 256:
        palette = palette[:256]

    palette = sort_palette(palette, threshold=0.18)

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