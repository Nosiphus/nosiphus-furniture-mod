package com.mrcrayfish.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

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
        if(this.level == null || !this.level.isLoaded(pos))
            return;

        BlockEntity tileEntity = this.level.getBlockEntity(pos);
        if(tileEntity instanceof TrampolineBlockEntity trampoline)
        {
            if(trampolines.contains(trampoline))
                return;

            trampolines.add(trampoline);
            this.isTrampoline(trampolines, pos.relative(Direction.NORTH));
            this.isTrampoline(trampolines, pos.relative(Direction.EAST));
            this.isTrampoline(trampolines, pos.relative(Direction.SOUTH));
            this.isTrampoline(trampolines, pos.relative(Direction.WEST));
        }
    }

    @Override
    public void load(CompoundTag compound)
    {
        super.load(compound);
        if (compound.contains("Count", Tag.TAG_INT))
        {
            this.count = compound.getInt("Count");
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compound)
    {
        super.saveAdditional(compound);
        compound.putInt("Count", this.count);
    }

    @Override
    public CompoundTag getUpdateTag()
    {
        CompoundTag tag = super.getUpdateTag();
        this.saveAdditional(tag);
        return tag;
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
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