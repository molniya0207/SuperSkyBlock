package com.stopper.ssb.client.entity.renderer;

import com.stopper.ssb.client.entity.model.ClownBossModel;
import com.stopper.ssb.common.entities.ClownBoss;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ClownBossRenderer extends MobRenderer<ClownBoss, ClownBossModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("ssb", "textures/entities/clownboss.png");

    public ClownBossRenderer(EntityRendererManager manager) {
        super(manager, new ClownBossModel(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ClownBoss p_110775_1_) {
        return TEXTURE;
    }
}
