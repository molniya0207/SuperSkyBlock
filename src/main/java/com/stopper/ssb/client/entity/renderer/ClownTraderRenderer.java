package com.stopper.ssb.client.entity.renderer;

import com.stopper.ssb.client.entity.model.ClownTraderModel;
import com.stopper.ssb.common.entities.ClownTrader;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ClownTraderRenderer extends MobRenderer<ClownTrader, ClownTraderModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("ssb", "textures/entities/clowntrader.png");

    public ClownTraderRenderer(EntityRendererManager manager) {
        super(manager, new ClownTraderModel(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ClownTrader p_110775_1_) {
        return TEXTURE;
    }
}
