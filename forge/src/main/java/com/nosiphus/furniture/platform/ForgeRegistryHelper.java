package com.nosiphus.furniture.platform;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.platform.services.IRegistryHelper;
import com.nosiphus.furniture.world.level.fluid.BaseFluidForge;
import com.nosiphus.furniture.world.level.fluid.ModFluidTypes;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
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
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ForgeRegistryHelper implements IRegistryHelper {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, NosiphusFurnitureMod.MOD_ID);

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        return BLOCK_ENTITY_TYPES.register(name, blockEntityTypeSupplier);
    }

    @Override
    public <T extends EntityType<?>> Supplier<T> registerEntityType(String name, Supplier<T> entityTypeSupplier) {
        return ENTITY_TYPES.register(name, entityTypeSupplier);
    }

    @Override
    public <T extends Fluid> Supplier<T> registerFluid(String name, Supplier<T> fluidSupplier) {
        return FLUIDS.register(name, fluidSupplier);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    @Override
    public <T extends MenuType<?>> Supplier<T> registerMenuType(String name, Supplier<T> menuTypeSupplier) {
        return MENU_TYPES.register(name, menuTypeSupplier);
    }

    @Override
    public <T extends ParticleType<?>> Supplier<T> registerParticleType(String name, Supplier<T> particleTypeSupplier) {
        return PARTICLE_TYPES.register(name, particleTypeSupplier);
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String name, Supplier<T> serializerSupplier) {
        return RECIPE_SERIALIZERS.register(name, serializerSupplier);
    }

    @Override
    public <T extends Recipe<?>> Supplier<RecipeType<T>> registerRecipeType(String name, Supplier<RecipeType<T>> typeSupplier) {
        return RECIPE_TYPES.register(name, typeSupplier);
    }

    @Override
    public <T extends SoundEvent> Supplier<T> registerSoundEvent(String name, Supplier<T> soundEventSupplier) {
        return SOUND_EVENTS.register(name, soundEventSupplier);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends FlowingFluid> Supplier<T> registerSourceFluid(String name, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing, Supplier<? extends Item> bucket, Supplier<? extends LiquidBlock> block) {
        Supplier<FluidType> type = name.contains("super") ? ModFluidTypes.SUPER_SOAPY_WATER_TYPE : ModFluidTypes.SOAPY_WATER_TYPE;
        return (Supplier<T>) (Supplier<?>) FLUIDS.register(name, () -> new BaseFluidForge.Source(still, flowing, bucket, block, type));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends FlowingFluid> Supplier<T> registerFlowingFluid(String name, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing, Supplier<? extends Item> bucket, Supplier<? extends LiquidBlock> block) {
        Supplier<FluidType> type = name.contains("super") ? ModFluidTypes.SUPER_SOAPY_WATER_TYPE : ModFluidTypes.SOAPY_WATER_TYPE;
        return (Supplier<T>) (Supplier<?>) FLUIDS.register(name, () -> new BaseFluidForge.Flowing(still, flowing, bucket, block, type));
    }

}