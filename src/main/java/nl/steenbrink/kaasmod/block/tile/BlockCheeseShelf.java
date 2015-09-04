package nl.steenbrink.kaasmod.block.tile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import nl.steenbrink.kaasmod.reference.Names;

public class BlockCheeseShelf extends BlockBasicTile{
    public BlockCheeseShelf() {
        super(Material.wood);
        this.setBlockName(Names.Blocks.CHEESE_SHELF);
        this.setStepSound(Block.soundTypeWood);
    }
}
