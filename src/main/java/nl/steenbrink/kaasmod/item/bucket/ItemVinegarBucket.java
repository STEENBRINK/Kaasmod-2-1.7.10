package nl.steenbrink.kaasmod.item.bucket;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;
import nl.steenbrink.kaasmod.reference.Names;

public class ItemVinegarBucket extends ItemBucket
{
    public ItemVinegarBucket(Block block){
        super(block);
        this.setUnlocalizedName(Names.Items.VINEGAR_BUCKET);
    }
}
