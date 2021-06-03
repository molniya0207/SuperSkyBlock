package com.stopper.ssb.common.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ClownSpawn extends BaseItem {
    public ClownSpawn(String name, String tooltip, Properties builder) {
        super(name, tooltip, builder);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        worldIn.playLocalSound(playerIn.getX(), playerIn.getY(), playerIn.getZ(), SoundEvents.WITHER_SPAWN, SoundCategory.HOSTILE, 1f, 0f, false);

        ItemStack toDestroy = playerIn.getItemInHand(handIn);
        if (toDestroy.getCount() <= 0) {
            playerIn.setItemInHand(handIn, ItemStack.EMPTY);
        } else {
            toDestroy.setCount(toDestroy.getCount() - 1);
            playerIn.setItemInHand(handIn, toDestroy);
        }
        return ActionResult.consume(ItemStack.EMPTY);
    }
}
