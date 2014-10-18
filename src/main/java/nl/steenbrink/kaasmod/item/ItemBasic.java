package nl.steenbrink.kaasmod.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

public class ItemBasic extends Item {

    public ItemBasic() {
        super();
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
    }

    @Override
    public String getUnlocalizedName() {
        return UnlocalizedNameHelper.getUnlocalizedItemName(super.getUnlocalizedName());
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return this.getUnlocalizedName();
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
       this.itemIcon = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }


}
