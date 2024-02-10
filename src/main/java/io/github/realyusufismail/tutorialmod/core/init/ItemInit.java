package io.github.realyusufismail.tutorialmod.core.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.core.material.CustomToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_EXAMPLE = ITEMS.register("raw_example", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SWORD = ITEMS.register("sword", () -> new SwordItem(CustomToolMaterial.SWORD, 8, -2.6f, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> PICKAXE = ITEMS.register("pickaxe", () -> new PickaxeItem(CustomToolMaterial.PICKAXE, 5, -2.6f, new Item.Properties().stacksTo(1)));
}
