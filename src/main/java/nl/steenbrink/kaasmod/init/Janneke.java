package nl.steenbrink.kaasmod.init;


import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.util.ResourceLocation;
import nl.steenbrink.kaasmod.reference.Names;
import nl.steenbrink.kaasmod.reference.Reference;
import nl.steenbrink.kaasmod.villager.JannekeVillagerTrades;

public class Janneke {

    public static void init(){
        VillagerRegistry.instance().registerVillagerId(Names.Villagers.JANNEKE);
        VillagerRegistry.instance().registerVillagerSkin(Names.Villagers.JANNEKE, new ResourceLocation(Reference.PATH_RESOURCES, "textures/entities/villager/Janneke.png"));
        VillagerRegistry.instance().registerVillageTradeHandler(Names.Villagers.JANNEKE, new JannekeVillagerTrades());
        VillagerRegistry.instance().getRegisteredVillagers();
        System.out.println("REGISTERED JANNEKE !!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
