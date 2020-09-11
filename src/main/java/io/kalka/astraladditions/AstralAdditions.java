package io.kalka.astraladditions;

import hellfirepvp.astralsorcery.common.base.MoonPhase;
import hellfirepvp.astralsorcery.common.constellation.ConstellationBase;
import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import hellfirepvp.astralsorcery.common.constellation.IWeakConstellation;
import hellfirepvp.astralsorcery.common.constellation.star.StarLocation;
import hellfirepvp.astralsorcery.common.crystal.CrystalProperty;
import hellfirepvp.astralsorcery.common.crystal.property.PropertyConstellation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.awt.*;

@Mod(AstralAdditions.MODID)
public class AstralAdditions {

    public static final String MODID = "astraladditions";
    // TODO: put these into their respective classes
    public static IWeakConstellation vulpecula;
    public static IWeakConstellation praeteritus;


    // TODO: Figure out how to change the pitch on the altar if it's a specific constellation
    public AstralAdditions() {
        buildConstellations();
    }

    private void doSetup(final FMLCommonSetupEvent event) {
        System.out.println("Astral Additions CommonSetupEvent!"); // Notify that this fired
    }

    // TODO: also put these into their respective classfiles...
    //  already a bit messy, but i'm just getting started :V
    private static void buildConstellations() {
        StarLocation sl1, sl2, sl3, sl4, sl5, sl6, sl7;

        praeteritus = new ConstellationBase.Weak("praeteritus", new Color(0x417DDA));
        sl1 = praeteritus.addStar(3, 18);
        sl2 = praeteritus.addStar(10, 14);
        sl3 = praeteritus.addStar(15, 15);
        sl4 = praeteritus.addStar(20, 16);
        sl5 = praeteritus.addStar(28, 12);
        sl6 = praeteritus.addStar(29, 18);
        sl7 = praeteritus.addStar(23, 22);

        praeteritus.addConnection(sl1, sl2);
        praeteritus.addConnection(sl2, sl3);
        praeteritus.addConnection(sl3, sl4);
        praeteritus.addConnection(sl4, sl5);
        praeteritus.addConnection(sl5, sl6);
        praeteritus.addConnection(sl6, sl7);
        praeteritus.addConnection(sl7, sl4);

        vulpecula = new ConstellationBase.Weak("vulpecula", new Color(0xAD3232));
        sl1 = vulpecula.addStar(2, 2);
        sl2 = vulpecula.addStar(11, 8);
        sl3 = vulpecula.addStar(16, 10);
        sl4 = vulpecula.addStar(18, 13);
        sl5 = vulpecula.addStar(25, 12);
        sl6 = vulpecula.addStar(27, 17);
        sl7 = vulpecula.addStar(6, 18);

        vulpecula.addConnection(sl1, sl2);
        vulpecula.addConnection(sl2, sl3);
        vulpecula.addConnection(sl3, sl4);
        vulpecula.addConnection(sl4, sl5);
        vulpecula.addConnection(sl5, sl6);
        vulpecula.addConnection(sl4, sl7);
    }


    // What we use to hook into AS registry
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
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
