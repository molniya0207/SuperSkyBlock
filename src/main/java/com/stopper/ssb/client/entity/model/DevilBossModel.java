package com.stopper.ssb.client.entity.model;

// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.stopper.ssb.common.entities.DevilBoss;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class DevilBossModel extends EntityModel<DevilBoss> {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bb_main;

	public DevilBossModel() {
		bone = new ModelRenderer(this);
		bone.setTexSize(64, 64);
		bone.texOffs(54, 0).addBox(-7.0F, -35.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		bone.texOffs(54, 0).addBox(-6.0F, -33.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		bone.texOffs(54, 0).addBox(-5.0F, -31.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		bone.texOffs(54, 0).addBox(-4.0F, -30.0F, -1.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setTexSize(64, 64);
		bone2.texOffs(54, 0).addBox(-1.0F, -35.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		bone2.texOffs(54, 0).addBox(-2.0F, -33.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		bone2.texOffs(54, 0).addBox(-3.0F, -31.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		bone2.texOffs(54, 0).addBox(-4.0F, -30.0F, -1.0F, 2.0F, 4.0F, 3.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setTexSize(64, 64);
		bone3.texOffs(0, 0).addBox(-4.0F, -24.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bone3.texOffs(0, 0).addBox(-10.0F, -24.0F, -4.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setTexSize(64, 64);
		bb_main.texOffs(0, 58).addBox(-5.0F, -2.0F, -2.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(0, 58).addBox(2.0F, -2.0F, -2.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-5.0F, -15.0F, -2.0F, 10.0F, 13.0F, 5.0F, 0.0F, false);
		bb_main.texOffs(26, 46).addBox(-6.0F, -26.0F, -3.0F, 12.0F, 11.0F, 7.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-2.0F, -19.0F, -4.0F, 4.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(DevilBoss p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float r, float g, float b, float a) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay);
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}