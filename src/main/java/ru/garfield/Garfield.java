package ru.garfield;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Garfield implements ClientModInitializer {

    public static final String MOD_ID = "garfield";
    public static final Logger LOGGER =
            LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Garfield Liquid Glass loaded!");
    }
}
