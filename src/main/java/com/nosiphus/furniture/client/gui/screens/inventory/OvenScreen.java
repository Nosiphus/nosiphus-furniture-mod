package com.nosiphus.furniture.client.gui.screens.inventory;

import com.nosiphus.furniture.world.inventory.OvenMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class OvenScreen extends AbstractContainerScreen<OvenMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("nfm", "textures/gui/oven.png");

    public OvenScreen(OvenMenu menu, Inventory inventory, Component component) {
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

        for (int i = 0; i < 4; i++) {
            renderBurnerFire(graphics, i);
        }
    }

    private void renderBurnerFire(GuiGraphics graphics, int index) {
        if (this.menu.isCooking(index)) {
            int progress = this.menu.getScaledProgress(index);

            int xOffset = 54 + (index * 18);

            graphics.blit(TEXTURE,
                    this.leftPos + xOffset,
                    this.topPos + 55 + (14 - progress),
                    176,
                    (14 - progress),
                    14,
                    progress);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        graphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
        graphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(graphics, mouseX, mouseY, delta);
        super.render(graphics, mouseX, mouseY, delta);
        this.renderTooltip(graphics, mouseX, mouseY);
    }
}