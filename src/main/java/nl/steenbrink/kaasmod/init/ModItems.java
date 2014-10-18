package nl.steenbrink.kaasmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import nl.steenbrink.kaasmod.item.ItemBasic;
import nl.steenbrink.kaasmod.reference.Names;

public class ModItems {

    public static final Item itemStomach = (new ItemBasic()).setUnlocalizedName(Names.Items.STOMACH);
    public static final Item itemRawSalt = (new ItemBasic()).setUnlocalizedName(Names.Items.RAW_SALT);

    public static void init() {
        GameRegistry.registerItem(itemStomach, Names.Items.STOMACH);
        GameRegistry.registerItem(itemRawSalt, Names.Items.RAW_SALT);
    }

}
