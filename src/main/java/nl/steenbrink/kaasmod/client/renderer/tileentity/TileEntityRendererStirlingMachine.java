package nl.steenbrink.kaasmod.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nl.steenbrink.kaasmod.client.renderer.model.ModelStirlingMachineWhole;
import nl.steenbrink.kaasmod.reference.Reference;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererStirlingMachine extends TileEntitySpecialRenderer {

    private ModelStirlingMachineWhole modelStirlingMachine;
    public TileEntityRendererStirlingMachine() {
        this.modelStirlingMachine = new ModelStirlingMachineWhole();
    }

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        this.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/models/ModelStirlingMachineWhole.png"));
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.modelStirlingMachine.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
