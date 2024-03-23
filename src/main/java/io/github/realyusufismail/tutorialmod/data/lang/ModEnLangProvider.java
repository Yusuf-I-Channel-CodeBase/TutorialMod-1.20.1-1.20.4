package io.github.realyusufismail.tutorialmod.data.lang;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.core.init.BlockInit;
import io.github.realyusufismail.tutorialmod.core.init.CreativeModeTabInit;
import io.github.realyusufismail.tutorialmod.core.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnLangProvider extends LanguageProvider {
    public ModEnLangProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        // items
        addItem(ItemInit.EXAMPLE_ITEM, "Example Item");
        addItem(ItemInit.RAW_EXAMPLE, "Raw Example");

        addItem(ItemInit.HELMET, "Helmet");
        addItem(ItemInit.CHESTPLATE, "Chestplate");
        addItem(ItemInit.LEGGINGS, "Leggings");
        addItem(ItemInit.BOOTS, "Boots");


        // blocks
        addBlock(BlockInit.EXAMPLE_BLOCK, "Example Block");
        addBlock(BlockInit.EXAMPLE_ORE, "Example Ore");
        addBlock(BlockInit.DEEPSLATE_EXAMPLE_ORE, "Deepslate Example Ore");

        // tools
        addItem(ItemInit.SWORD, "Sword");
        addItem(ItemInit.PICKAXE, "Pickaxe");

        // others
        add(CreativeModeTabInit.TUTORIAL_MOD_TAB_TITLE, "Tutorial Mod");
    }
}
