package com.nosiphus.furniture.core;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "nfm");

    private static RegistryObject<Item> register(String name, Item item) {

        return ITEMS.register(name, () -> item);

    }

}
