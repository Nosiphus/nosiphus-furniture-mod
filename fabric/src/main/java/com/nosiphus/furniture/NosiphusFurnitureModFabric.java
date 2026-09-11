package com.nosiphus.furniture;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.mrcrayfish.furniture.world.level.fluid.FabricFluidStorage;
import com.nosiphus.furniture.network.PacketHandlerFabric;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class NosiphusFurnitureModFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        NosiphusFurnitureMod.init();
        PacketHandlerFabric.init();
        registerFluidStorages();

        FurnitureConfigFabric.init();
    }

    public static void registerFluidStorages() {
        registerTank(ModBlockEntityTypes.BATH);
        registerTank(ModBlockEntityTypes.BIRD_BATH);
        registerTank(ModBlockEntityTypes.DISHWASHER);
        registerTank(ModBlockEntityTypes.SINK);
        registerTank(ModBlockEntityTypes.TAP);
        registerTank(ModBlockEntityTypes.TOILET);
        registerTank(ModBlockEntityTypes.WASHING_MACHINE);
        registerTank(ModBlockEntityTypes.WATER_TANK);
    }

    private static <T extends BlockEntity> void registerTank(Supplier<BlockEntityType<T>> typeSupplier) {
        if (typeSupplier != null && typeSupplier.get() != null) {
            FluidStorage.SIDED.registerForBlockEntity((be, direction) -> {
                if (be instanceof FluidHandlerSyncedBlockEntity fluidBe) {
                    return new FabricFluidStorage(fluidBe);
                }
                return null;
            }, typeSupplier.get());
        }
    }
}
