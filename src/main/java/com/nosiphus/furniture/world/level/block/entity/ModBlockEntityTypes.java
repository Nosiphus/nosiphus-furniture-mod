package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlockEntityTypes {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "nfm");

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BathBlockEntity>> BATH =
            BLOCK_ENTITY_TYPES.register("bath", () -> BlockEntityType.Builder.of(
                    BathBlockEntity::new,
                    ModBlocks.BATH_LIGHT.get(), ModBlocks.BATH_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BinBlockEntity>> BIN =
            BLOCK_ENTITY_TYPES.register("bin", () -> BlockEntityType.Builder.of(
                    BinBlockEntity::new,
                    ModBlocks.BIN_LIGHT.get(), ModBlocks.BIN_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BirdBathBlockEntity>> BIRD_BATH =
            BLOCK_ENTITY_TYPES.register("bird_bath", () -> BlockEntityType.Builder.of(
                    BirdBathBlockEntity::new,
                    ModBlocks.STONE_BIRD_BATH.get(), ModBlocks.ANDESITE_BIRD_BATH.get(),
                    ModBlocks.DIORITE_BIRD_BATH.get(), ModBlocks.GRANITE_BIRD_BATH.get(),
                    ModBlocks.BLACKSTONE_BIRD_BATH.get(), ModBlocks.DEEPSLATE_BIRD_BATH.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ChoppingBoardBlockEntity>> CHOPPING_BOARD =
            BLOCK_ENTITY_TYPES.register("chopping_board", () -> BlockEntityType.Builder.of(
                    ChoppingBoardBlockEntity::new,
                    ModBlocks.OAK_CHOPPING_BOARD.get(), ModBlocks.SPRUCE_CHOPPING_BOARD.get(),
                    ModBlocks.BIRCH_CHOPPING_BOARD.get(), ModBlocks.JUNGLE_CHOPPING_BOARD.get(),
                    ModBlocks.ACACIA_CHOPPING_BOARD.get(), ModBlocks.DARK_OAK_CHOPPING_BOARD.get(),
                    ModBlocks.MANGROVE_CHOPPING_BOARD.get(), ModBlocks.CHERRY_CHOPPING_BOARD.get(),
                    ModBlocks.CHERRY_CHOPPING_BOARD.get(), ModBlocks.WARPED_CHOPPING_BOARD.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CookieJarBlockEntity>> COOKIE_JAR =
            BLOCK_ENTITY_TYPES.register("cookie_jar", () -> BlockEntityType.Builder.of(
                    CookieJarBlockEntity::new,
                    ModBlocks.COOKIE_JAR.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DigitalClockBlockEntity>> DIGITAL_CLOCK =
            BLOCK_ENTITY_TYPES.register("digital_clock", () -> BlockEntityType.Builder.of(
                    DigitalClockBlockEntity::new,
                    ModBlocks.WHITE_DIGITAL_CLOCK.get(), ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get(),
                    ModBlocks.GRAY_DIGITAL_CLOCK.get(), ModBlocks.BLACK_DIGITAL_CLOCK.get(),
                    ModBlocks.BROWN_DIGITAL_CLOCK.get(), ModBlocks.RED_DIGITAL_CLOCK.get(),
                    ModBlocks.ORANGE_DIGITAL_CLOCK.get(), ModBlocks.BEIGE_DIGITAL_CLOCK.get(),
                    ModBlocks.YELLOW_DIGITAL_CLOCK.get(), ModBlocks.LIME_DIGITAL_CLOCK.get(),
                    ModBlocks.GREEN_DIGITAL_CLOCK.get(), ModBlocks.CYAN_DIGITAL_CLOCK.get(),
                    ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get(), ModBlocks.BLUE_DIGITAL_CLOCK.get(),
                    ModBlocks.PURPLE_DIGITAL_CLOCK.get(), ModBlocks.MAGENTA_DIGITAL_CLOCK.get(),
                    ModBlocks.PINK_DIGITAL_CLOCK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PlateBlockEntity>> PLATE =
            BLOCK_ENTITY_TYPES.register("plate", () -> BlockEntityType.Builder.of(
                    PlateBlockEntity::new,
                    ModBlocks.PLATE.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TelevisionStandBlockEntity>> TELEVISION_STAND =
            BLOCK_ENTITY_TYPES.register("television_stand", () -> BlockEntityType.Builder.of(
                    TelevisionStandBlockEntity::new,
                    ModBlocks.WHITE_TELEVISION_STAND.get(), ModBlocks.LIGHT_GRAY_TELEVISION_STAND.get(),
                    ModBlocks.GRAY_TELEVISION_STAND.get(), ModBlocks.BLACK_TELEVISION_STAND.get(),
                    ModBlocks.BROWN_TELEVISION_STAND.get(), ModBlocks.RED_TELEVISION_STAND.get(),
                    ModBlocks.ORANGE_TELEVISION_STAND.get(), ModBlocks.BEIGE_TELEVISION_STAND.get(),
                    ModBlocks.YELLOW_TELEVISION_STAND.get(), ModBlocks.LIME_TELEVISION_STAND.get(),
                    ModBlocks.GREEN_TELEVISION_STAND.get(), ModBlocks.CYAN_TELEVISION_STAND.get(),
                    ModBlocks.LIGHT_BLUE_TELEVISION_STAND.get(), ModBlocks.BLUE_TELEVISION_STAND.get(),
                    ModBlocks.PURPLE_TELEVISION_STAND.get(), ModBlocks.MAGENTA_TELEVISION_STAND.get(),
                    ModBlocks.PINK_TELEVISION_STAND.get()
            ).build(null));

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

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WaterTankBlockEntity>> WATER_TANK =
            BLOCK_ENTITY_TYPES.register("water_tank", () -> BlockEntityType.Builder.of(
                    WaterTankBlockEntity::new,
                    ModBlocks.OAK_WATER_TANK.get(), ModBlocks.SPRUCE_WATER_TANK.get(),
                    ModBlocks.BIRCH_WATER_TANK.get(), ModBlocks.JUNGLE_WATER_TANK.get(),
                    ModBlocks.ACACIA_WATER_TANK.get(), ModBlocks.DARK_OAK_WATER_TANK.get(),
                    ModBlocks.MANGROVE_WATER_TANK.get(), ModBlocks.CHERRY_WATER_TANK.get(),
                    ModBlocks.CHERRY_WATER_TANK.get(), ModBlocks.WARPED_WATER_TANK.get()
            ).build(null));

}
