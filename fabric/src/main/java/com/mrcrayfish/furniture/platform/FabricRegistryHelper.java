package com.mrcrayfish.furniture.platform;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.platform.services.IRegistryHelper;
import net.minecraft.core.Registry;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class FabricRegistryHelper implements IRegistryHelper {

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        T registeredBlock = Registry.register(
                BuiltInRegistries.BLOCK,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name),
                blockSupplier.get()
        );
        return () -> registeredBlock;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityType(String name, Supplier<BlockEntityType<T>> blockEntityTypeSupplier) {
        BlockEntityType<T> registeredType = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name),
                blockEntityTypeSupplier.get()
        );
        return () -> registeredType;
    }

    @Override
    public <T extends EntityType<?>> Supplier<T> registerEntityType(String name, Supplier<T> entityTypeSupplier) {
        T registeredEntityType = Registry.register(
                BuiltInRegistries.ENTITY_TYPE,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name),
                entityTypeSupplier.get()
        );
        return () -> registeredEntityType;
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> itemSupplier) {
        T registeredItem = Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name),
                itemSupplier.get()
        );
        return () -> registeredItem;
    }

    @Override
    public <T extends MenuType<?>> Supplier<T> registerMenuType(String name, Supplier<T> menuTypeSupplier) {
        T registeredMenuType = Registry.register(
                BuiltInRegistries.MENU,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name),
                menuTypeSupplier.get()
        );
        return () -> registeredMenuType;
    }

    @Override
    public <T extends RecipeSerializer<?>> Supplier<T> registerRecipeSerializer(String name, Supplier<T> serializerSupplier) {
        T registeredSerializer = Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name),
                serializerSupplier.get()
        );
        return () -> registeredSerializer;
    }

    @Override
    public <T extends Recipe<?>> Supplier<RecipeType<T>> registerRecipeType(String name, Supplier<RecipeType<T>> typeSupplier) {
        RecipeType<T> registeredType = Registry.register(
                BuiltInRegistries.RECIPE_TYPE,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name),
                typeSupplier.get()
        );
        return () -> registeredType;
    }

    @Override
    public <T extends SoundEvent> Supplier<T> registerSoundEvent(String name, Supplier<T> soundEventSupplier) {
        T registeredSoundEvent = Registry.register(
                BuiltInRegistries.SOUND_EVENT,
                ResourceLocation.fromNamespaceAndPath(MrCrayFishFurnitureMod.MOD_ID, name),
                soundEventSupplier.get()
        );
        return () -> registeredSoundEvent;
    }

}