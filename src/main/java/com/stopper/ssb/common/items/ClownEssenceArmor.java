package com.stopper.ssb.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ClownEssenceArmor extends ArmorItem {
    String g_name;
    String g_tooltip;

    public ClownEssenceArmor(String name, String tooltip, IArmorMaterial mat, EquipmentSlotType slot, Properties props) {
        super(mat, slot, props);
        g_name = name;
        g_tooltip = tooltip;
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        //player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 100));
    }

    @Override
    public ITextComponent getName(ItemStack stack) {
        return new TranslationTextComponent(g_name);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> list, ITooltipFlag flags) {
        list.add(new TranslationTextComponent(g_tooltip));
    }
}
