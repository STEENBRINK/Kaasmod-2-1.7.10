package nl.steenbrink.kaasmod.block.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import nl.steenbrink.kaasmod.init.ModFluids;
import nl.steenbrink.kaasmod.reference.Names;
import nl.steenbrink.kaasmod.tileentity.TileEntityCompressor;
public class BlockCompressor extends BlockBasicTile {

    public BlockCompressor() {
        super(Material.wood);
        this.setBlockName(Names.Blocks.COMPRESSOR);
        this.setStepSound(Block.soundTypeWood);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData) {
        return new TileEntityCompressor();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
        if (entityPlayer == null) return false;

        TileEntityCompressor tileEntityCompressor = (TileEntityCompressor) world.getTileEntity(x, y, z);
        if (tileEntityCompressor == null) return false;

        if (entityPlayer.isSneaking()) {
            if (entityPlayer.getCurrentEquippedItem() == null && tileEntityCompressor.getStackInSlot(0) != null && tileEntityCompressor.canExtractItem(0, null, 0)) {
                if (entityPlayer.inventory.addItemStackToInventory(tileEntityCompressor.getStackInSlot(0))) {
                    tileEntityCompressor.setInventorySlotContents(0, null);
                }
            }
            return true;
        }

        if (entityPlayer.getCurrentEquippedItem() != null) {
            ItemStack equipedItem = entityPlayer.getCurrentEquippedItem();
            System.out.println("Clicked! " + equipedItem.getUnlocalizedName());

            FluidStack fluidItem = FluidContainerRegistry.getFluidForFilledItem(equipedItem);
            if (fluidItem != null) {
                int capacity = tileEntityCompressor.fill(ForgeDirection.UNKNOWN, fluidItem, false);
                System.out.println("" + capacity);
                if (capacity > 0) {
                    String curdName = ""+ModFluids.fluidCurd.getUnlocalizedName();
                    String fluidItemName = ""+fluidItem.getUnlocalizedName();
                    if(curdName.equals(fluidItemName)) {
                        tileEntityCompressor.fill(ForgeDirection.UNKNOWN, fluidItem, true);
                        if (!entityPlayer.capabilities.isCreativeMode) {
                            entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, getContainer(equipedItem));
                        }
                    }
                }
            }
        }

        return true;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntityCompressor tileentityfurnace = (TileEntityCompressor)world.getTileEntity(x, y, z);

        if (tileentityfurnace != null)
        {
            for (int i1 = 0; i1 < tileentityfurnace.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = tileentityfurnace.getStackInSlot(i1);

                if (itemstack != null)
                {
                    float f = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
                    float f2 = world.rand.nextFloat() * 0.8F + 0.1F;

                    while (itemstack.stackSize > 0)
                    {
                        int j1 = world.rand.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }

                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)world.rand.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)world.rand.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)world.rand.nextGaussian() * f3);
                        world.spawnEntityInWorld(entityitem);
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, metadata);
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