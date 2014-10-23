package nl.steenbrink.kaasmod.item.bucket;

import net.minecraft.block.Block;
import nl.steenbrink.kaasmod.reference.Names;

public class ItemSaltWaterBucket extends ItemBucketBase
{
    public ItemSaltWaterBucket(Block block){
        super(block);
        this.setUnlocalizedName(Names.Items.SALT_WATER_BUCKET);
    }
}
