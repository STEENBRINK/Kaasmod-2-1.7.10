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
import nl.steenbrink.kaasmod.tileentity.TileEntityStirlingMachine;
import org.lwjgl.opengl.GL11;

public class ModelStirlingMachine extends ModelBase
{
    private final RenderItem customRenderItem;
    private ModelRenderer KnifeBaseBottom;
    private ModelRenderer KnifeHolder;
    private ModelRenderer Knife1;
    private ModelRenderer Knife2;
    private ModelRenderer Knife3;
    private ModelRenderer Knife4;
    private ModelRenderer Knife5;
    private ModelRenderer Knife6;
    private ModelRenderer Knife7;
    private ModelRenderer Knife8;
    private ModelRenderer Knife9;
    private ModelRenderer Knife10;
    private ModelRenderer Knife11;
    private ModelRenderer Knife12;
    private ModelRenderer Knife13;
    private ModelRenderer Knife14;
    private ModelRenderer Knife15;
    private ModelRenderer Knife16;
    private ModelRenderer Knife17;
    private ModelRenderer Knife18;
    private ModelRenderer Knife19;
    private ModelRenderer Knife20;
    private ModelRenderer Knife21;
    private ModelRenderer Knife22;
    private ModelRenderer Knife23;
    private ModelRenderer Knife24;
    private ModelRenderer Knife25;
    private ModelRenderer BottomLeft;
    private ModelRenderer VeryBottom;
    private ModelRenderer Front;
    private ModelRenderer Back;
    private ModelRenderer Left;
    private ModelRenderer Right;
    private ModelRenderer KnifeBaseTop;
    private ModelRenderer BaseLeft;
    private ModelRenderer BaseRight;

