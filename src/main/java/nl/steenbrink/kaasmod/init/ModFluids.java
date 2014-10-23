package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import nl.steenbrink.kaasmod.fluid.FluidSaltWater;
import nl.steenbrink.kaasmod.handler.BucketHandler;
import nl.steenbrink.kaasmod.item.ItemSaltWaterBucket;
import nl.steenbrink.kaasmod.reference.Names;

public class ModFluids{
    public static Fluid fluidSaltWater = new Fluid(Names.Fluids.SALT_WATER);
    public static Fluid fluidMilk = new Fluid(Names.Fluids.MILK);

    public static void init(){
        FluidRegistry.registerFluid(fluidSaltWater);
        FluidRegistry.registerFluid(fluidMilk);
    }

    public static void registerBuckets(){
        FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidSaltWater, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.itemSaltWaterBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidMilk, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.milk_bucket), new ItemStack(Items.bucket));
        BucketHandler.INSTANCE.buckets.put(ModBlocks.blockSaltWater, ModItems.itemSaltWaterBucket);
        BucketHandler.INSTANCE.buckets.put(ModBlocks.blockMilk, Items.milk_bucket);

        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    }
}
