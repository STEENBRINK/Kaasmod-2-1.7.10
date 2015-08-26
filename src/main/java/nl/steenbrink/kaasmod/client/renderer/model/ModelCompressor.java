package nl.steenbrink.kaasmod.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import org.lwjgl.opengl.GL11;

public class ModelCompressor extends ModelBase{
    private final RenderItem customRenderItem;
    private ModelRenderer BottomLeft;
    private ModelRenderer VeryBottom;
    private ModelRenderer Front;
    private ModelRenderer Back;
    private ModelRenderer Left;
    private ModelRenderer Right;
    private ModelRenderer FrontBar;
    private ModelRenderer BackPiece;
    private ModelRenderer FrontPiece;
    private ModelRenderer BackStandLeft;
    private ModelRenderer BackStandRight;
    private ModelRenderer MiddleLeft;
    private ModelRenderer BackBar;
    private ModelRenderer MiddleRight;
    private ModelRenderer MiddleFront;
    private ModelRenderer MiddleBack;
    private ModelRenderer FrontStandLeft;
    private ModelRenderer FrontStandRight;
    private ModelRenderer Base;
    private ModelRenderer Handle;
    private ModelRenderer PressPlate;

    public ModelCompressor() {
        customRenderItem = new RenderItem() {
            @Override
            public boolean shouldBob() {
                return false;
            }
        };
        customRenderItem.setRenderManager(RenderManager.instance);

        textureWidth = 64;
        textureHeight = 64;

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
        Left = new ModelRenderer(this, 0, 42);
        Left.addBox(0F, 0F, 0F, 1, 8, 14);
        Left.setRotationPoint(-8F, 14F, -7F);
        Left.setTextureSize(64, 32);
        Left.mirror = true;
        setRotation(Left, 0F, 0F, 0F);
        Right = new ModelRenderer(this, 0, 42);
        Right.addBox(0F, 0F, 0F, 1, 8, 14);
        Right.setRotationPoint(7F, 14F, -7F);
        Right.setTextureSize(64, 32);
        Right.mirror = true;
        setRotation(Right, 0F, 0F, 0F);
        FrontBar = new ModelRenderer(this, 34, 28);
        FrontBar.addBox(0F, 0F, 0F, 1, 1, 7);
        FrontBar.setRotationPoint(-0.5F, 9F, -8F);
        FrontBar.setTextureSize(64, 32);
        FrontBar.mirror = true;
        setRotation(FrontBar, 0F, 0F, 0F);
        BackPiece = new ModelRenderer(this, 8, 37);
        BackPiece.addBox(0F, 0F, 0F, 4, 1, 1);
        BackPiece.setRotationPoint(-2F, 9F, 7F);
        BackPiece.setTextureSize(64, 32);
        BackPiece.mirror = true;
        setRotation(BackPiece, 0F, 0F, 0F);
        FrontPiece = new ModelRenderer(this, 8, 37);
        FrontPiece.addBox(0F, 0F, 0F, 4, 1, 1);
        FrontPiece.setRotationPoint(-2F, 9F, -8F);
        FrontPiece.setTextureSize(64, 32);
        FrontPiece.mirror = true;
        setRotation(FrontPiece, 0F, 0F, 0F);
        BackStandLeft = new ModelRenderer(this, 30, 58);
        BackStandLeft.addBox(0F, 0F, 0F, 1, 5, 1);
        BackStandLeft.setRotationPoint(-2F, 9F, 7F);
        BackStandLeft.setTextureSize(64, 32);
        BackStandLeft.mirror = true;
        setRotation(BackStandLeft, 0F, 0F, 0F);
        BackStandRight = new ModelRenderer(this, 30, 58);
        BackStandRight.addBox(0F, 0F, 0F, 1, 5, 1);
        BackStandRight.setRotationPoint(1F, 9F, 7F);
        BackStandRight.setTextureSize(64, 32);
        BackStandRight.mirror = true;
        setRotation(BackStandRight, 0F, 0F, 0F);
        MiddleLeft = new ModelRenderer(this, 30, 47);
        MiddleLeft.addBox(0F, 0F, 0F, 1, 1, 3);
        MiddleLeft.setRotationPoint(-1.5F, 9F, -1.5F);
        MiddleLeft.setTextureSize(64, 32);
        MiddleLeft.mirror = true;
        setRotation(MiddleLeft, 0F, 0F, 0F);
        BackBar = new ModelRenderer(this, 34, 28);
        BackBar.addBox(0F, 0F, 0F, 1, 1, 7);
        BackBar.setRotationPoint(-0.5F, 9F, 1F);
        BackBar.setTextureSize(64, 32);
        BackBar.mirror = true;
        setRotation(BackBar, 0F, 0F, 0F);
        MiddleRight = new ModelRenderer(this, 30, 47);
        MiddleRight.addBox(0F, 0F, 0F, 1, 1, 3);
        MiddleRight.setRotationPoint(0.5F, 9F, -1.5F);
        MiddleRight.setTextureSize(64, 32);
        MiddleRight.mirror = true;
        setRotation(MiddleRight, 0F, 0F, 0F);
        MiddleFront = new ModelRenderer(this, 0, 37);
        MiddleFront.addBox(0F, 0F, 0F, 3, 1, 1);
        MiddleFront.setRotationPoint(-1.5F, 9F, -1.5F);
        MiddleFront.setTextureSize(64, 32);
        MiddleFront.mirror = true;
        setRotation(MiddleFront, 0F, 0F, 0F);
        MiddleBack = new ModelRenderer(this, 0, 37);
        MiddleBack.addBox(0F, 0F, 0F, 3, 1, 1);
        MiddleBack.setRotationPoint(-1.5F, 9F, 0.5F);
        MiddleBack.setTextureSize(64, 32);
        MiddleBack.mirror = true;
        setRotation(MiddleBack, 0F, 0F, 0F);
        FrontStandLeft = new ModelRenderer(this, 30, 58);
        FrontStandLeft.addBox(0F, 0F, 0F, 1, 5, 1);
        FrontStandLeft.setRotationPoint(-2F, 9F, -8F);
        FrontStandLeft.setTextureSize(64, 32);
        FrontStandLeft.mirror = true;
        setRotation(FrontStandLeft, 0F, 0F, 0F);
        FrontStandRight = new ModelRenderer(this, 30, 58);
        FrontStandRight.addBox(0F, 0F, 0F, 1, 5, 1);
        FrontStandRight.setRotationPoint(1F, 9F, -8F);
        FrontStandRight.setTextureSize(64, 32);
        FrontStandRight.mirror = true;
        setRotation(FrontStandRight, 0F, 0F, 0F);
        Base = new ModelRenderer(this, 48, 0);
        Base.addBox(0F, 0F, 0F, 1, 8, 1);
        Base.setRotationPoint(-0.5F, 8F, -0.5F);
        Base.setTextureSize(64, 32);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        Handle = new ModelRenderer(this, 0, 39);
        Handle.addBox(0F, 0F, 0F, 7, 1, 1);
        Handle.setRotationPoint(-3.5F, 8F, -0.5F);
        Handle.setTextureSize(64, 32);
        Handle.mirror = true;
        setRotation(Handle, 0F, 0F, 0F);
        PressPlate = new ModelRenderer(this, 0, 13);
        PressPlate.addBox(0F, 0F, 0F, 14, 1, 14);
        PressPlate.setRotationPoint(-7F, 16F, -7F);
        PressPlate.setTextureSize(64, 32);
        PressPlate.mirror = true;
        setRotation(PressPlate, 0.0174533F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        BottomLeft.render(f5);
        VeryBottom.render(f5);
        Front.render(f5);
        Back.render(f5);
        Left.render(f5);
        Right.render(f5);
        FrontBar.render(f5);
        BackPiece.render(f5);
        FrontPiece.render(f5);
        BackStandLeft.render(f5);
        BackStandRight.render(f5);
        MiddleLeft.render(f5);
        BackBar.render(f5);
        MiddleRight.render(f5);
        MiddleFront.render(f5);
        MiddleBack.render(f5);
        FrontStandLeft.render(f5);
        FrontStandRight.render(f5);
        Base.render(f5);
        Handle.render(f5);
        PressPlate.render(f5);
    }

    public void simpleRenderer(float f5){
        BottomLeft.render(f5);
        VeryBottom.render(f5);
        Front.render(f5);
        Back.render(f5);
        Left.render(f5);
        Right.render(f5);
        FrontBar.render(f5);
        BackPiece.render(f5);
        FrontPiece.render(f5);
        BackStandLeft.render(f5);
        BackStandRight.render(f5);
        MiddleLeft.render(f5);
        BackBar.render(f5);
        MiddleRight.render(f5);
        MiddleFront.render(f5);
        MiddleBack.render(f5);
        FrontStandLeft.render(f5);
        FrontStandRight.render(f5);
        Base.render(f5);
        Handle.render(f5);
        PressPlate.render(f5);
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
