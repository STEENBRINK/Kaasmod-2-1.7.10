package nl.steenbrink.kaasmod.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.init.ModItems;
import nl.steenbrink.kaasmod.reference.Reference;

public class CreativeTabKaasmod extends CreativeTabs {

    public static final CreativeTabKaasmod INSTANCE = new CreativeTabKaasmod();

    public CreativeTabKaasmod() {
        super(Reference.MOD_ID);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ModBlocks.blockCheese);
    }
}
