package com.stopper.ssb.common.utils;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class DevilMaskArmorMaterial implements IArmorMaterial {
    public DevilMaskArmorMaterial() {}

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return 2048;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        return 12;
    }

    @Override
    public int getEnchantmentValue() {
        return 12;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_DIAMOND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(SuperSkyBlock.registration.RAINBOWSTONE_ITEM.get());
    }

    @Override
    public String getName() {
        return "ssb:devilmask";
    }

    @Override
    public float getToughness() {
        return 10;
    }

    @Override
    public float getKnockbackResistance() {
        return 80;
    }
}
