package com.nosiphus.furniture.client.gui.components;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.nosiphus.furniture.client.event.CreativeScreenEvents;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;

/**
 * Author: MrCrayfish
 */
public class TagButton extends Button
{
    private static final ResourceLocation TABS = new ResourceLocation(MrCrayFishFurnitureMod.MOD_ID, "textures/gui/container/creative_inventory/tabs.png");

    private final CreativeScreenEvents.TagFilter category;
    private final ItemStack stack;
    private boolean toggled;

    public TagButton(int x, int y, CreativeScreenEvents.TagFilter category, OnPress onPress)
    {
        super(x, y, 32, 26, CommonComponents.EMPTY, onPress, DEFAULT_NARRATION);
        this.category = category;
        this.stack = category.getIcon();
        this.toggled = category.isEnabled();
        this.setTooltip(Tooltip.create(category.getName()));
    }

    public CreativeScreenEvents.TagFilter getCategory()
    {
        return this.category;
    }

    @Override
    public void onPress()
    {
        this.toggled = !this.toggled;
        this.category.setEnabled(this.toggled);
        super.onPress();
    }

    @Override
    public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks)
    {
        int width = this.toggled ? 32 : 28;
        int textureX = 26;
        int textureY = this.toggled ? 32 : 0;

        RenderSystem.setShaderTexture(0, TABS);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);

        this.drawRotatedTexture(graphics.pose().last().pose(), this.getX(), this.getY(), textureX, textureY, width, 26);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        graphics.renderItem(this.stack, this.getX() + 8, this.getY() + 5);
    }

    private void drawRotatedTexture(Matrix4f matrix, int x, int y, int texX, int texY, int width, int height)
    {
        float scale = 0.00390625F; // 1/256
        RenderSystem.setShader(GameRenderer::getPositionTexShader);

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder builder = tesselator.getBuilder();
        builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

        builder.vertex(matrix, x, y + height, 0.0F).uv((texX + height) * scale, texY * scale).endVertex();
        builder.vertex(matrix, x + width, y + height, 0.0F).uv((texX + height) * scale, (texY + width) * scale).endVertex();
        builder.vertex(matrix, x + width, y, 0.0F).uv(texX * scale, (texY + width) * scale).endVertex();
        builder.vertex(matrix, x, y, 0.0F).uv(texX * scale, texY * scale).endVertex();

        BufferUploader.drawWithShader(builder.end());
    }

    public void updateState()
    {
        this.toggled = this.category.isEnabled();
    }

}