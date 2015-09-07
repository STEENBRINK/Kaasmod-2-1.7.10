package nl.steenbrink.kaasmod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import nl.steenbrink.kaasmod.init.ModBlocks;

public class TileEntityCheeseShelf extends TileEntity implements ISidedInventory{

    public TileEntityCheeseShelf() {
        super();
    }

    private boolean shouldUpdate = true;
    private boolean isCrafting = false;
    private int craftingTimer = 0;

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
        if (this.getStackInSlot(0) != null && !isCrafting) {
            // Applying crafting possibilities
            if(this.inventory[0] == new ItemStack(ModBlocks.blockYoungCheese)) {
                this.isCrafting = true;
                this.craftingTimer = 120 * 20;
            }
            }

        // Updating crafting timer
        if (isCrafting) {
            if (getStackInSlot(0) == null) {
                this.isCrafting = false;
                this.craftingTimer = 0;
            } else {
                craftingTimer--;
                if (craftingTimer % 20 == 0) this.shouldUpdate = true;
                if (craftingTimer <= 0) {
                    //Crafting
                    this.setInventorySlotContents(0, new ItemStack(ModBlocks.blockCheese));
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
        this.shouldUpdate = true;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);

        // Write the crafting status
        nbtTagCompound.setBoolean("IsCrafting", isCrafting);
        nbtTagCompound.setInteger("CraftingTimer", craftingTimer);

        // Write the inventory
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

    public boolean isCrafting() {
        return isCrafting;
    }

    /* --- ISidedInventory --- */
    @Override
    public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
        return new int[]{0};
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
    public ItemStack getStackInSlot(int slot) {
        return this.inventory[slot];
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
