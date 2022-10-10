package net.crownsheep.woodexpanded.world.feature;

import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, WoodExpended.MOD_ID);

    public static final RegistryObject<PlacedFeature> PINE_CHECKED = PLACED_FEATURES.register("pine_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.PINE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.PINE_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> PURPUR_CHECKED = PLACED_FEATURES.register("purpur_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.PURPUR.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.PURPUR_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> PINE_PLACED = PLACED_FEATURES.register("pine_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PINE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    public static final RegistryObject<PlacedFeature> PURPUR_PLACED = PLACED_FEATURES.register("purpur_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PURPUR_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    public static final RegistryObject<PlacedFeature> OAK_WOOD_PIECE_ORE_PLACED = PLACED_FEATURES.register("oak_wood_piece_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.OAK_WOOD_PIECE_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-105), VerticalAnchor.aboveBottom(105)))));

    public static final RegistryObject<PlacedFeature> BIRCH_WOOD_PIECE_ORE_PLACED = PLACED_FEATURES.register("birch_wood_piece_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BIRCH_WOOD_PIECE_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-105), VerticalAnchor.aboveBottom(105)))));

    public static final RegistryObject<PlacedFeature> SPRUCE_WOOD_PIECE_ORE_PLACED = PLACED_FEATURES.register("spruce_wood_piece_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SPRUCE_WOOD_PIECE_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-105), VerticalAnchor.aboveBottom(105)))));

    public static final RegistryObject<PlacedFeature> DARK_OAK_WOOD_PIECE_ORE_PLACED = PLACED_FEATURES.register("dark_oak_wood_piece_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.DARK_OAK_WOOD_PIECE_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-105), VerticalAnchor.aboveBottom(105)))));

    public static final RegistryObject<PlacedFeature> JUNGLE_WOOD_PIECE_ORE_PLACED = PLACED_FEATURES.register("jungle_wood_piece_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.JUNGLE_WOOD_PIECE_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-105), VerticalAnchor.aboveBottom(105)))));

    public static final RegistryObject<PlacedFeature> ACACIA_WOOD_PIECE_ORE_PLACED = PLACED_FEATURES.register("acacia_wood_piece_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.ACACIA_WOOD_PIECE_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-105), VerticalAnchor.aboveBottom(105)))));

    public static final RegistryObject<PlacedFeature> MANGROVE_WOOD_PIECE_ORE_PLACED = PLACED_FEATURES.register("mangrove_wood_piece_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MANGROVE_WOOD_PIECE_ORE.getHolder().get(),
                    commonOrePlacement(100, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-105), VerticalAnchor.aboveBottom(105)))));
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}