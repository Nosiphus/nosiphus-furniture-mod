package com.mrcrayfish.furniture.world.level.block.entity;

import com.google.common.collect.Maps;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.inventory.FreezerMenu;
import com.mrcrayfish.furniture.world.item.crafting.FreezerSolidifyRecipe;
import com.mrcrayfish.furniture.world.item.crafting.ModRecipeTypes;
import com.mrcrayfish.furniture.world.level.block.FreezerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: MrCrayfish
 */
public class FreezerBlockEntity extends BasicLootBlockEntity
{
    private static final int[] SLOTS_SOURCE = new int[]{0};
    private static final int[] SLOTS_FUEL = new int[]{1};
    private static final int[] SLOTS_RESULT = new int[]{2};

    private int fuelTime;
    private int fuelTimeTotal;
    private int freezeTime;
    private int freezeTimeTotal;

    private final Map<ResourceLocation, Integer> recipesUsed = new HashMap<>();

    protected final ContainerData freezerData = new ContainerData()
    {
        @Override
        public int get(int index)
        {
            return switch (index) {
                case 0 -> fuelTime;
                case 1 -> fuelTimeTotal;
                case 2 -> freezeTime;
                case 3 -> freezeTimeTotal;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value)
        {
            switch (index) {
                case 0 -> fuelTime = value;
                case 1 -> fuelTimeTotal = value;
                case 2 -> freezeTime = value;
                case 3 -> freezeTimeTotal = value;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    };

    private final Map<ResourceLocation, Integer> usedRecipeCount = Maps.newHashMap();

    public FreezerBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntityTypes.FREEZER.get(), pos, state);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, FreezerBlockEntity freezer)
    {
        boolean wasFreezing = freezer.isFreezing();
        boolean dirty = false;

        if (freezer.isFreezing())
        {
            freezer.fuelTime--;
        }

        ItemStack input = freezer.items.get(0);
        ItemStack fuel = freezer.items.get(1);
        boolean hasInput = !input.isEmpty();
        boolean hasFuel = !fuel.isEmpty();

        if (freezer.isFreezing() || (hasFuel && hasInput))
        {
            SingleRecipeInput recipeInput = new SingleRecipeInput(input);
            RecipeHolder<FreezerSolidifyRecipe> recipe = level.getRecipeManager()
                    .getRecipeFor(ModRecipeTypes.FREEZER_SOLIDIFY.get(), recipeInput, level)
                    .orElse(null);

            int maxStack = freezer.getMaxStackSize();
            if (!freezer.isFreezing() && freezer.canFreeze(level.registryAccess(), recipe, maxStack))
            {
                freezer.fuelTime = freezer.getFreezeTime(fuel);
                freezer.fuelTimeTotal = freezer.fuelTime;
                if (freezer.isFreezing())
                {
                    dirty = true;
                    ItemStack remainder = Services.PLATFORM.getCraftingRemainingItem(fuel);
                    if (!remainder.isEmpty())
                    {
                        freezer.items.set(1, remainder);
                    }
                    else
                    {
                        fuel.shrink(1);
                    }
                }
            }

            if (freezer.isFreezing() && freezer.canFreeze(level.registryAccess(), recipe, maxStack))
            {
                freezer.freezeTime++;
                if (freezer.freezeTime >= freezer.freezeTimeTotal)
                {
                    freezer.freezeTime = 0;
                    freezer.freezeTimeTotal = freezer.getTotalFreezeTime(level, recipeInput);
                    freezer.freeze(level.registryAccess(), recipe);
                    dirty = true;
                }
            }
            else
            {
                freezer.freezeTime = 0;
            }
        }
        else if (!freezer.isFreezing() && freezer.freezeTime > 0)
        {
            freezer.freezeTime = Mth.clamp(freezer.freezeTime - 2, 0, freezer.freezeTimeTotal);
        }

        if (wasFreezing != freezer.isFreezing())
        {
            dirty = true;
        }

        if (dirty)
        {
            freezer.markUpdated();
        }
    }

    private boolean isFreezing()
    {
        return this.fuelTime > 0;
    }

    public int getFreezeTime(ItemStack stack)
    {
        if (stack.isEmpty()) return 0;
        int defaultFuelTime = 0;
        if (stack.is(Items.ICE)) defaultFuelTime = 2000;
        else if (stack.is(Items.PACKED_ICE)) defaultFuelTime = 18000;
        else if (stack.is(Items.BLUE_ICE)) defaultFuelTime = 162000;

        return Services.PLATFORM.getFreezerFuelTime(stack, defaultFuelTime);
    }

    private boolean canFreeze(HolderLookup.Provider registries, @Nullable RecipeHolder<FreezerSolidifyRecipe> recipe, int maxStack)
    {
        if (this.items.get(0).isEmpty() || recipe == null) return false;

        ItemStack result = recipe.value().getResultItem(registries);
        if (result.isEmpty()) return false;

        ItemStack currentOutput = this.items.get(2);
        if (currentOutput.isEmpty()) return true;
        if (!ItemStack.isSameItem(currentOutput, result)) return false;

        return currentOutput.getCount() + result.getCount() <= Math.min(maxStack, result.getMaxStackSize());
    }

    private void freeze(HolderLookup.Provider registries, @Nullable RecipeHolder<FreezerSolidifyRecipe> recipe)
    {
        if (recipe != null && this.canFreeze(registries, recipe, this.getMaxStackSize()))
        {
            ItemStack input = this.items.get(0);
            ItemStack result = recipe.value().getResultItem(registries);
            ItemStack outputSlot = this.items.get(2);

            if (outputSlot.isEmpty())
            {
                this.items.set(2, result.copy());
            }
            else
            {
                outputSlot.grow(result.getCount());
            }

            if (this.level != null && !this.level.isClientSide)
            {
                this.recipesUsed.compute(recipe.id(), (id, count) -> (count == null ? 0 : count) + 1);
            }

            ItemStack remainder = Services.PLATFORM.getCraftingRemainingItem(input);
            if (!remainder.isEmpty())
            {
                this.items.set(0, remainder);
            }
            else
            {
                input.shrink(1);
            }
        }
    }

    @Override
    public int getContainerSize()
    {
        return 3;
    }

    private int getTotalFreezeTime(Level level, SingleRecipeInput input)
    {
        return level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.FREEZER_SOLIDIFY.get(), input, level)
                .map(holder -> holder.value().getCookingTime())
                .orElse(300);
    }

