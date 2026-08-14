package com.mrcrayfish.furniture.world.level.block.entity;

import com.mrcrayfish.furniture.network.protocol.common.ClientboundFlipGrill;
import com.mrcrayfish.furniture.platform.Services;
import com.mrcrayfish.furniture.sounds.ModSoundEvents;
import com.mrcrayfish.furniture.world.item.crafting.GrillCookingRecipe;
import com.mrcrayfish.furniture.world.item.crafting.ModRecipeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Author: MrCrayfish
 */
public class GrillBlockEntity extends BlockEntity implements WorldlyContainer
{
    public static final int MAX_FLIPPING_COUNTER = 15;
    private static final int[] ALL_SLOTS = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private static final int[] GRILL_SLOTS = new int[]{9, 10, 11, 12};

    private final NonNullList<ItemStack> fuel = NonNullList.withSize(9, ItemStack.EMPTY);
    private final NonNullList<ItemStack> grill = NonNullList.withSize(4, ItemStack.EMPTY);
    private final int[] cookingTimes = new int[4];
    private final int[] cookingTotalTimes = new int[4];
    private final boolean[] flipped = new boolean[4];
    private final float[] experience = new float[4];
    private final byte[] rotations = new byte[4];
    private int remainingFuel = 0;

    private final boolean[] flipping = new boolean[4];
    private final int[] flippingCounter = new int[4];

