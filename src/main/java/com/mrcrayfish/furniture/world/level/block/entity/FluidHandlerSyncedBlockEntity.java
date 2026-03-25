package com.mrcrayfish.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

/**
 * Author: MrCrayfish
 */
public abstract class FluidHandlerSyncedBlockEntity extends BlockEntity
{
    protected final FluidTank tank;

    public FluidHandlerSyncedBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, int capacity)
    {
        super(type, pos, state);
        this.tank = new FluidTank(capacity)
        {
            @Override
            protected void onContentsChanged()
            {
                FluidHandlerSyncedBlockEntity.this.markUpdated();
            }
        };
    }

    public FluidTank getTank()
    {
        return this.tank;
    }

    protected void markUpdated()
    {
        this.setChanged();
        if(this.level != null)
        {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.tank.readFromNBT(registries, tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        this.tank.writeToNBT(registries, tag);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries)
    {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries)
    {
        // Re-load the data on the client side when the packet arrives
        this.loadAdditional(pkt.getTag(), registries);
    }
}