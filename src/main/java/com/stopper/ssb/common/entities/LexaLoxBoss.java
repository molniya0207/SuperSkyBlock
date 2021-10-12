package com.stopper.ssb.common.entities;

import com.stopper.ssb.common.goals.*;
import com.stopper.ssb.common.utils.PhaseBasedBoss;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BossInfo;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;

public class LexaLoxBoss extends MonsterEntity implements PhaseBasedBoss {
    private final ServerBossInfo bossEvent = (ServerBossInfo)(new ServerBossInfo(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS));
    public int Phase = 1;

    public LexaLoxBoss(EntityType<? extends MonsterEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0d, true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));

        this.goalSelector.addGoal(3, new PhaseBasedSpawnMinionsGoal(this, 2));
        this.goalSelector.addGoal(3, new PhaseBasedAddEffectGoal(this, 4));
        this.goalSelector.addGoal(3, new PhaseBasedStrikeLightningGoal(this, 4));
        this.goalSelector.addGoal(3, new PhaseBasedTeleportTargetGoal(this, 3));
        this.goalSelector.addGoal(3, new PhaseBasedTeleportToTargetGoal(this, 3));
        this.goalSelector.addGoal(3, new PhaseBasedMysticalAttackGoal(this, 5));

        this.goalSelector.addGoal(4, new OpenDoorGoal(this, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0d));
        this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MonsterEntity.createMonsterAttributes()
                .add(Attributes.ATTACK_DAMAGE, 35.0D)
                .add(Attributes.MAX_HEALTH, 1000.0D)
                .add(Attributes.FOLLOW_RANGE, 40.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.0d)
                .add(Attributes.ARMOR, 15.0D);
    }

    @Override
    public void startSeenByPlayer(ServerPlayerEntity p_184178_1_) {
        super.startSeenByPlayer(p_184178_1_);
        bossEvent.addPlayer(p_184178_1_);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayerEntity p_184203_1_) {
        super.stopSeenByPlayer(p_184203_1_);
        bossEvent.removePlayer(p_184203_1_);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setPercent(this.getHealth() / this.getMaxHealth());
        if (getHealth() < 700f && Phase == 1) {
            Phase = 2;
            setHealth(1000f);
            setAbsorptionAmount(10f);
        }
        if (getHealth() < 500f && Phase == 2) {
            Phase = 3;
            setHealth(600f);
            setAbsorptionAmount(25f);
        }
        if (getHealth() < 400f && Phase == 3) {
            Phase = 4;
            setHealth(600f);
            setAbsorptionAmount(30f);
        }
        if (getHealth() < 200f && Phase == 4) {
            Phase = 5;
            setHealth(500f);
            setAbsorptionAmount(50f);
        }
    }

    @Override
    protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
        return 0;
    }

    @Override
    public int getPhase() {
        return this.Phase;
    }
}
