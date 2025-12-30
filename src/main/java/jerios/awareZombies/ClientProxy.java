package jerios.awareZombies;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import jerios.awareZombies.entity.EntityBlood;
import jerios.awareZombies.entity.EntityBloodRender;

public class ClientProxy extends CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityBlood.class, new EntityBloodRender());

    }
}
