package io.github.realyusufismail.tutorialmod.armour;

import io.github.realyusufismail.tutorialmod.core.material.ArmourMaterialInit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
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
        //var helmet = pSlotId == 36;
        //var chestplate = pSlotId == 37;
        //var leggings = pSlotId == 38;
        //var boots = pSlotId == 39;
        if (pEntity instanceof Player player) {
            ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
            ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);

            // check if they are not in creative mode

            if (player.isCreative()) {
                return;
            }

            if (boots.getItem() instanceof ExampleArmour && legs.getItem() instanceof ExampleArmour && chest.getItem() instanceof ExampleArmour && head.getItem() instanceof ExampleArmour) {
                player.getAbilities().mayfly = true;
                player.fallDistance = 0.0F;
            }
        }
    }
}
