package net.crownsheep.woodexpanded.recipe;

import net.crownsheep.woodexpanded.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class WoodcutterRecipe extends ModSingleItemRecipe {
    public WoodcutterRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult) {
        super(ModRecipeTypes.WOODCUTTING, ModRecipeSerializer.WOODCUTTER, pId, pGroup, pIngredient, pResult);
    }

    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(Container pInv, Level pLevel) {
        return this.ingredient.test(pInv.getItem(0));
    }

    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.WOODCUTTER.get());
    }
}
