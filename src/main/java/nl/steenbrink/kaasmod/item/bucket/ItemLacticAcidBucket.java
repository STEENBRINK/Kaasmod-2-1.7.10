package nl.steenbrink.kaasmod.item.bucket;

import net.minecraft.block.Block;
import nl.steenbrink.kaasmod.reference.Names;

public class ItemLacticAcidBucket extends ItemBucketBase
    {
        public ItemLacticAcidBucket(Block block){
        super(block);
        this.setUnlocalizedName(Names.Items.LACTIC_ACID_BUCKET);
    }
}
