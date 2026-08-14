package com.nosiphus.furniture.network.protocol.common;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ServerboundTVChannelSync(BlockPos pos, int channel) implements CustomPacketPayload {

    public static final Type<ServerboundTVChannelSync> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath("nfm", "select_tv_channel"));

    public static final StreamCodec<FriendlyByteBuf, ServerboundTVChannelSync> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundTVChannelSync::pos,
            ByteBufCodecs.VAR_INT, ServerboundTVChannelSync::channel,
            ServerboundTVChannelSync::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}