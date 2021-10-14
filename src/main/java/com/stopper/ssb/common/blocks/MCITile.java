package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;

public class MCITile extends TileEntity {
    public MCITile() {
        super(SuperSkyBlock.registration.MCI_TILE.get());
    }

    public void onUse(PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = playerIn.getMainHandItem();
        ItemStack itemStackOff = playerIn.getOffhandItem();
        if (itemStack.getItem() == SuperSkyBlock.registration.BOSSESSENCE3_ITEM.get() && itemStack.getCount() >= 18 &&
                itemStackOff.getItem() == SuperSkyBlock.registration.RAINBOWSTONE_ITEM.get()) {
            itemStack.shrink(18);
            itemStackOff.shrink(18);
            playerIn.addItem(createItemStackFromItem(SuperSkyBlock.registration.CATALYZER_ITEM.get(), 1));
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
