package com.nosiphus.furniture.client.gui.screens.inventory;

import com.nosiphus.furniture.network.protocol.common.ServerboundTVURLSync;
import com.nosiphus.furniture.world.inventory.CathodeRayTubeTelevisionMenu;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.network.PacketDistributor;

public class CathodeRayTubeTelevisionScreen extends AbstractContainerScreen<CathodeRayTubeTelevisionMenu> {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("nfm", "textures/gui/value_container.png");

    private EditBox urlInput;
    private int selectedChannel = 0;

    public CathodeRayTubeTelevisionScreen(CathodeRayTubeTelevisionMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = 176;
        this.imageHeight = 35;
    }

    @Override
    protected void init() {
        super.init();
        CathodeRayTubeTelevisionBlockEntity tv = this.menu.getBlockEntity();
        this.urlInput = new EditBox(
                this.font,
                this.leftPos + 15,
                this.topPos + 45,
                180,
                18,
                Component.translatable("gui.cfm.tv.url_field")
        );
        this.urlInput.setMaxLength(256);
        this.urlInput.setValue(tv.getChannelUrl(this.selectedChannel));
        this.addRenderableWidget(this.urlInput);
        for (int i = 0; i < 3; i++) {
            final int channelIndex = i;
            Button channelBtn = Button.builder(Component.literal("Ch " + (i + 1)), button -> {
                        this.selectedChannel = channelIndex;
                        this.urlInput.setValue(tv.getChannelUrl(this.selectedChannel));
                    }).bounds(this.leftPos + 15 + (i * 60), this.topPos + 18, 55, 20).build();
            this.addRenderableWidget(channelBtn);
        }
        Button saveBtn = Button.builder(Component.translatable("gui.done"), button -> {
                    saveAndSendUrl();
                }).bounds(this.leftPos + 15, this.topPos + 75, 85, 20).build();
        Button cancelBtn = Button.builder(Component.translatable("gui.cancel"), button -> {
                    this.onClose();
                }).bounds(this.leftPos + 110, this.topPos + 75, 85, 20).build();
        this.addRenderableWidget(saveBtn);
        this.addRenderableWidget(cancelBtn);
    }

    private void saveAndSendUrl() {
        String newUrl = this.urlInput.getValue().trim();
        CathodeRayTubeTelevisionBlockEntity tv = this.menu.getBlockEntity();
        PacketDistributor.sendToServer(new ServerboundTVURLSync(tv.getBlockPos(), this.selectedChannel, newUrl));
        this.onClose();
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
