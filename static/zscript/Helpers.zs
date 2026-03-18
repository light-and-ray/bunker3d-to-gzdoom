
class Helpers_t
{
    double distanceToSegment(double px, double py, double x1, double y1, double x2, double y2)
    {
        double lineLengthSquared = (x2 - x1) ** 2 + (y2 - y1) ** 2;
        if (lineLengthSquared == 0) return sqrt((px - x1) ** 2 + (py - y1) ** 2);

        double t = max(0, min(1, ((px - x1) * (x2 - x1) + (py - y1) * (y2 - y1)) / lineLengthSquared));
        double nearestX = x1 + t * (x2 - x1);
        double nearestY = y1 + t * (y2 - y1);
        return sqrt((px - nearestX) ** 2 + (py - nearestY) ** 2);
    }

    bool isPlayerCloseEnough(double playerX, double playerY, double xA, double yA, double xB, double yB)
    {
        double THRESHOLD = 88.0;
        double distToA = sqrt((playerX - xA) ** 2 + (playerY - yA) ** 2);
        // double distToB = sqrt((playerX - xB) ** 2 + (playerY - yB) ** 2);
        double distToSegment = distanceToSegment(playerX, playerY, xA, yA, xB, yB);
        return distToA <= THRESHOLD || distToSegment <= THRESHOLD;
    }

    Vector2 getTargetPoint(double xA, double yA, double xB, double yB, double startingX, double startingY)
    {
        double lipSize = 18.0;

        // Calculate the vector from A to B
        double vecX = xB - xA;
        double vecY = yB - yA;

        double length = sqrt(vecX * vecX + vecY * vecY);

        vecX /= length;
        vecY /= length;

        // Move the line segment to the starting vertex
        double targetX = startingX + vecX * (length - lipSize);
        double targetY = startingY + vecY * (length - lipSize);

        Vector2 point;
        point.x = targetX;
        point.y = targetY;
        return point;
    }

    void getPosForLineHandlers(Array<double> points, double xA, double yA, double xB, double yB, double gap, bool returnX)
    {
        double dx = xB - xA;
        double dy = yB - yA;
        double lineLength = sqrt(dx * dx + dy * dy);

        // Scenario 1: Segment is too short to even fit the edge gaps
        if (lineLength < gap * 2.0)
        {
            Vector2 mid;
            mid.x = xA + dx * 0.5;
            mid.y = yA + dy * 0.5;
            if (returnX) {
                points.Push(mid.x);
            } else {
                points.Push(mid.y);
            }
            return;
        }

        // Determine how many gaps fit in the total length
        // We want: gap + (n-1)*internalGap + gap = lineLength
        int numHandlers = int(lineLength / gap);

        // Ensure we have at least 2 handlers if length >= 2*gap
        if (numHandlers < 2) numHandlers = 2;

        double directionX = dx / lineLength;
        double directionY = dy / lineLength;

        // The distance available for distribution after taking out the edge gaps
        double availableDist = lineLength - (2.0 * gap);

        // Calculate internal spacing between handlers
        double step = (numHandlers > 1) ? (availableDist / (numHandlers - 1)) : 0;

        for (int i = 0; i < numHandlers; i++)
        {
            double distFromA = gap + (i * step);
            Vector2 p;
            p.x = xA + directionX * distFromA;
            p.y = yA + directionY * distFromA;
            if (returnX) {
                points.Push(p.x);
            } else {
                points.Push(p.y);
            }
        };
    }

    Vector2 getUnstuckPos(Vector2 pos, double radius, LevelLocals Level)
    {
        Vector2 currentPos = pos;

        for (int i = 0; i < Level.lines.Size(); i++)
        {
            Vector2 v1 = Level.lines[i].v1.p;
            Vector2 v2 = Level.lines[i].v2.p;

            // Vector from V1 to V2 (the wall)
            Vector2 lineVec = v2 - v1;
            // Vector from V1 to the Actor
            Vector2 actorVec = currentPos - v1;

            double lineLenSq = lineVec.x * lineVec.x + lineVec.y * lineVec.y;
            if (lineLenSq == 0) continue; // Safety check for zero-length lines

            // Calculate the t-parameter for the point on the line segment closest to pos
            // Clamp it between 0 and 1 to stay on the segment
            double t = (actorVec.x * lineVec.x + actorVec.y * lineVec.y) / lineLenSq;
            t = max(0.0, min(1.0, t));

            // This is the point on the wall closest to the actor
            Vector2 closestPoint = v1 + lineVec * t;

            // Vector from the wall to the actor
            Vector2 pushVec = currentPos - closestPoint;
            double dist = sqrt(pushVec.x * pushVec.x + pushVec.y * pushVec.y);

            // If the actor is inside the radius, push them out
            if (dist < radius)
            {
                // If the actor is exactly on the line, we need a fallback direction
                if (dist == 0)
                {
                    // Push perpendicular to the line
                    Vector2 normal = (-lineVec.y, lineVec.x).Unit();
                    currentPos += normal * radius;
                }
                else
                {
                    // Normalize the push vector and move the actor to exactly 'radius' distance
                    currentPos = closestPoint + (pushVec / dist) * radius;
                }
            }
        }

        return currentPos;
    }
}

class FreezeChecker : Actor
{    }
