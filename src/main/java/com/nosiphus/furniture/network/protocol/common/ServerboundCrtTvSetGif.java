package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.inventory.CathodeRayTubeTelevisionMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundCrtTvSetGif(BlockPos pos, String gifUrl) implements CustomPacketPayload {

    public static final Type<ServerboundCrtTvSetGif> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "crt_tv_set_gif")
    );

    public static final StreamCodec<FriendlyByteBuf, ServerboundCrtTvSetGif> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundCrtTvSetGif::pos,
            StreamCodec.of(
                    (buf, val) -> buf.writeUtf(val, 512),
                    buf -> buf.readUtf(512)
            ), ServerboundCrtTvSetGif::gifUrl,
            ServerboundCrtTvSetGif::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof CathodeRayTubeTelevisionMenu menu) {
                if (menu.getBlockEntity().getBlockPos().equals(this.pos)) {
                    menu.getBlockEntity().setGifUrl(this.gifUrl);
                }
            }
        });
    }
}
