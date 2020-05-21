package me.angeschossen.lands.api.integration;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

/*
This class is just a example. It's not part of the API.
 */

public class IntegrationExample {

    private final LandsIntegration landsAddon;

    private IntegrationExample(Plugin yourPlugin) {

        /*
        Initialize LandsAddon
         */
        landsAddon = new LandsIntegration(yourPlugin);
    }

    //Just a test
    private void test(Location location) {
        final Land land = landsAddon.getLand("Test");
        //Do some stuff.
    }
}
