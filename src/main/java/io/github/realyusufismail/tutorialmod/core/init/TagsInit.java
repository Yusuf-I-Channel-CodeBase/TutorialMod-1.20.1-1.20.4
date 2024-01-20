package io.github.realyusufismail.tutorialmod.core.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagsInit {

    public static class BlockTagsInit {
        // Ores
        public static TagKey<Block> ORES_EXAMPLE = BlockTags.create(createResourceLocation("ores/example_ore"));

        // Deepslate ores
        public static TagKey<Block> DEEPSLATE_ORES_EXAMPLE = BlockTags.create(createResourceLocation("deepslate_ores/example_ore"));

        // For normal blocks - storage
        public static TagKey<Block> STORAGE_BLOCKS_EXAMPLE = BlockTags.create(createResourceLocation("storage_blocks/example_block"));


        private static ResourceLocation createResourceLocation(String name) {
            return new ResourceLocation("forge", name);
        }
    }

    public static class ItemTagsInit {
        // Ores
        public static TagKey<Item> ORES_EXAMPLE = ItemTags.create(createResourceLocation("ores/example_ore"));

        // Deepslate ores
        public static TagKey<Item> DEEPSLATE_ORES_EXAMPLE = ItemTags.create(createResourceLocation("deepslate_ores/example_ore"));

        // For normal blocks - storage
        public static TagKey<Item> STORAGE_BLOCKS_EXAMPLE = ItemTags.create(createResourceLocation("storage_blocks/example_block"));

        // Items

        // ore ingot
        public static TagKey<Item> INGOTS_EXAMPLE = ItemTags.create(createResourceLocation("ingots/example"));

        // Raw ore scrap
        public static TagKey<Item> SCRAPS_EXAMPLE = ItemTags.create(createResourceLocation("scraps/example"));


        private static ResourceLocation createResourceLocation(String name) {
            return new ResourceLocation("forge", name);
        }
    }
}
