package com.mrcrayfish.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.FurnitureConfig;
import com.mrcrayfish.furniture.world.inventory.MailBoxMenu;
import com.mrcrayfish.furniture.world.mail.Mail;
import com.mrcrayfish.furniture.world.mail.PostOffice;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.function.Supplier;

public class MailBoxBlockEntity extends BasicLootBlockEntity
{
    private UUID id;
    private String name = "Mail Box";
    private String ownerName;
    private UUID ownerId;

    protected MailBoxBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state)
    {
        super(type, pos, state);
    }

    public MailBoxBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntityTypes.MAIL_BOX.get(), pos, state);
    }

    public void setId(UUID id)
    {
        if(this.id == null)
        {
            this.id = id;
            this.setChanged();
        }
    }

    @Nullable
    public UUID getId()
    {
        return this.id;
    }

    public void setMailBoxName(String name)
    {
        this.name = name;
        this.markUpdated();
    }

    public String getMailBoxName()
    {
        return name;
    }

    public void setOwner(ServerPlayer entity)
    {
        this.ownerId = entity.getUUID();
        this.ownerName = entity.getName().getString();
        this.markUpdated();
    }

    @Nullable
    public UUID getOwnerId()
    {
        return this.ownerId;
    }

    @Nullable
    public String getOwnerName()
    {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName)
    {
        this.ownerName = ownerName;
    }

    public void updateOwnerName(ServerPlayer player)
    {
        if(player.getUUID().equals(this.ownerId))
        {
            if(!player.getName().getString().equals(this.ownerName))
            {
                this.ownerName = player.getName().getString();
                this.markUpdated();
            }
        }
    }

    public void updateIdAndAttemptClaim(ServerPlayer player)
    {
        boolean changed = false;
        if(this.id == null)
        {
            this.id = UUID.randomUUID();
            changed = true;
        }
        if(this.ownerId == null)
        {
            this.ownerId = player.getUUID();
            this.ownerName = player.getName().getString();
            changed = true;
        }
        if(changed) this.markUpdated();
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, MailBoxBlockEntity blockEntity)
    {
        MinecraftServer server = level.getServer();
        if(server == null || blockEntity.getOwnerId() == null || blockEntity.getId() == null)
            return;

        if(!PostOffice.isRegistered(server, blockEntity.getOwnerId(), blockEntity.getId()))
        {
            ServerPlayer player = server.getPlayerList().getPlayer(blockEntity.getOwnerId());
            if(player != null)
            {
                PostOffice.registerMailBox(player, blockEntity.getId(), blockEntity.getMailBoxName(), blockEntity.getBlockPos());
            }
        }
        else if(!blockEntity.isFull() && server.getTickCount() % FurnitureConfig.getPullMailInterval() == 0)
        {
            Supplier<Mail> supplier = PostOffice.getMailForPlayerMailBox(server, blockEntity.getOwnerId(), blockEntity.getId());
            boolean addedMail = false;
            while(!blockEntity.isFull())
            {
                Mail mail = supplier.get();
                if(mail == null) break;
                blockEntity.addItem(mail.getStack());
                addedMail = true;
            }
            if(addedMail) blockEntity.markUpdated();
        }
    }

    @Override
    public int getContainerSize()
    {
        return 9;
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container.cfm.mail_box", this.ownerName, this.name);
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory)
    {
        return new MailBoxMenu(windowId, playerInventory, this);
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        if (compound.hasUUID("MailBoxUUID")) {
            this.id = compound.getUUID("MailBoxUUID");
        }
        if (compound.contains("MailBoxName", Tag.TAG_STRING)) {
            this.name = compound.getString("MailBoxName");
        }
        if (compound.contains("OwnerName", Tag.TAG_STRING)) {
            this.ownerName = compound.getString("OwnerName");
        }
        if (compound.hasUUID("OwnerUUID")) {
            this.ownerId = compound.getUUID("OwnerUUID");
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compound) {
        super.saveAdditional(compound);
        if (this.id != null) {
            compound.putUUID("MailBoxUUID", this.id);
        }
        if (this.name != null) {
            compound.putString("MailBoxName", this.name);
        }
        if (this.ownerName != null && this.ownerId != null) {
            compound.putString("OwnerName", this.ownerName);
            compound.putUUID("OwnerUUID", this.ownerId);
        }
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
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