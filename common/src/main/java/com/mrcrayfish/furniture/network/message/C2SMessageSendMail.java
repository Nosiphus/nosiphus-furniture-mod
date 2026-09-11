package com.mrcrayfish.furniture.network.message;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.network.Message;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

public record C2SMessageSendMail(UUID recipientId, UUID mailBoxId) implements Message {
    public static final ResourceLocation ID = new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, "send_mail");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeUUID(this.recipientId);
        buf.writeUUID(this.mailBoxId);
    }

    public static C2SMessageSendMail decode(FriendlyByteBuf buf) {
        return new C2SMessageSendMail(buf.readUUID(), buf.readUUID());
    }
}