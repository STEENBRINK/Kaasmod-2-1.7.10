package nl.steenbrink.kaasmod.block.fluid;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import nl.steenbrink.kaasmod.reference.Names;

public class BlockCurd extends BlockKaasmodFluidBase
{
    public BlockCurd(Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setBlockName(Names.Fluids.CURD);
    }
}
