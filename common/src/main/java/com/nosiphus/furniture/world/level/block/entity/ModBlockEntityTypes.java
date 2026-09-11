package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.platform.Services;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModBlockEntityTypes {

    public static void init() {

    }

    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> register(String name, Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        return Services.REGISTRY.registerBlockEntityType(name, blockEntityTypeSupplier);
    }

    public static final Supplier<BlockEntityType<BathBlockEntity>> BATH =
            register("bath", () -> BlockEntityType.Builder.of(
                    BathBlockEntity::new,
                    ModBlocks.BATH_LIGHT.get(), ModBlocks.BATH_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<BinBlockEntity>> BIN =
            register("bin", () -> BlockEntityType.Builder.of(
                    BinBlockEntity::new,
                    ModBlocks.BIN_LIGHT.get(), ModBlocks.BIN_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<BirdBathBlockEntity>> BIRD_BATH =
            register("bird_bath", () -> BlockEntityType.Builder.of(
                    BirdBathBlockEntity::new,
                    ModBlocks.STONE_BIRD_BATH.get(), ModBlocks.ANDESITE_BIRD_BATH.get(),
                    ModBlocks.DIORITE_BIRD_BATH.get(), ModBlocks.GRANITE_BIRD_BATH.get(),
                    ModBlocks.BLACKSTONE_BIRD_BATH.get(), ModBlocks.DEEPSLATE_BIRD_BATH.get()
            ).build(null));

    public static final Supplier<BlockEntityType<CathodeRayTubeTelevisionBlockEntity>> CATHODE_RAY_TUBE_TELEVISION =
            register("cathode_ray_tube_television", () -> BlockEntityType.Builder.of(
                    CathodeRayTubeTelevisionBlockEntity::new,
                    ModBlocks.CATHODE_RAY_TUBE_TELEVISION.get()
            ).build(null));

    public static final Supplier<BlockEntityType<ChoppingBoardBlockEntity>> CHOPPING_BOARD =
            register("chopping_board", () -> BlockEntityType.Builder.of(
                    ChoppingBoardBlockEntity::new,
                    ModBlocks.OAK_CHOPPING_BOARD.get(), ModBlocks.SPRUCE_CHOPPING_BOARD.get(),
                    ModBlocks.BIRCH_CHOPPING_BOARD.get(), ModBlocks.JUNGLE_CHOPPING_BOARD.get(),
                    ModBlocks.ACACIA_CHOPPING_BOARD.get(), ModBlocks.DARK_OAK_CHOPPING_BOARD.get(),
                    ModBlocks.MANGROVE_CHOPPING_BOARD.get(), ModBlocks.CHERRY_CHOPPING_BOARD.get(),
                    ModBlocks.CRIMSON_CHOPPING_BOARD.get(), ModBlocks.WARPED_CHOPPING_BOARD.get()
            ).build(null));

    public static final Supplier<BlockEntityType<CookieJarBlockEntity>> COOKIE_JAR =
            register("cookie_jar", () -> BlockEntityType.Builder.of(
                    CookieJarBlockEntity::new,
                    ModBlocks.COOKIE_JAR.get()
            ).build(null));

    public static final Supplier<BlockEntityType<DigitalClockBlockEntity>> DIGITAL_CLOCK =
            register("digital_clock", () -> BlockEntityType.Builder.of(DigitalClockBlockEntity::new,
                    Stream.of(
                                    ModBlocks.WHITE_DIGITAL_CLOCK,
                                    ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK,
                                    ModBlocks.GRAY_DIGITAL_CLOCK,
                                    ModBlocks.BLACK_DIGITAL_CLOCK,
                                    ModBlocks.BROWN_DIGITAL_CLOCK,
                                    ModBlocks.RED_DIGITAL_CLOCK,
                                    ModBlocks.ORANGE_DIGITAL_CLOCK,
                                    Services.PLATFORM.isModLoaded("yogmod") ? ModBlocks.BEIGE_DIGITAL_CLOCK : null,
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
                            .map(Supplier::get)
                            .toArray(Block[]::new)
            ).build(null));

    public static final Supplier<BlockEntityType<DishwasherBlockEntity>> DISHWASHER =
            register("dishwasher", () -> BlockEntityType.Builder.of(
                    DishwasherBlockEntity::new,
                    ModBlocks.DISHWASHER_LIGHT.get(), ModBlocks.DISHWASHER_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<FireAlarmBlockEntity>> FIRE_ALARM =
            register("fire_alarm", () -> BlockEntityType.Builder.of(
                    FireAlarmBlockEntity::new,
                    ModBlocks.FIRE_ALARM.get()
            ).build(null));

    public static final Supplier<BlockEntityType<LiquidCrystalDisplayTelevisionBlockEntity>> LIQUID_CRYSTAL_DISPLAY_TELEVISION =
            register("liquid_crystal_display_television", () -> BlockEntityType.Builder.of(
                    LiquidCrystalDisplayTelevisionBlockEntity::new,
                    ModBlocks.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get()
            ).build(null));

    public static final Supplier<BlockEntityType<MicrowaveBlockEntity>> MICROWAVE =
            register("microwave", () -> BlockEntityType.Builder.of(
                    MicrowaveBlockEntity::new,
                    ModBlocks.MICROWAVE_LIGHT.get(), ModBlocks.MICROWAVE_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<OvenBlockEntity>> OVEN =
            register("oven", () -> BlockEntityType.Builder.of(
                    OvenBlockEntity::new,
                    ModBlocks.OVEN_LIGHT.get(), ModBlocks.OVEN_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<PlateBlockEntity>> PLATE =
            register("plate", () -> BlockEntityType.Builder.of(
                    PlateBlockEntity::new,
                    ModBlocks.PLATE.get()
            ).build(null));

    public static final Supplier<BlockEntityType<PrinterBlockEntity>> PRINTER =
            register("printer", () -> BlockEntityType.Builder.of(
                    PrinterBlockEntity::new,
                    ModBlocks.PRINTER.get()
            ).build(null));

    public static final Supplier<BlockEntityType<ShowerHeadBlockEntity>> SHOWER_HEAD =
            register("shower_head", () -> BlockEntityType.Builder.of(
                    ShowerHeadBlockEntity::new,
                    ModBlocks.SHOWER_HEAD_LIGHT.get(), ModBlocks.SHOWER_HEAD_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<SinkBlockEntity>> SINK =
            register("sink", () -> BlockEntityType.Builder.of(
                    SinkBlockEntity::new,
                    ModBlocks.SINK_LIGHT.get(), ModBlocks.SINK_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<StereoBlockEntity>> STEREO =
            register("stereo", () -> BlockEntityType.Builder.of(
                    StereoBlockEntity::new,
                    ModBlocks.STEREO.get()
            ).build(null));

    public static final Supplier<BlockEntityType<TapBlockEntity>> TAP =
            register("tap", () -> BlockEntityType.Builder.of(
                    TapBlockEntity::new,
                    ModBlocks.STONE_TAP.get(), ModBlocks.ANDESITE_TAP.get(),
                    ModBlocks.DIORITE_TAP.get(), ModBlocks.GRANITE_TAP.get(),
                    ModBlocks.BLACKSTONE_TAP.get(), ModBlocks.DEEPSLATE_TAP.get()
            ).build(null));

    public static final Supplier<BlockEntityType<ToasterBlockEntity>> TOASTER =
            register("toaster", () -> BlockEntityType.Builder.of(
                    ToasterBlockEntity::new,
                    ModBlocks.TOASTER_LIGHT.get(), ModBlocks.TOASTER_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<ToiletBlockEntity>> TOILET =
            register("toilet", () -> BlockEntityType.Builder.of(
                    ToiletBlockEntity::new,
                    ModBlocks.TOILET_LIGHT.get(), ModBlocks.TOILET_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<TelevisionStandBlockEntity>> TELEVISION_STAND =
            register("television_stand", () -> BlockEntityType.Builder.of(TelevisionStandBlockEntity::new,
                    Stream.of(
                                    ModBlocks.WHITE_TELEVISION_STAND,
                                    ModBlocks.LIGHT_GRAY_TELEVISION_STAND,
                                    ModBlocks.GRAY_TELEVISION_STAND,
                                    ModBlocks.BLACK_TELEVISION_STAND,
                                    ModBlocks.BROWN_TELEVISION_STAND,
                                    ModBlocks.RED_TELEVISION_STAND,
                                    ModBlocks.ORANGE_TELEVISION_STAND,
                                    Services.PLATFORM.isModLoaded("yogmod") ? ModBlocks.BEIGE_TELEVISION_STAND : null,
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
                            .map(Supplier::get)
                            .toArray(Block[]::new)
            ).build(null));

    public static final Supplier<BlockEntityType<WallCabinetBlockEntity>> WALL_CABINET =
            register("wall_cabinet", () -> BlockEntityType.Builder.of(WallCabinetBlockEntity::new,
                    Stream.of(
                                    ModBlocks.WHITE_WALL_CABINET,
                                    ModBlocks.LIGHT_GRAY_WALL_CABINET,
                                    ModBlocks.GRAY_WALL_CABINET,
                                    ModBlocks.BLACK_WALL_CABINET,
                                    ModBlocks.BROWN_WALL_CABINET,
                                    ModBlocks.RED_WALL_CABINET,
                                    ModBlocks.ORANGE_WALL_CABINET,
                                    Services.PLATFORM.isModLoaded("yogmod") ? ModBlocks.BEIGE_WALL_CABINET : null,
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
                            .map(Supplier::get)
                            .toArray(Block[]::new)
            ).build(null));

    public static final Supplier<BlockEntityType<WashingMachineBlockEntity>> WASHING_MACHINE =
            register("washing_machine", () -> BlockEntityType.Builder.of(
                    WashingMachineBlockEntity::new,
                    ModBlocks.WASHING_MACHINE_LIGHT.get(), ModBlocks.WASHING_MACHINE_DARK.get()
            ).build(null));

    public static final Supplier<BlockEntityType<WaterTankBlockEntity>> WATER_TANK =
            register("water_tank", () -> BlockEntityType.Builder.of(
                    WaterTankBlockEntity::new,
                    ModBlocks.OAK_WATER_TANK.get(), ModBlocks.SPRUCE_WATER_TANK.get(),
                    ModBlocks.BIRCH_WATER_TANK.get(), ModBlocks.JUNGLE_WATER_TANK.get(),
                    ModBlocks.ACACIA_WATER_TANK.get(), ModBlocks.DARK_OAK_WATER_TANK.get(),
                    ModBlocks.MANGROVE_WATER_TANK.get(), ModBlocks.CHERRY_WATER_TANK.get(),
                    ModBlocks.CRIMSON_WATER_TANK.get(), ModBlocks.WARPED_WATER_TANK.get()
            ).build(null));

}