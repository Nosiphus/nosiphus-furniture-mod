package com.mrcrayfish.furniture.network.play;

import com.mrcrayfish.furniture.network.message.*;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.inventory.CrateMenu;
import com.mrcrayfish.furniture.world.inventory.PostBoxMenu;
import com.mrcrayfish.furniture.world.level.block.entity.CrateBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.DoorMatBlockEntity;
import com.mrcrayfish.furniture.world.level.block.entity.MailBoxBlockEntity;
import com.mrcrayfish.furniture.world.mail.Mail;
import com.mrcrayfish.furniture.world.mail.PostOffice;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;

public class ServerPlayHandler {

    public static void handleLockCrate(C2SMessageLockCrate payload, ServerPlayer player) {
        if (player.containerMenu instanceof CrateMenu crateMenu) {
            CrateBlockEntity crate = crateMenu.getBlockEntity();
            if (crate != null && player.getUUID().equals(crate.getOwner())) {
                crate.setLocked(!crate.isLocked());
            }
        }
    }

    public static void handleOpenMailBox(C2SMessageOpenMailBox payload, ServerPlayer player) {
        BlockPos pos = payload.pos();
        if (player.level().isLoaded(pos)) {
            if (player.level().getBlockEntity(pos) instanceof MailBoxBlockEntity mailBox) {
                mailBox.updateIdAndAttemptClaim(player);
                mailBox.updateOwnerName(player);
                Services.PLATFORM.openMenu(player, mailBox, pos);
            }
        }
    }

    public static void handleSendMail(C2SMessageSendMail payload, ServerPlayer player) {
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

    public static void handleSetDoorMat(C2SMessageSetDoorMat payload, ServerPlayer player) {
        if (player.level().isLoaded(payload.pos())) {
            BlockEntity be = player.level().getBlockEntity(payload.pos());
            if (be instanceof DoorMatBlockEntity doorMat) {
                if (player.distanceToSqr(payload.pos().getCenter()) < 64.0) {
                    doorMat.setMessage(payload.message());
                }
            }
        }
    }

    public static void handleSetMailBoxName(C2SMessageSetMailBoxName payload, ServerPlayer player) {
        PostOffice.setMailBoxName(player.server, player.getUUID(), payload.mailBoxId(), payload.name());
    }
}