package nl.steenbrink.kaasmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import nl.steenbrink.kaasmod.client.renderer.tileentity.TileEntityRendererBarrel;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerTileEntityRenderer() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, new TileEntityRendererBarrel());
    }
}
