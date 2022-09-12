package net.crownsheep.woodexpanded.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModHorseArmorItem extends Item {
    private static final String TEX_FOLDER = "textures/entity/horse/";
    private final int protection;
    private final ResourceLocation texture;

    /**
     *
     * @param pProtection the given protection level of the {@code HorseArmorItem}
     * @param pIdentifier the texture path identifier for the {@code DyeableHorseArmorItem}, {@link
     * net.minecraft.world.item.HorseArmorItem}
     * @param pProperties the item properties
     */
    public ModHorseArmorItem(int pProtection, String pIdentifier, Item.Properties pProperties) {
        this(pProtection, new ResourceLocation("woodexpanded:textures/entity/horse/armor/" + pIdentifier + "_horse_armor" + ".png"), pProperties);
    }

    /**
     *
     * @param pProtection the given protection level of the {@code HorseArmorItem}
     * @param pIdentifier the texture path identifier for the {@code DyeableHorseArmorItem}, {@link
     * net.minecraft.world.item.HorseArmorItem}
     * @param pProperties the item properties
     */
    public ModHorseArmorItem(int pProtection, ResourceLocation pIdentifier, Item.Properties pProperties) {
        super(pProperties);
        this.protection = pProtection;
        this.texture = pIdentifier;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public int getProtection() {
        return this.protection;
    }
}
