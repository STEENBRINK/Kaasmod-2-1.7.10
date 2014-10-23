package nl.steenbrink.kaasmod.item.bucket;

import net.minecraft.block.Block;
import nl.steenbrink.kaasmod.reference.Names;

public class ItemRennetBucket extends ItemBucketBase
    {
        public ItemRennetBucket(Block block){
        super(block);
        this.setUnlocalizedName(Names.Items.RENNET_BUCKET);
    }
}
