package nl.steenbrink.kaasmod.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import nl.steenbrink.kaasmod.init.ModItems;

public class EntityEventHandler {

    @SubscribeEvent
    public void onLivingDropsEvent(LivingDropsEvent event) {
        if (event.entityLiving instanceof EntityCow && event.entityLiving.isChild()) {
            EntityCow entityCow = (EntityCow) event.entityLiving;
            EntityItem itemEntity = new EntityItem(entityCow.worldObj, entityCow.posX, entityCow.posY, entityCow.posZ, new ItemStack(ModItems.itemStomach));
            event.drops.add(itemEntity);
        }
    }

}
