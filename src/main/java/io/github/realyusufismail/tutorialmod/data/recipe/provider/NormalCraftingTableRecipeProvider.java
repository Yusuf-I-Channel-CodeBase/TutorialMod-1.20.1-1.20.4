package io.github.realyusufismail.tutorialmod.data.recipe.provider;

import io.github.realyusufismail.tutorialmod.core.init.BlockInit;
import io.github.realyusufismail.tutorialmod.core.init.ItemInit;
import io.github.realyusufismail.tutorialmod.data.recipe.MainModRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class NormalCraftingTableRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput output;

    public NormalCraftingTableRecipeProvider(DataGenerator generator, RecipeOutput output) {
        super(generator);
        this.output = output;
    }

    public void build() {
        //ShapedRecipeBuilder has to be crafted in a certain order like a sword
        //ShapelessRecipeBuilder like making an iron block. no order

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.EXAMPLE_BLOCK.get(), 1)
                .requires(ItemInit.EXAMPLE_ITEM.get(), 9)
                .unlockedBy("has_item", has(ItemInit.EXAMPLE_ITEM.get()))
                .save(output, getModId("example_item_block_recipe"));


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.SWORD.get(), 1)
                .pattern(" x ")
                .pattern(" x ")
                .pattern(" s ")
                .define('s', Items.STICK)
                .define('x', ItemInit.EXAMPLE_ITEM.get())
                .unlockedBy("has_item", has(ItemInit.EXAMPLE_ITEM.get()))
                .save(output, getModId("example_item_sword_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.PICKAXE.get(), 1)
                .pattern("xxx")
                .pattern(" s ")
                .pattern(" s ")
                .define('x', ItemInit.EXAMPLE_ITEM.get())
                .define('s', Items.STICK)
                .unlockedBy("has_item", has(ItemInit.EXAMPLE_ITEM.get()))
                .save(output, getModId("example_item_pickaxe_recipe"));

        // armour
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.HELMET, 1)
                .pattern("xxx")
                .pattern( "x  x")
                .define('x', ItemInit.EXAMPLE_ITEM.get())
                .unlockedBy("has_item", has(ItemInit.EXAMPLE_ITEM.get()))
                .save(output, getModId("example_item_helmet_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.CHESTPLATE, 1)
                .pattern("x x")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', ItemInit.EXAMPLE_ITEM.get())
                .unlockedBy("has_item", has(ItemInit.EXAMPLE_ITEM.get()))
                .save(output, getModId("example_item_chestplate_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.LEGGINGS, 1)
                .pattern("xxx")
                .pattern("x x")
                .pattern("x x")
                .define('x', ItemInit.EXAMPLE_ITEM.get())
                .unlockedBy("has_item", has(ItemInit.EXAMPLE_ITEM.get()))
                .save(output, getModId("example_item_legging_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.BOOTS, 1)
                .pattern("x x")
                .pattern("x x")
                .define('x', ItemInit.EXAMPLE_ITEM.get())
                .unlockedBy("has_item", has(ItemInit.EXAMPLE_ITEM.get()))
                .save(output, getModId("example_item_boots_recipe"));
    }
}
