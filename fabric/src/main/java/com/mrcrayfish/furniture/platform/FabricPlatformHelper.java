package com.mrcrayfish.furniture.platform;

import com.mrcrayfish.furniture.event.FreezerEvents;
import com.mrcrayfish.furniture.mixin.AbstractContainerScreenAccessor;
import com.mrcrayfish.furniture.mixin.CreativeModeInventoryScreenAccessor;
import com.mrcrayfish.furniture.network.Message;
import com.mrcrayfish.furniture.platform.services.IPlatformHelper;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
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
    public TextureAtlasSprite getStillFluidSprite(Fluid fluid) {
        if (fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER) {
            return Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                    .apply(new ResourceLocation("block/water_still"));
        }
        TextureAtlasSprite sprite = FluidVariantRendering.getSprite(FluidVariant.of(fluid));
        if (sprite == null) {
            sprite = Minecraft.getInstance().getTextureAtlas(TextureAtlas.LOCATION_BLOCKS)
                    .apply(new ResourceLocation("block/water_still"));
        }
        return sprite;
    }

    @Override
    public int getFluidColor(Fluid fluid, @Nullable Level level, @Nullable BlockPos pos) {
        int color = FluidVariantRendering.getColor(FluidVariant.of(fluid), level, pos);
        if ((color & 0xFF000000) == 0) {
            color |= 0xFF000000;
        }
        return color;
    }

    @Override
    public int getFreezerFuelTime(ItemStack stack, int defaultFuelTime) {
        return FreezerEvents.FREEZER_FUEL_TIME.invoker().getFuelTime(stack, defaultFuelTime);
    }

    @Override
    public void fireItemSolidifyEvent(Player player, ItemStack stack) {
        FreezerEvents.ITEM_SOLIDIFY.invoker().onSolidify(player, stack);
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
        Integer burnTime = FuelRegistry.INSTANCE.get(stack.getItem());
        return burnTime != null ? burnTime : 0;
    }

    @Override
    public void sendToTrackingChunk(ServerLevel level, BlockPos pos, Message message) {
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        message.encode(buf);
        for (ServerPlayer player : PlayerLookup.tracking(level, pos)) {
            ServerPlayNetworking.send(player, message.getId(), buf);
        }
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (stack.getItem().hasCraftingRemainingItem()) {
            return new ItemStack(stack.getItem().getCraftingRemainingItem());
        }
        return ItemStack.EMPTY;
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
