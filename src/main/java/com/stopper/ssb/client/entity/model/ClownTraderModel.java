package com.stopper.ssb.client.entity.model;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.stopper.ssb.common.entities.ClownTrader;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ClownTraderModel extends EntityModel<ClownTrader> {
	private final ModelRenderer bb_main;

	public ClownTraderModel() {
		bb_main = new ModelRenderer(this);
		bb_main.setTexSize(64, 64);
		bb_main.texOffs(0, 60).addBox(-4.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(0, 60).addBox(2.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.texOffs(0, 0).addBox(-4.0F, -16.0F, -2.0F, 8.0F, 14.0F, 4.0F, 0.0F, false);
		bb_main.texOffs(28, 0).addBox(-5.0F, -26.0F, -4.0F, 10.0F, 10.0F, 8.0F, 0.0F, false);
		bb_main.texOffs(58, 61).addBox(-1.0F, -20.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(0, 18).addBox(-6.0F, -30.0F, -5.0F, 12.0F, 6.0F, 10.0F, 0.0F, false);
		bb_main.texOffs(60, 18).addBox(-3.0F, -23.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.texOffs(60, 18).addBox(2.0F, -23.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(ClownTrader p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		matrixStack.translate(0d, 1.5d, 0d);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}