package net.crownsheep.woodexpanded.recipe;

import com.google.gson.JsonObject;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;

public interface ModRecipeSerializer<T extends Recipe<?>> extends net.minecraftforge.common.extensions.IForgeRecipeSerializer<T> {
    RecipeSerializer<WoodcutterRecipe> WOODCUTTER = register("woodcutting", new SingleItemRecipe.Serializer<>());

    //Forge: use fromJson with IContext if you need the context
    T fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe);

    @org.jetbrains.annotations.Nullable
    T fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer);

    void toNetwork(FriendlyByteBuf pBuffer, T pRecipe);

    static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String pKey, S pRecipeSerializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, pKey, pRecipeSerializer);
    }
}

