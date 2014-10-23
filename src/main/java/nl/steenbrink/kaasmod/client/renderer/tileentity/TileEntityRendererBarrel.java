package nl.steenbrink.kaasmod.client.renderer.tileentity;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nl.steenbrink.kaasmod.client.renderer.model.ModelBarrel;
import nl.steenbrink.kaasmod.reference.Reference;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererBarrel extends TileEntitySpecialRenderer {

    private final ModelBarrel modelBarrel;

    public TileEntityRendererBarrel() {
        this.modelBarrel = new ModelBarrel();
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        TileEntityBarrel tileEntityBarrel = (TileEntityBarrel) te;

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        this.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/models/Barrel.png"));
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.modelBarrel.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

        if (tileEntityBarrel.fluidStack.amount > 0) {
            //System.err.println(">> RENDER: " + tileEntityBarrel.fluidStack.getFluid().getName());
            GL11.glPushMatrix();
            float fluidHeight = ((0.90f - 0.13f)/(tileEntityBarrel.fluidCapacity - 1)) * tileEntityBarrel.fluidStack.amount + 0.129229229f;
            GL11.glTranslatef((float)x + 0.5F,(float)y + fluidHeight,(float)z + 0.5F);
            GL11.glScalef(0.9f, 1.0f, 0.9f);
            ResourceLocation fluidTexture = TextureMap.locationBlocksTexture;
            bindTexture(fluidTexture);
            this.modelBarrel.renderInternal(0xffffffff, tileEntityBarrel.fluidStack.getFluid().getIcon(), true);
            GL11.glPopMatrix();
        }
    }
}
