package com.stopper.ssb.common.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;

public class DevilIgniteTargetGoal extends Goal {
    MonsterEntity mob;

    public DevilIgniteTargetGoal(MonsterEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        float rnd = this.mob.getRandom().nextFloat();
        return this.mob.getHealth() < 300.0f && 0.1f < rnd && rnd < 0.12F && mob.getTarget() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return false;
    }

    @Override
    public void start() {
        if (mob.getTarget() != null) {
            mob.getTarget().setRemainingFireTicks(100);
        }
    }
}
