package com.nosiphus.furniture.core;

import com.nosiphus.furniture.blockentity.BinBlockEntity;
import com.nosiphus.furniture.blockentity.DishwasherBlockEntity;
import com.nosiphus.furniture.inventory.container.BinMenu;
import com.nosiphus.furniture.inventory.container.DishwasherMenu;
import com.nosiphus.furniture.inventory.container.MicrowaveMenu;
import com.nosiphus.furniture.inventory.container.OvenMenu;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModContainers {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "nfm");

    public static final RegistryObject<MenuType<BinMenu>> BIN = register("bin", (IContainerFactory<BinMenu>) (ID, inventory, data) -> {
        BinBlockEntity binBlockEntity = (BinBlockEntity) inventory.player.level.getBlockEntity(data.readBlockPos());
        return new BinMenu(ID, inventory, binBlockEntity);
    });
    public static final RegistryObject<MenuType<DishwasherMenu>> DISHWASHER = register("dishwasher", (IContainerFactory<DishwasherMenu>) (ID, inventory, data) -> {
        DishwasherBlockEntity dishwasherBlockEntity = (DishwasherBlockEntity) inventory.player.level.getBlockEntity(data.readBlockPos());
        return new DishwasherMenu(ID, inventory, dishwasherBlockEntity);
    });
    public static final RegistryObject<MenuType<MicrowaveMenu>> MICROWAVE = registerMenuType((ID, inventory, extraData) -> new MicrowaveMenu(ID, inventory), "microwave");
    public static final RegistryObject<MenuType<OvenMenu>> OVEN = registerMenuType((ID, inventory, extraData) -> new OvenMenu(ID, inventory), "oven");

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(String key, MenuType.MenuSupplier<T> supplier) {
        MenuType<T> type = new MenuType<>(supplier);
        return CONTAINERS.register(key, () -> type);
    }

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return CONTAINERS.register(name, () -> IForgeMenuType.create(factory));
    }

}
