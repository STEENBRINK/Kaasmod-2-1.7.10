package nl.steenbrink.kaasmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;
import nl.steenbrink.kaasmod.handler.EntityEventHandler;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.init.ModFluids;
import nl.steenbrink.kaasmod.init.ModItems;
import nl.steenbrink.kaasmod.proxy.IProxy;
import nl.steenbrink.kaasmod.reference.Reference;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class Kaasmod {

    @Mod.Instance(Reference.MOD_ID)
    public static Kaasmod instance;

    @SidedProxy(clientSide = Reference.CLASS_PROXY_CLIENT, serverSide = Reference.CLASS_PROXY_SERVER)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Initialize the items and blocks
        ModFluids.init();
        ModBlocks.init();
        ModItems.init();
        ModFluids.registerBuckets();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // Register event handlers
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());

        proxy.registerTileEntityRenderer();
        GameRegistry.registerTileEntity(TileEntityBarrel.class, "tileBarrel");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

}
