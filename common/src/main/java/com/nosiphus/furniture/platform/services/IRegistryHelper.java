package com.nosiphus.furniture.platform.services;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public interface IRegistryHelper {
    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier);
    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> blockEntityTypeSupplier);
    <T extends EntityType<?>> Supplier<T> registerEntityType(String name, Supplier<T> entityTypeSupplier);
    <T extends Fluid> Supplier<T> registerFluid(String name, Supplier<T> fluidSupplier);
    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier);
    <T extends MenuType<?>> Supplier<T> registerMenuType(String name, Supplier<T> menuTypeSupplier);
    <T extends ParticleType<?>> Supplier<T> registerParticleType(String name, Supplier<T> particleTypeSupplier);
    <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String name, Supplier<T> serializerSupplier);
    <T extends Recipe<?>> Supplier<RecipeType<T>> registerRecipeType(String name, Supplier<RecipeType<T>> typeSupplier);
    <T extends SoundEvent> Supplier<T> registerSoundEvent(String name, Supplier<T> soundEventSupplier);

    <T extends FlowingFluid> Supplier<T> registerSourceFluid(
            String name,
            Supplier<? extends Fluid> still,
            Supplier<? extends Fluid> flowing,
            Supplier<? extends Item> bucket,
            Supplier<? extends LiquidBlock> block
    );

    <T extends FlowingFluid> Supplier<T> registerFlowingFluid(
            String name,
            Supplier<? extends Fluid> still,
            Supplier<? extends Fluid> flowing,
            Supplier<? extends Item> bucket,
            Supplier<? extends LiquidBlock> block
    );
}
