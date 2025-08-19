package com.nosiphus.furniture.blockentity;

import com.mrcrayfish.furniture.util.BlockEntityUtil;
import com.mrcrayfish.furniture.util.ItemStackHelper;
import com.nosiphus.furniture.core.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class CookieJarBlockEntity extends BlockEntity implements WorldlyContainer {

    public static final int[] ALL_SLOTS = new int[]{0, 1, 2, 3, 4, 5};
    public static final int[] JAR_SLOTS = new int[]{0, 1, 2, 3, 4, 5};

    private final NonNullList<ItemStack> cookieJar = NonNullList.withSize(6, ItemStack.EMPTY);

    protected CookieJarBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public CookieJarBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COOKIE_JAR.get(), pos, state);
    }

    public NonNullList<ItemStack> getCookieJar() {
        return this.cookieJar;
    }

    public boolean addItem(ItemStack stack) {
        if(this.cookieJar.get(0).isEmpty()) {
            ItemStack copy = stack.copy();
            copy.setCount(1);
            this.cookieJar.set(0, copy);
            CompoundTag compoundTag = new CompoundTag();
            this.writeItems(compoundTag);
            BlockEntityUtil.sendUpdatePacket(this, compoundTag);
            return true;
        }
        return false;
    }

    public void removeItem() {
        if(!this.cookieJar.get(0).isEmpty()) {
            double posX = worldPosition.getX() + 0.5;
            double posY = worldPosition.getY() + 0.2;
            double posZ = worldPosition.getZ() + 0.5;

            ItemEntity entity = new ItemEntity(this.level, posX, posY, posZ, this.cookieJar.get(0).copy());
            this.level.addFreshEntity(entity);

            this.cookieJar.set(0, ItemStack.EMPTY);

            CompoundTag compoundTag = new CompoundTag();
            this.writeItems(compoundTag);
            BlockEntityUtil.sendUpdatePacket(this, compoundTag);
        }
    }

    @Override
    public int getContainerSize() {
        return this.cookieJar.size();
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack stack : this.cookieJar) {
            if(!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int index) {
        return this.cookieJar.get(index);
    }

    @Override
    public ItemStack removeItem(int index, int count) {
        ItemStack result = ContainerHelper.removeItem(this.cookieJar, index, count);

        if(this.cookieJar.get(index).isEmpty()) {
            double posX = worldPosition.getX() + 0.5;
            double posY = worldPosition.getY() + 0.2;
            double posZ = worldPosition.getZ() + 0.5;
        }

        CompoundTag compoundTag = new CompoundTag();
        this.writeItems(compoundTag);
        BlockEntityUtil.sendUpdatePacket(this, compoundTag);

        return result;
    }

    @Override
    public ItemStack removeItemNoUpdate(int index)
    {
        return ContainerHelper.takeItem(this.cookieJar, index);
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        NonNullList<ItemStack> inventory = this.cookieJar;
        inventory.set(index, stack);
        if(stack.getCount() > this.getMaxStackSize()) {
            stack.setCount(this.getMaxStackSize());
        }

        CompoundTag compoundTag = new CompoundTag();
        this.writeItems(compoundTag);
        BlockEntityUtil.sendUpdatePacket(this, compoundTag);
    }

    @Override
    public int getMaxStackSize()
    {
        return 1;
    }

    @Override
    public void clearContent()
    {
        this.cookieJar.clear();
    }

    @Override
    public void load(CompoundTag compound)
    {
        super.load(compound);
        if(compound.contains("CookieJar", Tag.TAG_LIST))
        {
            this.cookieJar.clear();
            ItemStackHelper.loadAllItems("CookieJar", compound, this.cookieJar);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag)
    {
        super.saveAdditional(tag);
        this.writeItems(tag);
    }

    private CompoundTag writeItems(CompoundTag compound)
    {
        ItemStackHelper.saveAllItems("CookieJar", compound, this.cookieJar, true);
        return compound;
    }

    @Override
    public CompoundTag getUpdateTag()
    {
        return this.saveWithFullMetadata();
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket()
    {
        return ClientboundBlockEntityDataPacket.create(this, BlockEntity::getUpdateTag);
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt)
    {
        CompoundTag compound = pkt.getTag();
        this.load(compound);
    }

    @Override
    public boolean stillValid(Player player)
    {
        return this.level.getBlockEntity(this.worldPosition) == this && player.distanceToSqr(this.worldPosition.getX() + 0.5, this.worldPosition.getY() + 0.5, this.worldPosition.getZ() + 0.5) <= 64;
    }

    @Override
    public int[] getSlotsForFace(Direction side)
    {
        return side == Direction.DOWN ? JAR_SLOTS : ALL_SLOTS;
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction)
    {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction)
    {
        return true;
    }



    }
