package net.ottervyne.hydra.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties TITANIUM_APPLE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).alwaysEdible()
            .effect(new MobEffectInstance(MobEffects.DARKNESS, 250), 1f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 0), 0.75F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 0.80F)
            .effect(new MobEffectInstance(MobEffects.ABSORPTION, 1000, 3), 0.60F).build();
}
