package com.nosiphus.furniture.network.message;

import com.mrcrayfish.furniture.network.message.IMessage;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;

public class C2SMessageDishwasher implements IMessage<C2SMessageDishwasher> {

    private int type;
    private BlockPos pos;

    public C2SMessageDishwasher() {}

    public C2SMessageDishwasher(int type, BlockPos pos) {
        this.type = type;
        this.pos = pos;
    }

    @Override
    public void encode(C2SMessageDishwasher c2SMessageDishwasher, FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeInt(c2SMessageDishwasher.type);
        friendlyByteBuf.writeBlockPos(c2SMessageDishwasher.pos);
    }

    @Override
    public C2SMessageDishwasher decode(FriendlyByteBuf friendlyByteBuf) {
        return new C2SMessageDishwasher(friendlyByteBuf.readInt().readBlockPos());
    }



}
