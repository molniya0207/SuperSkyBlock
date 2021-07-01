package com.stopper.ssb.common.goals;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;

public class DevilStrikeLightningGoal extends Goal {
    MonsterEntity boss;

    public DevilStrikeLightningGoal(MonsterEntity boss) {
        this.boss = boss;
    }

    @Override
    public boolean canUse() {
        float rnd = this.boss.getRandom().nextFloat();
        return this.boss.getHealth() < 550.0f && 0.1f < rnd && rnd < 0.12F;
    }

    public boolean canContinueToUse() {
        return false;
    }

    public void start() {
        if (this.boss.level.isClientSide) return;
        if (this.boss.getTarget() == null) return;
        EntityType.LIGHTNING_BOLT.spawn(this.boss.level.getServer().overworld(), null, null, this.boss.getTarget().blockPosition(), SpawnReason.TRIGGERED, true, true);
    }

    public void tick() {}
}
