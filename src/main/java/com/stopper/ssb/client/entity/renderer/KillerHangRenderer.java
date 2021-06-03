package com.stopper.ssb.client.entity.renderer;

import com.stopper.ssb.client.entity.model.HangModel;
import com.stopper.ssb.common.entities.KillerHangBoss;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class KillerHangRenderer extends MobRenderer<KillerHangBoss, HangModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation("ssb", "textures/entities/hang.png");

    public KillerHangRenderer(EntityRendererManager manager) {
        super(manager, new HangModel(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(KillerHangBoss p_110775_1_) {
        return TEXTURE;
    }
}
