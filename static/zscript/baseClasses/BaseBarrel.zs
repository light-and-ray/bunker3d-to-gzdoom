
class BaseBarrel : Actor
{
    Default
    {
        Health 5;
        Height 48;
        Radius 29;
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
        double SOFT_GAP = 14;
        double PENETRATION_FORCE_SCALE = 0.3;
        double combinedRadius = self.radius + other.radius;
        double combinedRadiusBlocking = self.radius - SOFT_GAP + other.radius;
        double distSq = self.Distance2DSquared(other);
        bool canCollideSoft = (distSq <= combinedRadius * combinedRadius);
        bool canCollideBlocking = (distSq <= combinedRadiusBlocking * combinedRadiusBlocking);

        if (canCollideSoft)
        {
            Vector3 diff = self.Vec3To(other);
            if (other.pos.z < self.pos.z + self.height - self.radius) {
                diff.z = 0; // Hemisphere on the top, cylinder on the bottom
            }

            double dist = diff.Length();
            if (dist > 0)
            {
                Vector3 normal = diff / dist;
                double penetration = combinedRadius - dist;
                double dotProd = other.Vel dot normal;

                if (dotProd < 0)
                {
                    double pushForce = dotProd - (penetration * PENETRATION_FORCE_SCALE);
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

