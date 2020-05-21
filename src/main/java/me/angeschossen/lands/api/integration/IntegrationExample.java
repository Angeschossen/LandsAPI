package me.angeschossen.lands.api.integration;

import me.angeschossen.lands.api.land.LandArea;
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
        final LandArea area = landsAddon.getArea(location);
        //Do some stuff.
    }
}
