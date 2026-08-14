package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public record ServerboundSendMail(UUID recipientId, UUID mailBoxId) implements CustomPacketPayload {
    public static final Type<ServerboundSendMail> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, "send_mail"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSendMail> STREAM_CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, ServerboundSendMail::recipientId,
            UUIDUtil.STREAM_CODEC, ServerboundSendMail::mailBoxId,
            ServerboundSendMail::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}