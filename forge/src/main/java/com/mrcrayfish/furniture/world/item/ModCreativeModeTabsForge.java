package com.mrcrayfish.furniture.world.item;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabsForge {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MrCrayFishFurnitureMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CFM =
            CREATIVE_TABS.register(MrCrayFishFurnitureMod.MOD_ID, () -> ModCreativeModeTabs.createTabBuilder().build());
}