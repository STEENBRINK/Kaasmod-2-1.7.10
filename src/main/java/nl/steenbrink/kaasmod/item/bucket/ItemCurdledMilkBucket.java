package nl.steenbrink.kaasmod.item.bucket;

import net.minecraft.block.Block;
import nl.steenbrink.kaasmod.reference.Names;

public class ItemCurdledMilkBucket extends ItemBucketBase
{
    public ItemCurdledMilkBucket(Block block){
        super(block);
        this.setUnlocalizedName(Names.Items.CURDLED_MILK_BUCKET);
    }
}
