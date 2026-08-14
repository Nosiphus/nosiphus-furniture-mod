package com.nosiphus.furniture.client.gui.screens.inventory;

import com.nosiphus.furniture.network.protocol.common.ServerboundTVChannelSync;
import com.nosiphus.furniture.network.protocol.common.ServerboundTVURLSync;
import com.nosiphus.furniture.platform.Services;
import com.nosiphus.furniture.world.inventory.CathodeRayTubeTelevisionMenu;
import com.nosiphus.furniture.world.level.block.CathodeRayTubeTelevisionBlock;
import com.nosiphus.furniture.world.level.block.entity.CathodeRayTubeTelevisionBlockEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.state.BlockState;

public class CathodeRayTubeTelevisionScreen extends AbstractContainerScreen<CathodeRayTubeTelevisionMenu> {

    private EditBox urlInput;
    private int selectedChannel = 0;

    public CathodeRayTubeTelevisionScreen(CathodeRayTubeTelevisionMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = 210;
        this.imageHeight = 130;
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = -1000;
        CathodeRayTubeTelevisionBlockEntity tv = this.menu.getBlockEntity();
        BlockState state = tv != null && tv.getLevel() != null ? tv.getLevel().getBlockState(tv.getBlockPos()) : null;
        if (state != null && state.hasProperty(CathodeRayTubeTelevisionBlock.CHANNEL)) {
            this.selectedChannel = state.getValue(CathodeRayTubeTelevisionBlock.CHANNEL);
        }
        this.urlInput = new EditBox(
                this.font,
                this.leftPos + 15,
                this.topPos + 45,
                180,
                18,
                Component.translatable("gui.field.nfm.tv.url")
        );
        this.urlInput.setMaxLength(256);
        this.urlInput.setValue(tv != null ? tv.getChannelUrl(this.selectedChannel) : "");
        this.addRenderableWidget(this.urlInput);
        for (int i = 0; i < 3; i++) {
            final int channelIndex = i;
            Button channelBtn = Button.builder(Component.literal("Ch " + (i + 1)), button -> {
                this.selectedChannel = channelIndex;
                if (tv != null) {
                    this.urlInput.setValue(tv.getChannelUrl(this.selectedChannel));
                }
                onChannelButtonClicked(channelIndex);
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

    private void onChannelButtonClicked(int channelIndex) {
        CathodeRayTubeTelevisionBlockEntity tv = this.menu.getBlockEntity();
        if (tv != null) {
            Services.NETWORK.sendToServer(new ServerboundTVChannelSync(tv.getBlockPos(), channelIndex));
        }
    }

    private void saveAndSendUrl() {
        String newUrl = this.urlInput.getValue().trim();
        CathodeRayTubeTelevisionBlockEntity tv = this.menu.getBlockEntity();
        if (tv != null) {
            Services.NETWORK.sendToServer(new ServerboundTVURLSync(tv.getBlockPos(), this.selectedChannel, newUrl));
        }
        this.onClose();
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {}

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        int titleWidth = this.font.width(this.title);
        int centeredX = (this.imageWidth - titleWidth) / 2;
        graphics.drawString(this.font, this.title, centeredX, 6, 0x404040, false);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        super.render(graphics, mouseX, mouseY, partialTick);
        this.renderTooltip(graphics, mouseX, mouseY);
    }
}