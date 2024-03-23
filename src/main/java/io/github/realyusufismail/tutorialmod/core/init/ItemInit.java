package io.github.realyusufismail.tutorialmod.core.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.armour.ExampleArmour;
import io.github.realyusufismail.tutorialmod.core.material.ArmourMaterialInit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_EXAMPLE = ITEMS.register("raw_example", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SWORD = ITEMS.register("sword", () -> new SwordItem(TierInit.SWORD, 8, -2.6f, new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> PICKAXE = ITEMS.register("pickaxe", () -> new PickaxeItem(TierInit.PICKAXE, 5, -2.6f, new Item.Properties().stacksTo(1)));

    public static DeferredItem<Item> HELMET = ITEMS.register("helmet", () -> new ExampleArmour(ArmorItem.Type.HELMET));

    public static DeferredItem<Item> CHESTPLATE = ITEMS.register("chestplate", () -> new ExampleArmour(ArmorItem.Type.CHESTPLATE));

    public static DeferredItem<Item> LEGGINGS = ITEMS.register("leggings", () -> new ExampleArmour(ArmorItem.Type.LEGGINGS));

    public static DeferredItem<Item> BOOTS = ITEMS.register("boots", () -> new ExampleArmour(ArmorItem.Type.BOOTS));

    public static DeferredItem<Item> HEALING_APPLE = ITEMS.register("healing_apple", () -> new Item(new Item.Properties().food(FoodsInit.HEALING_APPLE)));
}
