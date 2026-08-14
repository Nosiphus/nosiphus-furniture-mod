package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.platform.Services;
import com.nosiphus.furniture.world.level.block.entity.BinBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.WallCabinetBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ModMenuTypes {

    public static final Supplier<MenuType<BinMenu>> BIN = Services.REGISTRY.registerMenuType("bin",
            () -> Services.PLATFORM.createMenuType((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                BinBlockEntity bin = (BinBlockEntity) inv.player.level().getBlockEntity(pos);
                return new BinMenu(windowId, inv, bin);
            })
    );

    public static final Supplier<MenuType<CathodeRayTubeTelevisionMenu>> CATHODE_RAY_TUBE_TELEVISION = Services.REGISTRY.registerMenuType("cathode_ray_tube_television",
            () -> Services.PLATFORM.createMenuType(CathodeRayTubeTelevisionMenu::new));

    public static final Supplier<MenuType<DishwasherMenu>> DISHWASHER = Services.REGISTRY.registerMenuType("dishwasher",
            () -> Services.PLATFORM.createMenuType(DishwasherMenu::new));

    public static final Supplier<MenuType<LiquidCrystalDisplayTelevisionMenu>> LIQUID_CRYSTAL_DISPLAY_TELEVISION = Services.REGISTRY.registerMenuType("liquid_crystal_display_television",
            () -> Services.PLATFORM.createMenuType(LiquidCrystalDisplayTelevisionMenu::new));

    public static final Supplier<MenuType<MicrowaveMenu>> MICROWAVE = Services.REGISTRY.registerMenuType("microwave",
            () -> Services.PLATFORM.createMenuType(MicrowaveMenu::new));

    public static final Supplier<MenuType<OvenMenu>> OVEN = Services.REGISTRY.registerMenuType("oven",
            () -> Services.PLATFORM.createMenuType(OvenMenu::new));

    public static final Supplier<MenuType<PrinterMenu>> PRINTER = Services.REGISTRY.registerMenuType("printer",
            () -> Services.PLATFORM.createMenuType(PrinterMenu::new));

    public static final Supplier<MenuType<WallCabinetMenu>> WALL_CABINET = Services.REGISTRY.registerMenuType("wall_cabinet",
            () -> Services.PLATFORM.createMenuType((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                WallCabinetBlockEntity wallCabinet = (WallCabinetBlockEntity) inv.player.level().getBlockEntity(pos);
                return new WallCabinetMenu(windowId, inv, wallCabinet);
            })
    );

    public static final Supplier<MenuType<WashingMachineMenu>> WASHING_MACHINE = Services.REGISTRY.registerMenuType("washing_machine",
            () -> Services.PLATFORM.createMenuType(WashingMachineMenu::new));

    public static void init() {}
}