package com.nosiphus.furniture.core;

import com.nosiphus.furniture.client.menu.*;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "nfm");

    public static final RegistryObject<MenuType<MicrowaveMenu>> MICROWAVE_MENU = registerMenuType((ID, inventory, extraData) -> new MicrowaveMenu(ID, inventory), "microwave_menu");
    public static final RegistryObject<MenuType<OvenMenu>> OVEN_MENU = registerMenuType((ID, inventory, extraData) -> new OvenMenu(ID, inventory), "oven_menu");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENU_TYPES.register(name, () -> IForgeMenuType.create(factory));
    }

}
