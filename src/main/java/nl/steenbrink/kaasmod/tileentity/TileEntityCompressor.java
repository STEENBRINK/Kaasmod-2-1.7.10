package nl.steenbrink.kaasmod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;
import nl.steenbrink.kaasmod.Kaasmod;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.init.ModFluids;
import nl.steenbrink.kaasmod.init.ModItems;
import nl.steenbrink.kaasmod.reference.Names;

public class TileEntityCompressor extends TileEntity implements IFluidHandler, ISidedInventory
{
    public TileEntityCompressor() { super(); }

    private boolean shouldUpdate = true;
    private boolean isCrafting = false;
    public int craftingTimer = 0;

    public FluidStack fluidStack = new FluidStack(0, 0);
    public int fluidCapacity = 1000;

    private ItemStack[] inventory = new ItemStack[1];

    @Override
    public void updateEntity()
    {
        if (this.shouldUpdate) {
            this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            this.shouldUpdate = false;
        }
        super.updateEntity();
        if (this.fluidStack!= null && !isCrafting) {
            //Apply crafting here
            if (this.fluidStack.getFluid() == ModFluids.fluidCurd) {
                this.isCrafting = true;
                this.craftingTimer = 20 * 10;
            }
        }

        //Update Timer
        if (isCrafting) {
            if (this.fluidStack == null || this.fluidStack.amount == 0) { //the null check is for idea wich keeps bitching, even though it is impossible
                this.isCrafting = false;
                this.craftingTimer = 0;
            }else{
                craftingTimer--;
                if (craftingTimer % 20 == 0) {
                    this.shouldUpdate = true;
                    System.out.println("Updated! Tick" + craftingTimer);
                }
                if (craftingTimer <= 0) {
                    // crafting outcome
                    this.isCrafting = false;
                    this.craftingTimer = 0;
                    this.fluidStack.amount = 0;
                    this.setInventorySlotContents(0, new ItemStack(ModBlocks.blockYoungCheese));
                    this.shouldUpdate = true;
                    System.out.println("Done!" + this.getStackInSlot(0).getUnlocalizedName());
                }
            }
        }

    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        // Write the crafting status
        nbtTagCompound.setBoolean("IsCrafting", isCrafting);
        nbtTagCompound.setInteger("CraftingTimer", craftingTimer);

        // Save the internal fluidStack
        if (this.fluidStack.getFluid() != null) {
            NBTTagCompound fluidCompound = new NBTTagCompound();
            this.fluidStack.writeToNBT(fluidCompound);
            nbtTagCompound.setTag("Fluid", fluidCompound);
        }
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

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
    {
        int capacity = fluidCapacity - fluidStack.amount;
        this.shouldUpdate = true;

        if (!canFill(from, resource.getFluid())) return 0;
        if (resource.getFluid() != ModFluids.fluidCurd) return 0;
        //if (from != ForgeDirection.NORTH) return 0;

        if (!doFill) {
            return Math.min(resource.amount, capacity);
        } else {
            if (fluidStack.amount == 0) {
                if (resource.amount > fluidCapacity) {
                    fluidStack = new FluidStack(resource.getFluidID(), fluidCapacity);
                    return fluidCapacity;
                } else {
                    fluidStack = new FluidStack(resource.getFluidID(), resource.amount);
                    return resource.amount;
                }
            } else if (resource.getFluidID() == fluidStack.getFluidID()) {
                int insertAmount = Math.min(resource.amount, fluidCapacity);
                fluidStack = new FluidStack(resource.getFluidID(), insertAmount);
                return insertAmount;
            }
        }
        return 0;
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
    {
        if (resource == null || !resource.isFluidEqual(fluidStack)) return null;

        return this.drain(from, resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
        if (!canDrain(from, null)) return new FluidStack(0, 0);
        if (fluidStack.amount == 0 || fluidStack.getFluidID() == 0) return new FluidStack(0, 0);
        this.shouldUpdate = true;
        int drainAmount = Math.min(maxDrain, fluidStack.amount);

        if (!doDrain) {
            return new FluidStack(FluidRegistry.getFluid(fluidStack.getFluidID()), drainAmount);
        } else {
            FluidStack drained = new FluidStack(FluidRegistry.getFluid(fluidStack.getFluidID()), drainAmount);
            fluidStack.amount -= drainAmount;
            return drained;
        }
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid)
    {
        return !isCrafting;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid)
    {
        return !isCrafting;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from)
    {
        return new FluidTankInfo[]{new FluidTankInfo(fluidStack, fluidCapacity)};
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
        return !isCrafting;
    }

    @Override
    public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
        return !isCrafting;
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) { return this.inventory[slot]; }

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
        this.inventory[slot] = itemStack;
        this.shouldUpdate = true;
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
