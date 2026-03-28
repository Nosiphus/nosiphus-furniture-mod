package com.nosiphus.furniture.world.item;

import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.material.ModFluids;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.nosiphus.furniture.world.item.ModCreativeModeTabs.addToTab;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("nfm");

    // Tables
    public static final DeferredItem<BlockItem> STONE_TABLE = addToTab(ITEMS.register("stone_table",
            () -> new BlockItem(ModBlocks.STONE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ANDESITE_TABLE = addToTab(ITEMS.register("andesite_table",
            () -> new BlockItem(ModBlocks.ANDESITE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DIORITE_TABLE = addToTab(ITEMS.register("diorite_table",
            () -> new BlockItem(ModBlocks.DIORITE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRANITE_TABLE = addToTab(ITEMS.register("granite_table",
            () -> new BlockItem(ModBlocks.GRANITE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACKSTONE_TABLE = addToTab(ITEMS.register("blackstone_table",
            () -> new BlockItem(ModBlocks.BLACKSTONE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DEEPSLATE_TABLE = addToTab(ITEMS.register("deepslate_table",
            () -> new BlockItem(ModBlocks.DEEPSLATE_TABLE.get(), new Item.Properties())));

    // Modern Tables
    public static final DeferredItem<BlockItem> WHITE_MODERN_TABLE = addToTab(ITEMS.register("white_modern_table",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_TABLE = addToTab(ITEMS.register("light_gray_modern_table",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_TABLE = addToTab(ITEMS.register("gray_modern_table",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_TABLE = addToTab(ITEMS.register("black_modern_table",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_TABLE = addToTab(ITEMS.register("brown_modern_table",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_TABLE = addToTab(ITEMS.register("red_modern_table",
            () -> new BlockItem(ModBlocks.RED_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_TABLE = addToTab(ITEMS.register("orange_modern_table",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_TABLE = addToTab(ITEMS.register("beige_modern_table",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_TABLE = addToTab(ITEMS.register("yellow_modern_table",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_TABLE = addToTab(ITEMS.register("lime_modern_table",
            () -> new BlockItem(ModBlocks.LIME_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_TABLE = addToTab(ITEMS.register("green_modern_table",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_TABLE = addToTab(ITEMS.register("cyan_modern_table",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_TABLE = addToTab(ITEMS.register("light_blue_modern_table",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_TABLE = addToTab(ITEMS.register("blue_modern_table",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_TABLE = addToTab(ITEMS.register("purple_modern_table",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_TABLE = addToTab(ITEMS.register("magenta_modern_table",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_TABLE = addToTab(ITEMS.register("pink_modern_table",
            () -> new BlockItem(ModBlocks.PINK_MODERN_TABLE.get(), new Item.Properties())));

    // Chairs
    public static final DeferredItem<BlockItem> STONE_CHAIR = addToTab(ITEMS.register("stone_chair",
            () -> new BlockItem(ModBlocks.STONE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ANDESITE_CHAIR = addToTab(ITEMS.register("andesite_chair",
            () -> new BlockItem(ModBlocks.ANDESITE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DIORITE_CHAIR = addToTab(ITEMS.register("diorite_chair",
            () -> new BlockItem(ModBlocks.DIORITE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRANITE_CHAIR = addToTab(ITEMS.register("granite_chair",
            () -> new BlockItem(ModBlocks.GRANITE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACKSTONE_CHAIR = addToTab(ITEMS.register("blackstone_chair",
            () -> new BlockItem(ModBlocks.BLACKSTONE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DEEPSLATE_CHAIR = addToTab(ITEMS.register("deepslate_chair",
            () -> new BlockItem(ModBlocks.DEEPSLATE_CHAIR.get(), new Item.Properties())));

    // Modern Chairs
    public static final DeferredItem<BlockItem> WHITE_MODERN_CHAIR = addToTab(ITEMS.register("white_modern_chair",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_CHAIR = addToTab(ITEMS.register("light_gray_modern_chair",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_CHAIR = addToTab(ITEMS.register("gray_modern_chair",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_CHAIR = addToTab(ITEMS.register("black_modern_chair",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_CHAIR = addToTab(ITEMS.register("brown_modern_chair",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_CHAIR = addToTab(ITEMS.register("red_modern_chair",
            () -> new BlockItem(ModBlocks.RED_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_CHAIR = addToTab(ITEMS.register("orange_modern_chair",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_CHAIR = addToTab(ITEMS.register("beige_modern_chair",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_CHAIR = addToTab(ITEMS.register("yellow_modern_chair",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_CHAIR = addToTab(ITEMS.register("lime_modern_chair",
            () -> new BlockItem(ModBlocks.LIME_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_CHAIR = addToTab(ITEMS.register("green_modern_chair",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_CHAIR = addToTab(ITEMS.register("cyan_modern_chair",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_CHAIR = addToTab(ITEMS.register("light_blue_modern_chair",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_CHAIR = addToTab(ITEMS.register("blue_modern_chair",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_CHAIR = addToTab(ITEMS.register("purple_modern_chair",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_CHAIR = addToTab(ITEMS.register("magenta_modern_chair",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_CHAIR = addToTab(ITEMS.register("pink_modern_chair",
            () -> new BlockItem(ModBlocks.PINK_MODERN_CHAIR.get(), new Item.Properties())));

    // Coffee Tables
    public static final DeferredItem<BlockItem> STONE_COFFEE_TABLE = addToTab(ITEMS.register("stone_coffee_table",
            () -> new BlockItem(ModBlocks.STONE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ANDESITE_COFFEE_TABLE = addToTab(ITEMS.register("andesite_coffee_table",
            () -> new BlockItem(ModBlocks.ANDESITE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DIORITE_COFFEE_TABLE = addToTab(ITEMS.register("diorite_coffee_table",
            () -> new BlockItem(ModBlocks.DIORITE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRANITE_COFFEE_TABLE = addToTab(ITEMS.register("granite_coffee_table",
            () -> new BlockItem(ModBlocks.GRANITE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACKSTONE_COFFEE_TABLE = addToTab(ITEMS.register("blackstone_coffee_table",
            () -> new BlockItem(ModBlocks.BLACKSTONE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DEEPSLATE_COFFEE_TABLE = addToTab(ITEMS.register("deepslate_coffee_table",
            () -> new BlockItem(ModBlocks.DEEPSLATE_COFFEE_TABLE.get(), new Item.Properties())));

    // Modern Coffee Tables
    public static final DeferredItem<BlockItem> WHITE_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("white_modern_coffee_table",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("light_gray_modern_coffee_table",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("gray_modern_coffee_table",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("black_modern_coffee_table",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("brown_modern_coffee_table",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("red_modern_coffee_table",
            () -> new BlockItem(ModBlocks.RED_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("orange_modern_coffee_table",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("beige_modern_coffee_table",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("yellow_modern_coffee_table",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("lime_modern_coffee_table",
            () -> new BlockItem(ModBlocks.LIME_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("green_modern_coffee_table",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("cyan_modern_coffee_table",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("light_blue_modern_coffee_table",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("blue_modern_coffee_table",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("purple_modern_coffee_table",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("magenta_modern_coffee_table",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_COFFEE_TABLE = addToTab(ITEMS.register("pink_modern_coffee_table",
            () -> new BlockItem(ModBlocks.PINK_MODERN_COFFEE_TABLE.get(), new Item.Properties())));

    // Cabinets
    public static final DeferredItem<BlockItem> STONE_CABINET = addToTab(ITEMS.register("stone_cabinet",
            () -> new BlockItem(ModBlocks.STONE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ANDESITE_CABINET = addToTab(ITEMS.register("andesite_cabinet",
            () -> new BlockItem(ModBlocks.ANDESITE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DIORITE_CABINET = addToTab(ITEMS.register("diorite_cabinet",
            () -> new BlockItem(ModBlocks.DIORITE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRANITE_CABINET = addToTab(ITEMS.register("granite_cabinet",
            () -> new BlockItem(ModBlocks.GRANITE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACKSTONE_CABINET = addToTab(ITEMS.register("blackstone_cabinet",
            () -> new BlockItem(ModBlocks.BLACKSTONE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DEEPSLATE_CABINET = addToTab(ITEMS.register("deepslate_cabinet",
            () -> new BlockItem(ModBlocks.DEEPSLATE_CABINET.get(), new Item.Properties())));

    // Modern Cabinets
    public static final DeferredItem<BlockItem> WHITE_MODERN_CABINET = addToTab(ITEMS.register("white_modern_cabinet",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_CABINET = addToTab(ITEMS.register("light_gray_modern_cabinet",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_CABINET = addToTab(ITEMS.register("gray_modern_cabinet",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_CABINET = addToTab(ITEMS.register("black_modern_cabinet",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_CABINET = addToTab(ITEMS.register("brown_modern_cabinet",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_CABINET = addToTab(ITEMS.register("red_modern_cabinet",
            () -> new BlockItem(ModBlocks.RED_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_CABINET = addToTab(ITEMS.register("orange_modern_cabinet",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_CABINET = addToTab(ITEMS.register("beige_modern_cabinet",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_CABINET = addToTab(ITEMS.register("yellow_modern_cabinet",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_CABINET = addToTab(ITEMS.register("lime_modern_cabinet",
            () -> new BlockItem(ModBlocks.LIME_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_CABINET = addToTab(ITEMS.register("green_modern_cabinet",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_CABINET = addToTab(ITEMS.register("cyan_modern_cabinet",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_CABINET = addToTab(ITEMS.register("light_blue_modern_cabinet",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_CABINET = addToTab(ITEMS.register("blue_modern_cabinet",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_CABINET = addToTab(ITEMS.register("purple_modern_cabinet",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_CABINET = addToTab(ITEMS.register("magenta_modern_cabinet",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_CABINET = addToTab(ITEMS.register("pink_modern_cabinet",
            () -> new BlockItem(ModBlocks.PINK_MODERN_CABINET.get(), new Item.Properties())));

    // Bedside Cabinets
    public static final DeferredItem<BlockItem> STONE_BEDSIDE_CABINET = addToTab(ITEMS.register("stone_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STONE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ANDESITE_BEDSIDE_CABINET = addToTab(ITEMS.register("andesite_bedside_cabinet",
            () -> new BlockItem(ModBlocks.ANDESITE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DIORITE_BEDSIDE_CABINET = addToTab(ITEMS.register("diorite_bedside_cabinet",
            () -> new BlockItem(ModBlocks.DIORITE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRANITE_BEDSIDE_CABINET = addToTab(ITEMS.register("granite_bedside_cabinet",
            () -> new BlockItem(ModBlocks.GRANITE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACKSTONE_BEDSIDE_CABINET = addToTab(ITEMS.register("blackstone_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BLACKSTONE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DEEPSLATE_BEDSIDE_CABINET = addToTab(ITEMS.register("deepslate_bedside_cabinet",
            () -> new BlockItem(ModBlocks.DEEPSLATE_BEDSIDE_CABINET.get(), new Item.Properties())));

    // Modern Bedside Cabinets
    public static final DeferredItem<BlockItem> WHITE_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("white_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("light_gray_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("gray_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("black_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("brown_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("red_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.RED_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("orange_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("beige_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("yellow_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("lime_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.LIME_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("green_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("cyan_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("light_blue_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("blue_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("purple_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("magenta_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_BEDSIDE_CABINET = addToTab(ITEMS.register("pink_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.PINK_MODERN_BEDSIDE_CABINET.get(), new Item.Properties())));

    // Modern Beds
    public static final DeferredItem<BlockItem> WHITE_MODERN_BED = addToTab(ITEMS.register("white_modern_bed",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_BED = addToTab(ITEMS.register("light_gray_modern_bed",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_BED = addToTab(ITEMS.register("gray_modern_bed",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_BED = addToTab(ITEMS.register("black_modern_bed",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_BED = addToTab(ITEMS.register("brown_modern_bed",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_BED = addToTab(ITEMS.register("red_modern_bed",
            () -> new BlockItem(ModBlocks.RED_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_BED = addToTab(ITEMS.register("orange_modern_bed",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_BED = addToTab(ITEMS.register("beige_modern_bed",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_BED = addToTab(ITEMS.register("yellow_modern_bed",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_BED = addToTab(ITEMS.register("lime_modern_bed",
            () -> new BlockItem(ModBlocks.LIME_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_BED = addToTab(ITEMS.register("green_modern_bed",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_BED = addToTab(ITEMS.register("cyan_modern_bed",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_BED = addToTab(ITEMS.register("light_blue_modern_bed",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_BED = addToTab(ITEMS.register("blue_modern_bed",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_BED = addToTab(ITEMS.register("purple_modern_bed",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_BED = addToTab(ITEMS.register("magenta_modern_bed",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_BED.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_BED = addToTab(ITEMS.register("pink_modern_bed",
            () -> new BlockItem(ModBlocks.PINK_MODERN_BED.get(), new Item.Properties())));

    // Curtains
    public static final DeferredItem<BlockItem> WHITE_CURTAIN = addToTab(ITEMS.register("white_curtain",
            () -> new BlockItem(ModBlocks.WHITE_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CURTAIN = addToTab(ITEMS.register("light_gray_curtain",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_CURTAIN = addToTab(ITEMS.register("gray_curtain",
            () -> new BlockItem(ModBlocks.GRAY_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_CURTAIN = addToTab(ITEMS.register("black_curtain",
            () -> new BlockItem(ModBlocks.BLACK_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_CURTAIN = addToTab(ITEMS.register("brown_curtain",
            () -> new BlockItem(ModBlocks.BROWN_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_CURTAIN = addToTab(ITEMS.register("red_curtain",
            () -> new BlockItem(ModBlocks.RED_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_CURTAIN = addToTab(ITEMS.register("orange_curtain",
            () -> new BlockItem(ModBlocks.ORANGE_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_CURTAIN = addToTab(ITEMS.register("beige_curtain",
            () -> new BlockItem(ModBlocks.BEIGE_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_CURTAIN = addToTab(ITEMS.register("yellow_curtain",
            () -> new BlockItem(ModBlocks.YELLOW_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_CURTAIN = addToTab(ITEMS.register("lime_curtain",
            () -> new BlockItem(ModBlocks.LIME_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_CURTAIN = addToTab(ITEMS.register("green_curtain",
            () -> new BlockItem(ModBlocks.GREEN_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_CURTAIN = addToTab(ITEMS.register("cyan_curtain",
            () -> new BlockItem(ModBlocks.CYAN_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CURTAIN = addToTab(ITEMS.register("light_blue_curtain",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_CURTAIN = addToTab(ITEMS.register("blue_curtain",
            () -> new BlockItem(ModBlocks.BLUE_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_CURTAIN = addToTab(ITEMS.register("purple_curtain",
            () -> new BlockItem(ModBlocks.PURPLE_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_CURTAIN = addToTab(ITEMS.register("magenta_curtain",
            () -> new BlockItem(ModBlocks.MAGENTA_CURTAIN.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_CURTAIN = addToTab(ITEMS.register("pink_curtain",
            () -> new BlockItem(ModBlocks.PINK_CURTAIN.get(), new Item.Properties())));

    // Desks
    public static final DeferredItem<BlockItem> STONE_DESK = addToTab(ITEMS.register("stone_desk",
            () -> new BlockItem(ModBlocks.STONE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ANDESITE_DESK = addToTab(ITEMS.register("andesite_desk",
            () -> new BlockItem(ModBlocks.ANDESITE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DIORITE_DESK = addToTab(ITEMS.register("diorite_desk",
            () -> new BlockItem(ModBlocks.DIORITE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRANITE_DESK = addToTab(ITEMS.register("granite_desk",
            () -> new BlockItem(ModBlocks.GRANITE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACKSTONE_DESK = addToTab(ITEMS.register("blackstone_desk",
            () -> new BlockItem(ModBlocks.BLACKSTONE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DEEPSLATE_DESK = addToTab(ITEMS.register("deepslate_desk",
            () -> new BlockItem(ModBlocks.DEEPSLATE_DESK.get(), new Item.Properties())));

    // Modern Desks
    public static final DeferredItem<BlockItem> WHITE_MODERN_DESK = addToTab(ITEMS.register("white_modern_desk",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_DESK = addToTab(ITEMS.register("light_gray_modern_desk",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_DESK = addToTab(ITEMS.register("gray_modern_desk",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_DESK = addToTab(ITEMS.register("black_modern_desk",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_DESK = addToTab(ITEMS.register("brown_modern_desk",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_DESK = addToTab(ITEMS.register("red_modern_desk",
            () -> new BlockItem(ModBlocks.RED_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_DESK = addToTab(ITEMS.register("orange_modern_desk",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_DESK = addToTab(ITEMS.register("beige_modern_desk",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_DESK = addToTab(ITEMS.register("yellow_modern_desk",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_DESK = addToTab(ITEMS.register("lime_modern_desk",
            () -> new BlockItem(ModBlocks.LIME_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_DESK = addToTab(ITEMS.register("green_modern_desk",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_DESK = addToTab(ITEMS.register("cyan_modern_desk",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_DESK = addToTab(ITEMS.register("light_blue_modern_desk",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_DESK = addToTab(ITEMS.register("blue_modern_desk",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_DESK = addToTab(ITEMS.register("purple_modern_desk",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_DESK = addToTab(ITEMS.register("magenta_modern_desk",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_DESK = addToTab(ITEMS.register("pink_modern_desk",
            () -> new BlockItem(ModBlocks.PINK_MODERN_DESK.get(), new Item.Properties())));

    // Desk Cabinets
    public static final DeferredItem<BlockItem> STONE_DESK_CABINET = addToTab(ITEMS.register("stone_desk_cabinet",
            () -> new BlockItem(ModBlocks.STONE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ANDESITE_DESK_CABINET = addToTab(ITEMS.register("andesite_desk_cabinet",
            () -> new BlockItem(ModBlocks.ANDESITE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DIORITE_DESK_CABINET = addToTab(ITEMS.register("diorite_desk_cabinet",
            () -> new BlockItem(ModBlocks.DIORITE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRANITE_DESK_CABINET = addToTab(ITEMS.register("granite_desk_cabinet",
            () -> new BlockItem(ModBlocks.GRANITE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACKSTONE_DESK_CABINET = addToTab(ITEMS.register("blackstone_desk_cabinet",
            () -> new BlockItem(ModBlocks.BLACKSTONE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DEEPSLATE_DESK_CABINET = addToTab(ITEMS.register("deepslate_desk_cabinet",
            () -> new BlockItem(ModBlocks.DEEPSLATE_DESK_CABINET.get(), new Item.Properties())));

    // Modern Desk Cabinets
    public static final DeferredItem<BlockItem> WHITE_MODERN_DESK_CABINET = addToTab(ITEMS.register("white_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_DESK_CABINET = addToTab(ITEMS.register("light_gray_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_DESK_CABINET = addToTab(ITEMS.register("gray_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_DESK_CABINET = addToTab(ITEMS.register("black_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_DESK_CABINET = addToTab(ITEMS.register("brown_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_DESK_CABINET = addToTab(ITEMS.register("red_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.RED_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_DESK_CABINET = addToTab(ITEMS.register("orange_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_DESK_CABINET = addToTab(ITEMS.register("beige_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_DESK_CABINET = addToTab(ITEMS.register("yellow_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_DESK_CABINET = addToTab(ITEMS.register("lime_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.LIME_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_DESK_CABINET = addToTab(ITEMS.register("green_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_DESK_CABINET = addToTab(ITEMS.register("cyan_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_DESK_CABINET = addToTab(ITEMS.register("light_blue_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_DESK_CABINET = addToTab(ITEMS.register("blue_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_DESK_CABINET = addToTab(ITEMS.register("purple_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_DESK_CABINET = addToTab(ITEMS.register("magenta_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_DESK_CABINET = addToTab(ITEMS.register("pink_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.PINK_MODERN_DESK_CABINET.get(), new Item.Properties())));

    // Wall Cabinets
    public static final DeferredItem<BlockItem> WHITE_WALL_CABINET = addToTab(ITEMS.register("white_wall_cabinet",
            () -> new BlockItem(ModBlocks.WHITE_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_WALL_CABINET = addToTab(ITEMS.register("light_gray_wall_cabinet",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_WALL_CABINET = addToTab(ITEMS.register("gray_wall_cabinet",
            () -> new BlockItem(ModBlocks.GRAY_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_WALL_CABINET = addToTab(ITEMS.register("black_wall_cabinet",
            () -> new BlockItem(ModBlocks.BLACK_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_WALL_CABINET = addToTab(ITEMS.register("brown_wall_cabinet",
            () -> new BlockItem(ModBlocks.BROWN_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_WALL_CABINET = addToTab(ITEMS.register("red_wall_cabinet",
            () -> new BlockItem(ModBlocks.RED_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_WALL_CABINET = addToTab(ITEMS.register("orange_wall_cabinet",
            () -> new BlockItem(ModBlocks.ORANGE_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_WALL_CABINET = addToTab(ITEMS.register("beige_wall_cabinet",
            () -> new BlockItem(ModBlocks.BEIGE_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_WALL_CABINET = addToTab(ITEMS.register("yellow_wall_cabinet",
            () -> new BlockItem(ModBlocks.YELLOW_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_WALL_CABINET = addToTab(ITEMS.register("lime_wall_cabinet",
            () -> new BlockItem(ModBlocks.LIME_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_WALL_CABINET = addToTab(ITEMS.register("green_wall_cabinet",
            () -> new BlockItem(ModBlocks.GREEN_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_WALL_CABINET = addToTab(ITEMS.register("cyan_wall_cabinet",
            () -> new BlockItem(ModBlocks.CYAN_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_WALL_CABINET = addToTab(ITEMS.register("light_blue_wall_cabinet",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_WALL_CABINET = addToTab(ITEMS.register("blue_wall_cabinet",
            () -> new BlockItem(ModBlocks.BLUE_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_WALL_CABINET = addToTab(ITEMS.register("purple_wall_cabinet",
            () -> new BlockItem(ModBlocks.PURPLE_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_WALL_CABINET = addToTab(ITEMS.register("magenta_wall_cabinet",
            () -> new BlockItem(ModBlocks.MAGENTA_WALL_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_WALL_CABINET = addToTab(ITEMS.register("pink_wall_cabinet",
            () -> new BlockItem(ModBlocks.PINK_WALL_CABINET.get(), new Item.Properties())));

    // Modern Sofas
    public static final DeferredItem<BlockItem> WHITE_MODERN_SOFA = addToTab(ITEMS.register("white_modern_sofa",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_SOFA = addToTab(ITEMS.register("light_gray_modern_sofa",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_SOFA = addToTab(ITEMS.register("gray_modern_sofa",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_SOFA = addToTab(ITEMS.register("black_modern_sofa",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_SOFA = addToTab(ITEMS.register("brown_modern_sofa",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_SOFA = addToTab(ITEMS.register("red_modern_sofa",
            () -> new BlockItem(ModBlocks.RED_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_SOFA = addToTab(ITEMS.register("orange_modern_sofa",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_SOFA = addToTab(ITEMS.register("beige_modern_sofa",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_SOFA = addToTab(ITEMS.register("yellow_modern_sofa",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_SOFA = addToTab(ITEMS.register("lime_modern_sofa",
            () -> new BlockItem(ModBlocks.LIME_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_SOFA = addToTab(ITEMS.register("green_modern_sofa",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_SOFA = addToTab(ITEMS.register("cyan_modern_sofa",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_SOFA = addToTab(ITEMS.register("light_blue_modern_sofa",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_SOFA = addToTab(ITEMS.register("blue_modern_sofa",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_SOFA = addToTab(ITEMS.register("purple_modern_sofa",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_SOFA = addToTab(ITEMS.register("magenta_modern_sofa",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_SOFA = addToTab(ITEMS.register("pink_modern_sofa",
            () -> new BlockItem(ModBlocks.PINK_MODERN_SOFA.get(), new Item.Properties())));

    // Television Stands
    public static final DeferredItem<BlockItem> WHITE_TELEVISION_STAND = addToTab(ITEMS.register("white_television_stand",
            () -> new BlockItem(ModBlocks.WHITE_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TELEVISION_STAND = addToTab(ITEMS.register("light_gray_television_stand",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_TELEVISION_STAND = addToTab(ITEMS.register("gray_television_stand",
            () -> new BlockItem(ModBlocks.GRAY_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_TELEVISION_STAND = addToTab(ITEMS.register("black_television_stand",
            () -> new BlockItem(ModBlocks.BLACK_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_TELEVISION_STAND = addToTab(ITEMS.register("brown_television_stand",
            () -> new BlockItem(ModBlocks.BROWN_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_TELEVISION_STAND = addToTab(ITEMS.register("red_television_stand",
            () -> new BlockItem(ModBlocks.RED_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_TELEVISION_STAND = addToTab(ITEMS.register("orange_television_stand",
            () -> new BlockItem(ModBlocks.ORANGE_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_TELEVISION_STAND = addToTab(ITEMS.register("beige_television_stand",
            () -> new BlockItem(ModBlocks.BEIGE_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_TELEVISION_STAND = addToTab(ITEMS.register("yellow_television_stand",
            () -> new BlockItem(ModBlocks.YELLOW_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_TELEVISION_STAND = addToTab(ITEMS.register("lime_television_stand",
            () -> new BlockItem(ModBlocks.LIME_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_TELEVISION_STAND = addToTab(ITEMS.register("green_television_stand",
            () -> new BlockItem(ModBlocks.GREEN_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_TELEVISION_STAND = addToTab(ITEMS.register("cyan_television_stand",
            () -> new BlockItem(ModBlocks.CYAN_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TELEVISION_STAND = addToTab(ITEMS.register("light_blue_television_stand",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_TELEVISION_STAND = addToTab(ITEMS.register("blue_television_stand",
            () -> new BlockItem(ModBlocks.BLUE_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_TELEVISION_STAND = addToTab(ITEMS.register("purple_television_stand",
            () -> new BlockItem(ModBlocks.PURPLE_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_TELEVISION_STAND = addToTab(ITEMS.register("magenta_television_stand",
            () -> new BlockItem(ModBlocks.MAGENTA_TELEVISION_STAND.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_TELEVISION_STAND = addToTab(ITEMS.register("pink_television_stand",
            () -> new BlockItem(ModBlocks.PINK_TELEVISION_STAND.get(), new Item.Properties())));

    // Lamps
    public static final DeferredItem<BlockItem> WHITE_LAMP = addToTab(ITEMS.register("white_lamp",
            () -> new BlockItem(ModBlocks.WHITE_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_LAMP = addToTab(ITEMS.register("light_gray_lamp",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_LAMP = addToTab(ITEMS.register("gray_lamp",
            () -> new BlockItem(ModBlocks.GRAY_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_LAMP = addToTab(ITEMS.register("black_lamp",
            () -> new BlockItem(ModBlocks.BLACK_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_LAMP = addToTab(ITEMS.register("brown_lamp",
            () -> new BlockItem(ModBlocks.BROWN_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_LAMP = addToTab(ITEMS.register("red_lamp",
            () -> new BlockItem(ModBlocks.RED_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_LAMP = addToTab(ITEMS.register("orange_lamp",
            () -> new BlockItem(ModBlocks.ORANGE_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_LAMP = addToTab(ITEMS.register("beige_lamp",
            () -> new BlockItem(ModBlocks.BEIGE_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_LAMP = addToTab(ITEMS.register("yellow_lamp",
            () -> new BlockItem(ModBlocks.YELLOW_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_LAMP = addToTab(ITEMS.register("lime_lamp",
            () -> new BlockItem(ModBlocks.LIME_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_LAMP = addToTab(ITEMS.register("green_lamp",
            () -> new BlockItem(ModBlocks.GREEN_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_LAMP = addToTab(ITEMS.register("cyan_lamp",
            () -> new BlockItem(ModBlocks.CYAN_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_LAMP = addToTab(ITEMS.register("light_blue_lamp",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_LAMP = addToTab(ITEMS.register("blue_lamp",
            () -> new BlockItem(ModBlocks.BLUE_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_LAMP = addToTab(ITEMS.register("purple_lamp",
            () -> new BlockItem(ModBlocks.PURPLE_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_LAMP = addToTab(ITEMS.register("magenta_lamp",
            () -> new BlockItem(ModBlocks.MAGENTA_LAMP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_LAMP = addToTab(ITEMS.register("pink_lamp",
            () -> new BlockItem(ModBlocks.PINK_LAMP.get(), new Item.Properties())));

    // Modern Kitchen Counters
    public static final DeferredItem<BlockItem> WHITE_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("white_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("light_gray_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("gray_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("black_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("brown_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("red_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.RED_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("orange_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("beige_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("yellow_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("lime_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIME_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("green_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("cyan_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("light_blue_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("blue_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("purple_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("magenta_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_KITCHEN_COUNTER = addToTab(ITEMS.register("pink_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.PINK_MODERN_KITCHEN_COUNTER.get(), new Item.Properties())));

    // Modern Kitchen Drawers
    public static final DeferredItem<BlockItem> WHITE_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("white_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("light_gray_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("gray_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("black_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("brown_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("red_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.RED_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("orange_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("beige_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("yellow_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("lime_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIME_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("green_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("cyan_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("light_blue_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("blue_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("purple_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("magenta_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_KITCHEN_DRAWER = addToTab(ITEMS.register("pink_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.PINK_MODERN_KITCHEN_DRAWER.get(), new Item.Properties())));

    // Modern Kitchen Sinks
    public static final DeferredItem<BlockItem> WHITE_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("white_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.WHITE_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("light_gray_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("gray_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.GRAY_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("black_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.BLACK_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("brown_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.BROWN_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("red_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.RED_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("orange_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.ORANGE_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("beige_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.BEIGE_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("yellow_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.YELLOW_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("lime_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIME_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("green_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.GREEN_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("cyan_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.CYAN_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("light_blue_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("blue_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.BLUE_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("purple_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.PURPLE_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("magenta_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.MAGENTA_MODERN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_MODERN_KITCHEN_SINK = addToTab(ITEMS.register("pink_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.PINK_MODERN_KITCHEN_SINK.get(), new Item.Properties())));

    // Bar Stools
    public static final DeferredItem<BlockItem> WHITE_BAR_STOOL = addToTab(ITEMS.register("white_bar_stool",
            () -> new BlockItem(ModBlocks.WHITE_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_BAR_STOOL = addToTab(ITEMS.register("light_gray_bar_stool",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_BAR_STOOL = addToTab(ITEMS.register("gray_bar_stool",
            () -> new BlockItem(ModBlocks.GRAY_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_BAR_STOOL = addToTab(ITEMS.register("black_bar_stool",
            () -> new BlockItem(ModBlocks.BLACK_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_BAR_STOOL = addToTab(ITEMS.register("brown_bar_stool",
            () -> new BlockItem(ModBlocks.BROWN_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_BAR_STOOL = addToTab(ITEMS.register("red_bar_stool",
            () -> new BlockItem(ModBlocks.RED_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_BAR_STOOL = addToTab(ITEMS.register("orange_bar_stool",
            () -> new BlockItem(ModBlocks.ORANGE_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_BAR_STOOL = addToTab(ITEMS.register("beige_bar_stool",
            () -> new BlockItem(ModBlocks.BEIGE_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_BAR_STOOL = addToTab(ITEMS.register("yellow_bar_stool",
            () -> new BlockItem(ModBlocks.YELLOW_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_BAR_STOOL = addToTab(ITEMS.register("lime_bar_stool",
            () -> new BlockItem(ModBlocks.LIME_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_BAR_STOOL = addToTab(ITEMS.register("green_bar_stool",
            () -> new BlockItem(ModBlocks.GREEN_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_BAR_STOOL = addToTab(ITEMS.register("cyan_bar_stool",
            () -> new BlockItem(ModBlocks.CYAN_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_BAR_STOOL = addToTab(ITEMS.register("light_blue_bar_stool",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_BAR_STOOL = addToTab(ITEMS.register("blue_bar_stool",
            () -> new BlockItem(ModBlocks.BLUE_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_BAR_STOOL = addToTab(ITEMS.register("purple_bar_stool",
            () -> new BlockItem(ModBlocks.PURPLE_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_BAR_STOOL = addToTab(ITEMS.register("magenta_bar_stool",
            () -> new BlockItem(ModBlocks.MAGENTA_BAR_STOOL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_BAR_STOOL = addToTab(ITEMS.register("pink_bar_stool",
            () -> new BlockItem(ModBlocks.PINK_BAR_STOOL.get(), new Item.Properties())));

    // Chopping Boards
    public static final DeferredItem<BlockItem> OAK_CHOPPING_BOARD = addToTab(ITEMS.register("oak_chopping_board",
            () -> new BlockItem(ModBlocks.OAK_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_CHOPPING_BOARD = addToTab(ITEMS.register("spruce_chopping_board",
            () -> new BlockItem(ModBlocks.SPRUCE_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_CHOPPING_BOARD = addToTab(ITEMS.register("birch_chopping_board",
            () -> new BlockItem(ModBlocks.BIRCH_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_CHOPPING_BOARD = addToTab(ITEMS.register("jungle_chopping_board",
            () -> new BlockItem(ModBlocks.JUNGLE_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_CHOPPING_BOARD = addToTab(ITEMS.register("acacia_chopping_board",
            () -> new BlockItem(ModBlocks.ACACIA_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_CHOPPING_BOARD = addToTab(ITEMS.register("dark_oak_chopping_board",
            () -> new BlockItem(ModBlocks.DARK_OAK_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_CHOPPING_BOARD = addToTab(ITEMS.register("mangrove_chopping_board",
            () -> new BlockItem(ModBlocks.MANGROVE_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_CHOPPING_BOARD = addToTab(ITEMS.register("cherry_chopping_board",
            () -> new BlockItem(ModBlocks.CHERRY_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_CHOPPING_BOARD = addToTab(ITEMS.register("crimson_chopping_board",
            () -> new BlockItem(ModBlocks.CRIMSON_CHOPPING_BOARD.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_CHOPPING_BOARD = addToTab(ITEMS.register("warped_chopping_board",
            () -> new BlockItem(ModBlocks.WARPED_CHOPPING_BOARD.get(), new Item.Properties())));

    // Door Bells
    public static final DeferredItem<BlockItem> OAK_DOOR_BELL = addToTab(ITEMS.register("oak_door_bell",
            () -> new BlockItem(ModBlocks.OAK_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_DOOR_BELL = addToTab(ITEMS.register("spruce_door_bell",
            () -> new BlockItem(ModBlocks.SPRUCE_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_DOOR_BELL = addToTab(ITEMS.register("birch_door_bell",
            () -> new BlockItem(ModBlocks.BIRCH_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_DOOR_BELL = addToTab(ITEMS.register("jungle_door_bell",
            () -> new BlockItem(ModBlocks.JUNGLE_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_DOOR_BELL = addToTab(ITEMS.register("acacia_door_bell",
            () -> new BlockItem(ModBlocks.ACACIA_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_DOOR_BELL = addToTab(ITEMS.register("dark_oak_door_bell",
            () -> new BlockItem(ModBlocks.DARK_OAK_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_DOOR_BELL = addToTab(ITEMS.register("mangrove_door_bell",
            () -> new BlockItem(ModBlocks.MANGROVE_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_DOOR_BELL = addToTab(ITEMS.register("cherry_door_bell",
            () -> new BlockItem(ModBlocks.CHERRY_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_DOOR_BELL = addToTab(ITEMS.register("crimson_door_bell",
            () -> new BlockItem(ModBlocks.CRIMSON_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_DOOR_BELL = addToTab(ITEMS.register("warped_door_bell",
            () -> new BlockItem(ModBlocks.WARPED_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_DOOR_BELL = addToTab(ITEMS.register("stripped_oak_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_DOOR_BELL = addToTab(ITEMS.register("stripped_spruce_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_DOOR_BELL = addToTab(ITEMS.register("stripped_birch_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_DOOR_BELL = addToTab(ITEMS.register("stripped_jungle_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_DOOR_BELL = addToTab(ITEMS.register("stripped_acacia_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_DOOR_BELL = addToTab(ITEMS.register("stripped_dark_oak_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_DOOR_BELL = addToTab(ITEMS.register("stripped_mangrove_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_DOOR_BELL = addToTab(ITEMS.register("stripped_cherry_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_DOOR_BELL = addToTab(ITEMS.register("stripped_crimson_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_DOOR_BELL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_DOOR_BELL = addToTab(ITEMS.register("stripped_warped_door_bell",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_DOOR_BELL.get(), new Item.Properties())));

    // Inflatable Castles
    public static final DeferredItem<BlockItem> WHITE_INFLATABLE_CASTLE = addToTab(ITEMS.register("white_inflatable_castle",
            () -> new BlockItem(ModBlocks.WHITE_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_INFLATABLE_CASTLE = addToTab(ITEMS.register("light_gray_inflatable_castle",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_INFLATABLE_CASTLE = addToTab(ITEMS.register("gray_inflatable_castle",
            () -> new BlockItem(ModBlocks.GRAY_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_INFLATABLE_CASTLE = addToTab(ITEMS.register("black_inflatable_castle",
            () -> new BlockItem(ModBlocks.BLACK_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_INFLATABLE_CASTLE = addToTab(ITEMS.register("brown_inflatable_castle",
            () -> new BlockItem(ModBlocks.BROWN_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_INFLATABLE_CASTLE = addToTab(ITEMS.register("red_inflatable_castle",
            () -> new BlockItem(ModBlocks.RED_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_INFLATABLE_CASTLE = addToTab(ITEMS.register("orange_inflatable_castle",
            () -> new BlockItem(ModBlocks.ORANGE_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_INFLATABLE_CASTLE = addToTab(ITEMS.register("beige_inflatable_castle",
            () -> new BlockItem(ModBlocks.BEIGE_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_INFLATABLE_CASTLE = addToTab(ITEMS.register("yellow_inflatable_castle",
            () -> new BlockItem(ModBlocks.YELLOW_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_INFLATABLE_CASTLE = addToTab(ITEMS.register("lime_inflatable_castle",
            () -> new BlockItem(ModBlocks.LIME_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_INFLATABLE_CASTLE = addToTab(ITEMS.register("green_inflatable_castle",
            () -> new BlockItem(ModBlocks.GREEN_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_INFLATABLE_CASTLE = addToTab(ITEMS.register("cyan_inflatable_castle",
            () -> new BlockItem(ModBlocks.CYAN_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_INFLATABLE_CASTLE = addToTab(ITEMS.register("light_blue_inflatable_castle",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_INFLATABLE_CASTLE = addToTab(ITEMS.register("blue_inflatable_castle",
            () -> new BlockItem(ModBlocks.BLUE_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_INFLATABLE_CASTLE = addToTab(ITEMS.register("purple_inflatable_castle",
            () -> new BlockItem(ModBlocks.PURPLE_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_INFLATABLE_CASTLE = addToTab(ITEMS.register("magenta_inflatable_castle",
            () -> new BlockItem(ModBlocks.MAGENTA_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_INFLATABLE_CASTLE = addToTab(ITEMS.register("pink_inflatable_castle",
            () -> new BlockItem(ModBlocks.PINK_INFLATABLE_CASTLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CASTLE_NETTING = addToTab(ITEMS.register("castle_netting",
            () -> new BlockItem(ModBlocks.CASTLE_NETTING.get(), new Item.Properties())));

    // Kitchenware
    public static final DeferredItem<BlockItem> COOKIE_JAR = addToTab(ITEMS.register("cookie_jar",
            () -> new BlockItem(ModBlocks.COOKIE_JAR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WHITE_CUP = addToTab(ITEMS.register("white_cup",
            () -> new BlockItem(ModBlocks.WHITE_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_CUP = addToTab(ITEMS.register("light_gray_cup",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_CUP = addToTab(ITEMS.register("gray_cup",
            () -> new BlockItem(ModBlocks.GRAY_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_CUP = addToTab(ITEMS.register("black_cup",
            () -> new BlockItem(ModBlocks.BLACK_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_CUP = addToTab(ITEMS.register("brown_cup",
            () -> new BlockItem(ModBlocks.BROWN_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_CUP = addToTab(ITEMS.register("red_cup",
            () -> new BlockItem(ModBlocks.RED_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_CUP = addToTab(ITEMS.register("orange_cup",
            () -> new BlockItem(ModBlocks.ORANGE_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_CUP = addToTab(ITEMS.register("beige_cup",
            () -> new BlockItem(ModBlocks.BEIGE_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_CUP = addToTab(ITEMS.register("yellow_cup",
            () -> new BlockItem(ModBlocks.YELLOW_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_CUP = addToTab(ITEMS.register("lime_cup",
            () -> new BlockItem(ModBlocks.LIME_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_CUP = addToTab(ITEMS.register("green_cup",
            () -> new BlockItem(ModBlocks.GREEN_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_CUP = addToTab(ITEMS.register("cyan_cup",
            () -> new BlockItem(ModBlocks.CYAN_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_CUP = addToTab(ITEMS.register("light_blue_cup",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_CUP = addToTab(ITEMS.register("blue_cup",
            () -> new BlockItem(ModBlocks.BLUE_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_CUP = addToTab(ITEMS.register("purple_cup",
            () -> new BlockItem(ModBlocks.PURPLE_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_CUP = addToTab(ITEMS.register("magenta_cup",
            () -> new BlockItem(ModBlocks.MAGENTA_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_CUP = addToTab(ITEMS.register("pink_cup",
            () -> new BlockItem(ModBlocks.PINK_CUP.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PLATE = addToTab(ITEMS.register("plate",
            () -> new BlockItem(ModBlocks.PLATE.get(), new Item.Properties())));

    // Bird Baths
    public static final DeferredItem<BlockItem> STONE_BIRD_BATH = addToTab(ITEMS.register("stone_bird_bath",
            () -> new BlockItem(ModBlocks.STONE_BIRD_BATH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ANDESITE_BIRD_BATH = addToTab(ITEMS.register("andesite_bird_bath",
            () -> new BlockItem(ModBlocks.ANDESITE_BIRD_BATH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DIORITE_BIRD_BATH = addToTab(ITEMS.register("diorite_bird_bath",
            () -> new BlockItem(ModBlocks.DIORITE_BIRD_BATH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRANITE_BIRD_BATH = addToTab(ITEMS.register("granite_bird_bath",
            () -> new BlockItem(ModBlocks.GRANITE_BIRD_BATH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACKSTONE_BIRD_BATH = addToTab(ITEMS.register("blackstone_bird_bath",
            () -> new BlockItem(ModBlocks.BLACKSTONE_BIRD_BATH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DEEPSLATE_BIRD_BATH = addToTab(ITEMS.register("deepslate_bird_bath",
            () -> new BlockItem(ModBlocks.DEEPSLATE_BIRD_BATH.get(), new Item.Properties())));

    // Water Tanks
    public static final DeferredItem<BlockItem> OAK_WATER_TANK = addToTab(ITEMS.register("oak_water_tank",
            () -> new BlockItem(ModBlocks.OAK_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_WATER_TANK = addToTab(ITEMS.register("spruce_water_tank",
            () -> new BlockItem(ModBlocks.SPRUCE_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_WATER_TANK = addToTab(ITEMS.register("birch_water_tank",
            () -> new BlockItem(ModBlocks.BIRCH_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_WATER_TANK = addToTab(ITEMS.register("jungle_water_tank",
            () -> new BlockItem(ModBlocks.JUNGLE_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_WATER_TANK = addToTab(ITEMS.register("acacia_water_tank",
            () -> new BlockItem(ModBlocks.ACACIA_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_WATER_TANK = addToTab(ITEMS.register("dark_oak_water_tank",
            () -> new BlockItem(ModBlocks.DARK_OAK_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_WATER_TANK = addToTab(ITEMS.register("mangrove_water_tank",
            () -> new BlockItem(ModBlocks.MANGROVE_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_WATER_TANK = addToTab(ITEMS.register("cherry_water_tank",
            () -> new BlockItem(ModBlocks.CHERRY_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_WATER_TANK = addToTab(ITEMS.register("crimson_water_tank",
            () -> new BlockItem(ModBlocks.CRIMSON_WATER_TANK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_WATER_TANK = addToTab(ITEMS.register("warped_water_tank",
            () -> new BlockItem(ModBlocks.WARPED_WATER_TANK.get(), new Item.Properties())));

    // Appliances and Electronics
    public static final DeferredItem<BlockItem> ELECTRIC_FENCE = addToTab(ITEMS.register("electric_fence",
            () -> new BlockItem(ModBlocks.ELECTRIC_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BATH_LIGHT = addToTab(ITEMS.register("bath_light",
            () -> new BlockItem(ModBlocks.BATH_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BATH_DARK = addToTab(ITEMS.register("bath_dark",
            () -> new BlockItem(ModBlocks.BATH_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIN_LIGHT = addToTab(ITEMS.register("bin_light",
            () -> new BlockItem(ModBlocks.BIN_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIN_DARK = addToTab(ITEMS.register("bin_dark",
            () -> new BlockItem(ModBlocks.BIN_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLENDER_LIGHT = addToTab(ITEMS.register("blender_light",
            () -> new BlockItem(ModBlocks.BLENDER_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLENDER_DARK = addToTab(ITEMS.register("blender_dark",
            () -> new BlockItem(ModBlocks.BLENDER_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CATHODE_RAY_TUBE_TELEVISION = addToTab(ITEMS.register("cathode_ray_tube_television",
            () -> new BlockItem(ModBlocks.CATHODE_RAY_TUBE_TELEVISION.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> COMPUTER_LIGHT = addToTab(ITEMS.register("computer_light",
            () -> new BlockItem(ModBlocks.COMPUTER_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> COMPUTER_DARK = addToTab(ITEMS.register("computer_dark",
            () -> new BlockItem(ModBlocks.COMPUTER_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DISHWASHER_LIGHT = addToTab(ITEMS.register("dishwasher_light",
            () -> new BlockItem(ModBlocks.DISHWASHER_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DISHWASHER_DARK = addToTab(ITEMS.register("dishwasher_dark",
            () -> new BlockItem(ModBlocks.DISHWASHER_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> FIRE_ALARM = addToTab(ITEMS.register("fire_alarm",
            () -> new BlockItem(ModBlocks.FIRE_ALARM.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIQUID_CRYSTAL_DISPLAY_TELEVISION = addToTab(ITEMS.register("liquid_crystal_display_television",
            () -> new BlockItem(ModBlocks.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MICROWAVE_LIGHT = addToTab(ITEMS.register("microwave_light",
            () -> new BlockItem(ModBlocks.MICROWAVE_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MICROWAVE_DARK = addToTab(ITEMS.register("microwave_dark",
            () -> new BlockItem(ModBlocks.MICROWAVE_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> OVEN_LIGHT = addToTab(ITEMS.register("oven_light",
            () -> new BlockItem(ModBlocks.OVEN_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> OVEN_DARK = addToTab(ITEMS.register("oven_dark",
            () -> new BlockItem(ModBlocks.OVEN_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> OVEN_RANGE_HOOD_LIGHT = addToTab(ITEMS.register("oven_range_hood_light",
            () -> new BlockItem(ModBlocks.OVEN_RANGE_HOOD_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> OVEN_RANGE_HOOD_DARK = addToTab(ITEMS.register("oven_range_hood_dark",
            () -> new BlockItem(ModBlocks.OVEN_RANGE_HOOD_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PRINTER = addToTab(ITEMS.register("printer",
            () -> new BlockItem(ModBlocks.PRINTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SINK_LIGHT = addToTab(ITEMS.register("sink_light",
            () -> new BlockItem(ModBlocks.SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SINK_DARK = addToTab(ITEMS.register("sink_dark",
            () -> new BlockItem(ModBlocks.SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SHOWER_LIGHT = addToTab(ITEMS.register("shower_light",
            () -> new BlockItem(ModBlocks.SHOWER_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SHOWER_DARK = addToTab(ITEMS.register("shower_dark",
            () -> new BlockItem(ModBlocks.SHOWER_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SHOWER_HEAD_LIGHT = addToTab(ITEMS.register("shower_head_light",
            () -> new BlockItem(ModBlocks.SHOWER_HEAD_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SHOWER_HEAD_DARK = addToTab(ITEMS.register("shower_head_dark",
            () -> new BlockItem(ModBlocks.SHOWER_HEAD_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STEREO = addToTab(ITEMS.register("stereo",
            () -> new BlockItem(ModBlocks.STEREO.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> TOASTER_LIGHT = addToTab(ITEMS.register("toaster_light",
            () -> new BlockItem(ModBlocks.TOASTER_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> TOASTER_DARK = addToTab(ITEMS.register("toaster_dark",
            () -> new BlockItem(ModBlocks.TOASTER_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> TOILET_LIGHT = addToTab(ITEMS.register("toilet_light",
            () -> new BlockItem(ModBlocks.TOILET_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> TOILET_DARK = addToTab(ITEMS.register("toilet_dark",
            () -> new BlockItem(ModBlocks.TOILET_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WASHING_MACHINE_LIGHT = addToTab(ITEMS.register("washing_machine_light",
            () -> new BlockItem(ModBlocks.WASHING_MACHINE_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WASHING_MACHINE_DARK = addToTab(ITEMS.register("washing_machine_dark",
            () -> new BlockItem(ModBlocks.WASHING_MACHINE_DARK.get(), new Item.Properties())));

    // Digital Clocks
    public static final DeferredItem<BlockItem> WHITE_DIGITAL_CLOCK = addToTab(ITEMS.register("white_digital_clock",
            () -> new BlockItem(ModBlocks.WHITE_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_DIGITAL_CLOCK = addToTab(ITEMS.register("light_gray_digital_clock",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_DIGITAL_CLOCK = addToTab(ITEMS.register("gray_digital_clock",
            () -> new BlockItem(ModBlocks.GRAY_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_DIGITAL_CLOCK = addToTab(ITEMS.register("black_digital_clock",
            () -> new BlockItem(ModBlocks.BLACK_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_DIGITAL_CLOCK = addToTab(ITEMS.register("brown_digital_clock",
            () -> new BlockItem(ModBlocks.BROWN_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_DIGITAL_CLOCK = addToTab(ITEMS.register("red_digital_clock",
            () -> new BlockItem(ModBlocks.RED_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_DIGITAL_CLOCK = addToTab(ITEMS.register("orange_digital_clock",
            () -> new BlockItem(ModBlocks.ORANGE_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_DIGITAL_CLOCK = addToTab(ITEMS.register("beige_digital_clock",
            () -> new BlockItem(ModBlocks.BEIGE_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_DIGITAL_CLOCK = addToTab(ITEMS.register("yellow_digital_clock",
            () -> new BlockItem(ModBlocks.YELLOW_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_DIGITAL_CLOCK = addToTab(ITEMS.register("lime_digital_clock",
            () -> new BlockItem(ModBlocks.LIME_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_DIGITAL_CLOCK = addToTab(ITEMS.register("green_digital_clock",
            () -> new BlockItem(ModBlocks.GREEN_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_DIGITAL_CLOCK = addToTab(ITEMS.register("cyan_digital_clock",
            () -> new BlockItem(ModBlocks.CYAN_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_DIGITAL_CLOCK = addToTab(ITEMS.register("light_blue_digital_clock",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_DIGITAL_CLOCK = addToTab(ITEMS.register("blue_digital_clock",
            () -> new BlockItem(ModBlocks.BLUE_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_DIGITAL_CLOCK = addToTab(ITEMS.register("purple_digital_clock",
            () -> new BlockItem(ModBlocks.PURPLE_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_DIGITAL_CLOCK = addToTab(ITEMS.register("magenta_digital_clock",
            () -> new BlockItem(ModBlocks.MAGENTA_DIGITAL_CLOCK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_DIGITAL_CLOCK = addToTab(ITEMS.register("pink_digital_clock",
            () -> new BlockItem(ModBlocks.PINK_DIGITAL_CLOCK.get(), new Item.Properties())));

    // Festive Blocks
    public static final DeferredItem<BlockItem> CANDLE = addToTab(ITEMS.register("candle",
            () -> new BlockItem(ModBlocks.CANDLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHRISTMAS_TREE = addToTab(ITEMS.register("christmas_tree",
            () -> new BlockItem(ModBlocks.CHRISTMAS_TREE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WREATH = addToTab(ITEMS.register("wreath",
            () -> new BlockItem(ModBlocks.WREATH.get(), new Item.Properties())));

    // Food
    public static final DeferredItem<Item> BREAD_SLICE = addToTab(ITEMS.register("bread_slice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.2f).alwaysEdible().build()))));
    public static final DeferredItem<Item> KEBAB = addToTab(ITEMS.register("kebab",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).alwaysEdible().build()))));
    public static final DeferredItem<Item> COOKED_KEBAB = addToTab(ITEMS.register("cooked_kebab",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationModifier(0.2f).alwaysEdible().build()))));
    public static final DeferredItem<Item> SAUSAGE = addToTab(ITEMS.register("sausage",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).alwaysEdible().build()))));
    public static final DeferredItem<Item> COOKED_SAUSAGE = addToTab(ITEMS.register("cooked_sausage",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationModifier(0.2f).alwaysEdible().build()))));
    public static final DeferredItem<Item> TOAST = addToTab(ITEMS.register("toast",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationModifier(0.2f).alwaysEdible().build()))));

    // Supplies
    public static final DeferredItem<Item> INK_CARTRIDGE = addToTab(ITEMS.register("ink_cartridge",
            () -> new Item(new Item.Properties().durability(10000))));

    // Tools
    public static final DeferredItem<SwordItem> CROWBAR = addToTab(ITEMS.register("crowbar",
            () -> new SwordItem(Tiers.IRON, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.IRON, 3, -3.0F)))));
    public static final DeferredItem<SwordItem> KNIFE = addToTab(ITEMS.register("knife",
            () -> new SwordItem(Tiers.STONE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.STONE, 1, -2.4F)))));
    public static final DeferredItem<Item> SOAP = addToTab(ITEMS.register("soap",
            () -> new Item(new Item.Properties())));
    public static final DeferredItem<BucketItem> SOAPY_WATER_BUCKET = addToTab(ITEMS.register("soapy_water_bucket",
            () -> new BucketItem(ModFluids.SOAPY_WATER.get(), new Item.Properties().stacksTo(1))));
    public static final DeferredItem<BucketItem> SUPER_SOAPY_WATER_BUCKET = addToTab(ITEMS.register("super_soapy_water_bucket",
            () -> new BucketItem(ModFluids.SUPER_SOAPY_WATER.get(), new Item.Properties().stacksTo(1))));
    public static final DeferredItem<Item> TELEVISION_REMOTE = addToTab(ITEMS.register("television_remote",
            () -> new Item(new Item.Properties())));



}
