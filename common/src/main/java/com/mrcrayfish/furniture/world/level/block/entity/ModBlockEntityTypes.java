package com.mrcrayfish.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBlockEntityTypes
{

    public static void init() {

    }

    @SafeVarargs
    private static Block[] filterBlocks(Supplier<? extends Block>... suppliers)
    {
        return Stream.of(suppliers)
                .filter(Objects::nonNull)
                .map(Supplier::get)
                .filter(Objects::nonNull)
                .toArray(Block[]::new);
    }

    public static final Supplier<BlockEntityType<BedsideCabinetBlockEntity>> BEDSIDE_CABINET = Services.REGISTRY.registerBlockEntityType("bedside_cabinet",
            () -> BlockEntityType.Builder.of(BedsideCabinetBlockEntity::new, filterBlocks(
                    // CFM Variants
                    ModBlocks.OAK_BEDSIDE_CABINET, ModBlocks.SPRUCE_BEDSIDE_CABINET,
                    ModBlocks.BIRCH_BEDSIDE_CABINET, ModBlocks.JUNGLE_BEDSIDE_CABINET,
                    ModBlocks.ACACIA_BEDSIDE_CABINET, ModBlocks.DARK_OAK_BEDSIDE_CABINET,
                    ModBlocks.MANGROVE_BEDSIDE_CABINET, ModBlocks.CHERRY_BEDSIDE_CABINET,
                    ModBlocks.CRIMSON_BEDSIDE_CABINET, ModBlocks.WARPED_BEDSIDE_CABINET,
                    ModBlocks.STRIPPED_OAK_BEDSIDE_CABINET, ModBlocks.STRIPPED_SPRUCE_BEDSIDE_CABINET,
                    ModBlocks.STRIPPED_BIRCH_BEDSIDE_CABINET, ModBlocks.STRIPPED_JUNGLE_BEDSIDE_CABINET,
                    ModBlocks.STRIPPED_ACACIA_BEDSIDE_CABINET, ModBlocks.STRIPPED_DARK_OAK_BEDSIDE_CABINET,
                    ModBlocks.STRIPPED_MANGROVE_BEDSIDE_CABINET, ModBlocks.STRIPPED_CHERRY_BEDSIDE_CABINET,
                    ModBlocks.STRIPPED_CRIMSON_BEDSIDE_CABINET, ModBlocks.STRIPPED_WARPED_BEDSIDE_CABINET,

                    // NFM Stone Variants
                    com.nosiphus.furniture.world.level.block.ModBlocks.STONE_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ANDESITE_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.DIORITE_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRANITE_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACKSTONE_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.DEEPSLATE_BEDSIDE_CABINET,

                    // NFM Modern Variants
                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_BEDSIDE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_BEDSIDE_CABINET
            )).build(null));

    public static final Supplier<BlockEntityType<CabinetBlockEntity>> CABINET = Services.REGISTRY.registerBlockEntityType("cabinet",
            () -> BlockEntityType.Builder.of(CabinetBlockEntity::new, filterBlocks(
                    // CFM Variants
                    ModBlocks.OAK_CABINET, ModBlocks.SPRUCE_CABINET,
                    ModBlocks.BIRCH_CABINET, ModBlocks.JUNGLE_CABINET,
                    ModBlocks.ACACIA_CABINET, ModBlocks.DARK_OAK_CABINET,
                    ModBlocks.MANGROVE_CABINET, ModBlocks.CHERRY_CABINET,
                    ModBlocks.CRIMSON_CABINET, ModBlocks.WARPED_CABINET,
                    ModBlocks.STRIPPED_OAK_CABINET, ModBlocks.STRIPPED_SPRUCE_CABINET,
                    ModBlocks.STRIPPED_BIRCH_CABINET, ModBlocks.STRIPPED_JUNGLE_CABINET,
                    ModBlocks.STRIPPED_ACACIA_CABINET, ModBlocks.STRIPPED_DARK_OAK_CABINET,
                    ModBlocks.STRIPPED_MANGROVE_CABINET, ModBlocks.STRIPPED_CHERRY_CABINET,
                    ModBlocks.STRIPPED_CRIMSON_CABINET, ModBlocks.STRIPPED_WARPED_CABINET,

                    // NFM Stone Variants
                    com.nosiphus.furniture.world.level.block.ModBlocks.STONE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ANDESITE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.DIORITE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRANITE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACKSTONE_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.DEEPSLATE_CABINET,

                    // NFM Modern Variants
                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_CABINET,

                    // NFM Wall Cabinet Variants
                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.RED_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIME_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_WALL_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_WALL_CABINET
            )).build(null));

    public static final Supplier<BlockEntityType<CoolerBlockEntity>> COOLER = Services.REGISTRY.registerBlockEntityType("cooler",
            () -> BlockEntityType.Builder.of(CoolerBlockEntity::new, filterBlocks(
                    ModBlocks.WHITE_COOLER, ModBlocks.LIGHT_GRAY_COOLER,
                    ModBlocks.GRAY_COOLER, ModBlocks.BLACK_COOLER,
                    ModBlocks.BROWN_COOLER, ModBlocks.RED_COOLER,
                    ModBlocks.ORANGE_COOLER, ModBlocks.BEIGE_COOLER,
                    ModBlocks.YELLOW_COOLER, ModBlocks.LIME_COOLER,
                    ModBlocks.GREEN_COOLER, ModBlocks.CYAN_COOLER,
                    ModBlocks.LIGHT_BLUE_COOLER, ModBlocks.BLUE_COOLER,
                    ModBlocks.PURPLE_COOLER, ModBlocks.MAGENTA_COOLER,
                    ModBlocks.PINK_COOLER
            )).build(null));

    public static final Supplier<BlockEntityType<CrateBlockEntity>> CRATE = Services.REGISTRY.registerBlockEntityType("crate",
            () -> BlockEntityType.Builder.of(CrateBlockEntity::new, filterBlocks(
                    ModBlocks.OAK_CRATE, ModBlocks.SPRUCE_CRATE, ModBlocks.BIRCH_CRATE,
                    ModBlocks.JUNGLE_CRATE, ModBlocks.ACACIA_CRATE, ModBlocks.DARK_OAK_CRATE,
                    ModBlocks.MANGROVE_CRATE, ModBlocks.CHERRY_CRATE, ModBlocks.CRIMSON_CRATE,
                    ModBlocks.WARPED_CRATE, ModBlocks.STRIPPED_OAK_CRATE, ModBlocks.STRIPPED_SPRUCE_CRATE,
                    ModBlocks.STRIPPED_BIRCH_CRATE, ModBlocks.STRIPPED_JUNGLE_CRATE, ModBlocks.STRIPPED_ACACIA_CRATE,
                    ModBlocks.STRIPPED_DARK_OAK_CRATE, ModBlocks.STRIPPED_MANGROVE_CRATE, ModBlocks.STRIPPED_CHERRY_CRATE,
                    ModBlocks.STRIPPED_CRIMSON_CRATE, ModBlocks.STRIPPED_WARPED_CRATE
            )).build(null));

    public static final Supplier<BlockEntityType<DeskCabinetBlockEntity>> DESK_CABINET = Services.REGISTRY.registerBlockEntityType("desk_cabinet",
            () -> BlockEntityType.Builder.of(DeskCabinetBlockEntity::new, filterBlocks(
                    // CFM Variants
                    ModBlocks.OAK_DESK_CABINET, ModBlocks.SPRUCE_DESK_CABINET,
                    ModBlocks.BIRCH_DESK_CABINET, ModBlocks.JUNGLE_DESK_CABINET,
                    ModBlocks.ACACIA_DESK_CABINET, ModBlocks.DARK_OAK_DESK_CABINET,
                    ModBlocks.MANGROVE_DESK_CABINET, ModBlocks.CHERRY_DESK_CABINET,
                    ModBlocks.CRIMSON_DESK_CABINET, ModBlocks.WARPED_DESK_CABINET,
                    ModBlocks.STRIPPED_OAK_DESK_CABINET, ModBlocks.STRIPPED_SPRUCE_DESK_CABINET,
                    ModBlocks.STRIPPED_BIRCH_DESK_CABINET, ModBlocks.STRIPPED_JUNGLE_DESK_CABINET,
                    ModBlocks.STRIPPED_ACACIA_DESK_CABINET, ModBlocks.STRIPPED_DARK_OAK_DESK_CABINET,
                    ModBlocks.STRIPPED_MANGROVE_DESK_CABINET, ModBlocks.STRIPPED_CHERRY_DESK_CABINET,
                    ModBlocks.STRIPPED_CRIMSON_DESK_CABINET, ModBlocks.STRIPPED_WARPED_DESK_CABINET,

                    // NFM Stone Variants
                    com.nosiphus.furniture.world.level.block.ModBlocks.STONE_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ANDESITE_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.DIORITE_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRANITE_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACKSTONE_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.DEEPSLATE_DESK_CABINET,

                    // NFM Modern Variants
                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_DESK_CABINET,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_DESK_CABINET
            )).build(null));

    public static final Supplier<BlockEntityType<DoorMatBlockEntity>> DOOR_MAT = Services.REGISTRY.registerBlockEntityType("door_mat",
            () -> BlockEntityType.Builder.of(DoorMatBlockEntity::new, filterBlocks(ModBlocks.DOOR_MAT)).build(null));

    public static final Supplier<BlockEntityType<FreezerBlockEntity>> FREEZER = Services.REGISTRY.registerBlockEntityType("freezer",
            () -> BlockEntityType.Builder.of(FreezerBlockEntity::new, filterBlocks(
                    ModBlocks.FREEZER_LIGHT, ModBlocks.FREEZER_DARK
            )).build(null));

    public static final Supplier<BlockEntityType<FridgeBlockEntity>> FRIDGE = Services.REGISTRY.registerBlockEntityType("fridge",
            () -> BlockEntityType.Builder.of(FridgeBlockEntity::new, filterBlocks(
                    ModBlocks.FRIDGE_LIGHT, ModBlocks.FRIDGE_DARK
            )).build(null));

    public static final Supplier<BlockEntityType<GrillBlockEntity>> GRILL = Services.REGISTRY.registerBlockEntityType("grill",
            () -> BlockEntityType.Builder.of(GrillBlockEntity::new, filterBlocks(
                    ModBlocks.WHITE_GRILL, ModBlocks.LIGHT_GRAY_GRILL,
                    ModBlocks.GRAY_GRILL, ModBlocks.BLACK_GRILL,
                    ModBlocks.BROWN_GRILL, ModBlocks.RED_GRILL,
                    ModBlocks.ORANGE_GRILL, ModBlocks.BEIGE_GRILL,
                    ModBlocks.YELLOW_GRILL, ModBlocks.LIME_GRILL,
                    ModBlocks.GREEN_GRILL, ModBlocks.CYAN_GRILL,
                    ModBlocks.LIGHT_BLUE_GRILL, ModBlocks.BLUE_GRILL,
                    ModBlocks.PURPLE_GRILL, ModBlocks.MAGENTA_GRILL,
                    ModBlocks.PINK_GRILL
            )).build(null));

    public static final Supplier<BlockEntityType<KitchenDrawerBlockEntity>> KITCHEN_DRAWER = Services.REGISTRY.registerBlockEntityType("kitchen_drawer",
            () -> BlockEntityType.Builder.of(KitchenDrawerBlockEntity::new, filterBlocks(
                    // CFM Variants
                    ModBlocks.OAK_KITCHEN_DRAWER, ModBlocks.SPRUCE_KITCHEN_DRAWER,
                    ModBlocks.BIRCH_KITCHEN_DRAWER, ModBlocks.JUNGLE_KITCHEN_DRAWER,
                    ModBlocks.ACACIA_KITCHEN_DRAWER, ModBlocks.DARK_OAK_KITCHEN_DRAWER,
                    ModBlocks.MANGROVE_KITCHEN_DRAWER, ModBlocks.CHERRY_KITCHEN_DRAWER,
                    ModBlocks.CRIMSON_KITCHEN_DRAWER, ModBlocks.WARPED_KITCHEN_DRAWER,
                    ModBlocks.STRIPPED_OAK_KITCHEN_DRAWER, ModBlocks.STRIPPED_SPRUCE_KITCHEN_DRAWER,
                    ModBlocks.STRIPPED_BIRCH_KITCHEN_DRAWER, ModBlocks.STRIPPED_JUNGLE_KITCHEN_DRAWER,
                    ModBlocks.STRIPPED_ACACIA_KITCHEN_DRAWER, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_DRAWER,
                    ModBlocks.STRIPPED_MANGROVE_KITCHEN_DRAWER, ModBlocks.STRIPPED_CHERRY_KITCHEN_DRAWER,
                    ModBlocks.STRIPPED_CRIMSON_KITCHEN_DRAWER, ModBlocks.STRIPPED_WARPED_KITCHEN_DRAWER,
                    ModBlocks.WHITE_KITCHEN_DRAWER, ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER,
                    ModBlocks.GRAY_KITCHEN_DRAWER, ModBlocks.BLACK_KITCHEN_DRAWER,
                    ModBlocks.BROWN_KITCHEN_DRAWER, ModBlocks.RED_KITCHEN_DRAWER,
                    ModBlocks.ORANGE_KITCHEN_DRAWER, ModBlocks.BEIGE_KITCHEN_DRAWER,
                    ModBlocks.YELLOW_KITCHEN_DRAWER, ModBlocks.LIME_KITCHEN_DRAWER,
                    ModBlocks.GREEN_KITCHEN_DRAWER, ModBlocks.CYAN_KITCHEN_DRAWER,
                    ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER, ModBlocks.BLUE_KITCHEN_DRAWER,
                    ModBlocks.PURPLE_KITCHEN_DRAWER, ModBlocks.MAGENTA_KITCHEN_DRAWER,
                    ModBlocks.PINK_KITCHEN_DRAWER,

                    // NFM Modern Kitchen Drawers
                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_KITCHEN_DRAWER,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_KITCHEN_DRAWER
            )).build(null));

    public static final Supplier<BlockEntityType<KitchenSinkBlockEntity>> KITCHEN_SINK = Services.REGISTRY.registerBlockEntityType("kitchen_sink",
            () -> BlockEntityType.Builder.of(KitchenSinkBlockEntity::new, filterBlocks(
                    // CFM Variants
                    ModBlocks.OAK_KITCHEN_SINK_LIGHT, ModBlocks.SPRUCE_KITCHEN_SINK_LIGHT,
                    ModBlocks.BIRCH_KITCHEN_SINK_LIGHT, ModBlocks.JUNGLE_KITCHEN_SINK_LIGHT,
                    ModBlocks.ACACIA_KITCHEN_SINK_LIGHT, ModBlocks.DARK_OAK_KITCHEN_SINK_LIGHT,
                    ModBlocks.MANGROVE_KITCHEN_SINK_LIGHT, ModBlocks.CHERRY_KITCHEN_SINK_LIGHT,
                    ModBlocks.CRIMSON_KITCHEN_SINK_LIGHT, ModBlocks.WARPED_KITCHEN_SINK_LIGHT,
                    ModBlocks.STRIPPED_OAK_KITCHEN_SINK_LIGHT, ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT,
                    ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_LIGHT, ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT,
                    ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_LIGHT, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT,
                    ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT, ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_LIGHT,
                    ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT, ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_LIGHT,
                    ModBlocks.OAK_KITCHEN_SINK_DARK, ModBlocks.SPRUCE_KITCHEN_SINK_DARK,
                    ModBlocks.BIRCH_KITCHEN_SINK_DARK, ModBlocks.JUNGLE_KITCHEN_SINK_DARK,
                    ModBlocks.ACACIA_KITCHEN_SINK_DARK, ModBlocks.DARK_OAK_KITCHEN_SINK_DARK,
                    ModBlocks.MANGROVE_KITCHEN_SINK_DARK, ModBlocks.CHERRY_KITCHEN_SINK_DARK,
                    ModBlocks.CRIMSON_KITCHEN_SINK_DARK, ModBlocks.WARPED_KITCHEN_SINK_DARK,
                    ModBlocks.STRIPPED_OAK_KITCHEN_SINK_DARK, ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_DARK,
                    ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_DARK, ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_DARK,
                    ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_DARK, ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_DARK,
                    ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_DARK, ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_DARK,
                    ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_DARK, ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_DARK,
                    ModBlocks.WHITE_KITCHEN_SINK, ModBlocks.LIGHT_GRAY_KITCHEN_SINK,
                    ModBlocks.GRAY_KITCHEN_SINK, ModBlocks.BLACK_KITCHEN_SINK,
                    ModBlocks.BROWN_KITCHEN_SINK, ModBlocks.RED_KITCHEN_SINK,
                    ModBlocks.ORANGE_KITCHEN_SINK, ModBlocks.BEIGE_KITCHEN_SINK,
                    ModBlocks.YELLOW_KITCHEN_SINK, ModBlocks.LIME_KITCHEN_SINK,
                    ModBlocks.GREEN_KITCHEN_SINK, ModBlocks.CYAN_KITCHEN_SINK,
                    ModBlocks.LIGHT_BLUE_KITCHEN_SINK, ModBlocks.BLUE_KITCHEN_SINK,
                    ModBlocks.PURPLE_KITCHEN_SINK, ModBlocks.MAGENTA_KITCHEN_SINK,
                    ModBlocks.PINK_KITCHEN_SINK,

                    // NFM Modern Kitchen Sinks
                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_KITCHEN_SINK,
                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_KITCHEN_SINK
            )).build(null));

    public static final Supplier<BlockEntityType<MailBoxBlockEntity>> MAIL_BOX = Services.REGISTRY.registerBlockEntityType("mail_box",
            () -> BlockEntityType.Builder.of(MailBoxBlockEntity::new, filterBlocks(
                    ModBlocks.OAK_MAIL_BOX, ModBlocks.SPRUCE_MAIL_BOX,
                    ModBlocks.BIRCH_MAIL_BOX, ModBlocks.JUNGLE_MAIL_BOX,
                    ModBlocks.ACACIA_MAIL_BOX, ModBlocks.DARK_OAK_MAIL_BOX,
                    ModBlocks.MANGROVE_MAIL_BOX, ModBlocks.CHERRY_MAIL_BOX,
                    ModBlocks.CRIMSON_MAIL_BOX, ModBlocks.WARPED_MAIL_BOX,
                    ModBlocks.STRIPPED_OAK_MAIL_BOX, ModBlocks.STRIPPED_SPRUCE_MAIL_BOX,
                    ModBlocks.STRIPPED_BIRCH_MAIL_BOX, ModBlocks.STRIPPED_JUNGLE_MAIL_BOX,
                    ModBlocks.STRIPPED_ACACIA_MAIL_BOX, ModBlocks.STRIPPED_DARK_OAK_MAIL_BOX,
                    ModBlocks.STRIPPED_MANGROVE_MAIL_BOX, ModBlocks.STRIPPED_CHERRY_MAIL_BOX,
                    ModBlocks.STRIPPED_CRIMSON_MAIL_BOX, ModBlocks.STRIPPED_WARPED_MAIL_BOX
            )).build(null));

    public static final Supplier<BlockEntityType<TrampolineBlockEntity>> TRAMPOLINE = Services.REGISTRY.registerBlockEntityType("trampoline",
            () -> BlockEntityType.Builder.of(TrampolineBlockEntity::new, filterBlocks(
                    ModBlocks.WHITE_TRAMPOLINE, ModBlocks.LIGHT_GRAY_TRAMPOLINE,
                    ModBlocks.GRAY_TRAMPOLINE, ModBlocks.BLACK_TRAMPOLINE,
                    ModBlocks.BROWN_TRAMPOLINE, ModBlocks.RED_TRAMPOLINE,
                    ModBlocks.ORANGE_TRAMPOLINE, ModBlocks.BEIGE_TRAMPOLINE,
                    ModBlocks.YELLOW_TRAMPOLINE, ModBlocks.LIME_TRAMPOLINE,
                    ModBlocks.GREEN_TRAMPOLINE, ModBlocks.CYAN_TRAMPOLINE,
                    ModBlocks.LIGHT_BLUE_TRAMPOLINE, ModBlocks.BLUE_TRAMPOLINE,
                    ModBlocks.PURPLE_TRAMPOLINE, ModBlocks.MAGENTA_TRAMPOLINE,
                    ModBlocks.PINK_TRAMPOLINE
            )).build(null));
}