package nl.steenbrink.kaasmod.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.*;
import nl.steenbrink.kaasmod.init.ModFluids;

public class TileEntityStirlingMachine extends TileEntity implements IFluidHandler
{
    public TileEntityStirlingMachine()
    {
        super();
    }

    private boolean shouldUpdate = true;
    private boolean isCrafting = false;
    private int craftingTimer = 0;

    public FluidStack fluidStack = new FluidStack(0, 0);
    public int fluidCapacity = 1000;

    @Override
    public void updateEntity()
    {
        if (this.shouldUpdate) {
            this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            this.shouldUpdate = false;
        }
        super.updateEntity();
        if (this.worldObj.isRemote) return;

        // Using the inserted items
        if (this.fluidStack != null && !isCrafting) {
            // Applying crafting possibilities
            if (this.fluidStack.getFluid() == ModFluids.fluidCurdledMilk) {
                this.isCrafting = true;
                this.craftingTimer = 20 * 120;
            }
        }

        // Updating crafting timer
        if (isCrafting) {
            if (this.fluidStack == null || this.fluidStack.amount == 0) { // IDEA keeps bitching about this.fluidstack possibly being null, athough it is impossible
                this.isCrafting = false;
                this.craftingTimer = 0;
            } else {
                craftingTimer--;
                if (craftingTimer % 20 == 0) {
                    this.shouldUpdate = true;
                    //System.out.println("Updated!");
                }
                if (craftingTimer <= 0) {
                    this.fluidStack = new FluidStack(ModFluids.fluidCurd, fluidStack.amount);
                    this.isCrafting = false;
                    this.craftingTimer = 0;
                    this.shouldUpdate = true;
                }
            }
        }
    }

     @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);

        // Read the crafting status
        this.isCrafting = nbtTagCompound.getBoolean("IsCrafting");
        this.craftingTimer = nbtTagCompound.getInteger("CraftingTimer");

        // Read the internal fluidStack
        if (nbtTagCompound.hasKey("Fluid")) {
            NBTTagCompound fluidCompound = nbtTagCompound.getCompoundTag("Fluid");
            this.fluidStack = FluidStack.loadFluidStackFromNBT(fluidCompound);
        } else {
            this.fluidStack = new FluidStack(0, 0);
        }

        this.shouldUpdate = true;
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
        if (resource.getFluid() != ModFluids.fluidCurdledMilk) return 0;
        //if (from != ForgeDirection.NORTH) return 0;

        if (!doFill) {
            return Math.min(resource.amount, capacity);
        } else {
            if (fluidStack.amount == 0) {
                if (resource.amount > fluidCapacity) {
                    fluidStack = new FluidStack(resource.fluidID, fluidCapacity);
                    return fluidCapacity;
                } else {
                    fluidStack = new FluidStack(resource.fluidID, resource.amount);
                    return resource.amount;
                }
            } else if (resource.fluidID == fluidStack.fluidID) {
                int insertAmount = Math.min(resource.amount, fluidCapacity);
                fluidStack = new FluidStack(resource.fluidID, insertAmount);
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
        if (fluidStack.amount == 0 || fluidStack.fluidID == 0) return new FluidStack(0, 0);
        this.shouldUpdate = true;
        int drainAmount = Math.min(maxDrain, fluidStack.amount);

        if (!doDrain) {
            return new FluidStack(FluidRegistry.getFluid(fluidStack.fluidID), drainAmount);
        } else {
            FluidStack drained = new FluidStack(FluidRegistry.getFluid(fluidStack.fluidID), drainAmount);
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
}