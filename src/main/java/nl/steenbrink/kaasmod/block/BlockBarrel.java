package nl.steenbrink.kaasmod.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.reference.Names;
import nl.steenbrink.kaasmod.tileentity.TileEntityBarrel;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

public class BlockBarrel extends BlockContainer {

    public BlockBarrel() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
        this.setBlockName(Names.Blocks.BARREL);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName() {
        return UnlocalizedNameHelper.getUnlocalizedBlockName(super.getUnlocalizedName());
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData) {
        return new TileEntityBarrel();
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

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
        if (entityPlayer == null) return false;

        TileEntityBarrel tileEntityBarrel = (TileEntityBarrel) world.getTileEntity(x, y, z);
        if (tileEntityBarrel == null) return false;

        if (entityPlayer.getCurrentEquippedItem() != null) {
            ItemStack equipedItem = entityPlayer.getCurrentEquippedItem();

            FluidStack fluidItem = FluidContainerRegistry.getFluidForFilledItem(equipedItem);
            if (fluidItem != null) {
                int capacity = tileEntityBarrel.fill(ForgeDirection.UNKNOWN, fluidItem, false);
                if (capacity > 0) {
                    tileEntityBarrel.fill(ForgeDirection.UNKNOWN, fluidItem, true);
                    if (!entityPlayer.capabilities.isCreativeMode) {
                        if (equipedItem.getItem() == Items.potionitem && equipedItem.getItemDamage() == 0) {
                            entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, new ItemStack(Items.glass_bottle, 1, 0));
                        } else {
                            entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, getContainer(equipedItem));
                        }
                    }
                }
            } else if (FluidContainerRegistry.isContainer(equipedItem)) {
                FluidStack available = tileEntityBarrel.drain(ForgeDirection.UNKNOWN, Integer.MAX_VALUE, false);
                if (available != null) {
                    ItemStack filled = FluidContainerRegistry.fillFluidContainer(available, equipedItem);
                    FluidStack liquid = FluidContainerRegistry.getFluidForFilledItem(filled);
                    if (liquid != null) {
                        if (equipedItem.stackSize > 1) {
                            if (!entityPlayer.inventory.addItemStackToInventory(filled)) {
                                return false;
                            } else {
                                equipedItem.stackSize -= 1;
                            }
                        } else {
                            entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, filled);
                        }

                        tileEntityBarrel.drain(ForgeDirection.UNKNOWN, liquid.amount, true);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private ItemStack getContainer(ItemStack item) {
        if (item.stackSize == 1) {
            if (item.getItem().hasContainerItem(item)) {
                return item.getItem().getContainerItem(item);
            } else {
                return null;
            }
        } else {
            item.splitStack(1);
            return item;
        }
    }

}
