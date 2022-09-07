package net.crownsheep.woodexpanded.world.feature;

import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, WoodExpended.MOD_ID);


    public static final RegistryObject<PlacedFeature> PINE_PLACED = PLACED_FEATURES.register("pine_placed",
            () -> new PlacedFeature((Holder<ConfiguredFeature<?,?>>)(Holder<? extends ConfiguredFeature<?,?>>)
                    ModConfiguredFeatures.PINE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.1f, 2))));

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }
}