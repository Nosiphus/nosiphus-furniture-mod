package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.inventory.CathodeRayTubeTelevisionMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundCrtTvUpdate(BlockPos pos, boolean power, int channel) implements CustomPacketPayload {

    public static final Type<ServerboundCrtTvUpdate> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "crt_tv_update")
    );

    public static final StreamCodec<FriendlyByteBuf, ServerboundCrtTvUpdate> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundCrtTvUpdate::pos,
            StreamCodec.of(FriendlyByteBuf::writeBoolean, FriendlyByteBuf::readBoolean), ServerboundCrtTvUpdate::power,
            StreamCodec.of((buf, val) -> buf.writeInt(val), FriendlyByteBuf::readInt), ServerboundCrtTvUpdate::channel,
            ServerboundCrtTvUpdate::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof CathodeRayTubeTelevisionMenu menu) {
                if (menu.getBlockEntity().getBlockPos().equals(this.pos)) {
                    menu.getBlockEntity().setPowerAndChannel(this.power, this.channel);
                }
            }
        });
    }
}
