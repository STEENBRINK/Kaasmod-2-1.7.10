package nl.steenbrink.kaasmod.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.IIcon;
import nl.steenbrink.kaasmod.tileentity.TileEntitiyToaster;
import org.lwjgl.opengl.GL11;

public class ModelToaster extends ModelBase
{
    //fields
    private final RenderItem customRenderItem;

    ModelRenderer BottomBack;
    ModelRenderer BottomPlate;
    ModelRenderer BottomFront;
    ModelRenderer Turnpoint;
    ModelRenderer TopPlate;
    ModelRenderer HolderLeft;
    ModelRenderer HolderRight;
    ModelRenderer Holder;

    public ModelToaster(){
        customRenderItem = new RenderItem() {
            @Override
            public boolean shouldBob() {
                return false;
            }
        };
        customRenderItem.setRenderManager(RenderManager.instance);

        textureWidth = 64;
        textureHeight = 32;

        BottomBack = new ModelRenderer(this, 0, 0);
        BottomBack.addBox(0F, 0F, 0F, 12, 1, 1);
        BottomBack.setRotationPoint(-6F, 23F, 5F);
        BottomBack.setTextureSize(64, 32);
        BottomBack.mirror = true;
        setRotation(BottomBack, 0F, 0F, 0F);
        BottomPlate = new ModelRenderer(this, 0, 17);
        BottomPlate.addBox(0F, 0F, 0F, 14, 1, 14);
        BottomPlate.setRotationPoint(-7F, 22F, -7F);
        BottomPlate.setTextureSize(64, 32);
        BottomPlate.mirror = true;
        setRotation(BottomPlate, 0F, 0F, 0F);
        BottomFront = new ModelRenderer(this, 0, 0);
        BottomFront.addBox(0F, 0F, 0F, 12, 1, 1);
        BottomFront.setRotationPoint(-6F, 23F, -6F);
        BottomFront.setTextureSize(64, 32);
        BottomFront.mirror = true;
        setRotation(BottomFront, 0F, 0F, 0F);
        Turnpoint = new ModelRenderer(this, 0, 0);
        Turnpoint.addBox(0F, 0F, 0F, 12, 1, 1);
        Turnpoint.setRotationPoint(-6F, 21F, 7F);
        Turnpoint.setTextureSize(64, 32);
        Turnpoint.mirror = true;
        setRotation(Turnpoint, 0F, 0F, 0F);
        TopPlate = new ModelRenderer(this, 0, 17);
        TopPlate.addBox(0F, 0F, 0F, 14, 1, 14);
        TopPlate.setRotationPoint(-7F, 20F, -7F);
        TopPlate.setTextureSize(64, 32);
        TopPlate.mirror = true;
        setRotation(TopPlate, 0F, 0F, 0F);
        HolderLeft = new ModelRenderer(this, 0, 0);
        HolderLeft.addBox(0F, 0F, 0F, 1, 1, 1);
        HolderLeft.setRotationPoint(-5F, 19F, -5F);
        HolderLeft.setTextureSize(64, 32);
        HolderLeft.mirror = true;
        setRotation(HolderLeft, 0F, 0F, 0F);
        HolderRight = new ModelRenderer(this, 0, 0);
        HolderRight.addBox(0F, 0F, 0F, 1, 1, 1);
        HolderRight.setRotationPoint(4F, 19F, -5F);
        HolderRight.setTextureSize(64, 32);
        HolderRight.mirror = true;
        setRotation(HolderRight, 0F, 0F, 0F);
        Holder = new ModelRenderer(this, 0, 0);
        Holder.addBox(0F, 0F, 0F, 12, 1, 1);
        Holder.setRotationPoint(-6F, 18F, -5F);
        Holder.setTextureSize(64, 32);
        Holder.mirror = true;
        setRotation(Holder, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        BottomBack.render(f5);
        BottomPlate.render(f5);
        BottomFront.render(f5);
        Turnpoint.render(f5);
        TopPlate.render(f5);
        HolderLeft.render(f5);
        HolderRight.render(f5);
        Holder.render(f5);
    }

    public void simpleRender(float f5) {
        BottomBack.render(f5);
        BottomPlate.render(f5);
        BottomFront.render(f5);
        Turnpoint.render(f5);
        TopPlate.render(f5);
        HolderLeft.render(f5);
        HolderRight.render(f5);
        Holder.render(f5);
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

    public void renderItem(TileEntitiyToaster tileEntityToaster, double x, double y, double z) {
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        float scaleFactor = 1f;
        float speedMultiplier = 1f;
        if (tileEntityToaster.isCrafting())
            speedMultiplier = 4f;
        float rotationAngle = (float) (720.0 * speedMultiplier * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);

        EntityItem ghostEntityItem = new EntityItem(tileEntityToaster.getWorldObj());
        ghostEntityItem.hoverStart = 0.0F;
        ghostEntityItem.setEntityItemStack(tileEntityToaster.getStackInSlot(0));

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

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

}

