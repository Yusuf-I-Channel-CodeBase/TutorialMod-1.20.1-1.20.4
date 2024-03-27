package io.github.realyusufismail.tutorialmod.worldgen;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomesModifiers {
    protected static ResourceKey<BiomeModifier> ADD_EXAMPLE_ORE = registerKey("add_example_ore");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
                ADD_EXAMPLE_ORE,
                new BiomeModifiers.AddFeaturesBiomeModifier(
                        biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                        HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.EXAMPLE_ORE)),
                        GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(
                NeoForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(TutorialMod.MOD_ID, name));
    }
}