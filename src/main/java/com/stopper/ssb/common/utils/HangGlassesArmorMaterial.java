package com.stopper.ssb.common.utils;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class HangGlassesArmorMaterial implements IArmorMaterial {
    public HangGlassesArmorMaterial() {}

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return 600;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        return 7;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(SuperSkyBlock.registration.BOSSESSENCE2_ITEM.get());
    }

    @Override
    public String getName() {
        return "ssb:hangglasses";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
