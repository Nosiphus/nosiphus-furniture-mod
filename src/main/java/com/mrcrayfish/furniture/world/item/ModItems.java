package com.mrcrayfish.furniture.world.item;

import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.mrcrayfish.furniture.world.item.ModCreativeModeTabs.addToTab;

public class ModItems
{

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("cfm");

    // Tables
    public static final DeferredItem<BlockItem> OAK_TABLE = addToTab(ITEMS.register("oak_table",
            () -> new BlockItem(ModBlocks.OAK_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_TABLE = addToTab(ITEMS.register("spruce_table",
            () -> new BlockItem(ModBlocks.SPRUCE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_TABLE = addToTab(ITEMS.register("birch_table",
            () -> new BlockItem(ModBlocks.BIRCH_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_TABLE = addToTab(ITEMS.register("jungle_table",
            () -> new BlockItem(ModBlocks.JUNGLE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_TABLE = addToTab(ITEMS.register("acacia_table",
            () -> new BlockItem(ModBlocks.ACACIA_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_TABLE = addToTab(ITEMS.register("dark_oak_table",
            () -> new BlockItem(ModBlocks.DARK_OAK_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_TABLE = addToTab(ITEMS.register("mangrove_table",
            () -> new BlockItem(ModBlocks.MANGROVE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_TABLE = addToTab(ITEMS.register("cherry_table",
            () -> new BlockItem(ModBlocks.CHERRY_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_TABLE = addToTab(ITEMS.register("crimson_table",
            () -> new BlockItem(ModBlocks.CRIMSON_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_TABLE = addToTab(ITEMS.register("warped_table",
            () -> new BlockItem(ModBlocks.WARPED_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_TABLE = addToTab(ITEMS.register("stripped_oak_table",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_TABLE = addToTab(ITEMS.register("stripped_spruce_table",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_TABLE = addToTab(ITEMS.register("stripped_birch_table",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_TABLE = addToTab(ITEMS.register("stripped_jungle_table",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_TABLE = addToTab(ITEMS.register("stripped_acacia_table",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_TABLE = addToTab(ITEMS.register("stripped_dark_oak_table",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_TABLE = addToTab(ITEMS.register("stripped_mangrove_table",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_TABLE = addToTab(ITEMS.register("stripped_cherry_table",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_TABLE = addToTab(ITEMS.register("stripped_crimson_table",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_TABLE = addToTab(ITEMS.register("stripped_warped_table",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_TABLE.get(), new Item.Properties())));

    // Chairs
    public static final DeferredItem<BlockItem> OAK_CHAIR = addToTab(ITEMS.register("oak_chair",
            () -> new BlockItem(ModBlocks.OAK_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_CHAIR = addToTab(ITEMS.register("spruce_chair",
            () -> new BlockItem(ModBlocks.SPRUCE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_CHAIR = addToTab(ITEMS.register("birch_chair",
            () -> new BlockItem(ModBlocks.BIRCH_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_CHAIR = addToTab(ITEMS.register("jungle_chair",
            () -> new BlockItem(ModBlocks.JUNGLE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_CHAIR = addToTab(ITEMS.register("acacia_chair",
            () -> new BlockItem(ModBlocks.ACACIA_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_CHAIR = addToTab(ITEMS.register("dark_oak_chair",
            () -> new BlockItem(ModBlocks.DARK_OAK_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_CHAIR = addToTab(ITEMS.register("mangrove_chair",
            () -> new BlockItem(ModBlocks.MANGROVE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_CHAIR = addToTab(ITEMS.register("cherry_chair",
            () -> new BlockItem(ModBlocks.CHERRY_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_CHAIR = addToTab(ITEMS.register("crimson_chair",
            () -> new BlockItem(ModBlocks.CRIMSON_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_CHAIR = addToTab(ITEMS.register("warped_chair",
            () -> new BlockItem(ModBlocks.WARPED_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_CHAIR = addToTab(ITEMS.register("stripped_oak_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_CHAIR = addToTab(ITEMS.register("stripped_spruce_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_CHAIR = addToTab(ITEMS.register("stripped_birch_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_CHAIR = addToTab(ITEMS.register("stripped_jungle_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_CHAIR = addToTab(ITEMS.register("stripped_acacia_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_CHAIR = addToTab(ITEMS.register("stripped_dark_oak_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_CHAIR = addToTab(ITEMS.register("stripped_mangrove_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_CHAIR = addToTab(ITEMS.register("stripped_cherry_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_CHAIR = addToTab(ITEMS.register("stripped_crimson_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_CHAIR.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_CHAIR = addToTab(ITEMS.register("stripped_warped_chair",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_CHAIR.get(), new Item.Properties())));

    // Coffee Tables
    public static final DeferredItem<BlockItem> OAK_COFFEE_TABLE = addToTab(ITEMS.register("oak_coffee_table",
            () -> new BlockItem(ModBlocks.OAK_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_COFFEE_TABLE = addToTab(ITEMS.register("spruce_coffee_table",
            () -> new BlockItem(ModBlocks.SPRUCE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_COFFEE_TABLE = addToTab(ITEMS.register("birch_coffee_table",
            () -> new BlockItem(ModBlocks.BIRCH_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_COFFEE_TABLE = addToTab(ITEMS.register("jungle_coffee_table",
            () -> new BlockItem(ModBlocks.JUNGLE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_COFFEE_TABLE = addToTab(ITEMS.register("acacia_coffee_table",
            () -> new BlockItem(ModBlocks.ACACIA_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_COFFEE_TABLE = addToTab(ITEMS.register("dark_oak_coffee_table",
            () -> new BlockItem(ModBlocks.DARK_OAK_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_COFFEE_TABLE = addToTab(ITEMS.register("mangrove_coffee_table",
            () -> new BlockItem(ModBlocks.MANGROVE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_COFFEE_TABLE = addToTab(ITEMS.register("cherry_coffee_table",
            () -> new BlockItem(ModBlocks.CHERRY_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_COFFEE_TABLE = addToTab(ITEMS.register("crimson_coffee_table",
            () -> new BlockItem(ModBlocks.CRIMSON_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_COFFEE_TABLE = addToTab(ITEMS.register("warped_coffee_table",
            () -> new BlockItem(ModBlocks.WARPED_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_COFFEE_TABLE = addToTab(ITEMS.register("stripped_oak_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_COFFEE_TABLE = addToTab(ITEMS.register("stripped_spruce_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_COFFEE_TABLE = addToTab(ITEMS.register("stripped_birch_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_COFFEE_TABLE = addToTab(ITEMS.register("stripped_jungle_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_COFFEE_TABLE = addToTab(ITEMS.register("stripped_acacia_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_COFFEE_TABLE = addToTab(ITEMS.register("stripped_dark_oak_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_COFFEE_TABLE = addToTab(ITEMS.register("stripped_mangrove_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_COFFEE_TABLE = addToTab(ITEMS.register("stripped_cherry_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_COFFEE_TABLE = addToTab(ITEMS.register("stripped_crimson_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_COFFEE_TABLE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_COFFEE_TABLE = addToTab(ITEMS.register("stripped_warped_coffee_table",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_COFFEE_TABLE.get(), new Item.Properties())));

    // Cabinets
    public static final DeferredItem<BlockItem> OAK_CABINET = addToTab(ITEMS.register("oak_cabinet",
            () -> new BlockItem(ModBlocks.OAK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_CABINET = addToTab(ITEMS.register("spruce_cabinet",
            () -> new BlockItem(ModBlocks.SPRUCE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_CABINET = addToTab(ITEMS.register("birch_cabinet",
            () -> new BlockItem(ModBlocks.BIRCH_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_CABINET = addToTab(ITEMS.register("jungle_cabinet",
            () -> new BlockItem(ModBlocks.JUNGLE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_CABINET = addToTab(ITEMS.register("acacia_cabinet",
            () -> new BlockItem(ModBlocks.ACACIA_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_CABINET = addToTab(ITEMS.register("dark_oak_cabinet",
            () -> new BlockItem(ModBlocks.DARK_OAK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_CABINET = addToTab(ITEMS.register("mangrove_cabinet",
            () -> new BlockItem(ModBlocks.MANGROVE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_CABINET = addToTab(ITEMS.register("cherry_cabinet",
            () -> new BlockItem(ModBlocks.CHERRY_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_CABINET = addToTab(ITEMS.register("crimson_cabinet",
            () -> new BlockItem(ModBlocks.CRIMSON_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_CABINET = addToTab(ITEMS.register("warped_cabinet",
            () -> new BlockItem(ModBlocks.WARPED_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_CABINET = addToTab(ITEMS.register("stripped_oak_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_CABINET = addToTab(ITEMS.register("stripped_spruce_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_CABINET = addToTab(ITEMS.register("stripped_birch_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_CABINET = addToTab(ITEMS.register("stripped_jungle_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_CABINET = addToTab(ITEMS.register("stripped_acacia_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_CABINET = addToTab(ITEMS.register("stripped_dark_oak_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_CABINET = addToTab(ITEMS.register("stripped_mangrove_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_CABINET = addToTab(ITEMS.register("stripped_cherry_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_CABINET = addToTab(ITEMS.register("stripped_crimson_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_CABINET = addToTab(ITEMS.register("stripped_warped_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_CABINET.get(), new Item.Properties())));

    // Bedside Cabinets
    public static final DeferredItem<BlockItem> OAK_BEDSIDE_CABINET = addToTab(ITEMS.register("oak_bedside_cabinet",
            () -> new BlockItem(ModBlocks.OAK_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_BEDSIDE_CABINET = addToTab(ITEMS.register("spruce_bedside_cabinet",
            () -> new BlockItem(ModBlocks.SPRUCE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_BEDSIDE_CABINET = addToTab(ITEMS.register("birch_bedside_cabinet",
            () -> new BlockItem(ModBlocks.BIRCH_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_BEDSIDE_CABINET = addToTab(ITEMS.register("jungle_bedside_cabinet",
            () -> new BlockItem(ModBlocks.JUNGLE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_BEDSIDE_CABINET = addToTab(ITEMS.register("acacia_bedside_cabinet",
            () -> new BlockItem(ModBlocks.ACACIA_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_BEDSIDE_CABINET = addToTab(ITEMS.register("dark_oak_bedside_cabinet",
            () -> new BlockItem(ModBlocks.DARK_OAK_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_BEDSIDE_CABINET = addToTab(ITEMS.register("mangrove_bedside_cabinet",
            () -> new BlockItem(ModBlocks.MANGROVE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_BEDSIDE_CABINET = addToTab(ITEMS.register("cherry_bedside_cabinet",
            () -> new BlockItem(ModBlocks.CHERRY_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_BEDSIDE_CABINET = addToTab(ITEMS.register("crimson_bedside_cabinet",
            () -> new BlockItem(ModBlocks.CRIMSON_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_BEDSIDE_CABINET = addToTab(ITEMS.register("warped_bedside_cabinet",
            () -> new BlockItem(ModBlocks.WARPED_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_oak_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_spruce_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_birch_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_jungle_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_acacia_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_dark_oak_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_mangrove_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_cherry_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_crimson_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_BEDSIDE_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_BEDSIDE_CABINET = addToTab(ITEMS.register("stripped_warped_bedside_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_BEDSIDE_CABINET.get(), new Item.Properties())));

    // Desks
    public static final DeferredItem<BlockItem> OAK_DESK = addToTab(ITEMS.register("oak_desk",
            () -> new BlockItem(ModBlocks.OAK_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_DESK = addToTab(ITEMS.register("spruce_desk",
            () -> new BlockItem(ModBlocks.SPRUCE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_DESK = addToTab(ITEMS.register("birch_desk",
            () -> new BlockItem(ModBlocks.BIRCH_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_DESK = addToTab(ITEMS.register("jungle_desk",
            () -> new BlockItem(ModBlocks.JUNGLE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_DESK = addToTab(ITEMS.register("acacia_desk",
            () -> new BlockItem(ModBlocks.ACACIA_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_DESK = addToTab(ITEMS.register("dark_oak_desk",
            () -> new BlockItem(ModBlocks.DARK_OAK_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_DESK = addToTab(ITEMS.register("mangrove_desk",
            () -> new BlockItem(ModBlocks.MANGROVE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_DESK = addToTab(ITEMS.register("cherry_desk",
            () -> new BlockItem(ModBlocks.CHERRY_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_DESK = addToTab(ITEMS.register("crimson_desk",
            () -> new BlockItem(ModBlocks.CRIMSON_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_DESK = addToTab(ITEMS.register("warped_desk",
            () -> new BlockItem(ModBlocks.WARPED_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_DESK = addToTab(ITEMS.register("stripped_oak_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_DESK = addToTab(ITEMS.register("stripped_spruce_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_DESK = addToTab(ITEMS.register("stripped_birch_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_DESK = addToTab(ITEMS.register("stripped_jungle_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_DESK = addToTab(ITEMS.register("stripped_acacia_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_DESK = addToTab(ITEMS.register("stripped_dark_oak_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_DESK = addToTab(ITEMS.register("stripped_mangrove_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_DESK = addToTab(ITEMS.register("stripped_cherry_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_DESK = addToTab(ITEMS.register("stripped_crimson_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_DESK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_DESK = addToTab(ITEMS.register("stripped_warped_desk",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_DESK.get(), new Item.Properties())));

    // Desk Cabinets
    public static final DeferredItem<BlockItem> OAK_DESK_CABINET = addToTab(ITEMS.register("oak_desk_cabinet",
            () -> new BlockItem(ModBlocks.OAK_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_DESK_CABINET = addToTab(ITEMS.register("spruce_desk_cabinet",
            () -> new BlockItem(ModBlocks.SPRUCE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_DESK_CABINET = addToTab(ITEMS.register("birch_desk_cabinet",
            () -> new BlockItem(ModBlocks.BIRCH_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_DESK_CABINET = addToTab(ITEMS.register("jungle_desk_cabinet",
            () -> new BlockItem(ModBlocks.JUNGLE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_DESK_CABINET = addToTab(ITEMS.register("acacia_desk_cabinet",
            () -> new BlockItem(ModBlocks.ACACIA_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_DESK_CABINET = addToTab(ITEMS.register("dark_oak_desk_cabinet",
            () -> new BlockItem(ModBlocks.DARK_OAK_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_DESK_CABINET = addToTab(ITEMS.register("mangrove_desk_cabinet",
            () -> new BlockItem(ModBlocks.MANGROVE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_DESK_CABINET = addToTab(ITEMS.register("cherry_desk_cabinet",
            () -> new BlockItem(ModBlocks.CHERRY_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_DESK_CABINET = addToTab(ITEMS.register("crimson_desk_cabinet",
            () -> new BlockItem(ModBlocks.CRIMSON_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_DESK_CABINET = addToTab(ITEMS.register("warped_desk_cabinet",
            () -> new BlockItem(ModBlocks.WARPED_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_DESK_CABINET = addToTab(ITEMS.register("stripped_oak_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_DESK_CABINET = addToTab(ITEMS.register("stripped_spruce_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_DESK_CABINET = addToTab(ITEMS.register("stripped_birch_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_DESK_CABINET = addToTab(ITEMS.register("stripped_jungle_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_DESK_CABINET = addToTab(ITEMS.register("stripped_acacia_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_DESK_CABINET = addToTab(ITEMS.register("stripped_dark_oak_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_DESK_CABINET = addToTab(ITEMS.register("stripped_mangrove_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_DESK_CABINET = addToTab(ITEMS.register("stripped_cherry_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_DESK_CABINET = addToTab(ITEMS.register("stripped_crimson_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_DESK_CABINET.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_DESK_CABINET = addToTab(ITEMS.register("stripped_warped_desk_cabinet",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_DESK_CABINET.get(), new Item.Properties())));

    // Sofas
    public static final DeferredItem<BlockItem> WHITE_SOFA = addToTab(ITEMS.register("white_sofa",
            () -> new BlockItem(ModBlocks.WHITE_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_SOFA = addToTab(ITEMS.register("light_gray_sofa",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_SOFA = addToTab(ITEMS.register("gray_sofa",
            () -> new BlockItem(ModBlocks.GRAY_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_SOFA = addToTab(ITEMS.register("black_sofa",
            () -> new BlockItem(ModBlocks.BLACK_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_SOFA = addToTab(ITEMS.register("brown_sofa",
            () -> new BlockItem(ModBlocks.BROWN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_SOFA = addToTab(ITEMS.register("red_sofa",
            () -> new BlockItem(ModBlocks.RED_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_SOFA = addToTab(ITEMS.register("orange_sofa",
            () -> new BlockItem(ModBlocks.ORANGE_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_SOFA = addToTab(ITEMS.register("beige_sofa",
            () -> new BlockItem(ModBlocks.BEIGE_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_SOFA = addToTab(ITEMS.register("yellow_sofa",
            () -> new BlockItem(ModBlocks.YELLOW_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_SOFA = addToTab(ITEMS.register("lime_sofa",
            () -> new BlockItem(ModBlocks.LIME_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_SOFA = addToTab(ITEMS.register("green_sofa",
            () -> new BlockItem(ModBlocks.GREEN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_SOFA = addToTab(ITEMS.register("cyan_sofa",
            () -> new BlockItem(ModBlocks.CYAN_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_SOFA = addToTab(ITEMS.register("light_blue_sofa",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_SOFA = addToTab(ITEMS.register("blue_sofa",
            () -> new BlockItem(ModBlocks.BLUE_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_SOFA = addToTab(ITEMS.register("purple_sofa",
            () -> new BlockItem(ModBlocks.PURPLE_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_SOFA = addToTab(ITEMS.register("magenta_sofa",
            () -> new BlockItem(ModBlocks.MAGENTA_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_SOFA = addToTab(ITEMS.register("pink_sofa",
            () -> new BlockItem(ModBlocks.PINK_SOFA.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RAINBOW_SOFA = addToTab(ITEMS.register("rainbow_sofa",
            () -> new BlockItem(ModBlocks.RAINBOW_SOFA.get(), new Item.Properties())));

    // Blinds
    public static final DeferredItem<BlockItem> OAK_BLINDS = addToTab(ITEMS.register("oak_blinds",
            () -> new BlockItem(ModBlocks.OAK_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_BLINDS = addToTab(ITEMS.register("spruce_blinds",
            () -> new BlockItem(ModBlocks.SPRUCE_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_BLINDS = addToTab(ITEMS.register("birch_blinds",
            () -> new BlockItem(ModBlocks.BIRCH_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_BLINDS = addToTab(ITEMS.register("jungle_blinds",
            () -> new BlockItem(ModBlocks.JUNGLE_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_BLINDS = addToTab(ITEMS.register("acacia_blinds",
            () -> new BlockItem(ModBlocks.ACACIA_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_BLINDS = addToTab(ITEMS.register("dark_oak_blinds",
            () -> new BlockItem(ModBlocks.DARK_OAK_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_BLINDS = addToTab(ITEMS.register("mangrove_blinds",
            () -> new BlockItem(ModBlocks.MANGROVE_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_BLINDS = addToTab(ITEMS.register("cherry_blinds",
            () -> new BlockItem(ModBlocks.CHERRY_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_BLINDS = addToTab(ITEMS.register("crimson_blinds",
            () -> new BlockItem(ModBlocks.CRIMSON_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_BLINDS = addToTab(ITEMS.register("warped_blinds",
            () -> new BlockItem(ModBlocks.WARPED_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_BLINDS = addToTab(ITEMS.register("stripped_oak_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_BLINDS = addToTab(ITEMS.register("stripped_spruce_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_BLINDS = addToTab(ITEMS.register("stripped_birch_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_BLINDS = addToTab(ITEMS.register("stripped_jungle_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_BLINDS = addToTab(ITEMS.register("stripped_acacia_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_BLINDS = addToTab(ITEMS.register("stripped_dark_oak_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_BLINDS = addToTab(ITEMS.register("stripped_mangrove_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_BLINDS = addToTab(ITEMS.register("stripped_cherry_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_BLINDS = addToTab(ITEMS.register("stripped_crimson_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_BLINDS.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_BLINDS = addToTab(ITEMS.register("stripped_warped_blinds",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_BLINDS.get(), new Item.Properties())));

    // Upgraded Fences
    public static final DeferredItem<BlockItem> OAK_UPGRADED_FENCE = addToTab(ITEMS.register("oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.OAK_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_UPGRADED_FENCE = addToTab(ITEMS.register("spruce_upgraded_fence",
            () -> new BlockItem(ModBlocks.SPRUCE_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_UPGRADED_FENCE = addToTab(ITEMS.register("birch_upgraded_fence",
            () -> new BlockItem(ModBlocks.BIRCH_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_UPGRADED_FENCE = addToTab(ITEMS.register("jungle_upgraded_fence",
            () -> new BlockItem(ModBlocks.JUNGLE_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_UPGRADED_FENCE = addToTab(ITEMS.register("acacia_upgraded_fence",
            () -> new BlockItem(ModBlocks.ACACIA_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_UPGRADED_FENCE = addToTab(ITEMS.register("dark_oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.DARK_OAK_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_UPGRADED_FENCE = addToTab(ITEMS.register("mangrove_upgraded_fence",
            () -> new BlockItem(ModBlocks.MANGROVE_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_UPGRADED_FENCE = addToTab(ITEMS.register("cherry_upgraded_fence",
            () -> new BlockItem(ModBlocks.CHERRY_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_UPGRADED_FENCE = addToTab(ITEMS.register("crimson_upgraded_fence",
            () -> new BlockItem(ModBlocks.CRIMSON_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_UPGRADED_FENCE = addToTab(ITEMS.register("warped_upgraded_fence",
            () -> new BlockItem(ModBlocks.WARPED_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_spruce_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_birch_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_jungle_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_acacia_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_dark_oak_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_mangrove_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_cherry_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_crimson_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_UPGRADED_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_UPGRADED_FENCE = addToTab(ITEMS.register("stripped_warped_upgraded_fence",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_UPGRADED_FENCE.get(), new Item.Properties())));

    // Upgraded Gates
    public static final DeferredItem<BlockItem> OAK_UPGRADED_GATE = addToTab(ITEMS.register("oak_upgraded_gate",
            () -> new BlockItem(ModBlocks.OAK_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_UPGRADED_GATE = addToTab(ITEMS.register("spruce_upgraded_gate",
            () -> new BlockItem(ModBlocks.SPRUCE_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_UPGRADED_GATE = addToTab(ITEMS.register("birch_upgraded_gate",
            () -> new BlockItem(ModBlocks.BIRCH_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_UPGRADED_GATE = addToTab(ITEMS.register("jungle_upgraded_gate",
            () -> new BlockItem(ModBlocks.JUNGLE_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_UPGRADED_GATE = addToTab(ITEMS.register("acacia_upgraded_gate",
            () -> new BlockItem(ModBlocks.ACACIA_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_UPGRADED_GATE = addToTab(ITEMS.register("dark_oak_upgraded_gate",
            () -> new BlockItem(ModBlocks.DARK_OAK_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_UPGRADED_GATE = addToTab(ITEMS.register("mangrove_upgraded_gate",
            () -> new BlockItem(ModBlocks.MANGROVE_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_UPGRADED_GATE = addToTab(ITEMS.register("cherry_upgraded_gate",
            () -> new BlockItem(ModBlocks.CHERRY_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_UPGRADED_GATE = addToTab(ITEMS.register("crimson_upgraded_gate",
            () -> new BlockItem(ModBlocks.CRIMSON_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_UPGRADED_GATE = addToTab(ITEMS.register("warped_upgraded_gate",
            () -> new BlockItem(ModBlocks.WARPED_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_UPGRADED_GATE = addToTab(ITEMS.register("stripped_oak_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_UPGRADED_GATE = addToTab(ITEMS.register("stripped_spruce_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_UPGRADED_GATE = addToTab(ITEMS.register("stripped_birch_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_UPGRADED_GATE = addToTab(ITEMS.register("stripped_jungle_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_UPGRADED_GATE = addToTab(ITEMS.register("stripped_acacia_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_UPGRADED_GATE = addToTab(ITEMS.register("stripped_dark_oak_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_UPGRADED_GATE = addToTab(ITEMS.register("stripped_mangrove_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_UPGRADED_GATE = addToTab(ITEMS.register("stripped_cherry_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_UPGRADED_GATE = addToTab(ITEMS.register("stripped_crimson_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_UPGRADED_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_UPGRADED_GATE = addToTab(ITEMS.register("stripped_warped_upgraded_gate",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_UPGRADED_GATE.get(), new Item.Properties())));

    // Picket Fences
    public static final DeferredItem<BlockItem> WHITE_PICKET_FENCE = addToTab(ITEMS.register("white_picket_fence",
            () -> new BlockItem(ModBlocks.WHITE_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_PICKET_FENCE = addToTab(ITEMS.register("light_gray_picket_fence",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_PICKET_FENCE = addToTab(ITEMS.register("gray_picket_fence",
            () -> new BlockItem(ModBlocks.GRAY_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_PICKET_FENCE = addToTab(ITEMS.register("black_picket_fence",
            () -> new BlockItem(ModBlocks.BLACK_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_PICKET_FENCE = addToTab(ITEMS.register("brown_picket_fence",
            () -> new BlockItem(ModBlocks.BROWN_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_PICKET_FENCE = addToTab(ITEMS.register("red_picket_fence",
            () -> new BlockItem(ModBlocks.RED_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_PICKET_FENCE = addToTab(ITEMS.register("orange_picket_fence",
            () -> new BlockItem(ModBlocks.ORANGE_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_PICKET_FENCE = addToTab(ITEMS.register("beige_picket_fence",
            () -> new BlockItem(ModBlocks.BEIGE_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_PICKET_FENCE = addToTab(ITEMS.register("yellow_picket_fence",
            () -> new BlockItem(ModBlocks.YELLOW_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_PICKET_FENCE = addToTab(ITEMS.register("lime_picket_fence",
            () -> new BlockItem(ModBlocks.LIME_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_PICKET_FENCE = addToTab(ITEMS.register("green_picket_fence",
            () -> new BlockItem(ModBlocks.GREEN_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_PICKET_FENCE = addToTab(ITEMS.register("cyan_picket_fence",
            () -> new BlockItem(ModBlocks.CYAN_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_PICKET_FENCE = addToTab(ITEMS.register("light_blue_picket_fence",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_PICKET_FENCE = addToTab(ITEMS.register("blue_picket_fence",
            () -> new BlockItem(ModBlocks.BLUE_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_PICKET_FENCE = addToTab(ITEMS.register("purple_picket_fence",
            () -> new BlockItem(ModBlocks.PURPLE_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_PICKET_FENCE = addToTab(ITEMS.register("magenta_picket_fence",
            () -> new BlockItem(ModBlocks.MAGENTA_PICKET_FENCE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_PICKET_FENCE = addToTab(ITEMS.register("pink_picket_fence",
            () -> new BlockItem(ModBlocks.PINK_PICKET_FENCE.get(), new Item.Properties())));

    // Picket Gates
    public static final DeferredItem<BlockItem> WHITE_PICKET_GATE = addToTab(ITEMS.register("white_picket_gate",
            () -> new BlockItem(ModBlocks.WHITE_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_PICKET_GATE = addToTab(ITEMS.register("light_gray_picket_gate",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_PICKET_GATE = addToTab(ITEMS.register("gray_picket_gate",
            () -> new BlockItem(ModBlocks.GRAY_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_PICKET_GATE = addToTab(ITEMS.register("black_picket_gate",
            () -> new BlockItem(ModBlocks.BLACK_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_PICKET_GATE = addToTab(ITEMS.register("brown_picket_gate",
            () -> new BlockItem(ModBlocks.BROWN_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_PICKET_GATE = addToTab(ITEMS.register("red_picket_gate",
            () -> new BlockItem(ModBlocks.RED_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_PICKET_GATE = addToTab(ITEMS.register("orange_picket_gate",
            () -> new BlockItem(ModBlocks.ORANGE_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_PICKET_GATE = addToTab(ITEMS.register("beige_picket_gate",
            () -> new BlockItem(ModBlocks.BEIGE_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_PICKET_GATE = addToTab(ITEMS.register("yellow_picket_gate",
            () -> new BlockItem(ModBlocks.YELLOW_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_PICKET_GATE = addToTab(ITEMS.register("lime_picket_gate",
            () -> new BlockItem(ModBlocks.LIME_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_PICKET_GATE = addToTab(ITEMS.register("green_picket_gate",
            () -> new BlockItem(ModBlocks.GREEN_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_PICKET_GATE = addToTab(ITEMS.register("cyan_picket_gate",
            () -> new BlockItem(ModBlocks.CYAN_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_PICKET_GATE = addToTab(ITEMS.register("light_blue_picket_gate",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_PICKET_GATE = addToTab(ITEMS.register("blue_picket_gate",
            () -> new BlockItem(ModBlocks.BLUE_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_PICKET_GATE = addToTab(ITEMS.register("purple_picket_gate",
            () -> new BlockItem(ModBlocks.PURPLE_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_PICKET_GATE = addToTab(ITEMS.register("magenta_picket_gate",
            () -> new BlockItem(ModBlocks.MAGENTA_PICKET_GATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_PICKET_GATE = addToTab(ITEMS.register("pink_picket_gate",
            () -> new BlockItem(ModBlocks.PINK_PICKET_GATE.get(), new Item.Properties())));

    // Crates
    public static final DeferredItem<BlockItem> OAK_CRATE = addToTab(ITEMS.register("oak_crate",
            () -> new BlockItem(ModBlocks.OAK_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_CRATE = addToTab(ITEMS.register("spruce_crate",
            () -> new BlockItem(ModBlocks.SPRUCE_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_CRATE = addToTab(ITEMS.register("birch_crate",
            () -> new BlockItem(ModBlocks.BIRCH_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_CRATE = addToTab(ITEMS.register("jungle_crate",
            () -> new BlockItem(ModBlocks.JUNGLE_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_CRATE = addToTab(ITEMS.register("acacia_crate",
            () -> new BlockItem(ModBlocks.ACACIA_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_CRATE = addToTab(ITEMS.register("dark_oak_crate",
            () -> new BlockItem(ModBlocks.DARK_OAK_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_CRATE = addToTab(ITEMS.register("mangrove_crate",
            () -> new BlockItem(ModBlocks.MANGROVE_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_CRATE = addToTab(ITEMS.register("cherry_crate",
            () -> new BlockItem(ModBlocks.CHERRY_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_CRATE = addToTab(ITEMS.register("crimson_crate",
            () -> new BlockItem(ModBlocks.CRIMSON_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_CRATE = addToTab(ITEMS.register("warped_crate",
            () -> new BlockItem(ModBlocks.WARPED_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_CRATE = addToTab(ITEMS.register("stripped_oak_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_CRATE = addToTab(ITEMS.register("stripped_spruce_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_CRATE = addToTab(ITEMS.register("stripped_birch_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_CRATE = addToTab(ITEMS.register("stripped_jungle_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_CRATE = addToTab(ITEMS.register("stripped_acacia_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_CRATE = addToTab(ITEMS.register("stripped_dark_oak_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_CRATE = addToTab(ITEMS.register("stripped_mangrove_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_CRATE = addToTab(ITEMS.register("stripped_cherry_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_CRATE = addToTab(ITEMS.register("stripped_crimson_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_CRATE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_CRATE = addToTab(ITEMS.register("stripped_warped_crate",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_CRATE.get(), new Item.Properties())));

    // Park Benches
    public static final DeferredItem<BlockItem> OAK_PARK_BENCH = addToTab(ITEMS.register("oak_park_bench",
            () -> new BlockItem(ModBlocks.OAK_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_PARK_BENCH = addToTab(ITEMS.register("spruce_park_bench",
            () -> new BlockItem(ModBlocks.SPRUCE_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_PARK_BENCH = addToTab(ITEMS.register("birch_park_bench",
            () -> new BlockItem(ModBlocks.BIRCH_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_PARK_BENCH = addToTab(ITEMS.register("jungle_park_bench",
            () -> new BlockItem(ModBlocks.JUNGLE_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_PARK_BENCH = addToTab(ITEMS.register("acacia_park_bench",
            () -> new BlockItem(ModBlocks.ACACIA_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_PARK_BENCH = addToTab(ITEMS.register("dark_oak_park_bench",
            () -> new BlockItem(ModBlocks.DARK_OAK_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_PARK_BENCH = addToTab(ITEMS.register("mangrove_park_bench",
            () -> new BlockItem(ModBlocks.MANGROVE_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_PARK_BENCH = addToTab(ITEMS.register("cherry_park_bench",
            () -> new BlockItem(ModBlocks.CHERRY_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_PARK_BENCH = addToTab(ITEMS.register("crimson_park_bench",
            () -> new BlockItem(ModBlocks.CRIMSON_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_PARK_BENCH = addToTab(ITEMS.register("warped_park_bench",
            () -> new BlockItem(ModBlocks.WARPED_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_PARK_BENCH = addToTab(ITEMS.register("stripped_oak_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_PARK_BENCH = addToTab(ITEMS.register("stripped_spruce_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_PARK_BENCH = addToTab(ITEMS.register("stripped_birch_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_PARK_BENCH = addToTab(ITEMS.register("stripped_jungle_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_PARK_BENCH = addToTab(ITEMS.register("stripped_acacia_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_PARK_BENCH = addToTab(ITEMS.register("stripped_dark_oak_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_PARK_BENCH = addToTab(ITEMS.register("stripped_mangrove_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_PARK_BENCH = addToTab(ITEMS.register("stripped_cherry_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_PARK_BENCH = addToTab(ITEMS.register("stripped_crimson_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_PARK_BENCH.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_PARK_BENCH = addToTab(ITEMS.register("stripped_warped_park_bench",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_PARK_BENCH.get(), new Item.Properties())));

    // Post Box
    public static final DeferredItem<BlockItem> POST_BOX = addToTab(ITEMS.register("post_box",
            () -> new BlockItem(ModBlocks.POST_BOX.get(), new Item.Properties())));

    // Mail Boxes
    public static final DeferredItem<BlockItem> OAK_MAIL_BOX = addToTab(ITEMS.register("oak_mail_box",
            () -> new BlockItem(ModBlocks.OAK_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_MAIL_BOX = addToTab(ITEMS.register("spruce_mail_box",
            () -> new BlockItem(ModBlocks.SPRUCE_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_MAIL_BOX = addToTab(ITEMS.register("birch_mail_box",
            () -> new BlockItem(ModBlocks.BIRCH_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_MAIL_BOX = addToTab(ITEMS.register("jungle_mail_box",
            () -> new BlockItem(ModBlocks.JUNGLE_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_MAIL_BOX = addToTab(ITEMS.register("acacia_mail_box",
            () -> new BlockItem(ModBlocks.ACACIA_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_MAIL_BOX = addToTab(ITEMS.register("dark_oak_mail_box",
            () -> new BlockItem(ModBlocks.DARK_OAK_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_MAIL_BOX = addToTab(ITEMS.register("mangrove_mail_box",
            () -> new BlockItem(ModBlocks.MANGROVE_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_MAIL_BOX = addToTab(ITEMS.register("cherry_mail_box",
            () -> new BlockItem(ModBlocks.CHERRY_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_MAIL_BOX = addToTab(ITEMS.register("crimson_mail_box",
            () -> new BlockItem(ModBlocks.CRIMSON_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_MAIL_BOX = addToTab(ITEMS.register("warped_mail_box",
            () -> new BlockItem(ModBlocks.WARPED_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_MAIL_BOX = addToTab(ITEMS.register("stripped_oak_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_MAIL_BOX = addToTab(ITEMS.register("stripped_spruce_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_MAIL_BOX = addToTab(ITEMS.register("stripped_birch_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_MAIL_BOX = addToTab(ITEMS.register("stripped_jungle_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_MAIL_BOX = addToTab(ITEMS.register("stripped_acacia_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_MAIL_BOX = addToTab(ITEMS.register("stripped_dark_oak_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_MAIL_BOX = addToTab(ITEMS.register("stripped_mangrove_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_MAIL_BOX = addToTab(ITEMS.register("stripped_cherry_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_MAIL_BOX = addToTab(ITEMS.register("stripped_crimson_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_MAIL_BOX.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_MAIL_BOX = addToTab(ITEMS.register("stripped_warped_mail_box",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_MAIL_BOX.get(), new Item.Properties())));

    // Hedges
    public static final DeferredItem<BlockItem> OAK_HEDGE = addToTab(ITEMS.register("oak_hedge",
            () -> new BlockItem(ModBlocks.OAK_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_HEDGE = addToTab(ITEMS.register("spruce_hedge",
            () -> new BlockItem(ModBlocks.SPRUCE_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_HEDGE = addToTab(ITEMS.register("birch_hedge",
            () -> new BlockItem(ModBlocks.BIRCH_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_HEDGE = addToTab(ITEMS.register("jungle_hedge",
            () -> new BlockItem(ModBlocks.JUNGLE_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_HEDGE = addToTab(ITEMS.register("acacia_hedge",
            () -> new BlockItem(ModBlocks.ACACIA_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_HEDGE = addToTab(ITEMS.register("dark_oak_hedge",
            () -> new BlockItem(ModBlocks.DARK_OAK_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_HEDGE = addToTab(ITEMS.register("mangrove_hedge",
            () -> new BlockItem(ModBlocks.MANGROVE_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_HEDGE = addToTab(ITEMS.register("cherry_hedge",
            () -> new BlockItem(ModBlocks.CHERRY_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> AZALEA_HEDGE = addToTab(ITEMS.register("azalea_hedge",
            () -> new BlockItem(ModBlocks.AZALEA_HEDGE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> FLOWERING_AZALEA_HEDGE = addToTab(ITEMS.register("flowering_azalea_hedge",
            () -> new BlockItem(ModBlocks.FLOWERING_AZALEA_HEDGE.get(), new Item.Properties())));

    // Rock Path
    public static final DeferredItem<BlockItem> ROCK_PATH = addToTab(ITEMS.register("rock_path",
            () -> new BlockItem(ModBlocks.ROCK_PATH.get(), new Item.Properties())));

    // Trampolines
    public static final DeferredItem<BlockItem> WHITE_TRAMPOLINE = addToTab(ITEMS.register("white_trampoline",
            () -> new BlockItem(ModBlocks.WHITE_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_TRAMPOLINE = addToTab(ITEMS.register("light_gray_trampoline",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_TRAMPOLINE = addToTab(ITEMS.register("gray_trampoline",
            () -> new BlockItem(ModBlocks.GRAY_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_TRAMPOLINE = addToTab(ITEMS.register("black_trampoline",
            () -> new BlockItem(ModBlocks.BLACK_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_TRAMPOLINE = addToTab(ITEMS.register("brown_trampoline",
            () -> new BlockItem(ModBlocks.BROWN_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_TRAMPOLINE = addToTab(ITEMS.register("red_trampoline",
            () -> new BlockItem(ModBlocks.RED_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_TRAMPOLINE = addToTab(ITEMS.register("orange_trampoline",
            () -> new BlockItem(ModBlocks.ORANGE_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_TRAMPOLINE = addToTab(ITEMS.register("beige_trampoline",
            () -> new BlockItem(ModBlocks.BEIGE_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_TRAMPOLINE = addToTab(ITEMS.register("yellow_trampoline",
            () -> new BlockItem(ModBlocks.YELLOW_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_TRAMPOLINE = addToTab(ITEMS.register("lime_trampoline",
            () -> new BlockItem(ModBlocks.LIME_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_TRAMPOLINE = addToTab(ITEMS.register("green_trampoline",
            () -> new BlockItem(ModBlocks.GREEN_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_TRAMPOLINE = addToTab(ITEMS.register("cyan_trampoline",
            () -> new BlockItem(ModBlocks.CYAN_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_TRAMPOLINE = addToTab(ITEMS.register("light_blue_trampoline",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_TRAMPOLINE = addToTab(ITEMS.register("blue_trampoline",
            () -> new BlockItem(ModBlocks.BLUE_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_TRAMPOLINE = addToTab(ITEMS.register("purple_trampoline",
            () -> new BlockItem(ModBlocks.PURPLE_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_TRAMPOLINE = addToTab(ITEMS.register("magenta_trampoline",
            () -> new BlockItem(ModBlocks.MAGENTA_TRAMPOLINE.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_TRAMPOLINE = addToTab(ITEMS.register("pink_trampoline",
            () -> new BlockItem(ModBlocks.PINK_TRAMPOLINE.get(), new Item.Properties())));

    // Coolers
    public static final DeferredItem<BlockItem> WHITE_COOLER = addToTab(ITEMS.register("white_cooler",
            () -> new BlockItem(ModBlocks.WHITE_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_COOLER = addToTab(ITEMS.register("light_gray_cooler",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_COOLER = addToTab(ITEMS.register("gray_cooler",
            () -> new BlockItem(ModBlocks.GRAY_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_COOLER = addToTab(ITEMS.register("black_cooler",
            () -> new BlockItem(ModBlocks.BLACK_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_COOLER = addToTab(ITEMS.register("brown_cooler",
            () -> new BlockItem(ModBlocks.BROWN_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_COOLER = addToTab(ITEMS.register("red_cooler",
            () -> new BlockItem(ModBlocks.RED_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_COOLER = addToTab(ITEMS.register("orange_cooler",
            () -> new BlockItem(ModBlocks.ORANGE_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_COOLER = addToTab(ITEMS.register("beige_cooler",
            () -> new BlockItem(ModBlocks.BEIGE_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_COOLER = addToTab(ITEMS.register("yellow_cooler",
            () -> new BlockItem(ModBlocks.YELLOW_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_COOLER = addToTab(ITEMS.register("lime_cooler",
            () -> new BlockItem(ModBlocks.LIME_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_COOLER = addToTab(ITEMS.register("green_cooler",
            () -> new BlockItem(ModBlocks.GREEN_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_COOLER = addToTab(ITEMS.register("cyan_cooler",
            () -> new BlockItem(ModBlocks.CYAN_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_COOLER = addToTab(ITEMS.register("light_blue_cooler",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_COOLER = addToTab(ITEMS.register("blue_cooler",
            () -> new BlockItem(ModBlocks.BLUE_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_COOLER = addToTab(ITEMS.register("purple_cooler",
            () -> new BlockItem(ModBlocks.PURPLE_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_COOLER = addToTab(ITEMS.register("magenta_cooler",
            () -> new BlockItem(ModBlocks.MAGENTA_COOLER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_COOLER = addToTab(ITEMS.register("pink_cooler",
            () -> new BlockItem(ModBlocks.PINK_COOLER.get(), new Item.Properties())));

    // Grills
    public static final DeferredItem<BlockItem> WHITE_GRILL = addToTab(ITEMS.register("white_grill",
            () -> new BlockItem(ModBlocks.WHITE_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_GRILL = addToTab(ITEMS.register("light_gray_grill",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_GRILL = addToTab(ITEMS.register("gray_grill",
            () -> new BlockItem(ModBlocks.GRAY_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_GRILL = addToTab(ITEMS.register("black_grill",
            () -> new BlockItem(ModBlocks.BLACK_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_GRILL = addToTab(ITEMS.register("brown_grill",
            () -> new BlockItem(ModBlocks.BROWN_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_GRILL = addToTab(ITEMS.register("red_grill",
            () -> new BlockItem(ModBlocks.RED_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_GRILL = addToTab(ITEMS.register("orange_grill",
            () -> new BlockItem(ModBlocks.ORANGE_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_GRILL = addToTab(ITEMS.register("beige_grill",
            () -> new BlockItem(ModBlocks.BEIGE_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_GRILL = addToTab(ITEMS.register("yellow_grill",
            () -> new BlockItem(ModBlocks.YELLOW_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_GRILL = addToTab(ITEMS.register("lime_grill",
            () -> new BlockItem(ModBlocks.LIME_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_GRILL = addToTab(ITEMS.register("green_grill",
            () -> new BlockItem(ModBlocks.GREEN_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_GRILL = addToTab(ITEMS.register("cyan_grill",
            () -> new BlockItem(ModBlocks.CYAN_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_GRILL = addToTab(ITEMS.register("light_blue_grill",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_GRILL = addToTab(ITEMS.register("blue_grill",
            () -> new BlockItem(ModBlocks.BLUE_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_GRILL = addToTab(ITEMS.register("purple_grill",
            () -> new BlockItem(ModBlocks.PURPLE_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_GRILL = addToTab(ITEMS.register("magenta_grill",
            () -> new BlockItem(ModBlocks.MAGENTA_GRILL.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_GRILL = addToTab(ITEMS.register("pink_grill",
            () -> new BlockItem(ModBlocks.PINK_GRILL.get(), new Item.Properties())));

    // Door Mat
    public static final DeferredItem<BlockItem> DOOR_MAT = addToTab(ITEMS.register("door_mat",
            () -> new DoorMatItem(ModBlocks.DOOR_MAT.get(), new Item.Properties())));

    // Diving Board
    public static final DeferredItem<BlockItem> DIVING_BOARD = addToTab(ITEMS.register("diving_board",
            () -> new BlockItem(ModBlocks.DIVING_BOARD.get(), new Item.Properties())));

    // Kitchen Counters
    public static final DeferredItem<BlockItem> OAK_KITCHEN_COUNTER = addToTab(ITEMS.register("oak_kitchen_counter",
            () -> new BlockItem(ModBlocks.OAK_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_KITCHEN_COUNTER = addToTab(ITEMS.register("spruce_kitchen_counter",
            () -> new BlockItem(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_KITCHEN_COUNTER = addToTab(ITEMS.register("birch_kitchen_counter",
            () -> new BlockItem(ModBlocks.BIRCH_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_KITCHEN_COUNTER = addToTab(ITEMS.register("jungle_kitchen_counter",
            () -> new BlockItem(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_KITCHEN_COUNTER = addToTab(ITEMS.register("acacia_kitchen_counter",
            () -> new BlockItem(ModBlocks.ACACIA_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_KITCHEN_COUNTER = addToTab(ITEMS.register("dark_oak_kitchen_counter",
            () -> new BlockItem(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_KITCHEN_COUNTER = addToTab(ITEMS.register("mangrove_kitchen_counter",
            () -> new BlockItem(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_KITCHEN_COUNTER = addToTab(ITEMS.register("cherry_kitchen_counter",
            () -> new BlockItem(ModBlocks.CHERRY_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_KITCHEN_COUNTER = addToTab(ITEMS.register("crimson_kitchen_counter",
            () -> new BlockItem(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_KITCHEN_COUNTER = addToTab(ITEMS.register("warped_kitchen_counter",
            () -> new BlockItem(ModBlocks.WARPED_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_oak_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_spruce_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_birch_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_jungle_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_acacia_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_dark_oak_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_mangrove_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_cherry_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_crimson_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_KITCHEN_COUNTER = addToTab(ITEMS.register("stripped_warped_kitchen_counter",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WHITE_KITCHEN_COUNTER = addToTab(ITEMS.register("white_kitchen_counter",
            () -> new BlockItem(ModBlocks.WHITE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_KITCHEN_COUNTER = addToTab(ITEMS.register("light_gray_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_KITCHEN_COUNTER = addToTab(ITEMS.register("gray_kitchen_counter",
            () -> new BlockItem(ModBlocks.GRAY_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_KITCHEN_COUNTER = addToTab(ITEMS.register("black_kitchen_counter",
            () -> new BlockItem(ModBlocks.BLACK_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_KITCHEN_COUNTER = addToTab(ITEMS.register("brown_kitchen_counter",
            () -> new BlockItem(ModBlocks.BROWN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_KITCHEN_COUNTER = addToTab(ITEMS.register("red_kitchen_counter",
            () -> new BlockItem(ModBlocks.RED_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_KITCHEN_COUNTER = addToTab(ITEMS.register("orange_kitchen_counter",
            () -> new BlockItem(ModBlocks.ORANGE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_KITCHEN_COUNTER = addToTab(ITEMS.register("beige_kitchen_counter",
            () -> new BlockItem(ModBlocks.BEIGE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_KITCHEN_COUNTER = addToTab(ITEMS.register("yellow_kitchen_counter",
            () -> new BlockItem(ModBlocks.YELLOW_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_KITCHEN_COUNTER = addToTab(ITEMS.register("lime_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIME_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_KITCHEN_COUNTER = addToTab(ITEMS.register("green_kitchen_counter",
            () -> new BlockItem(ModBlocks.GREEN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_KITCHEN_COUNTER = addToTab(ITEMS.register("cyan_kitchen_counter",
            () -> new BlockItem(ModBlocks.CYAN_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_KITCHEN_COUNTER = addToTab(ITEMS.register("light_blue_kitchen_counter",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_KITCHEN_COUNTER = addToTab(ITEMS.register("blue_kitchen_counter",
            () -> new BlockItem(ModBlocks.BLUE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_KITCHEN_COUNTER = addToTab(ITEMS.register("purple_kitchen_counter",
            () -> new BlockItem(ModBlocks.PURPLE_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_KITCHEN_COUNTER = addToTab(ITEMS.register("magenta_kitchen_counter",
            () -> new BlockItem(ModBlocks.MAGENTA_KITCHEN_COUNTER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_KITCHEN_COUNTER = addToTab(ITEMS.register("pink_kitchen_counter",
            () -> new BlockItem(ModBlocks.PINK_KITCHEN_COUNTER.get(), new Item.Properties())));

    // Kitchen Drawers
    public static final DeferredItem<BlockItem> OAK_KITCHEN_DRAWER = addToTab(ITEMS.register("oak_kitchen_drawer",
            () -> new BlockItem(ModBlocks.OAK_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_KITCHEN_DRAWER = addToTab(ITEMS.register("spruce_kitchen_drawer",
            () -> new BlockItem(ModBlocks.SPRUCE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_KITCHEN_DRAWER = addToTab(ITEMS.register("birch_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BIRCH_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_KITCHEN_DRAWER = addToTab(ITEMS.register("jungle_kitchen_drawer",
            () -> new BlockItem(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_KITCHEN_DRAWER = addToTab(ITEMS.register("acacia_kitchen_drawer",
            () -> new BlockItem(ModBlocks.ACACIA_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_KITCHEN_DRAWER = addToTab(ITEMS.register("dark_oak_kitchen_drawer",
            () -> new BlockItem(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_KITCHEN_DRAWER = addToTab(ITEMS.register("mangrove_kitchen_drawer",
            () -> new BlockItem(ModBlocks.MANGROVE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_KITCHEN_DRAWER = addToTab(ITEMS.register("cherry_kitchen_drawer",
            () -> new BlockItem(ModBlocks.CHERRY_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_KITCHEN_DRAWER = addToTab(ITEMS.register("crimson_kitchen_drawer",
            () -> new BlockItem(ModBlocks.CRIMSON_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_KITCHEN_DRAWER = addToTab(ITEMS.register("warped_kitchen_drawer",
            () -> new BlockItem(ModBlocks.WARPED_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_oak_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_spruce_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_birch_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_jungle_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_acacia_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_dark_oak_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_mangrove_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_cherry_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_crimson_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_KITCHEN_DRAWER = addToTab(ITEMS.register("stripped_warped_kitchen_drawer",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WHITE_KITCHEN_DRAWER = addToTab(ITEMS.register("white_kitchen_drawer",
            () -> new BlockItem(ModBlocks.WHITE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_KITCHEN_DRAWER = addToTab(ITEMS.register("light_gray_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_KITCHEN_DRAWER = addToTab(ITEMS.register("gray_kitchen_drawer",
            () -> new BlockItem(ModBlocks.GRAY_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_KITCHEN_DRAWER = addToTab(ITEMS.register("black_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BLACK_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_KITCHEN_DRAWER = addToTab(ITEMS.register("brown_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BROWN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_KITCHEN_DRAWER = addToTab(ITEMS.register("red_kitchen_drawer",
            () -> new BlockItem(ModBlocks.RED_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_KITCHEN_DRAWER = addToTab(ITEMS.register("orange_kitchen_drawer",
            () -> new BlockItem(ModBlocks.ORANGE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_KITCHEN_DRAWER = addToTab(ITEMS.register("beige_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BEIGE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_KITCHEN_DRAWER = addToTab(ITEMS.register("yellow_kitchen_drawer",
            () -> new BlockItem(ModBlocks.YELLOW_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_KITCHEN_DRAWER = addToTab(ITEMS.register("lime_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIME_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_KITCHEN_DRAWER = addToTab(ITEMS.register("green_kitchen_drawer",
            () -> new BlockItem(ModBlocks.GREEN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_KITCHEN_DRAWER = addToTab(ITEMS.register("cyan_kitchen_drawer",
            () -> new BlockItem(ModBlocks.CYAN_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_KITCHEN_DRAWER = addToTab(ITEMS.register("light_blue_kitchen_drawer",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_KITCHEN_DRAWER = addToTab(ITEMS.register("blue_kitchen_drawer",
            () -> new BlockItem(ModBlocks.BLUE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_KITCHEN_DRAWER = addToTab(ITEMS.register("purple_kitchen_drawer",
            () -> new BlockItem(ModBlocks.PURPLE_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_KITCHEN_DRAWER = addToTab(ITEMS.register("magenta_kitchen_drawer",
            () -> new BlockItem(ModBlocks.MAGENTA_KITCHEN_DRAWER.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_KITCHEN_DRAWER = addToTab(ITEMS.register("pink_kitchen_drawer",
            () -> new BlockItem(ModBlocks.PINK_KITCHEN_DRAWER.get(), new Item.Properties())));

    // Kitchen Sinks
    public static final DeferredItem<BlockItem> OAK_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("oak_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.OAK_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("spruce_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.SPRUCE_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("birch_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.BIRCH_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("jungle_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.JUNGLE_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("acacia_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.ACACIA_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("dark_oak_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.DARK_OAK_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("mangrove_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.MANGROVE_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("cherry_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.CHERRY_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("crimson_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.CRIMSON_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("warped_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.WARPED_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_oak_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_spruce_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_birch_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_jungle_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_acacia_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_dark_oak_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_mangrove_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_cherry_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_crimson_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_KITCHEN_SINK_LIGHT = addToTab(ITEMS.register("stripped_warped_kitchen_sink_light",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> OAK_KITCHEN_SINK_DARK = addToTab(ITEMS.register("oak_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.OAK_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> SPRUCE_KITCHEN_SINK_DARK = addToTab(ITEMS.register("spruce_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.SPRUCE_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BIRCH_KITCHEN_SINK_DARK = addToTab(ITEMS.register("birch_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.BIRCH_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> JUNGLE_KITCHEN_SINK_DARK = addToTab(ITEMS.register("jungle_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.JUNGLE_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ACACIA_KITCHEN_SINK_DARK = addToTab(ITEMS.register("acacia_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.ACACIA_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> DARK_OAK_KITCHEN_SINK_DARK = addToTab(ITEMS.register("dark_oak_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.DARK_OAK_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MANGROVE_KITCHEN_SINK_DARK = addToTab(ITEMS.register("mangrove_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.MANGROVE_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CHERRY_KITCHEN_SINK_DARK = addToTab(ITEMS.register("cherry_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.CHERRY_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CRIMSON_KITCHEN_SINK_DARK = addToTab(ITEMS.register("crimson_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.CRIMSON_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WARPED_KITCHEN_SINK_DARK = addToTab(ITEMS.register("warped_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.WARPED_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_OAK_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_oak_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_OAK_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_SPRUCE_KITCHS_SINK_DARK = addToTab(ITEMS.register("stripped_spruce_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_BIRCH_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_birch_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_JUNGLE_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_jungle_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_ACACIA_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_acacia_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_DARK_OAK_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_dark_oak_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_MANGROVE_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_mangrove_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CHERRY_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_cherry_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_CRIMSON_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_crimson_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> STRIPPED_WARPED_KITCHEN_SINK_DARK = addToTab(ITEMS.register("stripped_warped_kitchen_sink_dark",
            () -> new BlockItem(ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_DARK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> WHITE_KITCHEN_SINK = addToTab(ITEMS.register("white_kitchen_sink",
            () -> new BlockItem(ModBlocks.WHITE_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_GRAY_KITCHEN_SINK = addToTab(ITEMS.register("light_gray_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIGHT_GRAY_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GRAY_KITCHEN_SINK = addToTab(ITEMS.register("gray_kitchen_sink",
            () -> new BlockItem(ModBlocks.GRAY_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLACK_KITCHEN_SINK = addToTab(ITEMS.register("black_kitchen_sink",
            () -> new BlockItem(ModBlocks.BLACK_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BROWN_KITCHEN_SINK = addToTab(ITEMS.register("brown_kitchen_sink",
            () -> new BlockItem(ModBlocks.BROWN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> RED_KITCHEN_SINK = addToTab(ITEMS.register("red_kitchen_sink",
            () -> new BlockItem(ModBlocks.RED_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> ORANGE_KITCHEN_SINK = addToTab(ITEMS.register("orange_kitchen_sink",
            () -> new BlockItem(ModBlocks.ORANGE_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BEIGE_KITCHEN_SINK = addToTab(ITEMS.register("beige_kitchen_sink",
            () -> new BlockItem(ModBlocks.BEIGE_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> YELLOW_KITCHEN_SINK = addToTab(ITEMS.register("yellow_kitchen_sink",
            () -> new BlockItem(ModBlocks.YELLOW_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIME_KITCHEN_SINK = addToTab(ITEMS.register("lime_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIME_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> GREEN_KITCHEN_SINK = addToTab(ITEMS.register("green_kitchen_sink",
            () -> new BlockItem(ModBlocks.GREEN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> CYAN_KITCHEN_SINK = addToTab(ITEMS.register("cyan_kitchen_sink",
            () -> new BlockItem(ModBlocks.CYAN_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> LIGHT_BLUE_KITCHEN_SINK = addToTab(ITEMS.register("light_blue_kitchen_sink",
            () -> new BlockItem(ModBlocks.LIGHT_BLUE_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> BLUE_KITCHEN_SINK = addToTab(ITEMS.register("blue_kitchen_sink",
            () -> new BlockItem(ModBlocks.BLUE_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PURPLE_KITCHEN_SINK = addToTab(ITEMS.register("purple_kitchen_sink",
            () -> new BlockItem(ModBlocks.PURPLE_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> MAGENTA_KITCHEN_SINK = addToTab(ITEMS.register("magenta_kitchen_sink",
            () -> new BlockItem(ModBlocks.MAGENTA_KITCHEN_SINK.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> PINK_KITCHEN_SINK = addToTab(ITEMS.register("pink_kitchen_sink",
            () -> new BlockItem(ModBlocks.PINK_KITCHEN_SINK.get(), new Item.Properties())));

    // Appliances
    public static final DeferredItem<BlockItem> FRIDGE_LIGHT = addToTab(ITEMS.register("fridge_light",
            () -> new FridgeItem(ModBlocks.FRIDGE_LIGHT.get(), ModBlocks.FREEZER_LIGHT.get(), new Item.Properties())));
    public static final DeferredItem<BlockItem> FRIDGE_DARK = addToTab(ITEMS.register("fridge_dark",
            () -> new FridgeItem(ModBlocks.FRIDGE_DARK.get(), ModBlocks.FREEZER_DARK.get(), new Item.Properties())));

    // Items
    public static final DeferredItem<Item> SPATULA = addToTab(ITEMS.register("spatula",
            () -> new SwordItem(Tiers.IRON, new Item.Properties())));

}
