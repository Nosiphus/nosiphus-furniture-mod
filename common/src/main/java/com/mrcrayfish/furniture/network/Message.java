package com.mrcrayfish.furniture.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public interface Message {
    ResourceLocation getId();
    void encode(FriendlyByteBuf buf);
}