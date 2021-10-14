package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;

public class Molecular2Tile extends TileEntity {
    public Molecular2Tile() {
        super(SuperSkyBlock.registration.MOLECULAR_II_TILE.get());
    }

    public void onUse(PlayerEntity playerIn, Hand handIn) {
        ItemStack itemStack = playerIn.getItemInHand(handIn);
        if (itemStack.getItem() == Items.IRON_BLOCK) {
            itemStack.shrink(1);
            playerIn.addItem(createItemStackFromItem(Items.GOLD_INGOT, 1));
            playerIn.setItemInHand(handIn, itemStack);
        }
        if (itemStack.getItem() == Items.DIAMOND_BLOCK) {
            itemStack.shrink(1);
            playerIn.addItem(createItemStackFromItem(SuperSkyBlock.registration.FIRESTONE_ITEM.get(), 1));
            playerIn.setItemInHand(handIn, itemStack);
        }
        if (itemStack.getItem() == SuperSkyBlock.registration.BOSSESSENCE4_ITEM.get() && itemStack.getCount() >= 18) {
            itemStack.shrink(18);
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
