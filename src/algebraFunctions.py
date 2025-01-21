
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
                    if overlap_start > yC:
                        new_segments.append((xC, yC, xC, overlap_start))
                    if overlap_end < yD:
                        new_segments.append((xC, overlap_end, xC, yD))
                    return new_segments
        return None

    # Check if the segments overlap
    if xA <= xD and xB >= xC:
        # Find the overlap segment
        overlap_start = max(xA, xC)
        overlap_end = min(xB, xD)
        if overlap_start < overlap_end:
            if overlap_start > xA:
                new_segments.append((xA, yA, overlap_start, yA + (yB - yA) * (overlap_start - xA) / (xB - xA)))
            if overlap_start < xB and overlap_end > xA:
                new_segments.append((overlap_start, yA + (yB - yA) * (overlap_start - xA) / (xB - xA), overlap_end, yA + (yB - yA) * (overlap_end - xA) / (xB - xA)))
            if overlap_end < xB:
                new_segments.append((overlap_end, yA + (yB - yA) * (overlap_end - xA) / (xB - xA), xB, yB))
            if overlap_start > xC:
                new_segments.append((xC, yC, overlap_start, yC + (yD - yC) * (overlap_start - xC) / (xD - xC)))
            if overlap_end < xD:
                new_segments.append((overlap_end, yC + (yD - yC) * (overlap_end - xC) / (xD - xC), xD, yD))
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

def _revertCD(segments, xC, yC, xD, yD):
    for i in range(len(segments)):
        if (set([xC, xD]) == set([segments[i][0], segments[i][2]]) and
            set([yC, yD]) == set([segments[i][1], segments[i][3]])
        ):
            segments[i]  = (
                segments[i][2], segments[i][3],
                segments[i][0], segments[i][1]
            )
            return

def resolveSegmentsOverlap(xA, yA, xB, yB, xC, yC, xD, yD):
    # Ensure the segments are in the same order (xA, yA) to (xB, yB) and (xC, yC) to (xD, yD)
    changedAB = False
    if xA > xB or (xA == xB and yA > yB):
        xA, xB = xB, xA
        yA, yB = yB, yA
        changedAB = True
    changedCD = False
    if xC > xD or (xC == xD and yC > yD):
        xC, xD = xD, xC
        yC, yD = yD, yC
        changedCD = True
    result = resolveSegmentsOverlap_(xA, yA, xB, yB, xC, yC, xD, yD)
    if result:
        result = [tuple(int(x) for x in seg) for seg in result]
        if changedAB:
            result = reverseSegments(result)
            if not changedCD:
                _revertCD(result, xC, yC, xD, yD)
        elif changedCD:
            _revertCD(result, xC, yC, xD, yD)
    return result


def isInside(xA, yA, xB, yB, xC, yC, xD, yD):
    """
    Returns True if the segment (xA, yA) - (xB, yB) is fully inside the segment (xC, yC) - (xD, yD).
    The segments are assumed to be collinear.
    """
    # Check for horizontal line
    if yA == yB and yC == yD:
        return min(xC, xD) <= min(xA, xB) and max(xA, xB) <= max(xC, xD)
    # Check for vertical line
    elif xA == xB and xC == xD:
        return min(yC, yD) <= min(yA, yB) and max(yA, yB) <= max(yC, yD)
    else:
        return (min(xC, xD) <= min(xA, xB) and max(xA, xB) <= max(xC, xD) and
                min(yC, yD) <= min(yA, yB) and max(yA, yB) <= max(yC, yD))

def isAthwart(xA, yA, xB, yB, xC, yC, xD, yD):
    """
    Returns True if the two already collinear segments (xA, yA) - (xB, yB) and (xC, yC) - (xD, yD)
    are "moving" in different directions.
    """
    # Check for horizontal line
    if yA == yB and yC == yD:
        return ((xA < xB and xC > xD) or (xA > xB and xC < xD))
    # Check for vertical line
    elif xA == xB and xC == xD:
        return ((yA < yB and yC > yD) or (yA > yB and yC < yD))
    else:
        return ((xA < xB and xC > xD) or (xA > xB and xC < xD) or
                (yA < yB and yC > yD) or (yA > yB and yC < yD))


def test():
    oldLine1 =  (10, 9, 10, 6)
    oldLine2 =  (10, 7, 10, 8)
    tuples = [(10, 9, 10, 8), (10, 7, 10, 8), (10, 7, 10, 6)]
    for tup in tuples:
        print(isInside(*tup, *oldLine1))
        print(isInside(*tup, *oldLine2))
        print(isAthwart(*oldLine1, *oldLine2))
        print()

# test()
