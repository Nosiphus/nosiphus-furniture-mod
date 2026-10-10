package com.nosiphus.furniture.tags;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

public class ModFluidTags {

    public static final TagKey<Fluid> C_MILK = tag("c", "milk");
    public static final TagKey<Fluid> C_HONEY = tag("c", "honey");
    public static final TagKey<Fluid> C_TEA = tag("c", "tea");
    public static final TagKey<Fluid> C_JUICE = tag("c", "juice");
    public static final TagKey<Fluid> C_POTION = tag("c", "potion");
    public static final TagKey<Fluid> C_CRUDE_OIL = tag("c", "crude_oil");
    public static final TagKey<Fluid> C_OIL = tag("c", "oil");
    public static final TagKey<Fluid> C_FUEL = tag("c", "fuel");

    public static final TagKey<Fluid> FORGE_MILK = tag("forge", "milk");
    public static final TagKey<Fluid> FORGE_HONEY = tag("forge", "honey");
    public static final TagKey<Fluid> FORGE_TEA = tag("forge", "tea");
    public static final TagKey<Fluid> FORGE_JUICE = tag("forge", "juice");
    public static final TagKey<Fluid> FORGE_CRUDE_OIL = tag("forge", "crude_oil");
    public static final TagKey<Fluid> FORGE_OIL = tag("forge", "oil");
    public static final TagKey<Fluid> FORGE_FUEL = tag("forge", "fuel");

    public static final TagKey<Fluid> DRINKS = tag(NosiphusFurnitureMod.MOD_ID, "drinks");
    public static final TagKey<Fluid> SOAPY_FLUIDS = tag(NosiphusFurnitureMod.MOD_ID, "soapy_fluids");

    public static final TagKey<Fluid> WATER_BASED_FLUIDS = tag(NosiphusFurnitureMod.MOD_ID, "water_based_fluids");

    private static TagKey<Fluid> tag(String id, String name)
    {
        return TagKey.create(Registries.FLUID, new ResourceLocation(id, name));
    }

    private record TagStyleRule(List<TagKey<Fluid>> tags, int colorRgb) {
        public boolean matches(Fluid fluid) {
            for (TagKey<Fluid> tag : this.tags) {
                if (fluid.is(tag)) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final List<TagStyleRule> STYLE_RULES = List.of(
            new TagStyleRule(List.of(FluidTags.WATER), 0x3B99FF),
            new TagStyleRule(List.of(FluidTags.LAVA), 0xFF6A00),
            new TagStyleRule(List.of(C_MILK, FORGE_MILK), 0xF0F0F0),
            new TagStyleRule(List.of(C_HONEY, FORGE_HONEY), 0xFFA812),
            new TagStyleRule(List.of(C_TEA, FORGE_TEA), 0x8D5B2A),
            new TagStyleRule(List.of(C_JUICE, FORGE_JUICE, DRINKS), 0xFF3366),
            new TagStyleRule(List.of(C_POTION), 0xB842FF),
            new TagStyleRule(List.of(C_CRUDE_OIL, C_OIL, FORGE_CRUDE_OIL, FORGE_OIL), 0x383838),
            new TagStyleRule(List.of(C_FUEL, FORGE_FUEL), 0xFFE033),
            new TagStyleRule(List.of(SOAPY_FLUIDS), 0xA11FA0FF)
    );

    private static final Style DEFAULT_FLUID_STYLE = Style.EMPTY.withColor(TextColor.fromRgb(0x55FFFF));

    public static Style getFluidStyle(Fluid fluid) {
        for (TagStyleRule rule : STYLE_RULES) {
            if (rule.matches(fluid)) {
                return Style.EMPTY.withColor(TextColor.fromRgb(rule.colorRgb()));
            }
        }
        return DEFAULT_FLUID_STYLE;
    }

    public static void applyEffects(LivingEntity entity, Fluid fluid) {
        if (entity.level().isClientSide || fluid == Fluids.EMPTY) {
            return;
        }

        if (fluid.is(FluidTags.LAVA)) {
            entity.setSecondsOnFire(15);
            entity.hurt(entity.damageSources().lava(), 4.0F); // Direct internal burn damage
            entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                    SoundEvents.GENERIC_BURN, SoundSource.PLAYERS, 1.0F, 1.0F);
            return;
        }

        if (fluid.is(ModFluidTags.C_CRUDE_OIL) || fluid.is(ModFluidTags.C_OIL)
                || fluid.is(ModFluidTags.FORGE_CRUDE_OIL) || fluid.is(ModFluidTags.FORGE_OIL)) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 30 * 20, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 15 * 20, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * 20, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20 * 20, 2));
            return;
        }

        if (fluid.is(ModFluidTags.C_FUEL) || fluid.is(ModFluidTags.FORGE_FUEL)) {
            entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 45 * 20, 2));
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 20 * 20, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10 * 20, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 30 * 20, 1));
            return;
        }

        if (fluid.is(ModFluidTags.C_MILK) || fluid.is(ModFluidTags.FORGE_MILK)) {
            entity.removeAllEffects();
            return;
        }

        if (fluid.is(ModFluidTags.C_HONEY) || fluid.is(ModFluidTags.FORGE_HONEY)) {
            entity.removeEffect(MobEffects.POISON);
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 4 * 20, 0));
            return;
        }

        if (fluid.is(FluidTags.WATER)) {
            if (entity.isOnFire()) {
                entity.clearFire();
                entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                        SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS, 0.7F, 1.2F);
            }
        }
    }
}