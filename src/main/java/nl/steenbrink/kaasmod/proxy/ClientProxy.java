package nl.steenbrink.kaasmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import nl.steenbrink.kaasmod.client.renderer.item.ItemRendererBarrel;
import nl.steenbrink.kaasmod.client.renderer.item.ItemRendererStirlingMachine;
import nl.steenbrink.kaasmod.client.renderer.tileentity.TileEntityRendererBarrel;
import nl.steenbrink.kaasmod.client.renderer.tileentity.TileEntityRendererStirlingMachine;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;
import nl.steenbrink.kaasmod.tileentity.TileEntityStirlingMachine;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerTileEntityRenderer() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, new TileEntityRendererBarrel());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockBarrel), new ItemRendererBarrel());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStirlingMachine.class, new TileEntityRendererStirlingMachine());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockStirlingMachine), new ItemRendererStirlingMachine());
    }
}
