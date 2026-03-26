package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.level.block.*;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("nfm");

    // Tables
    public static final DeferredBlock<Block> STONE_TABLE = BLOCKS.register("stone_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_TABLE = BLOCKS.register("andesite_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> DIORITE_TABLE = BLOCKS.register("diorite_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> GRANITE_TABLE = BLOCKS.register("granite_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> BLACKSTONE_TABLE = BLOCKS.register("blackstone_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> DEEPSLATE_TABLE = BLOCKS.register("deepslate_table",
            () -> new TableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Tables
    public static final DeferredBlock<Block> WHITE_MODERN_TABLE = BLOCKS.register("white_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_TABLE = BLOCKS.register("light_gray_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_MODERN_TABLE = BLOCKS.register("gray_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_MODERN_TABLE = BLOCKS.register("black_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_MODERN_TABLE = BLOCKS.register("brown_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_MODERN_TABLE = BLOCKS.register("red_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_MODERN_TABLE = BLOCKS.register("orange_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_MODERN_TABLE = BLOCKS.register("beige_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_MODERN_TABLE = BLOCKS.register("yellow_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_MODERN_TABLE = BLOCKS.register("lime_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_MODERN_TABLE = BLOCKS.register("green_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_MODERN_TABLE = BLOCKS.register("cyan_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_TABLE = BLOCKS.register("light_blue_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_MODERN_TABLE = BLOCKS.register("blue_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_MODERN_TABLE = BLOCKS.register("purple_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_TABLE = BLOCKS.register("magenta_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_MODERN_TABLE = BLOCKS.register("pink_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Chairs
    public static final DeferredBlock<Block> STONE_CHAIR = BLOCKS.register("stone_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_CHAIR = BLOCKS.register("andesite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> DIORITE_CHAIR = BLOCKS.register("diorite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> GRANITE_CHAIR = BLOCKS.register("granite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> BLACKSTONE_CHAIR = BLOCKS.register("blackstone_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> DEEPSLATE_CHAIR = BLOCKS.register("deepslate_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Chairs
    public static final DeferredBlock<Block> WHITE_MODERN_CHAIR = BLOCKS.register("white_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_CHAIR = BLOCKS.register("light_gray_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_MODERN_CHAIR = BLOCKS.register("gray_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_MODERN_CHAIR = BLOCKS.register("black_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_MODERN_CHAIR = BLOCKS.register("brown_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_MODERN_CHAIR = BLOCKS.register("red_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_MODERN_CHAIR = BLOCKS.register("orange_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_MODERN_CHAIR = BLOCKS.register("beige_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_MODERN_CHAIR = BLOCKS.register("yellow_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_MODERN_CHAIR = BLOCKS.register("lime_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_MODERN_CHAIR = BLOCKS.register("green_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_MODERN_CHAIR = BLOCKS.register("cyan_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_CHAIR = BLOCKS.register("light_blue_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_MODERN_CHAIR = BLOCKS.register("blue_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_MODERN_CHAIR = BLOCKS.register("purple_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_CHAIR = BLOCKS.register("magenta_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_MODERN_CHAIR = BLOCKS.register("pink_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Coffee Tables
    public static final DeferredBlock<Block> STONE_COFFEE_TABLE = BLOCKS.register("stone_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_COFFEE_TABLE = BLOCKS.register("andesite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> DIORITE_COFFEE_TABLE = BLOCKS.register("diorite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> GRANITE_COFFEE_TABLE = BLOCKS.register("granite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> BLACKSTONE_COFFEE_TABLE = BLOCKS.register("blackstone_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> DEEPSLATE_COFFEE_TABLE = BLOCKS.register("deepslate_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Coffee Tables
    public static final DeferredBlock<Block> WHITE_MODERN_COFFEE_TABLE = BLOCKS.register("white_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_COFFEE_TABLE = BLOCKS.register("light_gray_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_MODERN_COFFEE_TABLE = BLOCKS.register("gray_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_MODERN_COFFEE_TABLE = BLOCKS.register("black_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_MODERN_COFFEE_TABLE = BLOCKS.register("brown_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_MODERN_COFFEE_TABLE = BLOCKS.register("red_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_MODERN_COFFEE_TABLE = BLOCKS.register("orange_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_MODERN_COFFEE_TABLE = BLOCKS.register("beige_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_MODERN_COFFEE_TABLE = BLOCKS.register("yellow_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_MODERN_COFFEE_TABLE = BLOCKS.register("lime_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_MODERN_COFFEE_TABLE = BLOCKS.register("green_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_MODERN_COFFEE_TABLE = BLOCKS.register("cyan_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_COFFEE_TABLE = BLOCKS.register("light_blue_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_MODERN_COFFEE_TABLE = BLOCKS.register("blue_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_MODERN_COFFEE_TABLE = BLOCKS.register("purple_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_COFFEE_TABLE = BLOCKS.register("magenta_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_MODERN_COFFEE_TABLE = BLOCKS.register("pink_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Cabinets
    public static final DeferredBlock<Block> STONE_CABINET = BLOCKS.register("stone_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_CABINET = BLOCKS.register("andesite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> DIORITE_CABINET = BLOCKS.register("diorite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> GRANITE_CABINET = BLOCKS.register("granite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> BLACKSTONE_CABINET = BLOCKS.register("blackstone_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> DEEPSLATE_CABINET = BLOCKS.register("deepslate_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Cabinets
    public static final DeferredBlock<Block> WHITE_MODERN_CABINET = BLOCKS.register("white_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_CABINET = BLOCKS.register("light_gray_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_MODERN_CABINET = BLOCKS.register("gray_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_MODERN_CABINET = BLOCKS.register("black_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_MODERN_CABINET = BLOCKS.register("brown_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_MODERN_CABINET = BLOCKS.register("red_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_MODERN_CABINET = BLOCKS.register("orange_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_MODERN_CABINET = BLOCKS.register("beige_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_MODERN_CABINET = BLOCKS.register("yellow_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_MODERN_CABINET = BLOCKS.register("lime_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_MODERN_CABINET = BLOCKS.register("green_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_MODERN_CABINET = BLOCKS.register("cyan_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_CABINET = BLOCKS.register("light_blue_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_MODERN_CABINET = BLOCKS.register("blue_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_MODERN_CABINET = BLOCKS.register("purple_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_CABINET = BLOCKS.register("magenta_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_MODERN_CABINET = BLOCKS.register("pink_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Bedside Cabinets
    public static final DeferredBlock<Block> STONE_BEDSIDE_CABINET = BLOCKS.register("stone_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_BEDSIDE_CABINET = BLOCKS.register("andesite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> DIORITE_BEDSIDE_CABINET = BLOCKS.register("diorite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> GRANITE_BEDSIDE_CABINET = BLOCKS.register("granite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> BLACKSTONE_BEDSIDE_CABINET = BLOCKS.register("blackstone_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> DEEPSLATE_BEDSIDE_CABINET = BLOCKS.register("deepslate_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    // Modern Bedside Cabinets
    public static final DeferredBlock<Block> WHITE_MODERN_BEDSIDE_CABINET = BLOCKS.register("white_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_BEDSIDE_CABINET = BLOCKS.register("light_gray_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_MODERN_BEDSIDE_CABINET = BLOCKS.register("gray_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_MODERN_BEDSIDE_CABINET = BLOCKS.register("black_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_MODERN_BEDSIDE_CABINET = BLOCKS.register("brown_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_MODERN_BEDSIDE_CABINET = BLOCKS.register("red_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_MODERN_BEDSIDE_CABINET = BLOCKS.register("orange_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_MODERN_BEDSIDE_CABINET = BLOCKS.register("beige_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_MODERN_BEDSIDE_CABINET = BLOCKS.register("yellow_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_MODERN_BEDSIDE_CABINET = BLOCKS.register("lime_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_MODERN_BEDSIDE_CABINET = BLOCKS.register("green_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_MODERN_BEDSIDE_CABINET = BLOCKS.register("cyan_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_BEDSIDE_CABINET = BLOCKS.register("light_blue_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_MODERN_BEDSIDE_CABINET = BLOCKS.register("blue_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_MODERN_BEDSIDE_CABINET = BLOCKS.register("purple_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_BEDSIDE_CABINET = BLOCKS.register("magenta_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_MODERN_BEDSIDE_CABINET = BLOCKS.register("pink_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Modern Beds
    public static final DeferredBlock<Block> WHITE_MODERN_BED = BLOCKS.register("white_modern_bed",
            () -> new ModernBedBlock(DyeColor.WHITE, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_BED = BLOCKS.register("light_gray_modern_bed",
            () -> new ModernBedBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> GRAY_MODERN_BED = BLOCKS.register("gray_modern_bed",
            () -> new ModernBedBlock(DyeColor.GRAY, BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> BLACK_MODERN_BED = BLOCKS.register("black_modern_bed",
            () -> new ModernBedBlock(DyeColor.BLACK, BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> BROWN_MODERN_BED = BLOCKS.register("brown_modern_bed",
            () -> new ModernBedBlock(DyeColor.BROWN, BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> RED_MODERN_BED = BLOCKS.register("red_modern_bed",
            () -> new ModernBedBlock(DyeColor.RED, BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> ORANGE_MODERN_BED = BLOCKS.register("orange_modern_bed",
            () -> new ModernBedBlock(DyeColor.ORANGE, BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> BEIGE_MODERN_BED = BLOCKS.register("beige_modern_bed",
            () -> new ModernBedBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> YELLOW_MODERN_BED = BLOCKS.register("yellow_modern_bed",
            () -> new ModernBedBlock(DyeColor.YELLOW, BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> LIME_MODERN_BED = BLOCKS.register("lime_modern_bed",
            () -> new ModernBedBlock(DyeColor.LIME, BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> GREEN_MODERN_BED = BLOCKS.register("green_modern_bed",
            () -> new ModernBedBlock(DyeColor.GREEN, BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> CYAN_MODERN_BED = BLOCKS.register("cyan_modern_bed",
            () -> new ModernBedBlock(DyeColor.CYAN, BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_BED = BLOCKS.register("light_blue_modern_bed",
            () -> new ModernBedBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> BLUE_MODERN_BED = BLOCKS.register("blue_modern_bed",
            () -> new ModernBedBlock(DyeColor.BLUE, BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> PURPLE_MODERN_BED = BLOCKS.register("purple_modern_bed",
            () -> new ModernBedBlock(DyeColor.PURPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_BED = BLOCKS.register("magenta_modern_bed",
            () -> new ModernBedBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> PINK_MODERN_BED = BLOCKS.register("pink_modern_bed",
            () -> new ModernBedBlock(DyeColor.PINK, BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));

    // Curtains
    public static final DeferredBlock<Block> WHITE_CURTAIN = BLOCKS.register("white_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CURTAIN = BLOCKS.register("light_gray_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> GRAY_CURTAIN = BLOCKS.register("gray_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> BLACK_CURTAIN = BLOCKS.register("black_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> BROWN_CURTAIN = BLOCKS.register("brown_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> RED_CURTAIN = BLOCKS.register("red_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> ORANGE_CURTAIN = BLOCKS.register("orange_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> BEIGE_CURTAIN = BLOCKS.register("beige_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> YELLOW_CURTAIN = BLOCKS.register("yellow_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> LIME_CURTAIN = BLOCKS.register("lime_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> GREEN_CURTAIN = BLOCKS.register("green_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> CYAN_CURTAIN = BLOCKS.register("cyan_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CURTAIN = BLOCKS.register("light_blue_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> BLUE_CURTAIN = BLOCKS.register("blue_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> PURPLE_CURTAIN = BLOCKS.register("purple_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_CURTAIN = BLOCKS.register("magenta_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> PINK_CURTAIN = BLOCKS.register("pink_curtain",
            () -> new CurtainBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));

}
