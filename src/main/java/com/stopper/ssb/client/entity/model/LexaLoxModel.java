package com.stopper.ssb.client.entity.model;

// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.stopper.ssb.common.entities.LexaLox;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class LexaLoxModel extends EntityModel<LexaLox> {
	private final ModelRenderer bb_main;

	public LexaLoxModel() {
		bb_main = new ModelRenderer(this);
		bb_main.setTexSize(40, 25);
		bb_main.texOffs(0, 0).addBox(-4.0F, -2.0F, -6.0F, 8.0F, 1.0F, 12.0F, 0.0F, false);
		bb_main.texOffs(0, 13).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 4.0F, 8.0F, 0.0F, false);
		bb_main.texOffs(28, 13).addBox(-5.0F, -3.0F, 3.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bb_main.texOffs(28, 13).addBox(-5.0F, -3.0F, -6.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bb_main.texOffs(28, 13).addBox(4.0F, -3.0F, -6.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
		bb_main.texOffs(28, 13).addBox(4.0F, -3.0F, 3.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(LexaLox p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		matrixStack.translate(0d, 1.5d, 0d);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}