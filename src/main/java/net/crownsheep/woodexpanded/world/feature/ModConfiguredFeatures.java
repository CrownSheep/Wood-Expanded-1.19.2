package net.crownsheep.woodexpanded.world.feature;

import com.google.common.base.Suppliers;
import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, WoodExpended.MOD_ID);
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> PINE_TREE =
            FeatureUtils.register("pine", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.PINE_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocks.PINE_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> PINE_CHECKED = PlacementUtils.register("pine_checked", PINE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.PINE_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PINE_SPAWN =
            FeatureUtils.register("pine_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PINE_CHECKED,
                            0.5F)), PINE_CHECKED));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}