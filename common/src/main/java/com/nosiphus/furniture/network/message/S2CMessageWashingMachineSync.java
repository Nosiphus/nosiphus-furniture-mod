package com.nosiphus.furniture.network.message;

import com.nosiphus.furniture.NosiphusFurnitureMod;
import com.nosiphus.furniture.network.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Fluid;

public record S2CMessageWashingMachineSync(BlockPos pos, Fluid fluid, int fluidAmount, boolean washing) implements Message {

    public static final ResourceLocation ID = new ResourceLocation(NosiphusFurnitureMod.MOD_ID, "washing_machine_sync");

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeBlockPos(this.pos);
        buf.writeResourceLocation(BuiltInRegistries.FLUID.getKey(this.fluid));
        buf.writeVarInt(this.fluidAmount);
        buf.writeBoolean(this.washing);
    }

    public static S2CMessageWashingMachineSync decode(FriendlyByteBuf buf) {
        BlockPos pos = buf.readBlockPos();
        Fluid fluid = BuiltInRegistries.FLUID.get(buf.readResourceLocation());
        int amount = buf.readVarInt();
        boolean washing = buf.readBoolean();
        return new S2CMessageWashingMachineSync(pos, fluid, amount, washing);
    }
}