package com.nosiphus.furniture.core;

import com.mrcrayfish.furniture.block.*;
import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.block.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "nfm");

    //Tables
    public static final RegistryObject<Block> TABLE_STONE = BLOCKS.register("stone_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> TABLE_ANDESITE = BLOCKS.register("andesite_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
    public static final RegistryObject<Block> TABLE_DIORITE = BLOCKS.register("diorite_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> TABLE_GRANITE = BLOCKS.register("granite_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final RegistryObject<Block> TABLE_BLACKSTONE = BLOCKS.register("blackstone_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
    public static final RegistryObject<Block> TABLE_DEEPSLATE = BLOCKS.register("deepslate_table",
            () -> new TableBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> TABLE_WHITE_MODERN = BLOCKS.register("white_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_ORANGE_MODERN = BLOCKS.register("orange_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_MAGENTA_MODERN = BLOCKS.register("magenta_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_YELLOW_MODERN = BLOCKS.register("yellow_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIME_MODERN = BLOCKS.register("lime_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> TABLE_PINK_MODERN = BLOCKS.register("pink_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> TABLE_GRAY_MODERN = BLOCKS.register("gray_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> TABLE_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> TABLE_CYAN_MODERN = BLOCKS.register("cyan_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_PURPLE_MODERN = BLOCKS.register("purple_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BLUE_MODERN = BLOCKS.register("blue_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BROWN_MODERN = BLOCKS.register("brown_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_GREEN_MODERN = BLOCKS.register("green_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> TABLE_RED_MODERN = BLOCKS.register("red_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> TABLE_BLACK_MODERN = BLOCKS.register("black_modern_table",
            () -> new ModernTableBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Chairs
    public static final RegistryObject<Block> CHAIR_STONE = BLOCKS.register("stone_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> CHAIR_ANDESITE = BLOCKS.register("andesite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
    public static final RegistryObject<Block> CHAIR_DIORITE = BLOCKS.register("diorite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> CHAIR_GRANITE = BLOCKS.register("granite_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final RegistryObject<Block> CHAIR_BLACKSTONE = BLOCKS.register("blackstone_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
    public static final RegistryObject<Block> CHAIR_DEEPSLATE = BLOCKS.register("deepslate_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> CHAIR_WHITE_MODERN = BLOCKS.register("white_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_ORANGE_MODERN = BLOCKS.register("orange_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_MAGENTA_MODERN = BLOCKS.register("magenta_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_YELLOW_MODERN = BLOCKS.register("yellow_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIME_MODERN = BLOCKS.register("lime_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_PINK_MODERN = BLOCKS.register("pink_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_GRAY_MODERN = BLOCKS.register("gray_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_CYAN_MODERN = BLOCKS.register("cyan_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_PURPLE_MODERN = BLOCKS.register("purple_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BLUE_MODERN = BLOCKS.register("blue_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BROWN_MODERN = BLOCKS.register("brown_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_GREEN_MODERN = BLOCKS.register("green_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_RED_MODERN = BLOCKS.register("red_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BLACK_MODERN = BLOCKS.register("black_modern_chair",
            () -> new ModernChairBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Office Chairs
    public static final RegistryObject<Block> CHAIR_WHITE_OFFICE = BLOCKS.register("white_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_ORANGE_OFFICE = BLOCKS.register("orange_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_MAGENTA_OFFICE = BLOCKS.register("magenta_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIGHT_BLUE_OFFICE = BLOCKS.register("light_blue_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_YELLOW_OFFICE = BLOCKS.register("yellow_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIME_OFFICE = BLOCKS.register("lime_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_PINK_OFFICE = BLOCKS.register("pink_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_GRAY_OFFICE = BLOCKS.register("gray_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_LIGHT_GRAY_OFFICE = BLOCKS.register("light_gray_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_CYAN_OFFICE = BLOCKS.register("cyan_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_PURPLE_OFFICE = BLOCKS.register("purple_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BLUE_OFFICE = BLOCKS.register("blue_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BROWN_OFFICE = BLOCKS.register("brown_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_GREEN_OFFICE = BLOCKS.register("green_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_RED_OFFICE = BLOCKS.register("red_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> CHAIR_BLACK_OFFICE = BLOCKS.register("black_office_chair",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Coffee Tables
    public static final RegistryObject<Block> COFFEE_TABLE_STONE = BLOCKS.register("stone_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> COFFEE_TABLE_ANDESITE = BLOCKS.register("andesite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
    public static final RegistryObject<Block> COFFEE_TABLE_DIORITE = BLOCKS.register("diorite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> COFFEE_TABLE_GRANITE = BLOCKS.register("granite_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BLACKSTONE = BLOCKS.register("blackstone_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
    public static final RegistryObject<Block> COFFEE_TABLE_DEEPSLATE = BLOCKS.register("deepslate_coffee_table",
            () -> new CoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> COFFEE_TABLE_WHITE_MODERN = BLOCKS.register("white_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_ORANGE_MODERN = BLOCKS.register("orange_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_MAGENTA_MODERN = BLOCKS.register("magenta_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_YELLOW_MODERN = BLOCKS.register("yellow_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIME_MODERN = BLOCKS.register("lime_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_PINK_MODERN = BLOCKS.register("pink_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_GRAY_MODERN = BLOCKS.register("gray_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_CYAN_MODERN = BLOCKS.register("cyan_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_PURPLE_MODERN = BLOCKS.register("purple_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BLUE_MODERN = BLOCKS.register("blue_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BROWN_MODERN = BLOCKS.register("brown_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_GREEN_MODERN = BLOCKS.register("green_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_RED_MODERN = BLOCKS.register("red_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> COFFEE_TABLE_BLACK_MODERN = BLOCKS.register("black_modern_coffee_table",
            () -> new ModernCoffeeTableBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Cabinets
    public static final RegistryObject<Block> CABINET_STONE = BLOCKS.register("stone_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> CABINET_ANDESITE = BLOCKS.register("andesite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
    public static final RegistryObject<Block> CABINET_DIORITE = BLOCKS.register("diorite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> CABINET_GRANITE = BLOCKS.register("granite_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final RegistryObject<Block> CABINET_BLACKSTONE = BLOCKS.register("blackstone_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
    public static final RegistryObject<Block> CABINET_DEEPSLATE = BLOCKS.register("deepslate_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> CABINET_WHITE_MODERN = BLOCKS.register("white_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_ORANGE_MODERN = BLOCKS.register("orange_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_MAGENTA_MODERN = BLOCKS.register("magenta_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_YELLOW_MODERN = BLOCKS.register("yellow_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIME_MODERN = BLOCKS.register("lime_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> CABINET_PINK_MODERN = BLOCKS.register("pink_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> CABINET_GRAY_MODERN = BLOCKS.register("gray_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> CABINET_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> CABINET_CYAN_MODERN = BLOCKS.register("cyan_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_PURPLE_MODERN = BLOCKS.register("purple_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BLUE_MODERN = BLOCKS.register("blue_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BROWN_MODERN = BLOCKS.register("brown_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_GREEN_MODERN = BLOCKS.register("green_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> CABINET_RED_MODERN = BLOCKS.register("red_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> CABINET_BLACK_MODERN = BLOCKS.register("black_modern_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Bedside Cabinets
    public static final RegistryObject<Block> BEDSIDE_CABINET_STONE = BLOCKS.register("stone_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_ANDESITE = BLOCKS.register("andesite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_DIORITE = BLOCKS.register("diorite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_GRANITE = BLOCKS.register("granite_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_BLACKSTONE = BLOCKS.register("blackstone_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_DEEPSLATE = BLOCKS.register("deepslate_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_WHITE_MODERN = BLOCKS.register("white_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_ORANGE_MODERN = BLOCKS.register("orange_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_MAGENTA_MODERN = BLOCKS.register("magenta_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_YELLOW_MODERN = BLOCKS.register("yellow_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_LIME_MODERN = BLOCKS.register("lime_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_PINK_MODERN = BLOCKS.register("pink_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_GRAY_MODERN = BLOCKS.register("gray_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_CYAN_MODERN = BLOCKS.register("cyan_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_PURPLE_MODERN = BLOCKS.register("purple_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_BLUE_MODERN = BLOCKS.register("blue_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_BROWN_MODERN = BLOCKS.register("brown_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_GREEN_MODERN = BLOCKS.register("green_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_RED_MODERN = BLOCKS.register("red_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> BEDSIDE_CABINET_BLACK_MODERN = BLOCKS.register("black_modern_bedside_cabinet",
            () -> new BedsideCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Desk
    public static final RegistryObject<Block> DESK_STONE = BLOCKS.register("stone_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.STONE), DeskBlock.MaterialType.STONE));
    public static final RegistryObject<Block> DESK_ANDESITE = BLOCKS.register("andesite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE), DeskBlock.MaterialType.ANDESITE));
    public static final RegistryObject<Block> DESK_DIORITE = BLOCKS.register("diorite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE), DeskBlock.MaterialType.DIORITE));
    public static final RegistryObject<Block> DESK_GRANITE = BLOCKS.register("granite_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE), DeskBlock.MaterialType.GRANITE));
    public static final RegistryObject<Block> DESK_BLACKSTONE = BLOCKS.register("blackstone_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE), DeskBlock.MaterialType.STONE));
    public static final RegistryObject<Block> DESK_DEEPSLATE = BLOCKS.register("deepslate_desk",
            () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE), DeskBlock.MaterialType.STONE));
    public static final RegistryObject<Block> DESK_WHITE_MODERN = BLOCKS.register("white_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE), ModernDeskBlock.MaterialType.WHITE_CONCRETE));
    public static final RegistryObject<Block> DESK_ORANGE_MODERN = BLOCKS.register("orange_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE), ModernDeskBlock.MaterialType.ORANGE_CONCRETE));
    public static final RegistryObject<Block> DESK_MAGENTA_MODERN = BLOCKS.register("magenta_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE), ModernDeskBlock.MaterialType.MAGENTA_CONCRETE));
    public static final RegistryObject<Block> DESK_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE), ModernDeskBlock.MaterialType.LIGHT_BLUE_CONCRETE));
    public static final RegistryObject<Block> DESK_YELLOW_MODERN = BLOCKS.register("yellow_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE), ModernDeskBlock.MaterialType.YELLOW_CONCRETE));
    public static final RegistryObject<Block> DESK_LIME_MODERN = BLOCKS.register("lime_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE), ModernDeskBlock.MaterialType.LIME_CONCRETE));
    public static final RegistryObject<Block> DESK_PINK_MODERN = BLOCKS.register("pink_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE), ModernDeskBlock.MaterialType.PINK_CONCRETE));
    public static final RegistryObject<Block> DESK_GRAY_MODERN = BLOCKS.register("gray_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE), ModernDeskBlock.MaterialType.GRAY_CONCRETE));
    public static final RegistryObject<Block> DESK_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE), ModernDeskBlock.MaterialType.LIGHT_GRAY_CONCRETE));
    public static final RegistryObject<Block> DESK_CYAN_MODERN = BLOCKS.register("cyan_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE), ModernDeskBlock.MaterialType.CYAN_CONCRETE));
    public static final RegistryObject<Block> DESK_PURPLE_MODERN = BLOCKS.register("purple_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE), ModernDeskBlock.MaterialType.PURPLE_CONCRETE));
    public static final RegistryObject<Block> DESK_BLUE_MODERN = BLOCKS.register("blue_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE), ModernDeskBlock.MaterialType.BLUE_CONCRETE));
    public static final RegistryObject<Block> DESK_BROWN_MODERN = BLOCKS.register("brown_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE), ModernDeskBlock.MaterialType.BROWN_CONCRETE));
    public static final RegistryObject<Block> DESK_GREEN_MODERN = BLOCKS.register("green_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE), ModernDeskBlock.MaterialType.GREEN_CONCRETE));
    public static final RegistryObject<Block> DESK_RED_MODERN = BLOCKS.register("red_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE), ModernDeskBlock.MaterialType.RED_CONCRETE));
    public static final RegistryObject<Block> DESK_BLACK_MODERN = BLOCKS.register("black_modern_desk",
            () -> new ModernDeskBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE), ModernDeskBlock.MaterialType.BLACK_CONCRETE));

    //Desk Cabinets
    public static final RegistryObject<Block> DESK_CABINET_STONE = BLOCKS.register("stone_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.STONE), DeskBlock.MaterialType.STONE));
    public static final RegistryObject<Block> DESK_CABINET_ANDESITE = BLOCKS.register("andesite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE), DeskBlock.MaterialType.ANDESITE));
    public static final RegistryObject<Block> DESK_CABINET_DIORITE = BLOCKS.register("diorite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE), DeskBlock.MaterialType.DIORITE));
    public static final RegistryObject<Block> DESK_CABINET_GRANITE = BLOCKS.register("granite_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE), DeskBlock.MaterialType.GRANITE));
    public static final RegistryObject<Block> DESK_CABINET_BLACKSTONE = BLOCKS.register("blackstone_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLACKSTONE), DeskBlock.MaterialType.STONE));
    public static final RegistryObject<Block> DESK_CABINET_DEEPSLATE = BLOCKS.register("deepslate_desk_cabinet",
            () -> new DeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE), DeskBlock.MaterialType.STONE));
    public static final RegistryObject<Block> DESK_CABINET_WHITE_MODERN = BLOCKS.register("white_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE), ModernDeskBlock.MaterialType.WHITE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_ORANGE_MODERN = BLOCKS.register("orange_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE), ModernDeskBlock.MaterialType.ORANGE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_MAGENTA_MODERN = BLOCKS.register("magenta_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE), ModernDeskBlock.MaterialType.MAGENTA_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE), ModernDeskBlock.MaterialType.LIGHT_BLUE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_YELLOW_MODERN = BLOCKS.register("yellow_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE), ModernDeskBlock.MaterialType.YELLOW_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_LIME_MODERN = BLOCKS.register("lime_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE), ModernDeskBlock.MaterialType.LIME_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_PINK_MODERN = BLOCKS.register("pink_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE), ModernDeskBlock.MaterialType.PINK_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_GRAY_MODERN = BLOCKS.register("gray_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE), ModernDeskBlock.MaterialType.GRAY_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE), ModernDeskBlock.MaterialType.LIGHT_GRAY_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_CYAN_MODERN = BLOCKS.register("cyan_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE), ModernDeskBlock.MaterialType.CYAN_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_PURPLE_MODERN = BLOCKS.register("purple_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE), ModernDeskBlock.MaterialType.PURPLE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_BLUE_MODERN = BLOCKS.register("blue_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE), ModernDeskBlock.MaterialType.BLUE_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_BROWN_MODERN = BLOCKS.register("brown_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE), ModernDeskBlock.MaterialType.BROWN_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_GREEN_MODERN = BLOCKS.register("green_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE), ModernDeskBlock.MaterialType.GREEN_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_RED_MODERN = BLOCKS.register("red_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE), ModernDeskBlock.MaterialType.RED_CONCRETE));
    public static final RegistryObject<Block> DESK_CABINET_BLACK_MODERN = BLOCKS.register("black_modern_desk_cabinet",
            () -> new ModernDeskCabinetBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE), ModernDeskBlock.MaterialType.BLACK_CONCRETE));

    //Sofas
    public static final RegistryObject<Block> SOFA_WHITE_MODERN = BLOCKS.register("white_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> SOFA_ORANGE_MODERN = BLOCKS.register("orange_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> SOFA_MAGENTA_MODERN = BLOCKS.register("magenta_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> SOFA_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> SOFA_YELLOW_MODERN = BLOCKS.register("yellow_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> SOFA_LIME_MODERN = BLOCKS.register("lime_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> SOFA_PINK_MODERN = BLOCKS.register("pink_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> SOFA_GRAY_MODERN = BLOCKS.register("gray_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> SOFA_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> SOFA_CYAN_MODERN = BLOCKS.register("cyan_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> SOFA_PURPLE_MODERN = BLOCKS.register("purple_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> SOFA_BLUE_MODERN = BLOCKS.register("blue_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> SOFA_BROWN_MODERN = BLOCKS.register("brown_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> SOFA_GREEN_MODERN = BLOCKS.register("green_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> SOFA_RED_MODERN = BLOCKS.register("red_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> SOFA_BLACK_MODERN = BLOCKS.register("black_modern_sofa",
            () -> new ModernSofaBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Television Stands
    public static final RegistryObject<Block> TELEVISION_STAND_WHITE = BLOCKS.register("white_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_ORANGE = BLOCKS.register("orange_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_MAGENTA = BLOCKS.register("magenta_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_LIGHT_BLUE = BLOCKS.register("light_blue_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_YELLOW = BLOCKS.register("yellow_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_LIME = BLOCKS.register("lime_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_PINK = BLOCKS.register("pink_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_GRAY = BLOCKS.register("gray_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_LIGHT_GRAY = BLOCKS.register("light_gray_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_CYAN = BLOCKS.register("cyan_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_PURPLE = BLOCKS.register("purple_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_BLUE = BLOCKS.register("blue_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_BROWN = BLOCKS.register("brown_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_GREEN = BLOCKS.register("green_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_RED = BLOCKS.register("red_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> TELEVISION_STAND_BLACK = BLOCKS.register("black_television_stand",
            () -> new TelevisionStandBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Kitchen Counters
    public static final RegistryObject<Block> KITCHEN_COUNTER_WHITE_MODERN = BLOCKS.register("white_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_ORANGE_MODERN = BLOCKS.register("orange_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_MAGENTA_MODERN = BLOCKS.register("magenta_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_YELLOW_MODERN = BLOCKS.register("yellow_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_LIME_MODERN = BLOCKS.register("lime_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_PINK_MODERN = BLOCKS.register("pink_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_GRAY_MODERN = BLOCKS.register("gray_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_CYAN_MODERN = BLOCKS.register("cyan_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_PURPLE_MODERN = BLOCKS.register("purple_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_BLUE_MODERN = BLOCKS.register("blue_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_BROWN_MODERN = BLOCKS.register("brown_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_GREEN_MODERN = BLOCKS.register("green_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_RED_MODERN = BLOCKS.register("red_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_COUNTER_BLACK_MODERN = BLOCKS.register("black_modern_kitchen_counter",
            () -> new KitchenCounterBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Kitchen Drawers
    public static final RegistryObject<Block> KITCHEN_DRAWER_WHITE_MODERN = BLOCKS.register("white_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_ORANGE_MODERN = BLOCKS.register("orange_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_MAGENTA_MODERN = BLOCKS.register("magenta_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_YELLOW_MODERN = BLOCKS.register("yellow_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_LIME_MODERN = BLOCKS.register("lime_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_PINK_MODERN = BLOCKS.register("pink_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_GRAY_MODERN = BLOCKS.register("gray_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_CYAN_MODERN = BLOCKS.register("cyan_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_PURPLE_MODERN = BLOCKS.register("purple_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_BLUE_MODERN = BLOCKS.register("blue_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_BROWN_MODERN = BLOCKS.register("brown_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_GREEN_MODERN = BLOCKS.register("green_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_RED_MODERN = BLOCKS.register("red_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> KITCHEN_DRAWER_BLACK_MODERN = BLOCKS.register("black_modern_kitchen_drawer",
            () -> new KitchenDrawerBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Kitchen Sinks
    public static final RegistryObject<Block> KITCHEN_SINK_WHITE_MODERN = BLOCKS.register("white_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_ORANGE_MODERN = BLOCKS.register("orange_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_MAGENTA_MODERN = BLOCKS.register("magenta_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_LIGHT_BLUE_MODERN = BLOCKS.register("light_blue_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_YELLOW_MODERN = BLOCKS.register("yellow_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_LIME_MODERN = BLOCKS.register("lime_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_PINK_MODERN = BLOCKS.register("pink_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_GRAY_MODERN = BLOCKS.register("gray_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_LIGHT_GRAY_MODERN = BLOCKS.register("light_gray_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_CYAN_MODERN = BLOCKS.register("cyan_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_PURPLE_MODERN = BLOCKS.register("purple_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_BLUE_MODERN = BLOCKS.register("blue_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_BROWN_MODERN = BLOCKS.register("brown_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_GREEN_MODERN = BLOCKS.register("green_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_RED_MODERN = BLOCKS.register("red_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE), false));
    public static final RegistryObject<Block> KITCHEN_SINK_BLACK_MODERN = BLOCKS.register("black_modern_kitchen_sink",
            () -> new ModernKitchenSinkBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE), false));

    //Bar Stools
    public static final RegistryObject<Block> BAR_STOOL_WHITE = BLOCKS.register("white_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_ORANGE = BLOCKS.register("orange_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_MAGENTA = BLOCKS.register("magenta_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_LIGHT_BLUE = BLOCKS.register("light_blue_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_YELLOW = BLOCKS.register("yellow_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_LIME = BLOCKS.register("lime_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_PINK = BLOCKS.register("pink_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_GRAY = BLOCKS.register("gray_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_LIGHT_GRAY = BLOCKS.register("light_gray_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_CYAN = BLOCKS.register("cyan_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_PURPLE = BLOCKS.register("purple_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_BLUE = BLOCKS.register("blue_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_BROWN = BLOCKS.register("brown_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_GREEN = BLOCKS.register("green_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_RED = BLOCKS.register("red_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> BAR_STOOL_BLACK = BLOCKS.register("black_bar_stool",
            () -> new BarStoolBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Electronics
    public static final RegistryObject<Block> LAPTOP_WHITE = BLOCKS.register("white_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_ORANGE = BLOCKS.register("orange_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_MAGENTA = BLOCKS.register("magenta_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_LIGHT_BLUE = BLOCKS.register("light_blue_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_YELLOW = BLOCKS.register("yellow_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_LIME = BLOCKS.register("lime_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.LIME_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_PINK = BLOCKS.register("pink_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_GRAY = BLOCKS.register("gray_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_LIGHT_GRAY = BLOCKS.register("light_gray_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_CYAN = BLOCKS.register("cyan_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_PURPLE = BLOCKS.register("purple_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_BLUE = BLOCKS.register("blue_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_BROWN = BLOCKS.register("brown_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_GREEN = BLOCKS.register("green_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_RED = BLOCKS.register("red_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.RED_CONCRETE)));
    public static final RegistryObject<Block> LAPTOP_BLACK = BLOCKS.register("black_laptop",
            () -> new PlaceholderBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CONCRETE)));

    //Door Bells
    public static final RegistryObject<Block> DOOR_BELL_OAK = BLOCKS.register("oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_SPRUCE = BLOCKS.register("spruce_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_BIRCH = BLOCKS.register("birch_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_JUNGLE = BLOCKS.register("jungle_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_ACACIA = BLOCKS.register("acacia_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_DARK_OAK = BLOCKS.register("dark_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_CRIMSON = BLOCKS.register("crimson_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> DOOR_BELL_WARPED = BLOCKS.register("warped_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_STEM)));
    public static final RegistryObject<Block> DOOR_BELL_MANGROVE = BLOCKS.register("mangrove_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_OAK = BLOCKS.register("stripped_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_SPRUCE = BLOCKS.register("stripped_spruce_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_SPRUCE_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_BIRCH = BLOCKS.register("stripped_birch_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_BIRCH_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_JUNGLE = BLOCKS.register("stripped_jungle_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_ACACIA = BLOCKS.register("stripped_acacia_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_DARK_OAK = BLOCKS.register("stripped_dark_oak_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_DARK_OAK_WOOD)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_CRIMSON = BLOCKS.register("stripped_crimson_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_CRIMSON_STEM)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_WARPED = BLOCKS.register("stripped_warped_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_WARPED_STEM)));
    public static final RegistryObject<Block> DOOR_BELL_STRIPPED_MANGROVE = BLOCKS.register("stripped_mangrove_door_bell",
            () -> new DoorBellBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_MANGROVE_WOOD)));

    //Inflatable Castles
    public static final RegistryObject<Block> INFLATABLE_CASTLE_WHITE = BLOCKS.register("white_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_ORANGE = BLOCKS.register("orange_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_MAGENTA = BLOCKS.register("magenta_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.MAGENTA_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_LIGHT_BLUE = BLOCKS.register("light_blue_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_BLUE_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_YELLOW = BLOCKS.register("yellow_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_LIME = BLOCKS.register("lime_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.LIME_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_PINK = BLOCKS.register("pink_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.PINK_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_GRAY = BLOCKS.register("gray_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_LIGHT_GRAY = BLOCKS.register("light_gray_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_CYAN = BLOCKS.register("cyan_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_PURPLE = BLOCKS.register("purple_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.PURPLE_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_BLUE = BLOCKS.register("blue_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_BROWN = BLOCKS.register("brown_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.BROWN_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_GREEN = BLOCKS.register("green_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.GREEN_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_RED = BLOCKS.register("red_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));
    public static final RegistryObject<Block> INFLATABLE_CASTLE_BLACK = BLOCKS.register("black_inflatable_castle",
            () -> new InflatableCastleBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL)));
    public static final RegistryObject<Block> CASTLE_NETTING = BLOCKS.register("castle_netting",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    //Appliances
    public static final RegistryObject<Block> BIN_LIGHT = BLOCKS.register("bin_light",
            () -> new BinBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> BIN_DARK = BLOCKS.register("bin_dark",
            () -> new BinBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> BLENDER_LIGHT = BLOCKS.register("blender_light",
            () -> new BlenderBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> BLENDER_DARK = BLOCKS.register("blender_dark",
            () -> new BlenderBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> DISHWASHER_LIGHT = BLOCKS.register("dishwasher_light",
            () -> new DishwasherBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> DISHWASHER_DARK = BLOCKS.register("dishwasher_dark",
            () -> new DishwasherBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> MICROWAVE_LIGHT = BLOCKS.register("microwave_light",
            () -> new MicrowaveBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> MICROWAVE_DARK = BLOCKS.register("microwave_dark",
            () -> new MicrowaveBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> OVEN_LIGHT = BLOCKS.register("oven_light",
            () -> new OvenBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> OVEN_DARK = BLOCKS.register("oven_dark",
            () -> new OvenBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> OVEN_RANGE_HOOD_LIGHT = BLOCKS.register("oven_range_hood_light",
            () -> new OvenRangeHoodBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).lightLevel((getLightValueLit(14))).noOcclusion()));
    public static final RegistryObject<Block> OVEN_RANGE_HOOD_DARK = BLOCKS.register("oven_range_hood_dark",
            () -> new OvenRangeHoodBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).lightLevel((getLightValueLit(14))).noOcclusion()));
    public static final RegistryObject<Block> SINK_LIGHT = BLOCKS.register("sink_light",
            () -> new SinkBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> SINK_DARK = BLOCKS.register("sink_dark",
            () -> new SinkBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> SHOWER_LIGHT = BLOCKS.register("shower_light",
            () -> new ShowerBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> SHOWER_DARK = BLOCKS.register("shower_dark",
            () -> new ShowerBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> SHOWER_HEAD_LIGHT = BLOCKS.register("shower_head_light",
            () -> new ShowerHeadBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> SHOWER_HEAD_DARK = BLOCKS.register("shower_head_dark",
            () -> new ShowerHeadBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> TOASTER_LIGHT = BLOCKS.register("toaster_light",
            () -> new ToasterBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> TOASTER_DARK = BLOCKS.register("toaster_dark",
            () -> new ToasterBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> TOILET_LIGHT = BLOCKS.register("toilet_light",
            () -> new ToiletBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> TOILET_DARK = BLOCKS.register("toilet_dark",
            () -> new ToiletBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE).noOcclusion()));

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
        };
    }

}
