package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ClientboundFlipGrill(BlockPos pos, int position) implements CustomPacketPayload {
    public static final Type<ClientboundFlipGrill> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, "flip_grill"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ClientboundFlipGrill> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ClientboundFlipGrill::pos,
            ByteBufCodecs.VAR_INT, ClientboundFlipGrill::position,
            ClientboundFlipGrill::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}