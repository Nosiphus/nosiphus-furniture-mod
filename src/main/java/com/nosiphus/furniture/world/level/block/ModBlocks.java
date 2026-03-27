package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.level.block.*;
import com.nosiphus.furniture.world.ChoppingBoardBlock;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.ToIntFunction;

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

    // Desks
    public static final DeferredBlock<Block> STONE_DESK = BLOCKS.register("stone_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), DeskBlock.MaterialType.STONE));
    public static final DeferredBlock<Block> ANDESITE_DESK = BLOCKS.register("andesite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE), DeskBlock.MaterialType.ANDESITE));
    public static final DeferredBlock<Block> DIORITE_DESK = BLOCKS.register("diorite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE), DeskBlock.MaterialType.DIORITE));
    public static final DeferredBlock<Block> GRANITE_DESK = BLOCKS.register("granite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE), DeskBlock.MaterialType.GRANITE));
    public static final DeferredBlock<Block> BLACKSTONE_DESK = BLOCKS.register("blackstone_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE), DeskBlock.MaterialType.BLACKSTONE));
    public static final DeferredBlock<Block> DEEPSLATE_DESK = BLOCKS.register("deepslate_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE), DeskBlock.MaterialType.DEEPSLATE));

    // Modern Desks
    public static final DeferredBlock<Block> WHITE_MODERN_DESK = BLOCKS.register("white_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE), DeskBlock.MaterialType.WHITE_CONCRETE));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_DESK = BLOCKS.register("light_gray_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE), DeskBlock.MaterialType.LIGHT_GRAY_CONCRETE));
    public static final DeferredBlock<Block> GRAY_MODERN_DESK = BLOCKS.register("gray_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE), DeskBlock.MaterialType.GRAY_CONCRETE));
    public static final DeferredBlock<Block> BLACK_MODERN_DESK = BLOCKS.register("black_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE), DeskBlock.MaterialType.BLACK_CONCRETE));
    public static final DeferredBlock<Block> BROWN_MODERN_DESK = BLOCKS.register("brown_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE), DeskBlock.MaterialType.BROWN_CONCRETE));
    public static final DeferredBlock<Block> RED_MODERN_DESK = BLOCKS.register("red_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE), DeskBlock.MaterialType.RED_CONCRETE));
    public static final DeferredBlock<Block> ORANGE_MODERN_DESK = BLOCKS.register("orange_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE), DeskBlock.MaterialType.ORANGE_CONCRETE));
    public static final DeferredBlock<Block> BEIGE_MODERN_DESK = BLOCKS.register("beige_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), DeskBlock.MaterialType.BEIGE_CONCRETE));
    public static final DeferredBlock<Block> YELLOW_MODERN_DESK = BLOCKS.register("yellow_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), DeskBlock.MaterialType.YELLOW_CONCRETE));
    public static final DeferredBlock<Block> LIME_MODERN_DESK = BLOCKS.register("lime_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE), DeskBlock.MaterialType.LIME_CONCRETE));
    public static final DeferredBlock<Block> GREEN_MODERN_DESK = BLOCKS.register("green_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE), DeskBlock.MaterialType.GREEN_CONCRETE));
    public static final DeferredBlock<Block> CYAN_MODERN_DESK = BLOCKS.register("cyan_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE), DeskBlock.MaterialType.CYAN_CONCRETE));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_DESK = BLOCKS.register("light_blue_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE), DeskBlock.MaterialType.LIGHT_BLUE_CONCRETE));
    public static final DeferredBlock<Block> BLUE_MODERN_DESK = BLOCKS.register("blue_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE), DeskBlock.MaterialType.BLUE_CONCRETE));
    public static final DeferredBlock<Block> PURPLE_MODERN_DESK = BLOCKS.register("purple_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE), DeskBlock.MaterialType.PURPLE_CONCRETE));
    public static final DeferredBlock<Block> MAGENTA_MODERN_DESK = BLOCKS.register("magenta_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE), DeskBlock.MaterialType.MAGENTA_CONCRETE));
    public static final DeferredBlock<Block> PINK_MODERN_DESK = BLOCKS.register("pink_modern_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE), DeskBlock.MaterialType.PINK_CONCRETE));

    // Desk Cabinets
    public static final DeferredBlock<Block> STONE_DESK_CABINET = BLOCKS.register("stone_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), DeskBlock.MaterialType.STONE));
    public static final DeferredBlock<Block> ANDESITE_DESK_CABINET = BLOCKS.register("andesite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE), DeskBlock.MaterialType.ANDESITE));
    public static final DeferredBlock<Block> DIORITE_DESK_CABINET = BLOCKS.register("diorite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE), DeskBlock.MaterialType.DIORITE));
    public static final DeferredBlock<Block> GRANITE_DESK_CABINET = BLOCKS.register("granite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE), DeskBlock.MaterialType.GRANITE));
    public static final DeferredBlock<Block> BLACKSTONE_DESK_CABINET = BLOCKS.register("blackstone_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE), DeskBlock.MaterialType.BLACKSTONE));
    public static final DeferredBlock<Block> DEEPSLATE_DESK_CABINET = BLOCKS.register("deepslate_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE), DeskBlock.MaterialType.DEEPSLATE));

    // Modern Desk Cabinets
    public static final DeferredBlock<Block> WHITE_MODERN_DESK_CABINET = BLOCKS.register("white_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE), DeskBlock.MaterialType.WHITE_CONCRETE));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_DESK_CABINET = BLOCKS.register("light_gray_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE), DeskBlock.MaterialType.LIGHT_GRAY_CONCRETE));
    public static final DeferredBlock<Block> GRAY_MODERN_DESK_CABINET = BLOCKS.register("gray_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE), DeskBlock.MaterialType.GRAY_CONCRETE));
    public static final DeferredBlock<Block> BLACK_MODERN_DESK_CABINET = BLOCKS.register("black_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE), DeskBlock.MaterialType.BLACK_CONCRETE));
    public static final DeferredBlock<Block> BROWN_MODERN_DESK_CABINET = BLOCKS.register("brown_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE), DeskBlock.MaterialType.BROWN_CONCRETE));
    public static final DeferredBlock<Block> RED_MODERN_DESK_CABINET = BLOCKS.register("red_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE), DeskBlock.MaterialType.RED_CONCRETE));
    public static final DeferredBlock<Block> ORANGE_MODERN_DESK_CABINET = BLOCKS.register("orange_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE), DeskBlock.MaterialType.ORANGE_CONCRETE));
    public static final DeferredBlock<Block> BEIGE_MODERN_DESK_CABINET = BLOCKS.register("beige_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), DeskBlock.MaterialType.BEIGE_CONCRETE));
    public static final DeferredBlock<Block> YELLOW_MODERN_DESK_CABINET = BLOCKS.register("yellow_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), DeskBlock.MaterialType.YELLOW_CONCRETE));
    public static final DeferredBlock<Block> LIME_MODERN_DESK_CABINET = BLOCKS.register("lime_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE), DeskBlock.MaterialType.LIME_CONCRETE));
    public static final DeferredBlock<Block> GREEN_MODERN_DESK_CABINET = BLOCKS.register("green_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE), DeskBlock.MaterialType.GREEN_CONCRETE));
    public static final DeferredBlock<Block> CYAN_MODERN_DESK_CABINET = BLOCKS.register("cyan_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE), DeskBlock.MaterialType.CYAN_CONCRETE));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_DESK_CABINET = BLOCKS.register("light_blue_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE), DeskBlock.MaterialType.LIGHT_BLUE_CONCRETE));
    public static final DeferredBlock<Block> BLUE_MODERN_DESK_CABINET = BLOCKS.register("blue_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE), DeskBlock.MaterialType.BLUE_CONCRETE));
    public static final DeferredBlock<Block> PURPLE_MODERN_DESK_CABINET = BLOCKS.register("purple_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE), DeskBlock.MaterialType.PURPLE_CONCRETE));
    public static final DeferredBlock<Block> MAGENTA_MODERN_DESK_CABINET = BLOCKS.register("magenta_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE), DeskBlock.MaterialType.MAGENTA_CONCRETE));
    public static final DeferredBlock<Block> PINK_MODERN_DESK_CABINET = BLOCKS.register("pink_modern_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE), DeskBlock.MaterialType.PINK_CONCRETE));

    // Wall Cabinets
    public static final DeferredBlock<Block> WHITE_WALL_CABINET = BLOCKS.register("white_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_WALL_CABINET = BLOCKS.register("light_gray_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_WALL_CABINET = BLOCKS.register("gray_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_WALL_CABINET = BLOCKS.register("black_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_WALL_CABINET = BLOCKS.register("brown_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_WALL_CABINET = BLOCKS.register("red_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_WALL_CABINET = BLOCKS.register("orange_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_WALL_CABINET = BLOCKS.register("beige_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_WALL_CABINET = BLOCKS.register("yellow_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_WALL_CABINET = BLOCKS.register("lime_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_WALL_CABINET = BLOCKS.register("green_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_WALL_CABINET = BLOCKS.register("cyan_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_WALL_CABINET = BLOCKS.register("light_blue_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_WALL_CABINET = BLOCKS.register("blue_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_WALL_CABINET = BLOCKS.register("purple_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_WALL_CABINET = BLOCKS.register("magenta_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_WALL_CABINET = BLOCKS.register("pink_wall_cabinet",
            () -> new WallCabinetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Modern Sofas
    public static final DeferredBlock<Block> WHITE_MODERN_SOFA = BLOCKS.register("white_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_SOFA = BLOCKS.register("light_gray_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> GRAY_MODERN_SOFA = BLOCKS.register("gray_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> BLACK_MODERN_SOFA = BLOCKS.register("black_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> BROWN_MODERN_SOFA = BLOCKS.register("brown_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> RED_MODERN_SOFA = BLOCKS.register("red_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> ORANGE_MODERN_SOFA = BLOCKS.register("orange_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> BEIGE_MODERN_SOFA = BLOCKS.register("beige_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> YELLOW_MODERN_SOFA = BLOCKS.register("yellow_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> LIME_MODERN_SOFA = BLOCKS.register("lime_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> GREEN_MODERN_SOFA = BLOCKS.register("green_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> CYAN_MODERN_SOFA = BLOCKS.register("cyan_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_SOFA = BLOCKS.register("light_blue_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> BLUE_MODERN_SOFA = BLOCKS.register("blue_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> PURPLE_MODERN_SOFA = BLOCKS.register("purple_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_SOFA = BLOCKS.register("magenta_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> PINK_MODERN_SOFA = BLOCKS.register("pink_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));

    // Television Stands
    public static final DeferredBlock<Block> WHITE_TELEVISION_STAND = BLOCKS.register("white_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TELEVISION_STAND = BLOCKS.register("light_gray_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_TELEVISION_STAND = BLOCKS.register("gray_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_TELEVISION_STAND = BLOCKS.register("black_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_TELEVISION_STAND = BLOCKS.register("brown_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_TELEVISION_STAND = BLOCKS.register("red_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_TELEVISION_STAND = BLOCKS.register("orange_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_TELEVISION_STAND = BLOCKS.register("beige_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_TELEVISION_STAND = BLOCKS.register("yellow_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_TELEVISION_STAND = BLOCKS.register("lime_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_TELEVISION_STAND = BLOCKS.register("green_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_TELEVISION_STAND = BLOCKS.register("cyan_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TELEVISION_STAND = BLOCKS.register("light_blue_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_TELEVISION_STAND = BLOCKS.register("blue_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_TELEVISION_STAND = BLOCKS.register("purple_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_TELEVISION_STAND = BLOCKS.register("magenta_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_TELEVISION_STAND = BLOCKS.register("pink_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Lamps
    public static final DeferredBlock<Block> WHITE_LAMP = BLOCKS.register("white_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> LIGHT_GRAY_LAMP = BLOCKS.register("light_gray_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> GRAY_LAMP = BLOCKS.register("gray_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> BLACK_LAMP = BLOCKS.register("black_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> BROWN_LAMP = BLOCKS.register("brown_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> RED_LAMP = BLOCKS.register("red_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> ORANGE_LAMP = BLOCKS.register("orange_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> BEIGE_LAMP = BLOCKS.register("beige_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> YELLOW_LAMP = BLOCKS.register("yellow_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> LIME_LAMP = BLOCKS.register("lime_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> GREEN_LAMP = BLOCKS.register("green_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> CYAN_LAMP = BLOCKS.register("cyan_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> LIGHT_BLUE_LAMP = BLOCKS.register("light_blue_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> BLUE_LAMP = BLOCKS.register("blue_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> PURPLE_LAMP = BLOCKS.register("purple_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> MAGENTA_LAMP = BLOCKS.register("magenta_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL).lightLevel(getLightValueLit(15))));
    public static final DeferredBlock<Block> PINK_LAMP = BLOCKS.register("pink_lamp",
            () -> new LampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL).lightLevel(getLightValueLit(15))));

    // Modern Kitchen Counters
    public static final DeferredBlock<Block> WHITE_MODERN_KITCHEN_COUNTER = BLOCKS.register("white_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_KITCHEN_COUNTER = BLOCKS.register("light_gray_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_MODERN_KITCHEN_COUNTER = BLOCKS.register("gray_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_MODERN_KITCHEN_COUNTER = BLOCKS.register("black_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_MODERN_KITCHEN_COUNTER = BLOCKS.register("brown_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_MODERN_KITCHEN_COUNTER = BLOCKS.register("red_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_MODERN_KITCHEN_COUNTER = BLOCKS.register("orange_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_MODERN_KITCHEN_COUNTER = BLOCKS.register("beige_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_MODERN_KITCHEN_COUNTER = BLOCKS.register("yellow_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_MODERN_KITCHEN_COUNTER = BLOCKS.register("lime_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_MODERN_KITCHEN_COUNTER = BLOCKS.register("green_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_MODERN_KITCHEN_COUNTER = BLOCKS.register("cyan_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_KITCHEN_COUNTER = BLOCKS.register("light_blue_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_MODERN_KITCHEN_COUNTER = BLOCKS.register("blue_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_MODERN_KITCHEN_COUNTER = BLOCKS.register("purple_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_KITCHEN_COUNTER = BLOCKS.register("magenta_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_MODERN_KITCHEN_COUNTER = BLOCKS.register("pink_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Modern Kitchen Drawers
    public static final DeferredBlock<Block> WHITE_MODERN_KITCHEN_DRAWER = BLOCKS.register("white_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_KITCHEN_DRAWER = BLOCKS.register("light_gray_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_MODERN_KITCHEN_DRAWER = BLOCKS.register("gray_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_MODERN_KITCHEN_DRAWER = BLOCKS.register("black_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_MODERN_KITCHEN_DRAWER = BLOCKS.register("brown_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_MODERN_KITCHEN_DRAWER = BLOCKS.register("red_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_MODERN_KITCHEN_DRAWER = BLOCKS.register("orange_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_MODERN_KITCHEN_DRAWER = BLOCKS.register("beige_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_MODERN_KITCHEN_DRAWER = BLOCKS.register("yellow_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_MODERN_KITCHEN_DRAWER = BLOCKS.register("lime_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_MODERN_KITCHEN_DRAWER = BLOCKS.register("green_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_MODERN_KITCHEN_DRAWER = BLOCKS.register("cyan_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_KITCHEN_DRAWER = BLOCKS.register("light_blue_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_MODERN_KITCHEN_DRAWER = BLOCKS.register("blue_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_MODERN_KITCHEN_DRAWER = BLOCKS.register("purple_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_MODERN_KITCHEN_DRAWER = BLOCKS.register("magenta_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_MODERN_KITCHEN_DRAWER = BLOCKS.register("pink_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Modern Kitchen Sinks
    public static final DeferredBlock<Block> WHITE_MODERN_KITCHEN_SINK = BLOCKS.register("white_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE), false));
    public static final DeferredBlock<Block> LIGHT_GRAY_MODERN_KITCHEN_SINK = BLOCKS.register("light_gray_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE), false));
    public static final DeferredBlock<Block> GRAY_MODERN_KITCHEN_SINK = BLOCKS.register("gray_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE), false));
    public static final DeferredBlock<Block> BLACK_MODERN_KITCHEN_SINK = BLOCKS.register("black_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE), false));
    public static final DeferredBlock<Block> BROWN_MODERN_KITCHEN_SINK = BLOCKS.register("brown_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE), false));
    public static final DeferredBlock<Block> RED_MODERN_KITCHEN_SINK = BLOCKS.register("red_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE), false));
    public static final DeferredBlock<Block> ORANGE_MODERN_KITCHEN_SINK = BLOCKS.register("orange_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE), false));
    public static final DeferredBlock<Block> BEIGE_MODERN_KITCHEN_SINK = BLOCKS.register("beige_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), false));
    public static final DeferredBlock<Block> YELLOW_MODERN_KITCHEN_SINK = BLOCKS.register("yellow_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE), false));
    public static final DeferredBlock<Block> LIME_MODERN_KITCHEN_SINK = BLOCKS.register("lime_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE), false));
    public static final DeferredBlock<Block> GREEN_MODERN_KITCHEN_SINK = BLOCKS.register("green_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE), false));
    public static final DeferredBlock<Block> CYAN_MODERN_KITCHEN_SINK = BLOCKS.register("cyan_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE), false));
    public static final DeferredBlock<Block> LIGHT_BLUE_MODERN_KITCHEN_SINK = BLOCKS.register("light_blue_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE), false));
    public static final DeferredBlock<Block> BLUE_MODERN_KITCHEN_SINK = BLOCKS.register("blue_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE), false));
    public static final DeferredBlock<Block> PURPLE_MODERN_KITCHEN_SINK = BLOCKS.register("purple_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE), false));
    public static final DeferredBlock<Block> MAGENTA_MODERN_KITCHEN_SINK = BLOCKS.register("magenta_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE), false));
    public static final DeferredBlock<Block> PINK_MODERN_KITCHEN_SINK = BLOCKS.register("pink_modern_kitchen_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE), false));

    // Bar Stools
    public static final DeferredBlock<Block> WHITE_BAR_STOOL = BLOCKS.register("white_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_BAR_STOOL = BLOCKS.register("light_gray_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_BAR_STOOL = BLOCKS.register("gray_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_BAR_STOOL = BLOCKS.register("black_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_BAR_STOOL = BLOCKS.register("brown_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_BAR_STOOL = BLOCKS.register("red_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_BAR_STOOL = BLOCKS.register("orange_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_BAR_STOOL = BLOCKS.register("beige_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_BAR_STOOL = BLOCKS.register("yellow_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_BAR_STOOL = BLOCKS.register("lime_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_BAR_STOOL = BLOCKS.register("green_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_BAR_STOOL = BLOCKS.register("cyan_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_BAR_STOOL = BLOCKS.register("light_blue_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_BAR_STOOL = BLOCKS.register("blue_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_BAR_STOOL = BLOCKS.register("purple_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_BAR_STOOL = BLOCKS.register("magenta_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_BAR_STOOL = BLOCKS.register("pink_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Chopping Boards
    public static final DeferredBlock<Block> OAK_CHOPPING_BOARD = BLOCKS.register("oak_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SPRUCE_CHOPPING_BOARD = BLOCKS.register("spruce_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS)));
    public static final DeferredBlock<Block> BIRCH_CHOPPING_BOARD = BLOCKS.register("birch_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS)));
    public static final DeferredBlock<Block> JUNGLE_CHOPPING_BOARD = BLOCKS.register("jungle_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS)));
    public static final DeferredBlock<Block> ACACIA_CHOPPING_BOARD = BLOCKS.register("acacia_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));
    public static final DeferredBlock<Block> DARK_OAK_CHOPPING_BOARD = BLOCKS.register("dark_oak_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS)));
    public static final DeferredBlock<Block> MANGROVE_CHOPPING_BOARD = BLOCKS.register("mangrove_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS)));
    public static final DeferredBlock<Block> CHERRY_CHOPPING_BOARD = BLOCKS.register("cherry_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final DeferredBlock<Block> CRIMSON_CHOPPING_BOARD = BLOCKS.register("crimson_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS)));
    public static final DeferredBlock<Block> WARPED_CHOPPING_BOARD = BLOCKS.register("warped_chopping_board",
            () -> new ChoppingBoardBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS)));

    // Door Bells
    public static final DeferredBlock<Block> OAK_DOOR_BELL = BLOCKS.register("oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_DOOR_BELL = BLOCKS.register("spruce_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_DOOR_BELL = BLOCKS.register("birch_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_DOOR_BELL = BLOCKS.register("jungle_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_DOOR_BELL = BLOCKS.register("acacia_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_DOOR_BELL = BLOCKS.register("dark_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_DOOR_BELL = BLOCKS.register("mangrove_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_DOOR_BELL = BLOCKS.register("cherry_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_DOOR_BELL = BLOCKS.register("crimson_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_DOOR_BELL = BLOCKS.register("warped_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_OAK_DOOR_BELL = BLOCKS.register("stripped_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_SPRUCE_DOOR_BELL = BLOCKS.register("stripped_spruce_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_BIRCH_DOOR_BELL = BLOCKS.register("stripped_birch_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_JUNGLE_DOOR_BELL = BLOCKS.register("stripped_jungle_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_ACACIA_DOOR_BELL = BLOCKS.register("stripped_acacia_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_DARK_OAK_DOOR_BELL = BLOCKS.register("stripped_dark_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_MANGROVE_DOOR_BELL = BLOCKS.register("stripped_mangrove_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_CHERRY_DOOR_BELL = BLOCKS.register("stripped_cherry_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_CRIMSON_DOOR_BELL = BLOCKS.register("stripped_crimson_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_PLANKS).noOcclusion()));
    public static final DeferredBlock<Block> STRIPPED_WARPED_DOOR_BELL = BLOCKS.register("stripped_warped_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS).noOcclusion()));

    // Inflatable Castles
    public static final DeferredBlock<Block> WHITE_INFLATABLE_CASTLE = BLOCKS.register("white_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));
    public static final DeferredBlock<Block> LIGHT_GRAY_INFLATABLE_CASTLE = BLOCKS.register("light_gray_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_WOOL)));
    public static final DeferredBlock<Block> GRAY_INFLATABLE_CASTLE = BLOCKS.register("gray_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_WOOL)));
    public static final DeferredBlock<Block> BLACK_INFLATABLE_CASTLE = BLOCKS.register("black_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_WOOL)));
    public static final DeferredBlock<Block> BROWN_INFLATABLE_CASTLE = BLOCKS.register("brown_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_WOOL)));
    public static final DeferredBlock<Block> RED_INFLATABLE_CASTLE = BLOCKS.register("red_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_WOOL)));
    public static final DeferredBlock<Block> ORANGE_INFLATABLE_CASTLE = BLOCKS.register("orange_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL)));
    public static final DeferredBlock<Block> BEIGE_INFLATABLE_CASTLE = BLOCKS.register("beige_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> YELLOW_INFLATABLE_CASTLE = BLOCKS.register("yellow_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_WOOL)));
    public static final DeferredBlock<Block> LIME_INFLATABLE_CASTLE = BLOCKS.register("lime_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_WOOL)));
    public static final DeferredBlock<Block> GREEN_INFLATABLE_CASTLE = BLOCKS.register("green_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_WOOL)));
    public static final DeferredBlock<Block> CYAN_INFLATABLE_CASTLE = BLOCKS.register("cyan_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_WOOL)));
    public static final DeferredBlock<Block> LIGHT_BLUE_INFLATABLE_CASTLE = BLOCKS.register("light_blue_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_WOOL)));
    public static final DeferredBlock<Block> BLUE_INFLATABLE_CASTLE = BLOCKS.register("blue_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_WOOL)));
    public static final DeferredBlock<Block> PURPLE_INFLATABLE_CASTLE = BLOCKS.register("purple_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_WOOL)));
    public static final DeferredBlock<Block> MAGENTA_INFLATABLE_CASTLE = BLOCKS.register("magenta_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_WOOL)));
    public static final DeferredBlock<Block> PINK_INFLATABLE_CASTLE = BLOCKS.register("pink_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_WOOL)));
    public static final DeferredBlock<Block> CASTLE_NETTING = BLOCKS.register("castle_netting",
            () -> new IronBarsBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL)));

    // Kitchenware
    public static final DeferredBlock<Block> COOKIE_JAR = BLOCKS.register("cookie_jar",
            () -> new CookieJarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final DeferredBlock<Block> WHITE_CUP = BLOCKS.register("white_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CUP = BLOCKS.register("light_gray_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> GRAY_CUP = BLOCKS.register("gray_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_STAINED_GLASS)));
    public static final DeferredBlock<Block> BLACK_CUP = BLOCKS.register("black_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_STAINED_GLASS)));
    public static final DeferredBlock<Block> BROWN_CUP = BLOCKS.register("brown_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_STAINED_GLASS)));
    public static final DeferredBlock<Block> RED_CUP = BLOCKS.register("red_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_STAINED_GLASS)));
    public static final DeferredBlock<Block> ORANGE_CUP = BLOCKS.register("orange_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_STAINED_GLASS)));
    public static final DeferredBlock<Block> BEIGE_CUP = BLOCKS.register("beige_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> YELLOW_CUP = BLOCKS.register("yellow_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIME_CUP = BLOCKS.register("lime_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_STAINED_GLASS)));
    public static final DeferredBlock<Block> GREEN_CUP = BLOCKS.register("green_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_STAINED_GLASS)));
    public static final DeferredBlock<Block> CYAN_CUP = BLOCKS.register("cyan_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_STAINED_GLASS)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CUP = BLOCKS.register("light_blue_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> BLUE_CUP = BLOCKS.register("blue_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_STAINED_GLASS)));
    public static final DeferredBlock<Block> PURPLE_CUP = BLOCKS.register("purple_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_STAINED_GLASS)));
    public static final DeferredBlock<Block> MAGENTA_CUP = BLOCKS.register("magenta_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_STAINED_GLASS)));
    public static final DeferredBlock<Block> PINK_CUP = BLOCKS.register("pink_cup",
            () -> new CupBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_STAINED_GLASS)));
    public static final DeferredBlock<Block> PLATE = BLOCKS.register("plate",
            () -> new PlateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_QUARTZ)));

    // Bird Baths
    public static final DeferredBlock<Block> STONE_BIRD_BATH = BLOCKS.register("stone_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
    public static final DeferredBlock<Block> ANDESITE_BIRD_BATH = BLOCKS.register("andesite_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE)));
    public static final DeferredBlock<Block> DIORITE_BIRD_BATH = BLOCKS.register("diorite_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DIORITE)));
    public static final DeferredBlock<Block> GRANITE_BIRD_BATH = BLOCKS.register("granite_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRANITE)));
    public static final DeferredBlock<Block> BLACKSTONE_BIRD_BATH = BLOCKS.register("blackstone_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACKSTONE)));
    public static final DeferredBlock<Block> DEEPSLATE_BIRD_BATH = BLOCKS.register("deepslate_bird_bath",
            () -> new BirdBathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE)));

    /*
    // Water Tanks
    public static final DeferredBlock<Block> OAK_WATER_TANK = BLOCKS.register("oak_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> SPRUCE_WATER_TANK = BLOCKS.register("spruce_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> BIRCH_WATER_TANK = BLOCKS.register("birch_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> JUNGLE_WATER_TANK = BLOCKS.register("jungle_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> ACACIA_WATER_TANK = BLOCKS.register("acacia_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> DARK_OAK_WATER_TANK = BLOCKS.register("dark_oak_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> MANGROVE_WATER_TANK = BLOCKS.register("mangrove_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> CHERRY_WATER_TANK = BLOCKS.register("cherry_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> CRIMSON_WATER_TANK = BLOCKS.register("crimson_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));
    public static final DeferredBlock<Block> WARPED_WATER_TANK = BLOCKS.register("warped_water_tank",
            () -> new WaterTankBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAULDRON).noOcclusion()));

    // Appliances and Electronics
    public static final DeferredBlock<Block> ELECTRIC_FENCE = BLOCKS.register("electric_fence",
            () -> new ElectricFenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ANVIL)));
    public static final DeferredBlock<Block> BATH_LIGHT = BLOCKS.register("bath_light",
            () -> new BathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> BATH_DARK = BLOCKS.register("bath_dark",
            () -> new BathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BIN_LIGHT = BLOCKS.register("bin_light",
            () -> new BinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> BIN_DARK = BLOCKS.register("bin_dark",
            () -> new BinBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> BLENDER_LIGHT = BLOCKS.register("blender_light",
            () -> new BlenderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> BLENDER_DARK = BLOCKS.register("blender_dark",
            () -> new BlenderBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> CATHODE_RAY_TUBE_TELEVISION = BLOCKS.register("cathode_ray_tube_television",
            () -> new CathodeRayTubeTelevisionBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> COMPUTER_LIGHT = BLOCKS.register("computer_light",
            () -> new ComputerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> COMPUTER_DARK = BLOCKS.register("computer_dark",
            () -> new ComputerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredBlock<Block> DISHWASHER_LIGHT = BLOCKS.register("dishwasher_light",
            () -> new DishwasherBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> DISHWASHER_DARK = BLOCKS.register("dishwasher_dark",
            () -> new DishwasherBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> FIRE_ALARM = BLOCKS.register("fire_alarm",
            () -> new FireAlarmBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIQUID_CRYSTAL_DISPLAY_TELEVISION = BLOCKS.register("liquid_crystal_display_television",
            () -> new LiquidCrystalDisplayTelevisionBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> MICROWAVE_LIGHT = BLOCKS.register("microwave_light",
            () -> new MicrowaveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> MICROWAVE_DARK = BLOCKS.register("microwave_dark",
            () -> new MicrowaveBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> OVEN_LIGHT = BLOCKS.register("oven_light",
            () -> new OvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> OVEN_DARK = BLOCKS.register("oven_dark",
            () -> new OvenBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> OVEN_RANGE_HOOD_LIGHT = BLOCKS.register("oven_range_hood_light",
            () -> new OvenRangeHoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).lightLevel(getLightValueLit(14)).noOcclusion()));
    public static final DeferredBlock<Block> OVEN_RANGE_HOOD_DARK = BLOCKS.register("oven_range_hood_dark",
            () -> new OvenRangeHoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).lightLevel(getLightValueLit(14)).noOcclusion()));
    public static final DeferredBlock<Block> PRINTER = BLOCKS.register("printer",
            () -> new PrinterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> SINK_LIGHT = BLOCKS.register("sink_light",
            () -> new SinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> SINK_DARK = BLOCKS.register("sink_dark",
            () -> new SinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> SHOWER_LIGHT = BLOCKS.register("shower_light",
            () -> new ShowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> SHOWER_DARK = BLOCKS.register("shower_dark",
            () -> new ShowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> SHOWER_HEAD_LIGHT = BLOCKS.register("shower_head_light",
            () -> new ShowerHeadBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> SHOWER_HEAD_DARK = BLOCKS.register("shower_head_dark",
            () -> new ShowerHeadBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> STEREO = BLOCKS.register("stereo",
            () -> new StereoBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> TOASTER_LIGHT = BLOCKS.register("toaster_light",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> TOASTER_DARK = BLOCKS.register("toaster_dark",
            () -> new ToasterBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> TOILET_LIGHT = BLOCKS.register("toilet_light",
            () -> new ToiletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> TOILET_DARK = BLOCKS.register("toilet_dark",
            () -> new ToiletBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> WASHING_MACHINE_LIGHT = BLOCKS.register("washing_machine_light",
            () -> new WashingMachineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final DeferredBlock<Block> WASHING_MACHINE_DARK = BLOCKS.register("washing_machine_dark",
            () -> new WashingMachineBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE).noOcclusion()));

    // Digital Clocks
    public static final DeferredBlock<Block> WHITE_DIGITAL_CLOCK = BLOCKS.register("white_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_GRAY_DIGITAL_CLOCK = BLOCKS.register("light_gray_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final DeferredBlock<Block> GRAY_DIGITAL_CLOCK = BLOCKS.register("gray_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_CONCRETE)));
    public static final DeferredBlock<Block> BLACK_DIGITAL_CLOCK = BLOCKS.register("black_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_CONCRETE)));
    public static final DeferredBlock<Block> BROWN_DIGITAL_CLOCK = BLOCKS.register("brown_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_CONCRETE)));
    public static final DeferredBlock<Block> RED_DIGITAL_CLOCK = BLOCKS.register("red_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.RED_CONCRETE)));
    public static final DeferredBlock<Block> ORANGE_DIGITAL_CLOCK = BLOCKS.register("orange_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_CONCRETE)));
    public static final DeferredBlock<Block> BEIGE_DIGITAL_CLOCK = BLOCKS.register("beige_digital_clock",
            () -> new YogDigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> YELLOW_DIGITAL_CLOCK = BLOCKS.register("yellow_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_CONCRETE)));
    public static final DeferredBlock<Block> LIME_DIGITAL_CLOCK = BLOCKS.register("lime_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_CONCRETE)));
    public static final DeferredBlock<Block> GREEN_DIGITAL_CLOCK = BLOCKS.register("green_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_CONCRETE)));
    public static final DeferredBlock<Block> CYAN_DIGITAL_CLOCK = BLOCKS.register("cyan_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_CONCRETE)));
    public static final DeferredBlock<Block> LIGHT_BLUE_DIGITAL_CLOCK = BLOCKS.register("light_blue_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final DeferredBlock<Block> BLUE_DIGITAL_CLOCK = BLOCKS.register("blue_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_CONCRETE)));
    public static final DeferredBlock<Block> PURPLE_DIGITAL_CLOCK = BLOCKS.register("purple_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_CONCRETE)));
    public static final DeferredBlock<Block> MAGENTA_DIGITAL_CLOCK = BLOCKS.register("magenta_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_CONCRETE)));
    public static final DeferredBlock<Block> PINK_DIGITAL_CLOCK = BLOCKS.register("pink_digital_clock",
            () -> new DigitalClockBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_CONCRETE)));

    // Festive Blocks
    public static final DeferredBlock<Block> CANDLE = BLOCKS.register("candle",
            () -> new CandleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_CONCRETE).lightLevel(getLightValueLit(13)).noOcclusion()));
    public static final DeferredBlock<Block> CHRISTMAS_TREE = BLOCKS.register("christmas_tree",
            () -> new ChristmasTreeBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES).noOcclusion()));
    public static final DeferredBlock<Block> WREATH = BLOCKS.register("wreath",
            () -> new WreathBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES).noOcclusion()));

    // Fluids
    public static final DeferredBlock<LiquidBlock> SOAPY_WATER = BLOCKS.register("soapy_water",
            () -> new LiquidBlock(ModFluids.SOAPY_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));
    public static final DeferredBlock<LiquidBlock> SUPER_SOAPY_WATER = BLOCKS.register("super_soapy_water",
            () -> new LiquidBlock(ModFluids.SUPER_SOAPY_WATER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)));

     */

    // Methods
    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

}
