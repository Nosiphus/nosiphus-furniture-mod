package com.mrcrayfish.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

public abstract class FluidHandlerSyncedBlockEntity extends BlockEntity implements IFluidBlockEntity {

    protected Fluid fluid = Fluids.EMPTY;
    protected int fluidAmount = 0;
    protected final int capacity;

    public FluidHandlerSyncedBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int capacity) {
        super(type, pos, state);
        this.capacity = capacity;
    }

    @Override
    public Fluid getFluid() {
        return this.fluid;
    }

    @Override
    public int getFluidAmount() {
        return this.fluidAmount;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    public void setFluid(Fluid fluid, int amount) {
        if (fluid == null || fluid == Fluids.EMPTY || amount <= 0) {
            this.fluid = Fluids.EMPTY;
            this.fluidAmount = 0;
        } else {
            this.fluid = fluid;
            this.fluidAmount = Math.min(amount, this.capacity);
        }
        this.markUpdated();
    }

    public boolean canFill(Fluid fluid, int amount) {
        if (fluid == null || fluid == Fluids.EMPTY || amount <= 0) return false;
        if (this.fluid == Fluids.EMPTY || this.fluidAmount <= 0) {
            return amount <= this.capacity;
        }
        return this.fluid == fluid && (this.fluidAmount + amount) <= this.capacity;
    }

    public boolean fill(Fluid fluid, int amount) {
        if (!this.canFill(fluid, amount)) return false;
        this.fluid = fluid;
        this.fluidAmount = Math.min(this.capacity, this.fluidAmount + amount);
        this.markUpdated();
        return true;
    }

    public boolean drain(int amount) {
        if (this.fluid == Fluids.EMPTY || this.fluidAmount <= 0 || amount <= 0) return false;
        this.fluidAmount -= amount;
        if (this.fluidAmount <= 0) {
            this.fluid = Fluids.EMPTY;
            this.fluidAmount = 0;
        }
        this.markUpdated();
        return true;
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("FluidName")) {
            this.fluid = BuiltInRegistries.FLUID.get(ResourceLocation.tryParse(tag.getString("FluidName")));
        } else {
            this.fluid = Fluids.EMPTY;
        }
        this.fluidAmount = tag.getInt("Amount");
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        if (this.fluid != Fluids.EMPTY) {
            tag.putString("FluidName", BuiltInRegistries.FLUID.getKey(this.fluid).toString());
        }
        tag.putInt("Amount", this.fluidAmount);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries) {
        if (pkt.getTag() != null) {
            this.loadAdditional(pkt.getTag(), registries);
        }
    }
}