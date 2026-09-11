package com.mrcrayfish.furniture.world.item;

import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

import java.util.function.Supplier;

import static com.mrcrayfish.furniture.world.item.ModCreativeModeTabs.addToTab;

public class ModItems
{

    public static void init() {

    }

    private static <T extends Item> Supplier<T> register(String name, Supplier<T> supplier)
    {
        return addToTab(Services.REGISTRY.registerItem(name, supplier));
    }

    private static <T extends Item> Supplier<T> registerOptional(String name, String requiredModId, Supplier<T> supplier)
    {
        if (Services.PLATFORM.isModLoaded(requiredModId))
        {
            return register(name, supplier);
        }
        return () -> null;
    }

    // Tables
    public static final Supplier<Item> OAK_TABLE = register("oak_table",
            () -> new BlockItem(ModBlocks.OAK_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_TABLE = register("spruce_table",
            () -> new BlockItem(ModBlocks.SPRUCE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_TABLE = register("birch_table",
            () -> new BlockItem(ModBlocks.BIRCH_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_TABLE = register("jungle_table",
            () -> new BlockItem(ModBlocks.JUNGLE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_TABLE = register("acacia_table",
            () -> new BlockItem(ModBlocks.ACACIA_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_TABLE = register("dark_oak_table",
            () -> new BlockItem(ModBlocks.DARK_OAK_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_TABLE = register("mangrove_table",
            () -> new BlockItem(ModBlocks.MANGROVE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_TABLE = register("cherry_table",
            () -> new BlockItem(ModBlocks.CHERRY_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_TABLE = register("crimson_table",
            () -> new BlockItem(ModBlocks.CRIMSON_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_TABLE = register("warped_table",
            () -> new BlockItem(ModBlocks.WARPED_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_TABLE = register("stripped_oak_table",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_TABLE = register("stripped_spruce_table",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_TABLE = register("stripped_birch_table",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_TABLE = register("stripped_jungle_table",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_TABLE = register("stripped_acacia_table",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_TABLE = register("stripped_dark_oak_table",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_TABLE = register("stripped_mangrove_table",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_TABLE = register("stripped_cherry_table",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_TABLE = register("stripped_crimson_table",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_TABLE = register("stripped_warped_table",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_TABLE.get(), new Item.Properties()));

    // Chairs
    public static final Supplier<Item> OAK_CHAIR = register("oak_chair",
            () -> new BlockItem(ModBlocks.OAK_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_CHAIR = register("spruce_chair",
            () -> new BlockItem(ModBlocks.SPRUCE_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_CHAIR = register("birch_chair",
            () -> new BlockItem(ModBlocks.BIRCH_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_CHAIR = register("jungle_chair",
            () -> new BlockItem(ModBlocks.JUNGLE_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_CHAIR = register("acacia_chair",
            () -> new BlockItem(ModBlocks.ACACIA_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_CHAIR = register("dark_oak_chair",
            () -> new BlockItem(ModBlocks.DARK_OAK_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_CHAIR = register("mangrove_chair",
            () -> new BlockItem(ModBlocks.MANGROVE_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_CHAIR = register("cherry_chair",
            () -> new BlockItem(ModBlocks.CHERRY_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_CHAIR = register("crimson_chair",
            () -> new BlockItem(ModBlocks.CRIMSON_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_CHAIR = register("warped_chair",
            () -> new BlockItem(ModBlocks.WARPED_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_CHAIR = register("stripped_oak_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_CHAIR = register("stripped_spruce_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_CHAIR = register("stripped_birch_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_CHAIR = register("stripped_jungle_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_CHAIR = register("stripped_acacia_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_CHAIR = register("stripped_dark_oak_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_CHAIR = register("stripped_mangrove_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_CHAIR = register("stripped_cherry_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_CHAIR = register("stripped_crimson_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_CHAIR.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_CHAIR = register("stripped_warped_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_CHAIR.get(), new Item.Properties()));

    // Coffee Tables
    public static final Supplier<Item> OAK_COFFEE_TABLE = register("oak_coffee_table",
            () -> new BlockItem(ModBlocks.OAK_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_COFFEE_TABLE = register("spruce_coffee_table",
            () -> new BlockItem(ModBlocks.SPRUCE_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_COFFEE_TABLE = register("birch_coffee_table",
            () -> new BlockItem(ModBlocks.BIRCH_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_COFFEE_TABLE = register("jungle_coffee_table",
            () -> new BlockItem(ModBlocks.JUNGLE_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_COFFEE_TABLE = register("acacia_coffee_table",
            () -> new BlockItem(ModBlocks.ACACIA_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_COFFEE_TABLE = register("dark_oak_coffee_table",
            () -> new BlockItem(ModBlocks.DARK_OAK_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_COFFEE_TABLE = register("mangrove_coffee_table",
            () -> new BlockItem(ModBlocks.MANGROVE_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_COFFEE_TABLE = register("cherry_coffee_table",
            () -> new BlockItem(ModBlocks.CHERRY_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_COFFEE_TABLE = register("crimson_coffee_table",
            () -> new BlockItem(ModBlocks.CRIMSON_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_COFFEE_TABLE = register("warped_coffee_table",
            () -> new BlockItem(ModBlocks.WARPED_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_COFFEE_TABLE = register("stripped_oak_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_COFFEE_TABLE = register("stripped_spruce_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_COFFEE_TABLE = register("stripped_birch_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_COFFEE_TABLE = register("stripped_jungle_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_COFFEE_TABLE = register("stripped_acacia_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_COFFEE_TABLE = register("stripped_dark_oak_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_COFFEE_TABLE = register("stripped_mangrove_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_COFFEE_TABLE = register("stripped_cherry_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_COFFEE_TABLE = register("stripped_crimson_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_COFFEE_TABLE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_COFFEE_TABLE = register("stripped_warped_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_COFFEE_TABLE.get(), new Item.Properties()));

    // Cabinets
    public static final Supplier<Item> OAK_CABINET = register("oak_cabinet",
            () -> new BlockItem(ModBlocks.OAK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_CABINET = register("spruce_cabinet",
            () -> new BlockItem(ModBlocks.SPRUCE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_CABINET = register("birch_cabinet",
            () -> new BlockItem(ModBlocks.BIRCH_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_CABINET = register("jungle_cabinet",
            () -> new BlockItem(ModBlocks.JUNGLE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_CABINET = register("acacia_cabinet",
            () -> new BlockItem(ModBlocks.ACACIA_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_CABINET = register("dark_oak_cabinet",
            () -> new BlockItem(ModBlocks.DARK_OAK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_CABINET = register("mangrove_cabinet",
            () -> new BlockItem(ModBlocks.MANGROVE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_CABINET = register("cherry_cabinet",
            () -> new BlockItem(ModBlocks.CHERRY_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_CABINET = register("crimson_cabinet",
            () -> new BlockItem(ModBlocks.CRIMSON_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_CABINET = register("warped_cabinet",
            () -> new BlockItem(ModBlocks.WARPED_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_CABINET = register("stripped_oak_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_CABINET = register("stripped_spruce_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_CABINET = register("stripped_birch_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_CABINET = register("stripped_jungle_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_CABINET = register("stripped_acacia_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_CABINET = register("stripped_dark_oak_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_CABINET = register("stripped_mangrove_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_CABINET = register("stripped_cherry_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_CABINET = register("stripped_crimson_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_CABINET = register("stripped_warped_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_CABINET.get(), new Item.Properties()));

    // Bedside Cabinets
    public static final Supplier<Item> OAK_BEDSIDE_CABINET = register("oak_bedside_cabinet",
            () -> new BlockItem(ModBlocks.OAK_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_BEDSIDE_CABINET = register("spruce_bedside_cabinet",
            () -> new BlockItem(ModBlocks.SPRUCE_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_BEDSIDE_CABINET = register("birch_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BIRCH_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_BEDSIDE_CABINET = register("jungle_bedside_cabinet",
            () -> new BlockItem(ModBlocks.JUNGLE_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_BEDSIDE_CABINET = register("acacia_bedside_cabinet",
            () -> new BlockItem(ModBlocks.ACACIA_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_BEDSIDE_CABINET = register("dark_oak_bedside_cabinet",
            () -> new BlockItem(ModBlocks.DARK_OAK_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_BEDSIDE_CABINET = register("mangrove_bedside_cabinet",
            () -> new BlockItem(ModBlocks.MANGROVE_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_BEDSIDE_CABINET = register("cherry_bedside_cabinet",
            () -> new BlockItem(ModBlocks.CHERRY_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_BEDSIDE_CABINET = register("crimson_bedside_cabinet",
            () -> new BlockItem(ModBlocks.CRIMSON_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_BEDSIDE_CABINET = register("warped_bedside_cabinet",
            () -> new BlockItem(ModBlocks.WARPED_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_BEDSIDE_CABINET = register("stripped_oak_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_BEDSIDE_CABINET = register("stripped_spruce_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_BEDSIDE_CABINET = register("stripped_birch_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_BEDSIDE_CABINET = register("stripped_jungle_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_BEDSIDE_CABINET = register("stripped_acacia_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_BEDSIDE_CABINET = register("stripped_dark_oak_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_BEDSIDE_CABINET = register("stripped_mangrove_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_BEDSIDE_CABINET = register("stripped_cherry_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_BEDSIDE_CABINET = register("stripped_crimson_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_BEDSIDE_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_BEDSIDE_CABINET = register("stripped_warped_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_BEDSIDE_CABINET.get(), new Item.Properties()));

    // Desks
    public static final Supplier<Item> OAK_DESK = register("oak_desk",
            () -> new BlockItem(ModBlocks.OAK_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_DESK = register("spruce_desk",
            () -> new BlockItem(ModBlocks.SPRUCE_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_DESK = register("birch_desk",
            () -> new BlockItem(ModBlocks.BIRCH_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_DESK = register("jungle_desk",
            () -> new BlockItem(ModBlocks.JUNGLE_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_DESK = register("acacia_desk",
            () -> new BlockItem(ModBlocks.ACACIA_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_DESK = register("dark_oak_desk",
            () -> new BlockItem(ModBlocks.DARK_OAK_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_DESK = register("mangrove_desk",
            () -> new BlockItem(ModBlocks.MANGROVE_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_DESK = register("cherry_desk",
            () -> new BlockItem(ModBlocks.CHERRY_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_DESK = register("crimson_desk",
            () -> new BlockItem(ModBlocks.CRIMSON_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_DESK = register("warped_desk",
            () -> new BlockItem(ModBlocks.WARPED_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_DESK = register("stripped_oak_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_DESK = register("stripped_spruce_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_DESK = register("stripped_birch_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_DESK = register("stripped_jungle_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_DESK = register("stripped_acacia_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_DESK = register("stripped_dark_oak_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_DESK = register("stripped_mangrove_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_DESK = register("stripped_cherry_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_DESK = register("stripped_crimson_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_DESK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_DESK = register("stripped_warped_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_DESK.get(), new Item.Properties()));

    // Desk Cabinets
    public static final Supplier<Item> OAK_DESK_CABINET = register("oak_desk_cabinet",
            () -> new BlockItem(ModBlocks.OAK_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_DESK_CABINET = register("spruce_desk_cabinet",
            () -> new BlockItem(ModBlocks.SPRUCE_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_DESK_CABINET = register("birch_desk_cabinet",
            () -> new BlockItem(ModBlocks.BIRCH_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_DESK_CABINET = register("jungle_desk_cabinet",
            () -> new BlockItem(ModBlocks.JUNGLE_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_DESK_CABINET = register("acacia_desk_cabinet",
            () -> new BlockItem(ModBlocks.ACACIA_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_DESK_CABINET = register("dark_oak_desk_cabinet",
            () -> new BlockItem(ModBlocks.DARK_OAK_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_DESK_CABINET = register("mangrove_desk_cabinet",
            () -> new BlockItem(ModBlocks.MANGROVE_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_DESK_CABINET = register("cherry_desk_cabinet",
            () -> new BlockItem(ModBlocks.CHERRY_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_DESK_CABINET = register("crimson_desk_cabinet",
            () -> new BlockItem(ModBlocks.CRIMSON_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_DESK_CABINET = register("warped_desk_cabinet",
            () -> new BlockItem(ModBlocks.WARPED_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_DESK_CABINET = register("stripped_oak_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_DESK_CABINET = register("stripped_spruce_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_DESK_CABINET = register("stripped_birch_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_DESK_CABINET = register("stripped_jungle_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_DESK_CABINET = register("stripped_acacia_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_DESK_CABINET = register("stripped_dark_oak_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_DESK_CABINET = register("stripped_mangrove_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_DESK_CABINET = register("stripped_cherry_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_DESK_CABINET = register("stripped_crimson_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_DESK_CABINET.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_DESK_CABINET = register("stripped_warped_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_DESK_CABINET.get(), new Item.Properties()));

    // Sofas
    public static final Supplier<Item> WHITE_SOFA = register("white_sofa",
            () -> new BlockItem(ModBlocks.WHITE_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_SOFA = register("light_gray_sofa",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_SOFA = register("gray_sofa",
            () -> new BlockItem(ModBlocks.GRAY_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_SOFA = register("black_sofa",
            () -> new BlockItem(ModBlocks.BLACK_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_SOFA = register("brown_sofa",
            () -> new BlockItem(ModBlocks.BROWN_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> RED_SOFA = register("red_sofa",
            () -> new BlockItem(ModBlocks.RED_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_SOFA = register("orange_sofa",
            () -> new BlockItem(ModBlocks.ORANGE_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_SOFA = registerOptional("beige_sofa", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_SOFA = register("yellow_sofa",
            () -> new BlockItem(ModBlocks.YELLOW_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_SOFA = register("lime_sofa",
            () -> new BlockItem(ModBlocks.LIME_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_SOFA = register("green_sofa",
            () -> new BlockItem(ModBlocks.GREEN_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_SOFA = register("cyan_sofa",
            () -> new BlockItem(ModBlocks.CYAN_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_SOFA = register("light_blue_sofa",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_SOFA = register("blue_sofa",
            () -> new BlockItem(ModBlocks.BLUE_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_SOFA = register("purple_sofa",
            () -> new BlockItem(ModBlocks.PURPLE_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_SOFA = register("magenta_sofa",
            () -> new BlockItem(ModBlocks.MAGENTA_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_SOFA = register("pink_sofa",
            () -> new BlockItem(ModBlocks.PINK_SOFA.get(), new Item.Properties()));
    public static final Supplier<Item> RAINBOW_SOFA = register("rainbow_sofa",
            () -> new BlockItem(ModBlocks.RAINBOW_SOFA.get(), new Item.Properties()));

    // Blinds
    public static final Supplier<Item> OAK_BLINDS = register("oak_blinds",
            () -> new BlockItem(ModBlocks.OAK_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_BLINDS = register("spruce_blinds",
            () -> new BlockItem(ModBlocks.SPRUCE_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_BLINDS = register("birch_blinds",
            () -> new BlockItem(ModBlocks.BIRCH_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_BLINDS = register("jungle_blinds",
            () -> new BlockItem(ModBlocks.JUNGLE_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_BLINDS = register("acacia_blinds",
            () -> new BlockItem(ModBlocks.ACACIA_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_BLINDS = register("dark_oak_blinds",
            () -> new BlockItem(ModBlocks.DARK_OAK_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_BLINDS = register("mangrove_blinds",
            () -> new BlockItem(ModBlocks.MANGROVE_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_BLINDS = register("cherry_blinds",
            () -> new BlockItem(ModBlocks.CHERRY_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_BLINDS = register("crimson_blinds",
            () -> new BlockItem(ModBlocks.CRIMSON_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_BLINDS = register("warped_blinds",
            () -> new BlockItem(ModBlocks.WARPED_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_BLINDS = register("stripped_oak_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_BLINDS = register("stripped_spruce_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_BLINDS = register("stripped_birch_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_BLINDS = register("stripped_jungle_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_BLINDS = register("stripped_acacia_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_BLINDS = register("stripped_dark_oak_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_BLINDS = register("stripped_mangrove_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_BLINDS = register("stripped_cherry_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_BLINDS = register("stripped_crimson_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_BLINDS.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_BLINDS = register("stripped_warped_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_BLINDS.get(), new Item.Properties()));

    // Upgraded Fences
    public static final Supplier<Item> OAK_UPGRADED_FENCE = register("oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.OAK_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_UPGRADED_FENCE = register("spruce_upgraded_fence",
            () -> new BlockItem(ModBlocks.SPRUCE_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_UPGRADED_FENCE = register("birch_upgraded_fence",
            () -> new BlockItem(ModBlocks.BIRCH_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_UPGRADED_FENCE = register("jungle_upgraded_fence",
            () -> new BlockItem(ModBlocks.JUNGLE_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_UPGRADED_FENCE = register("acacia_upgraded_fence",
            () -> new BlockItem(ModBlocks.ACACIA_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_UPGRADED_FENCE = register("dark_oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.DARK_OAK_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_UPGRADED_FENCE = register("mangrove_upgraded_fence",
            () -> new BlockItem(ModBlocks.MANGROVE_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_UPGRADED_FENCE = register("cherry_upgraded_fence",
            () -> new BlockItem(ModBlocks.CHERRY_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_UPGRADED_FENCE = register("crimson_upgraded_fence",
            () -> new BlockItem(ModBlocks.CRIMSON_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_UPGRADED_FENCE = register("warped_upgraded_fence",
            () -> new BlockItem(ModBlocks.WARPED_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_UPGRADED_FENCE = register("stripped_oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_UPGRADED_FENCE = register("stripped_spruce_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_UPGRADED_FENCE = register("stripped_birch_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_UPGRADED_FENCE = register("stripped_jungle_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_UPGRADED_FENCE = register("stripped_acacia_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_UPGRADED_FENCE = register("stripped_dark_oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_UPGRADED_FENCE = register("stripped_mangrove_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_UPGRADED_FENCE = register("stripped_cherry_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_UPGRADED_FENCE = register("stripped_crimson_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_UPGRADED_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_UPGRADED_FENCE = register("stripped_warped_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_UPGRADED_FENCE.get(), new Item.Properties()));

    // Upgraded Gates
    public static final Supplier<Item> OAK_UPGRADED_GATE = register("oak_upgraded_gate",
            () -> new BlockItem(ModBlocks.OAK_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_UPGRADED_GATE = register("spruce_upgraded_gate",
            () -> new BlockItem(ModBlocks.SPRUCE_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_UPGRADED_GATE = register("birch_upgraded_gate",
            () -> new BlockItem(ModBlocks.BIRCH_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_UPGRADED_GATE = register("jungle_upgraded_gate",
            () -> new BlockItem(ModBlocks.JUNGLE_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_UPGRADED_GATE = register("acacia_upgraded_gate",
            () -> new BlockItem(ModBlocks.ACACIA_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_UPGRADED_GATE = register("dark_oak_upgraded_gate",
            () -> new BlockItem(ModBlocks.DARK_OAK_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_UPGRADED_GATE = register("mangrove_upgraded_gate",
            () -> new BlockItem(ModBlocks.MANGROVE_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_UPGRADED_GATE = register("cherry_upgraded_gate",
            () -> new BlockItem(ModBlocks.CHERRY_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_UPGRADED_GATE = register("crimson_upgraded_gate",
            () -> new BlockItem(ModBlocks.CRIMSON_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_UPGRADED_GATE = register("warped_upgraded_gate",
            () -> new BlockItem(ModBlocks.WARPED_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_UPGRADED_GATE = register("stripped_oak_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_UPGRADED_GATE = register("stripped_spruce_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_UPGRADED_GATE = register("stripped_birch_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_UPGRADED_GATE = register("stripped_jungle_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_UPGRADED_GATE = register("stripped_acacia_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_UPGRADED_GATE = register("stripped_dark_oak_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_UPGRADED_GATE = register("stripped_mangrove_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_UPGRADED_GATE = register("stripped_cherry_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_UPGRADED_GATE = register("stripped_crimson_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_UPGRADED_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_UPGRADED_GATE = register("stripped_warped_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_UPGRADED_GATE.get(), new Item.Properties()));

    // Picket Fences
    public static final Supplier<Item> WHITE_PICKET_FENCE = register("white_picket_fence",
            () -> new BlockItem(ModBlocks.WHITE_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_PICKET_FENCE = register("light_gray_picket_fence",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_PICKET_FENCE = register("gray_picket_fence",
            () -> new BlockItem(ModBlocks.GRAY_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_PICKET_FENCE = register("black_picket_fence",
            () -> new BlockItem(ModBlocks.BLACK_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_PICKET_FENCE = register("brown_picket_fence",
            () -> new BlockItem(ModBlocks.BROWN_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> RED_PICKET_FENCE = register("red_picket_fence",
            () -> new BlockItem(ModBlocks.RED_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_PICKET_FENCE = register("orange_picket_fence",
            () -> new BlockItem(ModBlocks.ORANGE_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_PICKET_FENCE = registerOptional("beige_picket_fence", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_PICKET_FENCE = register("yellow_picket_fence",
            () -> new BlockItem(ModBlocks.YELLOW_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_PICKET_FENCE = register("lime_picket_fence",
            () -> new BlockItem(ModBlocks.LIME_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_PICKET_FENCE = register("green_picket_fence",
            () -> new BlockItem(ModBlocks.GREEN_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_PICKET_FENCE = register("cyan_picket_fence",
            () -> new BlockItem(ModBlocks.CYAN_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_PICKET_FENCE = register("light_blue_picket_fence",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_PICKET_FENCE = register("blue_picket_fence",
            () -> new BlockItem(ModBlocks.BLUE_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_PICKET_FENCE = register("purple_picket_fence",
            () -> new BlockItem(ModBlocks.PURPLE_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_PICKET_FENCE = register("magenta_picket_fence",
            () -> new BlockItem(ModBlocks.MAGENTA_PICKET_FENCE.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_PICKET_FENCE = register("pink_picket_fence",
            () -> new BlockItem(ModBlocks.PINK_PICKET_FENCE.get(), new Item.Properties()));

    // Picket Gates
    public static final Supplier<Item> WHITE_PICKET_GATE = register("white_picket_gate",
            () -> new BlockItem(ModBlocks.WHITE_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_PICKET_GATE = register("light_gray_picket_gate",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_PICKET_GATE = register("gray_picket_gate",
            () -> new BlockItem(ModBlocks.GRAY_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_PICKET_GATE = register("black_picket_gate",
            () -> new BlockItem(ModBlocks.BLACK_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_PICKET_GATE = register("brown_picket_gate",
            () -> new BlockItem(ModBlocks.BROWN_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> RED_PICKET_GATE = register("red_picket_gate",
            () -> new BlockItem(ModBlocks.RED_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_PICKET_GATE = register("orange_picket_gate",
            () -> new BlockItem(ModBlocks.ORANGE_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_PICKET_GATE = registerOptional("beige_picket_gate", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_PICKET_GATE = register("yellow_picket_gate",
            () -> new BlockItem(ModBlocks.YELLOW_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_PICKET_GATE = register("lime_picket_gate",
            () -> new BlockItem(ModBlocks.LIME_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_PICKET_GATE = register("green_picket_gate",
            () -> new BlockItem(ModBlocks.GREEN_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_PICKET_GATE = register("cyan_picket_gate",
            () -> new BlockItem(ModBlocks.CYAN_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_PICKET_GATE = register("light_blue_picket_gate",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_PICKET_GATE = register("blue_picket_gate",
            () -> new BlockItem(ModBlocks.BLUE_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_PICKET_GATE = register("purple_picket_gate",
            () -> new BlockItem(ModBlocks.PURPLE_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_PICKET_GATE = register("magenta_picket_gate",
            () -> new BlockItem(ModBlocks.MAGENTA_PICKET_GATE.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_PICKET_GATE = register("pink_picket_gate",
            () -> new BlockItem(ModBlocks.PINK_PICKET_GATE.get(), new Item.Properties()));

    // Crates
    public static final Supplier<Item> OAK_CRATE = register("oak_crate",
            () -> new BlockItem(ModBlocks.OAK_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_CRATE = register("spruce_crate",
            () -> new BlockItem(ModBlocks.SPRUCE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_CRATE = register("birch_crate",
            () -> new BlockItem(ModBlocks.BIRCH_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_CRATE = register("jungle_crate",
            () -> new BlockItem(ModBlocks.JUNGLE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_CRATE = register("acacia_crate",
            () -> new BlockItem(ModBlocks.ACACIA_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_CRATE = register("dark_oak_crate",
            () -> new BlockItem(ModBlocks.DARK_OAK_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_CRATE = register("mangrove_crate",
            () -> new BlockItem(ModBlocks.MANGROVE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_CRATE = register("cherry_crate",
            () -> new BlockItem(ModBlocks.CHERRY_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_CRATE = register("crimson_crate",
            () -> new BlockItem(ModBlocks.CRIMSON_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_CRATE = register("warped_crate",
            () -> new BlockItem(ModBlocks.WARPED_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_CRATE = register("stripped_oak_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_CRATE = register("stripped_spruce_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_CRATE = register("stripped_birch_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_CRATE = register("stripped_jungle_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_CRATE = register("stripped_acacia_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_CRATE = register("stripped_dark_oak_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_CRATE = register("stripped_mangrove_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_CRATE = register("stripped_cherry_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_CRATE = register("stripped_crimson_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_CRATE = register("stripped_warped_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_CRATE.get(), new Item.Properties()));

    // Park Benches
    public static final Supplier<Item> OAK_PARK_BENCH = register("oak_park_bench",
            () -> new BlockItem(ModBlocks.OAK_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_PARK_BENCH = register("spruce_park_bench",
            () -> new BlockItem(ModBlocks.SPRUCE_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_PARK_BENCH = register("birch_park_bench",
            () -> new BlockItem(ModBlocks.BIRCH_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_PARK_BENCH = register("jungle_park_bench",
            () -> new BlockItem(ModBlocks.JUNGLE_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_PARK_BENCH = register("acacia_park_bench",
            () -> new BlockItem(ModBlocks.ACACIA_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_PARK_BENCH = register("dark_oak_park_bench",
            () -> new BlockItem(ModBlocks.DARK_OAK_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_PARK_BENCH = register("mangrove_park_bench",
            () -> new BlockItem(ModBlocks.MANGROVE_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_PARK_BENCH = register("cherry_park_bench",
            () -> new BlockItem(ModBlocks.CHERRY_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_PARK_BENCH = register("crimson_park_bench",
            () -> new BlockItem(ModBlocks.CRIMSON_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_PARK_BENCH = register("warped_park_bench",
            () -> new BlockItem(ModBlocks.WARPED_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_PARK_BENCH = register("stripped_oak_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_PARK_BENCH = register("stripped_spruce_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_PARK_BENCH = register("stripped_birch_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_PARK_BENCH = register("stripped_jungle_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_PARK_BENCH = register("stripped_acacia_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_PARK_BENCH = register("stripped_dark_oak_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_PARK_BENCH = register("stripped_mangrove_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_PARK_BENCH = register("stripped_cherry_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_PARK_BENCH = register("stripped_crimson_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_PARK_BENCH.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_PARK_BENCH = register("stripped_warped_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_PARK_BENCH.get(), new Item.Properties()));

    // Post Box
    public static final Supplier<Item> POST_BOX = register("post_box",
            () -> new BlockItem(ModBlocks.POST_BOX.get(), new Item.Properties()));

    // Mail Boxes
    public static final Supplier<Item> OAK_MAIL_BOX = register("oak_mail_box",
            () -> new BlockItem(ModBlocks.OAK_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_MAIL_BOX = register("spruce_mail_box",
            () -> new BlockItem(ModBlocks.SPRUCE_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_MAIL_BOX = register("birch_mail_box",
            () -> new BlockItem(ModBlocks.BIRCH_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_MAIL_BOX = register("jungle_mail_box",
            () -> new BlockItem(ModBlocks.JUNGLE_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_MAIL_BOX = register("acacia_mail_box",
            () -> new BlockItem(ModBlocks.ACACIA_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_MAIL_BOX = register("dark_oak_mail_box",
            () -> new BlockItem(ModBlocks.DARK_OAK_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_MAIL_BOX = register("mangrove_mail_box",
            () -> new BlockItem(ModBlocks.MANGROVE_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_MAIL_BOX = register("cherry_mail_box",
            () -> new BlockItem(ModBlocks.CHERRY_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_MAIL_BOX = register("crimson_mail_box",
            () -> new BlockItem(ModBlocks.CRIMSON_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_MAIL_BOX = register("warped_mail_box",
            () -> new BlockItem(ModBlocks.WARPED_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_MAIL_BOX = register("stripped_oak_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_MAIL_BOX = register("stripped_spruce_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_MAIL_BOX = register("stripped_birch_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_MAIL_BOX = register("stripped_jungle_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_MAIL_BOX = register("stripped_acacia_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_MAIL_BOX = register("stripped_dark_oak_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_MAIL_BOX = register("stripped_mangrove_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_MAIL_BOX = register("stripped_cherry_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_MAIL_BOX = register("stripped_crimson_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_MAIL_BOX.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_MAIL_BOX = register("stripped_warped_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_MAIL_BOX.get(), new Item.Properties()));

    // Hedges
    public static final Supplier<Item> OAK_HEDGE = register("oak_hedge",
            () -> new BlockItem(ModBlocks.OAK_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_HEDGE = register("spruce_hedge",
            () -> new BlockItem(ModBlocks.SPRUCE_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_HEDGE = register("birch_hedge",
            () -> new BlockItem(ModBlocks.BIRCH_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_HEDGE = register("jungle_hedge",
            () -> new BlockItem(ModBlocks.JUNGLE_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_HEDGE = register("acacia_hedge",
            () -> new BlockItem(ModBlocks.ACACIA_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_HEDGE = register("dark_oak_hedge",
            () -> new BlockItem(ModBlocks.DARK_OAK_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_HEDGE = register("mangrove_hedge",
            () -> new BlockItem(ModBlocks.MANGROVE_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_HEDGE = register("cherry_hedge",
            () -> new BlockItem(ModBlocks.CHERRY_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> AZALEA_HEDGE = register("azalea_hedge",
            () -> new BlockItem(ModBlocks.AZALEA_HEDGE.get(), new Item.Properties()));
    public static final Supplier<Item> FLOWERING_AZALEA_HEDGE = register("flowering_azalea_hedge",
            () -> new BlockItem(ModBlocks.FLOWERING_AZALEA_HEDGE.get(), new Item.Properties()));

    // Rock Path
    public static final Supplier<Item> ROCK_PATH = register("rock_path",
            () -> new BlockItem(ModBlocks.ROCK_PATH.get(), new Item.Properties()));

    // Trampolines
    public static final Supplier<Item> WHITE_TRAMPOLINE = register("white_trampoline",
            () -> new BlockItem(ModBlocks.WHITE_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_TRAMPOLINE = register("light_gray_trampoline",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_TRAMPOLINE = register("gray_trampoline",
            () -> new BlockItem(ModBlocks.GRAY_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_TRAMPOLINE = register("black_trampoline",
            () -> new BlockItem(ModBlocks.BLACK_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_TRAMPOLINE = register("brown_trampoline",
            () -> new BlockItem(ModBlocks.BROWN_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> RED_TRAMPOLINE = register("red_trampoline",
            () -> new BlockItem(ModBlocks.RED_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_TRAMPOLINE = register("orange_trampoline",
            () -> new BlockItem(ModBlocks.ORANGE_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_TRAMPOLINE = registerOptional("beige_trampoline", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_TRAMPOLINE = register("yellow_trampoline",
            () -> new BlockItem(ModBlocks.YELLOW_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_TRAMPOLINE = register("lime_trampoline",
            () -> new BlockItem(ModBlocks.LIME_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_TRAMPOLINE = register("green_trampoline",
            () -> new BlockItem(ModBlocks.GREEN_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_TRAMPOLINE = register("cyan_trampoline",
            () -> new BlockItem(ModBlocks.CYAN_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_TRAMPOLINE = register("light_blue_trampoline",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_TRAMPOLINE = register("blue_trampoline",
            () -> new BlockItem(ModBlocks.BLUE_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_TRAMPOLINE = register("purple_trampoline",
            () -> new BlockItem(ModBlocks.PURPLE_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_TRAMPOLINE = register("magenta_trampoline",
            () -> new BlockItem(ModBlocks.MAGENTA_TRAMPOLINE.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_TRAMPOLINE = register("pink_trampoline",
            () -> new BlockItem(ModBlocks.PINK_TRAMPOLINE.get(), new Item.Properties()));

    // Coolers
    public static final Supplier<Item> WHITE_COOLER = register("white_cooler",
            () -> new BlockItem(ModBlocks.WHITE_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_COOLER = register("light_gray_cooler",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_COOLER = register("gray_cooler",
            () -> new BlockItem(ModBlocks.GRAY_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_COOLER = register("black_cooler",
            () -> new BlockItem(ModBlocks.BLACK_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_COOLER = register("brown_cooler",
            () -> new BlockItem(ModBlocks.BROWN_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> RED_COOLER = register("red_cooler",
            () -> new BlockItem(ModBlocks.RED_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_COOLER = register("orange_cooler",
            () -> new BlockItem(ModBlocks.ORANGE_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_COOLER = registerOptional("beige_cooler", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_COOLER = register("yellow_cooler",
            () -> new BlockItem(ModBlocks.YELLOW_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_COOLER = register("lime_cooler",
            () -> new BlockItem(ModBlocks.LIME_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_COOLER = register("green_cooler",
            () -> new BlockItem(ModBlocks.GREEN_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_COOLER = register("cyan_cooler",
            () -> new BlockItem(ModBlocks.CYAN_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_COOLER = register("light_blue_cooler",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_COOLER = register("blue_cooler",
            () -> new BlockItem(ModBlocks.BLUE_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_COOLER = register("purple_cooler",
            () -> new BlockItem(ModBlocks.PURPLE_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_COOLER = register("magenta_cooler",
            () -> new BlockItem(ModBlocks.MAGENTA_COOLER.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_COOLER = register("pink_cooler",
            () -> new BlockItem(ModBlocks.PINK_COOLER.get(), new Item.Properties()));

    // Grills
    public static final Supplier<Item> WHITE_GRILL = register("white_grill",
            () -> new BlockItem(ModBlocks.WHITE_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_GRILL = register("light_gray_grill",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_GRILL = register("gray_grill",
            () -> new BlockItem(ModBlocks.GRAY_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_GRILL = register("black_grill",
            () -> new BlockItem(ModBlocks.BLACK_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_GRILL = register("brown_grill",
            () -> new BlockItem(ModBlocks.BROWN_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> RED_GRILL = register("red_grill",
            () -> new BlockItem(ModBlocks.RED_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_GRILL = register("orange_grill",
            () -> new BlockItem(ModBlocks.ORANGE_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_GRILL = registerOptional("beige_grill", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_GRILL = register("yellow_grill",
            () -> new BlockItem(ModBlocks.YELLOW_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_GRILL = register("lime_grill",
            () -> new BlockItem(ModBlocks.LIME_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_GRILL = register("green_grill",
            () -> new BlockItem(ModBlocks.GREEN_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_GRILL = register("cyan_grill",
            () -> new BlockItem(ModBlocks.CYAN_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_GRILL = register("light_blue_grill",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_GRILL = register("blue_grill",
            () -> new BlockItem(ModBlocks.BLUE_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_GRILL = register("purple_grill",
            () -> new BlockItem(ModBlocks.PURPLE_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_GRILL = register("magenta_grill",
            () -> new BlockItem(ModBlocks.MAGENTA_GRILL.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_GRILL = register("pink_grill",
            () -> new BlockItem(ModBlocks.PINK_GRILL.get(), new Item.Properties()));

    // Door Mat
    public static final Supplier<Item> DOOR_MAT = register("door_mat",
            () -> new DoorMatItem(ModBlocks.DOOR_MAT.get(), new Item.Properties()));

    // Diving Board
    public static final Supplier<Item> DIVING_BOARD = register("diving_board",
            () -> new BlockItem(ModBlocks.DIVING_BOARD.get(), new Item.Properties()));

    // Kitchen Counters
    public static final Supplier<Item> OAK_KITCHEN_COUNTER = register("oak_kitchen_counter",
            () -> new BlockItem(ModBlocks.OAK_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_KITCHEN_COUNTER = register("spruce_kitchen_counter",
            () -> new BlockItem(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_KITCHEN_COUNTER = register("birch_kitchen_counter",
            () -> new BlockItem(ModBlocks.BIRCH_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_KITCHEN_COUNTER = register("jungle_kitchen_counter",
            () -> new BlockItem(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_KITCHEN_COUNTER = register("acacia_kitchen_counter",
            () -> new BlockItem(ModBlocks.ACACIA_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_KITCHEN_COUNTER = register("dark_oak_kitchen_counter",
            () -> new BlockItem(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_KITCHEN_COUNTER = register("mangrove_kitchen_counter",
            () -> new BlockItem(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_KITCHEN_COUNTER = register("cherry_kitchen_counter",
            () -> new BlockItem(ModBlocks.CHERRY_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_KITCHEN_COUNTER = register("crimson_kitchen_counter",
            () -> new BlockItem(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_KITCHEN_COUNTER = register("warped_kitchen_counter",
            () -> new BlockItem(ModBlocks.WARPED_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_KITCHEN_COUNTER = register("stripped_oak_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_KITCHEN_COUNTER = register("stripped_spruce_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_KITCHEN_COUNTER = register("stripped_birch_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_KITCHEN_COUNTER = register("stripped_jungle_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_KITCHEN_COUNTER = register("stripped_acacia_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_KITCHEN_COUNTER = register("stripped_dark_oak_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_KITCHEN_COUNTER = register("stripped_mangrove_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_KITCHEN_COUNTER = register("stripped_cherry_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_KITCHEN_COUNTER = register("stripped_crimson_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_KITCHEN_COUNTER = register("stripped_warped_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> WHITE_KITCHEN_COUNTER = register("white_kitchen_counter",
            () -> new BlockItem(ModBlocks.WHITE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_KITCHEN_COUNTER = register("light_gray_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_KITCHEN_COUNTER = register("gray_kitchen_counter",
            () -> new BlockItem(ModBlocks.GRAY_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_KITCHEN_COUNTER = register("black_kitchen_counter",
            () -> new BlockItem(ModBlocks.BLACK_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_KITCHEN_COUNTER = register("brown_kitchen_counter",
            () -> new BlockItem(ModBlocks.BROWN_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> RED_KITCHEN_COUNTER = register("red_kitchen_counter",
            () -> new BlockItem(ModBlocks.RED_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_KITCHEN_COUNTER = register("orange_kitchen_counter",
            () -> new BlockItem(ModBlocks.ORANGE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_KITCHEN_COUNTER = registerOptional("beige_kitchen_counter", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_KITCHEN_COUNTER = register("yellow_kitchen_counter",
            () -> new BlockItem(ModBlocks.YELLOW_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_KITCHEN_COUNTER = register("lime_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIME_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_KITCHEN_COUNTER = register("green_kitchen_counter",
            () -> new BlockItem(ModBlocks.GREEN_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_KITCHEN_COUNTER = register("cyan_kitchen_counter",
            () -> new BlockItem(ModBlocks.CYAN_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_KITCHEN_COUNTER = register("light_blue_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_KITCHEN_COUNTER = register("blue_kitchen_counter",
            () -> new BlockItem(ModBlocks.BLUE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_KITCHEN_COUNTER = register("purple_kitchen_counter",
            () -> new BlockItem(ModBlocks.PURPLE_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_KITCHEN_COUNTER = register("magenta_kitchen_counter",
            () -> new BlockItem(ModBlocks.MAGENTA_KITCHEN_COUNTER.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_KITCHEN_COUNTER = register("pink_kitchen_counter",
            () -> new BlockItem(ModBlocks.PINK_KITCHEN_COUNTER.get(), new Item.Properties()));

    // Kitchen Drawers
    public static final Supplier<Item> OAK_KITCHEN_DRAWER = register("oak_kitchen_drawer",
            () -> new BlockItem(ModBlocks.OAK_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_KITCHEN_DRAWER = register("spruce_kitchen_drawer",
            () -> new BlockItem(ModBlocks.SPRUCE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_KITCHEN_DRAWER = register("birch_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BIRCH_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_KITCHEN_DRAWER = register("jungle_kitchen_drawer",
            () -> new BlockItem(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_KITCHEN_DRAWER = register("acacia_kitchen_drawer",
            () -> new BlockItem(ModBlocks.ACACIA_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_KITCHEN_DRAWER = register("dark_oak_kitchen_drawer",
            () -> new BlockItem(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_KITCHEN_DRAWER = register("mangrove_kitchen_drawer",
            () -> new BlockItem(ModBlocks.MANGROVE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_KITCHEN_DRAWER = register("cherry_kitchen_drawer",
            () -> new BlockItem(ModBlocks.CHERRY_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_KITCHEN_DRAWER = register("crimson_kitchen_drawer",
            () -> new BlockItem(ModBlocks.CRIMSON_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_KITCHEN_DRAWER = register("warped_kitchen_drawer",
            () -> new BlockItem(ModBlocks.WARPED_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_KITCHEN_DRAWER = register("stripped_oak_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_KITCHEN_DRAWER = register("stripped_spruce_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_KITCHEN_DRAWER = register("stripped_birch_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_KITCHEN_DRAWER = register("stripped_jungle_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_KITCHEN_DRAWER = register("stripped_acacia_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_KITCHEN_DRAWER = register("stripped_dark_oak_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_KITCHEN_DRAWER = register("stripped_mangrove_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_KITCHEN_DRAWER = register("stripped_cherry_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_KITCHEN_DRAWER = register("stripped_crimson_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_KITCHEN_DRAWER = register("stripped_warped_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> WHITE_KITCHEN_DRAWER = register("white_kitchen_drawer",
            () -> new BlockItem(ModBlocks.WHITE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_KITCHEN_DRAWER = register("light_gray_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_KITCHEN_DRAWER = register("gray_kitchen_drawer",
            () -> new BlockItem(ModBlocks.GRAY_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_KITCHEN_DRAWER = register("black_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BLACK_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_KITCHEN_DRAWER = register("brown_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BROWN_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> RED_KITCHEN_DRAWER = register("red_kitchen_drawer",
            () -> new BlockItem(ModBlocks.RED_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_KITCHEN_DRAWER = register("orange_kitchen_drawer",
            () -> new BlockItem(ModBlocks.ORANGE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_KITCHEN_DRAWER = registerOptional("beige_kitchen_drawer", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_KITCHEN_DRAWER = register("yellow_kitchen_drawer",
            () -> new BlockItem(ModBlocks.YELLOW_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_KITCHEN_DRAWER = register("lime_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIME_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_KITCHEN_DRAWER = register("green_kitchen_drawer",
            () -> new BlockItem(ModBlocks.GREEN_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_KITCHEN_DRAWER = register("cyan_kitchen_drawer",
            () -> new BlockItem(ModBlocks.CYAN_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_KITCHEN_DRAWER = register("light_blue_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_KITCHEN_DRAWER = register("blue_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BLUE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_KITCHEN_DRAWER = register("purple_kitchen_drawer",
            () -> new BlockItem(ModBlocks.PURPLE_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_KITCHEN_DRAWER = register("magenta_kitchen_drawer",
            () -> new BlockItem(ModBlocks.MAGENTA_KITCHEN_DRAWER.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_KITCHEN_DRAWER = register("pink_kitchen_drawer",
            () -> new BlockItem(ModBlocks.PINK_KITCHEN_DRAWER.get(), new Item.Properties()));

    // Kitchen Sinks
    public static final Supplier<Item> OAK_KITCHEN_SINK_LIGHT = register("oak_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.OAK_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_KITCHEN_SINK_LIGHT = register("spruce_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.SPRUCE_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_KITCHEN_SINK_LIGHT = register("birch_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.BIRCH_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_KITCHEN_SINK_LIGHT = register("jungle_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.JUNGLE_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_KITCHEN_SINK_LIGHT = register("acacia_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.ACACIA_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_KITCHEN_SINK_LIGHT = register("dark_oak_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.DARK_OAK_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_KITCHEN_SINK_LIGHT = register("mangrove_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.MANGROVE_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_KITCHEN_SINK_LIGHT = register("cherry_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.CHERRY_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_KITCHEN_SINK_LIGHT = register("crimson_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.CRIMSON_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_KITCHEN_SINK_LIGHT = register("warped_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.WARPED_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_KITCHEN_SINK_LIGHT = register("stripped_oak_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT = register("stripped_spruce_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_KITCHEN_SINK_LIGHT = register("stripped_birch_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT = register("stripped_jungle_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_KITCHEN_SINK_LIGHT = register("stripped_acacia_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT = register("stripped_dark_oak_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT = register("stripped_mangrove_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_KITCHEN_SINK_LIGHT = register("stripped_cherry_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT = register("stripped_crimson_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_KITCHEN_SINK_LIGHT = register("stripped_warped_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> OAK_KITCHEN_SINK_DARK = register("oak_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.OAK_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> SPRUCE_KITCHEN_SINK_DARK = register("spruce_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.SPRUCE_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> BIRCH_KITCHEN_SINK_DARK = register("birch_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.BIRCH_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> JUNGLE_KITCHEN_SINK_DARK = register("jungle_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.JUNGLE_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> ACACIA_KITCHEN_SINK_DARK = register("acacia_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.ACACIA_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> DARK_OAK_KITCHEN_SINK_DARK = register("dark_oak_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.DARK_OAK_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> MANGROVE_KITCHEN_SINK_DARK = register("mangrove_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.MANGROVE_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> CHERRY_KITCHEN_SINK_DARK = register("cherry_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.CHERRY_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> CRIMSON_KITCHEN_SINK_DARK = register("crimson_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.CRIMSON_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> WARPED_KITCHEN_SINK_DARK = register("warped_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.WARPED_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_OAK_KITCHEN_SINK_DARK = register("stripped_oak_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_SPRUCE_KITCHEN_SINK_DARK = register("stripped_spruce_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_BIRCH_KITCHEN_SINK_DARK = register("stripped_birch_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_JUNGLE_KITCHEN_SINK_DARK = register("stripped_jungle_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_ACACIA_KITCHEN_SINK_DARK = register("stripped_acacia_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_DARK_OAK_KITCHEN_SINK_DARK = register("stripped_dark_oak_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_MANGROVE_KITCHEN_SINK_DARK = register("stripped_mangrove_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CHERRY_KITCHEN_SINK_DARK = register("stripped_cherry_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_CRIMSON_KITCHEN_SINK_DARK = register("stripped_crimson_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> STRIPPED_WARPED_KITCHEN_SINK_DARK = register("stripped_warped_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_DARK.get(), new Item.Properties()));
    public static final Supplier<Item> WHITE_KITCHEN_SINK = register("white_kitchen_sink",
            () -> new BlockItem(ModBlocks.WHITE_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_GRAY_KITCHEN_SINK = register("light_gray_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> GRAY_KITCHEN_SINK = register("gray_kitchen_sink",
            () -> new BlockItem(ModBlocks.GRAY_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> BLACK_KITCHEN_SINK = register("black_kitchen_sink",
            () -> new BlockItem(ModBlocks.BLACK_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> BROWN_KITCHEN_SINK = register("brown_kitchen_sink",
            () -> new BlockItem(ModBlocks.BROWN_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> RED_KITCHEN_SINK = register("red_kitchen_sink",
            () -> new BlockItem(ModBlocks.RED_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> ORANGE_KITCHEN_SINK = register("orange_kitchen_sink",
            () -> new BlockItem(ModBlocks.ORANGE_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> BEIGE_KITCHEN_SINK = registerOptional("beige_kitchen_sink", "yogmod",
            () -> new BlockItem(ModBlocks.BEIGE_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> YELLOW_KITCHEN_SINK = register("yellow_kitchen_sink",
            () -> new BlockItem(ModBlocks.YELLOW_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> LIME_KITCHEN_SINK = register("lime_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIME_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> GREEN_KITCHEN_SINK = register("green_kitchen_sink",
            () -> new BlockItem(ModBlocks.GREEN_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> CYAN_KITCHEN_SINK = register("cyan_kitchen_sink",
            () -> new BlockItem(ModBlocks.CYAN_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> LIGHT_BLUE_KITCHEN_SINK = register("light_blue_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> BLUE_KITCHEN_SINK = register("blue_kitchen_sink",
            () -> new BlockItem(ModBlocks.BLUE_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> PURPLE_KITCHEN_SINK = register("purple_kitchen_sink",
            () -> new BlockItem(ModBlocks.PURPLE_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> MAGENTA_KITCHEN_SINK = register("magenta_kitchen_sink",
            () -> new BlockItem(ModBlocks.MAGENTA_KITCHEN_SINK.get(), new Item.Properties()));
    public static final Supplier<Item> PINK_KITCHEN_SINK = register("pink_kitchen_sink",
            () -> new BlockItem(ModBlocks.PINK_KITCHEN_SINK.get(), new Item.Properties()));

    // Appliances
    public static final Supplier<Item> FRIDGE_LIGHT = register("fridge_light",
            () -> new FridgeItem(ModBlocks.FRIDGE_LIGHT.get(), ModBlocks.FREEZER_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> FRIDGE_DARK = register("fridge_dark",
            () -> new FridgeItem(ModBlocks.FRIDGE_DARK.get(), ModBlocks.FREEZER_DARK.get(), new Item.Properties()));

    // Items
    public static final Supplier<Item> SPATULA = register("spatula",
            () -> new SwordItem(Tiers.IRON, 3, -1.4F, new Item.Properties()));
}