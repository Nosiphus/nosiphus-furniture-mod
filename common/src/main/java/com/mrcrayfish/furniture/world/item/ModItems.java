package com.mrcrayfish.furniture.world.item;

import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static com.mrcrayfish.furniture.world.item.ModCreativeModeTabs.addToTab;

public class ModItems
{

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
    public static final Supplier<BlockItem> OAK_TABLE = registerBlockItem("oak_table", ModBlocks.OAK_TABLE);
    public static final Supplier<BlockItem> SPRUCE_TABLE = registerBlockItem("spruce_table", ModBlocks.SPRUCE_TABLE);
    public static final Supplier<BlockItem> BIRCH_TABLE = registerBlockItem("birch_table", ModBlocks.BIRCH_TABLE);
    public static final Supplier<BlockItem> JUNGLE_TABLE = registerBlockItem("jungle_table", ModBlocks.JUNGLE_TABLE);
    public static final Supplier<BlockItem> ACACIA_TABLE = registerBlockItem("acacia_table", ModBlocks.ACACIA_TABLE);
    public static final Supplier<BlockItem> DARK_OAK_TABLE = registerBlockItem("dark_oak_table", ModBlocks.DARK_OAK_TABLE);
    public static final Supplier<BlockItem> MANGROVE_TABLE = registerBlockItem("mangrove_table", ModBlocks.MANGROVE_TABLE);
    public static final Supplier<BlockItem> CHERRY_TABLE = registerBlockItem("cherry_table", ModBlocks.CHERRY_TABLE);
    public static final Supplier<BlockItem> CRIMSON_TABLE = registerBlockItem("crimson_table", ModBlocks.CRIMSON_TABLE);
    public static final Supplier<BlockItem> WARPED_TABLE = registerBlockItem("warped_table", ModBlocks.WARPED_TABLE);
    public static final Supplier<BlockItem> BAMBOO_TABLE = registerBlockItem("bamboo_table", ModBlocks.BAMBOO_TABLE);
    public static final Supplier<BlockItem> STRIPPED_OAK_TABLE = registerBlockItem("stripped_oak_table", ModBlocks.STRIPPED_OAK_TABLE);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_TABLE = registerBlockItem("stripped_spruce_table", ModBlocks.STRIPPED_SPRUCE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_TABLE = registerBlockItem("stripped_birch_table", ModBlocks.STRIPPED_BIRCH_TABLE);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_TABLE = registerBlockItem("stripped_jungle_table", ModBlocks.STRIPPED_JUNGLE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_TABLE = registerBlockItem("stripped_acacia_table", ModBlocks.STRIPPED_ACACIA_TABLE);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_TABLE = registerBlockItem("stripped_dark_oak_table", ModBlocks.STRIPPED_DARK_OAK_TABLE);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_TABLE = registerBlockItem("stripped_mangrove_table", ModBlocks.STRIPPED_MANGROVE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_TABLE = registerBlockItem("stripped_cherry_table", ModBlocks.STRIPPED_CHERRY_TABLE);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_TABLE = registerBlockItem("stripped_crimson_table", ModBlocks.STRIPPED_CRIMSON_TABLE);
    public static final Supplier<BlockItem> STRIPPED_WARPED_TABLE = registerBlockItem("stripped_warped_table", ModBlocks.STRIPPED_WARPED_TABLE);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_TABLE = registerBlockItem("stripped_bamboo_table", ModBlocks.STRIPPED_BAMBOO_TABLE);

    // Chairs
    public static final Supplier<BlockItem> OAK_CHAIR = registerBlockItem("oak_chair", ModBlocks.OAK_CHAIR);
    public static final Supplier<BlockItem> SPRUCE_CHAIR = registerBlockItem("spruce_chair", ModBlocks.SPRUCE_CHAIR);
    public static final Supplier<BlockItem> BIRCH_CHAIR = registerBlockItem("birch_chair", ModBlocks.BIRCH_CHAIR);
    public static final Supplier<BlockItem> JUNGLE_CHAIR = registerBlockItem("jungle_chair", ModBlocks.JUNGLE_CHAIR);
    public static final Supplier<BlockItem> ACACIA_CHAIR = registerBlockItem("acacia_chair", ModBlocks.ACACIA_CHAIR);
    public static final Supplier<BlockItem> DARK_OAK_CHAIR = registerBlockItem("dark_oak_chair", ModBlocks.DARK_OAK_CHAIR);
    public static final Supplier<BlockItem> MANGROVE_CHAIR = registerBlockItem("mangrove_chair", ModBlocks.MANGROVE_CHAIR);
    public static final Supplier<BlockItem> CHERRY_CHAIR = registerBlockItem("cherry_chair", ModBlocks.CHERRY_CHAIR);
    public static final Supplier<BlockItem> CRIMSON_CHAIR = registerBlockItem("crimson_chair", ModBlocks.CRIMSON_CHAIR);
    public static final Supplier<BlockItem> WARPED_CHAIR = registerBlockItem("warped_chair", ModBlocks.WARPED_CHAIR);
    public static final Supplier<BlockItem> BAMBOO_CHAIR = registerBlockItem("bamboo_chair", ModBlocks.BAMBOO_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_OAK_CHAIR = registerBlockItem("stripped_oak_chair", ModBlocks.STRIPPED_OAK_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_CHAIR = registerBlockItem("stripped_spruce_chair", ModBlocks.STRIPPED_SPRUCE_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_CHAIR = registerBlockItem("stripped_birch_chair", ModBlocks.STRIPPED_BIRCH_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_CHAIR = registerBlockItem("stripped_jungle_chair", ModBlocks.STRIPPED_JUNGLE_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_CHAIR = registerBlockItem("stripped_acacia_chair", ModBlocks.STRIPPED_ACACIA_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_CHAIR = registerBlockItem("stripped_dark_oak_chair", ModBlocks.STRIPPED_DARK_OAK_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_CHAIR = registerBlockItem("stripped_mangrove_chair", ModBlocks.STRIPPED_MANGROVE_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_CHAIR = registerBlockItem("stripped_cherry_chair", ModBlocks.STRIPPED_CHERRY_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_CHAIR = registerBlockItem("stripped_crimson_chair", ModBlocks.STRIPPED_CRIMSON_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_WARPED_CHAIR = registerBlockItem("stripped_warped_chair", ModBlocks.STRIPPED_WARPED_CHAIR);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_CHAIR = registerBlockItem("stripped_bamboo_chair", ModBlocks.STRIPPED_BAMBOO_CHAIR);

    // Coffee Tables
    public static final Supplier<BlockItem> OAK_COFFEE_TABLE = registerBlockItem("oak_coffee_table", ModBlocks.OAK_COFFEE_TABLE);
    public static final Supplier<BlockItem> SPRUCE_COFFEE_TABLE = registerBlockItem("spruce_coffee_table", ModBlocks.SPRUCE_COFFEE_TABLE);
    public static final Supplier<BlockItem> BIRCH_COFFEE_TABLE = registerBlockItem("birch_coffee_table", ModBlocks.BIRCH_COFFEE_TABLE);
    public static final Supplier<BlockItem> JUNGLE_COFFEE_TABLE = registerBlockItem("jungle_coffee_table", ModBlocks.JUNGLE_COFFEE_TABLE);
    public static final Supplier<BlockItem> ACACIA_COFFEE_TABLE = registerBlockItem("acacia_coffee_table", ModBlocks.ACACIA_COFFEE_TABLE);
    public static final Supplier<BlockItem> DARK_OAK_COFFEE_TABLE = registerBlockItem("dark_oak_coffee_table", ModBlocks.DARK_OAK_COFFEE_TABLE);
    public static final Supplier<BlockItem> MANGROVE_COFFEE_TABLE = registerBlockItem("mangrove_coffee_table", ModBlocks.MANGROVE_COFFEE_TABLE);
    public static final Supplier<BlockItem> CHERRY_COFFEE_TABLE = registerBlockItem("cherry_coffee_table", ModBlocks.CHERRY_COFFEE_TABLE);
    public static final Supplier<BlockItem> CRIMSON_COFFEE_TABLE = registerBlockItem("crimson_coffee_table", ModBlocks.CRIMSON_COFFEE_TABLE);
    public static final Supplier<BlockItem> WARPED_COFFEE_TABLE = registerBlockItem("warped_coffee_table", ModBlocks.WARPED_COFFEE_TABLE);
    public static final Supplier<BlockItem> BAMBOO_COFFEE_TABLE = registerBlockItem("bamboo_coffee_table", ModBlocks.BAMBOO_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_OAK_COFFEE_TABLE = registerBlockItem("stripped_oak_coffee_table", ModBlocks.STRIPPED_OAK_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_COFFEE_TABLE = registerBlockItem("stripped_spruce_coffee_table", ModBlocks.STRIPPED_SPRUCE_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_COFFEE_TABLE = registerBlockItem("stripped_birch_coffee_table", ModBlocks.STRIPPED_BIRCH_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_COFFEE_TABLE = registerBlockItem("stripped_jungle_coffee_table", ModBlocks.STRIPPED_JUNGLE_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_COFFEE_TABLE = registerBlockItem("stripped_acacia_coffee_table", ModBlocks.STRIPPED_ACACIA_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_COFFEE_TABLE = registerBlockItem("stripped_dark_oak_coffee_table", ModBlocks.STRIPPED_DARK_OAK_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_COFFEE_TABLE = registerBlockItem("stripped_mangrove_coffee_table", ModBlocks.STRIPPED_MANGROVE_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_COFFEE_TABLE = registerBlockItem("stripped_cherry_coffee_table", ModBlocks.STRIPPED_CHERRY_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_COFFEE_TABLE = registerBlockItem("stripped_crimson_coffee_table", ModBlocks.STRIPPED_CRIMSON_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_WARPED_COFFEE_TABLE = registerBlockItem("stripped_warped_coffee_table", ModBlocks.STRIPPED_WARPED_COFFEE_TABLE);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_COFFEE_TABLE = registerBlockItem("stripped_bamboo_coffee_table", ModBlocks.STRIPPED_BAMBOO_COFFEE_TABLE);

    // Cabinets
    public static final Supplier<BlockItem> OAK_CABINET = registerBlockItem("oak_cabinet", ModBlocks.OAK_CABINET);
    public static final Supplier<BlockItem> SPRUCE_CABINET = registerBlockItem("spruce_cabinet", ModBlocks.SPRUCE_CABINET);
    public static final Supplier<BlockItem> BIRCH_CABINET = registerBlockItem("birch_cabinet", ModBlocks.BIRCH_CABINET);
    public static final Supplier<BlockItem> JUNGLE_CABINET = registerBlockItem("jungle_cabinet", ModBlocks.JUNGLE_CABINET);
    public static final Supplier<BlockItem> ACACIA_CABINET = registerBlockItem("acacia_cabinet", ModBlocks.ACACIA_CABINET);
    public static final Supplier<BlockItem> DARK_OAK_CABINET = registerBlockItem("dark_oak_cabinet", ModBlocks.DARK_OAK_CABINET);
    public static final Supplier<BlockItem> MANGROVE_CABINET = registerBlockItem("mangrove_cabinet", ModBlocks.MANGROVE_CABINET);
    public static final Supplier<BlockItem> CHERRY_CABINET = registerBlockItem("cherry_cabinet", ModBlocks.CHERRY_CABINET);
    public static final Supplier<BlockItem> CRIMSON_CABINET = registerBlockItem("crimson_cabinet", ModBlocks.CRIMSON_CABINET);
    public static final Supplier<BlockItem> WARPED_CABINET = registerBlockItem("warped_cabinet", ModBlocks.WARPED_CABINET);
    public static final Supplier<BlockItem> BAMBOO_CABINET = registerBlockItem("bamboo_cabinet", ModBlocks.BAMBOO_CABINET);
    public static final Supplier<BlockItem> STRIPPED_OAK_CABINET = registerBlockItem("stripped_oak_cabinet", ModBlocks.STRIPPED_OAK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_CABINET = registerBlockItem("stripped_spruce_cabinet", ModBlocks.STRIPPED_SPRUCE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_CABINET = registerBlockItem("stripped_birch_cabinet", ModBlocks.STRIPPED_BIRCH_CABINET);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_CABINET = registerBlockItem("stripped_jungle_cabinet", ModBlocks.STRIPPED_JUNGLE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_CABINET = registerBlockItem("stripped_acacia_cabinet", ModBlocks.STRIPPED_ACACIA_CABINET);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_CABINET = registerBlockItem("stripped_dark_oak_cabinet", ModBlocks.STRIPPED_DARK_OAK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_CABINET = registerBlockItem("stripped_mangrove_cabinet", ModBlocks.STRIPPED_MANGROVE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_CABINET = registerBlockItem("stripped_cherry_cabinet", ModBlocks.STRIPPED_CHERRY_CABINET);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_CABINET = registerBlockItem("stripped_crimson_cabinet", ModBlocks.STRIPPED_CRIMSON_CABINET);
    public static final Supplier<BlockItem> STRIPPED_WARPED_CABINET = registerBlockItem("stripped_warped_cabinet", ModBlocks.STRIPPED_WARPED_CABINET);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_CABINET = registerBlockItem("stripped_bamboo_cabinet", ModBlocks.STRIPPED_BAMBOO_CABINET);

    // Bedside Cabinets
    public static final Supplier<BlockItem> OAK_BEDSIDE_CABINET = registerBlockItem("oak_bedside_cabinet", ModBlocks.OAK_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> SPRUCE_BEDSIDE_CABINET = registerBlockItem("spruce_bedside_cabinet", ModBlocks.SPRUCE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> BIRCH_BEDSIDE_CABINET = registerBlockItem("birch_bedside_cabinet", ModBlocks.BIRCH_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> JUNGLE_BEDSIDE_CABINET = registerBlockItem("jungle_bedside_cabinet", ModBlocks.JUNGLE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> ACACIA_BEDSIDE_CABINET = registerBlockItem("acacia_bedside_cabinet", ModBlocks.ACACIA_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> DARK_OAK_BEDSIDE_CABINET = registerBlockItem("dark_oak_bedside_cabinet", ModBlocks.DARK_OAK_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> MANGROVE_BEDSIDE_CABINET = registerBlockItem("mangrove_bedside_cabinet", ModBlocks.MANGROVE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> CHERRY_BEDSIDE_CABINET = registerBlockItem("cherry_bedside_cabinet", ModBlocks.CHERRY_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> CRIMSON_BEDSIDE_CABINET = registerBlockItem("crimson_bedside_cabinet", ModBlocks.CRIMSON_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> WARPED_BEDSIDE_CABINET = registerBlockItem("warped_bedside_cabinet", ModBlocks.WARPED_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> BAMBOO_BEDSIDE_CABINET = registerBlockItem("bamboo_bedside_cabinet", ModBlocks.BAMBOO_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_OAK_BEDSIDE_CABINET = registerBlockItem("stripped_oak_bedside_cabinet", ModBlocks.STRIPPED_OAK_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_BEDSIDE_CABINET = registerBlockItem("stripped_spruce_bedside_cabinet", ModBlocks.STRIPPED_SPRUCE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_BEDSIDE_CABINET = registerBlockItem("stripped_birch_bedside_cabinet", ModBlocks.STRIPPED_BIRCH_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_BEDSIDE_CABINET = registerBlockItem("stripped_jungle_bedside_cabinet", ModBlocks.STRIPPED_JUNGLE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_BEDSIDE_CABINET = registerBlockItem("stripped_acacia_bedside_cabinet", ModBlocks.STRIPPED_ACACIA_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_BEDSIDE_CABINET = registerBlockItem("stripped_dark_oak_bedside_cabinet", ModBlocks.STRIPPED_DARK_OAK_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_BEDSIDE_CABINET = registerBlockItem("stripped_mangrove_bedside_cabinet", ModBlocks.STRIPPED_MANGROVE_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_BEDSIDE_CABINET = registerBlockItem("stripped_cherry_bedside_cabinet", ModBlocks.STRIPPED_CHERRY_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_BEDSIDE_CABINET = registerBlockItem("stripped_crimson_bedside_cabinet", ModBlocks.STRIPPED_CRIMSON_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_WARPED_BEDSIDE_CABINET = registerBlockItem("stripped_warped_bedside_cabinet", ModBlocks.STRIPPED_WARPED_BEDSIDE_CABINET);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_BEDSIDE_CABINET = registerBlockItem("stripped_bamboo_bedside_cabinet", ModBlocks.STRIPPED_BAMBOO_BEDSIDE_CABINET);

    // Desks
    public static final Supplier<BlockItem> OAK_DESK = registerBlockItem("oak_desk", ModBlocks.OAK_DESK);
    public static final Supplier<BlockItem> SPRUCE_DESK = registerBlockItem("spruce_desk", ModBlocks.SPRUCE_DESK);
    public static final Supplier<BlockItem> BIRCH_DESK = registerBlockItem("birch_desk", ModBlocks.BIRCH_DESK);
    public static final Supplier<BlockItem> JUNGLE_DESK = registerBlockItem("jungle_desk", ModBlocks.JUNGLE_DESK);
    public static final Supplier<BlockItem> ACACIA_DESK = registerBlockItem("acacia_desk", ModBlocks.ACACIA_DESK);
    public static final Supplier<BlockItem> DARK_OAK_DESK = registerBlockItem("dark_oak_desk", ModBlocks.DARK_OAK_DESK);
    public static final Supplier<BlockItem> MANGROVE_DESK = registerBlockItem("mangrove_desk", ModBlocks.MANGROVE_DESK);
    public static final Supplier<BlockItem> CHERRY_DESK = registerBlockItem("cherry_desk", ModBlocks.CHERRY_DESK);
    public static final Supplier<BlockItem> CRIMSON_DESK = registerBlockItem("crimson_desk", ModBlocks.CRIMSON_DESK);
    public static final Supplier<BlockItem> WARPED_DESK = registerBlockItem("warped_desk", ModBlocks.WARPED_DESK);
    public static final Supplier<BlockItem> BAMBOO_DESK = registerBlockItem("bamboo_desk", ModBlocks.BAMBOO_DESK);
    public static final Supplier<BlockItem> STRIPPED_OAK_DESK = registerBlockItem("stripped_oak_desk", ModBlocks.STRIPPED_OAK_DESK);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_DESK = registerBlockItem("stripped_spruce_desk", ModBlocks.STRIPPED_SPRUCE_DESK);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_DESK = registerBlockItem("stripped_birch_desk", ModBlocks.STRIPPED_BIRCH_DESK);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_DESK = registerBlockItem("stripped_jungle_desk", ModBlocks.STRIPPED_JUNGLE_DESK);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_DESK = registerBlockItem("stripped_acacia_desk", ModBlocks.STRIPPED_ACACIA_DESK);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_DESK = registerBlockItem("stripped_dark_oak_desk", ModBlocks.STRIPPED_DARK_OAK_DESK);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_DESK = registerBlockItem("stripped_mangrove_desk", ModBlocks.STRIPPED_MANGROVE_DESK);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_DESK = registerBlockItem("stripped_cherry_desk", ModBlocks.STRIPPED_CHERRY_DESK);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_DESK = registerBlockItem("stripped_crimson_desk", ModBlocks.STRIPPED_CRIMSON_DESK);
    public static final Supplier<BlockItem> STRIPPED_WARPED_DESK = registerBlockItem("stripped_warped_desk", ModBlocks.STRIPPED_WARPED_DESK);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_DESK = registerBlockItem("stripped_bamboo_desk", ModBlocks.STRIPPED_BAMBOO_DESK);

    // Desk Cabinets
    public static final Supplier<BlockItem> OAK_DESK_CABINET = registerBlockItem("oak_desk_cabinet", ModBlocks.OAK_DESK_CABINET);
    public static final Supplier<BlockItem> SPRUCE_DESK_CABINET = registerBlockItem("spruce_desk_cabinet", ModBlocks.SPRUCE_DESK_CABINET);
    public static final Supplier<BlockItem> BIRCH_DESK_CABINET = registerBlockItem("birch_desk_cabinet", ModBlocks.BIRCH_DESK_CABINET);
    public static final Supplier<BlockItem> JUNGLE_DESK_CABINET = registerBlockItem("jungle_desk_cabinet", ModBlocks.JUNGLE_DESK_CABINET);
    public static final Supplier<BlockItem> ACACIA_DESK_CABINET = registerBlockItem("acacia_desk_cabinet", ModBlocks.ACACIA_DESK_CABINET);
    public static final Supplier<BlockItem> DARK_OAK_DESK_CABINET = registerBlockItem("dark_oak_desk_cabinet", ModBlocks.DARK_OAK_DESK_CABINET);
    public static final Supplier<BlockItem> MANGROVE_DESK_CABINET = registerBlockItem("mangrove_desk_cabinet", ModBlocks.MANGROVE_DESK_CABINET);
    public static final Supplier<BlockItem> CHERRY_DESK_CABINET = registerBlockItem("cherry_desk_cabinet", ModBlocks.CHERRY_DESK_CABINET);
    public static final Supplier<BlockItem> CRIMSON_DESK_CABINET = registerBlockItem("crimson_desk_cabinet", ModBlocks.CRIMSON_DESK_CABINET);
    public static final Supplier<BlockItem> WARPED_DESK_CABINET = registerBlockItem("warped_desk_cabinet", ModBlocks.WARPED_DESK_CABINET);
    public static final Supplier<BlockItem> BAMBOO_DESK_CABINET = registerBlockItem("bamboo_desk_cabinet", ModBlocks.BAMBOO_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_OAK_DESK_CABINET = registerBlockItem("stripped_oak_desk_cabinet", ModBlocks.STRIPPED_OAK_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_DESK_CABINET = registerBlockItem("stripped_spruce_desk_cabinet", ModBlocks.STRIPPED_SPRUCE_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_DESK_CABINET = registerBlockItem("stripped_birch_desk_cabinet", ModBlocks.STRIPPED_BIRCH_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_DESK_CABINET = registerBlockItem("stripped_jungle_desk_cabinet", ModBlocks.STRIPPED_JUNGLE_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_DESK_CABINET = registerBlockItem("stripped_acacia_desk_cabinet", ModBlocks.STRIPPED_ACACIA_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_DESK_CABINET = registerBlockItem("stripped_dark_oak_desk_cabinet", ModBlocks.STRIPPED_DARK_OAK_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_DESK_CABINET = registerBlockItem("stripped_mangrove_desk_cabinet", ModBlocks.STRIPPED_MANGROVE_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_DESK_CABINET = registerBlockItem("stripped_cherry_desk_cabinet", ModBlocks.STRIPPED_CHERRY_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_DESK_CABINET = registerBlockItem("stripped_crimson_desk_cabinet", ModBlocks.STRIPPED_CRIMSON_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_WARPED_DESK_CABINET = registerBlockItem("stripped_warped_desk_cabinet", ModBlocks.STRIPPED_WARPED_DESK_CABINET);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_DESK_CABINET = registerBlockItem("stripped_bamboo_desk_cabinet", ModBlocks.STRIPPED_BAMBOO_DESK_CABINET);

    // Sofas
    public static final Supplier<BlockItem> WHITE_SOFA = registerBlockItem("white_sofa", ModBlocks.WHITE_SOFA);
    public static final Supplier<BlockItem> LIGHT_GRAY_SOFA = registerBlockItem("light_gray_sofa", ModBlocks.LIGHT_GRAY_SOFA);
    public static final Supplier<BlockItem> GRAY_SOFA = registerBlockItem("gray_sofa", ModBlocks.GRAY_SOFA);
    public static final Supplier<BlockItem> BLACK_SOFA = registerBlockItem("black_sofa", ModBlocks.BLACK_SOFA);
    public static final Supplier<BlockItem> BROWN_SOFA = registerBlockItem("brown_sofa", ModBlocks.BROWN_SOFA);
    public static final Supplier<BlockItem> RED_SOFA = registerBlockItem("red_sofa", ModBlocks.RED_SOFA);
    public static final Supplier<BlockItem> ORANGE_SOFA = registerBlockItem("orange_sofa", ModBlocks.ORANGE_SOFA);
    public static final Supplier<BlockItem> BEIGE_SOFA = registerOptionalBlockItem("beige_sofa", ModBlocks.BEIGE_SOFA);
    public static final Supplier<BlockItem> YELLOW_SOFA = registerBlockItem("yellow_sofa", ModBlocks.YELLOW_SOFA);
    public static final Supplier<BlockItem> LIME_SOFA = registerBlockItem("lime_sofa", ModBlocks.LIME_SOFA);
    public static final Supplier<BlockItem> GREEN_SOFA = registerBlockItem("green_sofa", ModBlocks.GREEN_SOFA);
    public static final Supplier<BlockItem> CYAN_SOFA = registerBlockItem("cyan_sofa", ModBlocks.CYAN_SOFA);
    public static final Supplier<BlockItem> LIGHT_BLUE_SOFA = registerBlockItem("light_blue_sofa", ModBlocks.LIGHT_BLUE_SOFA);
    public static final Supplier<BlockItem> BLUE_SOFA = registerBlockItem("blue_sofa", ModBlocks.BLUE_SOFA);
    public static final Supplier<BlockItem> PURPLE_SOFA = registerBlockItem("purple_sofa", ModBlocks.PURPLE_SOFA);
    public static final Supplier<BlockItem> MAGENTA_SOFA = registerBlockItem("magenta_sofa", ModBlocks.MAGENTA_SOFA);
    public static final Supplier<BlockItem> PINK_SOFA = registerBlockItem("pink_sofa", ModBlocks.PINK_SOFA);
    public static final Supplier<BlockItem> RAINBOW_SOFA = registerBlockItem("rainbow_sofa", ModBlocks.RAINBOW_SOFA);

    // Blinds
    public static final Supplier<BlockItem> OAK_BLINDS = registerBlockItem("oak_blinds", ModBlocks.OAK_BLINDS);
    public static final Supplier<BlockItem> SPRUCE_BLINDS = registerBlockItem("spruce_blinds", ModBlocks.SPRUCE_BLINDS);
    public static final Supplier<BlockItem> BIRCH_BLINDS = registerBlockItem("birch_blinds", ModBlocks.BIRCH_BLINDS);
    public static final Supplier<BlockItem> JUNGLE_BLINDS = registerBlockItem("jungle_blinds", ModBlocks.JUNGLE_BLINDS);
    public static final Supplier<BlockItem> ACACIA_BLINDS = registerBlockItem("acacia_blinds", ModBlocks.ACACIA_BLINDS);
    public static final Supplier<BlockItem> DARK_OAK_BLINDS = registerBlockItem("dark_oak_blinds", ModBlocks.DARK_OAK_BLINDS);
    public static final Supplier<BlockItem> MANGROVE_BLINDS = registerBlockItem("mangrove_blinds", ModBlocks.MANGROVE_BLINDS);
    public static final Supplier<BlockItem> CHERRY_BLINDS = registerBlockItem("cherry_blinds", ModBlocks.CHERRY_BLINDS);
    public static final Supplier<BlockItem> CRIMSON_BLINDS = registerBlockItem("crimson_blinds", ModBlocks.CRIMSON_BLINDS);
    public static final Supplier<BlockItem> WARPED_BLINDS = registerBlockItem("warped_blinds", ModBlocks.WARPED_BLINDS);
    public static final Supplier<BlockItem> BAMBOO_BLINDS = registerBlockItem("bamboo_blinds", ModBlocks.BAMBOO_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_OAK_BLINDS = registerBlockItem("stripped_oak_blinds", ModBlocks.STRIPPED_OAK_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_BLINDS = registerBlockItem("stripped_spruce_blinds", ModBlocks.STRIPPED_SPRUCE_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_BLINDS = registerBlockItem("stripped_birch_blinds", ModBlocks.STRIPPED_BIRCH_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_BLINDS = registerBlockItem("stripped_jungle_blinds", ModBlocks.STRIPPED_JUNGLE_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_BLINDS = registerBlockItem("stripped_acacia_blinds", ModBlocks.STRIPPED_ACACIA_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_BLINDS = registerBlockItem("stripped_dark_oak_blinds", ModBlocks.STRIPPED_DARK_OAK_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_BLINDS = registerBlockItem("stripped_mangrove_blinds", ModBlocks.STRIPPED_MANGROVE_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_BLINDS = registerBlockItem("stripped_cherry_blinds", ModBlocks.STRIPPED_CHERRY_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_BLINDS = registerBlockItem("stripped_crimson_blinds", ModBlocks.STRIPPED_CRIMSON_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_WARPED_BLINDS = registerBlockItem("stripped_warped_blinds", ModBlocks.STRIPPED_WARPED_BLINDS);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_BLINDS = registerBlockItem("stripped_bamboo_blinds", ModBlocks.STRIPPED_BAMBOO_BLINDS);

    // Upgraded Fences
    public static final Supplier<BlockItem> OAK_UPGRADED_FENCE = registerBlockItem("oak_upgraded_fence", ModBlocks.OAK_UPGRADED_FENCE);
    public static final Supplier<BlockItem> SPRUCE_UPGRADED_FENCE = registerBlockItem("spruce_upgraded_fence", ModBlocks.SPRUCE_UPGRADED_FENCE);
    public static final Supplier<BlockItem> BIRCH_UPGRADED_FENCE = registerBlockItem("birch_upgraded_fence", ModBlocks.BIRCH_UPGRADED_FENCE);
    public static final Supplier<BlockItem> JUNGLE_UPGRADED_FENCE = registerBlockItem("jungle_upgraded_fence", ModBlocks.JUNGLE_UPGRADED_FENCE);
    public static final Supplier<BlockItem> ACACIA_UPGRADED_FENCE = registerBlockItem("acacia_upgraded_fence", ModBlocks.ACACIA_UPGRADED_FENCE);
    public static final Supplier<BlockItem> DARK_OAK_UPGRADED_FENCE = registerBlockItem("dark_oak_upgraded_fence", ModBlocks.DARK_OAK_UPGRADED_FENCE);
    public static final Supplier<BlockItem> MANGROVE_UPGRADED_FENCE = registerBlockItem("mangrove_upgraded_fence", ModBlocks.MANGROVE_UPGRADED_FENCE);
    public static final Supplier<BlockItem> CHERRY_UPGRADED_FENCE = registerBlockItem("cherry_upgraded_fence", ModBlocks.CHERRY_UPGRADED_FENCE);
    public static final Supplier<BlockItem> CRIMSON_UPGRADED_FENCE = registerBlockItem("crimson_upgraded_fence", ModBlocks.CRIMSON_UPGRADED_FENCE);
    public static final Supplier<BlockItem> WARPED_UPGRADED_FENCE = registerBlockItem("warped_upgraded_fence", ModBlocks.WARPED_UPGRADED_FENCE);
    public static final Supplier<BlockItem> BAMBOO_UPGRADED_FENCE = registerBlockItem("bamboo_upgraded_fence", ModBlocks.BAMBOO_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_OAK_UPGRADED_FENCE = registerBlockItem("stripped_oak_upgraded_fence", ModBlocks.STRIPPED_OAK_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_UPGRADED_FENCE = registerBlockItem("stripped_spruce_upgraded_fence", ModBlocks.STRIPPED_SPRUCE_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_UPGRADED_FENCE = registerBlockItem("stripped_birch_upgraded_fence", ModBlocks.STRIPPED_BIRCH_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_UPGRADED_FENCE = registerBlockItem("stripped_jungle_upgraded_fence", ModBlocks.STRIPPED_JUNGLE_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_UPGRADED_FENCE = registerBlockItem("stripped_acacia_upgraded_fence", ModBlocks.STRIPPED_ACACIA_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_UPGRADED_FENCE = registerBlockItem("stripped_dark_oak_upgraded_fence", ModBlocks.STRIPPED_DARK_OAK_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_UPGRADED_FENCE = registerBlockItem("stripped_mangrove_upgraded_fence", ModBlocks.STRIPPED_MANGROVE_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_UPGRADED_FENCE = registerBlockItem("stripped_cherry_upgraded_fence", ModBlocks.STRIPPED_CHERRY_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_UPGRADED_FENCE = registerBlockItem("stripped_crimson_upgraded_fence", ModBlocks.STRIPPED_CRIMSON_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_WARPED_UPGRADED_FENCE = registerBlockItem("stripped_warped_upgraded_fence", ModBlocks.STRIPPED_WARPED_UPGRADED_FENCE);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_UPGRADED_FENCE = registerBlockItem("stripped_bamboo_upgraded_fence", ModBlocks.STRIPPED_BAMBOO_UPGRADED_FENCE);

    // Upgraded Gates
    public static final Supplier<BlockItem> OAK_UPGRADED_GATE = registerBlockItem("oak_upgraded_gate", ModBlocks.OAK_UPGRADED_GATE);
    public static final Supplier<BlockItem> SPRUCE_UPGRADED_GATE = registerBlockItem("spruce_upgraded_gate", ModBlocks.SPRUCE_UPGRADED_GATE);
    public static final Supplier<BlockItem> BIRCH_UPGRADED_GATE = registerBlockItem("birch_upgraded_gate", ModBlocks.BIRCH_UPGRADED_GATE);
    public static final Supplier<BlockItem> JUNGLE_UPGRADED_GATE = registerBlockItem("jungle_upgraded_gate", ModBlocks.JUNGLE_UPGRADED_GATE);
    public static final Supplier<BlockItem> ACACIA_UPGRADED_GATE = registerBlockItem("acacia_upgraded_gate", ModBlocks.ACACIA_UPGRADED_GATE);
    public static final Supplier<BlockItem> DARK_OAK_UPGRADED_GATE = registerBlockItem("dark_oak_upgraded_gate", ModBlocks.DARK_OAK_UPGRADED_GATE);
    public static final Supplier<BlockItem> MANGROVE_UPGRADED_GATE = registerBlockItem("mangrove_upgraded_gate", ModBlocks.MANGROVE_UPGRADED_GATE);
    public static final Supplier<BlockItem> CHERRY_UPGRADED_GATE = registerBlockItem("cherry_upgraded_gate", ModBlocks.CHERRY_UPGRADED_GATE);
    public static final Supplier<BlockItem> CRIMSON_UPGRADED_GATE = registerBlockItem("crimson_upgraded_gate", ModBlocks.CRIMSON_UPGRADED_GATE);
    public static final Supplier<BlockItem> WARPED_UPGRADED_GATE = registerBlockItem("warped_upgraded_gate", ModBlocks.WARPED_UPGRADED_GATE);
    public static final Supplier<BlockItem> BAMBOO_UPGRADED_GATE = registerBlockItem("bamboo_upgraded_gate", ModBlocks.BAMBOO_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_OAK_UPGRADED_GATE = registerBlockItem("stripped_oak_upgraded_gate", ModBlocks.STRIPPED_OAK_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_UPGRADED_GATE = registerBlockItem("stripped_spruce_upgraded_gate", ModBlocks.STRIPPED_SPRUCE_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_UPGRADED_GATE = registerBlockItem("stripped_birch_upgraded_gate", ModBlocks.STRIPPED_BIRCH_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_UPGRADED_GATE = registerBlockItem("stripped_jungle_upgraded_gate", ModBlocks.STRIPPED_JUNGLE_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_UPGRADED_GATE = registerBlockItem("stripped_acacia_upgraded_gate", ModBlocks.STRIPPED_ACACIA_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_UPGRADED_GATE = registerBlockItem("stripped_dark_oak_upgraded_gate", ModBlocks.STRIPPED_DARK_OAK_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_UPGRADED_GATE = registerBlockItem("stripped_mangrove_upgraded_gate", ModBlocks.STRIPPED_MANGROVE_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_UPGRADED_GATE = registerBlockItem("stripped_cherry_upgraded_gate", ModBlocks.STRIPPED_CHERRY_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_UPGRADED_GATE = registerBlockItem("stripped_crimson_upgraded_gate", ModBlocks.STRIPPED_CRIMSON_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_WARPED_UPGRADED_GATE = registerBlockItem("stripped_warped_upgraded_gate", ModBlocks.STRIPPED_WARPED_UPGRADED_GATE);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_UPGRADED_GATE = registerBlockItem("stripped_bamboo_upgraded_gate", ModBlocks.STRIPPED_BAMBOO_UPGRADED_GATE);

    // Picket Fences
    public static final Supplier<BlockItem> WHITE_PICKET_FENCE = registerBlockItem("white_picket_fence", ModBlocks.WHITE_PICKET_FENCE);
    public static final Supplier<BlockItem> LIGHT_GRAY_PICKET_FENCE = registerBlockItem("light_gray_picket_fence", ModBlocks.LIGHT_GRAY_PICKET_FENCE);
    public static final Supplier<BlockItem> GRAY_PICKET_FENCE = registerBlockItem("gray_picket_fence", ModBlocks.GRAY_PICKET_FENCE);
    public static final Supplier<BlockItem> BLACK_PICKET_FENCE = registerBlockItem("black_picket_fence", ModBlocks.BLACK_PICKET_FENCE);
    public static final Supplier<BlockItem> BROWN_PICKET_FENCE = registerBlockItem("brown_picket_fence", ModBlocks.BROWN_PICKET_FENCE);
    public static final Supplier<BlockItem> RED_PICKET_FENCE = registerBlockItem("red_picket_fence", ModBlocks.RED_PICKET_FENCE);
    public static final Supplier<BlockItem> ORANGE_PICKET_FENCE = registerBlockItem("orange_picket_fence", ModBlocks.ORANGE_PICKET_FENCE);
    public static final Supplier<BlockItem> BEIGE_PICKET_FENCE = registerOptionalBlockItem("beige_picket_fence", ModBlocks.BEIGE_PICKET_FENCE);
    public static final Supplier<BlockItem> YELLOW_PICKET_FENCE = registerBlockItem("yellow_picket_fence", ModBlocks.YELLOW_PICKET_FENCE);
    public static final Supplier<BlockItem> LIME_PICKET_FENCE = registerBlockItem("lime_picket_fence", ModBlocks.LIME_PICKET_FENCE);
    public static final Supplier<BlockItem> GREEN_PICKET_FENCE = registerBlockItem("green_picket_fence", ModBlocks.GREEN_PICKET_FENCE);
    public static final Supplier<BlockItem> CYAN_PICKET_FENCE = registerBlockItem("cyan_picket_fence", ModBlocks.CYAN_PICKET_FENCE);
    public static final Supplier<BlockItem> LIGHT_BLUE_PICKET_FENCE = registerBlockItem("light_blue_picket_fence", ModBlocks.LIGHT_BLUE_PICKET_FENCE);
    public static final Supplier<BlockItem> BLUE_PICKET_FENCE = registerBlockItem("blue_picket_fence", ModBlocks.BLUE_PICKET_FENCE);
    public static final Supplier<BlockItem> PURPLE_PICKET_FENCE = registerBlockItem("purple_picket_fence", ModBlocks.PURPLE_PICKET_FENCE);
    public static final Supplier<BlockItem> MAGENTA_PICKET_FENCE = registerBlockItem("magenta_picket_fence", ModBlocks.MAGENTA_PICKET_FENCE);
    public static final Supplier<BlockItem> PINK_PICKET_FENCE = registerBlockItem("pink_picket_fence", ModBlocks.PINK_PICKET_FENCE);

    // Picket Gates
    public static final Supplier<BlockItem> WHITE_PICKET_GATE = registerBlockItem("white_picket_gate", ModBlocks.WHITE_PICKET_GATE);
    public static final Supplier<BlockItem> LIGHT_GRAY_PICKET_GATE = registerBlockItem("light_gray_picket_gate", ModBlocks.LIGHT_GRAY_PICKET_GATE);
    public static final Supplier<BlockItem> GRAY_PICKET_GATE = registerBlockItem("gray_picket_gate", ModBlocks.GRAY_PICKET_GATE);
    public static final Supplier<BlockItem> BLACK_PICKET_GATE = registerBlockItem("black_picket_gate", ModBlocks.BLACK_PICKET_GATE);
    public static final Supplier<BlockItem> BROWN_PICKET_GATE = registerBlockItem("brown_picket_gate", ModBlocks.BROWN_PICKET_GATE);
    public static final Supplier<BlockItem> RED_PICKET_GATE = registerBlockItem("red_picket_gate", ModBlocks.RED_PICKET_GATE);
    public static final Supplier<BlockItem> ORANGE_PICKET_GATE = registerBlockItem("orange_picket_gate", ModBlocks.ORANGE_PICKET_GATE);
    public static final Supplier<BlockItem> BEIGE_PICKET_GATE = registerOptionalBlockItem("beige_picket_gate", ModBlocks.BEIGE_PICKET_GATE);
    public static final Supplier<BlockItem> YELLOW_PICKET_GATE = registerBlockItem("yellow_picket_gate", ModBlocks.YELLOW_PICKET_GATE);
    public static final Supplier<BlockItem> LIME_PICKET_GATE = registerBlockItem("lime_picket_gate", ModBlocks.LIME_PICKET_GATE);
    public static final Supplier<BlockItem> GREEN_PICKET_GATE = registerBlockItem("green_picket_gate", ModBlocks.GREEN_PICKET_GATE);
    public static final Supplier<BlockItem> CYAN_PICKET_GATE = registerBlockItem("cyan_picket_gate", ModBlocks.CYAN_PICKET_GATE);
    public static final Supplier<BlockItem> LIGHT_BLUE_PICKET_GATE = registerBlockItem("light_blue_picket_gate", ModBlocks.LIGHT_BLUE_PICKET_GATE);
    public static final Supplier<BlockItem> BLUE_PICKET_GATE = registerBlockItem("blue_picket_gate", ModBlocks.BLUE_PICKET_GATE);
    public static final Supplier<BlockItem> PURPLE_PICKET_GATE = registerBlockItem("purple_picket_gate", ModBlocks.PURPLE_PICKET_GATE);
    public static final Supplier<BlockItem> MAGENTA_PICKET_GATE = registerBlockItem("magenta_picket_gate", ModBlocks.MAGENTA_PICKET_GATE);
    public static final Supplier<BlockItem> PINK_PICKET_GATE = registerBlockItem("pink_picket_gate", ModBlocks.PINK_PICKET_GATE);

    // Crates
    public static final Supplier<BlockItem> OAK_CRATE = registerBlockItem("oak_crate", ModBlocks.OAK_CRATE);
    public static final Supplier<BlockItem> SPRUCE_CRATE = registerBlockItem("spruce_crate", ModBlocks.SPRUCE_CRATE);
    public static final Supplier<BlockItem> BIRCH_CRATE = registerBlockItem("birch_crate", ModBlocks.BIRCH_CRATE);
    public static final Supplier<BlockItem> JUNGLE_CRATE = registerBlockItem("jungle_crate", ModBlocks.JUNGLE_CRATE);
    public static final Supplier<BlockItem> ACACIA_CRATE = registerBlockItem("acacia_crate", ModBlocks.ACACIA_CRATE);
    public static final Supplier<BlockItem> DARK_OAK_CRATE = registerBlockItem("dark_oak_crate", ModBlocks.DARK_OAK_CRATE);
    public static final Supplier<BlockItem> MANGROVE_CRATE = registerBlockItem("mangrove_crate", ModBlocks.MANGROVE_CRATE);
    public static final Supplier<BlockItem> CHERRY_CRATE = registerBlockItem("cherry_crate", ModBlocks.CHERRY_CRATE);
    public static final Supplier<BlockItem> CRIMSON_CRATE = registerBlockItem("crimson_crate", ModBlocks.CRIMSON_CRATE);
    public static final Supplier<BlockItem> WARPED_CRATE = registerBlockItem("warped_crate", ModBlocks.WARPED_CRATE);
    public static final Supplier<BlockItem> BAMBOO_CRATE = registerBlockItem("bamboo_crate", ModBlocks.BAMBOO_CRATE);
    public static final Supplier<BlockItem> STRIPPED_OAK_CRATE = registerBlockItem("stripped_oak_crate", ModBlocks.STRIPPED_OAK_CRATE);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_CRATE = registerBlockItem("stripped_spruce_crate", ModBlocks.STRIPPED_SPRUCE_CRATE);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_CRATE = registerBlockItem("stripped_birch_crate", ModBlocks.STRIPPED_BIRCH_CRATE);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_CRATE = registerBlockItem("stripped_jungle_crate", ModBlocks.STRIPPED_JUNGLE_CRATE);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_CRATE = registerBlockItem("stripped_acacia_crate", ModBlocks.STRIPPED_ACACIA_CRATE);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_CRATE = registerBlockItem("stripped_dark_oak_crate", ModBlocks.STRIPPED_DARK_OAK_CRATE);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_CRATE = registerBlockItem("stripped_mangrove_crate", ModBlocks.STRIPPED_MANGROVE_CRATE);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_CRATE = registerBlockItem("stripped_cherry_crate", ModBlocks.STRIPPED_CHERRY_CRATE);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_CRATE = registerBlockItem("stripped_crimson_crate", ModBlocks.STRIPPED_CRIMSON_CRATE);
    public static final Supplier<BlockItem> STRIPPED_WARPED_CRATE = registerBlockItem("stripped_warped_crate", ModBlocks.STRIPPED_WARPED_CRATE);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_CRATE = registerBlockItem("stripped_bamboo_crate", ModBlocks.STRIPPED_BAMBOO_CRATE);

    // Park Benches
    public static final Supplier<BlockItem> OAK_PARK_BENCH = registerBlockItem("oak_park_bench", ModBlocks.OAK_PARK_BENCH);
    public static final Supplier<BlockItem> SPRUCE_PARK_BENCH = registerBlockItem("spruce_park_bench", ModBlocks.SPRUCE_PARK_BENCH);
    public static final Supplier<BlockItem> BIRCH_PARK_BENCH = registerBlockItem("birch_park_bench", ModBlocks.BIRCH_PARK_BENCH);
    public static final Supplier<BlockItem> JUNGLE_PARK_BENCH = registerBlockItem("jungle_park_bench", ModBlocks.JUNGLE_PARK_BENCH);
    public static final Supplier<BlockItem> ACACIA_PARK_BENCH = registerBlockItem("acacia_park_bench", ModBlocks.ACACIA_PARK_BENCH);
    public static final Supplier<BlockItem> DARK_OAK_PARK_BENCH = registerBlockItem("dark_oak_park_bench", ModBlocks.DARK_OAK_PARK_BENCH);
    public static final Supplier<BlockItem> MANGROVE_PARK_BENCH = registerBlockItem("mangrove_park_bench", ModBlocks.MANGROVE_PARK_BENCH);
    public static final Supplier<BlockItem> CHERRY_PARK_BENCH = registerBlockItem("cherry_park_bench", ModBlocks.CHERRY_PARK_BENCH);
    public static final Supplier<BlockItem> CRIMSON_PARK_BENCH = registerBlockItem("crimson_park_bench", ModBlocks.CRIMSON_PARK_BENCH);
    public static final Supplier<BlockItem> WARPED_PARK_BENCH = registerBlockItem("warped_park_bench", ModBlocks.WARPED_PARK_BENCH);
    public static final Supplier<BlockItem> BAMBOO_PARK_BENCH = registerBlockItem("bamboo_park_bench", ModBlocks.BAMBOO_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_OAK_PARK_BENCH = registerBlockItem("stripped_oak_park_bench", ModBlocks.STRIPPED_OAK_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_PARK_BENCH = registerBlockItem("stripped_spruce_park_bench", ModBlocks.STRIPPED_SPRUCE_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_PARK_BENCH = registerBlockItem("stripped_birch_park_bench", ModBlocks.STRIPPED_BIRCH_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_PARK_BENCH = registerBlockItem("stripped_jungle_park_bench", ModBlocks.STRIPPED_JUNGLE_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_PARK_BENCH = registerBlockItem("stripped_acacia_park_bench", ModBlocks.STRIPPED_ACACIA_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_PARK_BENCH = registerBlockItem("stripped_dark_oak_park_bench", ModBlocks.STRIPPED_DARK_OAK_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_PARK_BENCH = registerBlockItem("stripped_mangrove_park_bench", ModBlocks.STRIPPED_MANGROVE_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_PARK_BENCH = registerBlockItem("stripped_cherry_park_bench", ModBlocks.STRIPPED_CHERRY_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_PARK_BENCH = registerBlockItem("stripped_crimson_park_bench", ModBlocks.STRIPPED_CRIMSON_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_WARPED_PARK_BENCH = registerBlockItem("stripped_warped_park_bench", ModBlocks.STRIPPED_WARPED_PARK_BENCH);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_PARK_BENCH = registerBlockItem("stripped_bamboo_park_bench", ModBlocks.STRIPPED_BAMBOO_PARK_BENCH);

    // Post Box
    public static final Supplier<BlockItem> POST_BOX = registerBlockItem("post_box", ModBlocks.POST_BOX);

    // Mail Boxes
    public static final Supplier<BlockItem> OAK_MAIL_BOX = registerBlockItem("oak_mail_box", ModBlocks.OAK_MAIL_BOX);
    public static final Supplier<BlockItem> SPRUCE_MAIL_BOX = registerBlockItem("spruce_mail_box", ModBlocks.SPRUCE_MAIL_BOX);
    public static final Supplier<BlockItem> BIRCH_MAIL_BOX = registerBlockItem("birch_mail_box", ModBlocks.BIRCH_MAIL_BOX);
    public static final Supplier<BlockItem> JUNGLE_MAIL_BOX = registerBlockItem("jungle_mail_box", ModBlocks.JUNGLE_MAIL_BOX);
    public static final Supplier<BlockItem> ACACIA_MAIL_BOX = registerBlockItem("acacia_mail_box", ModBlocks.ACACIA_MAIL_BOX);
    public static final Supplier<BlockItem> DARK_OAK_MAIL_BOX = registerBlockItem("dark_oak_mail_box", ModBlocks.DARK_OAK_MAIL_BOX);
    public static final Supplier<BlockItem> MANGROVE_MAIL_BOX = registerBlockItem("mangrove_mail_box", ModBlocks.MANGROVE_MAIL_BOX);
    public static final Supplier<BlockItem> CHERRY_MAIL_BOX = registerBlockItem("cherry_mail_box", ModBlocks.CHERRY_MAIL_BOX);
    public static final Supplier<BlockItem> CRIMSON_MAIL_BOX = registerBlockItem("crimson_mail_box", ModBlocks.CRIMSON_MAIL_BOX);
    public static final Supplier<BlockItem> WARPED_MAIL_BOX = registerBlockItem("warped_mail_box", ModBlocks.WARPED_MAIL_BOX);
    public static final Supplier<BlockItem> BAMBOO_MAIL_BOX = registerBlockItem("bamboo_mail_box", ModBlocks.BAMBOO_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_OAK_MAIL_BOX = registerBlockItem("stripped_oak_mail_box", ModBlocks.STRIPPED_OAK_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_MAIL_BOX = registerBlockItem("stripped_spruce_mail_box", ModBlocks.STRIPPED_SPRUCE_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_MAIL_BOX = registerBlockItem("stripped_birch_mail_box", ModBlocks.STRIPPED_BIRCH_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_MAIL_BOX = registerBlockItem("stripped_jungle_mail_box", ModBlocks.STRIPPED_JUNGLE_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_MAIL_BOX = registerBlockItem("stripped_acacia_mail_box", ModBlocks.STRIPPED_ACACIA_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_MAIL_BOX = registerBlockItem("stripped_dark_oak_mail_box", ModBlocks.STRIPPED_DARK_OAK_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_MAIL_BOX = registerBlockItem("stripped_mangrove_mail_box", ModBlocks.STRIPPED_MANGROVE_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_MAIL_BOX = registerBlockItem("stripped_cherry_mail_box", ModBlocks.STRIPPED_CHERRY_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_MAIL_BOX = registerBlockItem("stripped_crimson_mail_box", ModBlocks.STRIPPED_CRIMSON_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_WARPED_MAIL_BOX = registerBlockItem("stripped_warped_mail_box", ModBlocks.STRIPPED_WARPED_MAIL_BOX);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_MAIL_BOX = registerBlockItem("stripped_bamboo_mail_box", ModBlocks.STRIPPED_BAMBOO_MAIL_BOX);

    // Hedges
    public static final Supplier<BlockItem> OAK_HEDGE = registerBlockItem("oak_hedge", ModBlocks.OAK_HEDGE);
    public static final Supplier<BlockItem> SPRUCE_HEDGE = registerBlockItem("spruce_hedge", ModBlocks.SPRUCE_HEDGE);
    public static final Supplier<BlockItem> BIRCH_HEDGE = registerBlockItem("birch_hedge", ModBlocks.BIRCH_HEDGE);
    public static final Supplier<BlockItem> JUNGLE_HEDGE = registerBlockItem("jungle_hedge", ModBlocks.JUNGLE_HEDGE);
    public static final Supplier<BlockItem> ACACIA_HEDGE = registerBlockItem("acacia_hedge", ModBlocks.ACACIA_HEDGE);
    public static final Supplier<BlockItem> DARK_OAK_HEDGE = registerBlockItem("dark_oak_hedge", ModBlocks.DARK_OAK_HEDGE);
    public static final Supplier<BlockItem> MANGROVE_HEDGE = registerBlockItem("mangrove_hedge", ModBlocks.MANGROVE_HEDGE);
    public static final Supplier<BlockItem> CHERRY_HEDGE = registerBlockItem("cherry_hedge", ModBlocks.CHERRY_HEDGE);
    public static final Supplier<BlockItem> AZALEA_HEDGE = registerBlockItem("azalea_hedge", ModBlocks.AZALEA_HEDGE);
    public static final Supplier<BlockItem> FLOWERING_AZALEA_HEDGE = registerBlockItem("flowering_azalea_hedge", ModBlocks.FLOWERING_AZALEA_HEDGE);

    // Rock Path
    public static final Supplier<BlockItem> ROCK_PATH = registerBlockItem("rock_path", ModBlocks.ROCK_PATH);

    // Trampolines
    public static final Supplier<BlockItem> WHITE_TRAMPOLINE = registerBlockItem("white_trampoline", ModBlocks.WHITE_TRAMPOLINE);
    public static final Supplier<BlockItem> LIGHT_GRAY_TRAMPOLINE = registerBlockItem("light_gray_trampoline", ModBlocks.LIGHT_GRAY_TRAMPOLINE);
    public static final Supplier<BlockItem> GRAY_TRAMPOLINE = registerBlockItem("gray_trampoline", ModBlocks.GRAY_TRAMPOLINE);
    public static final Supplier<BlockItem> BLACK_TRAMPOLINE = registerBlockItem("black_trampoline", ModBlocks.BLACK_TRAMPOLINE);
    public static final Supplier<BlockItem> BROWN_TRAMPOLINE = registerBlockItem("brown_trampoline", ModBlocks.BROWN_TRAMPOLINE);
    public static final Supplier<BlockItem> RED_TRAMPOLINE = registerBlockItem("red_trampoline", ModBlocks.RED_TRAMPOLINE);
    public static final Supplier<BlockItem> ORANGE_TRAMPOLINE = registerBlockItem("orange_trampoline", ModBlocks.ORANGE_TRAMPOLINE);
    public static final Supplier<BlockItem> BEIGE_TRAMPOLINE = registerOptionalBlockItem("beige_trampoline", ModBlocks.BEIGE_TRAMPOLINE);
    public static final Supplier<BlockItem> YELLOW_TRAMPOLINE = registerBlockItem("yellow_trampoline", ModBlocks.YELLOW_TRAMPOLINE);
    public static final Supplier<BlockItem> LIME_TRAMPOLINE = registerBlockItem("lime_trampoline", ModBlocks.LIME_TRAMPOLINE);
    public static final Supplier<BlockItem> GREEN_TRAMPOLINE = registerBlockItem("green_trampoline", ModBlocks.GREEN_TRAMPOLINE);
    public static final Supplier<BlockItem> CYAN_TRAMPOLINE = registerBlockItem("cyan_trampoline", ModBlocks.CYAN_TRAMPOLINE);
    public static final Supplier<BlockItem> LIGHT_BLUE_TRAMPOLINE = registerBlockItem("light_blue_trampoline", ModBlocks.LIGHT_BLUE_TRAMPOLINE);
    public static final Supplier<BlockItem> BLUE_TRAMPOLINE = registerBlockItem("blue_trampoline", ModBlocks.BLUE_TRAMPOLINE);
    public static final Supplier<BlockItem> PURPLE_TRAMPOLINE = registerBlockItem("purple_trampoline", ModBlocks.PURPLE_TRAMPOLINE);
    public static final Supplier<BlockItem> MAGENTA_TRAMPOLINE = registerBlockItem("magenta_trampoline", ModBlocks.MAGENTA_TRAMPOLINE);
    public static final Supplier<BlockItem> PINK_TRAMPOLINE = registerBlockItem("pink_trampoline", ModBlocks.PINK_TRAMPOLINE);

    // Coolers
    public static final Supplier<BlockItem> WHITE_COOLER = registerBlockItem("white_cooler", ModBlocks.WHITE_COOLER);
    public static final Supplier<BlockItem> LIGHT_GRAY_COOLER = registerBlockItem("light_gray_cooler", ModBlocks.LIGHT_GRAY_COOLER);
    public static final Supplier<BlockItem> GRAY_COOLER = registerBlockItem("gray_cooler", ModBlocks.GRAY_COOLER);
    public static final Supplier<BlockItem> BLACK_COOLER = registerBlockItem("black_cooler", ModBlocks.BLACK_COOLER);
    public static final Supplier<BlockItem> BROWN_COOLER = registerBlockItem("brown_cooler", ModBlocks.BROWN_COOLER);
    public static final Supplier<BlockItem> RED_COOLER = registerBlockItem("red_cooler", ModBlocks.RED_COOLER);
    public static final Supplier<BlockItem> ORANGE_COOLER = registerBlockItem("orange_cooler", ModBlocks.ORANGE_COOLER);
    public static final Supplier<BlockItem> BEIGE_COOLER = registerOptionalBlockItem("beige_cooler", ModBlocks.BEIGE_COOLER);
    public static final Supplier<BlockItem> YELLOW_COOLER = registerBlockItem("yellow_cooler", ModBlocks.YELLOW_COOLER);
    public static final Supplier<BlockItem> LIME_COOLER = registerBlockItem("lime_cooler", ModBlocks.LIME_COOLER);
    public static final Supplier<BlockItem> GREEN_COOLER = registerBlockItem("green_cooler", ModBlocks.GREEN_COOLER);
    public static final Supplier<BlockItem> CYAN_COOLER = registerBlockItem("cyan_cooler", ModBlocks.CYAN_COOLER);
    public static final Supplier<BlockItem> LIGHT_BLUE_COOLER = registerBlockItem("light_blue_cooler", ModBlocks.LIGHT_BLUE_COOLER);
    public static final Supplier<BlockItem> BLUE_COOLER = registerBlockItem("blue_cooler", ModBlocks.BLUE_COOLER);
    public static final Supplier<BlockItem> PURPLE_COOLER = registerBlockItem("purple_cooler", ModBlocks.PURPLE_COOLER);
    public static final Supplier<BlockItem> MAGENTA_COOLER = registerBlockItem("magenta_cooler", ModBlocks.MAGENTA_COOLER);
    public static final Supplier<BlockItem> PINK_COOLER = registerBlockItem("pink_cooler", ModBlocks.PINK_COOLER);

    // Grills
    public static final Supplier<BlockItem> WHITE_GRILL = registerBlockItem("white_grill", ModBlocks.WHITE_GRILL);
    public static final Supplier<BlockItem> LIGHT_GRAY_GRILL = registerBlockItem("light_gray_grill", ModBlocks.LIGHT_GRAY_GRILL);
    public static final Supplier<BlockItem> GRAY_GRILL = registerBlockItem("gray_grill", ModBlocks.GRAY_GRILL);
    public static final Supplier<BlockItem> BLACK_GRILL = registerBlockItem("black_grill", ModBlocks.BLACK_GRILL);
    public static final Supplier<BlockItem> BROWN_GRILL = registerBlockItem("brown_grill", ModBlocks.BROWN_GRILL);
    public static final Supplier<BlockItem> RED_GRILL = registerBlockItem("red_grill", ModBlocks.RED_GRILL);
    public static final Supplier<BlockItem> ORANGE_GRILL = registerBlockItem("orange_grill", ModBlocks.ORANGE_GRILL);
    public static final Supplier<BlockItem> BEIGE_GRILL = registerOptionalBlockItem("beige_grill", ModBlocks.BEIGE_GRILL);
    public static final Supplier<BlockItem> YELLOW_GRILL = registerBlockItem("yellow_grill", ModBlocks.YELLOW_GRILL);
    public static final Supplier<BlockItem> LIME_GRILL = registerBlockItem("lime_grill", ModBlocks.LIME_GRILL);
    public static final Supplier<BlockItem> GREEN_GRILL = registerBlockItem("green_grill", ModBlocks.GREEN_GRILL);
    public static final Supplier<BlockItem> CYAN_GRILL = registerBlockItem("cyan_grill", ModBlocks.CYAN_GRILL);
    public static final Supplier<BlockItem> LIGHT_BLUE_GRILL = registerBlockItem("light_blue_grill", ModBlocks.LIGHT_BLUE_GRILL);
    public static final Supplier<BlockItem> BLUE_GRILL = registerBlockItem("blue_grill", ModBlocks.BLUE_GRILL);
    public static final Supplier<BlockItem> PURPLE_GRILL = registerBlockItem("purple_grill", ModBlocks.PURPLE_GRILL);
    public static final Supplier<BlockItem> MAGENTA_GRILL = registerBlockItem("magenta_grill", ModBlocks.MAGENTA_GRILL);
    public static final Supplier<BlockItem> PINK_GRILL = registerBlockItem("pink_grill", ModBlocks.PINK_GRILL);

    // Door Mat
    public static final Supplier<Item> DOOR_MAT = register("door_mat",
            () -> new DoorMatItem(ModBlocks.DOOR_MAT.get(), new Item.Properties()));

    // Diving Board
    public static final Supplier<BlockItem> DIVING_BOARD = registerBlockItem("diving_board", ModBlocks.DIVING_BOARD);

    // Kitchen Counters
    public static final Supplier<BlockItem> OAK_KITCHEN_COUNTER = registerBlockItem("oak_kitchen_counter", ModBlocks.OAK_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> SPRUCE_KITCHEN_COUNTER = registerBlockItem("spruce_kitchen_counter", ModBlocks.SPRUCE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BIRCH_KITCHEN_COUNTER = registerBlockItem("birch_kitchen_counter", ModBlocks.BIRCH_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> JUNGLE_KITCHEN_COUNTER = registerBlockItem("jungle_kitchen_counter", ModBlocks.JUNGLE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> ACACIA_KITCHEN_COUNTER = registerBlockItem("acacia_kitchen_counter", ModBlocks.ACACIA_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> DARK_OAK_KITCHEN_COUNTER = registerBlockItem("dark_oak_kitchen_counter", ModBlocks.DARK_OAK_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> MANGROVE_KITCHEN_COUNTER = registerBlockItem("mangrove_kitchen_counter", ModBlocks.MANGROVE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> CHERRY_KITCHEN_COUNTER = registerBlockItem("cherry_kitchen_counter", ModBlocks.CHERRY_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> CRIMSON_KITCHEN_COUNTER = registerBlockItem("crimson_kitchen_counter", ModBlocks.CRIMSON_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> WARPED_KITCHEN_COUNTER = registerBlockItem("warped_kitchen_counter", ModBlocks.WARPED_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BAMBOO_KITCHEN_COUNTER = registerBlockItem("bamboo_kitchen_counter", ModBlocks.BAMBOO_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_OAK_KITCHEN_COUNTER = registerBlockItem("stripped_oak_kitchen_counter", ModBlocks.STRIPPED_OAK_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_KITCHEN_COUNTER = registerBlockItem("stripped_spruce_kitchen_counter", ModBlocks.STRIPPED_SPRUCE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_KITCHEN_COUNTER = registerBlockItem("stripped_birch_kitchen_counter", ModBlocks.STRIPPED_BIRCH_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_KITCHEN_COUNTER = registerBlockItem("stripped_jungle_kitchen_counter", ModBlocks.STRIPPED_JUNGLE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_KITCHEN_COUNTER = registerBlockItem("stripped_acacia_kitchen_counter", ModBlocks.STRIPPED_ACACIA_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_KITCHEN_COUNTER = registerBlockItem("stripped_dark_oak_kitchen_counter", ModBlocks.STRIPPED_DARK_OAK_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_KITCHEN_COUNTER = registerBlockItem("stripped_mangrove_kitchen_counter", ModBlocks.STRIPPED_MANGROVE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_KITCHEN_COUNTER = registerBlockItem("stripped_cherry_kitchen_counter", ModBlocks.STRIPPED_CHERRY_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_KITCHEN_COUNTER = registerBlockItem("stripped_crimson_kitchen_counter", ModBlocks.STRIPPED_CRIMSON_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_WARPED_KITCHEN_COUNTER = registerBlockItem("stripped_warped_kitchen_counter", ModBlocks.STRIPPED_WARPED_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_KITCHEN_COUNTER = registerBlockItem("stripped_bamboo_kitchen_counter", ModBlocks.STRIPPED_BAMBOO_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> WHITE_KITCHEN_COUNTER = registerBlockItem("white_kitchen_counter", ModBlocks.WHITE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> LIGHT_GRAY_KITCHEN_COUNTER = registerBlockItem("light_gray_kitchen_counter", ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> GRAY_KITCHEN_COUNTER = registerBlockItem("gray_kitchen_counter", ModBlocks.GRAY_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BLACK_KITCHEN_COUNTER = registerBlockItem("black_kitchen_counter", ModBlocks.BLACK_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BROWN_KITCHEN_COUNTER = registerBlockItem("brown_kitchen_counter", ModBlocks.BROWN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> RED_KITCHEN_COUNTER = registerBlockItem("red_kitchen_counter", ModBlocks.RED_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> ORANGE_KITCHEN_COUNTER = registerBlockItem("orange_kitchen_counter", ModBlocks.ORANGE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BEIGE_KITCHEN_COUNTER = registerOptionalBlockItem("beige_kitchen_counter", ModBlocks.BEIGE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> YELLOW_KITCHEN_COUNTER = registerBlockItem("yellow_kitchen_counter", ModBlocks.YELLOW_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> LIME_KITCHEN_COUNTER = registerBlockItem("lime_kitchen_counter", ModBlocks.LIME_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> GREEN_KITCHEN_COUNTER = registerBlockItem("green_kitchen_counter", ModBlocks.GREEN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> CYAN_KITCHEN_COUNTER = registerBlockItem("cyan_kitchen_counter", ModBlocks.CYAN_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> LIGHT_BLUE_KITCHEN_COUNTER = registerBlockItem("light_blue_kitchen_counter", ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> BLUE_KITCHEN_COUNTER = registerBlockItem("blue_kitchen_counter", ModBlocks.BLUE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> PURPLE_KITCHEN_COUNTER = registerBlockItem("purple_kitchen_counter", ModBlocks.PURPLE_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> MAGENTA_KITCHEN_COUNTER = registerBlockItem("magenta_kitchen_counter", ModBlocks.MAGENTA_KITCHEN_COUNTER);
    public static final Supplier<BlockItem> PINK_KITCHEN_COUNTER = registerBlockItem("pink_kitchen_counter", ModBlocks.PINK_KITCHEN_COUNTER);

    // Kitchen Drawers
    public static final Supplier<BlockItem> OAK_KITCHEN_DRAWER = registerBlockItem("oak_kitchen_drawer", ModBlocks.OAK_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> SPRUCE_KITCHEN_DRAWER = registerBlockItem("spruce_kitchen_drawer", ModBlocks.SPRUCE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BIRCH_KITCHEN_DRAWER = registerBlockItem("birch_kitchen_drawer", ModBlocks.BIRCH_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> JUNGLE_KITCHEN_DRAWER = registerBlockItem("jungle_kitchen_drawer", ModBlocks.JUNGLE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> ACACIA_KITCHEN_DRAWER = registerBlockItem("acacia_kitchen_drawer", ModBlocks.ACACIA_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> DARK_OAK_KITCHEN_DRAWER = registerBlockItem("dark_oak_kitchen_drawer", ModBlocks.DARK_OAK_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> MANGROVE_KITCHEN_DRAWER = registerBlockItem("mangrove_kitchen_drawer", ModBlocks.MANGROVE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> CHERRY_KITCHEN_DRAWER = registerBlockItem("cherry_kitchen_drawer", ModBlocks.CHERRY_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> CRIMSON_KITCHEN_DRAWER = registerBlockItem("crimson_kitchen_drawer", ModBlocks.CRIMSON_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> WARPED_KITCHEN_DRAWER = registerBlockItem("warped_kitchen_drawer", ModBlocks.WARPED_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BAMBOO_KITCHEN_DRAWER = registerBlockItem("bamboo_kitchen_drawer", ModBlocks.BAMBOO_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_OAK_KITCHEN_DRAWER = registerBlockItem("stripped_oak_kitchen_drawer", ModBlocks.STRIPPED_OAK_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_KITCHEN_DRAWER = registerBlockItem("stripped_spruce_kitchen_drawer", ModBlocks.STRIPPED_SPRUCE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_KITCHEN_DRAWER = registerBlockItem("stripped_birch_kitchen_drawer", ModBlocks.STRIPPED_BIRCH_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_KITCHEN_DRAWER = registerBlockItem("stripped_jungle_kitchen_drawer", ModBlocks.STRIPPED_JUNGLE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_KITCHEN_DRAWER = registerBlockItem("stripped_acacia_kitchen_drawer", ModBlocks.STRIPPED_ACACIA_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_KITCHEN_DRAWER = registerBlockItem("stripped_dark_oak_kitchen_drawer", ModBlocks.STRIPPED_DARK_OAK_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_KITCHEN_DRAWER = registerBlockItem("stripped_mangrove_kitchen_drawer", ModBlocks.STRIPPED_MANGROVE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_KITCHEN_DRAWER = registerBlockItem("stripped_cherry_kitchen_drawer", ModBlocks.STRIPPED_CHERRY_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_KITCHEN_DRAWER = registerBlockItem("stripped_crimson_kitchen_drawer", ModBlocks.STRIPPED_CRIMSON_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_WARPED_KITCHEN_DRAWER = registerBlockItem("stripped_warped_kitchen_drawer", ModBlocks.STRIPPED_WARPED_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_KITCHEN_DRAWER = registerBlockItem("stripped_bamboo_kitchen_drawer", ModBlocks.STRIPPED_BAMBOO_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> WHITE_KITCHEN_DRAWER = registerBlockItem("white_kitchen_drawer", ModBlocks.WHITE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> LIGHT_GRAY_KITCHEN_DRAWER = registerBlockItem("light_gray_kitchen_drawer", ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> GRAY_KITCHEN_DRAWER = registerBlockItem("gray_kitchen_drawer", ModBlocks.GRAY_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BLACK_KITCHEN_DRAWER = registerBlockItem("black_kitchen_drawer", ModBlocks.BLACK_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BROWN_KITCHEN_DRAWER = registerBlockItem("brown_kitchen_drawer", ModBlocks.BROWN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> RED_KITCHEN_DRAWER = registerBlockItem("red_kitchen_drawer", ModBlocks.RED_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> ORANGE_KITCHEN_DRAWER = registerBlockItem("orange_kitchen_drawer", ModBlocks.ORANGE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BEIGE_KITCHEN_DRAWER = registerOptionalBlockItem("beige_kitchen_drawer", ModBlocks.BEIGE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> YELLOW_KITCHEN_DRAWER = registerBlockItem("yellow_kitchen_drawer", ModBlocks.YELLOW_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> LIME_KITCHEN_DRAWER = registerBlockItem("lime_kitchen_drawer", ModBlocks.LIME_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> GREEN_KITCHEN_DRAWER = registerBlockItem("green_kitchen_drawer", ModBlocks.GREEN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> CYAN_KITCHEN_DRAWER = registerBlockItem("cyan_kitchen_drawer", ModBlocks.CYAN_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> LIGHT_BLUE_KITCHEN_DRAWER = registerBlockItem("light_blue_kitchen_drawer", ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> BLUE_KITCHEN_DRAWER = registerBlockItem("blue_kitchen_drawer", ModBlocks.BLUE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> PURPLE_KITCHEN_DRAWER = registerBlockItem("purple_kitchen_drawer", ModBlocks.PURPLE_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> MAGENTA_KITCHEN_DRAWER = registerBlockItem("magenta_kitchen_drawer", ModBlocks.MAGENTA_KITCHEN_DRAWER);
    public static final Supplier<BlockItem> PINK_KITCHEN_DRAWER = registerBlockItem("pink_kitchen_drawer", ModBlocks.PINK_KITCHEN_DRAWER);

    // Kitchen Sinks
    public static final Supplier<BlockItem> OAK_KITCHEN_SINK_LIGHT = registerBlockItem("oak_kitchen_sink_light", ModBlocks.OAK_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> SPRUCE_KITCHEN_SINK_LIGHT = registerBlockItem("spruce_kitchen_sink_light", ModBlocks.SPRUCE_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> BIRCH_KITCHEN_SINK_LIGHT = registerBlockItem("birch_kitchen_sink_light", ModBlocks.BIRCH_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> JUNGLE_KITCHEN_SINK_LIGHT = registerBlockItem("jungle_kitchen_sink_light", ModBlocks.JUNGLE_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> ACACIA_KITCHEN_SINK_LIGHT = registerBlockItem("acacia_kitchen_sink_light", ModBlocks.ACACIA_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> DARK_OAK_KITCHEN_SINK_LIGHT = registerBlockItem("dark_oak_kitchen_sink_light", ModBlocks.DARK_OAK_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> MANGROVE_KITCHEN_SINK_LIGHT = registerBlockItem("mangrove_kitchen_sink_light", ModBlocks.MANGROVE_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> CHERRY_KITCHEN_SINK_LIGHT = registerBlockItem("cherry_kitchen_sink_light", ModBlocks.CHERRY_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> CRIMSON_KITCHEN_SINK_LIGHT = registerBlockItem("crimson_kitchen_sink_light", ModBlocks.CRIMSON_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> WARPED_KITCHEN_SINK_LIGHT = registerBlockItem("warped_kitchen_sink_light", ModBlocks.WARPED_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> BAMBOO_KITCHEN_SINK_LIGHT = registerBlockItem("bamboo_kitchen_sink_light", ModBlocks.BAMBOO_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_OAK_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_oak_kitchen_sink_light", ModBlocks.STRIPPED_OAK_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_spruce_kitchen_sink_light", ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_birch_kitchen_sink_light", ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_jungle_kitchen_sink_light", ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_acacia_kitchen_sink_light", ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_dark_oak_kitchen_sink_light", ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_mangrove_kitchen_sink_light", ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_cherry_kitchen_sink_light", ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_crimson_kitchen_sink_light", ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_WARPED_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_warped_kitchen_sink_light", ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_KITCHEN_SINK_LIGHT = registerBlockItem("stripped_bamboo_kitchen_sink_light", ModBlocks.STRIPPED_BAMBOO_KITCHEN_SINK_LIGHT);
    public static final Supplier<BlockItem> OAK_KITCHEN_SINK_DARK = registerBlockItem("oak_kitchen_sink_dark", ModBlocks.OAK_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> SPRUCE_KITCHEN_SINK_DARK = registerBlockItem("spruce_kitchen_sink_dark", ModBlocks.SPRUCE_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> BIRCH_KITCHEN_SINK_DARK = registerBlockItem("birch_kitchen_sink_dark", ModBlocks.BIRCH_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> JUNGLE_KITCHEN_SINK_DARK = registerBlockItem("jungle_kitchen_sink_dark", ModBlocks.JUNGLE_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> ACACIA_KITCHEN_SINK_DARK = registerBlockItem("acacia_kitchen_sink_dark", ModBlocks.ACACIA_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> DARK_OAK_KITCHEN_SINK_DARK = registerBlockItem("dark_oak_kitchen_sink_dark", ModBlocks.DARK_OAK_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> MANGROVE_KITCHEN_SINK_DARK = registerBlockItem("mangrove_kitchen_sink_dark", ModBlocks.MANGROVE_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> CHERRY_KITCHEN_SINK_DARK = registerBlockItem("cherry_kitchen_sink_dark", ModBlocks.CHERRY_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> CRIMSON_KITCHEN_SINK_DARK = registerBlockItem("crimson_kitchen_sink_dark", ModBlocks.CRIMSON_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> WARPED_KITCHEN_SINK_DARK = registerBlockItem("warped_kitchen_sink_dark", ModBlocks.WARPED_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> BAMBOO_KITCHEN_SINK_DARK = registerBlockItem("bamboo_kitchen_sink_dark", ModBlocks.BAMBOO_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_OAK_KITCHEN_SINK_DARK = registerBlockItem("stripped_oak_kitchen_sink_dark", ModBlocks.STRIPPED_OAK_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_SPRUCE_KITCHEN_SINK_DARK = registerBlockItem("stripped_spruce_kitchen_sink_dark", ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_BIRCH_KITCHEN_SINK_DARK = registerBlockItem("stripped_birch_kitchen_sink_dark", ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_JUNGLE_KITCHEN_SINK_DARK = registerBlockItem("stripped_jungle_kitchen_sink_dark", ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_ACACIA_KITCHEN_SINK_DARK = registerBlockItem("stripped_acacia_kitchen_sink_dark", ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_DARK_OAK_KITCHEN_SINK_DARK = registerBlockItem("stripped_dark_oak_kitchen_sink_dark", ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_MANGROVE_KITCHEN_SINK_DARK = registerBlockItem("stripped_mangrove_kitchen_sink_dark", ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_CHERRY_KITCHEN_SINK_DARK = registerBlockItem("stripped_cherry_kitchen_sink_dark", ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_CRIMSON_KITCHEN_SINK_DARK = registerBlockItem("stripped_crimson_kitchen_sink_dark", ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_WARPED_KITCHEN_SINK_DARK = registerBlockItem("stripped_warped_kitchen_sink_dark", ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> STRIPPED_BAMBOO_KITCHEN_SINK_DARK = registerBlockItem("stripped_bamboo_kitchen_sink_dark", ModBlocks.STRIPPED_BAMBOO_KITCHEN_SINK_DARK);
    public static final Supplier<BlockItem> WHITE_KITCHEN_SINK = registerBlockItem("white_kitchen_sink", ModBlocks.WHITE_KITCHEN_SINK);
    public static final Supplier<BlockItem> LIGHT_GRAY_KITCHEN_SINK = registerBlockItem("light_gray_kitchen_sink", ModBlocks.LIGHT_GRAY_KITCHEN_SINK);
    public static final Supplier<BlockItem> GRAY_KITCHEN_SINK = registerBlockItem("gray_kitchen_sink", ModBlocks.GRAY_KITCHEN_SINK);
    public static final Supplier<BlockItem> BLACK_KITCHEN_SINK = registerBlockItem("black_kitchen_sink", ModBlocks.BLACK_KITCHEN_SINK);
    public static final Supplier<BlockItem> BROWN_KITCHEN_SINK = registerBlockItem("brown_kitchen_sink", ModBlocks.BROWN_KITCHEN_SINK);
    public static final Supplier<BlockItem> RED_KITCHEN_SINK = registerBlockItem("red_kitchen_sink", ModBlocks.RED_KITCHEN_SINK);
    public static final Supplier<BlockItem> ORANGE_KITCHEN_SINK = registerBlockItem("orange_kitchen_sink", ModBlocks.ORANGE_KITCHEN_SINK);
    public static final Supplier<BlockItem> BEIGE_KITCHEN_SINK = registerOptionalBlockItem("beige_kitchen_sink", ModBlocks.BEIGE_KITCHEN_SINK);
    public static final Supplier<BlockItem> YELLOW_KITCHEN_SINK = registerBlockItem("yellow_kitchen_sink", ModBlocks.YELLOW_KITCHEN_SINK);
    public static final Supplier<BlockItem> LIME_KITCHEN_SINK = registerBlockItem("lime_kitchen_sink", ModBlocks.LIME_KITCHEN_SINK);
    public static final Supplier<BlockItem> GREEN_KITCHEN_SINK = registerBlockItem("green_kitchen_sink", ModBlocks.GREEN_KITCHEN_SINK);
    public static final Supplier<BlockItem> CYAN_KITCHEN_SINK = registerBlockItem("cyan_kitchen_sink", ModBlocks.CYAN_KITCHEN_SINK);
    public static final Supplier<BlockItem> LIGHT_BLUE_KITCHEN_SINK = registerBlockItem("light_blue_kitchen_sink", ModBlocks.LIGHT_BLUE_KITCHEN_SINK);
    public static final Supplier<BlockItem> BLUE_KITCHEN_SINK = registerBlockItem("blue_kitchen_sink", ModBlocks.BLUE_KITCHEN_SINK);
    public static final Supplier<BlockItem> PURPLE_KITCHEN_SINK = registerBlockItem("purple_kitchen_sink", ModBlocks.PURPLE_KITCHEN_SINK);
    public static final Supplier<BlockItem> MAGENTA_KITCHEN_SINK = registerBlockItem("magenta_kitchen_sink", ModBlocks.MAGENTA_KITCHEN_SINK);
    public static final Supplier<BlockItem> PINK_KITCHEN_SINK = registerBlockItem("pink_kitchen_sink", ModBlocks.PINK_KITCHEN_SINK);

    // Appliances
    public static final Supplier<Item> FRIDGE_LIGHT = register("fridge_light",
            () -> new FridgeItem(ModBlocks.FRIDGE_LIGHT.get(), ModBlocks.FREEZER_LIGHT.get(), new Item.Properties()));
    public static final Supplier<Item> FRIDGE_DARK = register("fridge_dark",
            () -> new FridgeItem(ModBlocks.FRIDGE_DARK.get(), ModBlocks.FREEZER_DARK.get(), new Item.Properties()));

    // Items
    public static final Supplier<Item> SPATULA = register("spatula",
            () -> new SwordItem(Tiers.IRON, 3, -1.4F, new Item.Properties()));
}