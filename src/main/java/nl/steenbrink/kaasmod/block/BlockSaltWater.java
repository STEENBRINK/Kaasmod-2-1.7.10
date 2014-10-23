package nl.steenbrink.kaasmod.block;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import nl.steenbrink.kaasmod.reference.Names;

public class BlockSaltWater extends BlockKaasmodFluidBase
{

    public BlockSaltWater(Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setBlockName(Names.Fluids.SALT_WATER);
    }
}
