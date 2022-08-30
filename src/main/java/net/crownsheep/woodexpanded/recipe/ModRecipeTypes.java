package net.crownsheep.woodexpanded.recipe;

import net.crownsheep.woodexpanded.WoodExpended;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, WoodExpended.MOD_ID);

    public static final RegistryObject<RecipeType<WoodcutterRecipe>> WOODCUTTER_TYPE =
            TYPES.register("woodcutter_type", () -> WoodcutterRecipe.Type.INSTANCE);

    public static void register(IEventBus eventBus) {
        TYPES.register(eventBus);
    }
}
