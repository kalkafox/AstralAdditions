package io.kalka.astraladditions.common.constellations;

import hellfirepvp.astralsorcery.common.constellation.ConstellationBase;
import hellfirepvp.astralsorcery.common.constellation.IConstellation;
import hellfirepvp.astralsorcery.common.constellation.star.StarLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.awt.*;

import static io.kalka.astraladditions.common.lib.ConstellationsAA.*;

public class RegistryConstellationsAA {

    public static void init() {
        buildConstellations();
    }

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
}
