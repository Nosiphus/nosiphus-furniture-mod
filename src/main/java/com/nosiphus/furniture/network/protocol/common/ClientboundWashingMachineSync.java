package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.level.block.entity.WashingMachineBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ClientboundWashingMachineSync(FluidStack fluid, BlockPos pos, boolean washing) implements CustomPacketPayload {
    public static final Type<ClientboundWashingMachineSync> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "washing_machine_sync")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundWashingMachineSync> STREAM_CODEC = StreamCodec.composite(
            FluidStack.OPTIONAL_STREAM_CODEC, ClientboundWashingMachineSync::fluid,
            BlockPos.STREAM_CODEC, ClientboundWashingMachineSync::pos,
            ByteBufCodecs.BOOL, ClientboundWashingMachineSync::washing,
            ClientboundWashingMachineSync::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().level().getBlockEntity(pos) instanceof WashingMachineBlockEntity washingMachine) {
                washingMachine.setFluid(fluid);
                washingMachine.setWashing(washing);
            }
        });
    }
}