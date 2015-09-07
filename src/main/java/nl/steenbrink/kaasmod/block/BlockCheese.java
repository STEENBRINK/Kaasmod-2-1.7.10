package nl.steenbrink.kaasmod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCake;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.init.ModItems;
import nl.steenbrink.kaasmod.reference.Names;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

/**
 * Steenbrink's Kaasmod
 *
 * @author STEENBRINK
 *         Copyright (c) 2015
 */

public class BlockCheese extends BlockCake {

    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;
    @SideOnly(Side.CLIENT)
    private IIcon iconInside;

    public BlockCheese() {
        super();
        this.setStepSound(Block.soundTypeCloth);
        this.setHardness(0.5F);
        this.setBlockName(Names.Blocks.CHEESE);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
        if (!world.isRemote && meta < 6) {

            EntityItem k = new EntityItem(world, x + 0.5, y + 0.5, z + 0.5, new ItemStack(ModItems.itemCheeseSlice, 6 - meta));
            k.setVelocity(0, 0.2, 0);
            world.spawnEntityInWorld(k);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public IIcon getIcon(int side, int metadata)
    {
        return side == 1 ? this.iconTop : (side == 0 ? this.iconBottom : (metadata > 0 && side == 4 ? this.iconInside : this.blockIcon));
    }

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "Side");
        this.iconInside = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "Inside");
        this.iconTop = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "Top");
        this.iconBottom = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName()) + "Bottom");
    }

    @Override
    public String getUnlocalizedName() {
        return UnlocalizedNameHelper.getUnlocalizedBlockName(super.getUnlocalizedName());
    }

}

