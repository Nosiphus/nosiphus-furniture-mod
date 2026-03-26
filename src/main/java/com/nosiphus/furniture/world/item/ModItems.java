package com.nosiphus.furniture.world.item;

import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
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


}
