package nl.steenbrink.kaasmod.item.food;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

public class ItemBasicFood extends ItemFood {
    public ItemBasicFood(int healAmount, float satModifier, boolean isWolfFood) {
        super(healAmount, satModifier, isWolfFood);
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
