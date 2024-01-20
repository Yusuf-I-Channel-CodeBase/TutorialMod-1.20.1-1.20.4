package io.github.realyusufismail.tutorialmod.data.tags;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.core.init.BlockInit;
import io.github.realyusufismail.tutorialmod.core.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ores
        tag(TagsInit.BlockTagsInit.ORES_EXAMPLE).add(BlockInit.EXAMPLE_ORE.get());

        // deepslate ores
        tag(TagsInit.BlockTagsInit.DEEPSLATE_ORES_EXAMPLE).add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get());

        // storage blocks
        tag(TagsInit.BlockTagsInit.STORAGE_BLOCKS_EXAMPLE).add(BlockInit.EXAMPLE_BLOCK.get());

        //        TagKey<Block> goldTags = createForgeTag("forge:needs_gold_tool");
        //        TagKey<Block> netheriteTags = createForgeTag("forge:needs_netherite_tool");
        //        TagKey<Block> woodTags = createForgeTag("forge:needs_wood_tool");

        /// tags allowing the mining of the ores
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.EXAMPLE_ORE.get())
                .add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get())
                .add(BlockInit.EXAMPLE_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.EXAMPLE_ORE.get())
                .add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get())
                .add(BlockInit.EXAMPLE_BLOCK.get());
    }

    private static TagKey<Block> createForgeTag(String name) {
        return BlockTags.create(new ResourceLocation(name));
    }
}
