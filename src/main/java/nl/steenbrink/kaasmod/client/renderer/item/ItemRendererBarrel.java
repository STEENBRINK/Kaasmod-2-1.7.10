package nl.steenbrink.kaasmod.client.renderer.item;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import nl.steenbrink.kaasmod.client.renderer.model.ModelBarrel;
import nl.steenbrink.kaasmod.reference.Reference;
import org.lwjgl.opengl.GL11;

public class ItemRendererBarrel implements IItemRenderer {

    private final ModelBarrel modelBarrel;

    public ItemRendererBarrel()
    {
        modelBarrel = new ModelBarrel();
    }

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
    {
        switch (itemRenderType)
        {
            case ENTITY:
            {
                renderBarrel(0F, 1F, 0F);
                return;
            }
            case EQUIPPED:
            {
                renderBarrel(0.5F, 1F, 0.5F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderBarrel(0.5F, 1.5F, 0.5F);
                return;
            }
            case INVENTORY:
            {
                renderBarrel(0F, 1F, 0F);
                return;
            }
            default:
        }
    }

    private void renderBarrel(float x, float y, float z)
    {
        GL11.glPushMatrix();

        // Scale, Translate, Rotate
        GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(180F, 0f, 0f, 1f);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/models/Barrel.png"));

        // Render
        modelBarrel.simpleRender(0.0625f);

        GL11.glPopMatrix();
    }

}
