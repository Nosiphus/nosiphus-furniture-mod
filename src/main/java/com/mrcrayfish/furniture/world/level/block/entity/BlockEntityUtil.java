package com.mrcrayfish.furniture.world.level.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.List;

/**
 * Author: MrCrayfish
 */
public class BlockEntityUtil
{
    /**
     * Sends an update packet to clients tracking a tile entity.
     *
     * @param blockEntity the tile entity to update
     */
    public static void sendUpdatePacket(BlockEntity blockEntity)
    {
        Packet<ClientGamePacketListener> packet = blockEntity.getUpdatePacket();
        if (packet != null && blockEntity.getLevel() != null)
        {
            sendUpdatePacket(blockEntity.getLevel(), blockEntity.getBlockPos(), packet);
        }
    }

    /**
     * Sends an update packet to clients tracking a tile entity with a specific CompoundTag
     *
     * @param blockEntity the tile entity to update
     */
    public static void sendUpdatePacket(BlockEntity blockEntity, CompoundTag compound)
    {
        Level level = blockEntity.getLevel();
        if (level == null) return;

        HolderLookup.Provider registries = level.registryAccess();
        addIdAndPosition(blockEntity, compound);
        ClientboundBlockEntityDataPacket packet = ClientboundBlockEntityDataPacket.create(
                blockEntity,
                (be, provider) -> compound
        );
        sendUpdatePacket(level, blockEntity.getBlockPos(), packet);
    }

    public static void sendUpdatePacketSimple(BlockEntity blockEntity, CompoundTag compound)
    {
        Level level = blockEntity.getLevel();
        if (level == null) return;

        ResourceLocation id = BlockEntityType.getKey(blockEntity.getType());
        if (id != null)
        {
            compound.putString("id", id.toString());
        }

        BlockPos pos = blockEntity.getBlockPos();
        compound.putInt("x", pos.getX());
        compound.putInt("y", pos.getY());
        compound.putInt("z", pos.getZ());

        ClientboundBlockEntityDataPacket packet = ClientboundBlockEntityDataPacket.create(
                blockEntity,
                (be, provider) -> compound
        );
        sendUpdatePacket(level, pos, packet);
    }

    private static void sendUpdatePacket(Level level, BlockPos pos, Packet<ClientGamePacketListener> packet)
    {
        if (level instanceof ServerLevel server)
        {
            List<ServerPlayer> players = server.getChunkSource().chunkMap.getPlayers(new ChunkPos(pos), false);
            players.forEach(player -> player.connection.send(packet));
        }
    }

    private static void addIdAndPosition(BlockEntity blockEntity, CompoundTag tag) {
        BlockEntity.addEntityType(tag, blockEntity.getType());
        BlockPos pos = blockEntity.getBlockPos();
        tag.putInt("x", pos.getX());
        tag.putInt("y", pos.getY());
        tag.putInt("z", pos.getZ());
    }
}