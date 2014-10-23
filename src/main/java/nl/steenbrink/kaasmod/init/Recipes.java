package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.itemStomachSlice, 5), new ItemStack(ModItems.itemStomach), new ItemStack(ModItems.itemKnife)));
    }
}
