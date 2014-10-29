package nl.steenbrink.kaasmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import nl.steenbrink.kaasmod.fluid.FluidCrafting;

import java.util.ArrayList;

public class RecipesBarrel {

    public static void init() {
        /* Mixing recipes */
        INSTANCE.addFluidMixing(
                new FluidStack(ModFluids.fluidSaltWater, 1000),
                new FluidStack(ModFluids.fluidVinegar, 10));

        /* Item-Fluid crafting recipes */
        INSTANCE.addFluidItemCrafting(
                new FluidStack(FluidRegistry.WATER, 1000),
                new ItemStack(ModItems.itemCleanSalt, 1),
                new FluidStack(ModFluids.fluidSaltWater, 1000),
                null,
                10 * 20);
        INSTANCE.addFluidItemCrafting(
                FluidCrafting.createCraftingFluid(new FluidStack(ModFluids.fluidSaltWater, 1000), new FluidStack(ModFluids.fluidVinegar, 10)),
                new ItemStack(ModItems.itemStomachSlice, 1),
                new FluidStack(ModFluids.fluidRennet, 1000),
                null,
                60 * 20);
        INSTANCE.addFluidItemCrafting(
                new FluidStack(FluidRegistry.WATER, 1000),
                new ItemStack(ModItems.itemDirtySalt, 1),
                new FluidStack(0, 0),
                new ItemStack(ModItems.itemCleanSalt, 1),
                30 * 20);

    }

    public static RecipesBarrel INSTANCE = new RecipesBarrel();

    public ArrayList<RecipeFluidMixing> fluidMixings = new ArrayList<RecipeFluidMixing>();
    public ArrayList<RecipeFluidItemCrafting> fluidItemCraftings = new ArrayList<RecipeFluidItemCrafting>();

    /* Fluid Mixing crafting recipes */
    public void addFluidMixing(FluidStack primaryFluid, FluidStack secondaryFluid) {
        addFluidMixing(primaryFluid, secondaryFluid, FluidCrafting.createCraftingFluid(primaryFluid, secondaryFluid));
    }
    public void addFluidMixing(FluidStack primaryFluid, FluidStack secondaryFluid, FluidStack outputFluid) {
        fluidMixings.add(new RecipeFluidMixing(primaryFluid, secondaryFluid, outputFluid));
    }
    public boolean isCrafting(FluidStack primaryFluid, FluidStack secondaryFluid) {
        for (RecipeFluidMixing recipeFluidMixing : fluidMixings) {
            if (recipeFluidMixing.isCrafting(primaryFluid, secondaryFluid)) return true;
        }
        return false;
    }
    public FluidStack getOutput(FluidStack primaryFluid, FluidStack secondaryFluid) {
        for (RecipeFluidMixing recipeFluidMixing : fluidMixings) {
            if (recipeFluidMixing.isCrafting(primaryFluid, secondaryFluid)) {
                return recipeFluidMixing.getOutput();
            }
        }
        return null;
    }

    /* Fluid Item crafting recipes */
    public void addFluidItemCrafting(FluidStack primaryFluid, ItemStack primaryItem, FluidStack outputFluid, ItemStack outputItem, int craftingDuration) {
        fluidItemCraftings.add(new RecipeFluidItemCrafting(primaryFluid, primaryItem, outputFluid, outputItem, craftingDuration));
    }
    public boolean isCrafting(FluidStack primaryFluid, ItemStack primaryItem) {
        for (RecipeFluidItemCrafting recipeFluidItemCrafting : fluidItemCraftings) {
            if (recipeFluidItemCrafting.isCrafting(primaryFluid, primaryItem)) return true;
        }
        return false;
    }
    public FluidStack getOutputFluid(FluidStack primaryFluid, ItemStack primaryItem) {
        for (RecipeFluidItemCrafting recipeFluidItemCrafting : fluidItemCraftings) {
            if (recipeFluidItemCrafting.isCrafting(primaryFluid, primaryItem)) {
                return recipeFluidItemCrafting.getOutputFluid();
            }
        }
        return null;
    }
    public ItemStack getOutputItem(FluidStack primaryFluid, ItemStack primaryItem) {
        for (RecipeFluidItemCrafting recipeFluidItemCrafting : fluidItemCraftings) {
            if (recipeFluidItemCrafting.isCrafting(primaryFluid, primaryItem)) {
                return recipeFluidItemCrafting.getOutputItem();
            }
        }
        return null;
    }
    public int getCraftingDuration(FluidStack primaryFluid, ItemStack primaryItem) {
        for (RecipeFluidItemCrafting recipeFluidItemCrafting : fluidItemCraftings) {
            if (recipeFluidItemCrafting.isCrafting(primaryFluid, primaryItem)) {
                return recipeFluidItemCrafting.getCraftingDuration();
            }
        }
        return 0;
    }

    private class RecipeFluidMixing {
        private FluidStack primaryFluid;
        private FluidStack secondaryFluid;
        private FluidStack outputFluid;

        public RecipeFluidMixing(FluidStack primaryFluid, FluidStack secondaryFluid, FluidStack putputFluid) {
            this.primaryFluid = primaryFluid;
            this.secondaryFluid = secondaryFluid;
            this.outputFluid = putputFluid;
        }

        public boolean isCrafting(FluidStack primaryFluid, FluidStack secondaryFluid) {
            return this.primaryFluid.isFluidStackIdentical(primaryFluid) && this.secondaryFluid.isFluidStackIdentical(secondaryFluid);
        }

        public FluidStack getOutput() {
            return this.outputFluid;
        }

    }

    private class RecipeFluidItemCrafting {
        private FluidStack primaryFluid;
        private ItemStack primaryItem;
        private FluidStack outputFluid;
        private ItemStack outputItem;
        private int craftingDuration;

        public RecipeFluidItemCrafting(FluidStack primaryFluid, ItemStack primaryItem, FluidStack outputFluid, ItemStack outputItem, int craftingDuration) {
            this.primaryFluid = primaryFluid;
            this.primaryItem = primaryItem;
            this.outputFluid = outputFluid;
            this.outputItem = outputItem;
            this.craftingDuration = craftingDuration;
        }

        public boolean isCrafting(FluidStack primaryFluid, ItemStack primaryItem) {
            return this.primaryFluid.isFluidStackIdentical(primaryFluid) && this.primaryItem.isItemEqual(primaryItem);
        }

        public FluidStack getOutputFluid() {
            return this.outputFluid;
        }
        public ItemStack getOutputItem() {
            return this.outputItem;
        }

        public int getCraftingDuration() {
            return this.craftingDuration;
        }
    }

}
