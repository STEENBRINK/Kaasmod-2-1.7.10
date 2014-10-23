package nl.steenbrink.kaasmod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;
import nl.steenbrink.kaasmod.init.ModFluids;
import nl.steenbrink.kaasmod.init.ModItems;

public class TileEntityBarrel extends TileEntity implements IFluidHandler, ISidedInventory {

    public TileEntityBarrel() {
        super();
    }

    private boolean shouldUpdate = true;

    public FluidStack fluidStack = new FluidStack(0, 0);
    public int fluidCapacity = 1000;

    private ItemStack[] inventory = new ItemStack[1];

    @Override
    public void updateEntity() {
        if (this.shouldUpdate) {
            this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            this.shouldUpdate = false;
        }
        super.updateEntity();
        if (this.worldObj.isRemote) return;

        // Using the inserted items
        if (this.getStackInSlot(0) != null) {
            // Turning Water into SaltWater
            if (this.fluidStack.getFluid() == FluidRegistry.WATER && this.getStackInSlot(0).getItem() == ModItems.itemRawSalt) {
                this.setInventorySlotContents(0, null);
                this.fluidStack.fluidID = ModFluids.fluidSaltWater.getID();
                this.shouldUpdate = true;
            }
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        // Read the internal fluidStack
        if (nbtTagCompound.hasKey("Fluid")) {
            NBTTagCompound fluidCompound = nbtTagCompound.getCompoundTag("Fluid");
            this.fluidStack = FluidStack.loadFluidStackFromNBT(fluidCompound);
        }

        // Read the inventory
        NBTTagList inventoryList = nbtTagCompound.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < inventoryList.tagCount(); ++i) {
            NBTTagCompound tagCompound = inventoryList.getCompoundTagAt(i);
            int j = tagCompound.getByte("Slot") & 255;
            if (j >= 0 && j < this.inventory.length) {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        // Save the internal fluidStack
        if (this.fluidStack.getFluid() != null) {
            NBTTagCompound fluidCompound = new NBTTagCompound();
            this.fluidStack.writeToNBT(fluidCompound);
            nbtTagCompound.setTag("Fluid", fluidCompound);
        }

        // Write the inventorty
        NBTTagList inventoryList = new NBTTagList();
        for (int i = 0; i < this.inventory.length; ++i) {
            if (this.inventory[i] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) i);
                this.inventory[i].writeToNBT(tagCompound);
                inventoryList.appendTag(tagCompound);
            }
        }
        nbtTagCompound.setTag("Items", inventoryList);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);

        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, this.blockMetadata, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound tag = pkt.func_148857_g();
        readFromNBT(tag);
    }

    /* --- IFluidHandler --- */
    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        this.shouldUpdate = true;

        int capacity = fluidCapacity - fluidStack.amount;

        if (!doFill) {
            if (resource.fluidID != fluidStack.fluidID && fluidStack.amount > 0) return 0;
            return Math.min(resource.amount, capacity);
        } else {
            if (fluidStack.amount == 0) {
                if (resource.fluidID != fluidStack.fluidID) {
                    fluidStack = new FluidStack(resource.fluidID, resource.amount);
                } else {
                    fluidStack.amount = resource.amount;
                }
                return resource.amount;
            } else if (resource.fluidID == fluidStack.fluidID) {
                if (capacity >= resource.amount) {
                    fluidStack.amount += resource.amount;
                    return resource.amount;
                } else {
                    fluidStack.amount = fluidCapacity;
                    return capacity;
                }
            }
        }

        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if (resource == null || !resource.isFluidEqual(fluidStack))
            return null;

        return this.drain(from, resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
        this.shouldUpdate = true;

        if (fluidStack.fluidID == 0) return new FluidStack(0, 0);
        if (!doDrain) {
            if (fluidStack.amount >= maxDrain) {
                return new FluidStack(FluidRegistry.getFluid(fluidStack.fluidID), maxDrain);
            } else {
                return new FluidStack(FluidRegistry.getFluid(fluidStack.fluidID), fluidStack.amount);
            }
        } else {
            int drainAmount = Math.min(fluidStack.amount, maxDrain);
            FluidStack drained = new FluidStack(FluidRegistry.getFluid(fluidStack.fluidID), drainAmount);
            fluidStack.amount -= maxDrain;
            return drained;
        }
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return true;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return true;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[]{new FluidTankInfo(fluidStack, fluidCapacity)};
    }

    /* --- ISidedInventory --- */
    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[]{0};
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return true;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return true;
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack) {
        inventory[slot] = itemStack;
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        return true;
    }

    @Override
    public void openInventory() {
    }

    @Override
    public void closeInventory() {
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return true;
    }
}
