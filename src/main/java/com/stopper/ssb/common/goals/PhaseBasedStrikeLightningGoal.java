package com.stopper.ssb.common.goals;

import com.stopper.ssb.common.utils.PhaseBasedBoss;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;

public class PhaseBasedStrikeLightningGoal extends Goal {
    MonsterEntity mob;
    int requiredPhase;

    public PhaseBasedStrikeLightningGoal(MonsterEntity mob, int requiredPhase) {
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
        if (this.mob.level.isClientSide) return;
        if (this.mob.getTarget() == null) return;
        EntityType.LIGHTNING_BOLT.spawn(this.mob.level.getServer().overworld(), null, null, this.mob.getTarget().blockPosition(), SpawnReason.TRIGGERED, true, true);
    }
}