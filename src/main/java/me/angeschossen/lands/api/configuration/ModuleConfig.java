package me.angeschossen.lands.api.configuration;

import com.github.angeschossen.pluginframework.api.configuration.Configuration;

public interface ModuleConfig extends Configuration {

    /**
     * Modules such as wars and nations can be disabled.
     * @return true, if this module is disabled
     */
    boolean isEnabled();
}
