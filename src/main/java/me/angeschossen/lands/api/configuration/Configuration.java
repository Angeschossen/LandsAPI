package me.angeschossen.lands.api.configuration;

import org.jetbrains.annotations.NotNull;

public interface Configuration {
    /**
     * Get configuration options for wars.
     * @return never null
     */
    @NotNull WarsConfig getWarsConfig();

    /**
     * Get configuration options for nations.
     * @return never null
     */
    @NotNull NationsConfig getNationsConfig();
}
