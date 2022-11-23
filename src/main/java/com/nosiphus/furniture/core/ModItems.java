package com.nosiphus.furniture.core;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "nfm");

    //Tables
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

    //Appliances
    public static final RegistryObject<BlockItem> BLENDER_LIGHT = ITEMS.register("blender_light",
            () -> new BlockItem(ModBlocks.BLENDER_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> BLENDER_DARK = ITEMS.register("blender_dark",
            () -> new BlockItem(ModBlocks.BLENDER_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
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
    public static final RegistryObject<BlockItem> TOILET_LIGHT = ITEMS.register("toilet_light",
            () -> new BlockItem(ModBlocks.TOILET_LIGHT.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));
    public static final RegistryObject<BlockItem> TOILET_DARK = ITEMS.register("toilet_dark",
            () -> new BlockItem(ModBlocks.TOILET_DARK.get(), new Item.Properties().tab(NosiphusFurnitureMod.GROUP)));

}
