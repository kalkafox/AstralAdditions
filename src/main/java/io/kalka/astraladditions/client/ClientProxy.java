package io.kalka.astraladditions.client;

import io.kalka.astraladditions.common.CommonProxy;

public class ClientProxy extends CommonProxy {

    @Override
    public void initialize() {
        System.out.println("This happened on the client");
    }

}