    public GrillBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntityTypes.GRILL.get(), pos, state);
    }

    public void setFlipping(int position)
    {
        this.flipping[position] = true;
        this.flippingCounter[position] = 0;
    }

    public boolean addItem(ItemStack stack, int position, int cookTime, float experience, byte rotation)
    {
        if(this.grill.get(position).isEmpty())
        {
            ItemStack copy = stack.copy();
            copy.setCount(1);
            this.grill.set(position, copy);

            this.cookingTimes[position] = 0;
            this.cookingTotalTimes[position] = cookTime / 2;
            this.flipped[position] = false;
            this.experience[position] = experience;
            this.rotations[position] = rotation;

            this.markUpdated();
            if(this.level != null)
            {
                this.level.playSound(null, this.worldPosition, ModSoundEvents.BLOCK_GRILL_PLACE.get(), SoundSource.BLOCKS, 0.75F, level.random.nextFloat() * 0.2F + 0.9F);
            }
            return true;
        }
        return false;
    }

    public boolean addFuel(ItemStack stack)
    {
        for(int i = 0; i < this.fuel.size(); i++)
        {
            if(this.fuel.get(i).isEmpty())
            {
                ItemStack copy = stack.copy();
                copy.setCount(1);
                this.fuel.set(i, copy);
                this.markUpdated();
                return true;
            }
        }
        return false;
    }

    public void flipItem(int position)
    {
        if(this.level != null && !this.grill.get(position).isEmpty())
        {
            if(!this.flipped[position] && this.cookingTimes[position] == this.cookingTotalTimes[position])
            {
                this.flipped[position] = true;
                this.cookingTimes[position] = 0;

                this.markUpdated();

                if(this.level instanceof ServerLevel serverLevel)
                {
                    Services.PLATFORM.sendToTrackingChunk(serverLevel, this.worldPosition, new ClientboundFlipGrill(this.worldPosition, position));
                }

                this.level.playSound(null, this.worldPosition, ModSoundEvents.BLOCK_GRILL_FLIP.get(), SoundSource.BLOCKS, 0.75F, 1.0F);
            }
            else if(this.flipped[position] && this.cookingTimes[position] == this.cookingTotalTimes[position])
            {
                this.removeItem(position);
            }
        }
    }

    public void removeItem(int position)
    {
        if(this.level != null && !this.grill.get(position).isEmpty())
        {
            BlockPos p = this.worldPosition;
            double posX = p.getX() + 0.3 + 0.4 * (position % 2);
            double posY = p.getY() + 1.0;
            double posZ = p.getZ() + 0.3 + 0.4 * (position / 2);

            this.level.addFreshEntity(new ItemEntity(this.level, posX, posY + 0.1, posZ, this.grill.get(position).copy()));
            this.grill.set(position, ItemStack.EMPTY);

            if(this.flipped[position] && this.cookingTimes[position] == this.cookingTotalTimes[position])
            {
                int amount = (int) experience[position];
                while(amount > 0)
                {
                    int split = ExperienceOrb.getExperienceValue(amount);
                    amount -= split;
                    this.level.addFreshEntity(new ExperienceOrb(this.level, posX, posY, posZ, split));
                }
            }

            this.markUpdated();
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, GrillBlockEntity blockEntity)
    {
        boolean canCook = blockEntity.canCook();
        boolean changed = false;

        if(blockEntity.remainingFuel == 0 && canCook)
        {
            for(int i = blockEntity.fuel.size() - 1; i >= 0; i--)
            {
                ItemStack stack = blockEntity.fuel.get(i);
                if(!stack.isEmpty())
                {
                    blockEntity.remainingFuel = Services.PLATFORM.getBurnTime(stack, RecipeType.SMELTING);
                    blockEntity.fuel.set(i, ItemStack.EMPTY);
                    changed = true;
                    break;
                }
            }
        }

        if(canCook && blockEntity.remainingFuel > 0)
        {
            if(blockEntity.cookItems()) changed = true;
            blockEntity.remainingFuel--;

            if(level.getGameTime() % 100 == 0) blockEntity.setChanged();

            if(blockEntity.remainingFuel == 0) changed = true;
        }

        if(changed)
        {
            blockEntity.markUpdated();
        }
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, GrillBlockEntity blockEntity)
    {
        blockEntity.spawnParticles();
        for(int i = 0; i < 4; i++)
        {
            if(blockEntity.flipping[i] && blockEntity.flippingCounter[i] < MAX_FLIPPING_COUNTER)
            {
                blockEntity.flippingCounter[i]++;
                if(blockEntity.flippingCounter[i] == MAX_FLIPPING_COUNTER) blockEntity.flipping[i] = false;
            }
        }
    }

    private boolean cookItems()
    {
        if(this.level == null) return false;
        boolean changed = false;
        for(int i = 0; i < 4; i++)
        {
            ItemStack stack = this.grill.get(i);
            if(!stack.isEmpty() && this.cookingTimes[i] < this.cookingTotalTimes[i])
            {
                this.cookingTimes[i]++;
                if(this.cookingTimes[i] == this.cookingTotalTimes[i])
                {
                    changed = true;
                    if(this.flipped[i])
                    {
                        Optional<RecipeHolder<GrillCookingRecipe>> recipe = this.level.getRecipeManager()
                                .getRecipeFor(ModRecipeTypes.GRILL_COOKING.get(), new SingleRecipeInput(stack), this.level);

                        if(recipe.isPresent())
                        {
                            this.grill.set(i, recipe.get().value().getResultItem(this.level.registryAccess()).copy());
                        }
                    }
                }
            }
        }
        return changed;
    }

    @Override
    protected void loadAdditional(CompoundTag compound, HolderLookup.Provider registries)
    {
        super.loadAdditional(compound, registries);

        for (int i = 0; i < this.grill.size(); i++) {
            this.grill.set(i, ItemStack.EMPTY);
        }
        for (int i = 0; i < this.fuel.size(); i++) {
            this.fuel.set(i, ItemStack.EMPTY);
        }

        if(compound.contains("Grill", Tag.TAG_COMPOUND))
            ContainerHelper.loadAllItems(compound.getCompound("Grill"), this.grill, registries);

        if(compound.contains("Fuel", Tag.TAG_COMPOUND))
            ContainerHelper.loadAllItems(compound.getCompound("Fuel"), this.fuel, registries);

        this.remainingFuel = compound.getInt("RemainingFuel");

        if(compound.contains("CookingTimes", Tag.TAG_INT_ARRAY))
            System.arraycopy(compound.getIntArray("CookingTimes"), 0, this.cookingTimes, 0, Math.min(4, compound.getIntArray("CookingTimes").length));

        if(compound.contains("CookingTotalTimes", Tag.TAG_INT_ARRAY))
            System.arraycopy(compound.getIntArray("CookingTotalTimes"), 0, this.cookingTotalTimes, 0, Math.min(4, compound.getIntArray("CookingTotalTimes").length));

        if(compound.contains("Flipped", Tag.TAG_BYTE_ARRAY)) {
            byte[] flippedBytes = compound.getByteArray("Flipped");
            for(int i = 0; i < Math.min(4, flippedBytes.length); i++) this.flipped[i] = flippedBytes[i] == 1;
        }

        if(compound.contains("Experience", Tag.TAG_INT_ARRAY)) {
            int[] expInts = compound.getIntArray("Experience");
            for(int i = 0; i < Math.min(4, expInts.length); i++) this.experience[i] = Float.intBitsToFloat(expInts[i]);
        }

        if(compound.contains("Rotations", Tag.TAG_BYTE_ARRAY))
            System.arraycopy(compound.getByteArray("Rotations"), 0, this.rotations, 0, Math.min(4, compound.getByteArray("Rotations").length));
    }

    @Override
    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider registries)
    {
        super.saveAdditional(compound, registries);

        compound.put("Grill", ContainerHelper.saveAllItems(new CompoundTag(), this.grill, registries));
        compound.put("Fuel", ContainerHelper.saveAllItems(new CompoundTag(), this.fuel, registries));

        compound.putInt("RemainingFuel", this.remainingFuel);
        compound.putIntArray("CookingTimes", this.cookingTimes);
        compound.putIntArray("CookingTotalTimes", this.cookingTotalTimes);

        byte[] flippedBytes = new byte[4];
        for(int i = 0; i < 4; i++) flippedBytes[i] = (byte) (this.flipped[i] ? 1 : 0);
        compound.putByteArray("Flipped", flippedBytes);

        int[] expInts = new int[4];
        for(int i = 0; i < 4; i++) expInts[i] = Float.floatToIntBits(this.experience[i]);
        compound.putIntArray("Experience", expInts);

        compound.putByteArray("Rotations", this.rotations);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries)
    {
        CompoundTag tag = super.getUpdateTag(registries);
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    private void markUpdated()
    {
        this.setChanged();
        if(this.level != null)
        {
            this.level.sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 3);
        }
    }

    private boolean canCook()
    {
        for(int i = 0; i < 4; i++)
        {
            if(!this.grill.get(i).isEmpty() && this.cookingTimes[i] != this.cookingTotalTimes[i]) return true;
        }
        return false;
    }

    private void spawnParticles()
    {
        if(this.level != null && this.isCooking() && this.remainingFuel > 0)
        {
            double posX = worldPosition.getX() + 0.2 + 0.6 * level.random.nextDouble();
            double posY = worldPosition.getY() + 0.85;
            double posZ = worldPosition.getZ() + 0.2 + 0.6 * level.random.nextDouble();
            level.addParticle(ParticleTypes.FLAME, posX, posY, posZ, 0.0, 0.0, 0.0);
        }
    }

    private boolean isCooking()
    {
        for(int i = 0; i < 4; i++)
        {
            if(!this.grill.get(i).isEmpty() && (this.cookingTimes[i] != this.cookingTotalTimes[i] || !this.flipped[i])) return true;
        }
        return false;
    }

    public Optional<GrillCookingRecipe> findMatchingRecipe(ItemStack stack)
    {
        if(this.level == null || stack.isEmpty()) return Optional.empty();
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipeTypes.GRILL_COOKING.get(), new SingleRecipeInput(stack), this.level)
                .map(RecipeHolder::value);
    }

    @Override public int getContainerSize() { return 13; }
    @Override public boolean isEmpty() { return fuel.stream().allMatch(ItemStack::isEmpty) && grill.stream().allMatch(ItemStack::isEmpty); }
    @Override public ItemStack getItem(int i) { return i < 9 ? fuel.get(i) : grill.get(i - 9); }

    @Override
    public ItemStack removeItem(int i, int count)
    {
        ItemStack res = ContainerHelper.removeItem(i < 9 ? fuel : grill, i < 9 ? i : i - 9, count);
        this.markUpdated();
        return res;
    }

    @Override
    public ItemStack removeItemNoUpdate(int i)
    {
        return ContainerHelper.takeItem(i < 9 ? fuel : grill, i < 9 ? i : i - 9);
    }

    @Override
    public void setItem(int i, ItemStack stack)
    {
        if(i < 9) fuel.set(i, stack); else grill.set(i - 9, stack);
        this.markUpdated();
    }

    @Override public boolean stillValid(Player player) { return Container.stillValidBlockEntity(this, player); }
    @Override public void clearContent() { fuel.clear(); grill.clear(); this.markUpdated(); }
    @Override public int[] getSlotsForFace(Direction side) { return side == Direction.DOWN ? GRILL_SLOTS : ALL_SLOTS; }

    @Override
    public boolean canPlaceItemThroughFace(int i, ItemStack stack, @Nullable Direction direction)
    {
        if(i < 9) return Services.PLATFORM.getBurnTime(stack, RecipeType.SMELTING) > 0;
        return this.level != null && this.level.getRecipeManager().getRecipeFor(ModRecipeTypes.GRILL_COOKING.get(), new SingleRecipeInput(stack), this.level).isPresent();
    }

    @Override
    public boolean canTakeItemThroughFace(int i, ItemStack stack, Direction direction)
    {
        if(direction == Direction.DOWN && i >= 9)
        {
            int idx = i - 9;
            return this.flipped[idx] && this.cookingTimes[idx] == this.cookingTotalTimes[idx];
        }
        return false;
    }

    public NonNullList<ItemStack> getGrill() { return this.grill; }
    public NonNullList<ItemStack> getFuel() { return this.fuel; }
    public byte[] getRotations() { return this.rotations; }
    public boolean isFlipped(int i) { return this.flipped[i]; }
    public boolean isFlipping(int i) { return this.flipping[i]; }
    public int getFlippingCount(int i) { return this.flippingCounter[i]; }
}