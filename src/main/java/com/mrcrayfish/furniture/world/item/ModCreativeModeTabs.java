package com.mrcrayfish.furniture.world.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "cfm");

    public static final List<Supplier<? extends ItemLike>> MOD_TAB_ITEMS = new ArrayList<>();

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CFM = CREATIVE_TABS.register("cfm",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.cfm"))
                    .icon(ModItems.OAK_TABLE.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                            MOD_TAB_ITEMS.forEach(itemLike -> output.accept(itemLike.get())))
                    .build()
    );

    public static <T extends Item> DeferredItem<T> addToTab(DeferredItem<T> itemLike) {
        MOD_TAB_ITEMS.add(itemLike);
        return itemLike;
    }

}
