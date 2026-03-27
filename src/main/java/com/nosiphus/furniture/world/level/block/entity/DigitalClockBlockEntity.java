package com.nosiphus.furniture.world.level.block.entity;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class DigitalClockBlockEntity extends BlockEntity {

    private DyeColor textColor = DyeColor.WHITE;

    public DigitalClockBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.DIGITAL_CLOCK.get(), pos, state);
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("textColor", CompoundTag.TAG_BYTE)) {
            this.textColor = DyeColor.byId(tag.getByte("textColor"));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putByte("textColor", (byte) textColor.getId());
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public DyeColor getTextColor() {
        return textColor;
    }

    public void setTextColor(DyeColor textColor) {
        this.textColor = textColor;
        this.markUpdated();
    }

    public static String getFormattedTime(long ticks) {
        int hours = (int) ((Math.floor(ticks / 1000.0) + 6) % 24);
        int minutes = (int) Math.floor((ticks % 1000) / 1000.0 * 60);
        return String.format("%02d:%02d", hours, minutes);
    }

    public static ChatFormatting getFromColor(DyeColor color) {
        return switch (color) {
            case ORANGE, BROWN -> ChatFormatting.GOLD;
            case MAGENTA, PINK -> ChatFormatting.LIGHT_PURPLE;
            case LIGHT_BLUE -> ChatFormatting.BLUE;
            case YELLOW -> ChatFormatting.YELLOW;
            case LIME -> ChatFormatting.GREEN;
            case GRAY -> ChatFormatting.DARK_GRAY;
            case LIGHT_GRAY -> ChatFormatting.GRAY;
            case CYAN -> ChatFormatting.DARK_AQUA;
            case PURPLE -> ChatFormatting.DARK_PURPLE;
            case BLUE -> ChatFormatting.DARK_BLUE;
            case GREEN -> ChatFormatting.DARK_GREEN;
            case RED -> ChatFormatting.DARK_RED;
            case BLACK -> ChatFormatting.BLACK;
            default -> ChatFormatting.WHITE;
        };
    }

}