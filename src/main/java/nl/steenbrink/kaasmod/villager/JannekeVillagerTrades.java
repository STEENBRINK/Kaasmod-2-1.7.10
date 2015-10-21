package nl.steenbrink.kaasmod.villager;


import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.init.ModItems;
import nl.steenbrink.kaasmod.reference.Names;

import java.util.Random;

public class JannekeVillagerTrades implements VillagerRegistry.IVillageTradeHandler {

    @Override
    public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
        if (villager.getProfession() == Names.Villagers.JANNEKE) {
            recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Items.emerald, 3), new ItemStack(ModItems.itemCheeseBaconBread, 2)));
            recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Items.emerald, 2), new ItemStack(ModBlocks.blockCheese)));
            recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Items.iron_ingot, 2), new ItemStack(ModItems.itemCheeseSlicer)));
            recipeList.addToListWithCheck(new MerchantRecipe(new ItemStack(Items.milk_bucket), new ItemStack(Items.emerald), new ItemStack(ModBlocks.blockCheese)));
        }
    }
}
