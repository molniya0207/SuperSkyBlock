package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.utils.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;

public class DustGeneratorTile extends BaseGeneratorTile implements ITickableTileEntity {
    public DustGeneratorTile() {
        super(SuperSkyBlock.registration.DUST_GENERATOR_TILE.get());
        this.requiredCounter = 30;
    }

    public void onGive(PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = new ItemStack(SuperSkyBlock.registration.GREENSTONE_ITEM.get());
        stack.setCount(1);
        playerIn.addItem(stack);
    }
}
