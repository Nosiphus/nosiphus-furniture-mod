package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.level.block.CathodeRayTubeTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.handling.IPayloadContext;

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

    public static void handle(ServerboundTVChannelSync payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {
                if (player.level().isLoaded(payload.pos())) {
                    BlockState state = player.level().getBlockState(payload.pos());
                    if (state.hasProperty(CathodeRayTubeTelevisionBlock.CHANNEL) && payload.channel() >= 0 && payload.channel() <= 2) {
                        player.level().setBlock(payload.pos(), state.setValue(CathodeRayTubeTelevisionBlock.CHANNEL, payload.channel()), 3);
                    }
                }
            }
        });
    }
}