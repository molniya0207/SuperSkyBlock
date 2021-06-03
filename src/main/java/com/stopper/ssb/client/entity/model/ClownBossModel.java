package com.stopper.ssb.client.entity.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.stopper.ssb.common.entities.ClownBoss;
import com.stopper.ssb.common.entities.LexaLox;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ClownBossModel extends EntityModel<ClownBoss> {
	private final ModelRenderer bb_main;

	public ClownBossModel() {
		bb_main = new ModelRenderer(this);
		bb_main.setTexSize(64, 64);
		bb_main.texOffs(0, 36).addBox(-6.0F, -22.0F, -4.0F, 12.0F, 20.0F, 8.0F, 0.0F, false);
		bb_main.texOffs(0, 13).addBox(-8.0F, -34.0F, -6.0F, 16.0F, 12.0F, 12.0F, 0.0F, false);
		bb_main.texOffs(32, 0).addBox(-7.0F, -3.0F, -5.0F, 6.0F, 3.0F, 10.0F, 0.0F, false);
		bb_main.texOffs(32, 0).addBox(1.0F, -3.0F, -5.0F, 6.0F, 3.0F, 10.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-11.0F, -38.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(5.0F, -38.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(8.0F, -41.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-14.0F, -41.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-17.0F, -44.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(11.0F, -44.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(ClownBoss p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
		return;
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		matrixStack.translate(0d, 1.5d, 0d);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}