package nl.steenbrink.kaasmod.item.bucket;

import net.minecraft.block.Block;
import nl.steenbrink.kaasmod.reference.Names;

public class ItemCurdBucket extends ItemBucketBase
{
    public ItemCurdBucket(Block block){
    super(block);
    this.setUnlocalizedName(Names.Items.CURD_BUCKET);
}
}
