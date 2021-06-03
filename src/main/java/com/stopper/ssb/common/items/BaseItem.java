package com.stopper.ssb.common.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BaseItem extends Item {
    String g_name;
    String g_tooltip;

    public BaseItem(String name, String tooltip, Properties builder) {
        super(builder);
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
