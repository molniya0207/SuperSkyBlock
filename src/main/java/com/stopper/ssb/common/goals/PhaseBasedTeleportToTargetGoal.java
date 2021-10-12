package com.stopper.ssb.common.goals;

import com.stopper.ssb.common.utils.PhaseBasedBoss;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;

public class PhaseBasedTeleportToTargetGoal extends Goal {
    MonsterEntity mob;
    int requiredPhase;

    public PhaseBasedTeleportToTargetGoal(MonsterEntity mob, int requiredPhase) {
        this.mob = mob;
        this.requiredPhase = requiredPhase;
    }

    @Override
    public boolean canUse() {
        float rnd = this.mob.getRandom().nextFloat();
        return ((PhaseBasedBoss)this.mob).getPhase() >= requiredPhase && 0.1f < rnd && rnd < 0.2F && mob.getTarget() != null;
    }

    @Override
    public boolean canContinueToUse() {
        return false;
    }

    @Override
    public void start() {
        if (mob.getTarget() != null) {
            mob.setPos(mob.getTarget().getX(), mob.getTarget().getY(), mob.getTarget().getZ());
        }
    }
}
