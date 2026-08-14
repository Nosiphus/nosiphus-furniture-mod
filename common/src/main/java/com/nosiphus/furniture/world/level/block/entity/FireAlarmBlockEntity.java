package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.sounds.ModSoundEvents;
import com.nosiphus.furniture.world.level.block.FireAlarmBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FireAlarmBlockEntity extends BlockEntity {

    private int timer = 34;

    public FireAlarmBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.FIRE_ALARM.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, FireAlarmBlockEntity entity) {
        if (level == null || level.isClientSide) return;

        if (state.getValue(FireAlarmBlock.ACTIVATED)) {
            if (entity.timer >= 34) {
                level.playSound(null, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
                        ModSoundEvents.BLOCK_FIRE_ALARM_BEEP.get(), SoundSource.BLOCKS, 5.0F, 1.0F);
                entity.timer = 0;
            }
            entity.timer++;
        } else {
            int radius = 9;
            for (int x = 0; x < radius; x++) {
                for (int y = 0; y < radius; y++) {
                    for (int z = 0; z < radius; z++) {
                        if (level.getBlockState(pos.offset(-4 + x, -4 + y, -4 + z)).is(Blocks.FIRE)) {
                            level.playSound(null, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5,
                                    ModSoundEvents.BLOCK_FIRE_ALARM_BEEP.get(), SoundSource.BLOCKS, 5.0F, 1.0F);
                            entity.timer = 0;
                            level.setBlockAndUpdate(pos, state.setValue(FireAlarmBlock.ACTIVATED, true));
                            return;
                        }
                    }
                }
            }
        }
    }
}