package nl.steenbrink.kaasmod.client.renderer.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBarrel extends ModelBase {
    ModelRenderer ShapeA;
    ModelRenderer ShapeB;
    ModelRenderer ShapeC;
    ModelRenderer ShapeD;
    ModelRenderer ShapeE;
    ModelRenderer ShapeF;
    ModelRenderer ShapeG;
    ModelRenderer ShapeH;
    ModelRenderer ShapeI;
    ModelRenderer ShapeJ;

    public ModelBarrel() {
        textureWidth = 64;
        textureHeight = 64;

        ShapeA = new ModelRenderer(this, 0, 0);
        ShapeA.addBox(0F, 0F, 0F, 12, 1, 12);
        ShapeA.setRotationPoint(-6F, 23F, -6F);
        ShapeA.setTextureSize(64, 64);
        ShapeA.mirror = true;
        setRotation(ShapeA, 0F, 0F, 0F);
        ShapeB = new ModelRenderer(this, 0, 0);
        ShapeB.addBox(0F, 0F, 0F, 14, 1, 14);
        ShapeB.setRotationPoint(-7F, 22F, -7F);
        ShapeB.setTextureSize(64, 64);
        ShapeB.mirror = true;
        setRotation(ShapeB, 0F, 0F, 0F);
        ShapeC = new ModelRenderer(this, 0, 0);
        ShapeC.addBox(0F, 0F, 0F, 16, 13, 1);
        ShapeC.setRotationPoint(-8F, 9F, 7F);
        ShapeC.setTextureSize(64, 64);
        ShapeC.mirror = true;
        setRotation(ShapeC, 0F, 0F, 0F);
        ShapeD = new ModelRenderer(this, 0, 0);
        ShapeD.addBox(0F, 0F, 0F, 16, 13, 1);
        ShapeD.setRotationPoint(-8F, 9F, -8F);
        ShapeD.setTextureSize(64, 64);
        ShapeD.mirror = true;
        setRotation(ShapeD, 0F, 0F, 0F);
        ShapeE = new ModelRenderer(this, 0, 0);
        ShapeE.addBox(0F, 0F, 0F, 1, 13, 14);
        ShapeE.setRotationPoint(7F, 9F, -7F);
        ShapeE.setTextureSize(64, 64);
        ShapeE.mirror = true;
        setRotation(ShapeE, 0F, 0F, 0F);
        ShapeF = new ModelRenderer(this, 0, 0);
        ShapeF.addBox(0F, 0F, 0F, 1, 13, 14);
        ShapeF.setRotationPoint(-8F, 9F, -7F);
        ShapeF.setTextureSize(64, 64);
        ShapeF.mirror = true;
        setRotation(ShapeF, 0F, 0F, 0F);
        ShapeG = new ModelRenderer(this, 0, 0);
        ShapeG.addBox(0F, 0F, 0F, 14, 1, 1);
        ShapeG.setRotationPoint(-7F, 8F, 6F);
        ShapeG.setTextureSize(64, 64);
        ShapeG.mirror = true;
        setRotation(ShapeG, 0F, 0F, 0F);
        ShapeH = new ModelRenderer(this, 0, 0);
        ShapeH.addBox(0F, 0F, 0F, 14, 1, 1);
        ShapeH.setRotationPoint(-7F, 8F, -7F);
        ShapeH.setTextureSize(64, 64);
        ShapeH.mirror = true;
        setRotation(ShapeH, 0F, 0F, 0F);
        ShapeI = new ModelRenderer(this, 0, 0);
        ShapeI.addBox(0F, 0F, 0F, 1, 1, 12);
        ShapeI.setRotationPoint(-7F, 8F, -6F);
        ShapeI.setTextureSize(64, 64);
        ShapeI.mirror = true;
        setRotation(ShapeI, 0F, 0F, 0F);
        ShapeJ = new ModelRenderer(this, 0, 0);
        ShapeJ.addBox(0F, 0F, 0F, 1, 1, 12);
        ShapeJ.setRotationPoint(6F, 8F, -6F);
        ShapeJ.setTextureSize(64, 64);
        ShapeJ.mirror = true;
        setRotation(ShapeJ, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        ShapeA.render(f5);
        ShapeB.render(f5);
        ShapeC.render(f5);
        ShapeD.render(f5);
        ShapeE.render(f5);
        ShapeF.render(f5);
        ShapeG.render(f5);
        ShapeH.render(f5);
        ShapeI.render(f5);
        ShapeJ.render(f5);
    }

    public void simpleRender(float f5) {
        ShapeA.render(f5);
        ShapeB.render(f5);
        ShapeC.render(f5);
        ShapeD.render(f5);
        ShapeE.render(f5);
        ShapeF.render(f5);
        ShapeG.render(f5);
        ShapeH.render(f5);
        ShapeI.render(f5);
        ShapeJ.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
