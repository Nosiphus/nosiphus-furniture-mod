package com.mrcrayfish.furniture.network;

import com.mrcrayfish.furniture.network.protocol.common.*;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.inventory.CrateMenu;
import com.mrcrayfish.furniture.world.inventory.PostBoxMenu;
import com.mrcrayfish.furniture.world.level.block.entity.CrateBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.DoorMatBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.GrillBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.MailBoxBlockEntity;
import com.mrcrayfish.furniture.world.mail.Mail;
import com.mrcrayfish.furniture.world.mail.PostOffice;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class PacketHandlers {

    public static void handleFlipGrill(ClientboundFlipGrill payload) {
        Player player = Minecraft.getInstance().player;
        if (player != null && player.level().getBlockEntity(payload.pos()) instanceof GrillBlockEntity grill) {
            grill.setFlipping(payload.position());
        }
    }

    public static void handleLockCrate(ServerboundLockCrate payload, ServerPlayer player) {
        if (player.containerMenu instanceof CrateMenu crateMenu) {
            if (crateMenu.getBlockEntity() instanceof CrateBlockEntity crate) {
                if (player.getUUID().equals(crate.getOwner())) {
                    crate.setLocked(!crate.isLocked());
                }
            }
        }
    }

    public static void handleOpenMailBox(ServerboundOpenMailBox payload, ServerPlayer player) {
        BlockPos pos = payload.pos();
        if (player.level().isLoaded(pos)) {
            if (player.level().getBlockEntity(pos) instanceof MailBoxBlockEntity mailBox) {
                mailBox.updateIdAndAttemptClaim(player);
                mailBox.updateOwnerName(player);
                Services.PLATFORM.openMenu(player, mailBox, pos);
            }
        }
    }

    public static void handleSendMail(ServerboundSendMail payload, ServerPlayer player) {
        if (player.containerMenu instanceof PostBoxMenu postBoxMenu) {
            ItemStack mailStack = postBoxMenu.getMailSlot().getItem();
            if (!mailStack.isEmpty()) {
                Mail mail = new Mail("", mailStack.copy(), player.getName().getString());
                if (PostOffice.sendMailToPlayer(player.server, payload.recipientId(), payload.mailBoxId(), mail)) {
                    postBoxMenu.getMailSlot().set(ItemStack.EMPTY);
                }
            }
        }
    }

    public static void handleSetDoorMat(ServerboundSetDoorMat payload, ServerPlayer player) {
        if (player.level().isLoaded(payload.pos())) {
            BlockEntity be = player.level().getBlockEntity(payload.pos());
            if (be instanceof DoorMatBlockEntity doorMat) {
                if (player.distanceToSqr(payload.pos().getCenter()) < 64.0) {
                    doorMat.setMessage(payload.message());
                }
            }
        }
    }

    public static void handleSetMailBoxName(ServerboundSetMailBoxName payload, ServerPlayer player) {
        PostOffice.setMailBoxName(player.server, player.getUUID(), payload.mailBoxId(), payload.name());
    }
}