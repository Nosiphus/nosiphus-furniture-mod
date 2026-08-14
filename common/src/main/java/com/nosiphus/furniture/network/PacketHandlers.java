package com.nosiphus.furniture.network;

import com.nosiphus.furniture.FurnitureConfig;
import com.nosiphus.furniture.network.protocol.common.*;
import com.nosiphus.furniture.world.inventory.BinMenu;
import com.nosiphus.furniture.world.level.block.CathodeRayTubeTelevisionBlock;
import com.nosiphus.furniture.world.level.block.LiquidCrystalDisplayTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.DishwasherBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.LiquidCrystalDisplayTelevisionBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.WashingMachineBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class PacketHandlers {

    public static void handleDishwasherSync(ClientboundDishwasherSync payload) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.level().getBlockEntity(payload.pos()) instanceof DishwasherBlockEntity dishwasher) {
            dishwasher.setFluid(payload.fluid(), payload.fluidAmount());
            dishwasher.setWashing(payload.washing());
        }
    }

    public static void handleWashingMachineSync(ClientboundWashingMachineSync payload) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.level().getBlockEntity(payload.pos()) instanceof WashingMachineBlockEntity washingMachine) {
            washingMachine.setFluid(payload.fluid(), payload.fluidAmount());
            washingMachine.setWashing(payload.washing());
        }
    }

    public static void handleBinEmpty(ServerboundBinEmpty payload, ServerPlayer player) {
        if (player.containerMenu instanceof BinMenu binMenu) {
            if (binMenu.getBlockEntity().getBlockPos().equals(payload.pos())) {
                BinMenu.emptyBin(binMenu);
            }
        }
    }

    public static void handleTVChannelSync(ServerboundTVChannelSync payload, ServerPlayer player) {
        if (player.level().isLoaded(payload.pos())) {
            BlockState state = player.level().getBlockState(payload.pos());
            IntegerProperty channelProperty = null;
            if (state.hasProperty(CathodeRayTubeTelevisionBlock.CHANNEL)) {
                channelProperty = CathodeRayTubeTelevisionBlock.CHANNEL;
            } else if (state.hasProperty(LiquidCrystalDisplayTelevisionBlock.CHANNEL)) {
                channelProperty = LiquidCrystalDisplayTelevisionBlock.CHANNEL;
            }
            if (channelProperty != null && payload.channel() >= 0 && payload.channel() <= 2) {
                player.level().setBlock(payload.pos(), state.setValue(channelProperty, payload.channel()), 3);
            }
        }
    }

    public static void handleTVURLSync(ServerboundTVURLSync payload, ServerPlayer player) {
        boolean isSingleplayer = player.getServer() != null && player.getServer().isSingleplayer();
        boolean isOp = player.hasPermissions(2);
        boolean opRequired = FurnitureConfig.isRequireOpToSetUrls();

        if (opRequired && !isSingleplayer && !isOp) {
            player.sendSystemMessage(Component.literal("Only server operators can set TV URLs on this server."));
            return;
        }

        if (payload.channel() < 0 || payload.channel() > ServerboundTVURLSync.MAX_CHANNEL) {
            return;
        }

        if (player.level().isLoaded(payload.pos())) {
            BlockEntity be = player.level().getBlockEntity(payload.pos());
            if (be instanceof CathodeRayTubeTelevisionBlockEntity tv) {
                applyUrlToTv(player, tv::setChannelUrl, payload.channel(), payload.url());
            } else if (be instanceof LiquidCrystalDisplayTelevisionBlockEntity tv) {
                applyUrlToTv(player, tv::setChannelUrl, payload.channel(), payload.url());
            }
        }
    }

    private static void applyUrlToTv(ServerPlayer player, ChannelUrlSetter setter, int channel, String rawUrl) {
        String inputUrl = rawUrl.trim();
        if (inputUrl.isEmpty()) {
            setter.setUrl(channel, "");
            return;
        }
        if (UrlValidator.isTrustedUrl(inputUrl)) {
            setter.setUrl(channel, inputUrl);
        } else {
            player.sendSystemMessage(Component.literal("URL rejected: Must be HTTPS and listed on the server allowlist."));
        }
    }

    @FunctionalInterface
    private interface ChannelUrlSetter {
        void setUrl(int channel, String url);
    }
}