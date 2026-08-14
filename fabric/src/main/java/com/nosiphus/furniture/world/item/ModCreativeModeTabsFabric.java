package com.nosiphus.furniture.world.item;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeModeTabsFabric {

    public static CreativeModeTab NFM;

    public static void register() {
        NFM = Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, NosiphusFurnitureMod.MOD_ID),
                ModCreativeModeTabs.createTabBuilder().build()
        );
    }

}