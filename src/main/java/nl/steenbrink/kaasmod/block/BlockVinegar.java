package nl.steenbrink.kaasmod.block;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import nl.steenbrink.kaasmod.reference.Names;

public class BlockVinegar extends BlockKaasmodFluidBase
{
    public BlockVinegar(Fluid fluid, Material material){
        super(fluid, material);
        this.setBlockName(Names.Fluids.VINEGAR);
    }
}
