package com.stopper.ssb.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class BaseTool extends ToolItem {
    String g_name;
    String g_tooltip;

    public BaseTool(String name, String tooltip, float damage, float attSpeed, IItemTier IIT, Properties props) {
        super(damage, attSpeed, IIT, Collections.emptySet(), props);
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
