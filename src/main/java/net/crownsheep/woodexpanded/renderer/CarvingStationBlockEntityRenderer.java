package net.crownsheep.woodexpanded.renderer;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.crownsheep.woodexpanded.block.ModBlocks;
import net.crownsheep.woodexpanded.block.custom.CarvingStationBlock;
import net.crownsheep.woodexpanded.block.entity.CarvingStationBlockEntity;
import net.crownsheep.woodexpanded.item.ModItems;
import net.crownsheep.woodexpanded.screen.CarvingStationScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.CompositeModel;

public class CarvingStationBlockEntityRenderer implements BlockEntityRenderer<CarvingStationBlockEntity>
{
    public CarvingStationBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(CarvingStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        render1(pBlockEntity, pPartialTick, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay);
        render2(pBlockEntity, pPartialTick, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay);
    }

    public void render1(CarvingStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                        MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack resultStack = CarvingStationScreen.statues[CarvingStationScreen.countsta];
        pPoseStack.pushPose();
        if(CarvingStationScreen.countsta == 2) {
            pPoseStack.translate(0.3f, 0.887f, 0.4f);
        }
        if(CarvingStationScreen.countsta == 3) {
            pPoseStack.translate(0.3f, 0.92f, 0.4f);
        }
        if(CarvingStationScreen.countsta != 2 && CarvingStationScreen.countsta != 3) {
            pPoseStack.translate(0.3f, 0.875f, 0.4f);
        }
        pPoseStack.scale(0.75f, 0.75f, 0.75f);

        switch (pBlockEntity.getBlockState().getValue(CarvingStationBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Vector3f.YP.rotationDegrees(186));
            case EAST -> pPoseStack.mulPose(Vector3f.YP.rotationDegrees(96));
            case SOUTH -> pPoseStack.mulPose(Vector3f.YP.rotationDegrees(6));
            case WEST -> pPoseStack.mulPose(Vector3f.YP.rotationDegrees(276));
        }

        itemRenderer.renderStatic(resultStack, ItemTransforms.TransformType.FIXED, getLightLevel(pBlockEntity.getLevel(),
                        pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
        pPoseStack.popPose();
    }

    public void render2(CarvingStationBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                        MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack toolStack = new ItemStack(ModItems.KNIFE.get());
        pPoseStack.pushPose();
        pPoseStack.translate(0.6f, 0.71f, 0.8f);
        pPoseStack.scale(0.6f, 0.6f, 0.6f);
        pPoseStack.mulPose(Vector3f.XP.rotationDegrees(90));

        switch (pBlockEntity.getBlockState().getValue(CarvingStationBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(59));
            case EAST -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(149));
            case SOUTH -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(239));
            case WEST -> pPoseStack.mulPose(Vector3f.ZP.rotationDegrees(329));
        }

        itemRenderer.renderStatic(toolStack, ItemTransforms.TransformType.FIXED, getLightLevel(pBlockEntity.getLevel(),
                        pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
