package com.stopper.ssb.client.entity.renderer;

import com.stopper.ssb.client.entity.model.LexaLoxBossModel;
import com.stopper.ssb.client.entity.model.LexaLoxModel;
import com.stopper.ssb.common.entities.LexaLox;
import com.stopper.ssb.common.entities.LexaLoxBoss;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class LexaLoxBossRenderer extends MobRenderer<LexaLoxBoss, LexaLoxBossModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("ssb", "textures/entities/lexaloxboss.png");

    public LexaLoxBossRenderer(EntityRendererManager manager) {
        super(manager, new LexaLoxBossModel(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(LexaLoxBoss p_110775_1_) {
        return TEXTURE;
    }
}
