package com.stopper.ssb.common.utils;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ClownEssenceArmorMaterial implements IArmorMaterial {
    public ClownEssenceArmorMaterial() {}

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return 1000;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        if (slot == EquipmentSlotType.CHEST) {
            return 9;
        }
        if (slot == EquipmentSlotType.FEET) {
            return 5;
        }
        if (slot == EquipmentSlotType.LEGS) {
            return 8;
        }
        return 6;
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
        return Ingredient.of(SuperSkyBlock.BOSSESSENCE1_ITEM.get());
    }

    @Override
    public String getName() {
        return "ssb:clownessence";
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
