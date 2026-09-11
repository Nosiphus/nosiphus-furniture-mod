package com.nosiphus.furniture.network.message;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.network.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record C2SMessageTVChannelSync(BlockPos pos, int channel) implements Message {

    public static final ResourceLocation ID = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "tv_channel_sync");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos);
        buf.writeVarInt(this.channel);
    }

    public static C2SMessageTVChannelSync decode(FriendlyByteBuf buf) {
        return new C2SMessageTVChannelSync(buf.readBlockPos(), buf.readVarInt());
    }
}