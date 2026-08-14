package com.nosiphus.furniture.network.protocol.common;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;

public record ClientboundDishwasherSync(Fluid fluid, int fluidAmount, BlockPos pos, boolean washing) implements CustomPacketPayload {
    public static final Type<ClientboundDishwasherSync> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "dishwasher_sync")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundDishwasherSync> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.registry(Registries.FLUID), ClientboundDishwasherSync::fluid,
            ByteBufCodecs.VAR_INT, ClientboundDishwasherSync::fluidAmount,
            BlockPos.STREAM_CODEC, ClientboundDishwasherSync::pos,
            ByteBufCodecs.BOOL, ClientboundDishwasherSync::washing,
            ClientboundDishwasherSync::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}