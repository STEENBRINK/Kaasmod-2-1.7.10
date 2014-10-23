package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import nl.steenbrink.kaasmod.block.BlockBarrel;
import nl.steenbrink.kaasmod.block.BlockKaasmodFluidBase;
import nl.steenbrink.kaasmod.block.BlockSaltOre;
import nl.steenbrink.kaasmod.block.BlockSaltWater;
import nl.steenbrink.kaasmod.item.ItemBlockBarrel;
import nl.steenbrink.kaasmod.reference.Names;

public class ModBlocks {

    public static final Block blockSaltOre = new BlockSaltOre();
    public static final Block blockBarrel = new BlockBarrel();
    public static final BlockFluidClassic blockSaltWater = new BlockSaltWater(ModFluids.saltWater, Material.water);

    public static void init() {
        GameRegistry.registerBlock(blockSaltOre, Names.Blocks.SALT_ORE);
        GameRegistry.registerBlock(blockBarrel, ItemBlockBarrel.class, Names.Blocks.BARREL);
        GameRegistry.registerBlock(blockSaltWater, Names.Fluids.SALT_WATER);
    }

}
