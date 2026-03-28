package com.nosiphus.furniture.client.gui.screens.inventory;

import com.nosiphus.furniture.world.inventory.DishwasherMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DishwasherScreen extends AbstractContainerScreen<DishwasherMenu> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("nfm", "textures/gui/dishwasher.png");

    public DishwasherScreen(DishwasherMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = 176;
        this.imageHeight = 228;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        this.renderBubbles(graphics);
        this.renderStatusLight(graphics);
        this.renderFluidLevel(graphics);
        this.renderTankOverlay(graphics);
    }

    private void renderBubbles(GuiGraphics graphics) {
        if (this.menu.getWashing()) {
            graphics.blit(TEXTURE, this.leftPos + 39, this.topPos + 39, 176, 0, 9, 55);
        }
    }

    private void renderStatusLight(GuiGraphics graphics) {
        int color = this.menu.getWashing() ? 0xFF00FF00 : 0xFFFF0000;
        graphics.fill(this.leftPos + 37, this.topPos + 9, this.leftPos + 48, this.topPos + 20, color);
    }

    private void renderFluidLevel(GuiGraphics graphics) {
        int height = this.menu.getFluidRenderHeight();
        int yOffset = this.menu.getFluidTypeYOffset();

        if (height > 0) {
            graphics.blit(TEXTURE,
                    this.leftPos + 129,
                    this.topPos + 39 + (55 - height),
                    yOffset,
                    (55 - height),
                    7,
                    height);
        }
    }

    private void renderTankOverlay(GuiGraphics graphics) {
        graphics.blit(TEXTURE, this.leftPos + 129, this.topPos + 39, 192, 0, 7, 55);
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
        if (this.isHovering(129, 39, 7, 55, mouseX, mouseY)) {
            graphics.renderTooltip(this.font,
                    Component.literal(this.menu.getFluidStack().getAmount() + " / 64000 mB"),
                    mouseX,
                    mouseY);
        }
    }
}