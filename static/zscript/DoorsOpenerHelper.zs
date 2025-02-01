class DoorsOpenerHelper
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
        double THRESHOLD = 96.0;
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
}
