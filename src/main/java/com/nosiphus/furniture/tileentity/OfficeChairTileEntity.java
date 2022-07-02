package com.nosiphus.furniture.tileentity;

import com.mrcrayfish.furniture.entity.SeatEntity;
import com.nosiphus.furniture.core.ModTileEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.util.List;

public class OfficeChairTileEntity extends TileEntity {

    protected OfficeChairTileEntity(TileEntityType<?> type) { super(type); };

    public OfficeChairTileEntity() { super(ModTileEntities.OFFICE_CHAIR.get()); }

    public float getRotation()
    {
        List<SeatEntity> seats = world.getEntitiesWithinAABB(SeatEntity.class, new AxisAlignedBB(pos));
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

}