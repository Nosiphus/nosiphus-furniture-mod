package com.nosiphus.furniture.core;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "nfm");

    //Tables
    public static final RegistryObject<BlockItem> TABLE_STONE = ITEMS.register("stone_table",
            () -> new BlockItem(ModBlocks.TABLE_STONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_ANDESITE = ITEMS.register("andesite_table",
            () -> new BlockItem(ModBlocks.TABLE_ANDESITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_DIORITE = ITEMS.register("diorite_table",
            () -> new BlockItem(ModBlocks.TABLE_DIORITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_GRANITE = ITEMS.register("granite_table",
            () -> new BlockItem(ModBlocks.TABLE_GRANITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_BLACKSTONE = ITEMS.register("blackstone_table",
            () -> new BlockItem(ModBlocks.TABLE_BLACKSTONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_DEEPSLATE = ITEMS.register("deepslate_table",
            () -> new BlockItem(ModBlocks.TABLE_DEEPSLATE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_WHITE_MODERN = ITEMS.register("white_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_ORANGE_MODERN = ITEMS.register("orange_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_MAGENTA_MODERN = ITEMS.register("magenta_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_YELLOW_MODERN = ITEMS.register("yellow_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_LIME_MODERN = ITEMS.register("lime_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_PINK_MODERN = ITEMS.register("pink_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_GRAY_MODERN = ITEMS.register("gray_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_CYAN_MODERN = ITEMS.register("cyan_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_PURPLE_MODERN = ITEMS.register("purple_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_BLUE_MODERN = ITEMS.register("blue_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_BROWN_MODERN = ITEMS.register("brown_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_GREEN_MODERN = ITEMS.register("green_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_RED_MODERN = ITEMS.register("red_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TABLE_BLACK_MODERN = ITEMS.register("black_modern_table",
            () -> new BlockItem(ModBlocks.TABLE_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Chairs
    public static final RegistryObject<BlockItem> CHAIR_STONE = ITEMS.register("stone_chair",
            () -> new BlockItem(ModBlocks.CHAIR_STONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_ANDESITE = ITEMS.register("andesite_chair",
            () -> new BlockItem(ModBlocks.CHAIR_ANDESITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_DIORITE = ITEMS.register("diorite_chair",
            () -> new BlockItem(ModBlocks.CHAIR_DIORITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_GRANITE = ITEMS.register("granite_chair",
            () -> new BlockItem(ModBlocks.CHAIR_GRANITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_BLACKSTONE = ITEMS.register("blackstone_chair",
            () -> new BlockItem(ModBlocks.CHAIR_BLACKSTONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_DEEPSLATE = ITEMS.register("deepslate_chair",
            () -> new BlockItem(ModBlocks.CHAIR_DEEPSLATE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_WHITE_MODERN = ITEMS.register("white_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_ORANGE_MODERN = ITEMS.register("orange_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_MAGENTA_MODERN = ITEMS.register("magenta_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_YELLOW_MODERN = ITEMS.register("yellow_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_LIME_MODERN = ITEMS.register("lime_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_PINK_MODERN = ITEMS.register("pink_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_GRAY_MODERN = ITEMS.register("gray_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_CYAN_MODERN = ITEMS.register("cyan_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_PURPLE_MODERN = ITEMS.register("purple_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_BLUE_MODERN = ITEMS.register("blue_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_BROWN_MODERN = ITEMS.register("brown_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_GREEN_MODERN = ITEMS.register("green_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_RED_MODERN = ITEMS.register("red_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_BLACK_MODERN = ITEMS.register("black_modern_chair",
            () -> new BlockItem(ModBlocks.CHAIR_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Office Chairs
    public static final RegistryObject<BlockItem> CHAIR_WHITE_OFFICE = ITEMS.register("white_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_WHITE_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_ORANGE_OFFICE = ITEMS.register("orange_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_ORANGE_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_MAGENTA_OFFICE = ITEMS.register("magenta_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_MAGENTA_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_LIGHT_BLUE_OFFICE = ITEMS.register("light_blue_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_LIGHT_BLUE_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_YELLOW_OFFICE = ITEMS.register("yellow_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_YELLOW_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_LIME_OFFICE = ITEMS.register("lime_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_LIME_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_PINK_OFFICE = ITEMS.register("pink_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_PINK_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_GRAY_OFFICE = ITEMS.register("gray_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_GRAY_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_LIGHT_GRAY_OFFICE = ITEMS.register("light_gray_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_LIGHT_GRAY_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_CYAN_OFFICE = ITEMS.register("cyan_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_CYAN_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_PURPLE_OFFICE = ITEMS.register("purple_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_PURPLE_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_BLUE_OFFICE = ITEMS.register("blue_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_BLUE_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_BROWN_OFFICE = ITEMS.register("brown_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_BROWN_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_GREEN_OFFICE = ITEMS.register("green_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_GREEN_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_RED_OFFICE = ITEMS.register("red_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_RED_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CHAIR_BLACK_OFFICE = ITEMS.register("black_office_chair",
            () -> new BlockItem(ModBlocks.CHAIR_BLACK_OFFICE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Coffee Tables
    public static final RegistryObject<BlockItem> COFFEE_TABLE_STONE = ITEMS.register("stone_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_STONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_ANDESITE = ITEMS.register("andesite_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_ANDESITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_DIORITE = ITEMS.register("diorite_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_DIORITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_GRANITE = ITEMS.register("granite_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_GRANITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_BLACKSTONE = ITEMS.register("blackstone_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_BLACKSTONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_DEEPSLATE = ITEMS.register("deepslate_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_DEEPSLATE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_WHITE_MODERN = ITEMS.register("white_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_ORANGE_MODERN = ITEMS.register("orange_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_MAGENTA_MODERN = ITEMS.register("magenta_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_YELLOW_MODERN = ITEMS.register("yellow_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_LIME_MODERN = ITEMS.register("lime_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_PINK_MODERN = ITEMS.register("pink_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_GRAY_MODERN = ITEMS.register("gray_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_CYAN_MODERN = ITEMS.register("cyan_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_PURPLE_MODERN = ITEMS.register("purple_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_BLUE_MODERN = ITEMS.register("blue_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_BROWN_MODERN = ITEMS.register("brown_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_GREEN_MODERN = ITEMS.register("green_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_RED_MODERN = ITEMS.register("red_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> COFFEE_TABLE_BLACK_MODERN = ITEMS.register("black_modern_coffee_table",
            () -> new BlockItem(ModBlocks.COFFEE_TABLE_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Cabinets
    public static final RegistryObject<BlockItem> CABINET_STONE = ITEMS.register("stone_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_STONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_ANDESITE = ITEMS.register("andesite_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_ANDESITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_DIORITE = ITEMS.register("diorite_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_DIORITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_GRANITE = ITEMS.register("granite_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_GRANITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_BLACKSTONE = ITEMS.register("blackstone_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_BLACKSTONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_DEEPSLATE = ITEMS.register("deepslate_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_DEEPSLATE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_WHITE_MODERN = ITEMS.register("white_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_ORANGE_MODERN = ITEMS.register("orange_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_MAGENTA_MODERN = ITEMS.register("magenta_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_YELLOW_MODERN = ITEMS.register("yellow_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_LIME_MODERN = ITEMS.register("lime_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_PINK_MODERN = ITEMS.register("pink_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_GRAY_MODERN = ITEMS.register("gray_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_CYAN_MODERN = ITEMS.register("cyan_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_PURPLE_MODERN = ITEMS.register("purple_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_BLUE_MODERN = ITEMS.register("blue_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_BROWN_MODERN = ITEMS.register("brown_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_GREEN_MODERN = ITEMS.register("green_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_RED_MODERN = ITEMS.register("red_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CABINET_BLACK_MODERN = ITEMS.register("black_modern_cabinet",
            () -> new BlockItem(ModBlocks.CABINET_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Bedside Cabinets
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_STONE = ITEMS.register("stone_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_STONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_ANDESITE = ITEMS.register("andesite_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_ANDESITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_DIORITE = ITEMS.register("diorite_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_DIORITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_GRANITE = ITEMS.register("granite_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_GRANITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_BLACKSTONE = ITEMS.register("blackstone_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_BLACKSTONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_DEEPSLATE = ITEMS.register("deepslate_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_DEEPSLATE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_WHITE_MODERN = ITEMS.register("white_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_ORANGE_MODERN = ITEMS.register("orange_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_MAGENTA_MODERN = ITEMS.register("magenta_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_YELLOW_MODERN = ITEMS.register("yellow_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_LIME_MODERN = ITEMS.register("lime_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_PINK_MODERN = ITEMS.register("pink_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_GRAY_MODERN = ITEMS.register("gray_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_CYAN_MODERN = ITEMS.register("cyan_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_PURPLE_MODERN = ITEMS.register("purple_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_BLUE_MODERN = ITEMS.register("blue_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_BROWN_MODERN = ITEMS.register("brown_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_GREEN_MODERN = ITEMS.register("green_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_RED_MODERN = ITEMS.register("red_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BEDSIDE_CABINET_BLACK_MODERN = ITEMS.register("black_modern_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BEDSIDE_CABINET_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Desk
    public static final RegistryObject<BlockItem> DESK_STONE = ITEMS.register("stone_desk",
            () -> new BlockItem(ModBlocks.DESK_STONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_ANDESITE = ITEMS.register("andesite_desk",
            () -> new BlockItem(ModBlocks.DESK_ANDESITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_DIORITE = ITEMS.register("diorite_desk",
            () -> new BlockItem(ModBlocks.DESK_DIORITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_GRANITE = ITEMS.register("granite_desk",
            () -> new BlockItem(ModBlocks.DESK_GRANITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_BLACKSTONE = ITEMS.register("blackstone_desk",
            () -> new BlockItem(ModBlocks.DESK_BLACKSTONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_DEEPSLATE = ITEMS.register("deepslate_desk",
            () -> new BlockItem(ModBlocks.DESK_DEEPSLATE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_WHITE_MODERN = ITEMS.register("white_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_ORANGE_MODERN = ITEMS.register("orange_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_MAGENTA_MODERN = ITEMS.register("magenta_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_YELLOW_MODERN = ITEMS.register("yellow_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_LIME_MODERN = ITEMS.register("lime_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_PINK_MODERN = ITEMS.register("pink_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_GRAY_MODERN = ITEMS.register("gray_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CYAN_MODERN = ITEMS.register("cyan_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_PURPLE_MODERN = ITEMS.register("purple_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_BLUE_MODERN = ITEMS.register("blue_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_BROWN_MODERN = ITEMS.register("brown_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_GREEN_MODERN = ITEMS.register("green_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_RED_MODERN = ITEMS.register("red_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_BLACK_MODERN = ITEMS.register("black_modern_desk",
            () -> new BlockItem(ModBlocks.DESK_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Desk Cabinets
    public static final RegistryObject<BlockItem> DESK_CABINET_STONE = ITEMS.register("stone_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_STONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_ANDESITE = ITEMS.register("andesite_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_ANDESITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_DIORITE = ITEMS.register("diorite_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_DIORITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_GRANITE = ITEMS.register("granite_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_GRANITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_BLACKSTONE = ITEMS.register("blackstone_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_BLACKSTONE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_DEEPSLATE = ITEMS.register("deepslate_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_DEEPSLATE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_WHITE_MODERN = ITEMS.register("white_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_ORANGE_MODERN = ITEMS.register("orange_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_MAGENTA_MODERN = ITEMS.register("magenta_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_YELLOW_MODERN = ITEMS.register("yellow_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_LIME_MODERN = ITEMS.register("lime_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_PINK_MODERN = ITEMS.register("pink_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_GRAY_MODERN = ITEMS.register("gray_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_CYAN_MODERN = ITEMS.register("cyan_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_PURPLE_MODERN = ITEMS.register("purple_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_BLUE_MODERN = ITEMS.register("blue_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_BROWN_MODERN = ITEMS.register("brown_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_GREEN_MODERN = ITEMS.register("green_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_RED_MODERN = ITEMS.register("red_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DESK_CABINET_BLACK_MODERN = ITEMS.register("black_modern_desk_cabinet",
            () -> new BlockItem(ModBlocks.DESK_CABINET_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Sofas
    public static final RegistryObject<BlockItem> SOFA_WHITE_MODERN = ITEMS.register("white_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_ORANGE_MODERN = ITEMS.register("orange_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_MAGENTA_MODERN = ITEMS.register("magenta_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_YELLOW_MODERN = ITEMS.register("yellow_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_LIME_MODERN = ITEMS.register("lime_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_PINK_MODERN = ITEMS.register("pink_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_GRAY_MODERN = ITEMS.register("gray_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_CYAN_MODERN = ITEMS.register("cyan_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_PURPLE_MODERN = ITEMS.register("purple_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_BLUE_MODERN = ITEMS.register("blue_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_BROWN_MODERN = ITEMS.register("brown_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_GREEN_MODERN = ITEMS.register("green_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_RED_MODERN = ITEMS.register("red_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SOFA_BLACK_MODERN = ITEMS.register("black_modern_sofa",
            () -> new BlockItem(ModBlocks.SOFA_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Television Stands
    public static final RegistryObject<BlockItem> TELEVISION_STAND_WHITE = ITEMS.register("white_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_WHITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_ORANGE = ITEMS.register("orange_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_ORANGE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_MAGENTA = ITEMS.register("magenta_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_MAGENTA.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_LIGHT_BLUE = ITEMS.register("light_blue_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_LIGHT_BLUE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_YELLOW = ITEMS.register("yellow_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_YELLOW.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_LIME = ITEMS.register("lime_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_LIME.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_PINK = ITEMS.register("pink_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_PINK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_GRAY = ITEMS.register("gray_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_GRAY.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_LIGHT_GRAY = ITEMS.register("light_gray_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_LIGHT_GRAY.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_CYAN = ITEMS.register("cyan_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_CYAN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_PURPLE = ITEMS.register("purple_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_PURPLE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_BLUE = ITEMS.register("blue_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_BLUE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_BROWN = ITEMS.register("brown_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_BROWN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_GREEN = ITEMS.register("green_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_GREEN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_RED = ITEMS.register("red_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_RED.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TELEVISION_STAND_BLACK = ITEMS.register("black_television_stand",
            () -> new BlockItem(ModBlocks.TELEVISION_STAND_BLACK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Kitchen Counters
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_WHITE_MODERN = ITEMS.register("white_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_ORANGE_MODERN = ITEMS.register("orange_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_MAGENTA_MODERN = ITEMS.register("magenta_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_YELLOW_MODERN = ITEMS.register("yellow_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_LIME_MODERN = ITEMS.register("lime_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_PINK_MODERN = ITEMS.register("pink_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_GRAY_MODERN = ITEMS.register("gray_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_CYAN_MODERN = ITEMS.register("cyan_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_PURPLE_MODERN = ITEMS.register("purple_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_BLUE_MODERN = ITEMS.register("blue_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_BROWN_MODERN = ITEMS.register("brown_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_GREEN_MODERN = ITEMS.register("green_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_RED_MODERN = ITEMS.register("red_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_COUNTER_BLACK_MODERN = ITEMS.register("black_modern_kitchen_counter",
            () -> new BlockItem(ModBlocks.KITCHEN_COUNTER_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Kitchen Drawers
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_WHITE_MODERN = ITEMS.register("white_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_ORANGE_MODERN = ITEMS.register("orange_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_MAGENTA_MODERN = ITEMS.register("magenta_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_YELLOW_MODERN = ITEMS.register("yellow_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_LIME_MODERN = ITEMS.register("lime_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_PINK_MODERN = ITEMS.register("pink_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_GRAY_MODERN = ITEMS.register("gray_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_CYAN_MODERN = ITEMS.register("cyan_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_PURPLE_MODERN = ITEMS.register("purple_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_BLUE_MODERN = ITEMS.register("blue_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_BROWN_MODERN = ITEMS.register("brown_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_GREEN_MODERN = ITEMS.register("green_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_RED_MODERN = ITEMS.register("red_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_DRAWER_BLACK_MODERN = ITEMS.register("black_modern_kitchen_drawer",
            () -> new BlockItem(ModBlocks.KITCHEN_DRAWER_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Kitchen Sinks
    public static final RegistryObject<BlockItem> KITCHEN_SINK_WHITE_MODERN = ITEMS.register("white_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_WHITE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_ORANGE_MODERN = ITEMS.register("orange_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_ORANGE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_MAGENTA_MODERN = ITEMS.register("magenta_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_MAGENTA_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_LIGHT_BLUE_MODERN = ITEMS.register("light_blue_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_LIGHT_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_YELLOW_MODERN = ITEMS.register("yellow_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_YELLOW_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_LIME_MODERN = ITEMS.register("lime_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_LIME_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_PINK_MODERN = ITEMS.register("pink_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_PINK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_GRAY_MODERN = ITEMS.register("gray_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_LIGHT_GRAY_MODERN = ITEMS.register("light_gray_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_LIGHT_GRAY_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_CYAN_MODERN = ITEMS.register("cyan_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_CYAN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_PURPLE_MODERN = ITEMS.register("purple_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_PURPLE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_BLUE_MODERN = ITEMS.register("blue_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_BLUE_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_BROWN_MODERN = ITEMS.register("brown_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_BROWN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_GREEN_MODERN = ITEMS.register("green_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_GREEN_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_RED_MODERN = ITEMS.register("red_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_RED_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> KITCHEN_SINK_BLACK_MODERN = ITEMS.register("black_modern_kitchen_sink",
            () -> new BlockItem(ModBlocks.KITCHEN_SINK_BLACK_MODERN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Bar Stools
    public static final RegistryObject<BlockItem> BAR_STOOL_WHITE = ITEMS.register("white_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_WHITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_ORANGE = ITEMS.register("orange_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_ORANGE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_MAGENTA = ITEMS.register("magenta_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_MAGENTA.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_LIGHT_BLUE = ITEMS.register("light_blue_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_LIGHT_BLUE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_YELLOW = ITEMS.register("yellow_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_YELLOW.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_LIME = ITEMS.register("lime_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_LIME.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_PINK = ITEMS.register("pink_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_PINK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_GRAY = ITEMS.register("gray_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_GRAY.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_LIGHT_GRAY = ITEMS.register("light_gray_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_LIGHT_GRAY.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_CYAN = ITEMS.register("cyan_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_CYAN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_PURPLE = ITEMS.register("purple_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_PURPLE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_BLUE = ITEMS.register("blue_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_BLUE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_BROWN = ITEMS.register("brown_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_BROWN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_GREEN = ITEMS.register("green_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_GREEN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_RED = ITEMS.register("red_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_RED.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BAR_STOOL_BLACK = ITEMS.register("black_bar_stool",
            () -> new BlockItem(ModBlocks.BAR_STOOL_BLACK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Electronics
    public static final RegistryObject<BlockItem> LAPTOP_WHITE = ITEMS.register("white_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_WHITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_ORANGE = ITEMS.register("orange_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_ORANGE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_MAGENTA = ITEMS.register("magenta_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_MAGENTA.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_LIGHT_BLUE = ITEMS.register("light_blue_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_LIGHT_BLUE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_YELLOW = ITEMS.register("yellow_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_YELLOW.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_LIME = ITEMS.register("lime_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_LIME.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_PINK = ITEMS.register("pink_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_PINK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_GRAY = ITEMS.register("gray_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_GRAY.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_LIGHT_GRAY = ITEMS.register("light_gray_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_LIGHT_GRAY.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_CYAN = ITEMS.register("cyan_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_CYAN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_PURPLE = ITEMS.register("purple_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_PURPLE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_BLUE = ITEMS.register("blue_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_BLUE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_BROWN = ITEMS.register("brown_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_BROWN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_GREEN = ITEMS.register("green_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_GREEN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_RED = ITEMS.register("red_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_RED.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> LAPTOP_BLACK = ITEMS.register("black_laptop",
            () -> new BlockItem(ModBlocks.LAPTOP_BLACK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Door Bells
    public static final RegistryObject<BlockItem> DOOR_BELL_OAK = ITEMS.register("oak_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_OAK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_SPRUCE = ITEMS.register("spruce_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_SPRUCE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_BIRCH = ITEMS.register("birch_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_BIRCH.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_JUNGLE = ITEMS.register("jungle_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_JUNGLE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_ACACIA = ITEMS.register("acacia_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_ACACIA.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_DARK_OAK = ITEMS.register("dark_oak_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_DARK_OAK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_CRIMSON = ITEMS.register("crimson_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_CRIMSON.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_WARPED = ITEMS.register("warped_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_WARPED.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_MANGROVE = ITEMS.register("mangrove_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_MANGROVE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_OAK = ITEMS.register("stripped_oak_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_OAK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_SPRUCE = ITEMS.register("stripped_spruce_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_SPRUCE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_BIRCH = ITEMS.register("stripped_birch_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_BIRCH.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_JUNGLE = ITEMS.register("stripped_jungle_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_JUNGLE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_ACACIA = ITEMS.register("stripped_acacia_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_ACACIA.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_DARK_OAK = ITEMS.register("stripped_dark_oak_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_DARK_OAK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_CRIMSON = ITEMS.register("stripped_crimson_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_CRIMSON.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_WARPED = ITEMS.register("stripped_warped_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_WARPED.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DOOR_BELL_STRIPPED_MANGROVE = ITEMS.register("stripped_mangrove_door_bell",
            () -> new BlockItem(ModBlocks.DOOR_BELL_STRIPPED_MANGROVE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Inflatable Castles
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_WHITE = ITEMS.register("white_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_WHITE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_ORANGE = ITEMS.register("orange_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_ORANGE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_MAGENTA = ITEMS.register("magenta_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_MAGENTA.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_LIGHT_BLUE = ITEMS.register("light_blue_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_LIGHT_BLUE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_YELLOW = ITEMS.register("yellow_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_YELLOW.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_LIME = ITEMS.register("lime_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_LIME.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_PINK = ITEMS.register("pink_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_PINK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_GRAY = ITEMS.register("gray_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_GRAY.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_LIGHT_GRAY = ITEMS.register("light_gray_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_LIGHT_GRAY.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_CYAN = ITEMS.register("cyan_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_CYAN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_PURPLE = ITEMS.register("purple_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_PURPLE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_BLUE = ITEMS.register("blue_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_BLUE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_BROWN = ITEMS.register("brown_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_BROWN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_GREEN = ITEMS.register("green_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_GREEN.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_RED = ITEMS.register("red_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_RED.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> INFLATABLE_CASTLE_BLACK = ITEMS.register("black_inflatable_castle",
            () -> new BlockItem(ModBlocks.INFLATABLE_CASTLE_BLACK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> CASTLE_NETTING = ITEMS.register("castle_netting",
            () -> new BlockItem(ModBlocks.CASTLE_NETTING.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Appliances
    public static final RegistryObject<BlockItem> BIN_LIGHT = ITEMS.register("bin_light",
            () -> new BlockItem(ModBlocks.BIN_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BIN_DARK = ITEMS.register("bin_dark",
            () -> new BlockItem(ModBlocks.BIN_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BLENDER_LIGHT = ITEMS.register("blender_light",
            () -> new BlockItem(ModBlocks.BLENDER_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BLENDER_DARK = ITEMS.register("blender_dark",
            () -> new BlockItem(ModBlocks.BLENDER_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DISHWASHER_LIGHT = ITEMS.register("dishwasher_light",
            () -> new BlockItem(ModBlocks.DISHWASHER_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> DISHWASHER_DARK = ITEMS.register("dishwasher_dark",
            () -> new BlockItem(ModBlocks.DISHWASHER_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> MICROWAVE_LIGHT = ITEMS.register("microwave_light",
            () -> new BlockItem(ModBlocks.MICROWAVE_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> MICROWAVE_DARK = ITEMS.register("microwave_dark",
            () -> new BlockItem(ModBlocks.MICROWAVE_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> OVEN_LIGHT = ITEMS.register("oven_light",
            () -> new BlockItem(ModBlocks.OVEN_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> OVEN_DARK = ITEMS.register("oven_dark",
            () -> new BlockItem(ModBlocks.OVEN_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> OVEN_RANGE_HOOD_LIGHT = ITEMS.register("oven_range_hood_light",
            () -> new BlockItem(ModBlocks.OVEN_RANGE_HOOD_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> OVEN_RANGE_HOOD_DARK = ITEMS.register("oven_range_hood_dark",
            () -> new BlockItem(ModBlocks.OVEN_RANGE_HOOD_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SINK_LIGHT = ITEMS.register("sink_light",
            () -> new BlockItem(ModBlocks.SINK_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SINK_DARK = ITEMS.register("sink_dark",
            () -> new BlockItem(ModBlocks.SINK_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SHOWER_LIGHT = ITEMS.register("shower_light",
            () -> new BlockItem(ModBlocks.SHOWER_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SHOWER_DARK = ITEMS.register("shower_dark",
            () -> new BlockItem(ModBlocks.SHOWER_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SHOWER_HEAD_LIGHT = ITEMS.register("shower_head_light",
            () -> new BlockItem(ModBlocks.SHOWER_HEAD_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> SHOWER_HEAD_DARK = ITEMS.register("shower_head_dark",
            () -> new BlockItem(ModBlocks.SHOWER_HEAD_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TOASTER_LIGHT = ITEMS.register("toaster_light",
            () -> new BlockItem(ModBlocks.TOASTER_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TOASTER_DARK = ITEMS.register("toaster_dark",
            () -> new BlockItem(ModBlocks.TOASTER_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TOILET_LIGHT = ITEMS.register("toilet_light",
            () -> new BlockItem(ModBlocks.TOILET_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TOILET_DARK = ITEMS.register("toilet_dark",
            () -> new BlockItem(ModBlocks.TOILET_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

    //Festive
    public static final RegistryObject<BlockItem> CANDLE = ITEMS.register("candle",
            () -> new BlockItem(ModBlocks.CANDLE.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> WREATH = ITEMS.register("wreath",
            () -> new BlockItem(ModBlocks.WREATH.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

}
