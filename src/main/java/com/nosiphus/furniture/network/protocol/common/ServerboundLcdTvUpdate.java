package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.inventory.LiquidCrystalDisplayTelevisionMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundLcdTvUpdate(BlockPos pos, boolean power, int channel) implements CustomPacketPayload {

    public static final Type<ServerboundLcdTvUpdate> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "lcd_tv_update")
    );

    public static final StreamCodec<FriendlyByteBuf, ServerboundLcdTvUpdate> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundLcdTvUpdate::pos,
            StreamCodec.of(FriendlyByteBuf::writeBoolean, FriendlyByteBuf::readBoolean), ServerboundLcdTvUpdate::power,
            StreamCodec.of((buf, val) -> buf.writeInt(val), FriendlyByteBuf::readInt), ServerboundLcdTvUpdate::channel,
            ServerboundLcdTvUpdate::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof LiquidCrystalDisplayTelevisionMenu menu) {
                if (menu.getBlockEntity().getBlockPos().equals(this.pos)) {
                    menu.getBlockEntity().setPowerAndChannel(this.power, this.channel);
                }
            }
        });
    }
}
