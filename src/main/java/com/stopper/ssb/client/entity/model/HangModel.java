package com.stopper.ssb.client.entity.model;

// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.stopper.ssb.common.entities.KillerHangBoss;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class HangModel extends EntityModel<KillerHangBoss> {
	private final ModelRenderer bb_main;

	public HangModel() {
		bb_main = new ModelRenderer(this);
		bb_main.setTexSize(64, 64);
		bb_main.texOffs(0, 61).addBox(1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(0, 61).addBox(-2.0F, -1.0F, -1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(60, 62).addBox(-2.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(60, 62).addBox(1.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(52, 0).addBox(-2.0F, -7.0F, -1.0F, 4.0F, 5.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-2.0F, -11.0F, -1.0F, 4.0F, 4.0F, 3.0F, 0.0F, false);
		bb_main.texOffs(26, 26).addBox(2.0F, -7.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(50, 26).addBox(-4.0F, -7.0F, -1.0F, 2.0F, 2.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(32, 23).addBox(-4.0F, -7.0F, 4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(44, 31).addBox(-3.0F, -7.0F, 4.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(38, 30).addBox(-3.0F, -8.0F, 4.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(KillerHangBoss p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		matrixStack.translate(0d, 1.5d, 0d);
		matrixStack.scale(5f, 5f, 5f);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}