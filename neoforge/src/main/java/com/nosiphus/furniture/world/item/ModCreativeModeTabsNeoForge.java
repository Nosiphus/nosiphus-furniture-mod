package com.nosiphus.furniture.world.item;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabsNeoForge {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NosiphusFurnitureMod.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NFM =
            CREATIVE_TABS.register(NosiphusFurnitureMod.MOD_ID, () -> ModCreativeModeTabs.createTabBuilder().build());
}