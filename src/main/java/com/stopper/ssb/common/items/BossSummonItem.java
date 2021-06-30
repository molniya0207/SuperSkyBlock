package com.stopper.ssb.common.items;

import com.stopper.ssb.SuperSkyBlock;
import com.stopper.ssb.common.utils.Registration;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.tileentity.MobSpawnerTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class BossSummonItem extends BaseItem {
    int ID;

    public BossSummonItem(String name, String tooltip, int id, Properties builder) {
        super(name, tooltip, builder);
        this.ID = id;
    }

    @Override
    public ActionResultType useOn(ItemUseContext ctx) {
        World world = ctx.getLevel();
        if (!(world instanceof ServerWorld)) {
            return ActionResultType.SUCCESS;
        } else {
            if (this.ID == 0) {
                SuperSkyBlock.registration.CLOWNTRADER_ENTITY_UNREG.spawn((ServerWorld)world, null, null, null, ctx.getClickedPos().above(), SpawnReason.TRIGGERED, true, true);
            }
            if (this.ID == 1) {
                SuperSkyBlock.registration.CLOWNBOSS_ENTITY_UNREG.spawn((ServerWorld)world, null, null, null, ctx.getClickedPos().above(), SpawnReason.TRIGGERED, true, true);
            }
            if (this.ID == 2) {
                SuperSkyBlock.registration.KILLERHANG_ENTITY_UNREG.spawn((ServerWorld)world, null, null, null, ctx.getClickedPos().above(), SpawnReason.TRIGGERED, true, true);
            }
            if (this.ID == 3) {
                ctx.getPlayer().hurt(DamageSource.CACTUS, 2f);
                SuperSkyBlock.registration.DEVILBOSS_ENTITY_UNREG.spawn((ServerWorld)world, null, null, null, ctx.getClickedPos().above(), SpawnReason.TRIGGERED, true, true);
            }
            ctx.getItemInHand().shrink(1);
            return ActionResultType.CONSUME;
        }
    }
}
