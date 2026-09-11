package com.mrcrayfish.furniture.network.message;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.network.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record C2SMessageSetDoorMat(BlockPos pos, String message) implements Message {
    public static final ResourceLocation ID = new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, "set_door_mat");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos);
        buf.writeUtf(this.message, 64);
    }

    public static C2SMessageSetDoorMat decode(FriendlyByteBuf buf) {
        return new C2SMessageSetDoorMat(buf.readBlockPos(), buf.readUtf(64));
    }
}