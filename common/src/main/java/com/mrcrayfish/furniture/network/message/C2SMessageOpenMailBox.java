package com.mrcrayfish.furniture.network.message;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.network.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record C2SMessageOpenMailBox(BlockPos pos) implements Message {
    public static final ResourceLocation ID = new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, "open_mailbox");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    public static C2SMessageOpenMailBox decode(FriendlyByteBuf buf) {
        return new C2SMessageOpenMailBox(buf.readBlockPos());
    }
}