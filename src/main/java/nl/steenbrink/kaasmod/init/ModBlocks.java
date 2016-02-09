package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import nl.steenbrink.kaasmod.block.*;
import nl.steenbrink.kaasmod.block.fluid.*;
import nl.steenbrink.kaasmod.block.tile.*;
import nl.steenbrink.kaasmod.item.block.*;
import nl.steenbrink.kaasmod.reference.Names;

public class ModBlocks {

    //Blocks
    public static final Block blockSaltOre = new BlockSaltOre();
    public static final Block blockCheeseBricks = new BlockBasic(Material.rock).setBlockName(Names.Blocks.CHEESE_BRICKS);
    public static final Block blockSmoothCheese = new BlockBasic(Material.rock).setBlockName(Names.Blocks.SMOOTH_CHEESE);
    public static final Block blockCheese = new BlockCheese(false).setBlockName(Names.Blocks.CHEESE);
    public static final Block blockYoungCheese = new BlockCheese(true).setBlockName(Names.Blocks.YOUNG_CHEESE);

    //Machines
    public static final Block blockBarrel = new BlockBarrel();
    public static final Block blockStirlingMachine = new BlockStirlingMachine();
    public static final Block blockToaster = new BlockToaster();
    public static final Block blockCompressor = new BlockCompressor();
    public static final Block blockCheeseShelf = new BlockCheeseShelf();

    //Slabs
    public static final Block blockCheeseBricksSlab =  new BlockBasicSlab(false, Material.rock, ModBlocks.blockCheeseBricks).setBlockName(Names.Blocks.CHEESE_BRICKS_SLAB);
    public static final Block blockCheeseBricksFullSlab = new BlockBasicSlab(true, Material.rock, ModBlocks.blockCheeseBricks).setBlockName(Names.Blocks.CHEESE_BRICKS_FULL_SLAB);
    public static final Block blockSmoothCheeseSlab = new BlockBasicSlab(false, Material.rock, ModBlocks.blockSmoothCheese).setBlockName(Names.Blocks.SMOOTH_CHEESE_SLAB);
    public static final Block blockSmoothCheeseFullSlab = new BlockBasicSlab(true, Material.rock, ModBlocks.blockSmoothCheese).setBlockName(Names.Blocks.SMOOTH_CHEESE_FULL_SLAB);

    //Fluids
    public static final BlockFluidClassic blockSaltWater = new BlockSaltWater(ModFluids.fluidSaltWater, Material.water);
    public static final BlockFluidClassic blockMilk = new BlockMilk(ModFluids.fluidMilk, Material.water);
    public static final BlockFluidClassic blockVinegar = new BlockVinegar(ModFluids.fluidVinegar, Material.water);
    public static final BlockFluidClassic blockLacticAcid = new BlockLacticAcid(ModFluids.fluidLacticAcid, Material.water);
    public static final BlockFluidClassic blockRennet = new BlockRennet(ModFluids.fluidRennet, Material.water);
    public static final BlockFluidClassic blockCurdledMilk = new BlockCurdledMilk(ModFluids.fluidCurdledMilk, Material.water);
    public static final BlockFluidClassic blockCurd = new BlockCurd(ModFluids.fluidCurd, Material.water);



    public static void init() {
        //Blocks
        GameRegistry.registerBlock(blockSaltOre, Names.Blocks.SALT_ORE);
        GameRegistry.registerBlock(blockCheeseBricks, Names.Blocks.CHEESE_BRICKS);
        GameRegistry.registerBlock(blockSmoothCheese, Names.Blocks.SMOOTH_CHEESE);
        GameRegistry.registerBlock(blockCheese, ItemBlockCheese.class, Names.Blocks.CHEESE);
        GameRegistry.registerBlock(blockYoungCheese, ItemBlockCheese.class, Names.Blocks.YOUNG_CHEESE);

        //Machines
        GameRegistry.registerBlock(blockBarrel, ItemBlockBarrel.class, Names.Blocks.BARREL);
        GameRegistry.registerBlock(blockStirlingMachine, ItemBlockStirlingMachine.class, Names.Blocks.STIRLING_MACHINE);
        GameRegistry.registerBlock(blockCheeseShelf, ItemBlockCheeseShelf.class, Names.Blocks.CHEESE_SHELF);
        GameRegistry.registerBlock(blockToaster, ItemBlockToaster.class, Names.Blocks.TOASTER);
        GameRegistry.registerBlock(blockCompressor, ItemBlockCompressor.class, Names.Blocks.COMPRESSOR);

        //Slabs
        GameRegistry.registerBlock(blockCheeseBricksSlab, Names.Blocks.CHEESE_BRICKS_SLAB);
        GameRegistry.registerBlock(blockCheeseBricksFullSlab, Names.Blocks.CHEESE_BRICKS_FULL_SLAB);
        GameRegistry.registerBlock(blockSmoothCheeseSlab, Names.Blocks.SMOOTH_CHEESE_SLAB);
        GameRegistry.registerBlock(blockSmoothCheeseFullSlab, Names.Blocks.SMOOTH_CHEESE_FULL_SLAB);

        //Fluis
        GameRegistry.registerBlock(blockSaltWater, Names.Fluids.SALT_WATER);
        GameRegistry.registerBlock(blockMilk, Names.Fluids.MILK);
        GameRegistry.registerBlock(blockVinegar, Names.Fluids.VINEGAR);
        GameRegistry.registerBlock(blockLacticAcid, Names.Fluids.LACTIC_ACID);
        GameRegistry.registerBlock(blockRennet, Names.Fluids.RENNET);
        GameRegistry.registerBlock(blockCurdledMilk, Names.Fluids.CURDLED_MILK);
        GameRegistry.registerBlock(blockCurd, Names.Fluids.CURD);

    }

}
