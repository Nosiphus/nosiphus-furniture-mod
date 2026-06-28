package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Objects;
import java.util.stream.Stream;

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
            BLOCK_ENTITY_TYPES.register("digital_clock", () -> BlockEntityType.Builder.of(DigitalClockBlockEntity::new,
                    Stream.of(
                            ModBlocks.WHITE_DIGITAL_CLOCK,
                                    ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK,
                                    ModBlocks.GRAY_DIGITAL_CLOCK,
                                    ModBlocks.BLACK_DIGITAL_CLOCK,
                                    ModBlocks.BROWN_DIGITAL_CLOCK,
                                    ModBlocks.RED_DIGITAL_CLOCK,
                                    ModBlocks.ORANGE_DIGITAL_CLOCK,
                                    ModList.get().isLoaded("yogmod") ? ModBlocks.BEIGE_DIGITAL_CLOCK : null,
                                    ModBlocks.YELLOW_DIGITAL_CLOCK,
                                    ModBlocks.LIME_DIGITAL_CLOCK,
                                    ModBlocks.GREEN_DIGITAL_CLOCK,
                                    ModBlocks.CYAN_DIGITAL_CLOCK,
                                    ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK,
                                    ModBlocks.BLUE_DIGITAL_CLOCK,
                                    ModBlocks.PURPLE_DIGITAL_CLOCK,
                                    ModBlocks.MAGENTA_DIGITAL_CLOCK,
                                    ModBlocks.PINK_DIGITAL_CLOCK
                            ).filter(Objects::nonNull)
                            .map(DeferredHolder::get)
                            .toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DishwasherBlockEntity>> DISHWASHER =
            BLOCK_ENTITY_TYPES.register("dishwasher", () -> BlockEntityType.Builder.of(
                    DishwasherBlockEntity::new,
                    ModBlocks.DISHWASHER_LIGHT.get(), ModBlocks.DISHWASHER_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FireAlarmBlockEntity>> FIRE_ALARM =
            BLOCK_ENTITY_TYPES.register("fire_alarm", () -> BlockEntityType.Builder.of(
                    FireAlarmBlockEntity::new,
                    ModBlocks.FIRE_ALARM.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MicrowaveBlockEntity>> MICROWAVE =
            BLOCK_ENTITY_TYPES.register("microwave", () -> BlockEntityType.Builder.of(
                    MicrowaveBlockEntity::new,
                    ModBlocks.MICROWAVE_LIGHT.get(), ModBlocks.MICROWAVE_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OvenBlockEntity>> OVEN =
            BLOCK_ENTITY_TYPES.register("oven", () -> BlockEntityType.Builder.of(
                    OvenBlockEntity::new,
                    ModBlocks.OVEN_LIGHT.get(), ModBlocks.OVEN_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PlateBlockEntity>> PLATE =
            BLOCK_ENTITY_TYPES.register("plate", () -> BlockEntityType.Builder.of(
                    PlateBlockEntity::new,
                    ModBlocks.PLATE.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PrinterBlockEntity>> PRINTER =
            BLOCK_ENTITY_TYPES.register("printer", () -> BlockEntityType.Builder.of(
                    PrinterBlockEntity::new,
                    ModBlocks.PRINTER.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ShowerHeadBlockEntity>> SHOWER_HEAD =
            BLOCK_ENTITY_TYPES.register("shower_head", () -> BlockEntityType.Builder.of(
                    ShowerHeadBlockEntity::new,
                    ModBlocks.SHOWER_HEAD_LIGHT.get(), ModBlocks.SHOWER_HEAD_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SinkBlockEntity>> SINK =
            BLOCK_ENTITY_TYPES.register("sink", () -> BlockEntityType.Builder.of(
                    SinkBlockEntity::new,
                    ModBlocks.SINK_LIGHT.get(), ModBlocks.SINK_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StereoBlockEntity>> STEREO =
            BLOCK_ENTITY_TYPES.register("stereo", () -> BlockEntityType.Builder.of(
                    StereoBlockEntity::new,
                    ModBlocks.STEREO.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TapBlockEntity>> TAP =
            BLOCK_ENTITY_TYPES.register("tap", () -> BlockEntityType.Builder.of(
                    TapBlockEntity::new,
                    ModBlocks.STONE_TAP.get(), ModBlocks.ANDESITE_TAP.get(),
                    ModBlocks.DIORITE_TAP.get(), ModBlocks.GRANITE_TAP.get(),
                    ModBlocks.BLACKSTONE_TAP.get(), ModBlocks.DEEPSLATE_TAP.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ToasterBlockEntity>> TOASTER =
            BLOCK_ENTITY_TYPES.register("toaster", () -> BlockEntityType.Builder.of(
                    ToasterBlockEntity::new,
                    ModBlocks.TOASTER_LIGHT.get(), ModBlocks.TOASTER_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ToiletBlockEntity>> TOILET =
            BLOCK_ENTITY_TYPES.register("toilet", () -> BlockEntityType.Builder.of(
                    ToiletBlockEntity::new,
                    ModBlocks.TOILET_LIGHT.get(), ModBlocks.TOILET_DARK.get()
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TelevisionStandBlockEntity>> TELEVISION_STAND =
            BLOCK_ENTITY_TYPES.register("television_stand", () -> BlockEntityType.Builder.of(TelevisionStandBlockEntity::new,
                    Stream.of(
                            ModBlocks.WHITE_TELEVISION_STAND,
                                    ModBlocks.LIGHT_GRAY_TELEVISION_STAND,
                                    ModBlocks.GRAY_TELEVISION_STAND,
                                    ModBlocks.BLACK_TELEVISION_STAND,
                                    ModBlocks.BROWN_TELEVISION_STAND,
                                    ModBlocks.RED_TELEVISION_STAND,
                                    ModBlocks.ORANGE_TELEVISION_STAND,
                                    ModList.get().isLoaded("yogmod") ? ModBlocks.BEIGE_TELEVISION_STAND : null,
                                    ModBlocks.YELLOW_TELEVISION_STAND,
                                    ModBlocks.LIME_TELEVISION_STAND,
                                    ModBlocks.GREEN_TELEVISION_STAND,
                                    ModBlocks.CYAN_TELEVISION_STAND,
                                    ModBlocks.LIGHT_BLUE_TELEVISION_STAND,
                                    ModBlocks.BLUE_TELEVISION_STAND,
                                    ModBlocks.PURPLE_TELEVISION_STAND,
                                    ModBlocks.MAGENTA_TELEVISION_STAND,
                                    ModBlocks.PINK_TELEVISION_STAND
                            ).filter(Objects::nonNull)
                            .map(DeferredHolder::get)
                            .toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WallCabinetBlockEntity>> WALL_CABINET =
            BLOCK_ENTITY_TYPES.register("wall_cabinet", () -> BlockEntityType.Builder.of(WallCabinetBlockEntity::new,
                    Stream.of(
                            ModBlocks.WHITE_WALL_CABINET,
                                    ModBlocks.LIGHT_GRAY_WALL_CABINET,
                                    ModBlocks.GRAY_WALL_CABINET,
                                    ModBlocks.BLACK_WALL_CABINET,
                                    ModBlocks.BROWN_WALL_CABINET,
                                    ModBlocks.RED_WALL_CABINET,
                                    ModBlocks.ORANGE_WALL_CABINET,
                                    ModList.get().isLoaded("yogmod") ? ModBlocks.BEIGE_WALL_CABINET : null,
                                    ModBlocks.YELLOW_WALL_CABINET,
                                    ModBlocks.LIME_WALL_CABINET,
                                    ModBlocks.GREEN_WALL_CABINET,
                                    ModBlocks.CYAN_WALL_CABINET,
                                    ModBlocks.LIGHT_BLUE_WALL_CABINET,
                                    ModBlocks.BLUE_WALL_CABINET,
                                    ModBlocks.PURPLE_WALL_CABINET,
                                    ModBlocks.MAGENTA_WALL_CABINET,
                                    ModBlocks.PINK_WALL_CABINET
                            ).filter(Objects::nonNull)
                            .map(DeferredHolder::get)
                            .toArray(Block[]::new)
            ).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WashingMachineBlockEntity>> WASHING_MACHINE =
            BLOCK_ENTITY_TYPES.register("washing_machine", () -> BlockEntityType.Builder.of(
                    WashingMachineBlockEntity::new,
                    ModBlocks.WASHING_MACHINE_LIGHT.get(), ModBlocks.WASHING_MACHINE_DARK.get()
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
