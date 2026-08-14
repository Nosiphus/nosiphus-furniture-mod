package com.nosiphus.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.level.block.entity.BasicLootBlockEntity;
import com.nosiphus.furniture.world.level.block.TelevisionStandBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TelevisionStandBlockEntity extends BasicLootBlockEntity {

    public TelevisionStandBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.TELEVISION_STAND.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return 18;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.cfm.cabinet");
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory) {
        return new ChestMenu(MenuType.GENERIC_9x2, windowId, playerInventory, this, 2);
    }

    @Override
    public void onOpen(Level level, BlockPos pos, BlockState state) {
        this.playDoorSound(state, ModSoundEvents.BLOCK_CABINET_OPEN.get());
        this.setDoorState(state, true);
    }

    @Override
    public void onClose(Level level, BlockPos pos, BlockState state) {
        this.playDoorSound(state, ModSoundEvents.BLOCK_CABINET_CLOSE.get());
        this.setDoorState(state, false);
    }

    private void playDoorSound(BlockState state, SoundEvent event) {
        Vec3i directionVec = state.getValue(TelevisionStandBlock.DIRECTION).getNormal();
        double x = this.worldPosition.getX() + 0.5D + directionVec.getX() / 2.0D;
        double y = this.worldPosition.getY() + 0.5D + directionVec.getY() / 2.0D;
        double z = this.worldPosition.getZ() + 0.5D + directionVec.getZ() / 2.0D;
        Level level = this.getLevel();
        if (level != null) {
            level.playSound(null, x, y, z, event, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
        }
    }

    private void setDoorState(BlockState state, boolean open) {
        Level level = this.getLevel();
        if (level != null) {
            level.setBlock(this.getBlockPos(), state.setValue(TelevisionStandBlock.OPEN, open), 3);
        }
    }
}