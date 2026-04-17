package com.mrcrayfish.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Objects;
import java.util.stream.Stream;

public class ModBlockEntityTypes
{

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "cfm");

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BedsideCabinetBlockEntity>> BEDSIDE_CABINET =
            BLOCK_ENTITY_TYPES.register("bedside_cabinet", () -> BlockEntityType.Builder.of(
                    BedsideCabinetBlockEntity::new,
                    Stream.of(ModBlocks.OAK_BEDSIDE_CABINET, ModBlocks.SPRUCE_BEDSIDE_CABINET,
                                    ModBlocks.BIRCH_BEDSIDE_CABINET, ModBlocks.JUNGLE_BEDSIDE_CABINET,
                                    ModBlocks.ACACIA_BEDSIDE_CABINET, ModBlocks.DARK_OAK_BEDSIDE_CABINET,
                                    ModBlocks.MANGROVE_BEDSIDE_CABINET, ModBlocks.CHERRY_BEDSIDE_CABINET,
                                    ModBlocks.CRIMSON_BEDSIDE_CABINET, ModBlocks.WARPED_BEDSIDE_CABINET,
                                    ModBlocks.STRIPPED_OAK_BEDSIDE_CABINET, ModBlocks.STRIPPED_SPRUCE_BEDSIDE_CABINET,
                                    ModBlocks.STRIPPED_BIRCH_BEDSIDE_CABINET, ModBlocks.STRIPPED_JUNGLE_BEDSIDE_CABINET,
                                    ModBlocks.STRIPPED_ACACIA_BEDSIDE_CABINET, ModBlocks.STRIPPED_DARK_OAK_BEDSIDE_CABINET,
                                    ModBlocks.STRIPPED_MANGROVE_BEDSIDE_CABINET, ModBlocks.STRIPPED_CHERRY_BEDSIDE_CABINET,
                                    ModBlocks.STRIPPED_CRIMSON_BEDSIDE_CABINET, ModBlocks.STRIPPED_WARPED_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.STONE_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.ANDESITE_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.DIORITE_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.GRANITE_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACKSTONE_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.DEEPSLATE_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_BEDSIDE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_BEDSIDE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_BEDSIDE_CABINET)
                            .filter(Objects::nonNull).map(DeferredHolder::get).toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CabinetBlockEntity>> CABINET =
            BLOCK_ENTITY_TYPES.register("cabinet", () -> BlockEntityType.Builder.of(
                    CabinetBlockEntity::new,
                    Stream.of(ModBlocks.OAK_CABINET, ModBlocks.SPRUCE_CABINET,
                                    ModBlocks.BIRCH_CABINET, ModBlocks.JUNGLE_CABINET,
                                    ModBlocks.ACACIA_CABINET, ModBlocks.DARK_OAK_CABINET,
                                    ModBlocks.MANGROVE_CABINET, ModBlocks.CHERRY_CABINET,
                                    ModBlocks.CRIMSON_CABINET, ModBlocks.WARPED_CABINET,
                                    ModBlocks.STRIPPED_OAK_CABINET, ModBlocks.STRIPPED_SPRUCE_CABINET,
                                    ModBlocks.STRIPPED_BIRCH_CABINET, ModBlocks.STRIPPED_JUNGLE_CABINET,
                                    ModBlocks.STRIPPED_ACACIA_CABINET, ModBlocks.STRIPPED_DARK_OAK_CABINET,
                                    ModBlocks.STRIPPED_MANGROVE_CABINET, ModBlocks.STRIPPED_CHERRY_CABINET,
                                    ModBlocks.STRIPPED_CRIMSON_CABINET, ModBlocks.STRIPPED_WARPED_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.STONE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.ANDESITE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.DIORITE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.GRANITE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACKSTONE_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.DEEPSLATE_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_CABINET)
                            .filter(Objects::nonNull).map(DeferredHolder::get).toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CoolerBlockEntity>> COOLER =
            BLOCK_ENTITY_TYPES.register("cooler", () -> BlockEntityType.Builder.of(
                    CoolerBlockEntity::new,
                    Stream.of(ModBlocks.WHITE_COOLER, ModBlocks.LIGHT_GRAY_COOLER,
                                    ModBlocks.GRAY_COOLER, ModBlocks.BLACK_COOLER,
                                    ModBlocks.BROWN_COOLER, ModBlocks.RED_COOLER,
                                    ModBlocks.ORANGE_COOLER, ModBlocks.BEIGE_COOLER,
                                    ModBlocks.YELLOW_COOLER, ModBlocks.LIME_COOLER,
                                    ModBlocks.GREEN_COOLER, ModBlocks.CYAN_COOLER,
                                    ModBlocks.LIGHT_BLUE_COOLER, ModBlocks.BLUE_COOLER,
                                    ModBlocks.PURPLE_COOLER, ModBlocks.MAGENTA_COOLER,
                                    ModBlocks.PINK_COOLER)
                            .filter(Objects::nonNull).map(DeferredHolder::get).toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CrateBlockEntity>> CRATE =
            BLOCK_ENTITY_TYPES.register("crate", () -> BlockEntityType.Builder.of(
                    CrateBlockEntity::new,
                    ModBlocks.OAK_CRATE.get(), ModBlocks.SPRUCE_CRATE.get(), ModBlocks.BIRCH_CRATE.get(),
                    ModBlocks.JUNGLE_CRATE.get(), ModBlocks.ACACIA_CRATE.get(), ModBlocks.DARK_OAK_CRATE.get(),
                    ModBlocks.MANGROVE_CRATE.get(), ModBlocks.CHERRY_CRATE.get(), ModBlocks.CRIMSON_CRATE.get(),
                    ModBlocks.WARPED_CRATE.get(), ModBlocks.STRIPPED_OAK_CRATE.get(), ModBlocks.STRIPPED_SPRUCE_CRATE.get(),
                    ModBlocks.STRIPPED_BIRCH_CRATE.get(), ModBlocks.STRIPPED_JUNGLE_CRATE.get(), ModBlocks.STRIPPED_ACACIA_CRATE.get(),
                    ModBlocks.STRIPPED_DARK_OAK_CRATE.get(), ModBlocks.STRIPPED_MANGROVE_CRATE.get(), ModBlocks.STRIPPED_CHERRY_CRATE.get(),
                    ModBlocks.STRIPPED_CRIMSON_CRATE.get(), ModBlocks.STRIPPED_WARPED_CRATE.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DeskCabinetBlockEntity>> DESK_CABINET =
            BLOCK_ENTITY_TYPES.register("desk_cabinet", () -> BlockEntityType.Builder.of(
                    DeskCabinetBlockEntity::new,
                    Stream.of(ModBlocks.OAK_DESK_CABINET, ModBlocks.SPRUCE_DESK_CABINET,
                                    ModBlocks.BIRCH_DESK_CABINET, ModBlocks.JUNGLE_DESK_CABINET,
                                    ModBlocks.ACACIA_DESK_CABINET, ModBlocks.DARK_OAK_DESK_CABINET,
                                    ModBlocks.MANGROVE_DESK_CABINET, ModBlocks.CHERRY_DESK_CABINET,
                                    ModBlocks.CRIMSON_DESK_CABINET, ModBlocks.WARPED_DESK_CABINET,
                                    ModBlocks.STRIPPED_OAK_DESK_CABINET, ModBlocks.STRIPPED_SPRUCE_DESK_CABINET,
                                    ModBlocks.STRIPPED_BIRCH_DESK_CABINET, ModBlocks.STRIPPED_JUNGLE_DESK_CABINET,
                                    ModBlocks.STRIPPED_ACACIA_DESK_CABINET, ModBlocks.STRIPPED_DARK_OAK_DESK_CABINET,
                                    ModBlocks.STRIPPED_MANGROVE_DESK_CABINET, ModBlocks.STRIPPED_CHERRY_DESK_CABINET,
                                    ModBlocks.STRIPPED_CRIMSON_DESK_CABINET, ModBlocks.STRIPPED_WARPED_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.STONE_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.ANDESITE_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.DIORITE_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.GRANITE_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.BLACKSTONE_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.DEEPSLATE_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_DESK_CABINET, com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_DESK_CABINET,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_DESK_CABINET)
                            .filter(Objects::nonNull).map(DeferredHolder::get).toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DoorMatBlockEntity>> DOOR_MAT =
            BLOCK_ENTITY_TYPES.register("door_mat", () -> BlockEntityType.Builder.of(
                    DoorMatBlockEntity::new,
                    ModBlocks.DOOR_MAT.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FreezerBlockEntity>> FREEZER =
            BLOCK_ENTITY_TYPES.register("freezer", () -> BlockEntityType.Builder.of(
                    FreezerBlockEntity::new,
                    ModBlocks.FREEZER_LIGHT.get(), ModBlocks.FREEZER_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FridgeBlockEntity>> FRIDGE =
            BLOCK_ENTITY_TYPES.register("fridge", () -> BlockEntityType.Builder.of(
                    FridgeBlockEntity::new,
                    ModBlocks.FRIDGE_LIGHT.get(), ModBlocks.FRIDGE_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrillBlockEntity>> GRILL =
            BLOCK_ENTITY_TYPES.register("grill", () -> BlockEntityType.Builder.of(
                    GrillBlockEntity::new,
                    Stream.of(ModBlocks.WHITE_GRILL, ModBlocks.LIGHT_GRAY_GRILL,
                                    ModBlocks.GRAY_GRILL, ModBlocks.BLACK_GRILL,
                                    ModBlocks.BROWN_GRILL, ModBlocks.RED_GRILL,
                                    ModBlocks.ORANGE_GRILL, ModBlocks.BEIGE_GRILL,
                                    ModBlocks.YELLOW_GRILL, ModBlocks.LIME_GRILL,
                                    ModBlocks.GREEN_GRILL, ModBlocks.CYAN_GRILL,
                                    ModBlocks.LIGHT_BLUE_GRILL, ModBlocks.BLUE_GRILL,
                                    ModBlocks.PURPLE_GRILL, ModBlocks.MAGENTA_GRILL,
                                    ModBlocks.PINK_GRILL)
                            .filter(Objects::nonNull).map(DeferredHolder::get).toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KitchenDrawerBlockEntity>> KITCHEN_DRAWER =
            BLOCK_ENTITY_TYPES.register("kitchen_drawer", () -> BlockEntityType.Builder.of(
                    KitchenDrawerBlockEntity::new,
                    Stream.of(ModBlocks.OAK_KITCHEN_DRAWER, ModBlocks.SPRUCE_KITCHEN_DRAWER,
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
                                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_KITCHEN_DRAWER, com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_DRAWER,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_KITCHEN_DRAWER, com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_KITCHEN_DRAWER,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_KITCHEN_DRAWER, com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_KITCHEN_DRAWER,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_KITCHEN_DRAWER, com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_KITCHEN_DRAWER,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_KITCHEN_DRAWER, com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_KITCHEN_DRAWER,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_KITCHEN_DRAWER, com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_KITCHEN_DRAWER,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_DRAWER, com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_KITCHEN_DRAWER,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_KITCHEN_DRAWER, com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_KITCHEN_DRAWER,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_KITCHEN_DRAWER)
                            .filter(Objects::nonNull).map(DeferredHolder::get).toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KitchenSinkBlockEntity>> KITCHEN_SINK =
            BLOCK_ENTITY_TYPES.register("kitchen_sink", () -> BlockEntityType.Builder.of(
                    KitchenSinkBlockEntity::new,
                    Stream.of(ModBlocks.OAK_KITCHEN_SINK_LIGHT, ModBlocks.SPRUCE_KITCHEN_SINK_LIGHT,
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
                                    com.nosiphus.furniture.world.level.block.ModBlocks.WHITE_MODERN_KITCHEN_SINK, com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_GRAY_MODERN_KITCHEN_SINK,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GRAY_MODERN_KITCHEN_SINK, com.nosiphus.furniture.world.level.block.ModBlocks.BLACK_MODERN_KITCHEN_SINK,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.BROWN_MODERN_KITCHEN_SINK, com.nosiphus.furniture.world.level.block.ModBlocks.RED_MODERN_KITCHEN_SINK,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.ORANGE_MODERN_KITCHEN_SINK, com.nosiphus.furniture.world.level.block.ModBlocks.BEIGE_MODERN_KITCHEN_SINK,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.YELLOW_MODERN_KITCHEN_SINK, com.nosiphus.furniture.world.level.block.ModBlocks.LIME_MODERN_KITCHEN_SINK,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.GREEN_MODERN_KITCHEN_SINK, com.nosiphus.furniture.world.level.block.ModBlocks.CYAN_MODERN_KITCHEN_SINK,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.LIGHT_BLUE_MODERN_KITCHEN_SINK, com.nosiphus.furniture.world.level.block.ModBlocks.BLUE_MODERN_KITCHEN_SINK,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PURPLE_MODERN_KITCHEN_SINK, com.nosiphus.furniture.world.level.block.ModBlocks.MAGENTA_MODERN_KITCHEN_SINK,
                                    com.nosiphus.furniture.world.level.block.ModBlocks.PINK_MODERN_KITCHEN_SINK)
                            .filter(Objects::nonNull).map(DeferredHolder::get).toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MailBoxBlockEntity>> MAIL_BOX =
            BLOCK_ENTITY_TYPES.register("mail_box", () -> BlockEntityType.Builder.of(
                    MailBoxBlockEntity::new,
                    ModBlocks.OAK_MAIL_BOX.get(), ModBlocks.SPRUCE_MAIL_BOX.get(),
                    ModBlocks.BIRCH_MAIL_BOX.get(), ModBlocks.JUNGLE_MAIL_BOX.get(),
                    ModBlocks.ACACIA_MAIL_BOX.get(), ModBlocks.DARK_OAK_MAIL_BOX.get(),
                    ModBlocks.MANGROVE_MAIL_BOX.get(), ModBlocks.CHERRY_MAIL_BOX.get(),
                    ModBlocks.CRIMSON_MAIL_BOX.get(), ModBlocks.WARPED_MAIL_BOX.get(),
                    ModBlocks.STRIPPED_OAK_MAIL_BOX.get(), ModBlocks.STRIPPED_SPRUCE_MAIL_BOX.get(),
                    ModBlocks.STRIPPED_BIRCH_MAIL_BOX.get(), ModBlocks.STRIPPED_JUNGLE_MAIL_BOX.get(),
                    ModBlocks.STRIPPED_ACACIA_MAIL_BOX.get(), ModBlocks.STRIPPED_DARK_OAK_MAIL_BOX.get(),
                    ModBlocks.STRIPPED_MANGROVE_MAIL_BOX.get(), ModBlocks.STRIPPED_CHERRY_MAIL_BOX.get(),
                    ModBlocks.STRIPPED_CRIMSON_MAIL_BOX.get(), ModBlocks.STRIPPED_WARPED_MAIL_BOX.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TrampolineBlockEntity>> TRAMPOLINE =
            BLOCK_ENTITY_TYPES.register("trampoline", () -> BlockEntityType.Builder.of(
                    TrampolineBlockEntity::new,
                    Stream.of(ModBlocks.WHITE_TRAMPOLINE, ModBlocks.LIGHT_GRAY_TRAMPOLINE,
                                    ModBlocks.GRAY_TRAMPOLINE, ModBlocks.BLACK_TRAMPOLINE,
                                    ModBlocks.BROWN_TRAMPOLINE, ModBlocks.RED_TRAMPOLINE,
                                    ModBlocks.ORANGE_TRAMPOLINE, ModBlocks.BEIGE_TRAMPOLINE,
                                    ModBlocks.YELLOW_TRAMPOLINE, ModBlocks.LIME_TRAMPOLINE,
                                    ModBlocks.GREEN_TRAMPOLINE, ModBlocks.CYAN_TRAMPOLINE,
                                    ModBlocks.LIGHT_BLUE_TRAMPOLINE, ModBlocks.BLUE_TRAMPOLINE,
                                    ModBlocks.PURPLE_TRAMPOLINE, ModBlocks.MAGENTA_TRAMPOLINE,
                                    ModBlocks.PINK_TRAMPOLINE)
                            .filter(Objects::nonNull).map(DeferredHolder::get).toArray(Block[]::new)
            ).build(null));

}
