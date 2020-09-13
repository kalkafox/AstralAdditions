package io.kalka.astraladditions.common;

import io.kalka.astraladditions.common.constellations.RegistryConstellationsAA;

public class CommonProxy {
    public void init() {
        System.out.println("this happened");
        RegistryConstellationsAA.init();
    }

    public void initialize() {
    }
}
