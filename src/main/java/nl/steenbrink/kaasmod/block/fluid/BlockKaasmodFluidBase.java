package nl.steenbrink.kaasmod.block.fluid;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

public class BlockKaasmodFluidBase extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    public IIcon iconFlowing;

    public BlockKaasmodFluidBase(Fluid fluid, Material material){
        super(fluid, material);
        super.displacements.put(this, false);
    }

    @Override
    public String getUnlocalizedName() {
        return UnlocalizedNameHelper.getUnlocalizedBlockName(super.getUnlocalizedName());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
        this.blockIcon = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName())+"_still");
        this.iconFlowing = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName())+"_flow");

        this.getFluid().setStillIcon(blockIcon);
        this.getFluid().setFlowingIcon(iconFlowing);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if(side == 0 || side == 1) return this.blockIcon;
        else return (this.iconFlowing);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {

        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {

        if (world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }
}
