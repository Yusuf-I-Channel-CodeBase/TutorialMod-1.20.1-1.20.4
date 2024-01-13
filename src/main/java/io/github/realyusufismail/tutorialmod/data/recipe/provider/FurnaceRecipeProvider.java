package io.github.realyusufismail.tutorialmod.data.recipe.provider;

import io.github.realyusufismail.tutorialmod.core.init.BlockInit;
import io.github.realyusufismail.tutorialmod.core.init.ItemInit;
import io.github.realyusufismail.tutorialmod.data.recipe.MainModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class FurnaceRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput output;

    public FurnaceRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> lookupProvider, RecipeOutput output) {
        super(generator, lookupProvider);
        this.output = output;
    }

    public void build() {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(BlockInit.EXAMPLE_BLOCK.get()), RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM.get(), 0.6f, 300)
                .unlockedBy("has_item", has(BlockInit.EXAMPLE_BLOCK.get()))
                .save(output, getModId("example_block_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(BlockInit.EXAMPLE_BLOCK.get()), RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM.get(), 0.6f, 300)
                .unlockedBy("has_item", has(BlockInit.EXAMPLE_BLOCK.get()))
                .save(output, getModId("example_block_blasting"));
    }
}
