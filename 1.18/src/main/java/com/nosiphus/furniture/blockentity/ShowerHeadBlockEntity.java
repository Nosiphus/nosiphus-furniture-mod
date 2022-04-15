package com.nosiphus.furniture.blockentity;

import com.nosiphus.furniture.core.ModBlockEntities;
import com.nosiphus.furniture.core.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;

public class ShowerHeadBlockEntity extends BlockEntity implements BlockEntityTicker {

    private Random random = new Random();
    private int timer = 20;

    protected ShowerHeadBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {

        super(type, pos, state);

    }

    public ShowerHeadBlockEntity(BlockPos pos, BlockState state) {

        super(ModBlockEntities.SHOWER_HEAD.get(), pos, state);

    }

    @Override
    public void tick(Level p_155253_, BlockPos p_155254_, BlockState p_155255_, BlockEntity p_155256_) {

        if (this.level.isClientSide) {

            double posX = worldPosition.getX() + 0.35D + (random.nextDouble() / 3);
            double posZ = worldPosition.getZ() + 0.35D + (random.nextDouble() / 3);
            level.addParticle(ModParticles.SHOWER_PARTICLE.get(), posX, worldPosition.getY(), posZ, 0.0D, 0.0D, 0.0D);

        } else {

            if (timer % 5 == 0) {



            }

        }

    }
}
