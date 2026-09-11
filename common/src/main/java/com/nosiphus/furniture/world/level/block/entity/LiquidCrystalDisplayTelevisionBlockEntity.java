package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.client.renderer.blockentity.GifFrameCache;
import com.nosiphus.furniture.world.inventory.LiquidCrystalDisplayTelevisionMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Container;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class LiquidCrystalDisplayTelevisionBlockEntity extends BlockEntity implements MenuProvider {

    private final String[] channelUrls = new String[]{"", "", ""};

    public LiquidCrystalDisplayTelevisionBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), pos, state);
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
        if (this.level != null && this.level.isClientSide()) {
            for (int i = 0; i < 3; i++) {
                String url = getChannelUrl(i);
                if (url != null && !url.isBlank()) {
                    GifFrameCache.getInstance().releaseUrlIfUnused(url);
                }
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("ChannelUrl0", this.channelUrls[0]);
        tag.putString("ChannelUrl1", this.channelUrls[1]);
        tag.putString("ChannelUrl2", this.channelUrls[2]);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("ChannelUrl0")) this.channelUrls[0] = tag.getString("ChannelUrl0");
        if (tag.contains("ChannelUrl1")) this.channelUrls[1] = tag.getString("ChannelUrl1");
        if (tag.contains("ChannelUrl2")) this.channelUrls[2] = tag.getString("ChannelUrl2");
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public String getChannelUrl(int channel) {
        if (channel >= 0 && channel < this.channelUrls.length) {
            return this.channelUrls[channel];
        }
        return "";
    }

    public void setChannelUrl(int channel, String url) {
        if (channel >= 0 && channel < this.channelUrls.length) {
            this.channelUrls[channel] = url != null ? url : "";
            this.markUpdated();
            if (this.level != null && !this.level.isClientSide()) {
                this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), 3);
            }
        }
    }

    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.nfm.liquid_crystal_display_television");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new LiquidCrystalDisplayTelevisionMenu(id, inventory, this);
    }
}