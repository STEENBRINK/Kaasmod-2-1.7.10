package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import nl.steenbrink.kaasmod.fluid.FluidSaltWater;
import nl.steenbrink.kaasmod.reference.Names;

public class ModFluids{
    public static Fluid saltWater = new Fluid(Names.Fluids.SALT_WATER).set;

    public static void init(){
        FluidRegistry.registerFluid(saltWater);
    }
}
