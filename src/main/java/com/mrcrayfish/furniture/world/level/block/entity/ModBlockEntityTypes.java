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

}
