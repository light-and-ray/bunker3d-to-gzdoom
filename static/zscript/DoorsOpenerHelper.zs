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
        double THRESHOLD = 48.0;

        // Calculate the distance from the player to point A
        double distToA = sqrt((playerX - xA) ** 2 + (playerY - yA) ** 2);

        // Calculate the distance from the player to point B
        double distToB = sqrt((playerX - xB) ** 2 + (playerY - yB) ** 2);

        // Calculate the distance from the player to the line segment AB
        double distToSegment = distanceToSegment(playerX, playerY, xA, yA, xB, yB);

        // Check if the player is too close to either point A, point B, or the line segment AB
        return distToA <= THRESHOLD || distToB <= THRESHOLD || distToSegment <= THRESHOLD;
    }

    Vector2 getTargetPoint(double xA, double yA, double xB, double yB)
    {
        double lipSize = 18.0;

        double vecX = xB - xA;
        double vecY = yB - yA;

        double length = sqrt(vecX * vecX + vecY * vecY);

        vecX /= length;
        vecY /= length;

        double targetX = xA + vecX * (length - lipSize);
        double targetY = yA + vecY * (length - lipSize);
        Vector2 point;
        point.x = targetX;
        point.y = targetY;
        return point;
    }
}