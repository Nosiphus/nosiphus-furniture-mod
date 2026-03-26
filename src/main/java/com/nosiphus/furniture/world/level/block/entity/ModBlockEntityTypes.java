package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.world.level.block.entity.CabinetBlockEntity;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "nfm");

    /*
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CabinetBlockEntity>> CABINET =
            BLOCK_ENTITY_TYPES.register("cabinet", () -> BlockEntityType.Builder.of(
                    CabinetBlockEntity::new,
                    ModBlocks.STONE_CABINET.get(), ModBlocks.ANDESITE_CABINET.get(),
                    ModBlocks.DIORITE_CABINET.get(), ModBlocks.GRANITE_CABINET.get(),
                    ModBlocks.BLACKSTONE_CABINET.get(), ModBlocks.DEEPSLATE_CABINET.get(),
                    ModBlocks.WHITE_MODERN_CABINET.get(), ModBlocks.LIGHT_GRAY_MODERN_CABINET.get(),
                    ModBlocks.GRAY_MODERN_CABINET.get(), ModBlocks.BLACK_MODERN_CABINET.get(),
                    ModBlocks.BROWN_MODERN_CABINET.get(), ModBlocks.RED_MODERN_CABINET.get(),
                    ModBlocks.ORANGE_MODERN_CABINET.get(), ModBlocks.BEIGE_MODERN_CABINET.get(),
                    ModBlocks.YELLOW_MODERN_CABINET.get(), ModBlocks.LIME_MODERN_CABINET.get(),
                    ModBlocks.GREEN_MODERN_CABINET.get(), ModBlocks.CYAN_MODERN_CABINET.get(),
                    ModBlocks.LIGHT_BLUE_MODERN_CABINET.get(), ModBlocks.BLUE_MODERN_CABINET.get(),
                    ModBlocks.PURPLE_MODERN_CABINET.get(), ModBlocks.MAGENTA_MODERN_CABINET.get(),
                    ModBlocks.PINK_MODERN_CABINET.get()
            ).build(null));

     */

}
