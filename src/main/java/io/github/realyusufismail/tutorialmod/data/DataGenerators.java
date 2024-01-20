package io.github.realyusufismail.tutorialmod.data;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.data.lang.ModEnLangProvider;
import io.github.realyusufismail.tutorialmod.data.lootable.ModLootTables;
import io.github.realyusufismail.tutorialmod.data.recipe.MainModRecipeProvider;
import io.github.realyusufismail.tutorialmod.data.tags.ModBlockTagsProvider;
import io.github.realyusufismail.tutorialmod.data.tags.ModItemTagProvider;
import io.github.realyusufismail.tutorialmod.data.texture.ModBlockStateProvider;
import io.github.realyusufismail.tutorialmod.data.texture.ModItemStateProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {

    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = event.getGenerator().getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            generator.addProvider(true, new ModEnLangProvider(output));
            generator.addProvider(true, new ModItemStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModBlockStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModLootTables(output));
            generator.addProvider(true, new MainModRecipeProvider(generator, event.getLookupProvider()));
            ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(output, event.getLookupProvider(), existingFileHelper);
            generator.addProvider(true, blockTagsProvider);
            generator.addProvider(true, new ModItemTagProvider(output, event.getLookupProvider(), blockTagsProvider, existingFileHelper));
        } catch (RuntimeException e) {
            TutorialMod.logger.error("Failed to generate data", e);
        }
    }
}