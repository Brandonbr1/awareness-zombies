package jerios.awareZombies;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import jerios.awareZombies.ai.SmartZombieAI;
import jerios.awareZombies.entity.EntityBlood;

@Mod(
    modid = AwareZombies.MODID,
    version = Properities.VERSION,
    name = "Situationally Aware Zombies",
    acceptedMinecraftVersions = "[1.7.10]")
public class AwareZombies {

    public static final String MODID = "awareZombies";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "jerios.awareZombies.ClientProxy", serverSide = "jerios.awareZombies.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        MinecraftForge.EVENT_BUS.register(this);
        EntityRegistry
            .registerModEntity(EntityBlood.class, "Blood", 2, this, Config.trackRange, Config.updateFreq, false);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @SubscribeEvent
    public void onZombieSpawn(LivingSpawnEvent e) {
        if (e.entityLiving instanceof EntityZombie) {
            ZombieAwarenessData.INSTANCE.zombieCount++;
        }
        if (e.entityLiving instanceof EntityMob) {
            this.applySmartAi((EntityMob) e.entityLiving);
        }
    }

    @SubscribeEvent
    public void onZombieDeath(LivingDeathEvent e) {
        if (e.entityLiving instanceof EntityZombie) {
            ZombieAwarenessData.INSTANCE.zombieCount--;
        }
    }

    private void applySmartAi(EntityMob e) {
        e.targetTasks.addTask(Config.aiPir, new SmartZombieAI(e));
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
