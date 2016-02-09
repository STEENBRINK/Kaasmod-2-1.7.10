package nl.steenbrink.kaasmod.client.renderer.tileentity;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nl.steenbrink.kaasmod.client.renderer.model.ModelCheeseShelf;
import nl.steenbrink.kaasmod.reference.Reference;
import nl.steenbrink.kaasmod.tileentity.TileEntityCheeseShelf;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererCheeseShelf extends TileEntitySpecialRenderer {

    private final ModelCheeseShelf modelCheeseShelf;

    public TileEntityRendererCheeseShelf() {this.modelCheeseShelf = new ModelCheeseShelf();}

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        TileEntityCheeseShelf tileEntityCheeseShelf = (TileEntityCheeseShelf) te;

        /*
         * Render the cheeseshelf model with the correct texture over it
         */
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        this.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/models/CheeseShelf.png"));
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.modelCheeseShelf.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

        /*
         * Render the internal item
         */
        if (tileEntityCheeseShelf.getStackInSlot(0) != null) {
            GL11.glPushMatrix();
            this.bindTexture(TextureMap.locationItemsTexture);
            this.modelCheeseShelf.renderBlock(tileEntityCheeseShelf, x, y, z);
            GL11.glPopMatrix();
        }


    }
}
