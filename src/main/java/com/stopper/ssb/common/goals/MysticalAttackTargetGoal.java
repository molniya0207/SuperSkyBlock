package com.stopper.ssb.common.goals;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;

public class MysticalAttackTargetGoal extends Goal {
    MonsterEntity mob;

    public MysticalAttackTargetGoal(MonsterEntity mob) {
        this.mob = mob;
    }

    @Override
    public boolean canUse() {
        float rnd = this.mob.getRandom().nextFloat();
        return this.mob.getHealth() < 200.0f && 0.1f < rnd && rnd < 0.2F && mob.getTarget() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return false;
    }

    @Override
    public void start() {
        if (mob.getTarget() != null) {
            mob.getTarget().setHealth(mob.getTarget().getHealth() - 3f);
        }
    }
}
