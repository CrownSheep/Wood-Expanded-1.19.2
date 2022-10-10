package net.crownsheep.woodexpanded.world.feature;

import com.google.common.base.Suppliers;
import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.UpwardsBranchingTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, WoodExpended.MOD_ID);
    
    public static final RegistryObject<ConfiguredFeature<?, ?>> PINE =
            CONFIGURED_FEATURES.register("pine", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.PINE_LOG.get()),
                            new StraightTrunkPlacer(5, 4, 6),
                            BlockStateProvider.simple(ModBlocks.PINE_LEAVES.get()),
                            new PineFoliagePlacer(ConstantInt.of(5), ConstantInt.of(4), ConstantInt.of(5)),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));


    public static final RegistryObject<ConfiguredFeature<?, ?>> PINE_SPAWN =
            CONFIGURED_FEATURES.register("pine_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.PINE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.PINE_CHECKED.getHolder().get())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PURPUR =
            CONFIGURED_FEATURES.register("purpur", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.PURPUR_LOG.get()),
                            new UpwardsBranchingTrunkPlacer(4, 12, 9, ConstantInt.of(7), 9, ConstantInt.of(7), ),
                            BlockStateProvider.simple(ModBlocks.PURPUR_LEAVES.get()),
                            new BushFoliagePlacer(ConstantInt.of(7), ConstantInt.of(9), 11),
                            new TwoLayersFeatureSize(1, 0, 2)).build()));


    public static final RegistryObject<ConfiguredFeature<?, ?>> PURPUR_SPAWN =
            CONFIGURED_FEATURES.register("purpur_spawn", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                            ModPlacedFeatures.PINE_CHECKED.getHolder().get(),
                            0.5F)), ModPlacedFeatures.PINE_CHECKED.getHolder().get())));


    public static final Supplier<List<OreConfiguration.TargetBlockState>> OAK_WOOD_PIECE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.OAK_WOOD_PIECE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.OAK_WOOD_PIECE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> BIRCH_WOOD_PIECE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BIRCH_WOOD_PIECE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.BIRCH_WOOD_PIECE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> SPRUCE_WOOD_PIECE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SPRUCE_WOOD_PIECE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.SPRUCE_WOOD_PIECE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> DARK_OAK_WOOD_PIECE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.DARK_OAK_WOOD_PIECE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DARK_OAK_WOOD_PIECE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> JUNGLE_WOOD_PIECE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.JUNGLE_WOOD_PIECE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.JUNGLE_WOOD_PIECE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> ACACIA_WOOD_PIECE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ACACIA_WOOD_PIECE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.ACACIA_WOOD_PIECE_ORE.get().defaultBlockState())));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> MANGROVE_WOOD_PIECE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.MANGROVE_WOOD_PIECE_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.MANGROVE_WOOD_PIECE_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> OAK_WOOD_PIECE_ORE = CONFIGURED_FEATURES.register("oak_wood_piece_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OAK_WOOD_PIECE_ORES.get(), 5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BIRCH_WOOD_PIECE_ORE = CONFIGURED_FEATURES.register("birch_wood_piece_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(BIRCH_WOOD_PIECE_ORES.get(), 5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SPRUCE_WOOD_PIECE_ORE = CONFIGURED_FEATURES.register("spruce_wood_piece_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(SPRUCE_WOOD_PIECE_ORES.get(), 5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> DARK_OAK_WOOD_PIECE_ORE = CONFIGURED_FEATURES.register("dark_oak_wood_piece_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DARK_OAK_WOOD_PIECE_ORES.get(), 5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> JUNGLE_WOOD_PIECE_ORE = CONFIGURED_FEATURES.register("jungle_wood_piece_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(JUNGLE_WOOD_PIECE_ORES.get(), 5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ACACIA_WOOD_PIECE_ORE = CONFIGURED_FEATURES.register("acacia_wood_piece_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ACACIA_WOOD_PIECE_ORES.get(), 5)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> MANGROVE_WOOD_PIECE_ORE = CONFIGURED_FEATURES.register("mangrove_wood_piece_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(MANGROVE_WOOD_PIECE_ORES.get(), 5)));


    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }
}