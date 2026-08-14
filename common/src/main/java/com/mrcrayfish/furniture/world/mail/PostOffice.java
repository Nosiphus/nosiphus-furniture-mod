package com.mrcrayfish.furniture.world.mail;

import com.mrcrayfish.furniture.FurnitureConfig;
import com.mrcrayfish.furniture.world.level.block.entity.MailBoxBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Author: MrCrayfish
 */
public class PostOffice extends SavedData
{
    private static final String ID = "cfm_post_office";

    private final Map<UUID, Map<UUID, MailBox>> playerMailboxMap = new HashMap<>();

    public static final SavedData.Factory<PostOffice> FACTORY = new SavedData.Factory<>(
            PostOffice::new,
            PostOffice::load,
            null
    );

    public PostOffice() {}

    public static PostOffice load(CompoundTag tag, HolderLookup.Provider registries)
    {
        PostOffice postOffice = new PostOffice();
        postOffice.read(tag, registries);
        return postOffice;
    }

    public void read(CompoundTag compound, HolderLookup.Provider registries)
    {
        this.playerMailboxMap.clear();
        if (compound.contains("PlayerMailBoxes", Tag.TAG_LIST))
        {
            ListTag playerList = compound.getList("PlayerMailBoxes", Tag.TAG_COMPOUND);
            for (int i = 0; i < playerList.size(); i++)
            {
                CompoundTag playerEntry = playerList.getCompound(i);
                UUID playerId = playerEntry.getUUID("PlayerUUID");

                if (playerEntry.contains("MailBoxes", Tag.TAG_LIST))
                {
                    Map<UUID, MailBox> mailBoxMap = new HashMap<>();
                    ListTag mailBoxList = playerEntry.getList("MailBoxes", Tag.TAG_COMPOUND);
                    for (int j = 0; j < mailBoxList.size(); j++)
                    {
                        CompoundTag mailBoxEntry = mailBoxList.getCompound(j);
                        UUID mailBoxId = mailBoxEntry.getUUID("MailBoxUUID");
                        MailBox mailBox = new MailBox(mailBoxEntry.getCompound("MailBox"), registries);
                        mailBoxMap.put(mailBoxId, mailBox);
                    }
                    this.playerMailboxMap.put(playerId, mailBoxMap);
                }
            }
        }
    }

    @Override
    public CompoundTag save(CompoundTag compound, HolderLookup.Provider registries)
    {
        ListTag playerList = new ListTag();
        this.playerMailboxMap.forEach((playerId, mailStorage) ->
        {
            if (!mailStorage.isEmpty())
            {
                CompoundTag playerEntry = new CompoundTag();
                playerEntry.putUUID("PlayerUUID", playerId);

                ListTag mailBoxList = new ListTag();
                mailStorage.forEach((mailBoxId, mailBox) ->
                {
                    CompoundTag mailBoxEntry = new CompoundTag();
                    mailBoxEntry.putUUID("MailBoxUUID", mailBoxId);
                    mailBoxEntry.put("MailBox", mailBox.serializeNBT(registries));
                    mailBoxList.add(mailBoxEntry);
                });
                playerEntry.put("MailBoxes", mailBoxList);
                playerList.add(playerEntry);
            }
        });
        compound.put("PlayerMailBoxes", playerList);
        return compound;
    }

    public static void registerMailBox(ServerPlayer player, UUID mailBoxId, String name, BlockPos pos)
    {
        PostOffice office = get(player.server);
        Map<UUID, MailBox> mailBoxMap = office.playerMailboxMap.computeIfAbsent(player.getUUID(), uuid -> new HashMap<>());
        mailBoxMap.put(mailBoxId, new MailBox(mailBoxId, name, player.getUUID(), player.getName().getString(), pos, player.level().dimension()));
        office.setDirty();
    }

    public static void unregisterMailBox(MinecraftServer server, UUID playerId, UUID mailBoxId)
    {
        if(server != null)
        {
            PostOffice office = get(server);
            Map<UUID, MailBox> mailBoxMap = office.playerMailboxMap.computeIfAbsent(playerId, uuid -> new HashMap<>());
            mailBoxMap.remove(mailBoxId);
            office.setDirty();
        }
    }

