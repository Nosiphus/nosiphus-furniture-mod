package com.nosiphus.furniture.platform;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.platform.services.IRegistryHelper;
import com.nosiphus.furniture.world.level.fluid.BaseFluid;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
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

public class FabricRegistryHelper implements IRegistryHelper {

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        T registeredBlock = Registry.register(
                BuiltInRegistries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                blockSupplier.get()
        );
        return () -> registeredBlock;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        BlockEntityType<T> registeredType = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                blockEntityTypeSupplier.get()
        );
        return () -> registeredType;
    }

    @Override
    public <T extends EntityType<?>> Supplier<T> registerEntityType(String name, Supplier<T> entityTypeSupplier) {
        T registeredEntityType = Registry.register(
                BuiltInRegistries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                entityTypeSupplier.get()
        );
        return () -> registeredEntityType;
    }

    @Override
    public <T extends Fluid> Supplier<T> registerFluid(String name, Supplier<T> fluidSupplier) {
        T registeredFluid = Registry.register(
                BuiltInRegistries.FLUID,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                fluidSupplier.get()
        );
        return () -> registeredFluid;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        T registeredItem = Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                itemSupplier.get()
        );
        return () -> registeredItem;
    }

    @Override
    public <T extends MenuType<?>> Supplier<T> registerMenuType(String name, Supplier<T> menuTypeSupplier) {
        T registeredMenuType = Registry.register(
                BuiltInRegistries.MENU,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                menuTypeSupplier.get()
        );
        return () -> registeredMenuType;
    }

    @Override
    public <T extends ParticleType<?>> Supplier<T> registerParticleType(String name, Supplier<T> particleTypeSupplier) {
        T type = particleTypeSupplier.get();
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name), type);
        return () -> type;
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String name, Supplier<T> serializerSupplier) {
        T registeredSerializer = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                serializerSupplier.get()
        );
        return () -> registeredSerializer;
    }

    @Override
    public <T extends Recipe<?>> Supplier<RecipeType<T>> registerRecipeType(String name, Supplier<RecipeType<T>> typeSupplier) {
        RecipeType<T> registeredType = Registry.register(
                BuiltInRegistries.RECIPE_TYPE,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                typeSupplier.get()
        );
        return () -> registeredType;
    }

    @Override
    public <T extends SoundEvent> Supplier<T> registerSoundEvent(String name, Supplier<T> soundEventSupplier) {
        T registeredSoundEvent = Registry.register(
                BuiltInRegistries.SOUND_EVENT,
                ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                soundEventSupplier.get()
        );
        return () -> registeredSoundEvent;
    }

    @Override
    public <T extends FlowingFluid> Supplier<T> registerSourceFluid(String name, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing, Supplier<? extends Item> bucket, Supplier<? extends LiquidBlock> block) {
        T fluid = (T) Registry.register(BuiltInRegistries.FLUID, ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                new BaseFluid.Source(still, flowing, bucket, block));
        return () -> fluid;
    }

    @Override
    public <T extends FlowingFluid> Supplier<T> registerFlowingFluid(String name, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing, Supplier<? extends Item> bucket, Supplier<? extends LiquidBlock> block) {
        T fluid = (T) Registry.register(BuiltInRegistries.FLUID, ResourceLocation.fromNamespaceAndPath(NosiphusFurnitureMod.MOD_ID, name),
                new BaseFluid.Flowing(still, flowing, bucket, block));
        return () -> fluid;
    }

}