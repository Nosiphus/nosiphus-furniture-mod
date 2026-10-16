package com.nosiphus.furniture.network;

import com.nosiphus.furniture.FurnitureConfig;
import com.nosiphus.furniture.network.protocol.common.ServerboundBinEmpty;
import com.nosiphus.furniture.network.protocol.common.ServerboundTVChannelSync;
import com.nosiphus.furniture.network.protocol.common.ServerboundTVURLSync;
import com.nosiphus.furniture.world.inventory.BinMenu;
import com.nosiphus.furniture.world.level.block.CathodeRayTubeTelevisionBlock;
import com.nosiphus.furniture.world.level.block.LiquidCrystalDisplayTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.LiquidCrystalDisplayTelevisionBlockEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ServerPacketHandlers {

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

        if (FurnitureConfig.requireOpToSetUrls() && !isSingleplayer && !isOp) {
            player.sendSystemMessage(Component.literal("Only server operators can set TV URLs on this server."));
            return;
        }

        if (payload.channel() < 0 || payload.channel() > ServerboundTVURLSync.MAX_CHANNEL) {
            return;
        }

        if (!player.level().isLoaded(payload.pos())) {
            return;
        }

        String rawUrl = payload.url();
        String normalizedUrl = UrlValidator.normalizeUrl(rawUrl);

        // If the URL is not empty, it must pass the server's trusted URL validation rules
        if (!normalizedUrl.isEmpty() && !UrlValidator.isTrustedUrl(normalizedUrl)) {
            player.sendSystemMessage(Component.literal("URL rejected: Must be HTTPS and on the server allowlist."));
            return;
        }

        BlockEntity be = player.level().getBlockEntity(payload.pos());
        if (be instanceof CathodeRayTubeTelevisionBlockEntity tv) {
            applyUrlToTv(player, tv::setChannelUrl, payload.channel(), normalizedUrl);
        } else if (be instanceof LiquidCrystalDisplayTelevisionBlockEntity tv) {
            applyUrlToTv(player, tv::setChannelUrl, payload.channel(), normalizedUrl);
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