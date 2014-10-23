package nl.steenbrink.kaasmod.item.bucket;

import net.minecraft.block.Block;
import nl.steenbrink.kaasmod.reference.Names;

public class ItemVinegarBucket extends ItemBucketBase
{
    public ItemVinegarBucket(Block block){
        super(block);
        this.setUnlocalizedName(Names.Items.VINEGAR_BUCKET);
    }
}
