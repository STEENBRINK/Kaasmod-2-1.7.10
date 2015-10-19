package nl.steenbrink.kaasmod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import nl.steenbrink.kaasmod.client.renderer.item.*;
import nl.steenbrink.kaasmod.client.renderer.tileentity.*;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.tileentity.*;

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

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitiyToaster.class, new TileEntityRendererToaster());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.blockToaster), new ItemRendererToaster());
    }
}
