package com.stopper.ssb.client.entity.renderer;

import com.stopper.ssb.client.entity.model.LexaLoxModel;
import com.stopper.ssb.client.entity.model.twest;
import com.stopper.ssb.common.entities.ClownBoss;
import com.stopper.ssb.common.entities.LexaLox;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LexaLoxRenderer extends MobRenderer<LexaLox, LexaLoxModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("ssb", "textures/entities/lexalox.png");

    public LexaLoxRenderer(EntityRendererManager manager) {
        super(manager, new LexaLoxModel(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(LexaLox p_110775_1_) {
        return TEXTURE;
    }
}
