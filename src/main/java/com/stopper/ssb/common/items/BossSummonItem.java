package com.stopper.ssb.common.items;

import com.stopper.ssb.SuperSkyBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;

public class BossSummonItem extends BaseItem {
    EntityType<?> type;

    public BossSummonItem(String name, String tooltip, EntityType<?> type, Properties builder) {
        super(name, tooltip, builder);
        this.type = type;
    }

    @Override
    public ActionResultType useOn(ItemUseContext ctx) {
        this.type.spawn(ctx.getLevel().getServer().overworld(), null, null, ctx.getClickedPos().above(), SpawnReason.TRIGGERED, true, true);
        ctx.getItemInHand().shrink(1);
        return super.useOn(ctx);
    }
}
