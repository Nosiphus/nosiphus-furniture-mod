package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.inventory.LiquidCrystalDisplayTelevisionMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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

    private boolean power = false;
    private int channel = 0;

    public LiquidCrystalDisplayTelevisionBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.LIQUID_CRYSTAL_DISPLAY_TELEVISION.get(), pos, state);
    }

    public boolean isPowered() {
        return power;
    }

    public int getChannel() {
        return channel;
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
        return Component.translatable("container.nfm.liquid_crystal_display_television");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new LiquidCrystalDisplayTelevisionMenu(id, inventory, this);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.putBoolean("lcd_tv.power", this.power);
        tag.putInt("lcd_tv.channel", this.channel);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.power = tag.getBoolean("lcd_tv.power");
        this.channel = tag.getInt("lcd_tv.channel");
    }
}