    public ModelStirlingMachine() {
        customRenderItem = new RenderItem() {
            @Override
            public boolean shouldBob() {
                return false;
            }
        };
        customRenderItem.setRenderManager(RenderManager.instance);

        textureWidth = 64;
        textureHeight = 64;

        KnifeBaseBottom = new ModelRenderer(this, 0, 53);
        KnifeBaseBottom.addBox(0F, 0F, 0F, 1, 4, 1);
        KnifeBaseBottom.setRotationPoint(-0.5F, 11F, -0.5F);
        KnifeBaseBottom.setTextureSize(64, 32);
        KnifeBaseBottom.mirror = true;
        setRotation(KnifeBaseBottom, 0F, 0F, 0F);
        KnifeHolder = new ModelRenderer(this, 0, 52);
        KnifeHolder.addBox(0F, 0F, 0F, 12, 0, 1);
        KnifeHolder.setRotationPoint(-6F, 14.5F, -0.5F);
        KnifeHolder.setTextureSize(64, 32);
        KnifeHolder.mirror = true;
        setRotation(KnifeHolder, 0F, 0F, 0F);
        Knife1 = new ModelRenderer(this, 16, 52);
        Knife1.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife1.setRotationPoint(6F, 14.5F, -0.5F);
        Knife1.setTextureSize(64, 32);
        Knife1.mirror = true;
        setRotation(Knife1, 0F, 0F, 0F);
        Knife2 = new ModelRenderer(this, 16, 52);
        Knife2.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife2.setRotationPoint(5.5F, 14.5F, -0.5F);
        Knife2.setTextureSize(64, 32);
        Knife2.mirror = true;
        setRotation(Knife2, 0F, 0F, 0F);
        Knife3 = new ModelRenderer(this, 16, 52);
        Knife3.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife3.setRotationPoint(5F, 14.5F, -0.5F);
        Knife3.setTextureSize(64, 32);
        Knife3.mirror = true;
        setRotation(Knife3, 0F, 0F, 0F);
        Knife4 = new ModelRenderer(this, 16, 52);
        Knife4.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife4.setRotationPoint(4.5F, 14.5F, -0.5F);
        Knife4.setTextureSize(64, 32);
        Knife4.mirror = true;
        setRotation(Knife4, 0F, 0F, 0F);
        Knife5 = new ModelRenderer(this, 16, 52);
        Knife5.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife5.setRotationPoint(4F, 14.5F, -0.5F);
        Knife5.setTextureSize(64, 32);
        Knife5.mirror = true;
        setRotation(Knife5, 0F, 0F, 0F);
        Knife6 = new ModelRenderer(this, 16, 52);
        Knife6.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife6.setRotationPoint(3.5F, 14.5F, -0.5F);
        Knife6.setTextureSize(64, 32);
        Knife6.mirror = true;
        setRotation(Knife6, 0F, 0F, 0F);
        Knife7 = new ModelRenderer(this, 16, 52);
        Knife7.addBox(3F, 0F, 0F, 0, 6, 1);
        Knife7.setRotationPoint(0F, 14.5F, -0.5F);
        Knife7.setTextureSize(64, 32);
        Knife7.mirror = true;
        setRotation(Knife7, 0F, 0F, 0F);
        Knife8 = new ModelRenderer(this, 16, 52);
        Knife8.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife8.setRotationPoint(2.5F, 14.5F, -0.5F);
        Knife8.setTextureSize(64, 32);
        Knife8.mirror = true;
        setRotation(Knife8, 0F, 0F, 0F);
        Knife9 = new ModelRenderer(this, 16, 52);
        Knife9.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife9.setRotationPoint(2F, 14.5F, -0.5F);
        Knife9.setTextureSize(64, 32);
        Knife9.mirror = true;
        setRotation(Knife9, 0F, 0F, 0F);
        Knife10 = new ModelRenderer(this, 16, 52);
        Knife10.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife10.setRotationPoint(1.5F, 14.5F, -0.5F);
        Knife10.setTextureSize(64, 32);
        Knife10.mirror = true;
        setRotation(Knife10, 0F, 0F, 0F);
        Knife11 = new ModelRenderer(this, 16, 52);
        Knife11.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife11.setRotationPoint(1F, 14.5F, -0.5F);
        Knife11.setTextureSize(64, 32);
        Knife11.mirror = true;
        setRotation(Knife11, 0F, 0F, 0F);
        Knife12 = new ModelRenderer(this, 16, 52);
        Knife12.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife12.setRotationPoint(0.5F, 14.5F, -0.5F);
        Knife12.setTextureSize(64, 32);
        Knife12.mirror = true;
        setRotation(Knife12, 0F, 0F, 0F);
        Knife13 = new ModelRenderer(this, 16, 52);
        Knife13.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife13.setRotationPoint(0F, 14.5F, -0.5F);
        Knife13.setTextureSize(64, 32);
        Knife13.mirror = true;
        setRotation(Knife13, 0F, 0F, 0F);
        Knife14 = new ModelRenderer(this, 16, 52);
        Knife14.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife14.setRotationPoint(-0.5F, 14.5F, -0.5F);
        Knife14.setTextureSize(64, 32);
        Knife14.mirror = true;
        setRotation(Knife14, 0F, 0F, 0F);
        Knife15 = new ModelRenderer(this, 16, 52);
        Knife15.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife15.setRotationPoint(-1F, 14.5F, -0.5F);
        Knife15.setTextureSize(64, 32);
        Knife15.mirror = true;
        setRotation(Knife15, 0F, 0F, 0F);
        Knife16 = new ModelRenderer(this, 16, 52);
        Knife16.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife16.setRotationPoint(-1.5F, 14.5F, -0.5F);
        Knife16.setTextureSize(64, 32);
        Knife16.mirror = true;
        setRotation(Knife16, 0F, 0F, 0F);
        Knife17 = new ModelRenderer(this, 16, 52);
        Knife17.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife17.setRotationPoint(-2F, 14.5F, -0.5F);
        Knife17.setTextureSize(64, 32);
        Knife17.mirror = true;
        setRotation(Knife17, 0F, 0F, 0F);
        Knife18 = new ModelRenderer(this, 16, 52);
        Knife18.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife18.setRotationPoint(-2.5F, 14.5F, -0.5F);
        Knife18.setTextureSize(64, 32);
        Knife18.mirror = true;
        setRotation(Knife18, 0F, 0F, 0F);
        Knife19 = new ModelRenderer(this, 16, 52);
        Knife19.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife19.setRotationPoint(-3F, 14.5F, -0.5F);
        Knife19.setTextureSize(64, 32);
        Knife19.mirror = true;
        setRotation(Knife19, 0F, 0F, 0F);
        Knife20 = new ModelRenderer(this, 16, 52);
        Knife20.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife20.setRotationPoint(-3.5F, 14.5F, -0.5F);
        Knife20.setTextureSize(64, 32);
        Knife20.mirror = true;
        setRotation(Knife20, 0F, 0F, 0F);
        Knife21 = new ModelRenderer(this, 16, 52);
        Knife21.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife21.setRotationPoint(-4F, 14.5F, -0.5F);
        Knife21.setTextureSize(64, 32);
        Knife21.mirror = true;
        setRotation(Knife21, 0F, 0F, 0F);
        Knife22 = new ModelRenderer(this, 16, 52);
        Knife22.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife22.setRotationPoint(-4.5F, 14.5F, -0.5F);
        Knife22.setTextureSize(64, 32);
        Knife22.mirror = true;
        setRotation(Knife22, 0F, 0F, 0F);
        Knife23 = new ModelRenderer(this, 16, 52);
        Knife23.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife23.setRotationPoint(-5F, 14.5F, -0.5F);
        Knife23.setTextureSize(64, 32);
        Knife23.mirror = true;
        setRotation(Knife23, 0F, 0F, 0F);
        Knife24 = new ModelRenderer(this, 16, 52);
        Knife24.addBox(0F, 0F, 0F, 0, 5, 1);
        Knife24.setRotationPoint(-5.5F, 14.5F, -0.5F);
        Knife24.setTextureSize(64, 32);
        Knife24.mirror = true;
        setRotation(Knife24, 0F, 0F, 0F);
        Knife25 = new ModelRenderer(this, 16, 52);
        Knife25.addBox(0F, 0F, 0F, 0, 6, 1);
        Knife25.setRotationPoint(-6F, 14.5F, -0.5F);
        Knife25.setTextureSize(64, 32);
        Knife25.mirror = true;
        setRotation(Knife25, 0F, 0F, 0F);
        BottomLeft = new ModelRenderer(this, 0, 13);
        BottomLeft.addBox(0F, 0F, 0F, 14, 1, 14);
        BottomLeft.setRotationPoint(-7F, 22F, -7F);
        BottomLeft.setTextureSize(64, 32);
        BottomLeft.mirror = true;
        setRotation(BottomLeft, 0F, 0F, 0F);
        VeryBottom = new ModelRenderer(this, 0, 0);
        VeryBottom.addBox(0F, 0F, 0F, 12, 1, 12);
        VeryBottom.setRotationPoint(-6F, 23F, -6F);
        VeryBottom.setTextureSize(64, 32);
        VeryBottom.mirror = true;
        setRotation(VeryBottom, 0F, 0F, 0F);
        Front = new ModelRenderer(this, 0, 28);
        Front.addBox(0F, 0F, 0F, 16, 8, 1);
        Front.setRotationPoint(-8F, 14F, -8F);
        Front.setTextureSize(64, 32);
        Front.mirror = true;
        setRotation(Front, 0F, 0F, 0F);
        Back = new ModelRenderer(this, 0, 28);
        Back.addBox(0F, 0F, 0F, 16, 8, 1);
        Back.setRotationPoint(-8F, 14F, 7F);
        Back.setTextureSize(64, 32);
        Back.mirror = true;
        setRotation(Back, 0F, 0F, 0F);
        Left = new ModelRenderer(this, 34, 28);
        Left.addBox(0F, 0F, 0F, 1, 8, 14);
        Left.setRotationPoint(-8F, 14F, -7F);
        Left.setTextureSize(64, 32);
        Left.mirror = true;
        setRotation(Left, 0F, 0F, 0F);
        Right = new ModelRenderer(this, 34, 28);
        Right.addBox(0F, 0F, 0F, 1, 8, 14);
        Right.setRotationPoint(7F, 14F, -7F);
        Right.setTextureSize(64, 32);
        Right.mirror = true;
        setRotation(Right, 0F, 0F, 0F);
        KnifeBaseTop = new ModelRenderer(this, 0, 0);
        KnifeBaseTop.addBox(0F, 0F, 0F, 1, 3, 1);
        KnifeBaseTop.setRotationPoint(-0.5F, 8F, -0.5F);
        KnifeBaseTop.setTextureSize(64, 32);
        KnifeBaseTop.mirror = true;
        setRotation(KnifeBaseTop, 0F, 0F, 0F);
        BaseLeft = new ModelRenderer(this, 0, 37);
        BaseLeft.addBox(0F, 0F, 0F, 1, 10, 1);
        BaseLeft.setRotationPoint(0F, 8F, -0.5F);
        BaseLeft.setTextureSize(64, 32);
        BaseLeft.mirror = true;
        setRotation(BaseLeft, 0F, 0F, 0.9272934F);
        BaseRight = new ModelRenderer(this, 0, 37);
        BaseRight.addBox(-1F, 0F, 0F, 1, 10, 1);
        BaseRight.setRotationPoint(0F, 8F, -0.5F);
        BaseRight.setTextureSize(64, 32);
        BaseRight.mirror = true;
        setRotation(BaseRight, 0F, 0F, -0.9272934F);
    }
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
      super.render(entity, f, f1, f2, f3, f4, f5);
      setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      KnifeBaseBottom.render(f5);
      KnifeHolder.render(f5);
      Knife1.render(f5);
      Knife2.render(f5);
      Knife3.render(f5);
      Knife4.render(f5);
      Knife5.render(f5);
      Knife6.render(f5);
      Knife7.render(f5);
      Knife8.render(f5);
      Knife9.render(f5);
      Knife10.render(f5);
      Knife11.render(f5);
      Knife12.render(f5);
      Knife13.render(f5);
      Knife14.render(f5);
      Knife15.render(f5);
      Knife16.render(f5);
      Knife17.render(f5);
      Knife18.render(f5);
      Knife19.render(f5);
      Knife20.render(f5);
      Knife21.render(f5);
      Knife22.render(f5);
      Knife23.render(f5);
      Knife24.render(f5);
      Knife25.render(f5);
      BottomLeft.render(f5);
      VeryBottom.render(f5);
      Front.render(f5);
      Back.render(f5);
      Left.render(f5);
      Right.render(f5);
      KnifeBaseTop.render(f5);
      BaseLeft.render(f5);
      BaseRight.render(f5);
    }

    public void simpleRender(float f5){
      KnifeBaseBottom.render(f5);
      KnifeHolder.render(f5);
      Knife1.render(f5);
      Knife2.render(f5);
      Knife3.render(f5);
      Knife4.render(f5);
      Knife5.render(f5);
      Knife6.render(f5);
      Knife7.render(f5);
      Knife8.render(f5);
      Knife9.render(f5);
      Knife10.render(f5);
      Knife11.render(f5);
      Knife12.render(f5);
      Knife13.render(f5);
      Knife14.render(f5);
      Knife15.render(f5);
      Knife16.render(f5);
      Knife17.render(f5);
      Knife18.render(f5);
      Knife19.render(f5);
      Knife20.render(f5);
      Knife21.render(f5);
      Knife22.render(f5);
      Knife23.render(f5);
      Knife24.render(f5);
      Knife25.render(f5);
      BottomLeft.render(f5);
      VeryBottom.render(f5);
      Front.render(f5);
      Back.render(f5);
      Left.render(f5);
      Right.render(f5);
      KnifeBaseTop.render(f5);
      BaseLeft.render(f5);
      BaseRight.render(f5);
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
