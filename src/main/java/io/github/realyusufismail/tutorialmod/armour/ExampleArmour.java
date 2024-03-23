package io.github.realyusufismail.tutorialmod.armour;

import io.github.realyusufismail.tutorialmod.core.material.ArmourMaterialInit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class ExampleArmour extends ArmorItem implements IItemExtension {
    public ExampleArmour(Type pType) {
        super(ArmourMaterialInit.EXAMPLE, pType, new Item.Properties());
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
            ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

            // Check if the player already has flight enabled through another means
            if (player.getAbilities().mayfly) return;

            if (player.isCreative() || player.isSpectator()) return;

            if (boots.getItem() instanceof ExampleArmour && leggings.getItem() instanceof ExampleArmour && chestplate.getItem() instanceof ExampleArmour && helmet.getItem() instanceof ExampleArmour) {
                player.getAbilities().mayfly = true;
                player.fallDistance = 0.0f;
            } else {
                player.getAbilities().mayfly = false; // Turn off flight
            }
        }
    }
}
