package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.utils.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;

public class RainbowGeneratorTile extends BaseGeneratorTile implements ITickableTileEntity {
    public RainbowGeneratorTile() {
        super(SuperSkyBlock.registration.RAINBOW_GENERATOR_TILE.get());
        this.requiredCounter = 30;
    }

    public void onGive(PlayerEntity playerIn, Hand handIn) {
        if (playerIn.level.getBlockState(getBlockPos().above()).getBlock().is(Blocks.WATER) && playerIn.getItemInHand(handIn).getItem() == SuperSkyBlock.registration.FIRESTONE_ITEM.get()) {
            ItemStack stack = new ItemStack(SuperSkyBlock.registration.RAINBOWSTONE_ITEM.get());
            stack.setCount(playerIn.getItemInHand(handIn).getCount());
            playerIn.setItemInHand(handIn, ItemStack.EMPTY);
            playerIn.addItem(stack);
        }
    }
}
