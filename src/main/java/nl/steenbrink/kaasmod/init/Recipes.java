package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes
{
    public static void init()
    {
        //Machines
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockBarrel), "P P", "PBP", "PPP", 'P', new ItemStack(Blocks.planks), 'B', new ItemStack(Items.bucket)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockStirlingMachine), "ISI", "IKI", "PBP", 'I', new ItemStack(Items.iron_ingot), 'S', new ItemStack(Items.stick), 'K', new ItemStack(ModItems.itemKnife), 'P', new ItemStack(Blocks.planks), 'B', new ItemStack(Items.bucket)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockCompressor), "IXI", "IBI", "PPP", 'I', new ItemStack(Items.iron_ingot), 'X', Blocks.light_weighted_pressure_plate, 'B', new ItemStack(Items.bucket), 'P', new ItemStack(Blocks.planks)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockCheeseShelf), "WWW", 'W', new ItemStack(Blocks.wooden_pressure_plate)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockToaster), "IPI", "I  ", "IPI", 'I', new ItemStack(Items.iron_ingot), 'P', new ItemStack(Blocks.heavy_weighted_pressure_plate)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockToaster), "IPI", "  I", "IPI", 'I', new ItemStack(Items.iron_ingot), 'P', new ItemStack(Blocks.heavy_weighted_pressure_plate)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockCheese), "KKK", "KKK", 'K', new ItemStack(ModItems.itemCheeseSlice)));

        //Blocks
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockCheeseBricks, 4), "CC", "CC", 'C', new ItemStack(ModItems.itemCheeseBrick)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockSmoothCheese, 4), "CC", "CC", 'C', new ItemStack(ModItems.itemCheeseSlice)));

        //Items
        GameRegistry.addSmelting(new ItemStack(ModItems.itemCheeseSlice), new ItemStack(ModItems.itemCheeseBrick), 2);

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemStomachSlice, 5), new ItemStack(ModItems.itemStomach), new ItemStack(ModItems.itemKnife)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemKnife), "I ", " S", 'I', new ItemStack(Items.iron_ingot), 'S', new ItemStack(Items.stick)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockBarrel), "P P", "PBP", "PPP", 'P', new ItemStack(Blocks.planks), 'B', new ItemStack(Items.bucket)));

        //Food
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBreadSlice, 5), new ItemStack(Items.bread), new ItemStack(ModItems.itemKnife)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemCheeseBread), "B", "C", "B", 'B', new ItemStack(ModItems.itemBreadSlice), 'C', new ItemStack(ModItems.itemCheeseSlice)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemCheeseBaconBread), " B ", "CPC", " B ", 'B', new ItemStack(ModItems.itemBreadSlice), 'C', new ItemStack(ModItems.itemCheeseSlice), 'P', new ItemStack(Items.cooked_porkchop)));

    }
}
