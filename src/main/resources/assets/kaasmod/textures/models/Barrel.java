// Date: 22/10/2014 20:18:30
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelBarrel extends ModelBase
{
  //fields
    ModelRenderer SideF;
    ModelRenderer SideB;
    ModelRenderer SideR;
    ModelRenderer SideL;
    ModelRenderer bottom;
  
  public ModelBarrel()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      SideF = new ModelRenderer(this, 0, 0);
      SideF.addBox(0F, 0F, 0F, 12, 16, 2);
      SideF.setRotationPoint(-6F, 8F, -8F);
      SideF.setTextureSize(64, 64);
      SideF.mirror = true;
      setRotation(SideF, 0F, 0F, 0F);
      SideB = new ModelRenderer(this, 0, 0);
      SideB.addBox(0F, 0F, 0F, 12, 16, 2);
      SideB.setRotationPoint(-6F, 8F, 6F);
      SideB.setTextureSize(64, 64);
      SideB.mirror = true;
      setRotation(SideB, 0F, 0F, 0F);
      SideR = new ModelRenderer(this, 0, 0);
      SideR.addBox(0F, 0F, 0F, 2, 16, 16);
      SideR.setRotationPoint(6F, 8F, -8F);
      SideR.setTextureSize(64, 64);
      SideR.mirror = true;
      setRotation(SideR, 0F, 0F, 0F);
      SideL = new ModelRenderer(this, 0, 0);
      SideL.addBox(0F, 0F, 0F, 2, 16, 16);
      SideL.setRotationPoint(-8F, 8F, -8F);
      SideL.setTextureSize(64, 64);
      SideL.mirror = true;
      setRotation(SideL, 0F, 0F, 0F);
      bottom = new ModelRenderer(this, 0, 0);
      bottom.addBox(0F, 0F, 0F, 12, 1, 12);
      bottom.setRotationPoint(-6F, 23F, -6F);
      bottom.setTextureSize(64, 64);
      bottom.mirror = true;
      setRotation(bottom, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    SideF.render(f5);
    SideB.render(f5);
    SideR.render(f5);
    SideL.render(f5);
    bottom.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5);
  }

}
