package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ServerboundSetDoorMat(BlockPos pos, String message) implements CustomPacketPayload {
    public static final Type<ServerboundSetDoorMat> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, "set_door_mat"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSetDoorMat> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundSetDoorMat::pos,
            ByteBufCodecs.stringUtf8(64), ServerboundSetDoorMat::message,
            ServerboundSetDoorMat::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}