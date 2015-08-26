package nl.steenbrink.kaasmod.block;


import net.minecraft.block.material.Material;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.reference.Names;

public class BlockSmoothCheese extends BlockBasic{
    public BlockSmoothCheese() {
        super(Material.rock);
        this.setBlockName(Names.Blocks.SMOOTH_CHEESE);
        this.setHardness(3.0f);
        this.setResistance(5.0f);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
    }
}
