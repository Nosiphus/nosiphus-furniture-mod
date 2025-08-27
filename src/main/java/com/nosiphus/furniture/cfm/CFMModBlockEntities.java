package com.nosiphus.furniture.cfm;

import com.mrcrayfish.furniture.Reference;
import com.mrcrayfish.furniture.tileentity.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.mrcrayfish.furniture.core.ModBlockEntities.REGISTER;

public class CFMModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Reference.MOD_ID);

    public static final RegistryObject<BlockEntityType<CabinetBlockEntity>> CFM_CABINET = register("cfm_cabinet", CabinetBlockEntity::new, () -> new Block[]{CFMModBlocks.CABINET_CHERRY.get(), CFMModBlocks.CABINET_STRIPPED_CHERRY.get()});
    public static final RegistryObject<BlockEntityType<BedsideCabinetBlockEntity>> CFM_BEDSIDE_CABINET = register("cfm_bedside_cabinet", BedsideCabinetBlockEntity::new, () -> new Block[]{CFMModBlocks.BEDSIDE_CABINET_CHERRY.get(), CFMModBlocks.BEDSIDE_CABINET_STRIPPED_CHERRY.get()});
    public static final RegistryObject<BlockEntityType<CrateBlockEntity>> CFM_CRATE = register("cfm_crate", CrateBlockEntity::new, () -> new Block[]{CFMModBlocks.CRATE_CHERRY.get(), CFMModBlocks.CRATE_STRIPPED_CHERRY.get()});
    public static final RegistryObject<BlockEntityType<MailBoxBlockEntity>> CFM_MAIL_BOX = register("cfm_mail_box", MailBoxBlockEntity::new, () -> new Block[]{CFMModBlocks.MAIL_BOX_CHERRY.get(), CFMModBlocks.MAIL_BOX_STRIPPED_CHERRY.get()});
    public static final RegistryObject<BlockEntityType<KitchenDrawerBlockEntity>> CFM_KITCHEN_DRAWER = register("cfm_kitchen_drawer", KitchenDrawerBlockEntity::new, () -> new Block[]{CFMModBlocks.KITCHEN_DRAWER_CHERRY.get(), CFMModBlocks.KITCHEN_DRAWER_STRIPPED_CHERRY.get()});

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntityType.BlockEntitySupplier<T> supplier, Supplier<Block[]> validBlocksSupplier)
    {
        //Type<?> type = Util.attemptDataFix(TypeReferences.BLOCK_ENTITY, name);
        return REGISTER.register(name, () -> BlockEntityType.Builder.of(supplier, validBlocksSupplier.get()).build(null)); //Null until someone can explain data fixers
    }

}
