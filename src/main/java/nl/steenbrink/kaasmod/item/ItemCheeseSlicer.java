package nl.steenbrink.kaasmod.item;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.init.ModBlocks;
import nl.steenbrink.kaasmod.reference.Names;

import java.util.Set;

public class ItemCheeseSlicer extends ItemTool{
    private static final Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{ModBlocks.blockCheese});



    public ItemCheeseSlicer() {
        super(4.0f, ToolMaterial.IRON, blocksEffectiveAgainst);
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
        this.setUnlocalizedName(Names.Items.CHEESE_SLICER);
    }

}
