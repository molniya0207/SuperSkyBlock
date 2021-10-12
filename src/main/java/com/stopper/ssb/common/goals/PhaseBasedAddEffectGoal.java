package com.stopper.ssb.common.goals;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.utils.PhaseBasedBoss;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PhaseBasedAddEffectGoal extends Goal {
    MonsterEntity mob;
    int requiredPhase;

    public PhaseBasedAddEffectGoal(MonsterEntity mob, int requiredPhase) {
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
        int selEff = this.mob.getRandom().nextInt(5);
        switch (selEff) {
            case 0:
                this.mob.getTarget().addEffect(new EffectInstance(Effects.BLINDNESS, 100));
                break;

            case 1:
                this.mob.getTarget().addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 140));
                break;

            case 2:
                this.mob.getTarget().addEffect(new EffectInstance(Effects.CONFUSION, 120));
                break;

            case 3:
                this.mob.getTarget().addEffect(new EffectInstance(Effects.WEAKNESS, 80));
                break;
        }
    }
}
