package com.nosiphus.furniture.platform;

import com.mrcrayfish.furniture.mixin.AbstractContainerScreenAccessor;
import com.mrcrayfish.furniture.mixin.CreativeModeInventoryScreenAccessor;
import com.nosiphus.furniture.platform.services.IPlatformHelper;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public CreativeModeTab getSelectedCreativeTab(CreativeModeInventoryScreen screen) {
        return CreativeModeInventoryScreenAccessor.cfm$getSelectedTab();
    }

    @Override
    public int getGuiLeft(CreativeModeInventoryScreen screen) {
        return ((AbstractContainerScreenAccessor) screen).getLeftPos();
    }

    @Override
    public int getGuiTop(CreativeModeInventoryScreen screen) {
        return ((AbstractContainerScreenAccessor) screen).getTopPos();
    }

    @Override
    public void openMenu(ServerPlayer player, MenuProvider provider, BlockPos pos) {
        this.openMenu(player, provider, buf -> buf.writeBlockPos(pos));
    }

    @Override
    public void openMenu(ServerPlayer player, MenuProvider provider, Consumer<FriendlyByteBuf> extraDataWriter) {
        player.openMenu(new ExtendedScreenHandlerFactory() {
            @Override
            public void writeScreenOpeningData(ServerPlayer serverPlayer, FriendlyByteBuf buf) {
                extraDataWriter.accept(buf);
            }

            @Override
            public Component getDisplayName() {
                return provider.getDisplayName();
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
                return provider.createMenu(syncId, inventory, player);
            }
        });
    }

    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(MenuFactory<T> factory) {
        return new ExtendedScreenHandlerType<>(factory::create);
    }
}
