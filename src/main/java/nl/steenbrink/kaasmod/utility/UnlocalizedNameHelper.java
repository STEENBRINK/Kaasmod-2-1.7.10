package nl.steenbrink.kaasmod.utility;

import nl.steenbrink.kaasmod.reference.Reference;

public class UnlocalizedNameHelper {

    public static String getUnlocalizedBlockName(String unlocalizedName) {
        return String.format("tile.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(unlocalizedName));
    }

    public static String getUnlocalizedItemName(String unlocalizedName) {
        return String.format("item.%s:%s", Reference.MOD_ID.toLowerCase(), getUnwrappedUnlocalizedName(unlocalizedName));
    }

    public static String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
