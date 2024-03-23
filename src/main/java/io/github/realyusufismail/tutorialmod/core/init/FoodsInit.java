package io.github.realyusufismail.tutorialmod.core.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodsInit {
    public static final FoodProperties HEALING_APPLE =  new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(0.3f)
            .alwaysEat()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 1)
            .build();
}
