package io.github.realyusufismail.tutorialmod.worldgen;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.netty.bootstrap.Bootstrap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    protected static ResourceKey<PlacedFeature> EXAMPLE_ORE = createKey("example_ore");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?,?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?,? >> holder =
                configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EXAMPLE_ORE);

        // 3 veins per chunk, between y -64 and 20
        register(context, EXAMPLE_ORE, holder, ModOrePlacement.commonOrePlacements(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(20))));
    }


    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(TutorialMod.MOD_ID, name));
    }


    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?,?>> feature, List<PlacementModifier> placements) {
        context.register(key, new PlacedFeature(feature, placements));
    }
}
