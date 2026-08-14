package com.nosiphus.furniture.client.gui.screens.inventory;

import com.nosiphus.furniture.network.protocol.common.ServerboundBinEmpty;
import com.nosiphus.furniture.platform.Services;
import com.nosiphus.furniture.world.inventory.BinMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class BinScreen extends AbstractContainerScreen<BinMenu> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("nfm", "textures/gui/bin.png");

    public BinScreen(BinMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = 176;
        this.imageHeight = 197;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
        this.addRenderableWidget(Button.builder(Component.translatable("gui.button.nfm.bin.empty"), (button) -> {
            Services.NETWORK.sendToServer(new ServerboundBinEmpty(this.getMenu().getBlockEntity().getBlockPos()));
            button.setFocused(false);
        }).bounds(this.leftPos + 128, this.topPos + 48, 40, 20).build());
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        graphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 0xFFFFFF, false);
        graphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 0xFFFFFF, false);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(graphics, mouseX, mouseY, delta);
        super.render(graphics, mouseX, mouseY, delta);
        this.renderTooltip(graphics, mouseX, mouseY);
    }
}