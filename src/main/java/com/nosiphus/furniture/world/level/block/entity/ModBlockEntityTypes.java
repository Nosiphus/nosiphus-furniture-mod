package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "nfm");

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WallCabinetBlockEntity>> WALL_CABINET =
            BLOCK_ENTITY_TYPES.register("wall_cabinet", () -> BlockEntityType.Builder.of(
                    WallCabinetBlockEntity::new,
                    ModBlocks.WHITE_WALL_CABINET.get(), ModBlocks.LIGHT_GRAY_WALL_CABINET.get(),
                    ModBlocks.GRAY_WALL_CABINET.get(), ModBlocks.BLACK_WALL_CABINET.get(),
                    ModBlocks.BROWN_WALL_CABINET.get(), ModBlocks.RED_WALL_CABINET.get(),
                    ModBlocks.ORANGE_WALL_CABINET.get(), ModBlocks.BEIGE_WALL_CABINET.get(),
                    ModBlocks.YELLOW_WALL_CABINET.get(), ModBlocks.LIME_WALL_CABINET.get(),
                    ModBlocks.GREEN_WALL_CABINET.get(), ModBlocks.CYAN_WALL_CABINET.get(),
                    ModBlocks.LIGHT_BLUE_WALL_CABINET.get(), ModBlocks.BLUE_WALL_CABINET.get(),
                    ModBlocks.PURPLE_WALL_CABINET.get(), ModBlocks.MAGENTA_WALL_CABINET.get(),
                    ModBlocks.PINK_WALL_CABINET.get()
            ).build(null));

}
