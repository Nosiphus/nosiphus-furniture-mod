package com.nosiphus.furniture.core;

import com.nosiphus.furniture.Reference;
import com.mrcrayfish.furniture.tileentity.*;
import com.nosiphus.furniture.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

/**
 * Author: MrCrayfish
 */
public class ModTileEntities
{
    public static final DeferredRegister<TileEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Reference.MOD_ID);

    public static final RegistryObject<TileEntityType<CabinetTileEntity>> CABINET = register("cabinet", CabinetTileEntity::new, () -> new Block[]{ModBlocks.CABINET_WHITE_MODERN.get(), ModBlocks.CABINET_ORANGE_MODERN.get(), ModBlocks.CABINET_MAGENTA_MODERN.get(), ModBlocks.CABINET_LIGHT_BLUE_MODERN.get(), ModBlocks.CABINET_YELLOW_MODERN.get(), ModBlocks.CABINET_LIME_MODERN.get(), ModBlocks.CABINET_PINK_MODERN.get(), ModBlocks.CABINET_GRAY_MODERN.get(), ModBlocks.CABINET_LIGHT_GRAY_MODERN.get(), ModBlocks.CABINET_CYAN_MODERN.get(), ModBlocks.CABINET_PURPLE_MODERN.get(), ModBlocks.CABINET_BLUE_MODERN.get(), ModBlocks.CABINET_BROWN_MODERN.get(), ModBlocks.CABINET_GREEN_MODERN.get(), ModBlocks.CABINET_RED_MODERN.get(), ModBlocks.CABINET_BLACK_MODERN.get()});
    public static final RegistryObject<TileEntityType<BedsideCabinetTileEntity>> BEDSIDE_CABINET = register("bedside_cabinet", BedsideCabinetTileEntity::new, () -> new Block[]{ModBlocks.BEDSIDE_CABINET_WHITE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_ORANGE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_MAGENTA_MODERN.get(), ModBlocks.BEDSIDE_CABINET_LIGHT_BLUE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_YELLOW_MODERN.get(), ModBlocks.BEDSIDE_CABINET_LIME_MODERN.get(), ModBlocks.BEDSIDE_CABINET_PINK_MODERN.get(), ModBlocks.BEDSIDE_CABINET_GRAY_MODERN.get(), ModBlocks.BEDSIDE_CABINET_LIGHT_GRAY_MODERN.get(), ModBlocks.BEDSIDE_CABINET_CYAN_MODERN.get(), ModBlocks.BEDSIDE_CABINET_PURPLE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_BLUE_MODERN.get(), ModBlocks.BEDSIDE_CABINET_BROWN_MODERN.get(), ModBlocks.BEDSIDE_CABINET_GREEN_MODERN.get(), ModBlocks.BEDSIDE_CABINET_RED_MODERN.get(), ModBlocks.BEDSIDE_CABINET_BLACK_MODERN.get()});
    public static final RegistryObject<TileEntityType<DeskCabinetTileEntity>> DESK_CABINET = register("desk_cabinet", DeskCabinetTileEntity::new, () -> new Block[]{ModBlocks.DESK_CABINET_WHITE_MODERN.get(), ModBlocks.DESK_CABINET_ORANGE_MODERN.get(), ModBlocks.DESK_CABINET_MAGENTA_MODERN.get(), ModBlocks.DESK_CABINET_LIGHT_BLUE_MODERN.get(), ModBlocks.DESK_CABINET_YELLOW_MODERN.get(), ModBlocks.DESK_CABINET_LIME_MODERN.get(), ModBlocks.DESK_CABINET_PINK_MODERN.get(), ModBlocks.DESK_CABINET_GRAY_MODERN.get(), ModBlocks.DESK_CABINET_LIGHT_GRAY_MODERN.get(), ModBlocks.DESK_CABINET_CYAN_MODERN.get(), ModBlocks.DESK_CABINET_PURPLE_MODERN.get(), ModBlocks.DESK_CABINET_BLUE_MODERN.get(), ModBlocks.DESK_CABINET_BROWN_MODERN.get(), ModBlocks.DESK_CABINET_GREEN_MODERN.get(), ModBlocks.DESK_CABINET_RED_MODERN.get(), ModBlocks.DESK_CABINET_BLACK_MODERN.get()});
    public static final RegistryObject<TileEntityType<KitchenDrawerTileEntity>> KITCHEN_DRAWER = register("kitchen_drawer", KitchenDrawerTileEntity::new, () -> new Block[]{ModBlocks.KITCHEN_DRAWER_WHITE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_ORANGE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_MAGENTA_MODERN.get(), ModBlocks.KITCHEN_DRAWER_LIGHT_BLUE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_YELLOW_MODERN.get(), ModBlocks.KITCHEN_DRAWER_LIME_MODERN.get(), ModBlocks.KITCHEN_DRAWER_PINK_MODERN.get(), ModBlocks.KITCHEN_DRAWER_GRAY_MODERN.get(), ModBlocks.KITCHEN_DRAWER_LIGHT_GRAY_MODERN.get(), ModBlocks.KITCHEN_DRAWER_CYAN_MODERN.get(), ModBlocks.KITCHEN_DRAWER_PURPLE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_BLUE_MODERN.get(), ModBlocks.KITCHEN_DRAWER_BROWN_MODERN.get(), ModBlocks.KITCHEN_DRAWER_GREEN_MODERN.get(), ModBlocks.KITCHEN_DRAWER_RED_MODERN.get(), ModBlocks.KITCHEN_DRAWER_BLACK_MODERN.get()});
    public static final RegistryObject<TileEntityType<KitchenSinkTileEntity>> KITCHEN_SINK = register("kitchen_sink", KitchenSinkTileEntity::new, () -> new Block[]{ModBlocks.KITCHEN_SINK_WHITE_MODERN.get(), ModBlocks.KITCHEN_SINK_ORANGE_MODERN.get(), ModBlocks.KITCHEN_SINK_MAGENTA_MODERN.get(), ModBlocks.KITCHEN_SINK_LIGHT_BLUE_MODERN.get(), ModBlocks.KITCHEN_SINK_YELLOW_MODERN.get(), ModBlocks.KITCHEN_SINK_LIME_MODERN.get(), ModBlocks.KITCHEN_SINK_PINK_MODERN.get(), ModBlocks.KITCHEN_SINK_GRAY_MODERN.get(), ModBlocks.KITCHEN_SINK_LIGHT_GRAY_MODERN.get(), ModBlocks.KITCHEN_SINK_CYAN_MODERN.get(), ModBlocks.KITCHEN_SINK_PURPLE_MODERN.get(), ModBlocks.KITCHEN_SINK_BLUE_MODERN.get(), ModBlocks.KITCHEN_SINK_BROWN_MODERN.get(), ModBlocks.KITCHEN_SINK_GREEN_MODERN.get(), ModBlocks.KITCHEN_SINK_RED_MODERN.get(), ModBlocks.KITCHEN_SINK_BLACK_MODERN.get()});
    public static final RegistryObject<TileEntityType<OfficeChairTileEntity>> OFFICE_CHAIR = register("office_chair", OfficeChairTileEntity::new, () -> new Block[]{ModBlocks.CHAIR_WHITE_OFFICE.get(), ModBlocks.CHAIR_ORANGE_OFFICE.get(), ModBlocks.CHAIR_MAGENTA_OFFICE.get(), ModBlocks.CHAIR_LIGHT_BLUE_OFFICE.get(), ModBlocks.CHAIR_YELLOW_OFFICE.get(), ModBlocks.CHAIR_LIME_OFFICE.get(), ModBlocks.CHAIR_PINK_OFFICE.get(), ModBlocks.CHAIR_GRAY_OFFICE.get(), ModBlocks.CHAIR_LIGHT_GRAY_OFFICE.get(), ModBlocks.CHAIR_CYAN_OFFICE.get(), ModBlocks.CHAIR_PURPLE_OFFICE.get(), ModBlocks.CHAIR_BLUE_OFFICE.get(), ModBlocks.CHAIR_BROWN_OFFICE.get(), ModBlocks.CHAIR_GREEN_OFFICE.get(), ModBlocks.CHAIR_RED_OFFICE.get(), ModBlocks.CHAIR_BLACK_OFFICE.get()});
    public static final RegistryObject<TileEntityType<SinkTileEntity>> SINK = register("sink", SinkTileEntity::new, () -> new Block[]{ModBlocks.SINK_LIGHT.get(), ModBlocks.SINK_DARK.get()});
    public static final RegistryObject<TileEntityType<ShowerHeadTileEntity>> SHOWER_HEAD = register("shower_head", ShowerHeadTileEntity::new, () -> new Block[]{ModBlocks.SHOWER_HEAD_LIGHT.get(), ModBlocks.SHOWER_HEAD_DARK.get()});

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factoryIn, Supplier<Block[]> validBlocksSupplier)
    {
        //Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, name);
        return REGISTER.register(name, () -> TileEntityType.Builder.create(factoryIn, validBlocksSupplier.get()).build(null)); //Null until someone can explain data fixers
    }
}