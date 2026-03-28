package com.nosiphus.furniture.client.gui.screens.inventory;

import com.mojang.blaze3d.systems.RenderSystem;
import com.nosiphus.furniture.world.inventory.PrinterMenu;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.entity.PrinterBlockEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class PrinterScreen extends AbstractContainerScreen<PrinterMenu> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("nfm", "textures/gui/printer.png");
    public PrinterBlockEntity blockEntity;

    public PrinterScreen(PrinterMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = 176;
        this.imageHeight = 185;
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int startX = (this.width - this.imageWidth) / 2;
        int startY = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
        renderInkLevel(guiGraphics, startX, startY);
        renderProgressBar(guiGraphics, startX, startY);
    }

    private void renderInkLevel(GuiGraphics guiGraphics, int x, int y) {
        if(menu.getSlot(0).getItem().getItem() == ModItems.INK_CARTRIDGE.get()) {
            guiGraphics.blit(TEXTURE, x + 74, y + 30 + (16 - menu.getRemainingInkLevel()), 179, (16 - menu.getRemainingInkLevel()), 3, menu.getRemainingInkLevel());
        }
    }

    private void renderProgressBar(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isPrinting()) {
            guiGraphics.blit(TEXTURE, x + 80, y + 30 + (16 - menu.getScaledProgress()), 176, (16 - menu.getScaledProgress()), 3, menu.getScaledProgress());
        }
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        Component title = this.title;
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, (this.imageHeight - 96 + 2), 0xFFFFFF);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(guiGraphics, mouseX, mouseY, delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);

        if(isHovering(73, 30, 5, 18, mouseX, mouseY)) {
            setTooltipForNextRenderPass(Component.literal(menu.getSlot(0).getItem().getMaxDamage() - menu.getSlot(0).getItem().getDamageValue() + " / 10000"));
        }
    }

}