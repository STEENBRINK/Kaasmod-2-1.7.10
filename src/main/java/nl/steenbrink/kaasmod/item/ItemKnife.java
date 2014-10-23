package nl.steenbrink.kaasmod.item;

import net.minecraft.item.ItemStack;
import nl.steenbrink.kaasmod.reference.Names;

public class ItemKnife extends ItemBasic
{
    public ItemKnife()
    {
        super();
        this.setUnlocalizedName(Names.Items.KNIFE);
        this.setContainerItem(this);
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {
        return false;
    }
}
