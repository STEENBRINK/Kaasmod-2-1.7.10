package nl.steenbrink.kaasmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.utility.UnlocalizedNameHelper;

public class BlockBasicSlab extends BlockSlab {
    public BlockBasicSlab(boolean isFull, Material material, Block original) {
        super(isFull, material);
        this.getOriginalTexture(original);
        this.getFull(isFull);
        if(!isFull) {
            this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
            this.isOpaqueCube();
            this.getUseNeighborBrightness();
            this.setLightOpacity(255);
        }
    }
    public String originalTexture;
    public boolean isFull;

    public void getOriginalTexture(Block textureBlock){
        originalTexture = textureBlock.getUnlocalizedName();
    }
    public void getFull(boolean full) { isFull = full;}

    @Override
    public String func_150002_b(int i) {
        if(!isFull) {
            return this.getUnlocalizedName() + "Full";
        } else {
            return null;
        }
    }

    @Override
    public String getUnlocalizedName() {
        return UnlocalizedNameHelper.getUnlocalizedBlockName(super.getUnlocalizedName());
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(UnlocalizedNameHelper.getUnwrappedUnlocalizedName(originalTexture));
    }

    protected ItemStack createStackedBlock(int i){
        if(!isFull) {
            if (this.getUnlocalizedName().equals("cheeseBricksSlab")) {
                return new ItemStack(ModBlocks.blockCheeseBricksFullSlab);
            } else if (this.getUnlocalizedName().equals("smoothCheeseSlab")) {
                return new ItemStack(ModBlocks.blockSmoothCheeseFullSlab);
            } else {return null;}
        } else {
            return null;
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float a, float b, float c) {
        if(!isFull){
            if (this.getUnlocalizedName().equals("cheeseBricksSlab")) {
                if(player.getCurrentEquippedItem().getUnlocalizedName().equals(ModBlocks.blockCheeseBricksSlab)) {
                    world.setBlock(x, y, z, ModBlocks.blockCheeseBricksFullSlab);
                }
            } else if (this.getUnlocalizedName().equals("smoothCheeseSlab")) {
                if(player.getCurrentEquippedItem().getUnlocalizedName().equals(ModBlocks.blockSmoothCheeseSlab)) {
                    world.setBlock(x, y, z, ModBlocks.blockSmoothCheeseFullSlab);
                }
            } else {return false;}
        }
        return true;
    }
}
