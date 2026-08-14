package com.nosiphus.furniture.world.item;

import com.nosiphus.furniture.platform.Services;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static com.nosiphus.furniture.world.item.ModCreativeModeTabs.addToTab;

public class ModItems {

    public static void init() {

    }

    private static <T extends Item> Supplier<T> register(String name, Supplier<T> supplier) {
        return addToTab(Services.REGISTRY.registerItem(name, supplier));
    }

    private static <T extends Item> Supplier<T> registerOptional(String name, String requiredModId, Supplier<T> supplier) {
        if (Services.PLATFORM.isModLoaded(requiredModId)) {
            return register(name, supplier);
        }
        return () -> null;
    }

    private static Supplier<BlockItem> registerBlockItem(String name, Supplier<? extends Block> blockSupplier) {
        return register(name, () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
    }

    private static Supplier<BlockItem> registerOptionalBlockItem(String name, Supplier<? extends Block> blockSupplier) {
        return registerOptional(name, "yogmod", () -> new BlockItem(blockSupplier.get(), new Item.Properties()));
    }

    // Tables
    public static final Supplier<BlockItem> STONE_TABLE = registerBlockItem("stone_table", ModBlocks.STONE_TABLE);
    public static final Supplier<BlockItem> ANDESITE_TABLE = registerBlockItem("andesite_table", ModBlocks.ANDESITE_TABLE);
    public static final Supplier<BlockItem> DIORITE_TABLE = registerBlockItem("diorite_table", ModBlocks.DIORITE_TABLE);
    public static final Supplier<BlockItem> GRANITE_TABLE = registerBlockItem("granite_table", ModBlocks.GRANITE_TABLE);
    public static final Supplier<BlockItem> BLACKSTONE_TABLE = registerBlockItem("blackstone_table", ModBlocks.BLACKSTONE_TABLE);
    public static final Supplier<BlockItem> DEEPSLATE_TABLE = registerBlockItem("deepslate_table", ModBlocks.DEEPSLATE_TABLE);

    // Modern Tables
    public static final Supplier<BlockItem> WHITE_MODERN_TABLE = registerBlockItem("white_modern_table", ModBlocks.WHITE_MODERN_TABLE);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_TABLE = registerBlockItem("light_gray_modern_table", ModBlocks.LIGHT_GRAY_MODERN_TABLE);
    public static final Supplier<BlockItem> GRAY_MODERN_TABLE = registerBlockItem("gray_modern_table", ModBlocks.GRAY_MODERN_TABLE);
    public static final Supplier<BlockItem> BLACK_MODERN_TABLE = registerBlockItem("black_modern_table", ModBlocks.BLACK_MODERN_TABLE);
    public static final Supplier<BlockItem> BROWN_MODERN_TABLE = registerBlockItem("brown_modern_table", ModBlocks.BROWN_MODERN_TABLE);
    public static final Supplier<BlockItem> RED_MODERN_TABLE = registerBlockItem("red_modern_table", ModBlocks.RED_MODERN_TABLE);
    public static final Supplier<BlockItem> ORANGE_MODERN_TABLE = registerBlockItem("orange_modern_table", ModBlocks.ORANGE_MODERN_TABLE);
    public static final Supplier<BlockItem> BEIGE_MODERN_TABLE = registerOptionalBlockItem("beige_modern_table", ModBlocks.BEIGE_MODERN_TABLE);
    public static final Supplier<BlockItem> YELLOW_MODERN_TABLE = registerBlockItem("yellow_modern_table", ModBlocks.YELLOW_MODERN_TABLE);
    public static final Supplier<BlockItem> LIME_MODERN_TABLE = registerBlockItem("lime_modern_table", ModBlocks.LIME_MODERN_TABLE);
    public static final Supplier<BlockItem> GREEN_MODERN_TABLE = registerBlockItem("green_modern_table", ModBlocks.GREEN_MODERN_TABLE);
    public static final Supplier<BlockItem> CYAN_MODERN_TABLE = registerBlockItem("cyan_modern_table", ModBlocks.CYAN_MODERN_TABLE);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_TABLE = registerBlockItem("light_blue_modern_table", ModBlocks.LIGHT_BLUE_MODERN_TABLE);
    public static final Supplier<BlockItem> BLUE_MODERN_TABLE = registerBlockItem("blue_modern_table", ModBlocks.BLUE_MODERN_TABLE);
    public static final Supplier<BlockItem> PURPLE_MODERN_TABLE = registerBlockItem("purple_modern_table", ModBlocks.PURPLE_MODERN_TABLE);
    public static final Supplier<BlockItem> MAGENTA_MODERN_TABLE = registerBlockItem("magenta_modern_table", ModBlocks.MAGENTA_MODERN_TABLE);
    public static final Supplier<BlockItem> PINK_MODERN_TABLE = registerBlockItem("pink_modern_table", ModBlocks.PINK_MODERN_TABLE);

    // Chairs
    public static final Supplier<BlockItem> STONE_CHAIR = registerBlockItem("stone_chair", ModBlocks.STONE_CHAIR);
    public static final Supplier<BlockItem> ANDESITE_CHAIR = registerBlockItem("andesite_chair", ModBlocks.ANDESITE_CHAIR);
    public static final Supplier<BlockItem> DIORITE_CHAIR = registerBlockItem("diorite_chair", ModBlocks.DIORITE_CHAIR);
    public static final Supplier<BlockItem> GRANITE_CHAIR = registerBlockItem("granite_chair", ModBlocks.GRANITE_CHAIR);
    public static final Supplier<BlockItem> BLACKSTONE_CHAIR = registerBlockItem("blackstone_chair", ModBlocks.BLACKSTONE_CHAIR);
    public static final Supplier<BlockItem> DEEPSLATE_CHAIR = registerBlockItem("deepslate_chair", ModBlocks.DEEPSLATE_CHAIR);

    // Modern Chairs
    public static final Supplier<BlockItem> WHITE_MODERN_CHAIR = registerBlockItem("white_modern_chair", ModBlocks.WHITE_MODERN_CHAIR);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_CHAIR = registerBlockItem("light_gray_modern_chair", ModBlocks.LIGHT_GRAY_MODERN_CHAIR);
    public static final Supplier<BlockItem> GRAY_MODERN_CHAIR = registerBlockItem("gray_modern_chair", ModBlocks.GRAY_MODERN_CHAIR);
    public static final Supplier<BlockItem> BLACK_MODERN_CHAIR = registerBlockItem("black_modern_chair", ModBlocks.BLACK_MODERN_CHAIR);
    public static final Supplier<BlockItem> BROWN_MODERN_CHAIR = registerBlockItem("brown_modern_chair", ModBlocks.BROWN_MODERN_CHAIR);
    public static final Supplier<BlockItem> RED_MODERN_CHAIR = registerBlockItem("red_modern_chair", ModBlocks.RED_MODERN_CHAIR);
    public static final Supplier<BlockItem> ORANGE_MODERN_CHAIR = registerBlockItem("orange_modern_chair", ModBlocks.ORANGE_MODERN_CHAIR);
    public static final Supplier<BlockItem> BEIGE_MODERN_CHAIR = registerOptionalBlockItem("beige_modern_chair", ModBlocks.BEIGE_MODERN_CHAIR);
    public static final Supplier<BlockItem> YELLOW_MODERN_CHAIR = registerBlockItem("yellow_modern_chair", ModBlocks.YELLOW_MODERN_CHAIR);
    public static final Supplier<BlockItem> LIME_MODERN_CHAIR = registerBlockItem("lime_modern_chair", ModBlocks.LIME_MODERN_CHAIR);
    public static final Supplier<BlockItem> GREEN_MODERN_CHAIR = registerBlockItem("green_modern_chair", ModBlocks.GREEN_MODERN_CHAIR);
    public static final Supplier<BlockItem> CYAN_MODERN_CHAIR = registerBlockItem("cyan_modern_chair", ModBlocks.CYAN_MODERN_CHAIR);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_CHAIR = registerBlockItem("light_blue_modern_chair", ModBlocks.LIGHT_BLUE_MODERN_CHAIR);
    public static final Supplier<BlockItem> BLUE_MODERN_CHAIR = registerBlockItem("blue_modern_chair", ModBlocks.BLUE_MODERN_CHAIR);
    public static final Supplier<BlockItem> PURPLE_MODERN_CHAIR = registerBlockItem("purple_modern_chair", ModBlocks.PURPLE_MODERN_CHAIR);
    public static final Supplier<BlockItem> MAGENTA_MODERN_CHAIR = registerBlockItem("magenta_modern_chair", ModBlocks.MAGENTA_MODERN_CHAIR);
    public static final Supplier<BlockItem> PINK_MODERN_CHAIR = registerBlockItem("pink_modern_chair", ModBlocks.PINK_MODERN_CHAIR);

    // Coffee Tables
    public static final Supplier<BlockItem> STONE_COFFEE_TABLE = registerBlockItem("stone_coffee_table", ModBlocks.STONE_COFFEE_TABLE);
    public static final Supplier<BlockItem> ANDESITE_COFFEE_TABLE = registerBlockItem("andesite_coffee_table", ModBlocks.ANDESITE_COFFEE_TABLE);
    public static final Supplier<BlockItem> DIORITE_COFFEE_TABLE = registerBlockItem("diorite_coffee_table", ModBlocks.DIORITE_COFFEE_TABLE);
    public static final Supplier<BlockItem> GRANITE_COFFEE_TABLE = registerBlockItem("granite_coffee_table", ModBlocks.GRANITE_COFFEE_TABLE);
    public static final Supplier<BlockItem> BLACKSTONE_COFFEE_TABLE = registerBlockItem("blackstone_coffee_table", ModBlocks.BLACKSTONE_COFFEE_TABLE);
    public static final Supplier<BlockItem> DEEPSLATE_COFFEE_TABLE = registerBlockItem("deepslate_coffee_table", ModBlocks.DEEPSLATE_COFFEE_TABLE);

    // Modern Coffee Tables
    public static final Supplier<BlockItem> WHITE_MODERN_COFFEE_TABLE = registerBlockItem("white_modern_coffee_table", ModBlocks.WHITE_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_COFFEE_TABLE = registerBlockItem("light_gray_modern_coffee_table", ModBlocks.LIGHT_GRAY_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> GRAY_MODERN_COFFEE_TABLE = registerBlockItem("gray_modern_coffee_table", ModBlocks.GRAY_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> BLACK_MODERN_COFFEE_TABLE = registerBlockItem("black_modern_coffee_table", ModBlocks.BLACK_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> BROWN_MODERN_COFFEE_TABLE = registerBlockItem("brown_modern_coffee_table", ModBlocks.BROWN_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> RED_MODERN_COFFEE_TABLE = registerBlockItem("red_modern_coffee_table", ModBlocks.RED_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> ORANGE_MODERN_COFFEE_TABLE = registerBlockItem("orange_modern_coffee_table", ModBlocks.ORANGE_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> BEIGE_MODERN_COFFEE_TABLE = registerOptionalBlockItem("beige_modern_coffee_table", ModBlocks.BEIGE_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> YELLOW_MODERN_COFFEE_TABLE = registerBlockItem("yellow_modern_coffee_table", ModBlocks.YELLOW_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> LIME_MODERN_COFFEE_TABLE = registerBlockItem("lime_modern_coffee_table", ModBlocks.LIME_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> GREEN_MODERN_COFFEE_TABLE = registerBlockItem("green_modern_coffee_table", ModBlocks.GREEN_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> CYAN_MODERN_COFFEE_TABLE = registerBlockItem("cyan_modern_coffee_table", ModBlocks.CYAN_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_COFFEE_TABLE = registerBlockItem("light_blue_modern_coffee_table", ModBlocks.LIGHT_BLUE_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> BLUE_MODERN_COFFEE_TABLE = registerBlockItem("blue_modern_coffee_table", ModBlocks.BLUE_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> PURPLE_MODERN_COFFEE_TABLE = registerBlockItem("purple_modern_coffee_table", ModBlocks.PURPLE_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> MAGENTA_MODERN_COFFEE_TABLE = registerBlockItem("magenta_modern_coffee_table", ModBlocks.MAGENTA_MODERN_COFFEE_TABLE);
    public static final Supplier<BlockItem> PINK_MODERN_COFFEE_TABLE = registerBlockItem("pink_modern_coffee_table", ModBlocks.PINK_MODERN_COFFEE_TABLE);

    // Cabinets
    public static final Supplier<BlockItem> STONE_CABINET = registerBlockItem("stone_cabinet", ModBlocks.STONE_CABINET);
    public static final Supplier<BlockItem> ANDESITE_CABINET = registerBlockItem("andesite_cabinet", ModBlocks.ANDESITE_CABINET);
    public static final Supplier<BlockItem> DIORITE_CABINET = registerBlockItem("diorite_cabinet", ModBlocks.DIORITE_CABINET);
    public static final Supplier<BlockItem> GRANITE_CABINET = registerBlockItem("granite_cabinet", ModBlocks.GRANITE_CABINET);
    public static final Supplier<BlockItem> BLACKSTONE_CABINET = registerBlockItem("blackstone_cabinet", ModBlocks.BLACKSTONE_CABINET);
    public static final Supplier<BlockItem> DEEPSLATE_CABINET = registerBlockItem("deepslate_cabinet", ModBlocks.DEEPSLATE_CABINET);

    // Modern Cabinets
    public static final Supplier<BlockItem> WHITE_MODERN_CABINET = registerBlockItem("white_modern_cabinet", ModBlocks.WHITE_MODERN_CABINET);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_CABINET = registerBlockItem("light_gray_modern_cabinet", ModBlocks.LIGHT_GRAY_MODERN_CABINET);
    public static final Supplier<BlockItem> GRAY_MODERN_CABINET = registerBlockItem("gray_modern_cabinet", ModBlocks.GRAY_MODERN_CABINET);
    public static final Supplier<BlockItem> BLACK_MODERN_CABINET = registerBlockItem("black_modern_cabinet", ModBlocks.BLACK_MODERN_CABINET);
    public static final Supplier<BlockItem> BROWN_MODERN_CABINET = registerBlockItem("brown_modern_cabinet", ModBlocks.BROWN_MODERN_CABINET);
    public static final Supplier<BlockItem> RED_MODERN_CABINET = registerBlockItem("red_modern_cabinet", ModBlocks.RED_MODERN_CABINET);
    public static final Supplier<BlockItem> ORANGE_MODERN_CABINET = registerBlockItem("orange_modern_cabinet", ModBlocks.ORANGE_MODERN_CABINET);
    public static final Supplier<BlockItem> BEIGE_MODERN_CABINET = registerOptionalBlockItem("beige_modern_cabinet", ModBlocks.BEIGE_MODERN_CABINET);
    public static final Supplier<BlockItem> YELLOW_MODERN_CABINET = registerBlockItem("yellow_modern_cabinet", ModBlocks.YELLOW_MODERN_CABINET);
    public static final Supplier<BlockItem> LIME_MODERN_CABINET = registerBlockItem("lime_modern_cabinet", ModBlocks.LIME_MODERN_CABINET);
    public static final Supplier<BlockItem> GREEN_MODERN_CABINET = registerBlockItem("green_modern_cabinet", ModBlocks.GREEN_MODERN_CABINET);
    public static final Supplier<BlockItem> CYAN_MODERN_CABINET = registerBlockItem("cyan_modern_cabinet", ModBlocks.CYAN_MODERN_CABINET);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_CABINET = registerBlockItem("light_blue_modern_cabinet", ModBlocks.LIGHT_BLUE_MODERN_CABINET);
    public static final Supplier<BlockItem> BLUE_MODERN_CABINET = registerBlockItem("blue_modern_cabinet", ModBlocks.BLUE_MODERN_CABINET);
    public static final Supplier<BlockItem> PURPLE_MODERN_CABINET = registerBlockItem("purple_modern_cabinet", ModBlocks.PURPLE_MODERN_CABINET);
    public static final Supplier<BlockItem> MAGENTA_MODERN_CABINET = registerBlockItem("magenta_modern_cabinet", ModBlocks.MAGENTA_MODERN_CABINET);
    public static final Supplier<BlockItem> PINK_MODERN_CABINET = registerBlockItem("pink_modern_cabinet", ModBlocks.PINK_MODERN_CABINET);

    // Bedside Cabinets
    public static final Supplier<BlockItem> STONE_BEDSIDE_CABINET = registerBlockItem("stone_bedside_cabinet", ModBlocks.STONE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> ANDESITE_BEDSIDE_CABINET = registerBlockItem("andesite_bedside_cabinet", ModBlocks.ANDESITE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> DIORITE_BEDSIDE_CABINET = registerBlockItem("diorite_bedside_cabinet", ModBlocks.DIORITE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> GRANITE_BEDSIDE_CABINET = registerBlockItem("granite_bedside_cabinet", ModBlocks.GRANITE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> BLACKSTONE_BEDSIDE_CABINET = registerBlockItem("blackstone_bedside_cabinet", ModBlocks.BLACKSTONE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> DEEPSLATE_BEDSIDE_CABINET = registerBlockItem("deepslate_bedside_cabinet", ModBlocks.DEEPSLATE_BEDSIDE_CABINET);

    // Modern Bedside Cabinets
    public static final Supplier<BlockItem> WHITE_MODERN_BEDSIDE_CABINET = registerBlockItem("white_modern_bedside_cabinet", ModBlocks.WHITE_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_BEDSIDE_CABINET = registerBlockItem("light_gray_modern_bedside_cabinet", ModBlocks.LIGHT_GRAY_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> GRAY_MODERN_BEDSIDE_CABINET = registerBlockItem("gray_modern_bedside_cabinet", ModBlocks.GRAY_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> BLACK_MODERN_BEDSIDE_CABINET = registerBlockItem("black_modern_bedside_cabinet", ModBlocks.BLACK_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> BROWN_MODERN_BEDSIDE_CABINET = registerBlockItem("brown_modern_bedside_cabinet", ModBlocks.BROWN_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> RED_MODERN_BEDSIDE_CABINET = registerBlockItem("red_modern_bedside_cabinet", ModBlocks.RED_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> ORANGE_MODERN_BEDSIDE_CABINET = registerBlockItem("orange_modern_bedside_cabinet", ModBlocks.ORANGE_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> BEIGE_MODERN_BEDSIDE_CABINET = registerOptionalBlockItem("beige_modern_bedside_cabinet", ModBlocks.BEIGE_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> YELLOW_MODERN_BEDSIDE_CABINET = registerBlockItem("yellow_modern_bedside_cabinet", ModBlocks.YELLOW_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> LIME_MODERN_BEDSIDE_CABINET = registerBlockItem("lime_modern_bedside_cabinet", ModBlocks.LIME_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> GREEN_MODERN_BEDSIDE_CABINET = registerBlockItem("green_modern_bedside_cabinet", ModBlocks.GREEN_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> CYAN_MODERN_BEDSIDE_CABINET = registerBlockItem("cyan_modern_bedside_cabinet", ModBlocks.CYAN_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_BEDSIDE_CABINET = registerBlockItem("light_blue_modern_bedside_cabinet", ModBlocks.LIGHT_BLUE_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> BLUE_MODERN_BEDSIDE_CABINET = registerBlockItem("blue_modern_bedside_cabinet", ModBlocks.BLUE_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> PURPLE_MODERN_BEDSIDE_CABINET = registerBlockItem("purple_modern_bedside_cabinet", ModBlocks.PURPLE_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> MAGENTA_MODERN_BEDSIDE_CABINET = registerBlockItem("magenta_modern_bedside_cabinet", ModBlocks.MAGENTA_MODERN_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> PINK_MODERN_BEDSIDE_CABINET = registerBlockItem("pink_modern_bedside_cabinet", ModBlocks.PINK_MODERN_BEDSIDE_CABINET);

    // Modern Beds
    public static final Supplier<BlockItem> WHITE_MODERN_BED = registerBlockItem("white_modern_bed", ModBlocks.WHITE_MODERN_BED);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_BED = registerBlockItem("light_gray_modern_bed", ModBlocks.LIGHT_GRAY_MODERN_BED);
    public static final Supplier<BlockItem> GRAY_MODERN_BED = registerBlockItem("gray_modern_bed", ModBlocks.GRAY_MODERN_BED);
    public static final Supplier<BlockItem> BLACK_MODERN_BED = registerBlockItem("black_modern_bed", ModBlocks.BLACK_MODERN_BED);
    public static final Supplier<BlockItem> BROWN_MODERN_BED = registerBlockItem("brown_modern_bed", ModBlocks.BROWN_MODERN_BED);
    public static final Supplier<BlockItem> RED_MODERN_BED = registerBlockItem("red_modern_bed", ModBlocks.RED_MODERN_BED);
    public static final Supplier<BlockItem> ORANGE_MODERN_BED = registerBlockItem("orange_modern_bed", ModBlocks.ORANGE_MODERN_BED);
    public static final Supplier<BlockItem> BEIGE_MODERN_BED = registerOptionalBlockItem("beige_modern_bed", ModBlocks.BEIGE_MODERN_BED);
    public static final Supplier<BlockItem> YELLOW_MODERN_BED = registerBlockItem("yellow_modern_bed", ModBlocks.YELLOW_MODERN_BED);
    public static final Supplier<BlockItem> LIME_MODERN_BED = registerBlockItem("lime_modern_bed", ModBlocks.LIME_MODERN_BED);
    public static final Supplier<BlockItem> GREEN_MODERN_BED = registerBlockItem("green_modern_bed", ModBlocks.GREEN_MODERN_BED);
    public static final Supplier<BlockItem> CYAN_MODERN_BED = registerBlockItem("cyan_modern_bed", ModBlocks.CYAN_MODERN_BED);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_BED = registerBlockItem("light_blue_modern_bed", ModBlocks.LIGHT_BLUE_MODERN_BED);
    public static final Supplier<BlockItem> BLUE_MODERN_BED = registerBlockItem("blue_modern_bed", ModBlocks.BLUE_MODERN_BED);
    public static final Supplier<BlockItem> PURPLE_MODERN_BED = registerBlockItem("purple_modern_bed", ModBlocks.PURPLE_MODERN_BED);
    public static final Supplier<BlockItem> MAGENTA_MODERN_BED = registerBlockItem("magenta_modern_bed", ModBlocks.MAGENTA_MODERN_BED);
    public static final Supplier<BlockItem> PINK_MODERN_BED = registerBlockItem("pink_modern_bed", ModBlocks.PINK_MODERN_BED);

    // Curtains
    public static final Supplier<BlockItem> WHITE_CURTAIN = registerBlockItem("white_curtain", ModBlocks.WHITE_CURTAIN);
    public static final Supplier<BlockItem> LIGHT_GRAY_CURTAIN = registerBlockItem("light_gray_curtain", ModBlocks.LIGHT_GRAY_CURTAIN);
    public static final Supplier<BlockItem> GRAY_CURTAIN = registerBlockItem("gray_curtain", ModBlocks.GRAY_CURTAIN);
    public static final Supplier<BlockItem> BLACK_CURTAIN = registerBlockItem("black_curtain", ModBlocks.BLACK_CURTAIN);
    public static final Supplier<BlockItem> BROWN_CURTAIN = registerBlockItem("brown_curtain", ModBlocks.BROWN_CURTAIN);
    public static final Supplier<BlockItem> RED_CURTAIN = registerBlockItem("red_curtain", ModBlocks.RED_CURTAIN);
    public static final Supplier<BlockItem> ORANGE_CURTAIN = registerBlockItem("orange_curtain", ModBlocks.ORANGE_CURTAIN);
    public static final Supplier<BlockItem> BEIGE_CURTAIN = registerOptionalBlockItem("beige_curtain", ModBlocks.BEIGE_CURTAIN);
    public static final Supplier<BlockItem> YELLOW_CURTAIN = registerBlockItem("yellow_curtain", ModBlocks.YELLOW_CURTAIN);
    public static final Supplier<BlockItem> LIME_CURTAIN = registerBlockItem("lime_curtain", ModBlocks.LIME_CURTAIN);
    public static final Supplier<BlockItem> GREEN_CURTAIN = registerBlockItem("green_curtain", ModBlocks.GREEN_CURTAIN);
    public static final Supplier<BlockItem> CYAN_CURTAIN = registerBlockItem("cyan_curtain", ModBlocks.CYAN_CURTAIN);
    public static final Supplier<BlockItem> LIGHT_BLUE_CURTAIN = registerBlockItem("light_blue_curtain", ModBlocks.LIGHT_BLUE_CURTAIN);
    public static final Supplier<BlockItem> BLUE_CURTAIN = registerBlockItem("blue_curtain", ModBlocks.BLUE_CURTAIN);
    public static final Supplier<BlockItem> PURPLE_CURTAIN = registerBlockItem("purple_curtain", ModBlocks.PURPLE_CURTAIN);
    public static final Supplier<BlockItem> MAGENTA_CURTAIN = registerBlockItem("magenta_curtain", ModBlocks.MAGENTA_CURTAIN);
    public static final Supplier<BlockItem> PINK_CURTAIN = registerBlockItem("pink_curtain", ModBlocks.PINK_CURTAIN);

    // Desks
    public static final Supplier<BlockItem> STONE_DESK = registerBlockItem("stone_desk", ModBlocks.STONE_DESK);
    public static final Supplier<BlockItem> ANDESITE_DESK = registerBlockItem("andesite_desk", ModBlocks.ANDESITE_DESK);
    public static final Supplier<BlockItem> DIORITE_DESK = registerBlockItem("diorite_desk", ModBlocks.DIORITE_DESK);
    public static final Supplier<BlockItem> GRANITE_DESK = registerBlockItem("granite_desk", ModBlocks.GRANITE_DESK);
    public static final Supplier<BlockItem> BLACKSTONE_DESK = registerBlockItem("blackstone_desk", ModBlocks.BLACKSTONE_DESK);
    public static final Supplier<BlockItem> DEEPSLATE_DESK = registerBlockItem("deepslate_desk", ModBlocks.DEEPSLATE_DESK);

    // Modern Desks
    public static final Supplier<BlockItem> WHITE_MODERN_DESK = registerBlockItem("white_modern_desk", ModBlocks.WHITE_MODERN_DESK);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_DESK = registerBlockItem("light_gray_modern_desk", ModBlocks.LIGHT_GRAY_MODERN_DESK);
    public static final Supplier<BlockItem> GRAY_MODERN_DESK = registerBlockItem("gray_modern_desk", ModBlocks.GRAY_MODERN_DESK);
    public static final Supplier<BlockItem> BLACK_MODERN_DESK = registerBlockItem("black_modern_desk", ModBlocks.BLACK_MODERN_DESK);
    public static final Supplier<BlockItem> BROWN_MODERN_DESK = registerBlockItem("brown_modern_desk", ModBlocks.BROWN_MODERN_DESK);
    public static final Supplier<BlockItem> RED_MODERN_DESK = registerBlockItem("red_modern_desk", ModBlocks.RED_MODERN_DESK);
    public static final Supplier<BlockItem> ORANGE_MODERN_DESK = registerBlockItem("orange_modern_desk", ModBlocks.ORANGE_MODERN_DESK);
    public static final Supplier<BlockItem> BEIGE_MODERN_DESK = registerOptionalBlockItem("beige_modern_desk", ModBlocks.BEIGE_MODERN_DESK);
    public static final Supplier<BlockItem> YELLOW_MODERN_DESK = registerBlockItem("yellow_modern_desk", ModBlocks.YELLOW_MODERN_DESK);
    public static final Supplier<BlockItem> LIME_MODERN_DESK = registerBlockItem("lime_modern_desk", ModBlocks.LIME_MODERN_DESK);
    public static final Supplier<BlockItem> GREEN_MODERN_DESK = registerBlockItem("green_modern_desk", ModBlocks.GREEN_MODERN_DESK);
    public static final Supplier<BlockItem> CYAN_MODERN_DESK = registerBlockItem("cyan_modern_desk", ModBlocks.CYAN_MODERN_DESK);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_DESK = registerBlockItem("light_blue_modern_desk", ModBlocks.LIGHT_BLUE_MODERN_DESK);
    public static final Supplier<BlockItem> BLUE_MODERN_DESK = registerBlockItem("blue_modern_desk", ModBlocks.BLUE_MODERN_DESK);
    public static final Supplier<BlockItem> PURPLE_MODERN_DESK = registerBlockItem("purple_modern_desk", ModBlocks.PURPLE_MODERN_DESK);
    public static final Supplier<BlockItem> MAGENTA_MODERN_DESK = registerBlockItem("magenta_modern_desk", ModBlocks.MAGENTA_MODERN_DESK);
    public static final Supplier<BlockItem> PINK_MODERN_DESK = registerBlockItem("pink_modern_desk", ModBlocks.PINK_MODERN_DESK);

    // Desk Cabinets
    public static final Supplier<BlockItem> STONE_DESK_CABINET = registerBlockItem("stone_desk_cabinet", ModBlocks.STONE_DESK_CABINET);
    public static final Supplier<BlockItem> ANDESITE_DESK_CABINET = registerBlockItem("andesite_desk_cabinet", ModBlocks.ANDESITE_DESK_CABINET);
    public static final Supplier<BlockItem> DIORITE_DESK_CABINET = registerBlockItem("diorite_desk_cabinet", ModBlocks.DIORITE_DESK_CABINET);
    public static final Supplier<BlockItem> GRANITE_DESK_CABINET = registerBlockItem("granite_desk_cabinet", ModBlocks.GRANITE_DESK_CABINET);
    public static final Supplier<BlockItem> BLACKSTONE_DESK_CABINET = registerBlockItem("blackstone_desk_cabinet", ModBlocks.BLACKSTONE_DESK_CABINET);
    public static final Supplier<BlockItem> DEEPSLATE_DESK_CABINET = registerBlockItem("deepslate_desk_cabinet", ModBlocks.DEEPSLATE_DESK_CABINET);

    // Modern Desk Cabinets
    public static final Supplier<BlockItem> WHITE_MODERN_DESK_CABINET = registerBlockItem("white_modern_desk_cabinet", ModBlocks.WHITE_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_DESK_CABINET = registerBlockItem("light_gray_modern_desk_cabinet", ModBlocks.LIGHT_GRAY_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> GRAY_MODERN_DESK_CABINET = registerBlockItem("gray_modern_desk_cabinet", ModBlocks.GRAY_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> BLACK_MODERN_DESK_CABINET = registerBlockItem("black_modern_desk_cabinet", ModBlocks.BLACK_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> BROWN_MODERN_DESK_CABINET = registerBlockItem("brown_modern_desk_cabinet", ModBlocks.BROWN_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> RED_MODERN_DESK_CABINET = registerBlockItem("red_modern_desk_cabinet", ModBlocks.RED_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> ORANGE_MODERN_DESK_CABINET = registerBlockItem("orange_modern_desk_cabinet", ModBlocks.ORANGE_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> BEIGE_MODERN_DESK_CABINET = registerOptionalBlockItem("beige_modern_desk_cabinet", ModBlocks.BEIGE_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> YELLOW_MODERN_DESK_CABINET = registerBlockItem("yellow_modern_desk_cabinet", ModBlocks.YELLOW_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> LIME_MODERN_DESK_CABINET = registerBlockItem("lime_modern_desk_cabinet", ModBlocks.LIME_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> GREEN_MODERN_DESK_CABINET = registerBlockItem("green_modern_desk_cabinet", ModBlocks.GREEN_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> CYAN_MODERN_DESK_CABINET = registerBlockItem("cyan_modern_desk_cabinet", ModBlocks.CYAN_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_DESK_CABINET = registerBlockItem("light_blue_modern_desk_cabinet", ModBlocks.LIGHT_BLUE_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> BLUE_MODERN_DESK_CABINET = registerBlockItem("blue_modern_desk_cabinet", ModBlocks.BLUE_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> PURPLE_MODERN_DESK_CABINET = registerBlockItem("purple_modern_desk_cabinet", ModBlocks.PURPLE_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> MAGENTA_MODERN_DESK_CABINET = registerBlockItem("magenta_modern_desk_cabinet", ModBlocks.MAGENTA_MODERN_DESK_CABINET);
    public static final Supplier<BlockItem> PINK_MODERN_DESK_CABINET = registerBlockItem("pink_modern_desk_cabinet", ModBlocks.PINK_MODERN_DESK_CABINET);

    // Wall Cabinets
    public static final Supplier<BlockItem> WHITE_WALL_CABINET = registerBlockItem("white_wall_cabinet", ModBlocks.WHITE_WALL_CABINET);
    public static final Supplier<BlockItem> LIGHT_GRAY_WALL_CABINET = registerBlockItem("light_gray_wall_cabinet", ModBlocks.LIGHT_GRAY_WALL_CABINET);
    public static final Supplier<BlockItem> GRAY_WALL_CABINET = registerBlockItem("gray_wall_cabinet", ModBlocks.GRAY_WALL_CABINET);
    public static final Supplier<BlockItem> BLACK_WALL_CABINET = registerBlockItem("black_wall_cabinet", ModBlocks.BLACK_WALL_CABINET);
    public static final Supplier<BlockItem> BROWN_WALL_CABINET = registerBlockItem("brown_wall_cabinet", ModBlocks.BROWN_WALL_CABINET);
    public static final Supplier<BlockItem> RED_WALL_CABINET = registerBlockItem("red_wall_cabinet", ModBlocks.RED_WALL_CABINET);
    public static final Supplier<BlockItem> ORANGE_WALL_CABINET = registerBlockItem("orange_wall_cabinet", ModBlocks.ORANGE_WALL_CABINET);
    public static final Supplier<BlockItem> BEIGE_WALL_CABINET = registerOptionalBlockItem("beige_wall_cabinet", ModBlocks.BEIGE_WALL_CABINET);
    public static final Supplier<BlockItem> YELLOW_WALL_CABINET = registerBlockItem("yellow_wall_cabinet", ModBlocks.YELLOW_WALL_CABINET);
    public static final Supplier<BlockItem> LIME_WALL_CABINET = registerBlockItem("lime_wall_cabinet", ModBlocks.LIME_WALL_CABINET);
    public static final Supplier<BlockItem> GREEN_WALL_CABINET = registerBlockItem("green_wall_cabinet", ModBlocks.GREEN_WALL_CABINET);
    public static final Supplier<BlockItem> CYAN_WALL_CABINET = registerBlockItem("cyan_wall_cabinet", ModBlocks.CYAN_WALL_CABINET);
    public static final Supplier<BlockItem> LIGHT_BLUE_WALL_CABINET = registerBlockItem("light_blue_wall_cabinet", ModBlocks.LIGHT_BLUE_WALL_CABINET);
    public static final Supplier<BlockItem> BLUE_WALL_CABINET = registerBlockItem("blue_wall_cabinet", ModBlocks.BLUE_WALL_CABINET);
    public static final Supplier<BlockItem> PURPLE_WALL_CABINET = registerBlockItem("purple_wall_cabinet", ModBlocks.PURPLE_WALL_CABINET);
    public static final Supplier<BlockItem> MAGENTA_WALL_CABINET = registerBlockItem("magenta_wall_cabinet", ModBlocks.MAGENTA_WALL_CABINET);
    public static final Supplier<BlockItem> PINK_WALL_CABINET = registerBlockItem("pink_wall_cabinet", ModBlocks.PINK_WALL_CABINET);

    // Modern Sofas
    public static final Supplier<BlockItem> WHITE_MODERN_SOFA = registerBlockItem("white_modern_sofa", ModBlocks.WHITE_MODERN_SOFA);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_SOFA = registerBlockItem("light_gray_modern_sofa", ModBlocks.LIGHT_GRAY_MODERN_SOFA);
    public static final Supplier<BlockItem> GRAY_MODERN_SOFA = registerBlockItem("gray_modern_sofa", ModBlocks.GRAY_MODERN_SOFA);
    public static final Supplier<BlockItem> BLACK_MODERN_SOFA = registerBlockItem("black_modern_sofa", ModBlocks.BLACK_MODERN_SOFA);
    public static final Supplier<BlockItem> BROWN_MODERN_SOFA = registerBlockItem("brown_modern_sofa", ModBlocks.BROWN_MODERN_SOFA);
    public static final Supplier<BlockItem> RED_MODERN_SOFA = registerBlockItem("red_modern_sofa", ModBlocks.RED_MODERN_SOFA);
    public static final Supplier<BlockItem> ORANGE_MODERN_SOFA = registerBlockItem("orange_modern_sofa", ModBlocks.ORANGE_MODERN_SOFA);
    public static final Supplier<BlockItem> BEIGE_MODERN_SOFA = registerOptionalBlockItem("beige_modern_sofa", ModBlocks.BEIGE_MODERN_SOFA);
    public static final Supplier<BlockItem> YELLOW_MODERN_SOFA = registerBlockItem("yellow_modern_sofa", ModBlocks.YELLOW_MODERN_SOFA);
    public static final Supplier<BlockItem> LIME_MODERN_SOFA = registerBlockItem("lime_modern_sofa", ModBlocks.LIME_MODERN_SOFA);
    public static final Supplier<BlockItem> GREEN_MODERN_SOFA = registerBlockItem("green_modern_sofa", ModBlocks.GREEN_MODERN_SOFA);
    public static final Supplier<BlockItem> CYAN_MODERN_SOFA = registerBlockItem("cyan_modern_sofa", ModBlocks.CYAN_MODERN_SOFA);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_SOFA = registerBlockItem("light_blue_modern_sofa", ModBlocks.LIGHT_BLUE_MODERN_SOFA);
    public static final Supplier<BlockItem> BLUE_MODERN_SOFA = registerBlockItem("blue_modern_sofa", ModBlocks.BLUE_MODERN_SOFA);
    public static final Supplier<BlockItem> PURPLE_MODERN_SOFA = registerBlockItem("purple_modern_sofa", ModBlocks.PURPLE_MODERN_SOFA);
    public static final Supplier<BlockItem> MAGENTA_MODERN_SOFA = registerBlockItem("magenta_modern_sofa", ModBlocks.MAGENTA_MODERN_SOFA);
    public static final Supplier<BlockItem> PINK_MODERN_SOFA = registerBlockItem("pink_modern_sofa", ModBlocks.PINK_MODERN_SOFA);

    // Television Stands
    public static final Supplier<BlockItem> WHITE_TELEVISION_STAND = registerBlockItem("white_television_stand", ModBlocks.WHITE_TELEVISION_STAND);
    public static final Supplier<BlockItem> LIGHT_GRAY_TELEVISION_STAND = registerBlockItem("light_gray_television_stand", ModBlocks.LIGHT_GRAY_TELEVISION_STAND);
    public static final Supplier<BlockItem> GRAY_TELEVISION_STAND = registerBlockItem("gray_television_stand", ModBlocks.GRAY_TELEVISION_STAND);
    public static final Supplier<BlockItem> BLACK_TELEVISION_STAND = registerBlockItem("black_television_stand", ModBlocks.BLACK_TELEVISION_STAND);
    public static final Supplier<BlockItem> BROWN_TELEVISION_STAND = registerBlockItem("brown_television_stand", ModBlocks.BROWN_TELEVISION_STAND);
    public static final Supplier<BlockItem> RED_TELEVISION_STAND = registerBlockItem("red_television_stand", ModBlocks.RED_TELEVISION_STAND);
    public static final Supplier<BlockItem> ORANGE_TELEVISION_STAND = registerBlockItem("orange_television_stand", ModBlocks.ORANGE_TELEVISION_STAND);
    public static final Supplier<BlockItem> BEIGE_TELEVISION_STAND = registerOptionalBlockItem("beige_television_stand", ModBlocks.BEIGE_TELEVISION_STAND);
    public static final Supplier<BlockItem> YELLOW_TELEVISION_STAND = registerBlockItem("yellow_television_stand", ModBlocks.YELLOW_TELEVISION_STAND);
    public static final Supplier<BlockItem> LIME_TELEVISION_STAND = registerBlockItem("lime_television_stand", ModBlocks.LIME_TELEVISION_STAND);
    public static final Supplier<BlockItem> GREEN_TELEVISION_STAND = registerBlockItem("green_television_stand", ModBlocks.GREEN_TELEVISION_STAND);
    public static final Supplier<BlockItem> CYAN_TELEVISION_STAND = registerBlockItem("cyan_television_stand", ModBlocks.CYAN_TELEVISION_STAND);
    public static final Supplier<BlockItem> LIGHT_BLUE_TELEVISION_STAND = registerBlockItem("light_blue_television_stand", ModBlocks.LIGHT_BLUE_TELEVISION_STAND);
    public static final Supplier<BlockItem> BLUE_TELEVISION_STAND = registerBlockItem("blue_television_stand", ModBlocks.BLUE_TELEVISION_STAND);
    public static final Supplier<BlockItem> PURPLE_TELEVISION_STAND = registerBlockItem("purple_television_stand", ModBlocks.PURPLE_TELEVISION_STAND);
    public static final Supplier<BlockItem> MAGENTA_TELEVISION_STAND = registerBlockItem("magenta_television_stand", ModBlocks.MAGENTA_TELEVISION_STAND);
    public static final Supplier<BlockItem> PINK_TELEVISION_STAND = registerBlockItem("pink_television_stand", ModBlocks.PINK_TELEVISION_STAND);

    // Lamps
    public static final Supplier<BlockItem> WHITE_LAMP = registerBlockItem("white_lamp", ModBlocks.WHITE_LAMP);
    public static final Supplier<BlockItem> LIGHT_GRAY_LAMP = registerBlockItem("light_gray_lamp", ModBlocks.LIGHT_GRAY_LAMP);
    public static final Supplier<BlockItem> GRAY_LAMP = registerBlockItem("gray_lamp", ModBlocks.GRAY_LAMP);
    public static final Supplier<BlockItem> BLACK_LAMP = registerBlockItem("black_lamp", ModBlocks.BLACK_LAMP);
    public static final Supplier<BlockItem> BROWN_LAMP = registerBlockItem("brown_lamp", ModBlocks.BROWN_LAMP);
    public static final Supplier<BlockItem> RED_LAMP = registerBlockItem("red_lamp", ModBlocks.RED_LAMP);
    public static final Supplier<BlockItem> ORANGE_LAMP = registerBlockItem("orange_lamp", ModBlocks.ORANGE_LAMP);
    public static final Supplier<BlockItem> BEIGE_LAMP = registerOptionalBlockItem("beige_lamp", ModBlocks.BEIGE_LAMP);
    public static final Supplier<BlockItem> YELLOW_LAMP = registerBlockItem("yellow_lamp", ModBlocks.YELLOW_LAMP);
    public static final Supplier<BlockItem> LIME_LAMP = registerBlockItem("lime_lamp", ModBlocks.LIME_LAMP);
    public static final Supplier<BlockItem> GREEN_LAMP = registerBlockItem("green_lamp", ModBlocks.GREEN_LAMP);
    public static final Supplier<BlockItem> CYAN_LAMP = registerBlockItem("cyan_lamp", ModBlocks.CYAN_LAMP);
    public static final Supplier<BlockItem> LIGHT_BLUE_LAMP = registerBlockItem("light_blue_lamp", ModBlocks.LIGHT_BLUE_LAMP);
    public static final Supplier<BlockItem> BLUE_LAMP = registerBlockItem("blue_lamp", ModBlocks.BLUE_LAMP);
    public static final Supplier<BlockItem> PURPLE_LAMP = registerBlockItem("purple_lamp", ModBlocks.PURPLE_LAMP);
    public static final Supplier<BlockItem> MAGENTA_LAMP = registerBlockItem("magenta_lamp", ModBlocks.MAGENTA_LAMP);
    public static final Supplier<BlockItem> PINK_LAMP = registerBlockItem("pink_lamp", ModBlocks.PINK_LAMP);

    // Modern Kitchen Counters
    public static final Supplier<BlockItem> WHITE_MODERN_KITCHEN_COUNTER = registerBlockItem("white_modern_kitchen_counter", ModBlocks.WHITE_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_KITCHEN_COUNTER = registerBlockItem("light_gray_modern_kitchen_counter", ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> GRAY_MODERN_KITCHEN_COUNTER = registerBlockItem("gray_modern_kitchen_counter", ModBlocks.GRAY_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BLACK_MODERN_KITCHEN_COUNTER = registerBlockItem("black_modern_kitchen_counter", ModBlocks.BLACK_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BROWN_MODERN_KITCHEN_COUNTER = registerBlockItem("brown_modern_kitchen_counter", ModBlocks.BROWN_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> RED_MODERN_KITCHEN_COUNTER = registerBlockItem("red_modern_kitchen_counter", ModBlocks.RED_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> ORANGE_MODERN_KITCHEN_COUNTER = registerBlockItem("orange_modern_kitchen_counter", ModBlocks.ORANGE_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BEIGE_MODERN_KITCHEN_COUNTER = registerOptionalBlockItem("beige_modern_kitchen_counter", ModBlocks.BEIGE_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> YELLOW_MODERN_KITCHEN_COUNTER = registerBlockItem("yellow_modern_kitchen_counter", ModBlocks.YELLOW_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> LIME_MODERN_KITCHEN_COUNTER = registerBlockItem("lime_modern_kitchen_counter", ModBlocks.LIME_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> GREEN_MODERN_KITCHEN_COUNTER = registerBlockItem("green_modern_kitchen_counter", ModBlocks.GREEN_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> CYAN_MODERN_KITCHEN_COUNTER = registerBlockItem("cyan_modern_kitchen_counter", ModBlocks.CYAN_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_KITCHEN_COUNTER = registerBlockItem("light_blue_modern_kitchen_counter", ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BLUE_MODERN_KITCHEN_COUNTER = registerBlockItem("blue_modern_kitchen_counter", ModBlocks.BLUE_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> PURPLE_MODERN_KITCHEN_COUNTER = registerBlockItem("purple_modern_kitchen_counter", ModBlocks.PURPLE_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> MAGENTA_MODERN_KITCHEN_COUNTER = registerBlockItem("magenta_modern_kitchen_counter", ModBlocks.MAGENTA_MODERN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> PINK_MODERN_KITCHEN_COUNTER = registerBlockItem("pink_modern_kitchen_counter", ModBlocks.PINK_MODERN_KITCHEN_COUNTER);

    // Modern Kitchen Drawers
    public static final Supplier<BlockItem> WHITE_MODERN_KITCHEN_DRAWER = registerBlockItem("white_modern_kitchen_drawer", ModBlocks.WHITE_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_KITCHEN_DRAWER = registerBlockItem("light_gray_modern_kitchen_drawer", ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> GRAY_MODERN_KITCHEN_DRAWER = registerBlockItem("gray_modern_kitchen_drawer", ModBlocks.GRAY_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BLACK_MODERN_KITCHEN_DRAWER = registerBlockItem("black_modern_kitchen_drawer", ModBlocks.BLACK_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BROWN_MODERN_KITCHEN_DRAWER = registerBlockItem("brown_modern_kitchen_drawer", ModBlocks.BROWN_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> RED_MODERN_KITCHEN_DRAWER = registerBlockItem("red_modern_kitchen_drawer", ModBlocks.RED_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> ORANGE_MODERN_KITCHEN_DRAWER = registerBlockItem("orange_modern_kitchen_drawer", ModBlocks.ORANGE_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BEIGE_MODERN_KITCHEN_DRAWER = registerOptionalBlockItem("beige_modern_kitchen_drawer", ModBlocks.BEIGE_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> YELLOW_MODERN_KITCHEN_DRAWER = registerBlockItem("yellow_modern_kitchen_drawer", ModBlocks.YELLOW_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> LIME_MODERN_KITCHEN_DRAWER = registerBlockItem("lime_modern_kitchen_drawer", ModBlocks.LIME_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> GREEN_MODERN_KITCHEN_DRAWER = registerBlockItem("green_modern_kitchen_drawer", ModBlocks.GREEN_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> CYAN_MODERN_KITCHEN_DRAWER = registerBlockItem("cyan_modern_kitchen_drawer", ModBlocks.CYAN_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_KITCHEN_DRAWER = registerBlockItem("light_blue_modern_kitchen_drawer", ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BLUE_MODERN_KITCHEN_DRAWER = registerBlockItem("blue_modern_kitchen_drawer", ModBlocks.BLUE_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> PURPLE_MODERN_KITCHEN_DRAWER = registerBlockItem("purple_modern_kitchen_drawer", ModBlocks.PURPLE_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> MAGENTA_MODERN_KITCHEN_DRAWER = registerBlockItem("magenta_modern_kitchen_drawer", ModBlocks.MAGENTA_MODERN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> PINK_MODERN_KITCHEN_DRAWER = registerBlockItem("pink_modern_kitchen_drawer", ModBlocks.PINK_MODERN_KITCHEN_DRAWER);

    // Modern Kitchen Sinks
    public static final Supplier<BlockItem> WHITE_MODERN_KITCHEN_SINK = registerBlockItem("white_modern_kitchen_sink", ModBlocks.WHITE_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> LIGHT_GRAY_MODERN_KITCHEN_SINK = registerBlockItem("light_gray_modern_kitchen_sink", ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> GRAY_MODERN_KITCHEN_SINK = registerBlockItem("gray_modern_kitchen_sink", ModBlocks.GRAY_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> BLACK_MODERN_KITCHEN_SINK = registerBlockItem("black_modern_kitchen_sink", ModBlocks.BLACK_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> BROWN_MODERN_KITCHEN_SINK = registerBlockItem("brown_modern_kitchen_sink", ModBlocks.BROWN_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> RED_MODERN_KITCHEN_SINK = registerBlockItem("red_modern_kitchen_sink", ModBlocks.RED_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> ORANGE_MODERN_KITCHEN_SINK = registerBlockItem("orange_modern_kitchen_sink", ModBlocks.ORANGE_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> BEIGE_MODERN_KITCHEN_SINK = registerOptionalBlockItem("beige_modern_kitchen_sink", ModBlocks.BEIGE_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> YELLOW_MODERN_KITCHEN_SINK = registerBlockItem("yellow_modern_kitchen_sink", ModBlocks.YELLOW_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> LIME_MODERN_KITCHEN_SINK = registerBlockItem("lime_modern_kitchen_sink", ModBlocks.LIME_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> GREEN_MODERN_KITCHEN_SINK = registerBlockItem("green_modern_kitchen_sink", ModBlocks.GREEN_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> CYAN_MODERN_KITCHEN_SINK = registerBlockItem("cyan_modern_kitchen_sink", ModBlocks.CYAN_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> LIGHT_BLUE_MODERN_KITCHEN_SINK = registerBlockItem("light_blue_modern_kitchen_sink", ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> BLUE_MODERN_KITCHEN_SINK = registerBlockItem("blue_modern_kitchen_sink", ModBlocks.BLUE_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> PURPLE_MODERN_KITCHEN_SINK = registerBlockItem("purple_modern_kitchen_sink", ModBlocks.PURPLE_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> MAGENTA_MODERN_KITCHEN_SINK = registerBlockItem("magenta_modern_kitchen_sink", ModBlocks.MAGENTA_MODERN_KITCHEN_SINK);
    public static final Supplier<BlockItem> PINK_MODERN_KITCHEN_SINK = registerBlockItem("pink_modern_kitchen_sink", ModBlocks.PINK_MODERN_KITCHEN_SINK);

    // Bar Stools
    public static final Supplier<BlockItem> WHITE_BAR_STOOL = registerBlockItem("white_bar_stool", ModBlocks.WHITE_BAR_STOOL);
    public static final Supplier<BlockItem> LIGHT_GRAY_BAR_STOOL = registerBlockItem("light_gray_bar_stool", ModBlocks.LIGHT_GRAY_BAR_STOOL);
    public static final Supplier<BlockItem> GRAY_BAR_STOOL = registerBlockItem("gray_bar_stool", ModBlocks.GRAY_BAR_STOOL);
    public static final Supplier<BlockItem> BLACK_BAR_STOOL = registerBlockItem("black_bar_stool", ModBlocks.BLACK_BAR_STOOL);
    public static final Supplier<BlockItem> BROWN_BAR_STOOL = registerBlockItem("brown_bar_stool", ModBlocks.BROWN_BAR_STOOL);
    public static final Supplier<BlockItem> RED_BAR_STOOL = registerBlockItem("red_bar_stool", ModBlocks.RED_BAR_STOOL);
    public static final Supplier<BlockItem> ORANGE_BAR_STOOL = registerBlockItem("orange_bar_stool", ModBlocks.ORANGE_BAR_STOOL);
    public static final Supplier<BlockItem> BEIGE_BAR_STOOL = registerOptionalBlockItem("beige_bar_stool", ModBlocks.BEIGE_BAR_STOOL);
    public static final Supplier<BlockItem> YELLOW_BAR_STOOL = registerBlockItem("yellow_bar_stool", ModBlocks.YELLOW_BAR_STOOL);
    public static final Supplier<BlockItem> LIME_BAR_STOOL = registerBlockItem("lime_bar_stool", ModBlocks.LIME_BAR_STOOL);
    public static final Supplier<BlockItem> GREEN_BAR_STOOL = registerBlockItem("green_bar_stool", ModBlocks.GREEN_BAR_STOOL);
    public static final Supplier<BlockItem> CYAN_BAR_STOOL = registerBlockItem("cyan_bar_stool", ModBlocks.CYAN_BAR_STOOL);
    public static final Supplier<BlockItem> LIGHT_BLUE_BAR_STOOL = registerBlockItem("light_blue_bar_stool", ModBlocks.LIGHT_BLUE_BAR_STOOL);
    public static final Supplier<BlockItem> BLUE_BAR_STOOL = registerBlockItem("blue_bar_stool", ModBlocks.BLUE_BAR_STOOL);
    public static final Supplier<BlockItem> PURPLE_BAR_STOOL = registerBlockItem("purple_bar_stool", ModBlocks.PURPLE_BAR_STOOL);
    public static final Supplier<BlockItem> MAGENTA_BAR_STOOL = registerBlockItem("magenta_bar_stool", ModBlocks.MAGENTA_BAR_STOOL);
    public static final Supplier<BlockItem> PINK_BAR_STOOL = registerBlockItem("pink_bar_stool", ModBlocks.PINK_BAR_STOOL);

    // Chopping Boards
    public static final Supplier<BlockItem> OAK_CHOPPING_BOARD = registerBlockItem("oak_chopping_board", ModBlocks.OAK_CHOPPING_BOARD);
    public static final Supplier<BlockItem> SPRUCE_CHOPPING_BOARD = registerBlockItem("spruce_chopping_board", ModBlocks.SPRUCE_CHOPPING_BOARD);
    public static final Supplier<BlockItem> BIRCH_CHOPPING_BOARD = registerBlockItem("birch_chopping_board", ModBlocks.BIRCH_CHOPPING_BOARD);
    public static final Supplier<BlockItem> JUNGLE_CHOPPING_BOARD = registerBlockItem("jungle_chopping_board", ModBlocks.JUNGLE_CHOPPING_BOARD);
    public static final Supplier<BlockItem> ACACIA_CHOPPING_BOARD = registerBlockItem("acacia_chopping_board", ModBlocks.ACACIA_CHOPPING_BOARD);
    public static final Supplier<BlockItem> DARK_OAK_CHOPPING_BOARD = registerBlockItem("dark_oak_chopping_board", ModBlocks.DARK_OAK_CHOPPING_BOARD);
    public static final Supplier<BlockItem> MANGROVE_CHOPPING_BOARD = registerBlockItem("mangrove_chopping_board", ModBlocks.MANGROVE_CHOPPING_BOARD);
    public static final Supplier<BlockItem> CHERRY_CHOPPING_BOARD = registerBlockItem("cherry_chopping_board", ModBlocks.CHERRY_CHOPPING_BOARD);
    public static final Supplier<BlockItem> CRIMSON_CHOPPING_BOARD = registerBlockItem("crimson_chopping_board", ModBlocks.CRIMSON_CHOPPING_BOARD);
    public static final Supplier<BlockItem> WARPED_CHOPPING_BOARD = registerBlockItem("warped_chopping_board", ModBlocks.WARPED_CHOPPING_BOARD);

    // Door Bells
    public static final Supplier<BlockItem> OAK_DOOR_BELL = registerBlockItem("oak_door_bell", ModBlocks.OAK_DOOR_BELL);
    public static final Supplier<BlockItem> SPRUCE_DOOR_BELL = registerBlockItem("spruce_door_bell", ModBlocks.SPRUCE_DOOR_BELL);
    public static final Supplier<BlockItem> BIRCH_DOOR_BELL = registerBlockItem("birch_door_bell", ModBlocks.BIRCH_DOOR_BELL);
    public static final Supplier<BlockItem> JUNGLE_DOOR_BELL = registerBlockItem("jungle_door_bell", ModBlocks.JUNGLE_DOOR_BELL);
    public static final Supplier<BlockItem> ACACIA_DOOR_BELL = registerBlockItem("acacia_door_bell", ModBlocks.ACACIA_DOOR_BELL);
    public static final Supplier<BlockItem> DARK_OAK_DOOR_BELL = registerBlockItem("dark_oak_door_bell", ModBlocks.DARK_OAK_DOOR_BELL);
    public static final Supplier<BlockItem> MANGROVE_DOOR_BELL = registerBlockItem("mangrove_door_bell", ModBlocks.MANGROVE_DOOR_BELL);
    public static final Supplier<BlockItem> CHERRY_DOOR_BELL = registerBlockItem("cherry_door_bell", ModBlocks.CHERRY_DOOR_BELL);
    public static final Supplier<BlockItem> CRIMSON_DOOR_BELL = registerBlockItem("crimson_door_bell", ModBlocks.CRIMSON_DOOR_BELL);
    public static final Supplier<BlockItem> WARPED_DOOR_BELL = registerBlockItem("warped_door_bell", ModBlocks.WARPED_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_OAK_DOOR_BELL = registerBlockItem("stripped_oak_door_bell", ModBlocks.STRIPPED_OAK_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_DOOR_BELL = registerBlockItem("stripped_spruce_door_bell", ModBlocks.STRIPPED_SPRUCE_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_DOOR_BELL = registerBlockItem("stripped_birch_door_bell", ModBlocks.STRIPPED_BIRCH_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_DOOR_BELL = registerBlockItem("stripped_jungle_door_bell", ModBlocks.STRIPPED_JUNGLE_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_DOOR_BELL = registerBlockItem("stripped_acacia_door_bell", ModBlocks.STRIPPED_ACACIA_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_DOOR_BELL = registerBlockItem("stripped_dark_oak_door_bell", ModBlocks.STRIPPED_DARK_OAK_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_DOOR_BELL = registerBlockItem("stripped_mangrove_door_bell", ModBlocks.STRIPPED_MANGROVE_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_DOOR_BELL = registerBlockItem("stripped_cherry_door_bell", ModBlocks.STRIPPED_CHERRY_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_DOOR_BELL = registerBlockItem("stripped_crimson_door_bell", ModBlocks.STRIPPED_CRIMSON_DOOR_BELL);
    public static final Supplier<BlockItem> STRIPPED_WARPED_DOOR_BELL = registerBlockItem("stripped_warped_door_bell", ModBlocks.STRIPPED_WARPED_DOOR_BELL);

    // Inflatable Castles
    public static final Supplier<BlockItem> WHITE_INFLATABLE_CASTLE = registerBlockItem("white_inflatable_castle", ModBlocks.WHITE_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> LIGHT_GRAY_INFLATABLE_CASTLE = registerBlockItem("light_gray_inflatable_castle", ModBlocks.LIGHT_GRAY_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> GRAY_INFLATABLE_CASTLE = registerBlockItem("gray_inflatable_castle", ModBlocks.GRAY_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> BLACK_INFLATABLE_CASTLE = registerBlockItem("black_inflatable_castle", ModBlocks.BLACK_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> BROWN_INFLATABLE_CASTLE = registerBlockItem("brown_inflatable_castle", ModBlocks.BROWN_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> RED_INFLATABLE_CASTLE = registerBlockItem("red_inflatable_castle", ModBlocks.RED_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> ORANGE_INFLATABLE_CASTLE = registerBlockItem("orange_inflatable_castle", ModBlocks.ORANGE_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> BEIGE_INFLATABLE_CASTLE = registerOptionalBlockItem("beige_inflatable_castle", ModBlocks.BEIGE_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> YELLOW_INFLATABLE_CASTLE = registerBlockItem("yellow_inflatable_castle", ModBlocks.YELLOW_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> LIME_INFLATABLE_CASTLE = registerBlockItem("lime_inflatable_castle", ModBlocks.LIME_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> GREEN_INFLATABLE_CASTLE = registerBlockItem("green_inflatable_castle", ModBlocks.GREEN_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> CYAN_INFLATABLE_CASTLE = registerBlockItem("cyan_inflatable_castle", ModBlocks.CYAN_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> LIGHT_BLUE_INFLATABLE_CASTLE = registerBlockItem("light_blue_inflatable_castle", ModBlocks.LIGHT_BLUE_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> BLUE_INFLATABLE_CASTLE = registerBlockItem("blue_inflatable_castle", ModBlocks.BLUE_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> PURPLE_INFLATABLE_CASTLE = registerBlockItem("purple_inflatable_castle", ModBlocks.PURPLE_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> MAGENTA_INFLATABLE_CASTLE = registerBlockItem("magenta_inflatable_castle", ModBlocks.MAGENTA_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> PINK_INFLATABLE_CASTLE = registerBlockItem("pink_inflatable_castle", ModBlocks.PINK_INFLATABLE_CASTLE);
    public static final Supplier<BlockItem> CASTLE_NETTING = registerBlockItem("castle_netting", ModBlocks.CASTLE_NETTING);

    // Kitchenware
    public static final Supplier<BlockItem> COOKIE_JAR = registerBlockItem("cookie_jar", ModBlocks.COOKIE_JAR);
    public static final Supplier<BlockItem> WHITE_CUP = registerBlockItem("white_cup", ModBlocks.WHITE_CUP);
    public static final Supplier<BlockItem> LIGHT_GRAY_CUP = registerBlockItem("light_gray_cup", ModBlocks.LIGHT_GRAY_CUP);
    public static final Supplier<BlockItem> GRAY_CUP = registerBlockItem("gray_cup", ModBlocks.GRAY_CUP);
    public static final Supplier<BlockItem> BLACK_CUP = registerBlockItem("black_cup", ModBlocks.BLACK_CUP);
    public static final Supplier<BlockItem> BROWN_CUP = registerBlockItem("brown_cup", ModBlocks.BROWN_CUP);
    public static final Supplier<BlockItem> RED_CUP = registerBlockItem("red_cup", ModBlocks.RED_CUP);
    public static final Supplier<BlockItem> ORANGE_CUP = registerBlockItem("orange_cup", ModBlocks.ORANGE_CUP);
    public static final Supplier<BlockItem> BEIGE_CUP = registerOptionalBlockItem("beige_cup", ModBlocks.BEIGE_CUP);
    public static final Supplier<BlockItem> YELLOW_CUP = registerBlockItem("yellow_cup", ModBlocks.YELLOW_CUP);
    public static final Supplier<BlockItem> LIME_CUP = registerBlockItem("lime_cup", ModBlocks.LIME_CUP);
    public static final Supplier<BlockItem> GREEN_CUP = registerBlockItem("green_cup", ModBlocks.GREEN_CUP);
    public static final Supplier<BlockItem> CYAN_CUP = registerBlockItem("cyan_cup", ModBlocks.CYAN_CUP);
    public static final Supplier<BlockItem> LIGHT_BLUE_CUP = registerBlockItem("light_blue_cup", ModBlocks.LIGHT_BLUE_CUP);
    public static final Supplier<BlockItem> BLUE_CUP = registerBlockItem("blue_cup", ModBlocks.BLUE_CUP);
    public static final Supplier<BlockItem> PURPLE_CUP = registerBlockItem("purple_cup", ModBlocks.PURPLE_CUP);
    public static final Supplier<BlockItem> MAGENTA_CUP = registerBlockItem("magenta_cup", ModBlocks.MAGENTA_CUP);
    public static final Supplier<BlockItem> PINK_CUP = registerBlockItem("pink_cup", ModBlocks.PINK_CUP);
    public static final Supplier<BlockItem> PLATE = registerBlockItem("plate", ModBlocks.PLATE);

    // Bird Baths
    public static final Supplier<BlockItem> STONE_BIRD_BATH = registerBlockItem("stone_bird_bath", ModBlocks.STONE_BIRD_BATH);
    public static final Supplier<BlockItem> ANDESITE_BIRD_BATH = registerBlockItem("andesite_bird_bath", ModBlocks.ANDESITE_BIRD_BATH);
    public static final Supplier<BlockItem> DIORITE_BIRD_BATH = registerBlockItem("diorite_bird_bath", ModBlocks.DIORITE_BIRD_BATH);
    public static final Supplier<BlockItem> GRANITE_BIRD_BATH = registerBlockItem("granite_bird_bath", ModBlocks.GRANITE_BIRD_BATH);
    public static final Supplier<BlockItem> BLACKSTONE_BIRD_BATH = registerBlockItem("blackstone_bird_bath", ModBlocks.BLACKSTONE_BIRD_BATH);
    public static final Supplier<BlockItem> DEEPSLATE_BIRD_BATH = registerBlockItem("deepslate_bird_bath", ModBlocks.DEEPSLATE_BIRD_BATH);

    // Taps
    public static final Supplier<BlockItem> STONE_TAP = registerBlockItem("stone_tap", ModBlocks.STONE_TAP);
    public static final Supplier<BlockItem> ANDESITE_TAP = registerBlockItem("andesite_tap", ModBlocks.ANDESITE_TAP);
    public static final Supplier<BlockItem> DIORITE_TAP = registerBlockItem("diorite_tap", ModBlocks.DIORITE_TAP);
    public static final Supplier<BlockItem> GRANITE_TAP = registerBlockItem("granite_tap", ModBlocks.GRANITE_TAP);
    public static final Supplier<BlockItem> BLACKSTONE_TAP = registerBlockItem("blackstone_tap", ModBlocks.BLACKSTONE_TAP);
    public static final Supplier<BlockItem> DEEPSLATE_TAP = registerBlockItem("deepslate_tap", ModBlocks.DEEPSLATE_TAP);

    // Water Tanks
    public static final Supplier<BlockItem> OAK_WATER_TANK = registerBlockItem("oak_water_tank", ModBlocks.OAK_WATER_TANK);
    public static final Supplier<BlockItem> SPRUCE_WATER_TANK = registerBlockItem("spruce_water_tank", ModBlocks.SPRUCE_WATER_TANK);
    public static final Supplier<BlockItem> BIRCH_WATER_TANK = registerBlockItem("birch_water_tank", ModBlocks.BIRCH_WATER_TANK);
    public static final Supplier<BlockItem> JUNGLE_WATER_TANK = registerBlockItem("jungle_water_tank", ModBlocks.JUNGLE_WATER_TANK);
    public static final Supplier<BlockItem> ACACIA_WATER_TANK = registerBlockItem("acacia_water_tank", ModBlocks.ACACIA_WATER_TANK);
    public static final Supplier<BlockItem> DARK_OAK_WATER_TANK = registerBlockItem("dark_oak_water_tank", ModBlocks.DARK_OAK_WATER_TANK);
    public static final Supplier<BlockItem> MANGROVE_WATER_TANK = registerBlockItem("mangrove_water_tank", ModBlocks.MANGROVE_WATER_TANK);
    public static final Supplier<BlockItem> CHERRY_WATER_TANK = registerBlockItem("cherry_water_tank", ModBlocks.CHERRY_WATER_TANK);
    public static final Supplier<BlockItem> CRIMSON_WATER_TANK = registerBlockItem("crimson_water_tank", ModBlocks.CRIMSON_WATER_TANK);
    public static final Supplier<BlockItem> WARPED_WATER_TANK = registerBlockItem("warped_water_tank", ModBlocks.WARPED_WATER_TANK);

    // Appliances and Electronics
    public static final Supplier<BlockItem> ELECTRIC_FENCE = registerBlockItem("electric_fence", ModBlocks.ELECTRIC_FENCE);
    public static final Supplier<BlockItem> BATH_LIGHT = registerBlockItem("bath_light", ModBlocks.BATH_LIGHT);
    public static final Supplier<BlockItem> BATH_DARK = registerBlockItem("bath_dark", ModBlocks.BATH_DARK);
    public static final Supplier<BlockItem> BIN_LIGHT = registerBlockItem("bin_light", ModBlocks.BIN_LIGHT);
    public static final Supplier<BlockItem> BIN_DARK = registerBlockItem("bin_dark", ModBlocks.BIN_DARK);
    public static final Supplier<BlockItem> BLENDER_LIGHT = registerBlockItem("blender_light", ModBlocks.BLENDER_LIGHT);
    public static final Supplier<BlockItem> BLENDER_DARK = registerBlockItem("blender_dark", ModBlocks.BLENDER_DARK);
    public static final Supplier<BlockItem> CATHODE_RAY_TUBE_TELEVISION = registerBlockItem("cathode_ray_tube_television", ModBlocks.CATHODE_RAY_TUBE_TELEVISION);
    public static final Supplier<BlockItem> COMPUTER_LIGHT = registerBlockItem("computer_light", ModBlocks.COMPUTER_LIGHT);
    public static final Supplier<BlockItem> COMPUTER_DARK = registerBlockItem("computer_dark", ModBlocks.COMPUTER_DARK);
    public static final Supplier<BlockItem> DISHWASHER_LIGHT = registerBlockItem("dishwasher_light", ModBlocks.DISHWASHER_LIGHT);
    public static final Supplier<BlockItem> DISHWASHER_DARK = registerBlockItem("dishwasher_dark", ModBlocks.DISHWASHER_DARK);
    public static final Supplier<BlockItem> FIRE_ALARM = registerBlockItem("fire_alarm", ModBlocks.FIRE_ALARM);
    public static final Supplier<BlockItem> LIQUID_CRYSTAL_DISPLAY_TELEVISION = registerBlockItem("liquid_crystal_display_television", ModBlocks.LIQUID_CRYSTAL_DISPLAY_TELEVISION);
    public static final Supplier<BlockItem> MICROWAVE_LIGHT = registerBlockItem("microwave_light", ModBlocks.MICROWAVE_LIGHT);
    public static final Supplier<BlockItem> MICROWAVE_DARK = registerBlockItem("microwave_dark", ModBlocks.MICROWAVE_DARK);
    public static final Supplier<BlockItem> OVEN_LIGHT = registerBlockItem("oven_light", ModBlocks.OVEN_LIGHT);
    public static final Supplier<BlockItem> OVEN_DARK = registerBlockItem("oven_dark", ModBlocks.OVEN_DARK);
    public static final Supplier<BlockItem> OVEN_RANGE_HOOD_LIGHT = registerBlockItem("oven_range_hood_light", ModBlocks.OVEN_RANGE_HOOD_LIGHT);
    public static final Supplier<BlockItem> OVEN_RANGE_HOOD_DARK = registerBlockItem("oven_range_hood_dark", ModBlocks.OVEN_RANGE_HOOD_DARK);
    public static final Supplier<BlockItem> PRINTER = registerBlockItem("printer", ModBlocks.PRINTER);
    public static final Supplier<BlockItem> SINK_LIGHT = registerBlockItem("sink_light", ModBlocks.SINK_LIGHT);
    public static final Supplier<BlockItem> SINK_DARK = registerBlockItem("sink_dark", ModBlocks.SINK_DARK);
    public static final Supplier<BlockItem> SHOWER_LIGHT = registerBlockItem("shower_light", ModBlocks.SHOWER_LIGHT);
    public static final Supplier<BlockItem> SHOWER_DARK = registerBlockItem("shower_dark", ModBlocks.SHOWER_DARK);
    public static final Supplier<BlockItem> SHOWER_HEAD_LIGHT = registerBlockItem("shower_head_light", ModBlocks.SHOWER_HEAD_LIGHT);
    public static final Supplier<BlockItem> SHOWER_HEAD_DARK = registerBlockItem("shower_head_dark", ModBlocks.SHOWER_HEAD_DARK);
    public static final Supplier<BlockItem> STEREO = registerBlockItem("stereo", ModBlocks.STEREO);
    public static final Supplier<BlockItem> TOASTER_LIGHT = registerBlockItem("toaster_light", ModBlocks.TOASTER_LIGHT);
    public static final Supplier<BlockItem> TOASTER_DARK = registerBlockItem("toaster_dark", ModBlocks.TOASTER_DARK);
    public static final Supplier<BlockItem> TOILET_LIGHT = registerBlockItem("toilet_light", ModBlocks.TOILET_LIGHT);
    public static final Supplier<BlockItem> TOILET_DARK = registerBlockItem("toilet_dark", ModBlocks.TOILET_DARK);
    public static final Supplier<BlockItem> WASHING_MACHINE_LIGHT = registerBlockItem("washing_machine_light", ModBlocks.WASHING_MACHINE_LIGHT);
    public static final Supplier<BlockItem> WASHING_MACHINE_DARK = registerBlockItem("washing_machine_dark", ModBlocks.WASHING_MACHINE_DARK);

    // Digital Clocks
    public static final Supplier<BlockItem> WHITE_DIGITAL_CLOCK = registerBlockItem("white_digital_clock", ModBlocks.WHITE_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> LIGHT_GRAY_DIGITAL_CLOCK = registerBlockItem("light_gray_digital_clock", ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> GRAY_DIGITAL_CLOCK = registerBlockItem("gray_digital_clock", ModBlocks.GRAY_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> BLACK_DIGITAL_CLOCK = registerBlockItem("black_digital_clock", ModBlocks.BLACK_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> BROWN_DIGITAL_CLOCK = registerBlockItem("brown_digital_clock", ModBlocks.BROWN_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> RED_DIGITAL_CLOCK = registerBlockItem("red_digital_clock", ModBlocks.RED_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> ORANGE_DIGITAL_CLOCK = registerBlockItem("orange_digital_clock", ModBlocks.ORANGE_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> BEIGE_DIGITAL_CLOCK = registerOptionalBlockItem("beige_digital_clock", ModBlocks.BEIGE_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> YELLOW_DIGITAL_CLOCK = registerBlockItem("yellow_digital_clock", ModBlocks.YELLOW_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> LIME_DIGITAL_CLOCK = registerBlockItem("lime_digital_clock", ModBlocks.LIME_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> GREEN_DIGITAL_CLOCK = registerBlockItem("green_digital_clock", ModBlocks.GREEN_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> CYAN_DIGITAL_CLOCK = registerBlockItem("cyan_digital_clock", ModBlocks.CYAN_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> LIGHT_BLUE_DIGITAL_CLOCK = registerBlockItem("light_blue_digital_clock", ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> BLUE_DIGITAL_CLOCK = registerBlockItem("blue_digital_clock", ModBlocks.BLUE_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> PURPLE_DIGITAL_CLOCK = registerBlockItem("purple_digital_clock", ModBlocks.PURPLE_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> MAGENTA_DIGITAL_CLOCK = registerBlockItem("magenta_digital_clock", ModBlocks.MAGENTA_DIGITAL_CLOCK);
    public static final Supplier<BlockItem> PINK_DIGITAL_CLOCK = registerBlockItem("pink_digital_clock", ModBlocks.PINK_DIGITAL_CLOCK);

    // Festive Blocks
    public static final Supplier<BlockItem> CANDLE = registerBlockItem("candle", ModBlocks.CANDLE);
    public static final Supplier<BlockItem> CHRISTMAS_TREE = registerBlockItem("christmas_tree", ModBlocks.CHRISTMAS_TREE);
    public static final Supplier<BlockItem> WREATH = registerBlockItem("wreath", ModBlocks.WREATH);

    // Food
    public static final Supplier<Item> BREAD_SLICE = register("bread_slice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2).saturationModifier(0.2f).alwaysEdible().build())));
    public static final Supplier<Item> KEBAB = register("kebab",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).alwaysEdible().build())));
    public static final Supplier<Item> COOKED_KEBAB = register("cooked_kebab",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationModifier(0.2f).alwaysEdible().build())));
    public static final Supplier<Item> SAUSAGE = register("sausage",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1).saturationModifier(0.2f).alwaysEdible().build())));
    public static final Supplier<Item> COOKED_SAUSAGE = register("cooked_sausage",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationModifier(0.2f).alwaysEdible().build())));
    public static final Supplier<Item> TOAST = register("toast",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(4).saturationModifier(0.2f).alwaysEdible().build())));

    // Supplies
    public static final Supplier<Item> INK_CARTRIDGE = register("ink_cartridge",
            () -> new Item(new Item.Properties().durability(10000)));

    // Tools
    public static final Supplier<SwordItem> CROWBAR = register("crowbar",
            () -> new SwordItem(Tiers.IRON, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.IRON, 3, -3.0F))));
    public static final Supplier<SwordItem> KNIFE = register("knife",
            () -> new SwordItem(Tiers.STONE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.STONE, 1, -2.4F))));
    public static final Supplier<Item> SOAP = register("soap",
            () -> new Item(new Item.Properties()));
    public static final Supplier<BucketItem> SOAPY_WATER_BUCKET = register("soapy_water_bucket",
            () -> new BucketItem(ModFluids.SOAPY_WATER.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<BucketItem> SUPER_SOAPY_WATER_BUCKET = register("super_soapy_water_bucket",
            () -> new BucketItem(ModFluids.SUPER_SOAPY_WATER.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> TELEVISION_REMOTE = register("television_remote",
            () -> new Item(new Item.Properties()));

}