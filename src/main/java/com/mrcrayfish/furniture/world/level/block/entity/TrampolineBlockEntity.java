package com.mrcrayfish.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: MrCrayfish
 */
public class TrampolineBlockEntity extends BlockEntity
{
    private int count = 1;

    public TrampolineBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntityTypes.TRAMPOLINE.get(), pos, state);
    }

    protected TrampolineBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    @Override
    public void onLoad()
    {
        super.onLoad();
        if (this.level != null && !this.level.isClientSide)
        {
            this.markUpdated();
        }
    }

    public void setCount(int count)
    {
        this.count = count;
        this.markUpdated();
    }

    public int getCount()
    {
        return this.count;
    }

    public void updateCount()
    {
        Set<TrampolineBlockEntity> trampolines = new HashSet<>();
        this.isTrampoline(trampolines, this.worldPosition);
        trampolines.forEach(trampoline -> trampoline.setCount(trampolines.size()));
    }

    private void isTrampoline(Set<TrampolineBlockEntity> trampolines, BlockPos pos)
    {
        if(this.level == null)
            return;

        BlockEntity tileEntity = this.level.getBlockEntity(pos);
        if(tileEntity instanceof TrampolineBlockEntity)
        {
            if(trampolines.contains(tileEntity))
                return;

            trampolines.add((TrampolineBlockEntity) tileEntity);
            this.isTrampoline(trampolines, pos.relative(Direction.NORTH));
            this.isTrampoline(trampolines, pos.relative(Direction.EAST));
            this.isTrampoline(trampolines, pos.relative(Direction.SOUTH));
            this.isTrampoline(trampolines, pos.relative(Direction.WEST));
        }
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider registries)
    {
        super.loadAdditional(compound, registries);
        if (compound.contains("Count", Tag.TAG_INT))
        {
            this.count = compound.getInt("Count");
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider registries)
    {
        super.saveAdditional(compound, registries);
        compound.putInt("Count", this.count);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries)
    {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt, HolderLookup.Provider registries)
    {
        CompoundTag compound = pkt.getTag();
        this.loadAdditional(compound, registries);
    }

    public void markUpdated()
    {
        this.setChanged();
        if(this.level != null)
        {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }
}