package com.mrcrayfish.furniture.platform;

import com.mrcrayfish.furniture.event.FreezerFuelTimeEvent;
import com.mrcrayfish.furniture.event.ItemSolidifyEvent;
import com.mrcrayfish.furniture.network.Message;
import com.mrcrayfish.furniture.platform.services.IPlatformHelper;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundCustomPayloadPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

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
    public TextureAtlasSprite getStillFluidSprite(Fluid fluid) {
        IClientFluidTypeExtensions properties = IClientFluidTypeExtensions.of(fluid);
        ResourceLocation texture = properties.getStillTexture();
        if (texture == null) {
            texture = new ResourceLocation("block/water_still");
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
        MinecraftForge.EVENT_BUS.post(event);
        return event.getFuelTime();
    }

    @Override
    public void fireItemSolidifyEvent(Player player, ItemStack stack) {
        MinecraftForge.EVENT_BUS.post(new ItemSolidifyEvent(player, stack));
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return ForgeHooks.getBurnTime(stack, recipeType);
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