package com.mrcrayfish.furniture.network.protocol.common;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record ServerboundLockCrate() implements CustomPacketPayload {
    public static final Type<ServerboundLockCrate> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, "lock_crate"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ServerboundLockCrate> STREAM_CODEC = StreamCodec.unit(new ServerboundLockCrate());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}