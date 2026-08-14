package com.nosiphus.furniture.network.protocol.common;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ServerboundTVURLSync(BlockPos pos, int channel, String url) implements CustomPacketPayload {

    public static final int MAX_URL_LEN = 512;
    public static final int MAX_CHANNEL = 2;

    public static final Type<ServerboundTVURLSync> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath("nfm", "serverbound_tv_url_sync"));

    public static final StreamCodec<FriendlyByteBuf, ServerboundTVURLSync> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundTVURLSync::pos,
            ByteBufCodecs.VAR_INT, ServerboundTVURLSync::channel,
            ByteBufCodecs.stringUtf8(MAX_URL_LEN), ServerboundTVURLSync::url,
            ServerboundTVURLSync::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}