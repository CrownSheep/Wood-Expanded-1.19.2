package net.crownsheep.woodexpanded.item;

import net.crownsheep.woodexpanded.WoodExpended;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    OAK_WOOD("oak_wood", 28, new int[]{1, 2, 5, 3}, 19, SoundEvents.WOOD_PLACE,
            1F, 0F, () -> Ingredient.of(Blocks.OAK_PLANKS.asItem())),

    BIRCH_WOOD("birch_wood", 28, new int[]{1, 2, 5, 3}, 19, SoundEvents.WOOD_PLACE,
            1F, 0F, () -> Ingredient.of(Blocks.BIRCH_PLANKS.asItem())),

    SPRUCE_WOOD("spruce_wood", 28, new int[]{1, 2, 5, 3}, 19, SoundEvents.WOOD_PLACE,
            1F, 0F, () -> Ingredient.of(Blocks.SPRUCE_PLANKS.asItem())),

    DARK_OAK_WOOD("dark_oak_wood", 28, new int[]{1, 2, 5, 3}, 19, SoundEvents.WOOD_PLACE,
            1F, 0F, () -> Ingredient.of(Blocks.DARK_OAK_PLANKS.asItem())),

    JUNGLE_WOOD("jungle_wood", 28, new int[]{1, 2, 5, 3}, 19, SoundEvents.WOOD_PLACE,
            1F, 0F, () -> Ingredient.of(Blocks.JUNGLE_PLANKS.asItem())),

    ACACIA_WOOD("acacia_wood", 28, new int[]{1, 2, 5, 3}, 19, SoundEvents.WOOD_PLACE,
            1F, 0F, () -> Ingredient.of(Blocks.ACACIA_PLANKS.asItem())),

    MANGROVE_WOOD("mangrove_wood", 28, new int[]{1, 2, 5, 3}, 19, SoundEvents.WOOD_PLACE,
            1F, 0F, () -> Ingredient.of(Blocks.MANGROVE_PLANKS.asItem())),

    PINE_WOOD("pine_wood", 28, new int[]{1, 2, 5, 3}, 19, SoundEvents.WOOD_PLACE,
            1F, 0F, () -> Ingredient.of(ModBlocks.PINE_PLANKS.get().asItem()));

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ModArmorMaterials(String p_40474_, int p_40475_, int[] p_40476_, int p_40477_,
                      SoundEvent p_40478_, float p_40479_, float p_40480_, Supplier<Ingredient> p_40481_) {
        this.name = p_40474_;
        this.durabilityMultiplier = p_40475_;
        this.slotProtections = p_40476_;
        this.enchantmentValue = p_40477_;
        this.sound = p_40478_;
        this.toughness = p_40479_;
        this.knockbackResistance = p_40480_;
        this.repairIngredient = new LazyLoadedValue<>(p_40481_);
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return WoodExpended.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