    public static List<MailBox> getMailBoxes(ServerPlayer playerEntity)
    {
        PostOffice office = get(playerEntity.server);
        return office.playerMailboxMap.values().stream().flatMap(map -> map.values().stream()).collect(Collectors.toList());
    }

    public static boolean sendMailToPlayer(MinecraftServer server, UUID playerId, UUID mailBoxId, Mail mail)
    {
        if (server != null)
        {
            PostOffice office = get(server);
            Map<UUID, MailBox> mailBoxMap = office.playerMailboxMap.computeIfAbsent(playerId, uuid -> new HashMap<>());
            if (mailBoxMap.containsKey(mailBoxId))
            {
                if (mailBoxMap.get(mailBoxId).getMailCount() < FurnitureConfig.getMaxMailQueue())
                {
                    mailBoxMap.get(mailBoxId).addMail(mail);
                    office.setDirty();
                    return true;
                }
            }
        }
        return false;
    }

    public static Supplier<Mail> getMailForPlayerMailBox(MinecraftServer server, UUID playerId, UUID mailBoxId)
    {
        return () ->
        {
            if (server != null)
            {
                PostOffice office = get(server);
                Map<UUID, MailBox> mailBoxMap = office.playerMailboxMap.get(playerId);
                if (mailBoxMap != null && mailBoxMap.containsKey(mailBoxId))
                {
                    MailBox mailBox = mailBoxMap.get(mailBoxId);
                    List<Mail> mailStorage = mailBox.getMailStorage();
                    if (!mailStorage.isEmpty())
                    {
                        office.setDirty();
                        return mailStorage.remove(0);
                    }
                }
            }
            return null;
        };
    }

    public static boolean setMailBoxName(MinecraftServer server, UUID playerId, UUID mailBoxId, String name)
    {
        name = name.trim();
        if (name.isEmpty() || server == null) return false;

        PostOffice office = get(server);
        Map<UUID, MailBox> mailBoxMap = office.playerMailboxMap.get(playerId);
        if (mailBoxMap == null || !mailBoxMap.containsKey(mailBoxId)) return false;

        MailBox mailBox = mailBoxMap.get(mailBoxId);
        mailBox.setName(name);

        ServerLevel level = server.getLevel(mailBox.getLevelResourceKey());
        if (level != null && level.isLoaded(mailBox.getPos()))
        {
            if (level.getBlockEntity(mailBox.getPos()) instanceof MailBoxBlockEntity mailBoxBlockEntity)
            {
                mailBoxBlockEntity.setMailBoxName(name);
                mailBoxBlockEntity.markUpdated();
            }
        }
        office.setDirty();
        return true;
    }

    public static boolean isRegistered(MinecraftServer server, UUID playerId, UUID mailBoxId)
    {
        if(server != null)
        {
            PostOffice office = get(server);
            if(office.playerMailboxMap.containsKey(playerId))
            {
                return office.playerMailboxMap.get(playerId).containsKey(mailBoxId);
            }
        }
        return false;
    }

    private static PostOffice get(MinecraftServer server)
    {
        ServerLevel overworld = server.getLevel(Level.OVERWORLD);
        return Objects.requireNonNull(overworld).getDataStorage().computeIfAbsent(FACTORY, ID);
    }

    public static void tickLevel(ServerLevel serverLevel)
    {
        MinecraftServer server = serverLevel.getServer();
        if (server.getTickCount() % 1200 == 0)
        {
            PostOffice office = get(server);
            boolean changed = false;

            for (Map<UUID, MailBox> map : office.playerMailboxMap.values())
            {
                Iterator<Map.Entry<UUID, MailBox>> it = map.entrySet().iterator();
                while (it.hasNext())
                {
                    MailBox mailBox = it.next().getValue();
                    BlockPos pos = mailBox.getPos();
                    ServerLevel mailLevel = server.getLevel(mailBox.getLevelResourceKey());

                    if (mailLevel != null)
                    {
                        if (mailLevel.isLoaded(pos))
                        {
                            if (mailLevel.getBlockEntity(pos) instanceof MailBoxBlockEntity be)
                            {
                                if (be.getId() == null || !be.getId().equals(mailBox.getId()))
                                {
                                    it.remove();
                                    changed = true;
                                }
                            }
                            else
                            {
                                it.remove();
                                changed = true;
                            }
                        }
                    }
                }
            }
            if (changed) office.setDirty();
        }
    }
}