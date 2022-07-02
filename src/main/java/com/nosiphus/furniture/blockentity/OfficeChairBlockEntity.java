package com.nosiphus.furniture.blockentity;

import com.mrcrayfish.furniture.entity.SeatEntity;
import com.nosiphus.furniture.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class OfficeChairBlockEntity extends BlockEntity {

    protected OfficeChairBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {

        super(type, pos, state);

    }

    public OfficeChairBlockEntity(BlockPos pos, BlockState state) { super(ModBlockEntities.OFFICE_CHAIR.get(), pos, state); }

    /*
    public float getRotation()
    {
        List<SeatEntity> seats = level.getEntities(SeatEntity.class, new AABB(pos));
        if(!seats.isEmpty())
        {
            SeatEntity seat = seats.get(0);
            if(seat.getControllingPassenger() != null)
            {
                if(seat.getControllingPassenger() instanceof LivingEntity)
                {
                    LivingEntity living = (LivingEntity) seat.getControllingPassenger();
                    living.renderYawOffset = living.rotationYaw;
                    living.prevRenderYawOffset = living.rotationYaw;
                    return living.rotationYaw;
                }
                return seat.getControllingPassenger().rotationYaw;
            }
        }
        return getRotation() * 90F + 180F;
    }
    */


}
