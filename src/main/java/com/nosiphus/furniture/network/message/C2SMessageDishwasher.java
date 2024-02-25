package com.nosiphus.furniture.network.message;

import com.mrcrayfish.furniture.network.message.IMessage;
import com.nosiphus.furniture.blockentity.DishwasherBlockEntity;
import com.nosiphus.furniture.client.menu.BinMenu;
import com.nosiphus.furniture.client.menu.DishwasherMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class C2SMessageDishwasher implements IMessage<C2SMessageDishwasher> {

    private boolean washing;
    private BlockPos pos;

    public C2SMessageDishwasher() {};

    public C2SMessageDishwasher(BlockPos pos) {
        this.washing = washing;
        this.pos = pos;
    }

    @Override
    public void encode(C2SMessageDishwasher c2SMessageDishwasher, FriendlyByteBuf friendlyByteBuf) {
        friendlyByteBuf.writeBlockPos(c2SMessageDishwasher.pos);
    }

    @Override
    public C2SMessageDishwasher decode(FriendlyByteBuf friendlyByteBuf) {
        return new C2SMessageDishwasher(friendlyByteBuf.readBlockPos());
    }

    @Override
    public void handle(C2SMessageDishwasher c2SMessageDishwasher, Supplier<NetworkEvent.Context> supplier) {
        supplier.get().enqueueWork(() ->
        {
            Level level = supplier.get().getSender().getLevel();
            ServerPlayer player = supplier.get().getSender();

            if (!(player.containerMenu instanceof DishwasherMenu dishwasherMenu)) {
                return;
            }

            if (player.containerMenu instanceof DishwasherMenu) {
                dishwasherMenu.emptyBin(Menu);
            }

        });
        supplier.get().setPacketHandled(true);
    }


}