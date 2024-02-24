package com.nosiphus.furniture.core;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "nfm");

    //Tools
    public static final RegistryObject<Item> KNIFE = register("knife",
            () -> new SwordItem(Tiers.STONE, 3, -2.4F, (new Item.Properties().tab(NosiphusFurnitureMod.GROUP))));
    public static final RegistryObject<Item> SOAP = register("soap",
            () -> new Item(new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<Item> SOAPY_WATER = register("soapy_water",
            () -> new Item(new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<Item> SUPER_SOAPY_WATER = register("super_soapy_water",
            () -> new Item(new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Methods
    private static RegistryObject<Item> register(String name, Supplier<Item> item)
    {
        return ITEMS.register(name, item);
    }

}
