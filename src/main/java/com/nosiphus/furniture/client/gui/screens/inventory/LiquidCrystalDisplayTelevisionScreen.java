package com.nosiphus.furniture.client.gui.screens.inventory;

import com.nosiphus.furniture.network.protocol.common.ServerboundLcdTvUpdate;
import com.nosiphus.furniture.network.protocol.common.ServerboundLcdTvSetGif;
import com.nosiphus.furniture.world.inventory.LiquidCrystalDisplayTelevisionMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.network.PacketDistributor;

public class LiquidCrystalDisplayTelevisionScreen extends AbstractContainerScreen<LiquidCrystalDisplayTelevisionMenu> {

    // GUI dimensions - no texture needed, purely programmatic
    private static final int GUI_WIDTH = 176;
    private static final int GUI_HEIGHT = 160;

    // Channel names
    private static final String[] CHANNEL_NAMES = {"Ch 1", "Ch 2", "Ch 3", "Ch 4"};
    private static final int[] CHANNEL_COLORS = {
        0xFFFF5555, // Red
        0xFF55FF55, // Green
        0xFF5555FF, // Blue
        0xFFFFFF55  // Yellow
    };

    private EditBox gifUrlBox;
    private String gifStatus = "";

    public LiquidCrystalDisplayTelevisionScreen(LiquidCrystalDisplayTelevisionMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        this.imageWidth = GUI_WIDTH;
        this.imageHeight = GUI_HEIGHT;
    }

    @Override
    protected void init() {
        super.init();

        int startX = this.leftPos;
        int startY = this.topPos;

        // Power toggle button (top center)
        this.addRenderableWidget(Button.builder(getPowerLabel(), btn -> {
            boolean newPower = !this.menu.isPowered();
            int channel = this.menu.getChannel();
            PacketDistributor.sendToServer(new ServerboundLcdTvUpdate(
                    this.menu.getBlockEntity().getBlockPos(), newPower, channel));
            btn.setMessage(newPower
                    ? Component.literal("Power: ON")
                    : Component.literal("Power: OFF"));
        }).bounds(startX + 63, startY + 10, 50, 20).build());

        // Channel buttons (in a row below power)
        for (int i = 0; i < 4; i++) {
            final int channelIndex = i;
            this.addRenderableWidget(Button.builder(Component.literal(CHANNEL_NAMES[i]), btn -> {
                boolean power = this.menu.isPowered();
                PacketDistributor.sendToServer(new ServerboundLcdTvUpdate(
                        this.menu.getBlockEntity().getBlockPos(), power, channelIndex));
            }).bounds(startX + 8 + i * 40, startY + 45, 36, 20).build());
        }

        // GIF URL label + text field
        this.gifUrlBox = new EditBox(this.font,
                startX + 8, startY + 95, GUI_WIDTH - 16 - 52, 18,
                Component.literal("GIF URL"));
        this.gifUrlBox.setMaxLength(512);
        this.gifUrlBox.setValue(this.menu.getGifUrl());
        this.gifUrlBox.setHint(Component.literal("Paste GIF URL here..."));
        this.addRenderableWidget(this.gifUrlBox);

        // "Set GIF" button
        this.addRenderableWidget(Button.builder(Component.literal("Set GIF"), btn -> {
            String url = this.gifUrlBox.getValue().trim();
            PacketDistributor.sendToServer(new ServerboundLcdTvSetGif(
                    this.menu.getBlockEntity().getBlockPos(), url));
            this.gifStatus = url.isEmpty() ? "Cleared." : "Sent!";
        }).bounds(startX + GUI_WIDTH - 52, startY + 95, 48, 18).build());
    }

    private Component getPowerLabel() {
        return this.menu.isPowered()
                ? Component.literal("Power: ON")
                : Component.literal("Power: OFF");
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        // Dark background panel
        graphics.fill(this.leftPos, this.topPos, this.leftPos + this.imageWidth, this.topPos + this.imageHeight, 0xC0101010);
        // Border
        graphics.fill(this.leftPos, this.topPos, this.leftPos + this.imageWidth, this.topPos + 1, 0xFF555555);
        graphics.fill(this.leftPos, this.topPos + this.imageHeight - 1, this.leftPos + this.imageWidth, this.topPos + this.imageHeight, 0xFF555555);
        graphics.fill(this.leftPos, this.topPos, this.leftPos + 1, this.topPos + this.imageHeight, 0xFF555555);
        graphics.fill(this.leftPos + this.imageWidth - 1, this.topPos, this.leftPos + this.imageWidth, this.topPos + this.imageHeight, 0xFF555555);

        // Channel indicator bar - show color of active channel if powered
        if (this.menu.isPowered()) {
            int ch = this.menu.getChannel();
            int indicatorColor = CHANNEL_COLORS[ch];
            graphics.fill(this.leftPos + 8, this.topPos + 75, this.leftPos + this.imageWidth - 8, this.topPos + 90, indicatorColor);
            graphics.drawString(this.font,
                    Component.literal("Channel " + (ch + 1) + " - ON"),
                    this.leftPos + 14, this.topPos + 79, 0xFF000000, false);
        } else {
            graphics.fill(this.leftPos + 8, this.topPos + 75, this.leftPos + this.imageWidth - 8, this.topPos + 90, 0xFF222222);
            graphics.drawString(this.font,
                    Component.literal("TV is OFF"),
                    this.leftPos + 14, this.topPos + 79, 0xFF888888, false);
        }

        // GIF URL label
        graphics.drawString(this.font, Component.literal("GIF URL:"),
                this.leftPos + 8, this.topPos + 85, 0xFFAAAAAA, false);

        // Status line
        if (!this.gifStatus.isEmpty()) {
            graphics.drawString(this.font, Component.literal(this.gifStatus),
                    this.leftPos + 8, this.topPos + 118, 0xFF55FF55, false);
        }
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
        graphics.drawString(this.font, this.title, (this.imageWidth - this.font.width(this.title)) / 2, -10, 0xFFAAAAAA, false);
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        this.renderBackground(graphics, mouseX, mouseY, delta);
        super.render(graphics, mouseX, mouseY, delta);
        this.renderTooltip(graphics, mouseX, mouseY);
    }
}