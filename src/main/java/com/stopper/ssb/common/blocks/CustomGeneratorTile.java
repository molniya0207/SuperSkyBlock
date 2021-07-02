package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.utils.Registration;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.Hand;

import java.util.ArrayList;
import java.util.Random;

public class CustomGeneratorTile extends BaseGeneratorTile implements ITickableTileEntity {
    public CustomGeneratorTile() {
        super(SuperSkyBlock.registration.CUSTOM_GENERATOR_TILE.get());
        this.requiredCounter = 30;
    }

    public void onGive(PlayerEntity playerIn, Hand handIn) {
        ArrayList<ItemStack> itemStacks = new ArrayList<>();

        ItemStack stack1 = new ItemStack(Items.COBBLESTONE);
        stack1.setCount(4);
        itemStacks.add(stack1);
        itemStacks.add(stack1);
        itemStacks.add(stack1);

        ItemStack stack2 = new ItemStack(SuperSkyBlock.registration.PURPLESTONE_ITEM.get());
        stack2.setCount(2);
        itemStacks.add(stack2);
        itemStacks.add(stack2);

        ItemStack stack3 = new ItemStack(Items.DIRT);
        stack3.setCount(5);
        itemStacks.add(stack3);
        itemStacks.add(stack3);
        itemStacks.add(stack3);

        ItemStack stack4 = new ItemStack(Items.IRON_ORE);
        stack4.setCount(3);
        itemStacks.add(stack4);
        itemStacks.add(stack4);

        Random rnd = new Random();
        playerIn.addItem(itemStacks.get(rnd.nextInt(itemStacks.size())));
    }
}
