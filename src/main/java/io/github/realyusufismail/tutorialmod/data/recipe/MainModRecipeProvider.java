package io.github.realyusufismail.tutorialmod.data.recipe;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.data.recipe.provider.FurnaceRecipeProvider;
import io.github.realyusufismail.tutorialmod.data.recipe.provider.NormalCraftingTableRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;

import java.util.concurrent.CompletableFuture;

public class MainModRecipeProvider extends RecipeProvider {
    protected final DataGenerator generator;

    public MainModRecipeProvider(DataGenerator generator) {
        super(generator.getPackOutput());
        this.generator = generator;
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        new NormalCraftingTableRecipeProvider(generator, recipeOutput).build();
        new FurnaceRecipeProvider(generator, recipeOutput).build();
    }

    public ResourceLocation getModId(String path) {
        return new ResourceLocation(TutorialMod.MOD_ID, path);
    }
}
