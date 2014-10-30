// Date: 30/10/2014 17:04:14
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.minecraft.src;

public class ModelModel extends ModelBase
{
  //fields
    ModelRenderer BottomLeft;
    ModelRenderer VeryBottom;
    ModelRenderer Front;
    ModelRenderer Back;
    ModelRenderer Right;
    ModelRenderer Right;
    ModelRenderer KnifeBase;
    ModelRenderer BaseLeft;
    ModelRenderer BaseRight;
  
  public ModelModel()
  {
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
      Right = new ModelRenderer(this, 34, 28);
      Right.addBox(0F, 0F, 0F, 1, 8, 14);
      Right.setRotationPoint(-8F, 14F, -7F);
      Right.setTextureSize(64, 64);
      Right.mirror = true;
      setRotation(Right, 0F, 0F, 0F);
      Right = new ModelRenderer(this, 34, 28);
      Right.addBox(0F, 0F, 0F, 1, 8, 14);
      Right.setRotationPoint(7F, 14F, -7F);
      Right.setTextureSize(64, 64);
      Right.mirror = true;
      setRotation(Right, 0F, 0F, 0F);
      KnifeBase = new ModelRenderer(this, 0, 0);
      KnifeBase.addBox(0F, 0F, 0F, 1, 3, 1);
      KnifeBase.setRotationPoint(-0.5F, 8F, -0.5F);
      KnifeBase.setTextureSize(64, 64);
      KnifeBase.mirror = true;
      setRotation(KnifeBase, 0F, 0F, 0F);
      BaseLeft = new ModelRenderer(this, 0, 37);
      BaseLeft.addBox(0F, 0F, 0F, 1, 10, 1);
      BaseLeft.setRotationPoint(0F, 8F, -0.5F);
      BaseLeft.setTextureSize(64, 64);
      BaseLeft.mirror = true;
      setRotation(BaseLeft, 0F, 0F, 0.9272934F);
      BaseRight = new ModelRenderer(this, 0, 37);
      BaseRight.addBox(-1F, 0F, 0F, 1, 10, 1);
      BaseRight.setRotationPoint(0F, 8F, -0.5F);
      BaseRight.setTextureSize(64, 64);
      BaseRight.mirror = true;
      setRotation(BaseRight, 0F, 0F, -0.9272934F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    BottomLeft.render(f5);
    VeryBottom.render(f5);
    Front.render(f5);
    Back.render(f5);
    Right.render(f5);
    Right.render(f5);
    KnifeBase.render(f5);
    BaseLeft.render(f5);
    BaseRight.render(f5);
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
