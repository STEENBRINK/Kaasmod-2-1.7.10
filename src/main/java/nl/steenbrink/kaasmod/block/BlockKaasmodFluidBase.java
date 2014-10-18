package nl.steenbrink.kaasmod.block;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.init.ModFluids;

public class BlockKaasmodFluidBase extends BlockFluidClassic
{

    public BlockKaasmodFluidBase(Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
    }
}
