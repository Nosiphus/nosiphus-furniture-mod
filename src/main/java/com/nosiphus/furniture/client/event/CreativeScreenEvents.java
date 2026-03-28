package com.nosiphus.furniture.client.event;

import com.google.common.collect.Lists;
import com.mrcrayfish.furniture.client.gui.components.IconButton;
import com.nosiphus.furniture.client.gui.components.TagButton;
import com.nosiphus.furniture.tags.ModItemTags;
import com.nosiphus.furniture.world.item.ModCreativeModeTabs;
import com.nosiphus.furniture.world.item.ModItems;
import com.nosiphus.furniture.world.level.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;

import java.util.*;

/**
 * Author: MrCrayfish
 */
public class CreativeScreenEvents
{
    private static final ResourceLocation ICONS = ResourceLocation.fromNamespaceAndPath("cfm", "textures/gui/icons.png");
    private static int startIndex;
    private static CreativeModeTab lastTab = CreativeModeTabs.getDefaultTab();

    private List<CreativeScreenEvents.TagFilter> filters;
    private List<TagButton> buttons;
    private Button btnScrollUp;
    private Button btnScrollDown;
    private Button btnEnableAll;
    private Button btnDisableAll;
    private int guiCenterX = 0;
    private int guiCenterY = 0;

    @SubscribeEvent
    public void onPlayerLogout(ClientPlayerNetworkEvent.LoggingOut event)
    {
        this.filters = null;
    }

    @SubscribeEvent
    public void onScreenInit(ScreenEvent.Init.Post event)
    {
        if(event.getScreen() instanceof CreativeModeInventoryScreen creativeScreen)
        {
            if(this.filters == null)
            {
                this.compileItems();
            }

            this.guiCenterX = creativeScreen.getGuiLeft();
            this.guiCenterY = creativeScreen.getGuiTop();
            this.buttons = this.createTagButtons();
            this.buttons.forEach(event::addListener);

            event.addListener(this.btnScrollUp = new IconButton(this.guiCenterX - 22, this.guiCenterY - 12, button -> {
                if(startIndex > 0) startIndex--;
                this.updateTagButtons();
            }, ICONS, 64, 0));

            event.addListener(this.btnScrollDown = new IconButton(this.guiCenterX - 22, this.guiCenterY + 127, button -> {
                if(startIndex <= filters.size() - 4 - 1) startIndex++;
                this.updateTagButtons();
            }, ICONS, 80, 0));

            event.addListener(this.btnEnableAll = new IconButton(this.guiCenterX - 50, this.guiCenterY + 10, button -> {
                this.filters.forEach(filters -> filters.setEnabled(true));
                this.buttons.forEach(TagButton::updateState);
                Screen screen = Minecraft.getInstance().screen;
                if(screen instanceof CreativeModeInventoryScreen)
                {
                    this.updateItems((CreativeModeInventoryScreen) screen);
                }
            }, ICONS, 96, 0));
            this.btnEnableAll.setTooltip(Tooltip.create(Component.translatable("gui.button.cfm.enable_filters")));

            event.addListener(this.btnDisableAll = new IconButton(this.guiCenterX - 50, this.guiCenterY + 32, button -> {
                this.filters.forEach(filters -> filters.setEnabled(false));
                this.buttons.forEach(TagButton::updateState);
                Screen screen = Minecraft.getInstance().screen;
                if(screen instanceof CreativeModeInventoryScreen)
                {
                    this.updateItems((CreativeModeInventoryScreen) screen);
                }
            }, ICONS, 112, 0));
            this.btnDisableAll.setTooltip(Tooltip.create(Component.translatable("gui.button.cfm.disable_filters")));

            this.onSwitchCreativeTab(CreativeModeInventoryScreen.selectedTab, creativeScreen);
        }
    }

    @SubscribeEvent
    public void onScreenDrawPost(ScreenEvent.Render.Post event)
    {
        if(event.getScreen() instanceof CreativeModeInventoryScreen creativeScreen)
        {
            this.guiCenterX = creativeScreen.getGuiLeft();
            this.guiCenterY = creativeScreen.getGuiTop();

            CreativeModeTab tab = CreativeModeInventoryScreen.selectedTab;
            if(lastTab != tab)
            {
                this.onSwitchCreativeTab(tab, creativeScreen);
                lastTab = tab;
            }
        }
    }

    private void onSwitchCreativeTab(CreativeModeTab tab, CreativeModeInventoryScreen screen)
    {
        if(tab == ModCreativeModeTabs.NFM.get())
        {
            this.btnScrollUp.visible = true;
            this.btnScrollDown.visible = true;
            this.btnEnableAll.visible = true;
            this.btnDisableAll.visible = true;
            this.updateTagButtons();
            this.updateItems(screen);
        }
        else
        {
            this.btnScrollUp.visible = false;
            this.btnScrollDown.visible = false;
            this.btnEnableAll.visible = false;
            this.btnDisableAll.visible = false;
            this.buttons.forEach(button -> button.visible = false);
        }
    }

