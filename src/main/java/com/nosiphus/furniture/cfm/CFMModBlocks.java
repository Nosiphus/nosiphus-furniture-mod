package com.nosiphus.furniture.cfm;

import com.mrcrayfish.furniture.Reference;
import com.mrcrayfish.furniture.block.*;
import com.mrcrayfish.furniture.core.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.mrcrayfish.furniture.core.ModBlocks.REGISTER;

public class CFMModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Reference.MOD_ID);
    public static final RegistryObject<Block> TABLE_CHERRY;
    public static final RegistryObject<Block> TABLE_STRIPPED_CHERRY;
    public static final RegistryObject<Block> CHAIR_CHERRY;
    public static final RegistryObject<Block> CHAIR_STRIPPED_CHERRY;
    public static final RegistryObject<Block> COFFEE_TABLE_CHERRY;
    public static final RegistryObject<Block> COFFEE_TABLE_STRIPPED_CHERRY;
    public static final RegistryObject<Block> CABINET_CHERRY;
    public static final RegistryObject<Block> CABINET_STRIPPED_CHERRY;
    public static final RegistryObject<Block> BEDSIDE_CABINET_CHERRY;
    public static final RegistryObject<Block> BEDSIDE_CABINET_STRIPPED_CHERRY;
    /*
    public static final RegistryObject<Block> DESK_CHERRY;
    public static final RegistryObject<Block> DESK_STRIPPED_CHERRY;
    public static final RegistryObject<Block> DESK_CABINET_CHERRY;
    public static final RegistryObject<Block> DESK_CABINET_STRIPPED_CHERRY;
     */
    public static final RegistryObject<Block> BLINDS_CHERRY;
    public static final RegistryObject<Block> BLINDS_STRIPPED_CHERRY;
    public static final RegistryObject<Block> UPGRADED_FENCE_CHERRY;
    public static final RegistryObject<Block> UPGRADED_FENCE_STRIPPED_CHERRY;
    public static final RegistryObject<Block> UPGRADED_GATE_CHERRY;
    public static final RegistryObject<Block> UPGRADED_GATE_STRIPPED_CHERRY;
    public static final RegistryObject<Block> CRATE_CHERRY;
    public static final RegistryObject<Block> CRATE_STRIPPED_CHERRY;
    public static final RegistryObject<Block> PARK_BENCH_CHERRY;
    public static final RegistryObject<Block> PARK_BENCH_STRIPPED_CHERRY;
    public static final RegistryObject<Block> MAIL_BOX_CHERRY;
    public static final RegistryObject<Block> MAIL_BOX_STRIPPED_CHERRY;
    public static final RegistryObject<Block> HEDGE_CHERRY;
    public static final RegistryObject<Block> KITCHEN_COUNTER_CHERRY;
    public static final RegistryObject<Block> KITCHEN_COUNTER_STRIPPED_CHERRY;
    public static final RegistryObject<Block> KITCHEN_DRAWER_CHERRY;
    public static final RegistryObject<Block> KITCHEN_DRAWER_STRIPPED_CHERRY;
    public static final RegistryObject<Block> KITCHEN_SINK_LIGHT_CHERRY;
    public static final RegistryObject<Block> KITCHEN_SINK_LIGHT_STRIPPED_CHERRY;
    public static final RegistryObject<Block> KITCHEN_SINK_DARK_CHERRY;
    public static final RegistryObject<Block> KITCHEN_SINK_DARK_STRIPPED_CHERRY;

    private static RegistryObject<Block> register(String name, Supplier<Block> block) {
        return register(name, block, new Item.Properties());
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, Item.Properties properties) {
        RegistryObject<Block> registryObject = REGISTER.register(name, block);
        ModItems.REGISTER.register(name, () -> new BlockItem((Block)registryObject.get(), properties));
        return registryObject;
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, @Nullable Function<RegistryObject<Block>, BlockItem> function) {
        RegistryObject<Block> registryObject = REGISTER.register(name, block);
        if (function != null) {
            ModItems.REGISTER.register(name, () -> (BlockItem)function.apply(registryObject));
        }

        return registryObject;
    }

    private static RegistryObject<Block> registerNoItem(String name, Supplier<Block> block) {
        return REGISTER.register(name, block);
    }

    static {
        TABLE_CHERRY = register("cherry_table", () -> new TableBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        TABLE_STRIPPED_CHERRY = register("stripped_cherry_table", () -> new TableBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        CHAIR_CHERRY = register("cherry_chair", () -> new ChairBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        CHAIR_STRIPPED_CHERRY = register("stripped_cherry_chair", () -> new ChairBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        COFFEE_TABLE_CHERRY = register("cherry_coffee_table", () -> new CoffeeTableBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        COFFEE_TABLE_STRIPPED_CHERRY = register("stripped_cherry_coffee_table", () -> new CoffeeTableBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        CABINET_CHERRY = register("cherry_cabinet", () -> new CabinetBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        CABINET_STRIPPED_CHERRY = register("stripped_cherry_cabinet", () -> new CabinetBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        BEDSIDE_CABINET_CHERRY = register("cherry_bedside_cabinet", () -> new BedsideCabinetBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        BEDSIDE_CABINET_STRIPPED_CHERRY = register("stripped_cherry_bedside_cabinet", () -> new BedsideCabinetBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        /*
        DESK_CHERRY = register("cherry_desk", () -> new DeskBlock(Properties.copy(Blocks.CHERRY_PLANKS), DeskBlockMaterialType.CHERRY));
        DESK_STRIPPED_CHERRY = register("stripped_cherry_desk", () -> new DeskBlock(Properties.copy(Blocks.CHERRY_PLANKS), DeskBlockMaterialType.STRIPPED_CHERRY));
        DESK_CABINET_CHERRY = register("cherry_desk_cabinet", () -> new DeskCabinetBlock(Properties.copy(Blocks.CHERRY_PLANKS), DeskBlockMaterialType.CHERRY));
        DESK_CABINET_STRIPPED_CHERRY = register("stripped_cherry_desk_cabinet", () -> new DeskCabinetBlock(Properties.copy(Blocks.CHERRY_PLANKS), DeskBlockMaterialType.STRIPPED_CHERRY));
         */
        BLINDS_CHERRY = register("cherry_blinds", () -> new BlindsBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        BLINDS_STRIPPED_CHERRY = register("stripped_cherry_blinds", () -> new BlindsBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        UPGRADED_FENCE_CHERRY = register("cherry_upgraded_fence", () -> new UpgradedFenceBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        UPGRADED_FENCE_STRIPPED_CHERRY = register("stripped_cherry_upgraded_fence", () -> new UpgradedFenceBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        UPGRADED_GATE_CHERRY = register("cherry_upgraded_gate", () -> new UpgradedGateBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        UPGRADED_GATE_STRIPPED_CHERRY = register("stripped_cherry_upgraded_gate", () -> new UpgradedGateBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        CRATE_CHERRY = register("cherry_crate", () -> new CrateBlock(Properties.copy(Blocks.CHEST)));
        CRATE_STRIPPED_CHERRY = register("stripped_cherry_crate", () -> new CrateBlock(Properties.copy(Blocks.CHEST)));
        PARK_BENCH_CHERRY = register("cherry_park_bench", () -> new ParkBenchBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        PARK_BENCH_STRIPPED_CHERRY = register("stripped_cherry_park_bench", () -> new ParkBenchBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        MAIL_BOX_CHERRY = register("cherry_mail_box", () -> new MailBoxBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        MAIL_BOX_STRIPPED_CHERRY = register("stripped_cherry_mail_box", () -> new MailBoxBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        HEDGE_CHERRY = register("cherry_hedge", () -> new HedgeBlock(Properties.copy(Blocks.CHERRY_LEAVES)));
        KITCHEN_COUNTER_CHERRY = register("cherry_kitchen_counter", () -> new KitchenCounterBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        KITCHEN_COUNTER_STRIPPED_CHERRY = register("stripped_cherry_kitchen_counter", () -> new KitchenCounterBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        KITCHEN_DRAWER_CHERRY = register("cherry_kitchen_drawer", () -> new KitchenDrawerBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        KITCHEN_DRAWER_STRIPPED_CHERRY = register("stripped_cherry_kitchen_drawer", () -> new KitchenDrawerBlock(Properties.copy(Blocks.CHERRY_PLANKS)));
        KITCHEN_SINK_LIGHT_CHERRY = register("cherry_kitchen_sink_light", () -> new KitchenSinkBlock(Properties.copy(Blocks.CHERRY_PLANKS), true));
        KITCHEN_SINK_LIGHT_STRIPPED_CHERRY = register("stripped_cherry_kitchen_sink_light", () -> new KitchenSinkBlock(Properties.copy(Blocks.CHERRY_PLANKS), true));
        KITCHEN_SINK_DARK_CHERRY = register("cherry_kitchen_sink_dark", () -> new KitchenSinkBlock(Properties.copy(Blocks.CHERRY_PLANKS), true));
        KITCHEN_SINK_DARK_STRIPPED_CHERRY = register("stripped_cherry_kitchen_sink_dark", () -> new KitchenSinkBlock(Properties.copy(Blocks.CHERRY_PLANKS), true));
    }

}

