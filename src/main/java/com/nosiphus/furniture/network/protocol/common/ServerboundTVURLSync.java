package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.network.protocol.UrlValidator;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundTVURLSync(BlockPos pos, int channel, String url) implements CustomPacketPayload {

    public static final Type<ServerboundTVURLSync> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath("cfm", "serverbound_tv_url_sync"));

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
                if (player.level().isLoaded(payload.pos()) &&
                        player.level().getBlockEntity(payload.pos()) instanceof CathodeRayTubeTelevisionBlockEntity tv) {

                    String inputUrl = payload.url().trim();

                    if (inputUrl.isEmpty()) {
                        tv.setChannelUrl(payload.channel(), "");
                        return;
                    }

                    if (UrlValidator.isTrustedUrl(inputUrl)) {
                        tv.setChannelUrl(payload.channel(), inputUrl);
                    }
                }
            }
        });
    }
}