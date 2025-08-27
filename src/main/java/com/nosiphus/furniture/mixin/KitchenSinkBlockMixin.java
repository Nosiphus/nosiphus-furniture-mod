package com.nosiphus.furniture.mixin;

import com.mrcrayfish.furniture.block.FurnitureHorizontalBlock;
import com.mrcrayfish.furniture.block.KitchenSinkBlock;
import com.mrcrayfish.furniture.tileentity.KitchenSinkBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(KitchenSinkBlock.class)
public class KitchenSinkBlockMixin extends FurnitureHorizontalBlock implements EntityBlock {

    public KitchenSinkBlockMixin(Properties properties) {
        super(properties);
    }

    /**
     * @author windowsxprules1
     * @reason MrCrayFish's original code does not always save the water level to the sink when exiting the world.
     */
    @Overwrite
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player playerEntity, InteractionHand hand, BlockHitResult result)
    {
        if(!level.isClientSide())
        {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            ItemStack heldItem = playerEntity.getItemInHand(hand);
            if(blockEntity instanceof KitchenSinkBlockEntity) {
                if(heldItem.getItem() == Items.GLASS_BOTTLE)
                {
                    IFluidHandler handler = FluidUtil.getFluidHandler(level, pos, null).orElse(null);
                    if(handler.getFluidInTank(0).getAmount() > 0 && !level.isClientSide())
                    {
                        if(!playerEntity.getAbilities().instabuild)
                        {
                            ItemStack waterPotion = PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER);
                            heldItem.shrink(1);
                            if(heldItem.isEmpty())
                            {
                                playerEntity.setItemInHand(hand, waterPotion);
                            }
                            else if(!playerEntity.getInventory().add(waterPotion))
                            {
                                playerEntity.drop(waterPotion, false);
                            }
                            else if(playerEntity instanceof ServerPlayer)
                            {
                                playerEntity.inventoryMenu.sendAllDataToRemote();
                            }
                        }

                        level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                        handler.drain(FluidType.BUCKET_VOLUME, IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.setChanged();
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide());
                }

                if(!heldItem.isEmpty() && heldItem.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent())
                {
                    blockEntity.setChanged();
                    return FluidUtil.interactWithFluidHandler(playerEntity, hand, level, pos, result.getDirection()) ? InteractionResult.SUCCESS : InteractionResult.PASS;
                }

                BlockPos waterPos = pos.below().below();
                if(this.isWaterSource(level, waterPos))
                {
                    IFluidHandler handler = FluidUtil.getFluidHandler(level, pos, null).orElse(null);
                    if(handler.getFluidInTank(0).getAmount() != handler.getTankCapacity(0))
                    {
                        handler.fill(new FluidStack(Fluids.WATER, FluidType.BUCKET_VOLUME), IFluidHandler.FluidAction.EXECUTE);
                        blockEntity.setChanged();
                        level.playSound(null, pos.getX() + 0.5, pos.getY() + 1.0, pos.getZ() + 0.5, SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);

                        Direction direction = state.getValue(DIRECTION);
                        double posX = pos.getX() + 0.5 + direction.getNormal().getX() * 0.1;
                        double posY = pos.getY() + 1.15;
                        double posZ = pos.getZ() + 0.5 + direction.getNormal().getZ() * 0.1;
                        ((ServerLevel) level).sendParticles(ParticleTypes.FALLING_WATER, posX, posY, posZ, 10, 0.01, 0.01, 0.01, 0);

                        int adjacentSources = 0;
                        adjacentSources += this.isWaterSource(level, waterPos.north()) ? 1 : 0;
                        adjacentSources += this.isWaterSource(level, waterPos.east()) ? 1 : 0;
                        adjacentSources += this.isWaterSource(level, waterPos.south()) ? 1 : 0;
                        adjacentSources += this.isWaterSource(level, waterPos.west()) ? 1 : 0;
                        if(adjacentSources < 2) //If it has less then two adjacent water sources, it is not infinite and thus it should be consumed
                        {
                            level.setBlockAndUpdate(waterPos, Blocks.AIR.defaultBlockState());
                            blockEntity.setChanged();
                        }
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }

    private boolean isWaterSource(Level level, BlockPos pos)
    {
        return level.getFluidState(pos).getType() == Fluids.WATER;
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new KitchenSinkBlockEntity(pos, state);
    }
}
