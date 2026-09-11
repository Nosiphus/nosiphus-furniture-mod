package com.nosiphus.furniture.network.message;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.network.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record C2SMessageTVURLSync(BlockPos pos, int channel, String url) implements Message {

    public static final ResourceLocation ID = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "tv_url_sync");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos);
        buf.writeVarInt(this.channel);
        buf.writeUtf(this.url, 512);
    }

    public static C2SMessageTVURLSync decode(FriendlyByteBuf buf) {
        return new C2SMessageTVURLSync(buf.readBlockPos(), buf.readVarInt(), buf.readUtf(512));
    }
}