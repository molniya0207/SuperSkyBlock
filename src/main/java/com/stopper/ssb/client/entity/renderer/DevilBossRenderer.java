package com.stopper.ssb.client.entity.renderer;

import com.stopper.ssb.client.entity.model.DevilBossModel;
import com.stopper.ssb.client.entity.model.HangModel;
import com.stopper.ssb.common.entities.DevilBoss;
import com.stopper.ssb.common.entities.KillerHangBoss;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class DevilBossRenderer extends MobRenderer<DevilBoss, DevilBossModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("ssb", "textures/entities/devil.png");

    public DevilBossRenderer(EntityRendererManager manager) {
        super(manager, new DevilBossModel(), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(DevilBoss p_110775_1_) {
        return TEXTURE;
    }
}
