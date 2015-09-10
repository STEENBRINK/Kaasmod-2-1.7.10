package nl.steenbrink.kaasmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import nl.steenbrink.kaasmod.client.renderer.item.ItemRendererBarrel;
import nl.steenbrink.kaasmod.client.renderer.item.ItemRendererCheeseShelf;
import nl.steenbrink.kaasmod.client.renderer.item.ItemRendererCompressor;
import nl.steenbrink.kaasmod.client.renderer.item.ItemRendererStirlingMachine;
import nl.steenbrink.kaasmod.client.renderer.tileentity.TileEntityRendererBarrel;
import nl.steenbrink.kaasmod.client.renderer.tileentity.TileEntityRendererCheeseShelf;
import nl.steenbrink.kaasmod.client.renderer.tileentity.TileEntityRendererCompressor;
import nl.steenbrink.kaasmod.client.renderer.tileentity.TileEntityRendererStirlingMachine;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;
import nl.steenbrink.kaasmod.tileentity.TileEntityCheeseShelf;
import nl.steenbrink.kaasmod.tileentity.TileEntityCompressor;
import nl.steenbrink.kaasmod.tileentity.TileEntityStirlingMachine;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerTileEntityRenderer() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, new TileEntityRendererBarrel());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockBarrel), new ItemRendererBarrel());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStirlingMachine.class, new TileEntityRendererStirlingMachine());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockStirlingMachine), new ItemRendererStirlingMachine());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCompressor.class, new TileEntityRendererCompressor());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockCompressor), new ItemRendererCompressor());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCheeseShelf.class, new TileEntityRendererCheeseShelf());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockCheeseShelf), new ItemRendererCheeseShelf());
    }
}
