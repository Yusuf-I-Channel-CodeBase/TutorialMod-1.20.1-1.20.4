package io.github.realyusufismail.tutorialmod.core.material;

import io.github.realyusufismail.tutorialmod.core.init.ItemInit;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum CustomToolMaterial implements Tier {
    SWORD(3, 2000, 10, () -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get())),
    PICKAXE(3, 25000, 10, () -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get())),
    ;

    private final int harvestLevel;
    private final int maxUses;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    CustomToolMaterial(int harvestLevel, int maxUses, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getUses() {
        return maxUses;
    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public int getLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairMaterial.get();
    }
}
