package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.utils.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;

public class ExchangerBlockTile extends TileEntity {
    public ExchangerBlockTile() {
        super(SuperSkyBlock.registration.EXCHANGER_TILE.get());
    }

    public void onUse(PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        if (itemStack.getItem() == SuperSkyBlock.registration.GOLDENCOIN_ITEM.get()) {
            itemStack.shrink(1);
            playerIn.addItem(createItemStackFromItem(SuperSkyBlock.registration.SILVERCOIN_ITEM.get(), 10));
            playerIn.setItemInHand(handIn, itemStack);
        }
        if (itemStack.getItem() == SuperSkyBlock.registration.SILVERCOIN_ITEM.get() && itemStack.getCount() >= 10) {
            itemStack.shrink(10);
            playerIn.addItem(createItemStackFromItem(SuperSkyBlock.registration.GOLDENCOIN_ITEM.get(), 1));
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
