package com.mrcrayfish.furniture.world.level.block.entity.yogmod;

import com.mrcrayfish.furniture.world.level.block.entity.BlockEntityUtil;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
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
public class YogTrampolineBlockEntity extends BlockEntity
{
    private int count = 1;

    public YogTrampolineBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntityTypes.YOG_TRAMPOLINE.get(), pos, state);
    }

    protected YogTrampolineBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    @Override
    public void onLoad()
    {
        super.onLoad();
        if (this.level != null && !this.level.isClientSide)
        {
            BlockEntityUtil.sendUpdatePacket(this);
        }
    }

    public void setCount(int count)
    {
        this.count = count;
        this.setChanged();
        BlockEntityUtil.sendUpdatePacket(this);
    }

    public int getCount()
    {
        return this.count;
    }

    public void updateCount()
    {
        Set<YogTrampolineBlockEntity> trampolines = new HashSet<>();
        this.isTrampoline(trampolines, this.worldPosition);
        trampolines.forEach(trampoline -> trampoline.setCount(trampolines.size()));
    }

    private void isTrampoline(Set<YogTrampolineBlockEntity> trampolines, BlockPos pos)
    {
        if(this.level == null)
            return;

        BlockEntity tileEntity = this.level.getBlockEntity(pos);
        if(tileEntity instanceof YogTrampolineBlockEntity)
        {
            if(trampolines.contains(tileEntity))
                return;

            trampolines.add((YogTrampolineBlockEntity) tileEntity);
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
        if (compound != null)
        {
            this.loadAdditional(compound, registries);
        }
    }

    private void readData(CompoundTag compound)
    {
        if(compound.contains("Count", Tag.TAG_INT))
        {
            this.count = compound.getInt("Count");
        }
    }

    private CompoundTag writeData(CompoundTag compound)
    {
        compound.putInt("Count", this.count);
        return compound;
    }
}