package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.level.block.*;
import com.nosiphus.furniture.platform.Services;
import com.nosiphus.furniture.world.level.fluid.ModFluids;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static void init() {

    }

    private static <T extends Block> Supplier<T> register(String name, Supplier<T> blockSupplier) {
        return Services.REGISTRY.registerBlock(name, blockSupplier);
    }

    // Tables
    public static final Supplier<Block> STONE_TABLE = register("stone_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final Supplier<Block> ANDESITE_TABLE = register("andesite_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final Supplier<Block> DIORITE_TABLE = register("diorite_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> GRANITE_TABLE = register("granite_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> BLACKSTONE_TABLE = register("blackstone_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final Supplier<Block> DEEPSLATE_TABLE = register("deepslate_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Tables
    public static final Supplier<Block> WHITE_MODERN_TABLE = register("white_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_TABLE = register("light_gray_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_MODERN_TABLE = register("gray_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_MODERN_TABLE = register("black_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_MODERN_TABLE = register("brown_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_MODERN_TABLE = register("red_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_MODERN_TABLE = register("orange_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_MODERN_TABLE = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_MODERN_TABLE = register("yellow_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_MODERN_TABLE = register("lime_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_MODERN_TABLE = register("green_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_MODERN_TABLE = register("cyan_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_TABLE = register("light_blue_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_MODERN_TABLE = register("blue_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_MODERN_TABLE = register("purple_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_MODERN_TABLE = register("magenta_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_MODERN_TABLE = register("pink_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Chairs
    public static final Supplier<Block> STONE_CHAIR = register("stone_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final Supplier<Block> ANDESITE_CHAIR = register("andesite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final Supplier<Block> DIORITE_CHAIR = register("diorite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> GRANITE_CHAIR = register("granite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final Supplier<Block> BLACKSTONE_CHAIR = register("blackstone_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final Supplier<Block> DEEPSLATE_CHAIR = register("deepslate_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Chairs
    public static final Supplier<Block> WHITE_MODERN_CHAIR = register("white_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_CHAIR = register("light_gray_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_MODERN_CHAIR = register("gray_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_MODERN_CHAIR = register("black_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_MODERN_CHAIR = register("brown_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_MODERN_CHAIR = register("red_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_MODERN_CHAIR = register("orange_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_MODERN_CHAIR = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_MODERN_CHAIR = register("yellow_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_MODERN_CHAIR = register("lime_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_MODERN_CHAIR = register("green_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_MODERN_CHAIR = register("cyan_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_CHAIR = register("light_blue_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_MODERN_CHAIR = register("blue_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_MODERN_CHAIR = register("purple_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_MODERN_CHAIR = register("magenta_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_MODERN_CHAIR = register("pink_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Coffee Tables
    public static final Supplier<Block> STONE_COFFEE_TABLE = register("stone_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final Supplier<Block> ANDESITE_COFFEE_TABLE = register("andesite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final Supplier<Block> DIORITE_COFFEE_TABLE = register("diorite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> GRANITE_COFFEE_TABLE = register("granite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final Supplier<Block> BLACKSTONE_COFFEE_TABLE = register("blackstone_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final Supplier<Block> DEEPSLATE_COFFEE_TABLE = register("deepslate_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Coffee Tables
    public static final Supplier<Block> WHITE_MODERN_COFFEE_TABLE = register("white_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_COFFEE_TABLE = register("light_gray_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_MODERN_COFFEE_TABLE = register("gray_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_MODERN_COFFEE_TABLE = register("black_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_MODERN_COFFEE_TABLE = register("brown_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_MODERN_COFFEE_TABLE = register("red_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_MODERN_COFFEE_TABLE = register("orange_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_MODERN_COFFEE_TABLE = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_MODERN_COFFEE_TABLE = register("yellow_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_MODERN_COFFEE_TABLE = register("lime_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_MODERN_COFFEE_TABLE = register("green_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_MODERN_COFFEE_TABLE = register("cyan_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_COFFEE_TABLE = register("light_blue_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_MODERN_COFFEE_TABLE = register("blue_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_MODERN_COFFEE_TABLE = register("purple_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_MODERN_COFFEE_TABLE = register("magenta_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_MODERN_COFFEE_TABLE = register("pink_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Cabinets
    public static final Supplier<Block> STONE_CABINET = register("stone_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final Supplier<Block> ANDESITE_CABINET = register("andesite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final Supplier<Block> DIORITE_CABINET = register("diorite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> GRANITE_CABINET = register("granite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final Supplier<Block> BLACKSTONE_CABINET = register("blackstone_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final Supplier<Block> DEEPSLATE_CABINET = register("deepslate_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Cabinets
    public static final Supplier<Block> WHITE_MODERN_CABINET = register("white_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_CABINET = register("light_gray_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_MODERN_CABINET = register("gray_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_MODERN_CABINET = register("black_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_MODERN_CABINET = register("brown_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_MODERN_CABINET = register("red_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_MODERN_CABINET = register("orange_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_MODERN_CABINET = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_MODERN_CABINET = register("yellow_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_MODERN_CABINET = register("lime_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_MODERN_CABINET = register("green_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_MODERN_CABINET = register("cyan_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_CABINET = register("light_blue_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_MODERN_CABINET = register("blue_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_MODERN_CABINET = register("purple_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_MODERN_CABINET = register("magenta_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_MODERN_CABINET = register("pink_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Bedside Cabinets
    public static final Supplier<Block> STONE_BEDSIDE_CABINET = register("stone_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final Supplier<Block> ANDESITE_BEDSIDE_CABINET = register("andesite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final Supplier<Block> DIORITE_BEDSIDE_CABINET = register("diorite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> GRANITE_BEDSIDE_CABINET = register("granite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final Supplier<Block> BLACKSTONE_BEDSIDE_CABINET = register("blackstone_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final Supplier<Block> DEEPSLATE_BEDSIDE_CABINET = register("deepslate_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Bedside Cabinets
    public static final Supplier<Block> WHITE_MODERN_BEDSIDE_CABINET = register("white_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_BEDSIDE_CABINET = register("light_gray_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_MODERN_BEDSIDE_CABINET = register("gray_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_MODERN_BEDSIDE_CABINET = register("black_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_MODERN_BEDSIDE_CABINET = register("brown_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_MODERN_BEDSIDE_CABINET = register("red_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_MODERN_BEDSIDE_CABINET = register("orange_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_MODERN_BEDSIDE_CABINET = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_MODERN_BEDSIDE_CABINET = register("yellow_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_MODERN_BEDSIDE_CABINET = register("lime_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_MODERN_BEDSIDE_CABINET = register("green_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_MODERN_BEDSIDE_CABINET = register("cyan_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_BEDSIDE_CABINET = register("light_blue_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_MODERN_BEDSIDE_CABINET = register("blue_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_MODERN_BEDSIDE_CABINET = register("purple_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_MODERN_BEDSIDE_CABINET = register("magenta_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_MODERN_BEDSIDE_CABINET = register("pink_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Modern Beds
    public static final Supplier<Block> WHITE_MODERN_BED = register("white_modern_bed",
            () -> new ModernBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_BED = register("light_gray_modern_bed",
            () -> new ModernBedBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final Supplier<Block> GRAY_MODERN_BED = register("gray_modern_bed",
            () -> new ModernBedBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final Supplier<Block> BLACK_MODERN_BED = register("black_modern_bed",
            () -> new ModernBedBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final Supplier<Block> BROWN_MODERN_BED = register("brown_modern_bed",
            () -> new ModernBedBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final Supplier<Block> RED_MODERN_BED = register("red_modern_bed",
            () -> new ModernBedBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final Supplier<Block> ORANGE_MODERN_BED = register("orange_modern_bed",
            () -> new ModernBedBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final Supplier<Block> BEIGE_MODERN_BED = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_bed",
            () -> new ModernBedBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL))) : null;
    public static final Supplier<Block> YELLOW_MODERN_BED = register("yellow_modern_bed",
            () -> new ModernBedBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final Supplier<Block> LIME_MODERN_BED = register("lime_modern_bed",
            () -> new ModernBedBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final Supplier<Block> GREEN_MODERN_BED = register("green_modern_bed",
            () -> new ModernBedBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final Supplier<Block> CYAN_MODERN_BED = register("cyan_modern_bed",
            () -> new ModernBedBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_BED = register("light_blue_modern_bed",
            () -> new ModernBedBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final Supplier<Block> BLUE_MODERN_BED = register("blue_modern_bed",
            () -> new ModernBedBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final Supplier<Block> PURPLE_MODERN_BED = register("purple_modern_bed",
            () -> new ModernBedBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final Supplier<Block> MAGENTA_MODERN_BED = register("magenta_modern_bed",
            () -> new ModernBedBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final Supplier<Block> PINK_MODERN_BED = register("pink_modern_bed",
            () -> new ModernBedBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));

    // Curtains
    public static final Supplier<Block> WHITE_CURTAIN = register("white_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> LIGHT_GRAY_CURTAIN = register("light_gray_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final Supplier<Block> GRAY_CURTAIN = register("gray_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final Supplier<Block> BLACK_CURTAIN = register("black_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final Supplier<Block> BROWN_CURTAIN = register("brown_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final Supplier<Block> RED_CURTAIN = register("red_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final Supplier<Block> ORANGE_CURTAIN = register("orange_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final Supplier<Block> BEIGE_CURTAIN = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL))) : null;
    public static final Supplier<Block> YELLOW_CURTAIN = register("yellow_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final Supplier<Block> LIME_CURTAIN = register("lime_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final Supplier<Block> GREEN_CURTAIN = register("green_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final Supplier<Block> CYAN_CURTAIN = register("cyan_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final Supplier<Block> LIGHT_BLUE_CURTAIN = register("light_blue_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final Supplier<Block> BLUE_CURTAIN = register("blue_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final Supplier<Block> PURPLE_CURTAIN = register("purple_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final Supplier<Block> MAGENTA_CURTAIN = register("magenta_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final Supplier<Block> PINK_CURTAIN = register("pink_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));

    // Desks
    public static final Supplier<Block> STONE_DESK = register("stone_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), DeskBlock.MaterialType.STONE));
    public static final Supplier<Block> ANDESITE_DESK = register("andesite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE), DeskBlock.MaterialType.ANDESITE));
    public static final Supplier<Block> DIORITE_DESK = register("diorite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE), DeskBlock.MaterialType.DIORITE));
    public static final Supplier<Block> GRANITE_DESK = register("granite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE), DeskBlock.MaterialType.GRANITE));
    public static final Supplier<Block> BLACKSTONE_DESK = register("blackstone_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE), DeskBlock.MaterialType.BLACKSTONE));
    public static final Supplier<Block> DEEPSLATE_DESK = register("deepslate_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE), DeskBlock.MaterialType.DEEPSLATE));

    // Modern Desks
    public static final Supplier<Block> WHITE_MODERN_DESK = register("white_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE), DeskBlock.MaterialType.WHITE_CONCRETE));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_DESK = register("light_gray_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE), DeskBlock.MaterialType.LIGHT_GRAY_CONCRETE));
    public static final Supplier<Block> GRAY_MODERN_DESK = register("gray_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE), DeskBlock.MaterialType.GRAY_CONCRETE));
    public static final Supplier<Block> BLACK_MODERN_DESK = register("black_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE), DeskBlock.MaterialType.BLACK_CONCRETE));
    public static final Supplier<Block> BROWN_MODERN_DESK = register("brown_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE), DeskBlock.MaterialType.BROWN_CONCRETE));
    public static final Supplier<Block> RED_MODERN_DESK = register("red_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE), DeskBlock.MaterialType.RED_CONCRETE));
    public static final Supplier<Block> ORANGE_MODERN_DESK = register("orange_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE), DeskBlock.MaterialType.ORANGE_CONCRETE));
    public static final Supplier<Block> BEIGE_MODERN_DESK = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), DeskBlock.MaterialType.BEIGE_CONCRETE)) : null;
    public static final Supplier<Block> YELLOW_MODERN_DESK = register("yellow_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), DeskBlock.MaterialType.YELLOW_CONCRETE));
    public static final Supplier<Block> LIME_MODERN_DESK = register("lime_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE), DeskBlock.MaterialType.LIME_CONCRETE));
    public static final Supplier<Block> GREEN_MODERN_DESK = register("green_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE), DeskBlock.MaterialType.GREEN_CONCRETE));
    public static final Supplier<Block> CYAN_MODERN_DESK = register("cyan_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE), DeskBlock.MaterialType.CYAN_CONCRETE));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_DESK = register("light_blue_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE), DeskBlock.MaterialType.LIGHT_BLUE_CONCRETE));
    public static final Supplier<Block> BLUE_MODERN_DESK = register("blue_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE), DeskBlock.MaterialType.BLUE_CONCRETE));
    public static final Supplier<Block> PURPLE_MODERN_DESK = register("purple_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE), DeskBlock.MaterialType.PURPLE_CONCRETE));
    public static final Supplier<Block> MAGENTA_MODERN_DESK = register("magenta_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE), DeskBlock.MaterialType.MAGENTA_CONCRETE));
    public static final Supplier<Block> PINK_MODERN_DESK = register("pink_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE), DeskBlock.MaterialType.PINK_CONCRETE));

    // Desk Cabinets
    public static final Supplier<Block> STONE_DESK_CABINET = register("stone_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), DeskBlock.MaterialType.STONE));
    public static final Supplier<Block> ANDESITE_DESK_CABINET = register("andesite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE), DeskBlock.MaterialType.ANDESITE));
    public static final Supplier<Block> DIORITE_DESK_CABINET = register("diorite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE), DeskBlock.MaterialType.DIORITE));
    public static final Supplier<Block> GRANITE_DESK_CABINET = register("granite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE), DeskBlock.MaterialType.GRANITE));
    public static final Supplier<Block> BLACKSTONE_DESK_CABINET = register("blackstone_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE), DeskBlock.MaterialType.BLACKSTONE));
    public static final Supplier<Block> DEEPSLATE_DESK_CABINET = register("deepslate_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE), DeskBlock.MaterialType.DEEPSLATE));

    // Modern Desk Cabinets
    public static final Supplier<Block> WHITE_MODERN_DESK_CABINET = register("white_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE), DeskBlock.MaterialType.WHITE_CONCRETE));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_DESK_CABINET = register("light_gray_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE), DeskBlock.MaterialType.LIGHT_GRAY_CONCRETE));
    public static final Supplier<Block> GRAY_MODERN_DESK_CABINET = register("gray_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE), DeskBlock.MaterialType.GRAY_CONCRETE));
    public static final Supplier<Block> BLACK_MODERN_DESK_CABINET = register("black_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE), DeskBlock.MaterialType.BLACK_CONCRETE));
    public static final Supplier<Block> BROWN_MODERN_DESK_CABINET = register("brown_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE), DeskBlock.MaterialType.BROWN_CONCRETE));
    public static final Supplier<Block> RED_MODERN_DESK_CABINET = register("red_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE), DeskBlock.MaterialType.RED_CONCRETE));
    public static final Supplier<Block> ORANGE_MODERN_DESK_CABINET = register("orange_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE), DeskBlock.MaterialType.ORANGE_CONCRETE));
    public static final Supplier<Block> BEIGE_MODERN_DESK_CABINET = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), DeskBlock.MaterialType.BEIGE_CONCRETE)) : null;
    public static final Supplier<Block> YELLOW_MODERN_DESK_CABINET = register("yellow_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), DeskBlock.MaterialType.YELLOW_CONCRETE));
    public static final Supplier<Block> LIME_MODERN_DESK_CABINET = register("lime_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE), DeskBlock.MaterialType.LIME_CONCRETE));
    public static final Supplier<Block> GREEN_MODERN_DESK_CABINET = register("green_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE), DeskBlock.MaterialType.GREEN_CONCRETE));
    public static final Supplier<Block> CYAN_MODERN_DESK_CABINET = register("cyan_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE), DeskBlock.MaterialType.CYAN_CONCRETE));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_DESK_CABINET = register("light_blue_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE), DeskBlock.MaterialType.LIGHT_BLUE_CONCRETE));
    public static final Supplier<Block> BLUE_MODERN_DESK_CABINET = register("blue_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE), DeskBlock.MaterialType.BLUE_CONCRETE));
    public static final Supplier<Block> PURPLE_MODERN_DESK_CABINET = register("purple_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE), DeskBlock.MaterialType.PURPLE_CONCRETE));
    public static final Supplier<Block> MAGENTA_MODERN_DESK_CABINET = register("magenta_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE), DeskBlock.MaterialType.MAGENTA_CONCRETE));
    public static final Supplier<Block> PINK_MODERN_DESK_CABINET = register("pink_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE), DeskBlock.MaterialType.PINK_CONCRETE));

    // Wall Cabinets
    public static final Supplier<Block> WHITE_WALL_CABINET = register("white_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_WALL_CABINET = register("light_gray_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_WALL_CABINET = register("gray_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_WALL_CABINET = register("black_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_WALL_CABINET = register("brown_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_WALL_CABINET = register("red_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_WALL_CABINET = register("orange_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_WALL_CABINET = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_WALL_CABINET = register("yellow_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_WALL_CABINET = register("lime_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_WALL_CABINET = register("green_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_WALL_CABINET = register("cyan_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_WALL_CABINET = register("light_blue_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_WALL_CABINET = register("blue_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_WALL_CABINET = register("purple_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_WALL_CABINET = register("magenta_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_WALL_CABINET = register("pink_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Modern Sofas
    public static final Supplier<Block> WHITE_MODERN_SOFA = register("white_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_SOFA = register("light_gray_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final Supplier<Block> GRAY_MODERN_SOFA = register("gray_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final Supplier<Block> BLACK_MODERN_SOFA = register("black_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final Supplier<Block> BROWN_MODERN_SOFA = register("brown_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final Supplier<Block> RED_MODERN_SOFA = register("red_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final Supplier<Block> ORANGE_MODERN_SOFA = register("orange_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final Supplier<Block> BEIGE_MODERN_SOFA = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL))) : null;
    public static final Supplier<Block> YELLOW_MODERN_SOFA = register("yellow_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final Supplier<Block> LIME_MODERN_SOFA = register("lime_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final Supplier<Block> GREEN_MODERN_SOFA = register("green_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final Supplier<Block> CYAN_MODERN_SOFA = register("cyan_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_SOFA = register("light_blue_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final Supplier<Block> BLUE_MODERN_SOFA = register("blue_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final Supplier<Block> PURPLE_MODERN_SOFA = register("purple_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final Supplier<Block> MAGENTA_MODERN_SOFA = register("magenta_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final Supplier<Block> PINK_MODERN_SOFA = register("pink_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));

    // Television Stands
    public static final Supplier<Block> WHITE_TELEVISION_STAND = register("white_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_TELEVISION_STAND = register("light_gray_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_TELEVISION_STAND = register("gray_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_TELEVISION_STAND = register("black_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_TELEVISION_STAND = register("brown_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_TELEVISION_STAND = register("red_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_TELEVISION_STAND = register("orange_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_TELEVISION_STAND = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_TELEVISION_STAND = register("yellow_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_TELEVISION_STAND = register("lime_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_TELEVISION_STAND = register("green_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_TELEVISION_STAND = register("cyan_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_TELEVISION_STAND = register("light_blue_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_TELEVISION_STAND = register("blue_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_TELEVISION_STAND = register("purple_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_TELEVISION_STAND = register("magenta_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_TELEVISION_STAND = register("pink_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Lamps
    public static final Supplier<Block> WHITE_LAMP = register("white_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> LIGHT_GRAY_LAMP = register("light_gray_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> GRAY_LAMP = register("gray_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> BLACK_LAMP = register("black_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> BROWN_LAMP = register("brown_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> RED_LAMP = register("red_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> ORANGE_LAMP = register("orange_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> BEIGE_LAMP = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE).lightLevel(getLightValueLit(15)))) : null;
    public static final Supplier<Block> YELLOW_LAMP = register("yellow_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> LIME_LAMP = register("lime_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> GREEN_LAMP = register("green_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> CYAN_LAMP = register("cyan_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> LIGHT_BLUE_LAMP = register("light_blue_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> BLUE_LAMP = register("blue_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> PURPLE_LAMP = register("purple_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> MAGENTA_LAMP = register("magenta_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL).lightLevel(getLightValueLit(15))));
    public static final Supplier<Block> PINK_LAMP = register("pink_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL).lightLevel(getLightValueLit(15))));

    // Modern Kitchen Counters
    public static final Supplier<Block> WHITE_MODERN_KITCHEN_COUNTER = register("white_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_KITCHEN_COUNTER = register("light_gray_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_MODERN_KITCHEN_COUNTER = register("gray_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_MODERN_KITCHEN_COUNTER = register("black_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_MODERN_KITCHEN_COUNTER = register("brown_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_MODERN_KITCHEN_COUNTER = register("red_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_MODERN_KITCHEN_COUNTER = register("orange_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_MODERN_KITCHEN_COUNTER = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_MODERN_KITCHEN_COUNTER = register("yellow_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_MODERN_KITCHEN_COUNTER = register("lime_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_MODERN_KITCHEN_COUNTER = register("green_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_MODERN_KITCHEN_COUNTER = register("cyan_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_KITCHEN_COUNTER = register("light_blue_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_MODERN_KITCHEN_COUNTER = register("blue_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_MODERN_KITCHEN_COUNTER = register("purple_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_MODERN_KITCHEN_COUNTER = register("magenta_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_MODERN_KITCHEN_COUNTER = register("pink_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Modern Kitchen Drawers
    public static final Supplier<Block> WHITE_MODERN_KITCHEN_DRAWER = register("white_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_KITCHEN_DRAWER = register("light_gray_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_MODERN_KITCHEN_DRAWER = register("gray_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_MODERN_KITCHEN_DRAWER = register("black_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_MODERN_KITCHEN_DRAWER = register("brown_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_MODERN_KITCHEN_DRAWER = register("red_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_MODERN_KITCHEN_DRAWER = register("orange_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_MODERN_KITCHEN_DRAWER = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_MODERN_KITCHEN_DRAWER = register("yellow_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_MODERN_KITCHEN_DRAWER = register("lime_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_MODERN_KITCHEN_DRAWER = register("green_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_MODERN_KITCHEN_DRAWER = register("cyan_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_KITCHEN_DRAWER = register("light_blue_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_MODERN_KITCHEN_DRAWER = register("blue_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_MODERN_KITCHEN_DRAWER = register("purple_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_MODERN_KITCHEN_DRAWER = register("magenta_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_MODERN_KITCHEN_DRAWER = register("pink_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Modern Kitchen Sinks
    public static final Supplier<Block> WHITE_MODERN_KITCHEN_SINK = register("white_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE), false));
    public static final Supplier<Block> LIGHT_GRAY_MODERN_KITCHEN_SINK = register("light_gray_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE), false));
    public static final Supplier<Block> GRAY_MODERN_KITCHEN_SINK = register("gray_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE), false));
    public static final Supplier<Block> BLACK_MODERN_KITCHEN_SINK = register("black_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE), false));
    public static final Supplier<Block> BROWN_MODERN_KITCHEN_SINK = register("brown_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE), false));
    public static final Supplier<Block> RED_MODERN_KITCHEN_SINK = register("red_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE), false));
    public static final Supplier<Block> ORANGE_MODERN_KITCHEN_SINK = register("orange_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE), false));
    public static final Supplier<Block> BEIGE_MODERN_KITCHEN_SINK = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), false)) : null;
    public static final Supplier<Block> YELLOW_MODERN_KITCHEN_SINK = register("yellow_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), false));
    public static final Supplier<Block> LIME_MODERN_KITCHEN_SINK = register("lime_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE), false));
    public static final Supplier<Block> GREEN_MODERN_KITCHEN_SINK = register("green_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE), false));
    public static final Supplier<Block> CYAN_MODERN_KITCHEN_SINK = register("cyan_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE), false));
    public static final Supplier<Block> LIGHT_BLUE_MODERN_KITCHEN_SINK = register("light_blue_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE), false));
    public static final Supplier<Block> BLUE_MODERN_KITCHEN_SINK = register("blue_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE), false));
    public static final Supplier<Block> PURPLE_MODERN_KITCHEN_SINK = register("purple_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE), false));
    public static final Supplier<Block> MAGENTA_MODERN_KITCHEN_SINK = register("magenta_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE), false));
    public static final Supplier<Block> PINK_MODERN_KITCHEN_SINK = register("pink_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE), false));

    // Bar Stools
    public static final Supplier<Block> WHITE_BAR_STOOL = register("white_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_BAR_STOOL = register("light_gray_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_BAR_STOOL = register("gray_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_BAR_STOOL = register("black_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_BAR_STOOL = register("brown_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_BAR_STOOL = register("red_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_BAR_STOOL = register("orange_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_BAR_STOOL = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_BAR_STOOL = register("yellow_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_BAR_STOOL = register("lime_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_BAR_STOOL = register("green_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_BAR_STOOL = register("cyan_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_BAR_STOOL = register("light_blue_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_BAR_STOOL = register("blue_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_BAR_STOOL = register("purple_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_BAR_STOOL = register("magenta_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_BAR_STOOL = register("pink_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Chopping Boards
    public static final Supplier<Block> OAK_CHOPPING_BOARD = register("oak_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final Supplier<Block> SPRUCE_CHOPPING_BOARD = register("spruce_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final Supplier<Block> BIRCH_CHOPPING_BOARD = register("birch_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final Supplier<Block> JUNGLE_CHOPPING_BOARD = register("jungle_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final Supplier<Block> ACACIA_CHOPPING_BOARD = register("acacia_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final Supplier<Block> DARK_OAK_CHOPPING_BOARD = register("dark_oak_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final Supplier<Block> MANGROVE_CHOPPING_BOARD = register("mangrove_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final Supplier<Block> CHERRY_CHOPPING_BOARD = register("cherry_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final Supplier<Block> CRIMSON_CHOPPING_BOARD = register("crimson_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final Supplier<Block> WARPED_CHOPPING_BOARD = register("warped_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Door Bells
    public static final Supplier<Block> OAK_DOOR_BELL = register("oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> SPRUCE_DOOR_BELL = register("spruce_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> BIRCH_DOOR_BELL = register("birch_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> JUNGLE_DOOR_BELL = register("jungle_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> ACACIA_DOOR_BELL = register("acacia_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_DOOR_BELL = register("dark_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> MANGROVE_DOOR_BELL = register("mangrove_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_DOOR_BELL = register("cherry_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> CRIMSON_DOOR_BELL = register("crimson_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> WARPED_DOOR_BELL = register("warped_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_OAK_DOOR_BELL = register("stripped_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_SPRUCE_DOOR_BELL = register("stripped_spruce_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_BIRCH_DOOR_BELL = register("stripped_birch_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_JUNGLE_DOOR_BELL = register("stripped_jungle_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_ACACIA_DOOR_BELL = register("stripped_acacia_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_DARK_OAK_DOOR_BELL = register("stripped_dark_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_MANGROVE_DOOR_BELL = register("stripped_mangrove_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_CHERRY_DOOR_BELL = register("stripped_cherry_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_CRIMSON_DOOR_BELL = register("stripped_crimson_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final Supplier<Block> STRIPPED_WARPED_DOOR_BELL = register("stripped_warped_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));

    // Inflatable Castles
    public static final Supplier<Block> WHITE_INFLATABLE_CASTLE = register("white_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final Supplier<Block> LIGHT_GRAY_INFLATABLE_CASTLE = register("light_gray_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final Supplier<Block> GRAY_INFLATABLE_CASTLE = register("gray_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final Supplier<Block> BLACK_INFLATABLE_CASTLE = register("black_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final Supplier<Block> BROWN_INFLATABLE_CASTLE = register("brown_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final Supplier<Block> RED_INFLATABLE_CASTLE = register("red_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final Supplier<Block> ORANGE_INFLATABLE_CASTLE = register("orange_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final Supplier<Block> BEIGE_INFLATABLE_CASTLE = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL))) : null;
    public static final Supplier<Block> YELLOW_INFLATABLE_CASTLE = register("yellow_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final Supplier<Block> LIME_INFLATABLE_CASTLE = register("lime_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final Supplier<Block> GREEN_INFLATABLE_CASTLE = register("green_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final Supplier<Block> CYAN_INFLATABLE_CASTLE = register("cyan_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final Supplier<Block> LIGHT_BLUE_INFLATABLE_CASTLE = register("light_blue_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final Supplier<Block> BLUE_INFLATABLE_CASTLE = register("blue_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final Supplier<Block> PURPLE_INFLATABLE_CASTLE = register("purple_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final Supplier<Block> MAGENTA_INFLATABLE_CASTLE = register("magenta_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final Supplier<Block> PINK_INFLATABLE_CASTLE = register("pink_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final Supplier<Block> CASTLE_NETTING = register("castle_netting",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));

    // Kitchenware
    public static final Supplier<Block> COOKIE_JAR = register("cookie_jar",
            () -> new CookieJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final Supplier<Block> WHITE_CUP = register("white_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final Supplier<Block> LIGHT_GRAY_CUP = register("light_gray_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final Supplier<Block> GRAY_CUP = register("gray_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final Supplier<Block> BLACK_CUP = register("black_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final Supplier<Block> BROWN_CUP = register("brown_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final Supplier<Block> RED_CUP = register("red_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final Supplier<Block> ORANGE_CUP = register("orange_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final Supplier<Block> BEIGE_CUP = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS))) : null;
    public static final Supplier<Block> YELLOW_CUP = register("yellow_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final Supplier<Block> LIME_CUP = register("lime_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final Supplier<Block> GREEN_CUP = register("green_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final Supplier<Block> CYAN_CUP = register("cyan_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final Supplier<Block> LIGHT_BLUE_CUP = register("light_blue_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final Supplier<Block> BLUE_CUP = register("blue_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final Supplier<Block> PURPLE_CUP = register("purple_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final Supplier<Block> MAGENTA_CUP = register("magenta_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final Supplier<Block> PINK_CUP = register("pink_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final Supplier<Block> PLATE = register("plate",
            () -> new PlateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ)));

    // Bird Baths
    public static final Supplier<Block> STONE_BIRD_BATH = register("stone_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final Supplier<Block> ANDESITE_BIRD_BATH = register("andesite_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final Supplier<Block> DIORITE_BIRD_BATH = register("diorite_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> GRANITE_BIRD_BATH = register("granite_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final Supplier<Block> BLACKSTONE_BIRD_BATH = register("blackstone_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final Supplier<Block> DEEPSLATE_BIRD_BATH = register("deepslate_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Taps
    public static final Supplier<Block> STONE_TAP = register("stone_tap",
            () -> new TapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final Supplier<Block> ANDESITE_TAP = register("andesite_tap",
            () -> new TapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final Supplier<Block> DIORITE_TAP = register("diorite_tap",
            () -> new TapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final Supplier<Block> GRANITE_TAP = register("granite_tap",
            () -> new TapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final Supplier<Block> BLACKSTONE_TAP = register("blackstone_tap",
            () -> new TapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final Supplier<Block> DEEPSLATE_TAP = register("deepslate_tap",
            () -> new TapBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Water Tanks
    public static final Supplier<Block> OAK_WATER_TANK = register("oak_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final Supplier<Block> SPRUCE_WATER_TANK = register("spruce_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final Supplier<Block> BIRCH_WATER_TANK = register("birch_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final Supplier<Block> JUNGLE_WATER_TANK = register("jungle_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final Supplier<Block> ACACIA_WATER_TANK = register("acacia_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final Supplier<Block> DARK_OAK_WATER_TANK = register("dark_oak_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final Supplier<Block> MANGROVE_WATER_TANK = register("mangrove_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final Supplier<Block> CHERRY_WATER_TANK = register("cherry_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final Supplier<Block> CRIMSON_WATER_TANK = register("crimson_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final Supplier<Block> WARPED_WATER_TANK = register("warped_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));

    // Appliances and Electronics
    public static final Supplier<Block> ELECTRIC_FENCE = register("electric_fence",
            () -> new ElectricFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL)));
    public static final Supplier<Block> BATH_LIGHT = register("bath_light",
            () -> new BathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> BATH_DARK = register("bath_dark",
            () -> new BathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BIN_LIGHT = register("bin_light",
            () -> new BinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> BIN_DARK = register("bin_dark",
            () -> new BinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> BLENDER_LIGHT = register("blender_light",
            () -> new BlenderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> BLENDER_DARK = register("blender_dark",
            () -> new BlenderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> CATHODE_RAY_TUBE_TELEVISION = register("cathode_ray_tube_television",
            () -> new CathodeRayTubeTelevisionBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> COMPUTER_LIGHT = register("computer_light",
            () -> new ComputerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> COMPUTER_DARK = register("computer_dark",
            () -> new ComputerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final Supplier<Block> DISHWASHER_LIGHT = register("dishwasher_light",
            () -> new DishwasherBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> DISHWASHER_DARK = register("dishwasher_dark",
            () -> new DishwasherBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> FIRE_ALARM = register("fire_alarm",
            () -> new FireAlarmBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIQUID_CRYSTAL_DISPLAY_TELEVISION = register("liquid_crystal_display_television",
            () -> new LiquidCrystalDisplayTelevisionBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> MICROWAVE_LIGHT = register("microwave_light",
            () -> new MicrowaveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> MICROWAVE_DARK = register("microwave_dark",
            () -> new MicrowaveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> OVEN_LIGHT = register("oven_light",
            () -> new OvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> OVEN_DARK = register("oven_dark",
            () -> new OvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> OVEN_RANGE_HOOD_LIGHT = register("oven_range_hood_light",
            () -> new OvenRangeHoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).lightLevel(getLightValueLit(14)).noOcclusion()));
    public static final Supplier<Block> OVEN_RANGE_HOOD_DARK = register("oven_range_hood_dark",
            () -> new OvenRangeHoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).lightLevel(getLightValueLit(14)).noOcclusion()));
    public static final Supplier<Block> PRINTER = register("printer",
            () -> new PrinterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> SINK_LIGHT = register("sink_light",
            () -> new SinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> SINK_DARK = register("sink_dark",
            () -> new SinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> SHOWER_LIGHT = register("shower_light",
            () -> new ShowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> SHOWER_DARK = register("shower_dark",
            () -> new ShowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> SHOWER_HEAD_LIGHT = register("shower_head_light",
            () -> new ShowerHeadBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> SHOWER_HEAD_DARK = register("shower_head_dark",
            () -> new ShowerHeadBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> STEREO = register("stereo",
            () -> new StereoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> TOASTER_LIGHT = register("toaster_light",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> TOASTER_DARK = register("toaster_dark",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> TOILET_LIGHT = register("toilet_light",
            () -> new ToiletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> TOILET_DARK = register("toilet_dark",
            () -> new ToiletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final Supplier<Block> WASHING_MACHINE_LIGHT = register("washing_machine_light",
            () -> new WashingMachineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final Supplier<Block> WASHING_MACHINE_DARK = register("washing_machine_dark",
            () -> new WashingMachineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));

    // Digital Clocks
    public static final Supplier<Block> WHITE_DIGITAL_CLOCK = register("white_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final Supplier<Block> LIGHT_GRAY_DIGITAL_CLOCK = register("light_gray_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final Supplier<Block> GRAY_DIGITAL_CLOCK = register("gray_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final Supplier<Block> BLACK_DIGITAL_CLOCK = register("black_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final Supplier<Block> BROWN_DIGITAL_CLOCK = register("brown_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final Supplier<Block> RED_DIGITAL_CLOCK = register("red_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final Supplier<Block> ORANGE_DIGITAL_CLOCK = register("orange_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final Supplier<Block> BEIGE_DIGITAL_CLOCK = Services.PLATFORM.isModLoaded("yogmod") ? register("beige_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE))) : null;
    public static final Supplier<Block> YELLOW_DIGITAL_CLOCK = register("yellow_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final Supplier<Block> LIME_DIGITAL_CLOCK = register("lime_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final Supplier<Block> GREEN_DIGITAL_CLOCK = register("green_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final Supplier<Block> CYAN_DIGITAL_CLOCK = register("cyan_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final Supplier<Block> LIGHT_BLUE_DIGITAL_CLOCK = register("light_blue_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final Supplier<Block> BLUE_DIGITAL_CLOCK = register("blue_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final Supplier<Block> PURPLE_DIGITAL_CLOCK = register("purple_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final Supplier<Block> MAGENTA_DIGITAL_CLOCK = register("magenta_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final Supplier<Block> PINK_DIGITAL_CLOCK = register("pink_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Festive Blocks
    public static final Supplier<Block> CANDLE = register("candle",
            () -> new CandleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).lightLevel(getLightValueLit(13)).noOcclusion()));
    public static final Supplier<Block> CHRISTMAS_TREE = register("christmas_tree",
            () -> new ChristmasTreeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES).noOcclusion()));
    public static final Supplier<Block> WREATH = register("wreath",
            () -> new WreathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES).noOcclusion()));

    // Fluids
    public static final Supplier<LiquidBlock> SOAPY_WATER = register("soapy_water",
            () -> new LiquidBlock(ModFluids.SOAPY_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final Supplier<LiquidBlock> SUPER_SOAPY_WATER = register("super_soapy_water",
            () -> new LiquidBlock(ModFluids.SUPER_SOAPY_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

    // Methods
    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

}