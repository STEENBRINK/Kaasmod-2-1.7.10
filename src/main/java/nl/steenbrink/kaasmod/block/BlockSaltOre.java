package nl.steenbrink.kaasmod.block;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import nl.steenbrink.kaasmod.init.ModItems;
import nl.steenbrink.kaasmod.reference.Names;

import java.util.Random;

public class BlockSaltOre extends BlockBasic {

    public BlockSaltOre() {
        super(Material.rock);
        this.setBlockName(Names.Blocks.SALT_ORE);
        this.setHardness(3.0f);
        this.setResistance(5.0f);
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune) {
        return ModItems.itemRawSalt;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        return 1 + random.nextInt(fortune + 1);
    }
}
