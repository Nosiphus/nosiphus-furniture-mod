package com.mrcrayfish.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.inventory.CrateMenu;
import com.mrcrayfish.furniture.world.level.block.CabinetBlock;
import com.mrcrayfish.furniture.world.level.block.CrateBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Author: MrCrayfish
 */
public class CrateBlockEntity extends BasicLootBlockEntity
{
    private UUID ownerUuid;
    private boolean locked;

    protected CrateBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    public CrateBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntityTypes.CRATE.get(), pos, state);
    }

    @Override
    public int getContainerSize()
    {
        return 27;
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container.cfm.crate");
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory)
    {
        if(this.locked && !this.ownerUuid.equals(playerInventory.player.getUUID()))
        {
            playerInventory.player.displayClientMessage(Component.translatable("container.isLocked", this.getDisplayName()), true);
            playerInventory.player.playNotifySound(SoundEvents.CHEST_LOCKED, SoundSource.BLOCKS, 1.0F, 1.0F);
            return null;
        }
        return new CrateMenu(windowId, playerInventory, this, this.locked);
    }

    @Override
    public boolean isMatchingContainerMenu(AbstractContainerMenu menu)
    {
        return menu instanceof CrateMenu crateMenu && crateMenu.getBlockEntity() == this;
    }

    public UUID getOwner()
    {
        return ownerUuid;
    }

    public void setOwner(UUID uuid)
    {
        this.ownerUuid = uuid;
        this.markUpdated();
    }

    public boolean isLocked()
    {
        return this.locked;
    }

    public void setLocked(boolean locked)
    {
        this.locked = locked;
        this.markUpdated();
    }

    @Override
    public void onOpen(Level level, BlockPos pos, BlockState state)
    {
        this.playLidSound(state, ModSoundEvents.BLOCK_CABINET_OPEN.get());
        this.setLidState(state, true);
    }

    @Override
    public void onClose(Level level, BlockPos pos, BlockState state)
    {
        this.playLidSound(state, ModSoundEvents.BLOCK_CABINET_CLOSE.get());
        this.setLidState(state, false);
    }

    public void removeUnauthorisedPlayers()
    {
        if (this.locked && this.level != null)
        {
            BlockPos pos = this.getBlockPos();
            AABB area = new AABB(pos).inflate(5.0);
            for (Player player : this.level.getEntitiesOfClass(Player.class, area))
            {
                if (player.containerMenu instanceof CrateMenu menu)
                {
                    if (menu.getBlockEntity() == this && !player.getUUID().equals(this.ownerUuid))
                    {
                        player.closeContainer();
                    }
                }
            }
        }
    }

    private void playLidSound(BlockState state, SoundEvent event)
    {
        Vec3i directionVec = state.getValue(CabinetBlock.DIRECTION).getNormal();
        double x = this.worldPosition.getX() + 0.5D + directionVec.getX() / 2.0D;
        double y = this.worldPosition.getY() + 0.5D + directionVec.getY() / 2.0D;
        double z = this.worldPosition.getZ() + 0.5D + directionVec.getZ() / 2.0D;
        Level level = this.getLevel();
        if(level != null)
        {
            level.playSound(null, x, y, z, event, SoundSource.BLOCKS, 0.75F, level.random.nextFloat() * 0.1F + 0.7F);
        }
    }

    private void setLidState(BlockState state, boolean open)
    {
        Level level = this.getLevel();
        if(level != null)
        {
            level.setBlock(this.getBlockPos(), state.setValue(CrateBlock.OPEN, open), 3);
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.readData(tag);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        this.writeData(tag);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries)
    {
        CompoundTag tag = super.getUpdateTag(registries);
        this.writeData(tag);
        return tag;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    private void readData(CompoundTag compound)
    {
        if(compound.hasUUID("OwnerUUID"))
        {
            this.ownerUuid = compound.getUUID("OwnerUUID");
        }
        if(compound.contains("Locked", Tag.TAG_BYTE))
        {
            this.locked = compound.getBoolean("Locked");
        }
    }

    private CompoundTag writeData(CompoundTag compound)
    {
        if(this.ownerUuid != null)
        {
            compound.putUUID("OwnerUUID", this.ownerUuid);
        }
        compound.putBoolean("Locked", this.locked);
        return compound;
    }

    public void markUpdated()
    {
        this.setChanged();
        if(this.level != null)
        {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack itemStack, @Nullable Direction direction)
    {
        return !locked;
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack itemStack, Direction direction)
    {
        return !locked;
    }
}