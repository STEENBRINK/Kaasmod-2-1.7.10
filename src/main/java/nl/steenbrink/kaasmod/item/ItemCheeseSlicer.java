package nl.steenbrink.kaasmod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemTool;
import nl.steenbrink.kaasmod.creative.CreativeTabKaasmod;
import nl.steenbrink.kaasmod.init.ModBlocks;

import java.util.Set;

public class ItemCheeseSlicer extends ItemTool{
    public static final Block[] blocksEffectiveAgainst = new Block[] {ModBlocks.blockCheese};


    public ItemCheeseSlicer() {
        super(4.0f, 3, );
        this.setCreativeTab(CreativeTabKaasmod.INSTANCE);
    }

}
