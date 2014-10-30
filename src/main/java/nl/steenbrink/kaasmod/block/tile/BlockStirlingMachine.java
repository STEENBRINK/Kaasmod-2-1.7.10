package nl.steenbrink.kaasmod.block.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.reference.Names;
import nl.steenbrink.kaasmod.tileentity.TileEntityStirlingMachine;

public class BlockStirlingMachine extends BlockBasicTile
{
    public BlockStirlingMachine(){
        super(Material.rock);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
        this.setBlockName(Names.Blocks.STIRLING_MACHINE);
        this.setStepSound(Block.soundTypeWood);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityStirlingMachine();
    }
}
