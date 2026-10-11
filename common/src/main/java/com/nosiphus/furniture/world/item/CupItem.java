package com.nosiphus.furniture.world.item;

import com.nosiphus.furniture.tags.ModFluidTags;
import com.nosiphus.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class CupItem extends BlockItem {

    public CupItem(Block block, Properties properties) {
        super(block, properties);
    }

    public int getMaxStackSize(ItemStack stack) {
        return hasFluid(stack) ? 1 : 64;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltip, flag);

        if (hasFluid(stack)) {
            Fluid fluid = getFluid(stack);
            int amount = getFluidAmount(stack);

            if (fluid != Fluids.EMPTY && amount > 0) {
                Component fluidDisplayName = Component.translatable(
                        fluid.defaultFluidState().createLegacyBlock().getBlock().getDescriptionId()
                ).withStyle(ModFluidTags.getFluidStyle(fluid));

                tooltip.add(Component.literal("")
                        .append(fluidDisplayName)
                        .append(Component.literal(": " + amount + " / 1000 mB").withStyle(ChatFormatting.GRAY)));
            }
        }
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return hasFluid(stack) ? UseAnim.DRINK : UseAnim.NONE;
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return hasFluid(stack) ? 32 : 0;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        ItemStack stack = context.getItemInHand();

        if (player != null && hasFluid(stack) && !player.isShiftKeyDown()) {
            InteractionResultHolder<ItemStack> drinkResult = this.use(context.getLevel(), player, context.getHand());
            return drinkResult.getResult();
        }

        return super.useOn(context);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (hasFluid(stack)) {
            if (!player.isShiftKeyDown()) {
                return ItemUtils.startUsingInstantly(level, player, hand);
            }
            return InteractionResultHolder.pass(stack);
        }

        return super.use(level, player, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        Fluid fluid = getFluid(stack);

        if (!level.isClientSide) {
            ModFluidTags.applyEffects(entity, fluid);
        }

        if (entity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (entity instanceof Player player && player.getAbilities().instabuild) {
            return stack;
        }

        if (entity instanceof Player player) {
            if (stack.getCount() > 1) {
                ItemStack singleDrained = stack.copyWithCount(1);
                drainCupItem(singleDrained, 250);
                stack.shrink(1);
                if (!player.getInventory().add(singleDrained)) {
                    player.drop(singleDrained, false);
                }
                return stack;
            } else {
                drainCupItem(stack, 250);
                return stack;
            }
        }

        return stack;
    }

    public static boolean hasFluid(ItemStack stack) {
        CustomData customData = stack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (customData == null) return false;
        CompoundTag tag = customData.copyTag();
        return tag.getInt("Amount") > 0;
    }

    public static Fluid getFluid(ItemStack stack) {
        CustomData customData = stack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (customData != null) {
            CompoundTag tag = customData.copyTag();
            if (tag.contains("FluidName", CompoundTag.TAG_STRING)) {
                return BuiltInRegistries.FLUID.get(ResourceLocation.parse(tag.getString("FluidName")));
            }
        }
        return Fluids.EMPTY;
    }

    public static int getFluidAmount(ItemStack stack) {
        CustomData customData = stack.get(DataComponents.BLOCK_ENTITY_DATA);
        if (customData != null) {
            return customData.copyTag().getInt("Amount");
        }
        return 0;
    }

    public static void setFluid(ItemStack stack, Fluid fluid, int amount) {
        if (fluid == Fluids.EMPTY || amount <= 0) {
            stack.remove(DataComponents.BLOCK_ENTITY_DATA);
        } else {
            stack.update(DataComponents.BLOCK_ENTITY_DATA, CustomData.EMPTY, customData -> {
                CompoundTag tag = customData.copyTag();
                tag.putString("id", BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(ModBlockEntityTypes.CUP.get()).toString());
                tag.putString("FluidName", BuiltInRegistries.FLUID.getKey(fluid).toString());
                tag.putInt("Amount", amount);
                return CustomData.of(tag);
            });
        }
    }

    public static ItemStack drainCupItem(ItemStack stack, int amount) {
        stack.update(DataComponents.BLOCK_ENTITY_DATA, CustomData.EMPTY, customData -> {
            CompoundTag tag = customData.copyTag();
            int current = tag.getInt("Amount");
            int next = Math.max(0, current - amount);
            if (next <= 0) {
                tag.remove("FluidName");
                tag.remove("Amount");
            } else {
                tag.putInt("Amount", next);
            }
            return CustomData.of(tag);
        });
        if (!hasFluid(stack)) {
            stack.remove(DataComponents.BLOCK_ENTITY_DATA);
        }
        return stack;
    }

    public static void applyFluidEffects(ItemStack stack, LivingEntity entity) {
        Fluid fluid = getFluid(stack);
        ModFluidTags.applyEffects(entity, fluid);
    }
}