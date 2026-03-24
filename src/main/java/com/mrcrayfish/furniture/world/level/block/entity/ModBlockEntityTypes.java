package com.mrcrayfish.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.ModBlocks;
import com.mrcrayfish.furniture.world.level.block.entity.yogmod.YogCoolerBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.yogmod.YogTrampolineBlockEntity;
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
                    ModBlocks.ORANGE_COOLER.get(), ModBlocks.YELLOW_COOLER.get(),
                    ModBlocks.LIME_COOLER.get(), ModBlocks.GREEN_COOLER.get(),
                    ModBlocks.CYAN_COOLER.get(), ModBlocks.LIGHT_BLUE_COOLER.get(),
                    ModBlocks.BLUE_COOLER.get(), ModBlocks.PURPLE_COOLER.get(),
                    ModBlocks.MAGENTA_COOLER.get(), ModBlocks.PINK_COOLER.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<YogCoolerBlockEntity>> YOG_COOLER =
            BLOCK_ENTITY_TYPES.register("yog_cooler", () -> BlockEntityType.Builder.of(
                    YogCoolerBlockEntity::new,
                    ModBlocks.BEIGE_COOLER.get()
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
                    ModBlocks.ORANGE_TRAMPOLINE.get(), ModBlocks.YELLOW_TRAMPOLINE.get(),
                    ModBlocks.LIME_TRAMPOLINE.get(), ModBlocks.GREEN_TRAMPOLINE.get(),
                    ModBlocks.CYAN_TRAMPOLINE.get(), ModBlocks.LIGHT_BLUE_TRAMPOLINE.get(),
                    ModBlocks.BLUE_TRAMPOLINE.get(), ModBlocks.PURPLE_TRAMPOLINE.get(),
                    ModBlocks.MAGENTA_TRAMPOLINE.get(), ModBlocks.PINK_TRAMPOLINE.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<YogTrampolineBlockEntity>> YOG_TRAMPOLINE =
            BLOCK_ENTITY_TYPES.register("yog_trampoline", () -> BlockEntityType.Builder.of(
                    YogTrampolineBlockEntity::new,
                    ModBlocks.BEIGE_TRAMPOLINE.get()
            ).build(null));



}
