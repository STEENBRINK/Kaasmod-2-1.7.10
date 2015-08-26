package nl.steenbrink.kaasmod.block.tile;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.reference.Names;

public class BlockToaster extends BlockBasicTile{
    public BlockToaster() {
        super(Material.iron);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
        this.setBlockName(Names.Blocks.TOASTER);
        this.setStepSound(Block.soundTypeMetal);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
    }
}
