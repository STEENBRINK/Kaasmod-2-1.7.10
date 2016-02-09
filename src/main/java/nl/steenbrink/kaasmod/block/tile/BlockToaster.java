package nl.steenbrink.kaasmod.block.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.init.ModItems;
import nl.steenbrink.kaasmod.reference.Names;
import nl.steenbrink.kaasmod.tileentity.TileEntitiyToaster;
import nl.steenbrink.kaasmod.tileentity.TileEntityCheeseShelf;

public class BlockToaster extends BlockBasicTile{
    public BlockToaster() {
        super(Material.iron);
        this.setBlockName(Names.Blocks.TOASTER);
        this.setStepSound(Block.soundTypeMetal);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metaData) { return new TileEntitiyToaster(); }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ) {
        //System.out.println("Activated!");
        if (entityPlayer == null) {
            //System.out.println("false!");
            return false;
        }

        TileEntitiyToaster tileEntityToaster = (TileEntitiyToaster) world.getTileEntity(x, y, z);
        if (tileEntityToaster == null) { return false; }

        if (entityPlayer.isSneaking()) {
            //System.out.println("Sne-aking");
            if (entityPlayer.getCurrentEquippedItem() == null && tileEntityToaster.getStackInSlot(0) != null && tileEntityToaster.canExtractItem(0, null, 0)) {
                if (entityPlayer.inventory.addItemStackToInventory(tileEntityToaster.getStackInSlot(0))) {
                    tileEntityToaster.setInventorySlotContents(0, null);
                }
            }
            return true;
        }
        if (entityPlayer.getCurrentEquippedItem() != null) {
            if (entityPlayer.getCurrentEquippedItem().getUnlocalizedName().equals(ModItems.itemCheeseBaconBread.getUnlocalizedName())) {
                //System.out.println("CheeseBaconBread!");
                ItemStack equipedItem = entityPlayer.getCurrentEquippedItem();
                if (tileEntityToaster.getStackInSlot(0) == null) {
                    tileEntityToaster.setInventorySlotContents(0, equipedItem.splitStack(1));
                }
            } //else {
                //System.out.println("false :(");
                //System.out.println(entityPlayer.getCurrentEquippedItem().getUnlocalizedName());
            //}
        }

        return true;
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
        TileEntitiyToaster tileentityfurnace = (TileEntitiyToaster)world.getTileEntity(x, y, z);

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
}
