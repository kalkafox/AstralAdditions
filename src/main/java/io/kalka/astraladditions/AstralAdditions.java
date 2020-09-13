package io.kalka.astraladditions;

import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import hellfirepvp.astralsorcery.common.crystal.CrystalProperty;
import hellfirepvp.astralsorcery.common.crystal.property.PropertyConstellation;
import io.kalka.astraladditions.client.ClientProxy;
import io.kalka.astraladditions.common.CommonProxy;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static io.kalka.astraladditions.common.lib.ConstellationsAA.praeteritus;
import static io.kalka.astraladditions.common.lib.ConstellationsAA.vulpecula;

@Mod(AstralAdditions.MODID)
public class AstralAdditions {

    public static final String MODID = "astraladditions";
    // TODO: put these into their respective classes

    private static AstralAdditions instance;

    private final CommonProxy proxy;

    // TODO: Figure out how to change the pitch on the altar if it's a specific constellation
    public AstralAdditions() {
        instance = this;
        this.proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        this.proxy.initialize();
        this.proxy.init();


    }

    private void doSetup(final FMLCommonSetupEvent event) {
        System.out.println("Astral Additions CommonSetupEvent!"); // Notify that this fired
    }

    private void onClientSetup(FMLClientSetupEvent event) {

    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onConstellationRegistry(final RegistryEvent.Register<IConstellation> cstEvent) {
            cstEvent.getRegistry().register(vulpecula);
            cstEvent.getRegistry().register(praeteritus);
        }
        @SubscribeEvent
        public static void onCrystalPropertyRegistry(final RegistryEvent.Register<CrystalProperty> property) {
            property.getRegistry().register(new PropertyConstellation(vulpecula));
            property.getRegistry().register(new PropertyConstellation(praeteritus));
        }
    }
}
