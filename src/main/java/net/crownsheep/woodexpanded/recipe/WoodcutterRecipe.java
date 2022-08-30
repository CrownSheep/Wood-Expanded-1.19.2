package net.crownsheep.woodexpanded.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

public class WoodcutterRecipe extends SingleItemRecipe {
    public WoodcutterRecipe(ResourceLocation pId, String pGroup, Ingredient pIngredient, ItemStack pResult) {
        super(ModRecipeTypes.WOODCUTTER_TYPE.get(), ModRecipeSerializers.WOODCUTTER_SERIALIZER.get(), pId, pGroup, pIngredient, pResult);
    }


    /**
     * Used to check if a recipe matches current crafting inventory
     */
    public boolean matches(Container pInv, Level pLevel) {
        return this.ingredient.test(pInv.getItem(0));
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.STONECUTTER);
    }

    public static class Type implements RecipeType<WoodcutterRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "woodcutting";
    }


    public static class Serializer implements RecipeSerializer<WoodcutterRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(WoodExpended.MOD_ID, "woodcutting");

        @Override
        public WoodcutterRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            return null;
        }

        @Override
        public @Nullable WoodcutterRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            return null;
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, WoodcutterRecipe pRecipe) {

        }
    }
}