package com.stopper.ssb.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FireDust extends BaseItem {
    public FireDust(String name, String tooltip, Properties builder) {
        super(name, tooltip, builder);
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }

    @Override
    public void inventoryTick(ItemStack p_77663_1_, World p_77663_2_, Entity entity, int p_77663_4_, boolean p_77663_5_) {
        super.inventoryTick(p_77663_1_, p_77663_2_, entity, p_77663_4_, p_77663_5_);
        entity.setRemainingFireTicks(100);
    }
}
