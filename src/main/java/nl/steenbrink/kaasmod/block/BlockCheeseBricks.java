package nl.steenbrink.kaasmod.block;


import net.minecraft.block.material.Material;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.reference.Names;

public class BlockCheeseBricks extends BlockBasic{
    public BlockCheeseBricks() {
        super(Material.rock);
        this.setBlockName(Names.Blocks.CHEESE_BRICKS);
        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
    }
}
