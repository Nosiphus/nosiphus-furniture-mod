package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.world.level.block.entity.DoorMatBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * Author: MrCrayfish
 */
public record ServerboundSetDoorMat(BlockPos pos, String message) implements CustomPacketPayload
{
    public static final Type<ServerboundSetDoorMat> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath("cfm", "set_door_mat"));

    public static final StreamCodec<FriendlyByteBuf, ServerboundSetDoorMat> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundSetDoorMat::pos,
            ByteBufCodecs.stringUtf8(64), ServerboundSetDoorMat::message,
            ServerboundSetDoorMat::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    public static void handle(final ServerboundSetDoorMat payload, final IPayloadContext context)
    {
        context.enqueueWork(() -> {
            var player = context.player();
            var level = player.level();

            if (level.isLoaded(payload.pos()))
            {
                BlockEntity be = level.getBlockEntity(payload.pos());
                if (be instanceof DoorMatBlockEntity doorMat)
                {
                    if (player.distanceToSqr(payload.pos().getCenter()) < 64.0)
                    {
                        doorMat.setMessage(payload.message());
                    }
                }
            }
        });
    }
}