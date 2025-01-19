from drawMap import LineB3D, draw_lines

def are_collinear(x1, y1, x2, y2, x3, y3):
    # Check if the points (x1, y1), (x2, y2), (x3, y3) are collinear
    return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)

def resolveSegmentsOverlap(xA, yA, xB, yB, xC, yC, xD, yD):
    # Check if the segments are collinear
    if not are_collinear(xA, yA, xB, yB, xC, yC) or not are_collinear(xA, yA, xB, yB, xD, yD):
        return None

    # Ensure the segments are in the same order (xA, yA) to (xB, yB) and (xC, yC) to (xD, yD)
    if xA > xB:
        xA, xB = xB, xA
        yA, yB = yB, yA
    if xC > xD:
        xC, xD = xD, xC
        yC, yD = yD, yC

    # Check if the segments overlap
    if xA <= xD and xB >= xC:
        # Find the overlap segment
        overlap_start = max(xA, xC)
        overlap_end = min(xB, xD)

        # Find the new segments
        new_segments = []
        if overlap_start > xA:
            new_segments.append((xA, yA, overlap_start, yA + (yB - yA) * (overlap_start - xA) / (xB - xA)))
        new_segments.append((overlap_start, yA + (yB - yA) * (overlap_start - xA) / (xB - xA), overlap_end, yA + (yB - yA) * (overlap_end - xA) / (xB - xA)))
        if overlap_end < xB:
            new_segments.append((overlap_end, yA + (yB - yA) * (overlap_end - xA) / (xB - xA), xB, yB))

        return [tuple(int(x) for x in seg) for seg in new_segments]

    return None


def test():
    lines = [
        LineB3D(v1=(1, 1), v2=(5, 5)),
        LineB3D(v1=(1, 1), v2=(5, 5)),
    ]
    # print(resolveSegmentsOverlap(1, 1, 5, 5, 3, 1, 3, 5))  # Overlapping segments
    draw_lines(lines, show=True)
    print(resolveSegmentsOverlap(1, 1, 5, 5, 1, 1, 5, 5))
    # print(resolveSegmentsOverlap(1, 1, 5, 5, 1, 1, 5, 5))  # Identical segments

    # # Example usage:
    # result = find_overlapping_segments(1, 0, 5, 0, 3, 0, 7, 0)
    # print(result)  # Output: [(1, 0, 3, 0), (3, 0, 5, 0), (5, 0, 7, 0)]
