package nl.steenbrink.kaasmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

/**
 * Created by Gebruiker on 20-11-2015.
 */
public class BlockBasicSlab extends BlockSlab {
    public BlockBasicSlab(boolean isFull, Material material, Block original) {
        super(isFull, material);
        this.getOriginal(original);
        if (!isFull){this.setCreativeTab(CreativeTabKaasmod.INSTANCE);}
    }
    public String originalTexture;
    public String full;

    public void getOriginal(Block textureBlock){
        originalTexture = textureBlock.getUnlocalizedName();
    }

    @Override
    public String func_150002_b(int i) {
        return null;
    }

    @Override
    public String getUnlocalizedName() {
        return UnlocalizedNameHelper.getUnlocalizedBlockName(super.getUnlocalizedName());
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(originalTexture));
    }
}
