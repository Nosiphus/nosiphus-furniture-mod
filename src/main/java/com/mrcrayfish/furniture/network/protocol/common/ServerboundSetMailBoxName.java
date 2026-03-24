package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.world.mail.PostOffice;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.UUID;

/**
 * Author: MrCrayfish
 */
public record ServerboundSetMailBoxName(String name, UUID mailBoxId) implements CustomPacketPayload
{
    public static final Type<ServerboundSetMailBoxName> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("cfm", "set_mailbox_name")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSetMailBoxName> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.stringUtf8(32), ServerboundSetMailBoxName::name,
            UUIDUtil.STREAM_CODEC, ServerboundSetMailBoxName::mailBoxId, // Standard UUID codec
            ServerboundSetMailBoxName::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    public static void handle(final ServerboundSetMailBoxName payload, final IPayloadContext context)
    {
        context.enqueueWork(() -> {
            ServerPlayer player = (ServerPlayer) context.player();
            PostOffice.setMailBoxName(player.getUUID(), payload.mailBoxId(), payload.name());
        });
    }
}