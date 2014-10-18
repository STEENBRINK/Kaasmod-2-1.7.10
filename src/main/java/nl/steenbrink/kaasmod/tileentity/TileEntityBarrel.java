package nl.steenbrink.kaasmod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileEntityBarrel extends TileEntity implements IFluidHandler, ISidedInventory {

    public TileEntityBarrel() {
        super();
    }

    public FluidStack fluidStack = new FluidStack(0, 0);
    private int fluidCapacity = 1000;

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        // Read the internal fluidStack
        NBTTagCompound fluidCompound = nbtTagCompound.getCompoundTag("Fluid");
        this.fluidStack = FluidStack.loadFluidStackFromNBT(fluidCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        // Save the internal fluidStack
        NBTTagCompound fluidCompound = new NBTTagCompound();
        this.fluidStack.writeToNBT(fluidCompound);
        nbtTagCompound.setTag("Fluid", fluidCompound);
    }

    /* --- IFluidHandler --- */
    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        //Simulate the fill to see if there is room for incoming liquids.
        int capacity = fluidCapacity - fluidStack.amount;

        if (!doFill) {
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
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return false;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public ItemStack getStackInSlot(int p_70301_1_) {
        return null;
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
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {

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
        return 0;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
        return false;
    }
}
