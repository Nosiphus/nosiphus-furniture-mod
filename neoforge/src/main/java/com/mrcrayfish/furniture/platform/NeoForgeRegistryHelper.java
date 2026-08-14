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
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class NeoForgeRegistryHelper implements IRegistryHelper {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MrCrayFishFurnitureMod.MOD_ID);
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, MrCrayFishFurnitureMod.MOD_ID);

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

}