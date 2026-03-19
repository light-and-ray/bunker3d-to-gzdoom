
class BaseBarrel : Actor
{
    Default
    {
        Health 5;
        Height 48;
        Radius 27.817490;
        +SOLID;
        +SHOOTABLE;
        +DONTTHRUST;
        +NOBLOOD;
        +NOBLOODDECALS;
    }
    States
    {
        SpawnBase:
            #### A -1;
            loop;
        Death:
            #### A 15;
            TNT1 A 0 SpawnExplosion();
            stop;
    }

    override bool CanCollideWith(Actor other, bool passive)
    {
        double BLOCKING_RADIUS = 5;
        double combinedRadius = self.radius + other.radius;
        double combinedRadiusBlocking = BLOCKING_RADIUS + other.radius;
        double distSq = self.Distance2DSquared(other);
        bool canCollideSoft = (distSq <= combinedRadius * combinedRadius);
        bool canCollideBlocking = (distSq <= combinedRadiusBlocking * combinedRadiusBlocking);

        if (canCollideSoft)
        {
            Vector3 diff = self.Vec3To(other);
            if (other.pos.z < self.pos.z + self.height - self.radius) {
                diff.z = 0; // Semi-sphere on the top, cylinder on the bottom
            }

            double dist = diff.Length();
            if (dist > 0)
            {
                Vector3 normal = diff / dist;
                double penetration = combinedRadius - dist;
                double dotProd = other.Vel dot normal;

                if (dotProd < 0)
                {
                    double pushForce = dotProd - (penetration * 0.2);
                    other.vel -= normal * pushForce;
                }
            }
        }

        return canCollideBlocking;
    }

    void SpawnExplosion()
    {
        Explosion_t explosion = Explosion_t(Spawn('Explosion_t', pos));
    }

}

