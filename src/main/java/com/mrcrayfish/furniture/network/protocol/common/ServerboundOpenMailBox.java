package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.world.level.block.entity.MailBoxBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * Author: MrCrayfish
 */
public record ServerboundOpenMailBox(BlockPos pos) implements CustomPacketPayload
{

    public static final Type<ServerboundOpenMailBox> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("cfm", "open_mailbox")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundOpenMailBox> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundOpenMailBox::pos,
            ServerboundOpenMailBox::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    public static void handle(final ServerboundOpenMailBox payload, final IPayloadContext context)
    {
        context.enqueueWork(() -> {
            ServerPlayer player = (ServerPlayer) context.player();
            BlockPos pos = payload.pos();

            if (player.level().isLoaded(pos))
            {
                if (player.level().getBlockEntity(pos) instanceof MailBoxBlockEntity mailBox)
                {
                    mailBox.updateIdAndAttemptClaim(player);
                    mailBox.updateOwnerName(player);

                    player.openMenu(mailBox, pos);
                }
            }
        });
    }
}