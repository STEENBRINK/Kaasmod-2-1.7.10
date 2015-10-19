package nl.steenbrink.kaasmod.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nl.steenbrink.kaasmod.client.renderer.model.ModelToaster;
import nl.steenbrink.kaasmod.reference.Reference;
import nl.steenbrink.kaasmod.tileentity.TileEntitiyToaster;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererToaster extends TileEntitySpecialRenderer {

    private final ModelToaster modelToaster;

    public TileEntityRendererToaster() {this.modelToaster = new ModelToaster();}

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        TileEntitiyToaster tileEntityToaster = (TileEntitiyToaster) te;

        /*
         * Render the compressor model with the correct texture over it
         */
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        this.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/models/Toaster.png"));
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.modelToaster.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

        /*
         * Render the fluid inside of the compressor
         */
        //if (tileEntityCheeseShelf.craftingTimer > 0) {
            //doshit
        //}
    }
}
