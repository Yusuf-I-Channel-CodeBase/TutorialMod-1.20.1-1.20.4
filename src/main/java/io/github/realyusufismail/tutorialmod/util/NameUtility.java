package io.github.realyusufismail.tutorialmod.util;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class NameUtility {

    public static String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(TutorialMod.MOD_ID + ":", "");
    }
}
