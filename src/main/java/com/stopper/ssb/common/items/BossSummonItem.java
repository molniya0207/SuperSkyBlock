package com.stopper.ssb.common.items;

import com.stopper.ssb.common.utils.Registration;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class BossSummonItem extends BaseItem {
    int ID;

    public BossSummonItem(String name, String tooltip, int id, Properties builder) {
        super(name, tooltip, builder);
        this.ID = id;
    }

    @Override
    public ActionResultType useOn(ItemUseContext ctx) {
        if (this.ID == 0) {
            ForgeRegistries.ENTITIES.getValue(new ResourceLocation("ssb", "clowntrader")).spawn(ctx.getLevel().getServer().overworld(), null, null, ctx.getClickedPos().above(), SpawnReason.TRIGGERED, true, true);
        }
        if (this.ID == 1) {
            ForgeRegistries.ENTITIES.getValue(new ResourceLocation("ssb", "clownboss")).spawn(ctx.getLevel().getServer().overworld(), null, null, ctx.getClickedPos().above(), SpawnReason.TRIGGERED, true, true);
        }
        if (this.ID == 2) {
            ForgeRegistries.ENTITIES.getValue(new ResourceLocation("ssb", "killerhang")).spawn(ctx.getLevel().getServer().overworld(), null, null, ctx.getClickedPos().above(), SpawnReason.TRIGGERED, true, true);
        }
        ctx.getItemInHand().shrink(1);
        return super.useOn(ctx);
    }
}
