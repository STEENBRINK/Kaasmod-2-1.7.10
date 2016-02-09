package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import nl.steenbrink.kaasmod.tileentity.*;

public class ModTileEntities
{
    public static void init(){
        GameRegistry.registerTileEntity(TileEntityBarrel.class, "tileBarrel");
        GameRegistry.registerTileEntity(TileEntityStirlingMachine.class, "tileStirlingMachine");
        GameRegistry.registerTileEntity(TileEntityCompressor.class, "tileCompressor");
        GameRegistry.registerTileEntity(TileEntityCheeseShelf.class, "tileCheeseShelf");
        GameRegistry.registerTileEntity(TileEntitiyToaster.class, "tileEntityToaster");
    }
}
