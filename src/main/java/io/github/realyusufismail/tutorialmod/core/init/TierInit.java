package io.github.realyusufismail.tutorialmod.core.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class TierInit {
    public static SimpleTier SWORD = new SimpleTier(3, 2000, 0f, 0f, 10, TagsInit.BlockTagsInit.NEEDS_EXAMPLE, () ->
            Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));


    // Level 3 is diamond.
    // Speed needs be > 0 in order to be able to mine.
    public static SimpleTier PICKAXE = new SimpleTier(3, 2000, 3f, 0f, 10, TagsInit.BlockTagsInit.NEEDS_EXAMPLE, () ->
            Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
}
