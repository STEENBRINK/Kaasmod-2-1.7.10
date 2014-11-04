package nl.steenbrink.kaasmod.block.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
import nl.steenbrink.kaasmod.tileentity.TileEntityStirlingMachine;

public class BlockStirlingMachine extends BlockBasicTile
{
    public BlockStirlingMachine(){
        super(Material.rock);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
        this.setBlockName(Names.Blocks.STIRLING_MACHINE);
        this.setStepSound(Block.soundTypeWood);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData)
    {
        return new TileEntityStirlingMachine();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
        if (entityPlayer == null) return false;

        TileEntityStirlingMachine tileEntityStirlingMachine = (TileEntityStirlingMachine) world.getTileEntity(x, y, z);
        if (tileEntityStirlingMachine == null) return false;

        if (entityPlayer.getCurrentEquippedItem() != null) {
            ItemStack equipedItem = entityPlayer.getCurrentEquippedItem();

            FluidStack fluidItem = FluidContainerRegistry.getFluidForFilledItem(equipedItem);
            if (fluidItem != null) {
                int capacity = tileEntityStirlingMachine.fill(ForgeDirection.UNKNOWN, fluidItem, false);
                if (capacity > 0) {
                    tileEntityStirlingMachine.fill(ForgeDirection.UNKNOWN, fluidItem, true);
                    if (!entityPlayer.capabilities.isCreativeMode) {
                        if (equipedItem.getItem() == Items.potionitem && equipedItem.getItemDamage() == 0) {
                            entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, new ItemStack(Items.glass_bottle, 1, 0));
                        } else {
                            entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, getContainer(equipedItem));
                        }
                    }
                }
            } else if (FluidContainerRegistry.isContainer(equipedItem)) {
                FluidStack available = tileEntityStirlingMachine.drain(ForgeDirection.UNKNOWN, Integer.MAX_VALUE, false);
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

                        tileEntityStirlingMachine.drain(ForgeDirection.UNKNOWN, liquid.amount, true);
                        return true;
                    }
                }
            }
        }

        return true;
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
