package com.mrcrayfish.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntityTypes
{

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "cfm");

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BedsideCabinetBlockEntity>> BEDSIDE_CABINET =
            BLOCK_ENTITY_TYPES.register("bedside_cabinet", () -> BlockEntityType.Builder.of(
                    BedsideCabinetBlockEntity::new,
                    ModBlocks.OAK_BEDSIDE_CABINET.get(), ModBlocks.SPRUCE_BEDSIDE_CABINET.get(),
                    ModBlocks.BIRCH_BEDSIDE_CABINET.get(), ModBlocks.JUNGLE_BEDSIDE_CABINET.get(),
                    ModBlocks.ACACIA_BEDSIDE_CABINET.get(), ModBlocks.DARK_OAK_BEDSIDE_CABINET.get(),
                    ModBlocks.MANGROVE_BEDSIDE_CABINET.get(), ModBlocks.CHERRY_BEDSIDE_CABINET.get(),
                    ModBlocks.CRIMSON_BEDSIDE_CABINET.get(), ModBlocks.WARPED_BEDSIDE_CABINET.get(),
                    ModBlocks.STRIPPED_OAK_BEDSIDE_CABINET.get(), ModBlocks.STRIPPED_SPRUCE_BEDSIDE_CABINET.get(),
                    ModBlocks.STRIPPED_BIRCH_BEDSIDE_CABINET.get(), ModBlocks.STRIPPED_JUNGLE_BEDSIDE_CABINET.get(),
                    ModBlocks.STRIPPED_ACACIA_BEDSIDE_CABINET.get(), ModBlocks.STRIPPED_DARK_OAK_BEDSIDE_CABINET.get(),
                    ModBlocks.STRIPPED_MANGROVE_BEDSIDE_CABINET.get(), ModBlocks.STRIPPED_CHERRY_BEDSIDE_CABINET.get(),
                    ModBlocks.STRIPPED_CRIMSON_BEDSIDE_CABINET.get(), ModBlocks.STRIPPED_WARPED_BEDSIDE_CABINET.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CabinetBlockEntity>> CABINET =
            BLOCK_ENTITY_TYPES.register("cabinet", () -> BlockEntityType.Builder.of(
                    CabinetBlockEntity::new,
                    ModBlocks.OAK_CABINET.get(), ModBlocks.SPRUCE_CABINET.get(),
                    ModBlocks.BIRCH_CABINET.get(), ModBlocks.JUNGLE_CABINET.get(),
                    ModBlocks.ACACIA_CABINET.get(), ModBlocks.DARK_OAK_CABINET.get(),
                    ModBlocks.MANGROVE_CABINET.get(), ModBlocks.CHERRY_CABINET.get(),
                    ModBlocks.CRIMSON_CABINET.get(), ModBlocks.WARPED_CABINET.get(),
                    ModBlocks.STRIPPED_OAK_CABINET.get(), ModBlocks.STRIPPED_SPRUCE_CABINET.get(),
                    ModBlocks.STRIPPED_BIRCH_CABINET.get(), ModBlocks.STRIPPED_JUNGLE_CABINET.get(),
                    ModBlocks.STRIPPED_ACACIA_CABINET.get(), ModBlocks.STRIPPED_DARK_OAK_CABINET.get(),
                    ModBlocks.STRIPPED_MANGROVE_CABINET.get(), ModBlocks.STRIPPED_CHERRY_CABINET.get(),
                    ModBlocks.STRIPPED_CRIMSON_CABINET.get(), ModBlocks.STRIPPED_WARPED_CABINET.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CoolerBlockEntity>> COOLER =
            BLOCK_ENTITY_TYPES.register("cooler", () -> BlockEntityType.Builder.of(
                    CoolerBlockEntity::new,
                    ModBlocks.WHITE_COOLER.get(), ModBlocks.LIGHT_GRAY_COOLER.get(),
                    ModBlocks.GRAY_COOLER.get(), ModBlocks.BLACK_COOLER.get(),
                    ModBlocks.BROWN_COOLER.get(), ModBlocks.RED_COOLER.get(),
                    ModBlocks.ORANGE_COOLER.get(), ModBlocks.BEIGE_COOLER.get(),
                    ModBlocks.YELLOW_COOLER.get(), ModBlocks.LIME_COOLER.get(),
                    ModBlocks.GREEN_COOLER.get(), ModBlocks.CYAN_COOLER.get(),
                    ModBlocks.LIGHT_BLUE_COOLER.get(), ModBlocks.BLUE_COOLER.get(),
                    ModBlocks.PURPLE_COOLER.get(), ModBlocks.MAGENTA_COOLER.get(),
                    ModBlocks.PINK_COOLER.get()
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
                    ModBlocks.OAK_DESK_CABINET.get(), ModBlocks.SPRUCE_DESK_CABINET.get(),
                    ModBlocks.BIRCH_DESK_CABINET.get(), ModBlocks.JUNGLE_DESK_CABINET.get(),
                    ModBlocks.ACACIA_DESK_CABINET.get(), ModBlocks.DARK_OAK_DESK_CABINET.get(),
                    ModBlocks.MANGROVE_DESK_CABINET.get(), ModBlocks.CHERRY_DESK_CABINET.get(),
                    ModBlocks.CRIMSON_DESK_CABINET.get(), ModBlocks.WARPED_DESK_CABINET.get(),
                    ModBlocks.STRIPPED_OAK_DESK_CABINET.get(), ModBlocks.STRIPPED_SPRUCE_DESK_CABINET.get(),
                    ModBlocks.STRIPPED_BIRCH_DESK_CABINET.get(), ModBlocks.STRIPPED_JUNGLE_DESK_CABINET.get(),
                    ModBlocks.STRIPPED_ACACIA_DESK_CABINET.get(), ModBlocks.STRIPPED_DARK_OAK_DESK_CABINET.get(),
                    ModBlocks.STRIPPED_MANGROVE_DESK_CABINET.get(), ModBlocks.STRIPPED_CHERRY_DESK_CABINET.get(),
                    ModBlocks.STRIPPED_CRIMSON_DESK_CABINET.get(), ModBlocks.STRIPPED_WARPED_DESK_CABINET.get()
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
                    ModBlocks.WHITE_GRILL.get(), ModBlocks.LIGHT_GRAY_GRILL.get(),
                    ModBlocks.GRAY_GRILL.get(), ModBlocks.BLACK_GRILL.get(),
                    ModBlocks.BROWN_GRILL.get(), ModBlocks.RED_GRILL.get(),
                    ModBlocks.ORANGE_GRILL.get(), ModBlocks.BEIGE_GRILL.get(),
                    ModBlocks.YELLOW_GRILL.get(), ModBlocks.LIME_GRILL.get(),
                    ModBlocks.GREEN_GRILL.get(), ModBlocks.CYAN_GRILL.get(),
                    ModBlocks.LIGHT_BLUE_GRILL.get(), ModBlocks.BLUE_GRILL.get(),
                    ModBlocks.PURPLE_GRILL.get(), ModBlocks.MAGENTA_GRILL.get(),
                    ModBlocks.PINK_GRILL.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KitchenDrawerBlockEntity>> KITCHEN_DRAWER =
            BLOCK_ENTITY_TYPES.register("kitchen_drawer", () -> BlockEntityType.Builder.of(
                    KitchenDrawerBlockEntity::new,
                    ModBlocks.OAK_KITCHEN_DRAWER.get(), ModBlocks.SPRUCE_KITCHEN_DRAWER.get(),
                    ModBlocks.BIRCH_KITCHEN_DRAWER.get(), ModBlocks.JUNGLE_KITCHEN_DRAWER.get(),
                    ModBlocks.ACACIA_KITCHEN_DRAWER.get(), ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(),
                    ModBlocks.MANGROVE_KITCHEN_DRAWER.get(), ModBlocks.CHERRY_KITCHEN_DRAWER.get(),
                    ModBlocks.CRIMSON_KITCHEN_DRAWER.get(), ModBlocks.WARPED_KITCHEN_DRAWER.get(),
                    ModBlocks.STRIPPED_OAK_KITCHEN_DRAWER.get(), ModBlocks.STRIPPED_SPRUCE_KITCHEN_DRAWER.get(),
                    ModBlocks.STRIPPED_BIRCH_KITCHEN_DRAWER.get(), ModBlocks.STRIPPED_JUNGLE_KITCHEN_DRAWER.get(),
                    ModBlocks.STRIPPED_ACACIA_KITCHEN_DRAWER.get(), ModBlocks.STRIPPED_DARK_OAK_KITCHEN_DRAWER.get(),
                    ModBlocks.STRIPPED_MANGROVE_KITCHEN_DRAWER.get(), ModBlocks.STRIPPED_CHERRY_KITCHEN_DRAWER.get(),
                    ModBlocks.STRIPPED_CRIMSON_KITCHEN_DRAWER.get(), ModBlocks.STRIPPED_WARPED_KITCHEN_DRAWER.get(),
                    ModBlocks.WHITE_KITCHEN_DRAWER.get(), ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get(),
                    ModBlocks.GRAY_KITCHEN_DRAWER.get(), ModBlocks.BLACK_KITCHEN_DRAWER.get(),
                    ModBlocks.BROWN_KITCHEN_DRAWER.get(), ModBlocks.RED_KITCHEN_DRAWER.get(),
                    ModBlocks.ORANGE_KITCHEN_DRAWER.get(), ModBlocks.BEIGE_KITCHEN_DRAWER.get(),
                    ModBlocks.YELLOW_KITCHEN_DRAWER.get(), ModBlocks.LIME_KITCHEN_DRAWER.get(),
                    ModBlocks.GREEN_KITCHEN_DRAWER.get(), ModBlocks.CYAN_KITCHEN_DRAWER.get(),
                    ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get(), ModBlocks.BLUE_KITCHEN_DRAWER.get(),
                    ModBlocks.PURPLE_KITCHEN_DRAWER.get(), ModBlocks.MAGENTA_KITCHEN_DRAWER.get(),
                    ModBlocks.PINK_KITCHEN_DRAWER.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KitchenSinkBlockEntity>> KITCHEN_SINK =
            BLOCK_ENTITY_TYPES.register("kitchen_sink", () -> BlockEntityType.Builder.of(
                    KitchenSinkBlockEntity::new,
                    ModBlocks.OAK_KITCHEN_SINK_LIGHT.get(), ModBlocks.SPRUCE_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.BIRCH_KITCHEN_SINK_LIGHT.get(), ModBlocks.JUNGLE_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.ACACIA_KITCHEN_SINK_LIGHT.get(), ModBlocks.DARK_OAK_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.MANGROVE_KITCHEN_SINK_LIGHT.get(), ModBlocks.CHERRY_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.CRIMSON_KITCHEN_SINK_LIGHT.get(), ModBlocks.WARPED_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.STRIPPED_OAK_KITCHEN_SINK_LIGHT.get(), ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_LIGHT.get(), ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_LIGHT.get(), ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_LIGHT.get(), ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_LIGHT.get(), ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_LIGHT.get(),
                    ModBlocks.OAK_KITCHEN_SINK_DARK.get(), ModBlocks.SPRUCE_KITCHEN_SINK_DARK.get(),
                    ModBlocks.BIRCH_KITCHEN_SINK_DARK.get(), ModBlocks.JUNGLE_KITCHEN_SINK_DARK.get(),
                    ModBlocks.ACACIA_KITCHEN_SINK_DARK.get(), ModBlocks.DARK_OAK_KITCHEN_SINK_DARK.get(),
                    ModBlocks.MANGROVE_KITCHEN_SINK_DARK.get(), ModBlocks.CHERRY_KITCHEN_SINK_DARK.get(),
                    ModBlocks.CRIMSON_KITCHEN_SINK_DARK.get(), ModBlocks.WARPED_KITCHEN_SINK_DARK.get(),
                    ModBlocks.STRIPPED_OAK_KITCHEN_SINK_DARK.get(), ModBlocks.STRIPPED_SPRUCE_KITCHEN_SINK_DARK.get(),
                    ModBlocks.STRIPPED_BIRCH_KITCHEN_SINK_DARK.get(), ModBlocks.STRIPPED_JUNGLE_KITCHEN_SINK_DARK.get(),
                    ModBlocks.STRIPPED_ACACIA_KITCHEN_SINK_DARK.get(), ModBlocks.STRIPPED_DARK_OAK_KITCHEN_SINK_DARK.get(),
                    ModBlocks.STRIPPED_MANGROVE_KITCHEN_SINK_DARK.get(), ModBlocks.STRIPPED_CHERRY_KITCHEN_SINK_DARK.get(),
                    ModBlocks.STRIPPED_CRIMSON_KITCHEN_SINK_DARK.get(), ModBlocks.STRIPPED_WARPED_KITCHEN_SINK_DARK.get(),
                    ModBlocks.WHITE_KITCHEN_SINK.get(), ModBlocks.LIGHT_GRAY_KITCHEN_SINK.get(),
                    ModBlocks.GRAY_KITCHEN_SINK.get(), ModBlocks.BLACK_KITCHEN_SINK.get(),
                    ModBlocks.BROWN_KITCHEN_SINK.get(), ModBlocks.RED_KITCHEN_SINK.get(),
                    ModBlocks.ORANGE_KITCHEN_SINK.get(), ModBlocks.BEIGE_KITCHEN_SINK.get(),
                    ModBlocks.YELLOW_KITCHEN_SINK.get(), ModBlocks.LIME_KITCHEN_SINK.get(),
                    ModBlocks.GREEN_KITCHEN_SINK.get(), ModBlocks.CYAN_KITCHEN_SINK.get(),
                    ModBlocks.LIGHT_BLUE_KITCHEN_SINK.get(), ModBlocks.BLUE_KITCHEN_SINK.get(),
                    ModBlocks.PURPLE_KITCHEN_SINK.get(), ModBlocks.MAGENTA_KITCHEN_SINK.get(),
                    ModBlocks.PINK_KITCHEN_SINK.get()
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
                    ModBlocks.WHITE_TRAMPOLINE.get(), ModBlocks.LIGHT_GRAY_TRAMPOLINE.get(),
                    ModBlocks.GRAY_TRAMPOLINE.get(), ModBlocks.BLACK_TRAMPOLINE.get(),
                    ModBlocks.BROWN_TRAMPOLINE.get(), ModBlocks.RED_TRAMPOLINE.get(),
                    ModBlocks.ORANGE_TRAMPOLINE.get(), ModBlocks.BEIGE_TRAMPOLINE.get(),
                    ModBlocks.YELLOW_TRAMPOLINE.get(), ModBlocks.LIME_TRAMPOLINE.get(),
                    ModBlocks.GREEN_TRAMPOLINE.get(), ModBlocks.CYAN_TRAMPOLINE.get(),
                    ModBlocks.LIGHT_BLUE_TRAMPOLINE.get(), ModBlocks.BLUE_TRAMPOLINE.get(),
                    ModBlocks.PURPLE_TRAMPOLINE.get(), ModBlocks.MAGENTA_TRAMPOLINE.get(),
                    ModBlocks.PINK_TRAMPOLINE.get()
            ).build(null));

}
