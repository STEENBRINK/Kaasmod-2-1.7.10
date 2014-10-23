package nl.steenbrink.kaasmod.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.reference.Names;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

public class ItemVinegarBucket extends ItemBucket
{
    public ItemVinegarBucket(Block block){
        super(block);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
        this.setContainerItem(Items.bucket);
        this.setUnlocalizedName(Names.Items.VINEGAR_BUCKET);
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
