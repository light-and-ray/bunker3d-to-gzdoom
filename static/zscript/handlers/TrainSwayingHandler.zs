
class TrainSwayingSourceWave : Actor
{
    const wideSway = 0.18;
    const longSway = 0.10;
    const highSway = 0.03;
    const wideFreq = 3.5;
    const longFreq = 2.63;
    const highFreq = 4.12;
    States
    {
        Spawn:
            TNT1 A 1000000 NoDelay A_QuakeEx(longSway, wideSway, highSway, 1000000, 0, 100000, "", QF_WAVE, longFreq, wideFreq, highFreq);
            loop;
    }
}

class TrainSwayingSourceRandom : Actor
{
    const wideSway = 0.06;
    const longSway = 0.04;
    const highSway = 0;
    States
    {
        Spawn:
            TNT1 A 1000000 NoDelay A_QuakeEx(longSway, wideSway, highSway, 1000000, 0, 100000, "");
            loop;
    }
}

class TrainSwayingHandler : EventHandler
{
    override void WorldLoaded(WorldEvent event)
    {
        Vector3 spawnPos;
        spawnPos.x = 0;
        spawnPos.y = 0;
        spawnPos.z = 0;
        Actor.Spawn('TrainSwayingSourceWave', spawnPos);
        Actor.Spawn('TrainSwayingSourceRandom', spawnPos);
    }
}

