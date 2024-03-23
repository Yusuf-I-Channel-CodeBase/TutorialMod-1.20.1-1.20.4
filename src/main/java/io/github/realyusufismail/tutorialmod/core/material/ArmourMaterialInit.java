package io.github.realyusufismail.tutorialmod.core.material;

import com.mojang.serialization.Codec;
import io.github.realyusufismail.tutorialmod.core.init.ItemInit;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ArmourMaterialInit implements ArmorMaterial, StringRepresentable {
    EXAMPLE("example", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.HELMET, 10);
        map.put(ArmorItem.Type.CHESTPLATE, 10);
        map.put(ArmorItem.Type.LEGGINGS, 10);
        map.put(ArmorItem.Type.BOOTS, 10);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0f, 1.0f, () -> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ArmourMaterialInit(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionFunctionForType;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_ARMOUR_PROTECTION = Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
        map.put(ArmorItem.Type.HELMET, 13);
        map.put(ArmorItem.Type.CHESTPLATE, 15);
        map.put(ArmorItem.Type.LEGGINGS, 16);
        map.put(ArmorItem.Type.BOOTS, 11);
    });

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return HEALTH_ARMOUR_PROTECTION.get(type) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }
}
