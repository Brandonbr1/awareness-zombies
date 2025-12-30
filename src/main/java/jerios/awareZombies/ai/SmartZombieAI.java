package jerios.awareZombies.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;

import jerios.awareZombies.Config;

public class SmartZombieAI extends EntityAIBase {

    EntityMob mob;

    public SmartZombieAI(EntityMob mob) {
        this.mob = mob;
        this.setMutexBits(Config.mutexBits);
    }

    @Override
    public boolean shouldExecute() {
        return false;
    }

}
