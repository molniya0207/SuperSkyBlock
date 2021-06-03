package com.stopper.ssb.common.utils;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class HangEssenceArmorMaterial implements IArmorMaterial {
    public HangEssenceArmorMaterial() {}

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return 2000;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        if (slot == EquipmentSlotType.CHEST) {
            return 12;
        }
        if (slot == EquipmentSlotType.FEET) {
            return 8;
        }
        if (slot == EquipmentSlotType.LEGS) {
            return 11;
        }
        return 9;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(SuperSkyBlock.BOSSESSENCE2_ITEM.get());
    }

    @Override
    public String getName() {
        return "ssb:hangessence";
    }

    @Override
    public float getToughness() {
        return 2;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
