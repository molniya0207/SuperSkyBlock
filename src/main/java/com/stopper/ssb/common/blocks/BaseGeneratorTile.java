package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;

public class BaseGeneratorTile extends TileEntity implements ITickableTileEntity {
    public int counter = 0;
    public int requiredCounter = 30;

    public BaseGeneratorTile(TileEntityType<?> tet) {
        super(tet);
    }

    @Override
    public void tick() {
        if (level.isClientSide) return;
        if (counter != requiredCounter) {
            counter++;
        }
    }

    public void onUse(PlayerEntity playerIn, Hand handIn) {
        if (counter == requiredCounter) {
            counter = 0;
            onGive(playerIn, handIn);
        }
    }

    public void onGive(PlayerEntity playerIn, Hand handIn) {
        return;
    }
}
