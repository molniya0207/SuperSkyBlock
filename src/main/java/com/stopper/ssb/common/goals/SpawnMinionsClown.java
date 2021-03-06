package com.stopper.ssb.common.goals;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.entities.ClownBoss;
import com.stopper.ssb.common.utils.Registration;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;

public class SpawnMinionsClown extends Goal {
    ClownBoss boss;

    public SpawnMinionsClown(ClownBoss boss) {
        this.boss = boss;
    }

    @Override
    public boolean canUse() {
        float rnd = this.boss.getRandom().nextFloat();
        return this.boss.getHealth() < 120.0f && 0.1f < rnd && rnd < 0.12F;
    }

    public boolean canContinueToUse() {
        return false;
    }

    public void start() {
        if (this.boss.level.isClientSide) return;
        SuperSkyBlock.registration.LEXALOX_ENTITY.get().spawn(this.boss.level.getServer().overworld(), null, null, this.boss.blockPosition(), SpawnReason.TRIGGERED, true, true);
    }

    public void tick() {}
}
