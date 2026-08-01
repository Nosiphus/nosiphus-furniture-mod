package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.FurnitureConfig;
import com.nosiphus.furniture.network.protocol.UrlValidator;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import com.nosiphus.furniture.world.level.block.entity.LiquidCrystalDisplayTelevisionBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundTVURLSync(BlockPos pos, int channel, String url) implements CustomPacketPayload {

    public static final Type<ServerboundTVURLSync> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath("nfm", "serverbound_tv_url_sync"));

    public static final StreamCodec<FriendlyByteBuf, ServerboundTVURLSync> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundTVURLSync::pos,
            ByteBufCodecs.VAR_INT, ServerboundTVURLSync::channel,
            ByteBufCodecs.STRING_UTF8, ServerboundTVURLSync::url,
            ServerboundTVURLSync::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(ServerboundTVURLSync payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {

                boolean isSingleplayer = player.getServer() != null && player.getServer().isSingleplayer();
                boolean isOp = player.hasPermissions(2);
                boolean opRequired = FurnitureConfig.COMMON.requireOpToSetUrls.get();

                if (opRequired && !isSingleplayer && !isOp) {
                    player.sendSystemMessage(Component.literal("Only server operators can set TV URLs on this server."));
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
        });
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