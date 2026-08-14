package com.mrcrayfish.furniture.platform;

import com.mrcrayfish.furniture.event.FreezerFuelTimeEvent;
import com.mrcrayfish.furniture.event.ItemSolidifyEvent;
import com.mrcrayfish.furniture.platform.services.IPlatformHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
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
    public TextureAtlasSprite getStillFluidSprite(Fluid fluid) {
        IClientFluidTypeExtensions properties = IClientFluidTypeExtensions.of(fluid);
        ResourceLocation texture = properties.getStillTexture();
        if (texture == null) {
            texture = ResourceLocation.withDefaultNamespace("block/water_still");
        }
        return Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS).apply(texture);
    }

    @Override
    public int getFluidColor(Fluid fluid, @Nullable Level level, @Nullable BlockPos pos) {
        IClientFluidTypeExtensions properties = IClientFluidTypeExtensions.of(fluid);
        int color;
        if (level != null && pos != null) {
            color = properties.getTintColor(fluid.defaultFluidState(), level, pos);
        } else {
            color = properties.getTintColor(new FluidStack(fluid, 1000));
        }
        if ((color & 0xFF000000) == 0) {
            color |= 0xFF000000;
        }
        return color;
    }

    @Override
    public int getFreezerFuelTime(ItemStack stack, int defaultFuelTime) {
        FreezerFuelTimeEvent event = new FreezerFuelTimeEvent(stack);
        event.setFuelTime(defaultFuelTime);
        NeoForge.EVENT_BUS.post(event);
        return event.getFuelTime();
    }

    @Override
    public void fireItemSolidifyEvent(Player player, ItemStack stack) {
        NeoForge.EVENT_BUS.post(new ItemSolidifyEvent(player, stack));
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return stack.getBurnTime(recipeType);
    }

    @Override
    public void sendToTrackingChunk(ServerLevel level, BlockPos pos, CustomPacketPayload payload) {
        PacketDistributor.sendToPlayersTrackingChunk(level, level.getChunkAt(pos).getPos(), payload);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.hasCraftingRemainingItem()) {
            return stack.getCraftingRemainingItem();
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void openMenu(ServerPlayer player, MenuProvider provider, BlockPos pos) {
        player.openMenu(provider, pos);
    }

    @Override
    public void openMenu(ServerPlayer player, MenuProvider provider, Consumer<RegistryFriendlyByteBuf> extraDataWriter) {
        player.openMenu(provider, extraDataWriter::accept);
    }

    @Override
    public <T extends AbstractContainerMenu> MenuType<T> createMenuType(MenuFactory<T> factory) {
        return IMenuTypeExtension.create(factory::create);
    }

}