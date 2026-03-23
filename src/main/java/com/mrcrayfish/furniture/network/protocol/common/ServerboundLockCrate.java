package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.world.inventory.CrateMenu;
import com.mrcrayfish.furniture.world.level.block.entity.CrateBlockEntity;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundLockCrate() implements CustomPacketPayload
{

    public static final Type<ServerboundLockCrate> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("cfm", "lock_crate")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundLockCrate> STREAM_CODEC =
            StreamCodec.unit(new ServerboundLockCrate());

    @Override
    public Type<? extends CustomPacketPayload> type()
    {
        return TYPE;
    }

    public static void handle(final ServerboundLockCrate payload, final IPayloadContext context) {
        context.enqueueWork(() ->
        {
            Player player = context.player();
            AbstractContainerMenu menu = player.containerMenu;

            if (menu instanceof CrateMenu crateMenu)
            {
                if (crateMenu.getBlockEntity() instanceof CrateBlockEntity crate)
                {
                    if (player.getUUID().equals(crate.getOwner()))
                    {
                        crate.setLocked(!crate.isLocked());
                    }
                }
            }
        });
    }
}