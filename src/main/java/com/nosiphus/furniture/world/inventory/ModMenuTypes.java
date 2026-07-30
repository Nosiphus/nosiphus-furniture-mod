package com.nosiphus.furniture.world.inventory;

import com.nosiphus.furniture.world.level.block.entity.BinBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.WallCabinetBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, "nfm");

    public static final DeferredHolder<MenuType<?>, MenuType<BinMenu>> BIN = MENU_TYPES.register("bin",
            () -> IMenuTypeExtension.create((windowId, inv, data) ->
            {
                BlockPos pos = data.readBlockPos();
                BinBlockEntity bin = (BinBlockEntity) inv.player.level().getBlockEntity(pos);
                return new BinMenu(windowId, inv, bin);
            })
    );

    public static final DeferredHolder<MenuType<?>, MenuType<CathodeRayTubeTelevisionMenu>> CATHODE_RAY_TUBE_TELEVISION = MENU_TYPES.register("cathode_ray_tube_television",
            () -> IMenuTypeExtension.create(CathodeRayTubeTelevisionMenu::new));

    public static final DeferredHolder<MenuType<?>, MenuType<DishwasherMenu>> DISHWASHER = MENU_TYPES.register("dishwasher",
            () -> IMenuTypeExtension.create(DishwasherMenu::new)
    );

    public static final DeferredHolder<MenuType<?>, MenuType<MicrowaveMenu>> MICROWAVE = MENU_TYPES.register("microwave",
            () -> IMenuTypeExtension.create(MicrowaveMenu::new)
    );

    public static final DeferredHolder<MenuType<?>, MenuType<OvenMenu>> OVEN = MENU_TYPES.register("oven",
            () -> IMenuTypeExtension.create(OvenMenu::new)
    );

    public static final DeferredHolder<MenuType<?>, MenuType<PrinterMenu>> PRINTER = MENU_TYPES.register("printer",
            () -> IMenuTypeExtension.create(PrinterMenu::new)
    );

    public static final DeferredHolder<MenuType<?>, MenuType<WallCabinetMenu>> WALL_CABINET = MENU_TYPES.register("wall_cabinet",
            () -> IMenuTypeExtension.create((windowId, inv, data) ->
            {
                BlockPos pos = data.readBlockPos();
                WallCabinetBlockEntity wallCabinet = (WallCabinetBlockEntity) inv.player.level().getBlockEntity(pos);
                return new WallCabinetMenu(windowId, inv, wallCabinet);
            })
    );

    public static final DeferredHolder<MenuType<?>, MenuType<WashingMachineMenu>> WASHING_MACHINE = MENU_TYPES.register("washing_machine",
            () -> IMenuTypeExtension.create(WashingMachineMenu::new)
    );

}
