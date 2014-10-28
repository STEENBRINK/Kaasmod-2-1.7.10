package nl.steenbrink.kaasmod.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.IIcon;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;
import org.lwjgl.opengl.GL11;

    public class ModelBarrel extends ModelBase {
        private final RenderItem customRenderItem;
        private ModelRenderer TopFront;
        private ModelRenderer TopLeft;
        private ModelRenderer TopBack;
        private ModelRenderer VeryBottom;
        private ModelRenderer BottomInside;
        private ModelRenderer SideFront;
        private ModelRenderer SideBack;
        private ModelRenderer SideRight;
        private ModelRenderer SideLeft;
        private ModelRenderer TopRight;

        public ModelBarrel() {
            customRenderItem = new RenderItem() {
                @Override
                public boolean shouldBob() {
                    return false;
                }
            };
            customRenderItem.setRenderManager(RenderManager.instance);

            textureWidth = 64;
            textureHeight = 64;

            TopFront = new ModelRenderer(this, 34, 62);
            TopFront.addBox(0F, 0F, 0F, 14, 1, 1);
            TopFront.setRotationPoint(-7F, 8F, -7F);
            TopFront.setTextureSize(64, 64);
            TopFront.mirror = true;
            setRotation(TopFront, 0F, 0F, 0F);
            TopLeft = new ModelRenderer(this, 0, 51);
            TopLeft.addBox(0F, 0F, 0F, 1, 1, 12);
            TopLeft.setRotationPoint(6F, 8F, -6F);
            TopLeft.setTextureSize(64, 64);
            TopLeft.mirror = true;
            setRotation(TopLeft, 0F, 0F, 0F);
            TopBack = new ModelRenderer(this, 34, 62);
            TopBack.addBox(0F, 0F, 0F, 14, 1, 1);
            TopBack.setRotationPoint(-7F, 8F, 6F);
            TopBack.setTextureSize(64, 64);
            TopBack.mirror = true;
            setRotation(TopBack, 0F, 0F, 0F);
            VeryBottom = new ModelRenderer(this, 0, 0);
            VeryBottom.addBox(0F, 0F, 0F, 12, 1, 12);
            VeryBottom.setRotationPoint(-6F, 23F, -6F);
            VeryBottom.setTextureSize(64, 64);
            VeryBottom.mirror = true;
            setRotation(VeryBottom, 0F, 0F, 0F);
            BottomInside = new ModelRenderer(this, 0, 13);
            BottomInside.addBox(0F, 0F, 0F, 14, 1, 14);
            BottomInside.setRotationPoint(-7F, 22F, -7F);
            BottomInside.setTextureSize(64, 64);
            BottomInside.mirror = true;
            setRotation(BottomInside, 0F, 0F, 0F);
            SideFront = new ModelRenderer(this, 0, 28);
            SideFront.addBox(0F, 0F, 0F, 16, 13, 1);
            SideFront.setRotationPoint(-8F, 9F, -8F);
            SideFront.setTextureSize(64, 64);
            SideFront.mirror = true;
            setRotation(SideFront, 0F, 0F, 0F);
            SideBack = new ModelRenderer(this, 0, 28);
            SideBack.addBox(0F, 0F, 0F, 16, 13, 1);
            SideBack.setRotationPoint(-8F, 9F, 7F);
            SideBack.setTextureSize(64, 64);
            SideBack.mirror = true;
            setRotation(SideBack, 0F, 0F, 0F);
            SideRight = new ModelRenderer(this, 34, 28);
            SideRight.addBox(0F, 0F, 0F, 1, 13, 14);
            SideRight.setRotationPoint(-8F, 9F, -7F);
            SideRight.setTextureSize(64, 64);
            SideRight.mirror = true;
            setRotation(SideRight, 0F, 0F, 0F);
            SideLeft = new ModelRenderer(this, 34, 28);
            SideLeft.addBox(0F, 0F, 0F, 1, 13, 14);
            SideLeft.setRotationPoint(7F, 9F, -7F);
            SideLeft.setTextureSize(64, 64);
            SideLeft.mirror = true;
            setRotation(SideLeft, 0F, 0F, 0F);
            TopRight = new ModelRenderer(this, 0, 51);
            TopRight.addBox(0F, 0F, 0F, 1, 1, 12);
            TopRight.setRotationPoint(-7F, 8F, -6F);
            TopRight.setTextureSize(64, 64);
            TopRight.mirror = true;
            setRotation(TopRight, 0F, 0F, 0F);
        }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        TopFront.render(f5);
        TopLeft.render(f5);
        TopBack.render(f5);
        VeryBottom.render(f5);
        BottomInside.render(f5);
        SideFront.render(f5);
        SideBack.render(f5);
        SideRight.render(f5);
        SideLeft.render(f5);
        TopRight.render(f5);
    }

    public void simpleRender(float f5){
        TopFront.render(f5);
        TopLeft.render(f5);
        TopBack.render(f5);
        VeryBottom.render(f5);
        BottomInside.render(f5);
        SideFront.render(f5);
        SideBack.render(f5);
        SideRight.render(f5);
        SideLeft.render(f5);
        TopRight.render(f5);
    }

    public void renderInternal(int color, IIcon icon)
    {
        Tessellator tessellator = Tessellator.instance;

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        double length = 1.0D;
        double width = 1.0D;
        double x = 0 - width/2;
        double y = 0;
        double z = 0 - length/2;

        double minU = (double)icon.getMinU();
        double maxU = (double)icon.getMaxU();
        double minV = (double)icon.getMinV();
        double maxV = (double)icon.getMaxV();

        tessellator.startDrawingQuads();
        tessellator.setColorRGBA_F((float) (color >> 24 & 255) / 255.0F, (float) (color >> 16 & 255) / 255.0F, (float) (color >> 8 & 255) / 255.0F, (float) (color & 255) / 255.0F);
        tessellator.addVertexWithUV(x + width, y, z + length, minU, minV);
        tessellator.addVertexWithUV(x + width, y, z, minU, maxV);
        tessellator.addVertexWithUV(x , y, z, maxU, maxV);
        tessellator.addVertexWithUV(x, y, z + length, maxU, minV);
        tessellator.draw();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
    }

    public void renderItem(TileEntityBarrel tileEntityBarrel, double x, double y, double z) {
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        float scaleFactor = 1f;
        float speedMultiplier = 1f;
        if (tileEntityBarrel.isCrafting())
            speedMultiplier = 4f;
        float rotationAngle = (float) (720.0 * speedMultiplier * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

        EntityItem ghostEntityItem = new EntityItem(tileEntityBarrel.getWorldObj());
        ghostEntityItem.hoverStart = 0.0F;
        ghostEntityItem.setEntityItemStack(tileEntityBarrel.getStackInSlot(0));

        GL11.glTranslatef((float) x + 0.5f, (float) y + 0.5f, (float) z + 0.5f);
        GL11.glScalef(scaleFactor, scaleFactor, scaleFactor);
        GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);

        customRenderItem.doRender(ghostEntityItem, 0, 0, 0, 0, 0);

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
    }


    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
