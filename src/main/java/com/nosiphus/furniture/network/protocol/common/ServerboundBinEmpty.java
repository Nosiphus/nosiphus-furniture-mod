package com.nosiphus.furniture.network.protocol.common;

import com.nosiphus.furniture.world.inventory.BinMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record ServerboundBinEmpty(BlockPos pos) implements CustomPacketPayload {

    public static final Type<ServerboundBinEmpty> TYPE = new Type<>(
            ResourceLocation.fromNamespaceAndPath("nfm", "empty_bin")
    );

    public static final StreamCodec<FriendlyByteBuf, ServerboundBinEmpty> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC, ServerboundBinEmpty::pos,
            ServerboundBinEmpty::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public void handle(IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player().containerMenu instanceof BinMenu binMenu) {
                if (binMenu.getBlockEntity().getBlockPos().equals(this.pos)) {
                    BinMenu.emptyBin(binMenu);
                }
            }
        });
    }
}