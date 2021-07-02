package com.stopper.ssb.common.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.Explosion;

public class MiniExplosionGoal extends Goal {
    MonsterEntity mob;

    public MiniExplosionGoal(MonsterEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        float rnd = this.mob.getRandom().nextFloat();
        return this.mob.getHealth() < 100.0f && 0.1f < rnd && rnd < 0.13F && mob.getTarget() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return false;
    }

    @Override
    public void start() {
        if (mob.getTarget() != null) {
            mob.getTarget().level.explode(null, mob.getTarget().getX(), mob.getTarget().getY(), mob.getTarget().getZ(), 2f, Explosion.Mode.NONE);
        }
    }
}
