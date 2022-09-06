package net.crownsheep.woodexpanded.effect.custom;

import net.crownsheep.woodexpanded.item.ModCreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WoodChipsEffect extends MobEffect {
    public WoodChipsEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }

    public static boolean landed;
    public static boolean alreadylanded;

    public static float damage;

    public static float oldfalldistance;



    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if(pLivingEntity.isOnGround()) {
            if(!alreadylanded) {
                damage = Math.round(oldfalldistance) * 0.22f;
                pLivingEntity.hurt(new DamageSource("wood_chips"), damage);
                landed = true;
            }
            if(alreadylanded) {
                landed = false;
            }
            alreadylanded = true;
        }

        if(!pLivingEntity.isOnGround()) {
            oldfalldistance = pLivingEntity.fallDistance;
            landed = false;
            alreadylanded = false;
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}
