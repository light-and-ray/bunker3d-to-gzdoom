# from drawMap import LineB3D, draw_lines
from ClassesB3D import LineB3D

def areCollinear(x1, y1, x2, y2, x3, y3):
    # Check if the points (x1, y1), (x2, y2), (x3, y3) are collinear
    return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)

def resolveSegmentsOverlap_(xA, yA, xB, yB, xC, yC, xD, yD):
    # Check if the segments are collinear
    if not areCollinear(xA, yA, xB, yB, xC, yC) or not areCollinear(xA, yA, xB, yB, xD, yD):
        return None

    new_segments = []

    # Handle vertical segments
    if xA == xB:
        if xC == xD and xA == xC:
            if yA <= yD and yB >= yC:
                overlap_start = max(yA, yC)
                overlap_end = min(yB, yD)
                if overlap_start < overlap_end:
                    if overlap_start > yA:
                        new_segments.append((xA, yA, xA, overlap_start))
                    new_segments.append((xA, overlap_start, xA, overlap_end))
                    if overlap_end < yB:
                        new_segments.append((xA, overlap_end, xA, yB))
                    return new_segments
        return None

    # Check if the segments overlap (non-horizontal and non-vertical)
    if xA <= xD and xB >= xC:
        # Find the overlap segment
        overlap_start = max(xA, xC)
        overlap_end = min(xB, xD)
        if overlap_start < overlap_end:
            if overlap_start > xA:
                new_segments.append((xA, yA, overlap_start, yA + (yB - yA) * (overlap_start - xA) / (xB - xA)))
            new_segments.append((overlap_start, yA + (yB - yA) * (overlap_start - xA) / (xB - xA), overlap_end, yA + (yB - yA) * (overlap_end - xA) / (xB - xA)))
            if overlap_end < xB:
                new_segments.append((overlap_end, yA + (yB - yA) * (overlap_end - xA) / (xB - xA), xB, yB))
            return new_segments

    return None

def reverseSegments(segments):
    reversedSegments = segments[:: -1]
    for i in range(len(reversedSegments)):
        reversedSegments[i]  = (
            reversedSegments[i][2], reversedSegments[i][3],
            reversedSegments[i][0], reversedSegments[i][1]
        )
    return reversedSegments

def resolveSegmentsOverlap(xA, yA, xB, yB, xC, yC, xD, yD):
    # Ensure the segments are in the same order (xA, yA) to (xB, yB) and (xC, yC) to (xD, yD)
    changedAB = False
    if xA > xB:
        xA, xB = xB, xA
        yA, yB = yB, yA
        changedAB = True
    changedBC = False
    if xC > xD:
        xC, xD = xD, xC
        yC, yD = yD, yC
        changedBC = True
    result = resolveSegmentsOverlap_(xA, yA, xB, yB, xC, yC, xD, yD)
    if result:
        result = [tuple(int(x) for x in seg) for seg in result]
        if changedAB:
            result = reverseSegments(result)
        # if changedBC:
    return result


def test():
    lines = [
        LineB3D(v1=(10, 0), v2=(0, 0)),
        LineB3D(v1=(5, 0), v2=(4, 0)),
    ]
    # draw_lines(lines, show=True)
    i = 0
    j = 1
    result = resolveSegmentsOverlap(lines[i].v1[0], lines[i].v1[1], lines[i].v2[0], lines[i].v2[1],
                                        lines[j].v1[0], lines[j].v1[1], lines[j].v2[0], lines[j].v2[1])
    print(result)

# test()
