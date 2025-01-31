
double distanceToSegment(double px, double py, double x1, double y1, double x2, double y2)
{
    double lineLengthSquared = pow(x2 - x1, 2) + pow(y2 - y1, 2);
    if (lineLengthSquared == 0) return sqrt(pow(px - x1, 2) + pow(py - y1, 2));

    double t = max(0, min(1, ((px - x1) * (x2 - x1) + (py - y1) * (y2 - y1)) / lineLengthSquared));
    double nearestX = x1 + t * (x2 - x1);
    double nearestY = y1 + t * (y2 - y1);
    return sqrt(pow(px - nearestX, 2) + pow(py - nearestY, 2));
}

bool isPlayerCloseEnough(double playerX, double playerY, double xA, double yA, double xB, double yB)
{
    const double THRESHOLD = 48.0;

    // Calculate the distance from the player to point A
    double distToA = sqrt(pow(playerX - xA, 2) + pow(playerY - yA, 2));

    // Calculate the distance from the player to point B
    double distToB = sqrt(pow(playerX - xB, 2) + pow(playerY - yB, 2));

    // Calculate the distance from the player to the line segment AB
    double distToSegment = distanceToSegment(playerX, playerY, xA, yA, xB, yB);

    // Check if the player is too close to either point A, point B, or the line segment AB
    return distToA <= THRESHOLD || distToB <= THRESHOLD || distToSegment <= THRESHOLD;
}

struct Point_t
{
    double x;
    double y;
}

Point_t getTargetPoint(double xA, double yA, double xB, double yB)
{
    const double lipSize = 18.0;

    double vecX = xB - xA;
    double vecY = yB - yA;

    double length = sqrt(vecX * vecX + vecY * vecY);

    // If the length is zero, the points are the same
    if (length == 0.0) {
        return [xA, yA];  // or throw an exception, depending on your requirements
    }

    // If the length is less than lipSize, move the target point to point B
    if (length <= lipSize) {
        return [xB, yB];
    }

    vecX /= length;
    vecY /= length;

    double targetX = xA + vecX * (length - lipSize);
    double targetY = yA + vecY * (length - lipSize);

    return Point_t(targetX, targetY);
}
