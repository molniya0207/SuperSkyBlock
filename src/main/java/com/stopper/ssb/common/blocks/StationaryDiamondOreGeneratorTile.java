package com.stopper.ssb.common.blocks;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;

public class StationaryDiamondOreGeneratorTile extends TileEntity implements ITickableTileEntity {
    public StationaryDiamondOreGeneratorTile() {
        super(SuperSkyBlock.STATIONARY_DIAMOND_ORE_GENERATOR_TILE.get());
    }

    @Override
    public void tick() {
        if (getLevel().isClientSide) return;
        if (getLevel().isEmptyBlock(getBlockPos().above())) {
            BlockState oldBlockState = getLevel().getBlockState(getBlockPos().above());
            getLevel().setBlock(getBlockPos().above(), Blocks.DIAMOND_ORE.defaultBlockState(), 3);
            //getLevel().markAndNotifyBlock(getBlockPos().above(), null, oldBlockState, Blocks.DIAMOND_ORE.defaultBlockState(), 0, 512);
        }
    }
}
