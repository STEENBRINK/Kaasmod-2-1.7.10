package nl.steenbrink.kaasmod.client.renderer.tileentity;

import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import nl.steenbrink.kaasmod.client.renderer.model.ModelBarrel;
import nl.steenbrink.kaasmod.client.renderer.model.ModelStirlingMachine;
import nl.steenbrink.kaasmod.reference.Reference;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;
import nl.steenbrink.kaasmod.tileentity.TileEntityStirlingMachine;
import org.lwjgl.opengl.GL11;

public class TileEntityRendererStirlingMachine extends TileEntitySpecialRenderer {

    private final ModelStirlingMachine modelStirlingMachine;

    public TileEntityRendererStirlingMachine() {
        this.modelStirlingMachine = new ModelStirlingMachine();
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        TileEntityStirlingMachine tileEntityStirlingMachine = (TileEntityStirlingMachine) te;

        /*
         * Render the stirlingmachine model with the correct texture over it
         */
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        this.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/models/StirlingMachineWhole.png"));
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        this.modelStirlingMachine.render(null, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
        GL11.glPopMatrix();

        /*
         * Render the fluid inside of the stirlingmachine
         */
        if (tileEntityStirlingMachine.fluidStack.amount > 0) {
            GL11.glPushMatrix();
            float fluidHeight = ((0.55f - 0.13f)/(tileEntityStirlingMachine.fluidCapacity - 1)) * tileEntityStirlingMachine.fluidStack.amount + 0.129229229f;
            GL11.glTranslatef((float)x + 0.5F,(float)y + fluidHeight,(float)z + 0.5F);
            GL11.glScalef(0.9f, 1.0f, 0.9f);
            this.bindTexture(TextureMap.locationBlocksTexture);
            this.modelStirlingMachine.renderInternal(0xffffffff, tileEntityStirlingMachine.fluidStack.getFluid().getIcon(tileEntityStirlingMachine.fluidStack));
            GL11.glPopMatrix();
        }
    }
}

