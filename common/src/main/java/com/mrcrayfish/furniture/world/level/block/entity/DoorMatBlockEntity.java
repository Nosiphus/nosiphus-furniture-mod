package com.mrcrayfish.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DoorMatBlockEntity extends BlockEntity
{
    private String message = null;

    public DoorMatBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntityTypes.DOOR_MAT.get(), pos, state);
    }

    public void setMessage(String message)
    {
        if(this.message == null)
        {
            this.message = message;
            this.markUpdated();
        }
    }

    public String getMessage()
    {
        return this.message != null ? this.message : "";
    }

    @Override
    public void load(CompoundTag compound)
    {
        super.load(compound);
        if(compound.contains("Message", Tag.TAG_STRING))
        {
            this.message = compound.getString("Message");
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compound)
    {
        super.saveAdditional(compound);
        if(this.message != null)
        {
            compound.putString("Message", this.message);
        }
    }

    @Override
    public CompoundTag getUpdateTag()
    {
        CompoundTag tag = super.getUpdateTag();
        this.saveAdditional(tag);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    private void markUpdated()
    {
        this.setChanged();
        if(this.level != null)
        {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }
}