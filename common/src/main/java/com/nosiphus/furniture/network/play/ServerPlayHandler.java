package com.nosiphus.furniture.network.play;

import com.nosiphus.furniture.FurnitureConfig;
import com.nosiphus.furniture.network.UrlValidator;
import com.nosiphus.furniture.network.message.C2SMessageEmptyBin;
import com.nosiphus.furniture.network.message.C2SMessageTVChannelSync;
import com.nosiphus.furniture.network.message.C2SMessageTVURLSync;
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

public class ServerPlayHandler {

    public static void handleEmptyBinMessage(ServerPlayer player, C2SMessageEmptyBin message) {
        if (!player.level().isLoaded(message.pos())) return;
        if (player.containerMenu instanceof BinMenu binMenu && binMenu.getBlockEntity().getBlockPos().equals(message.pos())) {
            BinMenu.emptyBin(binMenu);
        }
    }

    public static void handleTVChannelSync(ServerPlayer player, C2SMessageTVChannelSync message) {
        if (!player.level().isLoaded(message.pos())) return;

        BlockState state = player.level().getBlockState(message.pos());
        IntegerProperty prop = null;
        if (state.hasProperty(CathodeRayTubeTelevisionBlock.CHANNEL)) {
            prop = CathodeRayTubeTelevisionBlock.CHANNEL;
        } else if (state.hasProperty(LiquidCrystalDisplayTelevisionBlock.CHANNEL)) {
            prop = LiquidCrystalDisplayTelevisionBlock.CHANNEL;
        }

        if (prop != null && message.channel() >= 0 && message.channel() <= 2) {
            player.level().setBlock(message.pos(), state.setValue(prop, message.channel()), 3);
        }
    }

    public static void handleTVURLSync(ServerPlayer player, C2SMessageTVURLSync message) {
        boolean isSingleplayer = player.getServer() != null && player.getServer().isSingleplayer();
        boolean isOp = player.hasPermissions(2);

        if (FurnitureConfig.isRequireOpToSetUrls() && !isSingleplayer && !isOp) {
            player.sendSystemMessage(Component.literal("Only server operators can set TV URLs on this server."));
            return;
        }

        if (message.channel() < 0 || message.channel() > 2) return;
        if (!player.level().isLoaded(message.pos())) return;

        BlockEntity be = player.level().getBlockEntity(message.pos());
        String url = message.url().trim();
        if (!url.isEmpty() && !UrlValidator.isTrustedUrl(url)) {
            player.sendSystemMessage(Component.literal("URL rejected: Must be HTTPS and on the server allowlist."));
            return;
        }

        if (be instanceof CathodeRayTubeTelevisionBlockEntity tv) {
            tv.setChannelUrl(message.channel(), url);
        } else if (be instanceof LiquidCrystalDisplayTelevisionBlockEntity tv) {
            tv.setChannelUrl(message.channel(), url);
        }
    }
}