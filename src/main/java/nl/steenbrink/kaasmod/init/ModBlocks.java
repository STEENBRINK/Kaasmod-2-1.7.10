package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import nl.steenbrink.kaasmod.block.BlockBarrel;
import nl.steenbrink.kaasmod.block.BlockSaltOre;
import nl.steenbrink.kaasmod.reference.Names;

public class ModBlocks {

    public static final Block blockSaltOre = new BlockSaltOre();
    public static final Block blockBarrel = new BlockBarrel();

    public static void init() {
        GameRegistry.registerBlock(blockSaltOre, Names.Blocks.SALT_ORE);
        GameRegistry.registerBlock(blockBarrel, Names.Blocks.BARREL);
    }

}
