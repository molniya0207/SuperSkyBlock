package com.stopper.ssb.common.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class MCIBlock extends BaseBlock {
    public MCIBlock(Properties props) {
        super(props);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new Molecular1Tile();
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity playerIn, Hand handIn, BlockRayTraceResult rtRes) {
        if (!worldIn.isClientSide) {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof MCITile) {
                ((MCITile) tileEntity).onUse(playerIn, handIn);
            }
        }
        return ActionResultType.SUCCESS;
    }
}
