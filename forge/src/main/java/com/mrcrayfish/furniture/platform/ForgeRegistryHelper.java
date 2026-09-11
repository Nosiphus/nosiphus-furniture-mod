package com.mrcrayfish.furniture.platform;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.platform.services.IRegistryHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ForgeRegistryHelper implements IRegistryHelper {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MrCrayFishFurnitureMod.MOD_ID);

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
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

    @Override
    public <T extends MenuType<?>> Supplier<T> registerMenuType(String name, Supplier<T> menuTypeSupplier) {
        return MENU_TYPES.register(name, menuTypeSupplier);
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

}