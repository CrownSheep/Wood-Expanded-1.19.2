package net.crownsheep.woodexpanded.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.crownsheep.woodexpanded.entity.SeatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class SeatRenderer extends EntityRenderer<Entity>
{
    public SeatRenderer(EntityRendererProvider.Context context)
    {
        super(context);
        this.shadowRadius = 0.0f;
    }

    @Override
    public ResourceLocation getTextureLocation(Entity pEntity) {
        return null;
    }
}
