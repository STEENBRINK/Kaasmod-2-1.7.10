package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import nl.steenbrink.kaasmod.item.ItemBasic;
import nl.steenbrink.kaasmod.item.ItemKnife;
import nl.steenbrink.kaasmod.item.bucket.ItemSaltWaterBucket;
import nl.steenbrink.kaasmod.item.bucket.ItemVinegarBucket;
import nl.steenbrink.kaasmod.reference.Names;

public class ModItems {

    public static final Item itemStomach = new ItemBasic().setUnlocalizedName(Names.Items.STOMACH);
    public static final Item itemCleanSalt = new ItemBasic().setUnlocalizedName(Names.Items.CLEAN_SALT);
    public static final Item itemSaltWaterBucket = new ItemSaltWaterBucket(ModBlocks.blockSaltWater);
    public static final Item itemVinegarBucket =  new ItemVinegarBucket(ModBlocks.blockVinegar);
    public static final Item itemDirtySalt = new ItemBasic().setUnlocalizedName(Names.Items.DIRTY_SALT);
    public static final Item itemKnife = new ItemKnife();
    public static final Item itemStomachSlice = new ItemBasic().setUnlocalizedName(Names.Items.STOMACH_SLICE);

    public static void init() {
        GameRegistry.registerItem(itemStomach, Names.Items.STOMACH);
        GameRegistry.registerItem(itemCleanSalt, Names.Items.CLEAN_SALT);
        GameRegistry.registerItem(itemSaltWaterBucket, Names.Items.SALT_WATER_BUCKET);
        GameRegistry.registerItem(itemVinegarBucket, Names.Items.VINEGAR_BUCKET);
        GameRegistry.registerItem(itemDirtySalt, Names.Items.DIRTY_SALT);
        GameRegistry.registerItem(itemKnife, Names.Items.KNIFE);
        GameRegistry.registerItem(itemStomachSlice, Names.Items.STOMACH_SLICE);
    }

}
