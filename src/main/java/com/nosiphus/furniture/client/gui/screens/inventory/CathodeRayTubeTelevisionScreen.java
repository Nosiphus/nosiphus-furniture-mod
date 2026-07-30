package com.nosiphus.furniture.client.gui.screens.inventory;

import com.nosiphus.furniture.world.inventory.CathodeRayTubeTelevisionMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CathodeRayTubeTelevisionScreen extends AbstractContainerScreen<CathodeRayTubeTelevisionMenu> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("nfm", "textures/gui/value_container.png");

    public CathodeRayTubeTelevisionScreen(CathodeRayTubeTelevisionMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = 176;
        this.imageHeight = 35;
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        graphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawString(this.font, this.title, this.leftPos + 15, this.topPos + 6, 0x404040, false);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
