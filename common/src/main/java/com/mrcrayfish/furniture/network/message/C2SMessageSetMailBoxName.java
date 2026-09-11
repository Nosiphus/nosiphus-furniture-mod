package com.mrcrayfish.furniture.network.message;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.network.Message;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public record C2SMessageSetMailBoxName(String name, UUID mailBoxId) implements Message {
    public static final ResourceLocation ID = new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, "set_mailbox_name");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeUtf(this.name, 32);
        buf.writeUUID(this.mailBoxId);
    }

    public static C2SMessageSetMailBoxName decode(FriendlyByteBuf buf) {
        return new C2SMessageSetMailBoxName(buf.readUtf(32), buf.readUUID());
    }
}