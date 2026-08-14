package com.mrcrayfish.furniture.world.level.fluid;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.StoragePreconditions;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public class FabricFluidStorage implements SingleSlotStorage<FluidVariant> {

    private final FluidHandlerSyncedBlockEntity entity;

    public FabricFluidStorage(FluidHandlerSyncedBlockEntity entity) {
        this.entity = entity;
    }

    @Override
    public FluidVariant getResource() {
        Fluid fluid = this.entity.getFluid();
        return (fluid == null || fluid == Fluids.EMPTY) ? FluidVariant.blank() : FluidVariant.of(fluid);
    }

    @Override
    public long getAmount() {
        return (long) this.entity.getFluidAmount() * (FluidConstants.BUCKET / 1000);
    }

    @Override
    public long getCapacity() {
        return (long) this.entity.getCapacity() * (FluidConstants.BUCKET / 1000);
    }

    @Override
    public long insert(FluidVariant resource, long maxAmount, TransactionContext transaction) {
        StoragePreconditions.notBlankNotNegative(resource, maxAmount);
        int maxAmountMb = (int) (maxAmount / (FluidConstants.BUCKET / 1000));
        if (maxAmountMb <= 0 || !this.entity.canFill(resource.getFluid(), 1)) return 0;

        int spaceMb = this.entity.getCapacity() - this.entity.getFluidAmount();
        int insertedMb = Math.min(spaceMb, maxAmountMb);

        if (insertedMb > 0) {
            transaction.addCloseCallback((tx, result) -> {
                if (result.wasCommitted()) {
                    this.entity.fill(resource.getFluid(), insertedMb);
                }
            });
            return (long) insertedMb * (FluidConstants.BUCKET / 1000);
        }
        return 0;
    }

    @Override
    public long extract(FluidVariant resource, long maxAmount, TransactionContext transaction) {
        StoragePreconditions.notBlankNotNegative(resource, maxAmount);
        if (!resource.isOf(this.entity.getFluid())) return 0;

        int maxAmountMb = (int) (maxAmount / (FluidConstants.BUCKET / 1000));
        int currentMb = this.entity.getFluidAmount();
        int extractedMb = Math.min(currentMb, maxAmountMb);

        if (extractedMb > 0) {
            transaction.addCloseCallback((tx, result) -> {
                if (result.wasCommitted()) {
                    this.entity.drain(extractedMb);
                }
            });
            return (long) extractedMb * (FluidConstants.BUCKET / 1000);
        }
        return 0;
    }

    @Override
    public boolean isResourceBlank() {
        return false;
    }
}