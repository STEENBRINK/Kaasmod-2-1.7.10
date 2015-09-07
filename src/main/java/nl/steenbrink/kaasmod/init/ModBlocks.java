package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.BlockFluidClassic;
import nl.steenbrink.kaasmod.block.*;
import nl.steenbrink.kaasmod.block.fluid.*;
import nl.steenbrink.kaasmod.block.tile.BlockBarrel;
import nl.steenbrink.kaasmod.block.tile.BlockCompressor;
import nl.steenbrink.kaasmod.block.tile.BlockStirlingMachine;
import nl.steenbrink.kaasmod.block.tile.BlockToaster;
import nl.steenbrink.kaasmod.item.block.*;
import nl.steenbrink.kaasmod.reference.Names;

public class ModBlocks {

    public static final Block blockSaltOre = new BlockSaltOre();
    public static final Block blockBarrel = new BlockBarrel();
    public static final Block blockStirlingMachine = new BlockStirlingMachine();
    public static final BlockFluidClassic blockSaltWater = new BlockSaltWater(ModFluids.fluidSaltWater, Material.water);
    public static final BlockFluidClassic blockMilk = new BlockMilk(ModFluids.fluidMilk, Material.water);
    public static final BlockFluidClassic blockVinegar = new BlockVinegar(ModFluids.fluidVinegar, Material.water);
    public static final BlockFluidClassic blockLacticAcid = new BlockLacticAcid(ModFluids.fluidLacticAcid, Material.water);
    public static final BlockFluidClassic blockRennet = new BlockRennet(ModFluids.fluidRennet, Material.water);
    public static final BlockFluidClassic blockCurdledMilk = new BlockCurdledMilk(ModFluids.fluidCurdledMilk, Material.water);
    public static final BlockFluidClassic blockCurd = new BlockCurd(ModFluids.fluidCurd, Material.water);
    public static final Block blockCheeseBricks = new BlockCheeseBricks();
    public static final Block blockSmoothCheese = new BlockSmoothCheese();
    public static final Block blockToaster = new BlockToaster();
    public static final Block blockCompressor = new BlockCompressor();
    public static final Block blockCheese = new BlockCheese();



    public static void init() {
        GameRegistry.registerBlock(blockSaltOre, Names.Blocks.SALT_ORE);
        GameRegistry.registerBlock(blockBarrel, ItemBlockBarrel.class, Names.Blocks.BARREL);
        GameRegistry.registerBlock(blockSaltWater, Names.Fluids.SALT_WATER);
        GameRegistry.registerBlock(blockMilk, Names.Fluids.MILK);
        GameRegistry.registerBlock(blockVinegar, Names.Fluids.VINEGAR);
        GameRegistry.registerBlock(blockLacticAcid, Names.Fluids.LACTIC_ACID);
        GameRegistry.registerBlock(blockRennet, Names.Fluids.RENNET);
        GameRegistry.registerBlock(blockCurdledMilk, Names.Fluids.CURDLED_MILK);
        GameRegistry.registerBlock(blockCurd, Names.Fluids.CURD);
        GameRegistry.registerBlock(blockStirlingMachine, ItemBlockStirlingMachine.class, Names.Blocks.STIRLING_MACHINE);
        GameRegistry.registerBlock(blockCheeseBricks, Names.Blocks.CHEESE_BRICKS);
        GameRegistry.registerBlock(blockSmoothCheese, Names.Blocks.SMOOTH_CHEESE);
        GameRegistry.registerBlock(blockToaster, ItemBlockToaster.class, Names.Blocks.TOASTER);
        GameRegistry.registerBlock(blockCompressor, ItemBlockCompressor.class, Names.Blocks.COMPRESSOR);
        GameRegistry.registerBlock(blockCheese, ItemBlockCheese.class, Names.Blocks.CHEESE);
    }

}
