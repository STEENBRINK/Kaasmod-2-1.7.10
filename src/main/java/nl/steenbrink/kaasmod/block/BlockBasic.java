package nl.steenbrink.kaasmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import nl.steenbrink.kaasmod.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

public class BlockBasic extends Block {

    public BlockBasic(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
    }

    @Override
    public String getUnlocalizedName() {
        return UnlocalizedNameHelper.getUnlocalizedBlockName(super.getUnlocalizedName());
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }
}
