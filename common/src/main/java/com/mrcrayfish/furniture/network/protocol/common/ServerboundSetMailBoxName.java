package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public record ServerboundSetMailBoxName(String name, UUID mailBoxId) implements CustomPacketPayload {
    public static final Type<ServerboundSetMailBoxName> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, "set_mailbox_name"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSetMailBoxName> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.stringUtf8(32), ServerboundSetMailBoxName::name,
            UUIDUtil.STREAM_CODEC, ServerboundSetMailBoxName::mailBoxId,
            ServerboundSetMailBoxName::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}