package com.nosiphus.furniture.platform;

import com.nosiphus.furniture.platform.services.IPlatformHelper;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.network.NetworkHooks;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.function.Consumer;

public class ForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "Forge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    private static Field selectedTabField = null;

    private static Field getSelectedTabField() {
        if (selectedTabField == null) {
            try {
                selectedTabField = Arrays.stream(CreativeModeInventoryScreen.class.getDeclaredFields())
                        .filter(f -> java.lang.reflect.Modifier.isStatic(f.getModifiers()) && f.getType() == CreativeModeTab.class)
                        .findFirst()
                        .orElseThrow(() -> new NoSuchFieldException("Could not find static CreativeModeTab field in CreativeModeInventoryScreen"));
                selectedTabField.setAccessible(true);
            } catch (Exception e) {
                throw new RuntimeException("Failed to locate selectedTab field", e);
            }
        }
        return selectedTabField;
    }

    @Override
    public CreativeModeTab getSelectedCreativeTab(CreativeModeInventoryScreen screen) {
        try {
            return (CreativeModeTab) getSelectedTabField().get(null);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to read selectedTab from CreativeModeInventoryScreen", e);
        }
    }

    @Override
    public int getGuiLeft(CreativeModeInventoryScreen screen) {
        return screen.getGuiLeft();
    }

    @Override
    public int getGuiTop(CreativeModeInventoryScreen screen) {
        return screen.getGuiTop();
    }

    @Override
    public void openMenu(ServerPlayer player, MenuProvider provider, BlockPos pos) {
        NetworkHooks.openScreen(player, provider, pos);
    }

    @Override
    public void openMenu(ServerPlayer player, MenuProvider provider, Consumer<FriendlyByteBuf> extraDataWriter) {
        NetworkHooks.openScreen(player, provider, extraDataWriter::accept);
    }

    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(MenuFactory<T> factory) {
        return IForgeMenuType.create(factory::create);
    }
}
