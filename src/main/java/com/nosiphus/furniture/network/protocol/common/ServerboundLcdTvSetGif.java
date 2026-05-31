package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.inventory.LiquidCrystalDisplayTelevisionMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundLcdTvSetGif(BlockPos pos, String gifUrl) implements CustomPacketPayload {

    public static final Type<ServerboundLcdTvSetGif> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "lcd_tv_set_gif")
    );

    public static final StreamCodec<FriendlyByteBuf, ServerboundLcdTvSetGif> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundLcdTvSetGif::pos,
            StreamCodec.of(
                    (buf, val) -> buf.writeUtf(val, 512),
                    buf -> buf.readUtf(512)
            ), ServerboundLcdTvSetGif::gifUrl,
            ServerboundLcdTvSetGif::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof LiquidCrystalDisplayTelevisionMenu menu) {
                if (menu.getBlockEntity().getBlockPos().equals(this.pos)) {
                    menu.getBlockEntity().setGifUrl(this.gifUrl);
                }
            }
        });
    }
}