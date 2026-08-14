package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ServerboundOpenMailBox(BlockPos pos) implements CustomPacketPayload {
    public static final Type<ServerboundOpenMailBox> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, "open_mailbox"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundOpenMailBox> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundOpenMailBox::pos,
            ServerboundOpenMailBox::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}