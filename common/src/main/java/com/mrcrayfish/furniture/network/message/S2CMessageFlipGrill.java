package com.mrcrayfish.furniture.network.message;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.network.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public record S2CMessageFlipGrill(BlockPos pos, int position) implements Message {
    public static final ResourceLocation ID = new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, "flip_grill");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos);
        buf.writeVarInt(this.position);
    }

    public static S2CMessageFlipGrill decode(FriendlyByteBuf buf) {
        return new S2CMessageFlipGrill(buf.readBlockPos(), buf.readVarInt());
    }
}