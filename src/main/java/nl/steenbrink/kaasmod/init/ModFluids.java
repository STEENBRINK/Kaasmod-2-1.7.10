package nl.steenbrink.kaasmod.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import nl.steenbrink.kaasmod.handler.BucketHandler;
import nl.steenbrink.kaasmod.reference.Names;

public class ModFluids{
    public static Fluid fluidSaltWater = new Fluid(Names.Fluids.SALT_WATER);
    public static Fluid fluidMilk = new Fluid(Names.Fluids.MILK);
    public static Fluid fluidVinegar = new Fluid(Names.Fluids.VINEGAR);
    public static Fluid fluidLacticAcid = new Fluid(Names.Fluids.LACTIC_ACID);
    public static Fluid fluidRennet = new Fluid(Names.Fluids.RENNET);
    public static Fluid fluidCurdledMilk = new Fluid(Names.Fluids.CURDLED_MILK);
    public static Fluid fluidProcessedCurdledMilk = new Fluid(Names.Fluids.PROCESSED_CURDLED_MILK);
    public static Fluid fluidCrafting = new Fluid(Names.Fluids.CRAFTING_FLUID);

    public static void init(){
        FluidRegistry.registerFluid(fluidSaltWater);
        FluidRegistry.registerFluid(fluidMilk);
        FluidRegistry.registerFluid(fluidVinegar);
        FluidRegistry.registerFluid(fluidLacticAcid);
        FluidRegistry.registerFluid(fluidRennet);
        FluidRegistry.registerFluid(fluidCurdledMilk);
        FluidRegistry.registerFluid(fluidProcessedCurdledMilk);
        FluidRegistry.registerFluid(fluidCrafting);
    }

    public static void registerBuckets(){
        FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidSaltWater, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.itemSaltWaterBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidMilk, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(Items.milk_bucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(new FluidStack(fluidVinegar, FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(ModItems.itemVinegarBucket), new ItemStack(Items.bucket));

        BucketHandler.INSTANCE.buckets.put(ModBlocks.blockSaltWater, ModItems.itemSaltWaterBucket);
        BucketHandler.INSTANCE.buckets.put(ModBlocks.blockMilk, Items.milk_bucket);
        BucketHandler.INSTANCE.buckets.put(ModBlocks.blockVinegar, ModItems.itemVinegarBucket);

        MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
    }
}
