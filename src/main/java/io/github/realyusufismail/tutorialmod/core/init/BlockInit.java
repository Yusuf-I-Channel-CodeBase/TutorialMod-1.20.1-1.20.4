package io.github.realyusufismail.tutorialmod.core.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TutorialMod.MOD_ID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block", () -> new Block(Block.Properties.ofFullCopy(Blocks.STONE)));

    // Normal ores - stops gen at y 0

    public static final DeferredBlock<Block> EXAMPLE_ORE = registerBlock("example_ore", () -> new Block(Block.Properties.ofFullCopy(Blocks.IRON_ORE)));

    // Deepslate ores - starts gen at y 0
    public static final DeferredBlock<Block> DEEPSLATE_EXAMPLE_ORE = registerBlock("deepslate_example_ore", () -> new Block(Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));


    public static DeferredBlock<Block> registerBlock(
            String name, Supplier<Block> block) {
        DeferredBlock<Block> blockReg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }
}
