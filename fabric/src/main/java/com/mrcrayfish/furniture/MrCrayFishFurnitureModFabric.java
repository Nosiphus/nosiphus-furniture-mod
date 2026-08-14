package com.mrcrayfish.furniture;

import com.mrcrayfish.furniture.network.NetworkFabric;
import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import com.mrcrayfish.furniture.world.level.fluid.FabricFluidStorage;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class MrCrayFishFurnitureModFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        MrCrayFishFurnitureMod.init();
        NetworkFabric.register();
        registerFluidStorages();

        FurnitureConfigFabric.init();
    }

    public static void registerFluidStorages() {
        registerTank(ModBlockEntityTypes.KITCHEN_SINK);
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
