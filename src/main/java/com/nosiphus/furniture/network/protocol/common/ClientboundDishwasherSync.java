package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.level.block.entity.DishwasherBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ClientboundDishwasherSync(FluidStack fluid, BlockPos pos, boolean washing) implements CustomPacketPayload {
    public static final Type<ClientboundDishwasherSync> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "dishwasher_sync")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundDishwasherSync> STREAM_CODEC = StreamCodec.composite(
            FluidStack.OPTIONAL_STREAM_CODEC, ClientboundDishwasherSync::fluid,
            BlockPos.STREAM_CODEC, ClientboundDishwasherSync::pos,
            ByteBufCodecs.BOOL, ClientboundDishwasherSync::washing,
            ClientboundDishwasherSync::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            Level level = Minecraft.getInstance().level;
            if (level != null && level.getBlockEntity(pos) instanceof DishwasherBlockEntity dishwasher) {
                dishwasher.setFluid(fluid);
                dishwasher.setWashing(washing);
            }
        });
    }
}