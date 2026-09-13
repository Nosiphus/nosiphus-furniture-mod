package com.mrcrayfish.furniture.integration.everycomp;

import com.mrcrayfish.furniture.MrCrayFishFurnitureMod;
import com.mrcrayfish.furniture.tags.ModBlockTags;
import com.mrcrayfish.furniture.tags.ModItemTags;
import com.mrcrayfish.furniture.world.level.block.*;
import com.mrcrayfish.furniture.world.level.block.entity.ModBlockEntityTypes;
import net.mehvahdjukaar.every_compat.api.RenderLayer;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.set.leaves.LeavesType;
import net.mehvahdjukaar.moonlight.api.set.leaves.VanillaLeavesTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

public class EveryCompatModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, Block> tables;
    public final SimpleEntrySet<WoodType, Block> strippedTables;
    public final SimpleEntrySet<WoodType, Block> chairs;
    public final SimpleEntrySet<WoodType, Block> strippedChairs;
    public final SimpleEntrySet<WoodType, Block> coffeeTables;
    public final SimpleEntrySet<WoodType, Block> strippedCoffeeTables;
    public final SimpleEntrySet<WoodType, Block> cabinets;
    public final SimpleEntrySet<WoodType, Block> strippedCabinets;
    public final SimpleEntrySet<WoodType, Block> bedsideCabinets;
    public final SimpleEntrySet<WoodType, Block> strippedBedsideCabinets;
    public final SimpleEntrySet<WoodType, Block> desks;
    public final SimpleEntrySet<WoodType, Block> strippedDesks;
    public final SimpleEntrySet<WoodType, Block> deskCabinets;
    public final SimpleEntrySet<WoodType, Block> strippedDeskCabinets;
    public final SimpleEntrySet<WoodType, Block> blinds;
    public final SimpleEntrySet<WoodType, Block> strippedBlinds;
    public final SimpleEntrySet<WoodType, Block> upgradedFences;
    public final SimpleEntrySet<WoodType, Block> strippedUpgradedFences;
    public final SimpleEntrySet<WoodType, Block> upgradedGates;
    public final SimpleEntrySet<WoodType, Block> strippedUpgradedGates;
    public final SimpleEntrySet<WoodType, Block> crates;
    public final SimpleEntrySet<WoodType, Block> strippedCrates;
    public final SimpleEntrySet<WoodType, Block> parkBenches;
    public final SimpleEntrySet<WoodType, Block> strippedParkBenches;
    public final SimpleEntrySet<WoodType, Block> mailBoxes;
    public final SimpleEntrySet<WoodType, Block> strippedMailBoxes;
    public final SimpleEntrySet<LeavesType, Block> hedges;
    public final SimpleEntrySet<WoodType, Block> kitchenCounters;
    public final SimpleEntrySet<WoodType, Block> strippedKitchenCounters;
    public final SimpleEntrySet<WoodType, Block> kitchenDrawers;
    public final SimpleEntrySet<WoodType, Block> strippedKitchenDrawers;
    public final SimpleEntrySet<WoodType, Block> kitchenSinkLight;
    public final SimpleEntrySet<WoodType, Block> strippedKitchenSinkLight;
    public final SimpleEntrySet<WoodType, Block> kitchenSinkDark;
    public final SimpleEntrySet<WoodType, Block> strippedKitchenSinkDark;

    public EveryCompatModule(String modId) {
        super(modId, MrCrayFishFurnitureMod.MOD_ID);
        ResourceLocation tab = modRes(MrCrayFishFurnitureMod.MOD_ID);

        tables = SimpleEntrySet.builder(WoodType.class, "table",
                        ModBlocks.OAK_TABLE, () -> VanillaWoodTypes.OAK,
                        w -> new TableBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.GENERAL, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(tables);

        strippedTables = SimpleEntrySet.builder(WoodType.class, "table", "stripped",
                        ModBlocks.STRIPPED_OAK_TABLE, () -> VanillaWoodTypes.OAK,
                        w -> new TableBlock(Utils.copyPropertySafe(w.log)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.GENERAL, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedTables);

        chairs = SimpleEntrySet.builder(WoodType.class, "chair",
                        ModBlocks.OAK_CHAIR, () -> VanillaWoodTypes.OAK,
                        w -> new ChairBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.GENERAL, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(chairs);

        strippedChairs = SimpleEntrySet.builder(WoodType.class, "chair", "stripped",
                        ModBlocks.STRIPPED_OAK_CHAIR, () -> VanillaWoodTypes.OAK,
                        w -> new ChairBlock(Utils.copyPropertySafe(w.log)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.GENERAL, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedChairs);

        coffeeTables = SimpleEntrySet.builder(WoodType.class, "coffee_table",
                        ModBlocks.OAK_COFFEE_TABLE, () -> VanillaWoodTypes.OAK,
                        w -> new CoffeeTableBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.GENERAL, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(coffeeTables);

        strippedCoffeeTables = SimpleEntrySet.builder(WoodType.class, "coffee_table", "stripped",
                        ModBlocks.STRIPPED_OAK_COFFEE_TABLE, () -> VanillaWoodTypes.OAK,
                        w -> new CoffeeTableBlock(Utils.copyPropertySafe(w.log)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.GENERAL, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedCoffeeTables);

        cabinets = SimpleEntrySet.builder(WoodType.class, "cabinet",
                        ModBlocks.OAK_CABINET, () -> VanillaWoodTypes.OAK,
                        w -> new CabinetBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.CABINET)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(cabinets);

        strippedCabinets = SimpleEntrySet.builder(WoodType.class, "cabinet", "stripped",
                        ModBlocks.STRIPPED_OAK_CABINET, () -> VanillaWoodTypes.OAK,
                        w -> new CabinetBlock(Utils.copyPropertySafe(w.planks)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.CABINET)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedCabinets);

        bedsideCabinets = SimpleEntrySet.builder(WoodType.class, "bedside_cabinet",
                        ModBlocks.OAK_BEDSIDE_CABINET, () -> VanillaWoodTypes.OAK,
                        w -> new BedsideCabinetBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.BEDROOM, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.BEDSIDE_CABINET)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(bedsideCabinets);

        strippedBedsideCabinets = SimpleEntrySet.builder(WoodType.class, "bedside_cabinet", "stripped",
                        ModBlocks.STRIPPED_OAK_BEDSIDE_CABINET, () -> VanillaWoodTypes.OAK,
                        w -> new BedsideCabinetBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.BEDROOM, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .requiresChildren("stripped_log")
                .addTile(ModBlockEntityTypes.BEDSIDE_CABINET)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedBedsideCabinets);

        desks = SimpleEntrySet.builder(WoodType.class, "desk",
                        ModBlocks.OAK_DESK, () -> VanillaWoodTypes.OAK,
                        w -> new DeskBlock(Utils.copyPropertySafe(w.planks), DeskBlock.MaterialType.OAK))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.BEDROOM, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(desks);

        strippedDesks = SimpleEntrySet.builder(WoodType.class, "desk", "stripped",
                        ModBlocks.STRIPPED_OAK_DESK, () -> VanillaWoodTypes.OAK,
                        w -> new DeskBlock(Utils.copyPropertySafe(w.log), DeskBlock.MaterialType.STRIPPED_OAK))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.BEDROOM, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedDesks);

        deskCabinets = SimpleEntrySet.builder(WoodType.class, "desk_cabinet",
                        ModBlocks.OAK_DESK_CABINET, () -> VanillaWoodTypes.OAK,
                        w -> new DeskCabinetBlock(Utils.copyPropertySafe(w.log), DeskBlock.MaterialType.OAK))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.BEDROOM, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.DESK_CABINET)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(deskCabinets);

        strippedDeskCabinets = SimpleEntrySet.builder(WoodType.class, "desk_cabinet", "stripped",
                        ModBlocks.STRIPPED_OAK_DESK_CABINET, () -> VanillaWoodTypes.OAK,
                        w -> new DeskCabinetBlock(Utils.copyPropertySafe(w.log), DeskBlock.MaterialType.STRIPPED_OAK)).requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.BEDROOM, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.DESK_CABINET)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedDeskCabinets);

        blinds = SimpleEntrySet.builder(WoodType.class, "blinds",
                        ModBlocks.OAK_BLINDS, () -> VanillaWoodTypes.OAK,
                        w -> new BlindsBlock(Utils.copyPropertySafe(w.log)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.BEDROOM, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .build();
        this.addEntry(blinds);

        strippedBlinds = SimpleEntrySet.builder(WoodType.class, "blinds", "stripped",
                        ModBlocks.STRIPPED_OAK_BLINDS, () -> VanillaWoodTypes.OAK,
                        w -> new BlindsBlock(Utils.copyPropertySafe(w.log)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.BEDROOM, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .build();
        this.addEntry(strippedBlinds);

        upgradedFences = SimpleEntrySet.builder(WoodType.class, "upgraded_fence",
                        ModBlocks.OAK_UPGRADED_FENCE, () -> VanillaWoodTypes.OAK,
                        w -> new UpgradedFenceBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.FENCES, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModBlockTags.UPGRADED_FENCES, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addTag(ModItemTags.UPGRADED_FENCES, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(upgradedFences);

        strippedUpgradedFences = SimpleEntrySet.builder(WoodType.class, "upgraded_fence", "stripped",
                        ModBlocks.STRIPPED_OAK_UPGRADED_FENCE, () -> VanillaWoodTypes.OAK,
                        w -> new UpgradedFenceBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.FENCES, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModBlockTags.UPGRADED_FENCES, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addTag(ModItemTags.UPGRADED_FENCES, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedUpgradedFences);

        upgradedGates = SimpleEntrySet.builder(WoodType.class, "upgraded_gate",
                        ModBlocks.OAK_UPGRADED_GATE, () -> VanillaWoodTypes.OAK,
                        w -> new UpgradedGateBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.FENCE_GATES, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.UNSTABLE_BOTTOM_CENTER, Registries.BLOCK)
                .addTag(ModBlockTags.UPGRADED_FENCE_GATES, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addTag(ModItemTags.UPGRADED_FENCE_GATES, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(upgradedGates);

        strippedUpgradedGates = SimpleEntrySet.builder(WoodType.class, "upgraded_gate", "stripped",
                        ModBlocks.STRIPPED_OAK_UPGRADED_GATE, () -> VanillaWoodTypes.OAK,
                        w -> new UpgradedGateBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.FENCE_GATES, Registries.BLOCK)
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(BlockTags.UNSTABLE_BOTTOM_CENTER, Registries.BLOCK)
                .addTag(ModBlockTags.UPGRADED_FENCE_GATES, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addTag(ModItemTags.UPGRADED_FENCE_GATES, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedUpgradedGates);

        crates = SimpleEntrySet.builder(WoodType.class, "crate",
                        ModBlocks.OAK_CRATE, () -> VanillaWoodTypes.OAK,
                        w -> new CrateBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.CRATE)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(crates);

        strippedCrates = SimpleEntrySet.builder(WoodType.class, "crate", "stripped",
                        ModBlocks.STRIPPED_OAK_CRATE, () -> VanillaWoodTypes.OAK,
                        w -> new CrateBlock(Utils.copyPropertySafe(w.log)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.CRATE)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedCrates);

        parkBenches = SimpleEntrySet.builder(WoodType.class, "park_bench",
                        ModBlocks.OAK_PARK_BENCH, () -> VanillaWoodTypes.OAK,
                        w -> new ParkBenchBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(parkBenches);

        strippedParkBenches = SimpleEntrySet.builder(WoodType.class, "park_bench", "stripped",
                        ModBlocks.STRIPPED_OAK_PARK_BENCH, () -> VanillaWoodTypes.OAK,
                        w -> new ParkBenchBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .requiresChildren("stripped_log")
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedParkBenches);

        mailBoxes = SimpleEntrySet.builder(WoodType.class, "mail_box",
                        ModBlocks.OAK_MAIL_BOX, () -> VanillaWoodTypes.OAK,
                        w -> new MailBoxBlock(Utils.copyPropertySafe(w.log)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.MAIL_BOX)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(mailBoxes);

        strippedMailBoxes = SimpleEntrySet.builder(WoodType.class, "mail_box", "stripped",
                        ModBlocks.STRIPPED_OAK_MAIL_BOX, () -> VanillaWoodTypes.OAK,
                        w -> new MailBoxBlock(Utils.copyPropertySafe(w.log)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.MAIL_BOX)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedMailBoxes);

        hedges = SimpleEntrySet.builder(LeavesType.class, "hedge",
                        ModBlocks.OAK_HEDGE, () -> VanillaLeavesTypes.OAK,
                        w -> {
                            var l = w.getBlockOfThis("leaves");
                            if (l == null) return null;
                            return new HedgeBlock(Utils.copyPropertySafe(l));
                        })
                .requiresChildren("leaves") // Reason: RECIPES
                .addTag(ModBlockTags.HEDGES, Registries.BLOCK)
                .addTag(ModItemTags.HEDGES, Registries.ITEM)
                .addTag(ModItemTags.OUTDOORS, Registries.ITEM)
                .addModelTransform(m -> m.replaceWithTextureFromChild("minecraft:block/oak_leaves",
                        "leaves", s -> !s.contains("/snow") && !s.contains("_snow")))
                .setTabKey(tab)
                .defaultRecipe()
                .copyParentTint()
                .setRenderType(RenderLayer.CUTOUT_MIPPED)
                .build();
        this.addEntry(hedges);

        kitchenCounters = SimpleEntrySet.builder(WoodType.class, "kitchen_counter",
                        ModBlocks.OAK_KITCHEN_COUNTER, () -> VanillaWoodTypes.OAK,
                        w -> new KitchenCounterBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(kitchenCounters);

        strippedKitchenCounters = SimpleEntrySet.builder(WoodType.class, "kitchen_counter", "stripped",
                        ModBlocks.STRIPPED_OAK_KITCHEN_COUNTER, () -> VanillaWoodTypes.OAK,
                        w -> new KitchenCounterBlock(Utils.copyPropertySafe(w.log))).requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedKitchenCounters);

        kitchenDrawers = SimpleEntrySet.builder(WoodType.class, "kitchen_drawer",
                        ModBlocks.OAK_KITCHEN_DRAWER, () -> VanillaWoodTypes.OAK,
                        w -> new KitchenDrawerBlock(Utils.copyPropertySafe(w.planks)))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .addTile(ModBlockEntityTypes.KITCHEN_DRAWER)
                .setTabKey(tab)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(kitchenDrawers);

        strippedKitchenDrawers = SimpleEntrySet.builder(WoodType.class, "kitchen_drawer", "stripped",
                        ModBlocks.STRIPPED_OAK_KITCHEN_DRAWER, () -> VanillaWoodTypes.OAK,
                        w -> new KitchenDrawerBlock(Utils.copyPropertySafe(w.log)))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .addTag(ModItemTags.STORAGE, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.KITCHEN_DRAWER)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedKitchenDrawers);

        kitchenSinkLight = SimpleEntrySet.builder(WoodType.class, "kitchen_sink_light",
                        ModBlocks.OAK_KITCHEN_SINK_LIGHT, () -> VanillaWoodTypes.OAK,
                        w -> new KitchenSinkBlock(Utils.copyPropertySafe(w.planks), true))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.KITCHEN_SINK)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(kitchenSinkLight);

        strippedKitchenSinkLight = SimpleEntrySet.builder(WoodType.class, "kitchen_sink_light", "stripped",
                        ModBlocks.STRIPPED_OAK_KITCHEN_SINK_LIGHT, () -> VanillaWoodTypes.OAK,
                        w -> new KitchenSinkBlock(Utils.copyPropertySafe(w.log), true))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.KITCHEN_SINK)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedKitchenSinkLight);

        kitchenSinkDark = SimpleEntrySet.builder(WoodType.class, "kitchen_sink_dark",
                        ModBlocks.OAK_KITCHEN_SINK_DARK, () -> VanillaWoodTypes.OAK,
                        w -> new KitchenSinkBlock(Utils.copyPropertySafe(w.planks), true))
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.KITCHEN_SINK)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(kitchenSinkDark);

        strippedKitchenSinkDark = SimpleEntrySet.builder(WoodType.class, "kitchen_sink_dark", "stripped",
                        ModBlocks.STRIPPED_OAK_KITCHEN_SINK_DARK, () -> VanillaWoodTypes.OAK,
                        w -> new KitchenSinkBlock(Utils.copyPropertySafe(w.log), true))
                .requiresChildren("stripped_log")
                .addTag(BlockTags.MINEABLE_WITH_AXE, Registries.BLOCK)
                .addTag(ModItemTags.KITCHEN, Registries.ITEM)
                .setTabKey(tab)
                .addTile(ModBlockEntityTypes.KITCHEN_SINK)
                .defaultRecipe()
                .setRenderType(RenderLayer.CUTOUT)
                .build();
        this.addEntry(strippedKitchenSinkDark);

    }

}