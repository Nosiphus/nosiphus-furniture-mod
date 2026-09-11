package com.nosiphus.furniture.world.level.block.entity;

import com.nosiphus.furniture.world.item.crafting.ModRecipeTypes;
import com.nosiphus.furniture.world.item.crafting.ToastingRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static com.mrcrayfish.furniture.world.level.block.FurnitureHorizontalBlock.DIRECTION;

public class ToasterBlockEntity extends BlockEntity implements WorldlyContainer {

    public static final int[] ALL_SLOTS = new int[]{0, 1};
    public static final int[] TOAST_SLOTS = new int[]{0, 1};

    private final NonNullList<ItemStack> toaster = NonNullList.withSize(2, ItemStack.EMPTY);
    private final int[] cookingTimes = new int[2];
    private final int[] cookingTotalTimes = new int[2];
    private final float[] experience = new float[2];

    public ToasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.TOASTER.get(), pos, state);
    }

    public void markUpdated() {
        this.setChanged();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
        }
    }

    public int getDirection(BlockState state) {
        if(state.getValue(DIRECTION) == Direction.NORTH) {
            return 0;
        } else if (state.getValue(DIRECTION) == Direction.EAST) {
            return 1;
        } else if (state.getValue(DIRECTION) == Direction.SOUTH) {
            return 2;
        } else if (state.getValue(DIRECTION) == Direction.WEST) {
            return 3;
        }
        return 0;
    }

    public NonNullList<ItemStack> getToaster() {
        return this.toaster;
    }

    public boolean addItem(ItemStack stack, int position, int cookTime, float experience) {
        if (this.toaster.get(position).isEmpty()) {
            ItemStack single = stack.copy();
            single.setCount(1);
            this.toaster.set(position, single);
            this.resetPosition(position, cookTime, experience);
            this.markUpdated();
            return true;
        }
        return false;
    }

    private void resetPosition(int position, int cookTime, float experience) {
        this.cookingTimes[position] = 0;
        this.cookingTotalTimes[position] = cookTime / 2;
        this.experience[position] = experience;
    }

    public void removeItem(int position) {
        if (!this.toaster.get(position).isEmpty()) {
            if (this.level != null && !this.level.isClientSide) {
                double posX = worldPosition.getX() + 0.5;
                double posY = worldPosition.getY() + 0.5;
                double posZ = worldPosition.getZ() + 0.5;

                ItemEntity entity = new ItemEntity(this.level, posX, posY, posZ, this.toaster.get(position).copy());
                this.level.addFreshEntity(entity);

                if (this.cookingTimes[position] >= this.cookingTotalTimes[position]) {
                    Vec3 center = Vec3.atCenterOf(this.worldPosition);
                    ExperienceOrb.award((ServerLevel) this.level, center, (int) this.experience[position]);
                }
            }
            this.toaster.set(position, ItemStack.EMPTY);
            this.markUpdated();
        }
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ToasterBlockEntity be) {
        boolean itemsChanged = false;
        for (int i = 0; i < be.toaster.size(); i++) {
            ItemStack stack = be.toaster.get(i);
            if (!stack.isEmpty() && be.cookingTimes[i] < be.cookingTotalTimes[i]) {
                be.cookingTimes[i]++;
                if (be.cookingTimes[i] == be.cookingTotalTimes[i]) {
                    SimpleContainer container = new SimpleContainer(stack);
                    Optional<ToastingRecipe> recipe = level.getRecipeManager()
                            .getRecipeFor(ModRecipeTypes.TOASTING.get(), container, level);

                    if (recipe.isPresent()) {
                        be.toaster.set(i, recipe.get().getResultItem(level.registryAccess()).copy());
                        level.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.NOTE_BLOCK_CHIME.value(), SoundSource.BLOCKS, 0.5F, 2.0F);
                    }
                    itemsChanged = true;
                }
            }
        }
        if (itemsChanged) {
            be.markUpdated();
        }
    }

    @Override
    public int getContainerSize() { return 2; }

    @Override
    public boolean isEmpty() {
        return this.toaster.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getItem(int index) { return this.toaster.get(index); }

    @Override
    public ItemStack removeItem(int index, int count) {
        ItemStack result = ContainerHelper.removeItem(this.toaster, index, count);
        if (!result.isEmpty()) this.markUpdated();
        return result;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(this.toaster, index);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        this.toaster.set(index, stack);
        if (!stack.isEmpty() && this.level != null) {
            SimpleContainer container = new SimpleContainer(stack);
            this.level.getRecipeManager().getRecipeFor(ModRecipeTypes.TOASTING.get(), container, this.level)
                    .ifPresent(recipe -> this.resetPosition(index, recipe.getCookingTime(), recipe.getExperience()));
        }
        this.markUpdated();
    }

    @Override
    public int getMaxStackSize() { return 1; }

    @Override
    public boolean stillValid(Player player) {
        return Container.stillValidBlockEntity(this, player);
    }

    @Override
    public void clearContent() { this.toaster.clear(); this.markUpdated(); }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.toaster.clear();
        ContainerHelper.loadAllItems(tag, this.toaster);

        if (tag.contains("CookingTimes", Tag.TAG_INT_ARRAY)) {
            int[] times = tag.getIntArray("CookingTimes");
            System.arraycopy(times, 0, this.cookingTimes, 0, Math.min(this.cookingTimes.length, times.length));
        }
        if (tag.contains("CookingTotalTimes", Tag.TAG_INT_ARRAY)) {
            int[] totals = tag.getIntArray("CookingTotalTimes");
            System.arraycopy(totals, 0, this.cookingTotalTimes, 0, Math.min(this.cookingTotalTimes.length, totals.length));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.toaster);
        tag.putIntArray("CookingTimes", this.cookingTimes);
        tag.putIntArray("CookingTotalTimes", this.cookingTotalTimes);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag);
        return tag;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return side == Direction.DOWN ? TOAST_SLOTS : ALL_SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction dir) {
        return this.getItem(index).isEmpty() && this.level != null && this.level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.TOASTING.get(), new SimpleContainer(stack), this.level).isPresent();
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction dir) {
        return dir == Direction.DOWN && this.cookingTimes[index] >= this.cookingTotalTimes[index];
    }
}