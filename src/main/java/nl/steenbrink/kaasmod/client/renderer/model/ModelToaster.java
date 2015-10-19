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
    ModelRenderer Bottom;

    public ModelToaster(){
        customRenderItem = new RenderItem() {
            @Override
            public boolean shouldBob() {
                return false;
            }
        };
        customRenderItem.setRenderManager(RenderManager.instance);

        textureWidth = 64;
        textureHeight = 64;

        Bottom = new ModelRenderer(this, 0, 0);
        Bottom.addBox(0F, 0F, 0F, 16, 1, 16);
        Bottom.setRotationPoint(-8F, 23F, -8F);
        Bottom.setTextureSize(64, 64);
        Bottom.mirror = true;
        setRotation(Bottom, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Bottom.render(f5);
    }

    public void simpleRender(float f5) {
        Bottom.render(f5);
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

