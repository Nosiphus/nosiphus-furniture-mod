package com.mrcrayfish.furniture.platform.services;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Checks if a mod with the given id is loaded.
     *
     * @param modId The mod to check if it is loaded.
     * @return True if the mod is loaded, false otherwise.
     */
    boolean isModLoaded(String modId);

    /**
     * Check if the game is currently in a development environment.
     *
     * @return True if in a development environment, false otherwise.
     */
    boolean isDevelopmentEnvironment();

    /**
     * Gets the name of the environment type as a string.
     *
     * @return The name of the environment type.
     */
    default String getEnvironmentName() {

        return isDevelopmentEnvironment() ? "development" : "production";
    }

    int getGuiLeft(CreativeModeInventoryScreen screen);
    int getGuiTop(CreativeModeInventoryScreen screen);
    TextureAtlasSprite getStillFluidSprite(Fluid fluid);
    int getFluidColor(Fluid fluid, @Nullable Level level, @Nullable BlockPos pos);
    int getFreezerFuelTime(ItemStack stack, int defaultFuelTime);
    void fireItemSolidifyEvent(Player player, ItemStack stack);
    int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType);
    void sendToTrackingChunk(ServerLevel level, BlockPos pos, CustomPacketPayload payload);
    ItemStack getCraftingRemainingItem(ItemStack stack);
    void openMenu(ServerPlayer player, MenuProvider provider, BlockPos pos);
    void openMenu(ServerPlayer player, MenuProvider provider, Consumer<RegistryFriendlyByteBuf> extraDataWriter);
    <T extends AbstractContainerMenu> MenuType<T> createMenuType(MenuFactory<T> factory);
    @FunctionalInterface
    interface MenuFactory<T extends AbstractContainerMenu> {
        T create(int windowId, Inventory inventory, RegistryFriendlyByteBuf buf);
    }

}