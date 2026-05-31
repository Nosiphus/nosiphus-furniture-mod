package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.inventory.CathodeRayTubeTelevisionMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
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

public class CathodeRayTubeTelevisionBlockEntity extends BlockEntity implements MenuProvider {

    private boolean power = false;
    private int channel = 0;
    private String gifUrl = "";

    public CathodeRayTubeTelevisionBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.CATHODE_RAY_TUBE_TELEVISION.get(), pos, state);
    }

    public boolean isPowered() {
        return power;
    }

    public int getChannel() {
        return channel;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String url) {
        this.gifUrl = url == null ? "" : url;
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    public void setPowerAndChannel(boolean power, int channel) {
        this.power = power;
        this.channel = channel;
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.nfm.cathode_ray_tube_television");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new CathodeRayTubeTelevisionMenu(id, inventory, this);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putBoolean("crt_tv.power", this.power);
        tag.putInt("crt_tv.channel", this.channel);
        tag.putString("crt_tv.gifUrl", this.gifUrl);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.power = tag.getBoolean("crt_tv.power");
        this.channel = tag.getInt("crt_tv.channel");
        this.gifUrl = tag.getString("crt_tv.gifUrl");
    }
}
