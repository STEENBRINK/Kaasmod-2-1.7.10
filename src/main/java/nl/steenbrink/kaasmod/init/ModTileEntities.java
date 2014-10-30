package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;
import nl.steenbrink.kaasmod.tileentity.TileEntityStirlingMachine;

public class ModTileEntities
{
    public static void init(){
        GameRegistry.registerTileEntity(TileEntityBarrel.class, "tileBarrel");
        GameRegistry.registerTileEntity(TileEntityStirlingMachine.class, "tileStirlingMachine");
    }
}
