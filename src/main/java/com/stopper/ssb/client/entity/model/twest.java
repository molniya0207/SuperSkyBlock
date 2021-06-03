package com.stopper.ssb.client.entity.model;

// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.stopper.ssb.common.entities.ClownBoss;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class twest extends EntityModel<ClownBoss> {
	private final ModelRenderer bb_main;

	public twest() {
		bb_main = new ModelRenderer(this);
		bb_main.addBox(-6.0F, -32.0F, -9.0F, 12.0F, 32.0F, 18.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(ClownBoss p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		return;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}