package com.stopper.ssb.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class StationaryDiamondOreGeneratorBlock extends BaseBlock {
    public StationaryDiamondOreGeneratorBlock(Properties props) {
        super(props);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new StationaryDiamondOreGeneratorTile();
    }
}
