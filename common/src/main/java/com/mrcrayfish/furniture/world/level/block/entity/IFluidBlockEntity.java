package com.mrcrayfish.furniture.world.level.block.entity;

import net.minecraft.world.level.material.Fluid;

public interface IFluidBlockEntity {
    Fluid getFluid();
    int getFluidAmount();
    int getCapacity();
}