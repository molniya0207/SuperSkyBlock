package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.utils.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;

public class DiamondAnvilTile extends TileEntity {
    public DiamondAnvilTile() {
        super(SuperSkyBlock.registration.DIAMOND_ANVIL_TILE.get());
    }

    public void onUse(PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        if (itemStack.getItem() == SuperSkyBlock.registration.CUSTOM_GENERATOR_ITEM.get()) {
            itemStack.shrink(1);
            playerIn.addItem(createItemStackFromItem(SuperSkyBlock.registration.CUSTOM2_GENERATOR_ITEM.get(), 1));
            playerIn.setItemInHand(handIn, itemStack);
        }
    }

    public ItemStack createItemStackFromItem(Item item, int count) {
        return new ItemStack(item, count);
    }

    public void onGive(PlayerEntity playerIn, Hand handIn) {
        return;
    }
}
