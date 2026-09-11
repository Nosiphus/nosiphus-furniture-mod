package com.nosiphus.furniture.network.message;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.network.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record C2SMessageEmptyBin(BlockPos pos) implements Message {

    public static final ResourceLocation ID = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "empty_bin");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    public static C2SMessageEmptyBin decode(FriendlyByteBuf buf) {
        return new C2SMessageEmptyBin(buf.readBlockPos());
    }
}