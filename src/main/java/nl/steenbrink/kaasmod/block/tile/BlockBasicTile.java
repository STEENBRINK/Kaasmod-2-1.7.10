package nl.steenbrink.kaasmod.block.tile;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

public class BlockBasicTile extends BlockContainer
{
    public BlockBasicTile(Material material) {
        super(material);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
    }

    @Override
    public String getUnlocalizedName() {
        return UnlocalizedNameHelper.getUnlocalizedBlockName(super.getUnlocalizedName());
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return null;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
