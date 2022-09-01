package net.crownsheep.woodexpanded.recipe;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.eventbus.api.IEventBus;

public interface ModRecipeTypes<T extends Recipe<?>> {
    RecipeType<WoodcutterRecipe> WOODCUTTING = register("woodcutting");

    static <T extends Recipe<?>> net.minecraft.world.item.crafting.RecipeType<T> register(final String pIdentifier) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(pIdentifier), new RecipeType<T>() {
            public String toString() {
                return pIdentifier;
            }
        });
    }

    public static <T extends Recipe<?>> RecipeType<T> simple(final ResourceLocation name) {
        final String toString = name.toString();
        return new net.minecraft.world.item.crafting.RecipeType<T>() {
            @Override
            public String toString() {
                return toString;
            }
        };
    }
}
