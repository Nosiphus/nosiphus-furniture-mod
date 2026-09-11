package com.nosiphus.furniture.world.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final List<Supplier<? extends ItemLike>> MOD_TAB_ITEMS = new ArrayList<>();

    public static CreativeModeTab.Builder createTabBuilder() {
        return CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup.nfm"))
                .icon(() -> new ItemStack(ModItems.WHITE_MODERN_CHAIR.get()))
                .displayItems((displayParams, output) ->
                        MOD_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get()))
                );
    }

    public static <T extends ItemLike> Supplier<T> addToTab(Supplier<T> itemLike) {
        MOD_TAB_ITEMS.add(itemLike);
        return itemLike;
    }

    public static boolean isNfmTab(CreativeModeTab tab) {
        return tab != null && tab.getDisplayName().equals(Component.translatable("itemGroup.nfm"));
    }
}