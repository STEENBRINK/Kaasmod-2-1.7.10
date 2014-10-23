package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import nl.steenbrink.kaasmod.item.ItemBasic;
import nl.steenbrink.kaasmod.item.ItemSaltWaterBucket;
import nl.steenbrink.kaasmod.reference.Names;

public class ModItems {

    public static final Item itemStomach = (new ItemBasic()).setUnlocalizedName(Names.Items.STOMACH);
    public static final Item itemRawSalt = (new ItemBasic()).setUnlocalizedName(Names.Items.RAW_SALT);
    public static final Item itemSaltWaterBucket = (new ItemSaltWaterBucket(ModBlocks.blockSaltWater));

    public static void init() {
        GameRegistry.registerItem(itemStomach, Names.Items.STOMACH);
        GameRegistry.registerItem(itemRawSalt, Names.Items.RAW_SALT);
        GameRegistry.registerItem(itemSaltWaterBucket, Names.Items.SALT_WATER_BUCKET);
    }

}
