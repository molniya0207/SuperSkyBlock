package com.stopper.ssb.common.items;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseBlockItem extends BlockItem {
    String g_name;
    String g_tooltip;

    public BaseBlockItem(String name, String tooltip, Block blockIn, Properties builder) {
        super(blockIn, builder);
        g_name = name;
        g_tooltip = tooltip;
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
