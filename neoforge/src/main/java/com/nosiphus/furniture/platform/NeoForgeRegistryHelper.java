package com.nosiphus.furniture.platform;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.platform.services.IRegistryHelper;
import com.nosiphus.furniture.world.level.fluid.BaseFluidNeoForge;
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
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoForgeRegistryHelper implements IRegistryHelper {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, NosiphusFurnitureMod.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, NosiphusFurnitureMod.MOD_ID);

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        DeferredBlock<T> deferredBlock = BLOCKS.register(name, blockSupplier);
        return deferredBlock;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> deferredHolder = BLOCK_ENTITY_TYPES.register(name, blockEntityTypeSupplier);
        return deferredHolder;
    }

    @Override
    public <T extends EntityType<?>> Supplier<T> registerEntityType(String name, Supplier<T> entityTypeSupplier) {
        DeferredHolder<EntityType<?>, T> deferredHolder = ENTITY_TYPES.register(name, entityTypeSupplier);
        return deferredHolder;
    }

    @Override
    public <T extends Fluid> Supplier<T> registerFluid(String name, Supplier<T> fluidSupplier) {
        DeferredHolder<Fluid, T> deferredHolder = FLUIDS.register(name, fluidSupplier);
        return deferredHolder;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        DeferredItem<T> deferredItem = ITEMS.register(name, itemSupplier);
        return deferredItem;
    }

    @Override
    public <T extends MenuType<?>> Supplier<T> registerMenuType(String name, Supplier<T> menuTypeSupplier) {
        DeferredHolder<MenuType<?>, T> deferredHolder = MENU_TYPES.register(name, menuTypeSupplier);
        return deferredHolder;
    }

    @Override
    public <T extends ParticleType<?>> Supplier<T> registerParticleType(String name, Supplier<T> particleTypeSupplier) {
        return PARTICLE_TYPES.register(name, particleTypeSupplier);
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String name, Supplier<T> serializerSupplier) {
        DeferredHolder<RecipeSerializer<?>, T> deferredHolder = RECIPE_SERIALIZERS.register(name, serializerSupplier);
        return deferredHolder;
    }

    @Override
    public <T extends Recipe<?>> Supplier<RecipeType<T>> registerRecipeType(String name, Supplier<RecipeType<T>> typeSupplier) {
        DeferredHolder<RecipeType<?>, RecipeType<T>> deferredHolder = RECIPE_TYPES.register(name, typeSupplier);
        return deferredHolder;
    }

    @Override
    public <T extends SoundEvent> Supplier<T> registerSoundEvent(String name, Supplier<T> soundEventSupplier) {
        DeferredHolder<SoundEvent, T> deferredHolder = SOUND_EVENTS.register(name, soundEventSupplier);
        return deferredHolder;
    }

    @Override
    public <T extends FlowingFluid> Supplier<T> registerSourceFluid(String name, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing, Supplier<? extends Item> bucket, Supplier<? extends LiquidBlock> block) {
        Supplier<FluidType> type = name.contains("super") ? ModFluidTypes.SUPER_SOAPY_WATER_TYPE : ModFluidTypes.SOAPY_WATER_TYPE;
        return (Supplier<T>) (Supplier<?>) FLUIDS.register(name, () -> new BaseFluidNeoForge.Source(still, flowing, bucket, block, type));
    }

    @Override
    public <T extends FlowingFluid> Supplier<T> registerFlowingFluid(String name, Supplier<? extends Fluid> still, Supplier<? extends Fluid> flowing, Supplier<? extends Item> bucket, Supplier<? extends LiquidBlock> block) {
        Supplier<FluidType> type = name.contains("super") ? ModFluidTypes.SUPER_SOAPY_WATER_TYPE : ModFluidTypes.SOAPY_WATER_TYPE;
        return (Supplier<T>) (Supplier<?>) FLUIDS.register(name, () -> new BaseFluidNeoForge.Flowing(still, flowing, bucket, block, type));
    }

}