package nl.steenbrink.kaasmod.block.fluid;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import nl.steenbrink.kaasmod.reference.Names;

public class BlockRennet extends BlockKaasmodFluidBase
{
    public BlockRennet(Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setBlockName(Names.Fluids.RENNET);
    }
}