    private List<TagButton> createTagButtons()
    {
        List<TagButton> tagButtons = new ArrayList<>();
        for(CreativeScreenEvents.TagFilter filter : this.filters)
        {
            TagButton tagButton = new TagButton(this.guiCenterX - 28, this.guiCenterY, filter, button -> {
                Screen screen = Minecraft.getInstance().screen;
                if(screen instanceof CreativeModeInventoryScreen creativeScreen)
                {
                    this.updateItems(creativeScreen);
                }
            });
            tagButton.visible = false;
            tagButtons.add(tagButton);
        }
        return tagButtons;
    }

    private void updateTagButtons()
    {
        this.buttons.forEach(button -> button.visible = false);
        for(int i = startIndex; i < startIndex + 4 && i < this.buttons.size(); i++)
        {
            TagButton button = this.buttons.get(i);
            button.setY(this.guiCenterY + 29 * (i - startIndex) + 11);
            button.visible = true;
        }
        this.btnScrollUp.active = startIndex > 0;
        this.btnScrollDown.active = startIndex <= this.filters.size() - 4 - 1;
    }

    private void updateItems(CreativeModeInventoryScreen screen)
    {
        CreativeModeInventoryScreen.ItemPickerMenu menu = screen.getMenu();
        LinkedHashSet<Item> categorisedItems = new LinkedHashSet<>();
        for(CreativeScreenEvents.TagFilter filter : this.filters)
        {
            if(filter.isEnabled())
            {
                categorisedItems.addAll(filter.getItems());
            }
        }

        NonNullList<ItemStack> newItems = NonNullList.create();
        for(Item item : categorisedItems)
        {
            newItems.add(new ItemStack(item));
        }

        menu.items.clear();
        menu.items.addAll(newItems);
        menu.items.sort(Comparator.comparingInt(o -> Item.getId(o.getItem())));
        menu.scrollTo(0);
    }

    private void compileItems()
    {
        List<CreativeScreenEvents.TagFilter> tempFilters = Arrays.asList(
                new TagFilter(ModItemTags.GENERAL, new ItemStack(ModBlocks.WHITE_MODERN_CHAIR.get())),
                new TagFilter(ModItemTags.STORAGE, new ItemStack(ModBlocks.WHITE_MODERN_CABINET.get())),
                new TagFilter(ModItemTags.BEDROOM, new ItemStack(ModBlocks.WHITE_MODERN_DESK.get())),
                new TagFilter(ModItemTags.OUTDOORS, new ItemStack(ModBlocks.WHITE_INFLATABLE_CASTLE.get())),
                new TagFilter(ModItemTags.KITCHEN, new ItemStack(ModBlocks.WHITE_MODERN_KITCHEN_COUNTER.get())),
                new TagFilter(ModItemTags.BATHROOM, new ItemStack(ModBlocks.TOILET_LIGHT.get())),
                new TagFilter(ModItemTags.ELECTRONICS, new ItemStack(ModBlocks.OAK_DOOR_BELL.get())),
                new TagFilter(ModItemTags.FESTIVE, new ItemStack(ModBlocks.WREATH.get())),
                new TagFilter(ModItemTags.LIGHTING, new ItemStack(ModBlocks.WHITE_LAMP.get())),
                new TagFilter(ModItemTags.ITEMS, new ItemStack(ModItems.KNIFE.get()))
        );

        BuiltInRegistries.ITEM.holders().forEach(holder -> {
            if (holder.key().location().getNamespace().equals("nfm")) {
                Item item = holder.value();
                for (CreativeScreenEvents.TagFilter filter : tempFilters) {
                    if (holder.is(filter.getTag())) {
                        filter.add(item);
                    }
                }
            }
        });

        this.filters = new ArrayList<>(tempFilters);
    }

    /**
     * Author: MrCrayfish
     */
    public static class TagFilter
    {
        private final List<Item> items = Lists.newArrayList();
        private final TagKey<Item> tag;
        private final Component name;
        private final ItemStack icon;
        private boolean enabled = true;

        public TagFilter(TagKey<Item> tag, ItemStack icon)
        {
            this.tag = tag;
            this.name = Component.translatable(String.format("gui.tag_filter.%s.%s", tag.location().getNamespace(), tag.location().getPath().replace("/", ".")));
            this.icon = icon;
        }

        public TagKey<Item> getTag()
        {
            return tag;
        }

        public ItemStack getIcon()
        {
            return this.icon;
        }

        public Component getName()
        {
            return this.name;
        }

        public void setEnabled(boolean enabled)
        {
            this.enabled = enabled;
        }

        public boolean isEnabled()
        {
            return this.enabled;
        }

        public void add(Item item)
        {
            this.items.add(item);
        }

        public void add(Block block)
        {
            this.items.add(Item.byBlock(block));
        }

        public List<Item> getItems()
        {
            return this.items;
        }
    }
}