package com.mrcrayfish.furniture.platform;

import com.mrcrayfish.furniture.world.level.block.entity.FluidHandlerSyncedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

import java.util.Map;
import java.util.WeakHashMap;

public class NeoForgeFluidHelper implements IFluidHandler {

    private static final Map<FluidHandlerSyncedBlockEntity, NeoForgeFluidHelper> CACHE = new WeakHashMap<>();

    public static NeoForgeFluidHelper of(FluidHandlerSyncedBlockEntity blockEntity) {
        return CACHE.computeIfAbsent(blockEntity, NeoForgeFluidHelper::new);
    }

    private final FluidHandlerSyncedBlockEntity blockEntity;

    public NeoForgeFluidHelper(FluidHandlerSyncedBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    private void invalidateCapabilityCache() {
        Level level = this.blockEntity.getLevel();
        BlockPos pos = this.blockEntity.getBlockPos();
        if (level != null && !level.isClientSide) {
            level.invalidateCapabilities(pos);
        }
    }

    @Override
    public int getTanks() {
        return 1;
    }

    @Override
    public FluidStack getFluidInTank(int tank) {
        if (tank != 0 || this.blockEntity.getFluid() == Fluids.EMPTY || this.blockEntity.getFluidAmount() <= 0) {
            return FluidStack.EMPTY;
        }
        return new FluidStack(this.blockEntity.getFluid(), this.blockEntity.getFluidAmount());
    }

    @Override
    public int getTankCapacity(int tank) {
        return tank == 0 ? this.blockEntity.getCapacity() : 0;
    }

    @Override
    public boolean isFluidValid(int tank, FluidStack stack) {
        return tank == 0 && !stack.isEmpty();
    }

    @Override
    public int fill(FluidStack resource, FluidAction action) {
        if (resource.isEmpty()) return 0;

        if (this.blockEntity.getFluid() != Fluids.EMPTY && this.blockEntity.getFluid() != resource.getFluid()) {
            return 0;
        }

        int currentAmount = this.blockEntity.getFluidAmount();
        int space = this.blockEntity.getCapacity() - currentAmount;
        int toFill = Math.min(space, resource.getAmount());

        if (toFill > 0 && action.execute()) {
            this.blockEntity.fill(resource.getFluid(), toFill);
            this.invalidateCapabilityCache();
        }
        return toFill;
    }

    @Override
    public FluidStack drain(FluidStack resource, FluidAction action) {
        if (resource.isEmpty() || this.blockEntity.getFluid() == Fluids.EMPTY || this.blockEntity.getFluid() != resource.getFluid()) {
            return FluidStack.EMPTY;
        }
        return this.drain(resource.getAmount(), action);
    }

    @Override
    public FluidStack drain(int maxDrain, FluidAction action) {
        if (maxDrain <= 0 || this.blockEntity.getFluid() == Fluids.EMPTY || this.blockEntity.getFluidAmount() <= 0) {
            return FluidStack.EMPTY;
        }

        int toDrain = Math.min(this.blockEntity.getFluidAmount(), maxDrain);
        FluidStack drained = new FluidStack(this.blockEntity.getFluid(), toDrain);

        if (action.execute()) {
            this.blockEntity.drain(toDrain);
            this.invalidateCapabilityCache();
        }
        return drained;
    }
}