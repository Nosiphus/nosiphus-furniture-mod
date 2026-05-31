package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.inventory.ComputerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundComputerUpdate(BlockPos pos, boolean power, int channel) implements CustomPacketPayload {

    public static final Type<ServerboundComputerUpdate> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "computer_update")
    );

    public static final StreamCodec<FriendlyByteBuf, ServerboundComputerUpdate> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundComputerUpdate::pos,
            StreamCodec.of(FriendlyByteBuf::writeBoolean, FriendlyByteBuf::readBoolean), ServerboundComputerUpdate::power,
            StreamCodec.of((buf, val) -> buf.writeInt(val), FriendlyByteBuf::readInt), ServerboundComputerUpdate::channel,
            ServerboundComputerUpdate::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof ComputerMenu menu) {
                if (menu.getBlockEntity().getBlockPos().equals(this.pos)) {
                    menu.getBlockEntity().setPowerAndChannel(this.power, this.channel);
                }
            }
        });
    }
}
