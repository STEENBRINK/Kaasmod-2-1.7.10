package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemStomachSlice, 5), new ItemStack(ModItems.itemStomach), new ItemStack(ModItems.itemKnife)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemBreadSlice, 5), new ItemStack(Items.bread), new ItemStack(ModItems.itemKnife)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemKnife), "I ", " S", 'I', new ItemStack(Items.iron_ingot), 'S', new ItemStack(Items.stick)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockBarrel), "P P", "PBP", "PPP", 'P', (new ItemStack(Blocks.planks)), 'B', new ItemStack(Items.bucket)));
    }
}
