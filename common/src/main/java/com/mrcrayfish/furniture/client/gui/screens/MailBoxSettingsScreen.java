package com.mrcrayfish.furniture.client.gui.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.network.message.C2SMessageOpenMailBox;
import com.mrcrayfish.furniture.network.message.C2SMessageSetMailBoxName;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.world.level.block.entity.MailBoxBlockEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.UUID;

/**
 * Author: MrCrayfish
 */
public class MailBoxSettingsScreen extends Screen
{
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, "textures/gui/mail_box_settings.png");

    private final int xSize = 176;
    private final int ySize = 69;

    private final MailBoxBlockEntity mailBoxBlockEntity;
    private EditBox nameField;
    private Button btnSave;

    public MailBoxSettingsScreen(MailBoxBlockEntity mailBoxBlockEntity)
    {
        super(Component.translatable("gui.cfm.mail_box_settings"));
        this.mailBoxBlockEntity = mailBoxBlockEntity;
    }

    @Override
    protected void init()
    {
        int guiLeft = (this.width - this.xSize) / 2;
        int guiTop = (this.height - this.ySize) / 2;

        this.nameField = new EditBox(this.font, guiLeft + 8, guiTop + 18, 160, 18, CommonComponents.EMPTY);
        this.nameField.setMaxLength(32);
        if(this.mailBoxBlockEntity.getMailBoxName() != null)
        {
            this.nameField.setValue(this.mailBoxBlockEntity.getMailBoxName());
        }
        this.addRenderableWidget(this.nameField);
        this.setInitialFocus(this.nameField);

        this.btnSave = this.addRenderableWidget(Button.builder(Component.translatable("gui.button.cfm.save"), button -> {
            UUID id = this.mailBoxBlockEntity.getId();
            if (id != null && this.isValidName())
            {
                Services.NETWORK.sendToServer(new C2SMessageSetMailBoxName(this.nameField.getValue(), id));
                Services.NETWORK.sendToServer(new C2SMessageOpenMailBox(this.mailBoxBlockEntity.getBlockPos()));
            }
        }).pos(guiLeft + 7, guiTop + 42).size(79, 20).build());
        this.btnSave.active = false;

        this.addRenderableWidget(Button.builder(Component.translatable("gui.button.cfm.back"), button -> {
            Services.NETWORK.sendToServer(new C2SMessageOpenMailBox(this.mailBoxBlockEntity.getBlockPos()));
        }).pos(guiLeft + 91, guiTop + 42).size(79, 20).build());
    }

    @Override
    public void tick()
    {
        super.tick();
        this.btnSave.active = this.isValidName();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground(graphics);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        int startX = (this.width - this.xSize) / 2;
        int startY = (this.height - this.ySize) / 2;
        graphics.blit(GUI_TEXTURE, startX, startY, 0, 0, this.xSize, this.ySize);
        super.render(graphics, mouseX, mouseY, partialTicks);
        graphics.drawString(this.font, this.title.getString(), startX + 8, startY + 6, 0x404040);
        this.nameField.render(graphics, mouseX, mouseY, partialTicks);
    }

    private boolean isValidName()
    {
        String currentName = this.nameField.getValue().trim();
        return !currentName.isEmpty() && !currentName.equals(this.mailBoxBlockEntity.getMailBoxName());
    }
}