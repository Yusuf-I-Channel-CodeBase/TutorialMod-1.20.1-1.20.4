package io.github.realyusufismail.tutorialmod.data.tags;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.core.init.ItemInit;
import io.github.realyusufismail.tutorialmod.core.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, blockTagsProvider.contentsGetter(), TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ores
        copy(TagsInit.BlockTagsInit.ORES_EXAMPLE, TagsInit.ItemTagsInit.ORES_EXAMPLE);

        // deepslate ores
        copy(TagsInit.BlockTagsInit.DEEPSLATE_ORES_EXAMPLE, TagsInit.ItemTagsInit.DEEPSLATE_ORES_EXAMPLE);

        // storage blocks
        copy(TagsInit.BlockTagsInit.STORAGE_BLOCKS_EXAMPLE, TagsInit.ItemTagsInit.STORAGE_BLOCKS_EXAMPLE);

        // ingots
        tag(TagsInit.ItemTagsInit.INGOTS_EXAMPLE).add(ItemInit.EXAMPLE_ITEM.get());

        // scraps
        tag(TagsInit.ItemTagsInit.SCRAPS_EXAMPLE).add(ItemInit.EXAMPLE_ITEM.get());
    }
}
