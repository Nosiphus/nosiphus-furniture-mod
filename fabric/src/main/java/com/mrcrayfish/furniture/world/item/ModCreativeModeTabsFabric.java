package com.mrcrayfish.furniture.world.item;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

public class ModCreativeModeTabsFabric {

    public static CreativeModeTab CFM;

    public static void register() {
        CFM = Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, MrCrayFishFurnitureMod.MOD_ID),
                ModCreativeModeTabs.createTabBuilder().build()
        );
    }

}