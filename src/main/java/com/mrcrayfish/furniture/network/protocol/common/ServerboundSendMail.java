package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.world.inventory.PostBoxMenu;
import com.mrcrayfish.furniture.world.mail.Mail;
import com.mrcrayfish.furniture.world.mail.PostOffice;
import net.minecraft.core.UUIDUtil;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.UUID;

/**
 * Author: MrCrayfish
 */
public record ServerboundSendMail(UUID recipientId, UUID mailBoxId) implements CustomPacketPayload
{
    public static final Type<ServerboundSendMail> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("cfm", "send_mail")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundSendMail> STREAM_CODEC = StreamCodec.composite(
            UUIDUtil.STREAM_CODEC, ServerboundSendMail::recipientId,
            UUIDUtil.STREAM_CODEC, ServerboundSendMail::mailBoxId,
            ServerboundSendMail::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    public static void handle(final ServerboundSendMail payload, final IPayloadContext context)
    {
        context.enqueueWork(() ->
        {
            ServerPlayer sender = (ServerPlayer) context.player();
            if (sender.containerMenu instanceof PostBoxMenu postBoxMenu)
            {
                ItemStack mailStack = postBoxMenu.getMailSlot().getItem();

                if (!mailStack.isEmpty())
                {
                    Mail mail = new Mail("", mailStack.copy(), sender.getName().getString());
                    if (PostOffice.sendMailToPlayer(payload.recipientId(), payload.mailBoxId(), mail))
                    {
                        postBoxMenu.getMailSlot().set(ItemStack.EMPTY);
                    }
                }
            }
        });
    }
}