package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import nl.steenbrink.kaasmod.item.ItemBasic;
import nl.steenbrink.kaasmod.item.ItemCheeseSlicer;
import nl.steenbrink.kaasmod.item.ItemKnife;
import nl.steenbrink.kaasmod.item.bucket.*;
import nl.steenbrink.kaasmod.item.ItemBasicFood;
import nl.steenbrink.kaasmod.reference.Names;

public class ModItems {

    /*Items*/
    public static final Item itemStomach = new ItemBasic().setUnlocalizedName(Names.Items.STOMACH);
    public static final Item itemCleanSalt = new ItemBasic().setUnlocalizedName(Names.Items.CLEAN_SALT);
    public static final Item itemSaltWaterBucket = new ItemSaltWaterBucket(ModBlocks.blockSaltWater);
    public static final Item itemVinegarBucket =  new ItemVinegarBucket(ModBlocks.blockVinegar);
    public static final Item itemLacticAcidBucket = new ItemLacticAcidBucket(ModBlocks.blockLacticAcid);
    public static final Item itemRennetBucket = new ItemRennetBucket(ModBlocks.blockRennet);
    public static final Item itemCurdledMilkBucket = new ItemCurdledMilkBucket(ModBlocks.blockCurdledMilk);
    public static final Item itemCurdBucket = new ItemCurdBucket(ModBlocks.blockCurd);
    public static final Item itemDirtySalt = new ItemBasic().setUnlocalizedName(Names.Items.DIRTY_SALT);
    public static final Item itemKnife = new ItemKnife();
    public static final Item itemStomachSlice = new ItemBasic().setUnlocalizedName(Names.Items.STOMACH_SLICE);
    public static final Item itemCheeseBrick = new ItemBasic().setUnlocalizedName(Names.Items.CHEESE_BRICK);
    public static final Item itemCheeseSlicer = new ItemCheeseSlicer();
    public static final Item itemStarter = new ItemBasic().setUnlocalizedName(Names.Items.STARTER);
    /*Food*/
    public static final Item itemBreadSlice = new ItemBasicFood(1, 0.2f, false).setUnlocalizedName(Names.Items.BREAD_SLICE);
    public static final Item itemCheeseSlice = new ItemBasicFood(2, 0.2f, false).setUnlocalizedName(Names.Items.CHEESE_SLICE);
    public static final Item itemCheeseBaconBread = new ItemBasicFood(12, 1.5f, false).setUnlocalizedName(Names.Items.CHEESE_BACON_BREAD);
    public static final Item itemCheeseBread = new ItemBasicFood(6, 1.4f, false).setUnlocalizedName(Names.Items.CHEESE_BREAD);
    public static final Item itemTosti = new ItemBasicFood(20, 1.8f, false).setUnlocalizedName(Names.Items.TOSTI);

    public static void init() {
        GameRegistry.registerItem(itemStomach, Names.Items.STOMACH);
        GameRegistry.registerItem(itemCleanSalt, Names.Items.CLEAN_SALT);
        GameRegistry.registerItem(itemSaltWaterBucket, Names.Items.SALT_WATER_BUCKET);
        GameRegistry.registerItem(itemVinegarBucket, Names.Items.VINEGAR_BUCKET);
        GameRegistry.registerItem(itemDirtySalt, Names.Items.DIRTY_SALT);
        GameRegistry.registerItem(itemKnife, Names.Items.KNIFE);
        GameRegistry.registerItem(itemStomachSlice, Names.Items.STOMACH_SLICE);
        GameRegistry.registerItem(itemBreadSlice, Names.Items.BREAD_SLICE);
        GameRegistry.registerItem(itemLacticAcidBucket, Names.Items.LACTIC_ACID_BUCKET);
        GameRegistry.registerItem(itemRennetBucket, Names.Items.RENNET_BUCKET);
        GameRegistry.registerItem(itemCurdledMilkBucket, Names.Items.CURDLED_MILK_BUCKET);
        GameRegistry.registerItem(itemCurdBucket, Names.Items.CURD_BUCKET);
        GameRegistry.registerItem(itemCheeseSlice, Names.Items.CHEESE_SLICE);
        GameRegistry.registerItem(itemCheeseBrick, Names.Items.CHEESE_BRICK);
        GameRegistry.registerItem(itemCheeseBaconBread, Names.Items.CHEESE_BACON_BREAD);
        GameRegistry.registerItem(itemCheeseBread, Names.Items.CHEESE_BREAD);
        GameRegistry.registerItem(itemTosti, Names.Items.TOSTI);
        GameRegistry.registerItem(itemCheeseSlicer, Names.Items.CHEESE_SLICER);
        GameRegistry.registerItem(itemStarter, Names.Items.STARTER);
    }

}
