package com.nosiphus.furniture.world.level.block;

import com.mrcrayfish.furniture.world.level.block.ChairBlock;
import com.mrcrayfish.furniture.world.level.block.CoffeeTableBlock;
import com.mrcrayfish.furniture.world.level.block.TableBlock;
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

}
