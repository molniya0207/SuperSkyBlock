package com.stopper.ssb.common.entities;

import com.stopper.ssb.common.utils.Registration;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class ClownTrader extends AbstractVillagerEntity {
    public ClownTrader(EntityType<? extends AbstractVillagerEntity> entity, World world) {
        super(entity, world);
    }

    @Override
    protected void rewardTradeXp(MerchantOffer offer) {
        if (offer.shouldRewardExp()) {
            int i = 3 + this.random.nextInt(4);
            this.level.addFreshEntity(new ExperienceOrbEntity(this.level, this.getX(), this.getY() + 0.5D, this.getZ(), i));
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(4, new OpenDoorGoal(this, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.8d));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
    }

    @Override
    protected void updateTrades() {
        MerchantOffers merchantoffers = this.getOffers();
        if (!merchantoffers.isEmpty()) {
            merchantoffers.clear();
        }
        ArrayList<MerchantOffer> offerList = new ArrayList<>();
        // IS 1 | IS 2 -> IS 3 (RESULT) || USES MAXUSES XP MULT DEMAND
        offerList.add(new MerchantOffer(createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 2), createItemStackFromItem(Registration.SILVERCOIN_ITEM.get(), 7), createItemStackFromItem(Registration.HANGJAW_ITEM.get(), 1), 0, 99999, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 1), ItemStack.EMPTY, createItemStackFromItem(Items.WATER_BUCKET, 1), 0, 99999, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 1), ItemStack.EMPTY, createItemStackFromItem(Items.BONE_BLOCK, 2), 0, 99999, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 1), ItemStack.EMPTY, createItemStackFromItem(Items.GRASS_BLOCK, 4), 0, 99999, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 1), ItemStack.EMPTY, createItemStackFromItem(Items.REDSTONE, 32), 0, 99999, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 1), ItemStack.EMPTY, createItemStackFromItem(Items.MELON_SLICE, 32), 0, 99999, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 16), createItemStackFromItem(Items.DIAMOND_PICKAXE, 1), createItemStackWithEnchantmentsEF(Items.DIAMOND_PICKAXE, 1), 0, 3, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 64), ItemStack.EMPTY, createItemStackFromItem(Registration.ULTIMATE_HANGKATANA_ITEM.get(), 1), 0, 3, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Items.WHEAT, 32), ItemStack.EMPTY, createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 1), 0, 99999, 3, 0, 0));
        offerList.add(new MerchantOffer(createItemStackFromItem(Items.MELON_SLICE, 64), ItemStack.EMPTY, createItemStackFromItem(Registration.GOLDENCOIN_ITEM.get(), 1), 0, 99999, 3, 0, 0));
        for (int i = 0; i < offerList.size(); i++) {
            MerchantOffer merchantoffer = offerList.get(i);
            if (merchantoffer != null) {
                merchantoffers.add(merchantoffer);
            }
        }
    }

    public ItemStack createItemStackFromItem(Item item, int count) {
        return new ItemStack(item, count);
    }
    public ItemStack createItemStackWithEnchantmentsEF(Item item, int count) {
        ItemStack itemStack = new ItemStack(item, count);
        itemStack.enchant(Enchantments.BLOCK_EFFICIENCY, 3);
        itemStack.enchant(Enchantments.BLOCK_FORTUNE, 2);
        return itemStack;
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    public ActionResultType mobInteract(PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getItemInHand(handIn);
        if (itemstack.getItem() != Items.VILLAGER_SPAWN_EGG && this.isAlive() && !this.isTrading() && !this.isBaby()) {
            if (handIn == Hand.MAIN_HAND) {
                playerIn.awardStat(Stats.TALKED_TO_VILLAGER);
            }

            if (this.getOffers().isEmpty()) {
                return ActionResultType.sidedSuccess(this.level.isClientSide);
            } else {
                if (!this.level.isClientSide) {
                    this.setTradingPlayer(playerIn);
                    this.openTradingScreen(playerIn, this.getDisplayName(), 1);
                }

                return ActionResultType.sidedSuccess(this.level.isClientSide);
            }
        } else {
            return super.mobInteract(playerIn, handIn);
        }
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("entity.ssb.clowntrader");
    }

    public boolean removeWhenFarAway(double distance) {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return this.isTrading() ? SoundEvents.WANDERING_TRADER_TRADE : SoundEvents.WANDERING_TRADER_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return SoundEvents.WANDERING_TRADER_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.WANDERING_TRADER_DEATH;
    }

    protected SoundEvent getTradeUpdatedSound(boolean result) {
        return result ? SoundEvents.WANDERING_TRADER_YES : SoundEvents.WANDERING_TRADER_NO;
    }

    public SoundEvent getNotifyTradeSound() {
        return SoundEvents.WANDERING_TRADER_YES;
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return CreatureEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.ARMOR, 15.0D)
                .add(Attributes.MOVEMENT_SPEED, 1.0D)
                .add(Attributes.FOLLOW_RANGE, 24.0D);
    }
}
