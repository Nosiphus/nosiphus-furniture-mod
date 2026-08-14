package com.nosiphus.furniture.network.protocol.common;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;

public record ClientboundWashingMachineSync(Fluid fluid, int fluidAmount, BlockPos pos, boolean washing) implements CustomPacketPayload {
    public static final Type<ClientboundWashingMachineSync> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "washing_machine_sync")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundWashingMachineSync> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.registry(Registries.FLUID), ClientboundWashingMachineSync::fluid,
            ByteBufCodecs.VAR_INT, ClientboundWashingMachineSync::fluidAmount,
            BlockPos.STREAM_CODEC, ClientboundWashingMachineSync::pos,
            ByteBufCodecs.BOOL, ClientboundWashingMachineSync::washing,
            ClientboundWashingMachineSync::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}