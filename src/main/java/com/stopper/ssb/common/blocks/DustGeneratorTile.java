package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;

public class DustGeneratorTile extends BaseGeneratorTile implements ITickableTileEntity {
    public DustGeneratorTile() {
        super(SuperSkyBlock.DUST_GENERATOR_TILE.get());
        this.requiredCounter = 30;
    }

    public void onGive(PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = new ItemStack(SuperSkyBlock.GREENSTONE_ITEM.get());
        stack.setCount(1);
        playerIn.addItem(stack);
    }
}