    @Override
    public void setItem(int index, ItemStack stack)
    {
        super.setItem(index, stack);
        if (index == 0)
        {
            if (this.level != null)
            {
                SingleRecipeInput input = new SingleRecipeInput(stack);
                this.freezeTimeTotal = this.getTotalFreezeTime(this.level, input);
            }
            this.freezeTime = 0;
            this.markUpdated();
        }
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("container.cfm.freezer");
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory)
    {
        return new FreezerMenu(windowId, playerInventory, this);
    }

    @Override
    public boolean isMatchingContainerMenu(AbstractContainerMenu menu)
    {
        return menu instanceof FreezerMenu freezerMenu && freezerMenu.getBlockEntity() == this;
    }

    @Override
    public int[] getSlotsForFace(Direction direction)
    {
        switch(direction)
        {
            case UP:
                return SLOTS_SOURCE;
            case DOWN:
                return SLOTS_RESULT;
            default:
                return SLOTS_FUEL;
        }
    }

    private void addRecipeUsed(@Nullable RecipeHolder<?> recipeHolder)
    {
        if (recipeHolder != null)
        {
            this.recipesUsed.compute(recipeHolder.id(), (id, count) -> (count == null ? 0 : count) + 1);
            this.markUpdated();
        }
    }

    public void spawnExperience(Player player)
    {
        if (this.level == null) return;
        for (Map.Entry<ResourceLocation, Integer> entry : this.recipesUsed.entrySet())
        {
            this.level.getRecipeManager().byKey(entry.getKey()).ifPresent(recipe -> {
                if (recipe.value() instanceof FreezerSolidifyRecipe solidifyRecipe) {
                    this.createExperienceOrbs(player, entry.getValue(), solidifyRecipe.getExperience());
                }
            });
        }
        this.recipesUsed.clear();
    }

    private void createExperienceOrbs(Player player, int count, float experience)
    {
        int totalExp = Mth.floor(count * experience);
        float fraction = Mth.frac(count * experience);
        if (fraction != 0.0F && Math.random() < fraction) {
            totalExp++;
        }
        ExperienceOrb.award((net.minecraft.server.level.ServerLevel) player.level(), player.position(), totalExp);
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction)
    {
        return this.canPlaceItem(index, stack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction)
    {
        return index == 2;
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack)
    {
        if(index == 2)
        {
            return false;
        }
        else if(index != 1)
        {
            return true;
        }
        return this.getFreezeTime(stack) > 0;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.loadAdditional(tag, registries);
        this.freezeTime = tag.getInt("FreezeTime");
        this.freezeTimeTotal = tag.getInt("FreezeTimeTotal");
        this.fuelTime = tag.getInt("FuelTime");
        this.fuelTimeTotal = this.getFreezeTime(this.items.get(1));

        if (tag.contains("RecipesUsed", Tag.TAG_LIST))
        {
            ListTag list = tag.getList("RecipesUsed", Tag.TAG_COMPOUND);
            for (int i = 0; i < list.size(); i++) {
                CompoundTag entry = list.getCompound(i);
                this.recipesUsed.put(ResourceLocation.parse(entry.getString("Id")), entry.getInt("Count"));
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries)
    {
        super.saveAdditional(tag, registries);
        tag.putInt("FreezeTime", this.freezeTime);
        tag.putInt("FreezeTimeTotal", this.freezeTimeTotal);
        tag.putInt("FuelTime", this.fuelTime);

        ListTag list = new ListTag();
        this.recipesUsed.forEach((id, count) -> {
            CompoundTag entry = new CompoundTag();
            entry.putString("Id", id.toString());
            entry.putInt("Count", count);
            list.add(entry);
        });
        tag.put("RecipesUsed", list);
    }

    public ContainerData getFreezerData()
    {
        return this.freezerData;
    }

    @Override
    public void onOpen(Level level, BlockPos pos, BlockState state)
    {
        this.playDoorSound(state, ModSoundEvents.BLOCK_FRIDGE_OPEN.get());
        this.setDoorState(state, true);
    }

    @Override
    public void onClose(Level level, BlockPos pos, BlockState state)
    {
        this.playDoorSound(state, ModSoundEvents.BLOCK_FRIDGE_CLOSE.get());
        this.setDoorState(state, false);
    }

    private void playDoorSound(BlockState state, SoundEvent event)
    {
        Direction dir = state.getValue(FreezerBlock.DIRECTION).getOpposite();
        double x = this.worldPosition.getX() + 0.5D + dir.getStepX() * 0.5D;
        double y = this.worldPosition.getY() + 0.5D;
        double z = this.worldPosition.getZ() + 0.5D + dir.getStepZ() * 0.5D;
        if (this.level != null)
        {
            this.level.playSound(null, x, y, z, event, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
    }

    private void setDoorState(BlockState state, boolean open)
    {
        if (this.level != null) {
            this.level.setBlock(this.worldPosition, state.setValue(FreezerBlock.OPEN, open), 3);
        }
    }

    public void markUpdated()
    {
        this.setChanged();
        if (this.level != null)
        {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }
}