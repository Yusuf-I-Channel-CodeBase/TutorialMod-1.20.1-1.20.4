package io.github.realyusufismail.tutorialmod.data.world;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.worldgen.ModBiomesModifiers;
import io.github.realyusufismail.tutorialmod.worldgen.ModConfiguredFeatures;
import io.github.realyusufismail.tutorialmod.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,
                new RegistrySetBuilder()
                                .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap)
                                .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
                                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomesModifiers::bootstrap),
                Set.of(TutorialMod.MOD_ID));
    }
}
