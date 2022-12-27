package me.angeschossen.lands.api.handler;

import com.github.angeschossen.pluginframework.api.configuration.Configuration;
import com.github.angeschossen.pluginframework.api.configuration.gui.GUIConfiguration;
import com.github.angeschossen.pluginframework.api.configuration.messages.Messages;
import com.github.angeschossen.pluginframework.api.utils.StringUtils;
import me.angeschossen.lands.api.LandsIntegration;
import me.angeschossen.lands.api.configuration.ModuleConfig;
import me.angeschossen.lands.api.flags.FlagFactory;
import me.angeschossen.lands.api.flags.FlagRegistry;
import me.angeschossen.lands.api.flags.Flags;
import me.angeschossen.lands.api.levels.LevelsHandler;
import me.angeschossen.lands.api.utils.PlayerUtils;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class APIHandler {

    private static APIHandler instance;
    private final @NotNull Configuration config;
    private final @NotNull ModuleConfig warsConfig, nationsConfig;
    private final @NotNull Plugin plugin;
    private static LandsIntegrationFactory landsIntegrationFactory;
    private final @NotNull GUIConfiguration guiConfiguration;
    private final @NotNull Messages messages;
    private final @NotNull LevelsHandler levelsHandler;
    private final @NotNull LandsIntegration legacySupport;
    private static FlagRegistry flagRegistry;
    private final @NotNull StringUtils stringUtils;
    private final @NotNull PlayerUtils playerUtils;
    private static FlagFactory flagFactory;


    public static FlagFactory getFlagFactory() {
        return flagFactory;
    }

    public ModuleConfig getNationsConfig() {
        return nationsConfig;
    }

    public ModuleConfig getWarsConfig() {
        return warsConfig;
    }

    public Configuration getConfig() {
        return config;
    }

    public static void setBase(LandsIntegrationFactory fac, FlagFactory flagFac, FlagRegistry flagReg) {
        Objects.requireNonNull(fac);
        Objects.requireNonNull(flagFac);
        Objects.requireNonNull(flagReg);

        if (landsIntegrationFactory == null) {
            landsIntegrationFactory = fac;
            flagFactory = flagFac;
            flagRegistry = flagReg;
        }
    }

    private APIHandler(@NotNull Plugin plugin,
                       @NotNull Configuration config,
                       @NotNull ModuleConfig warsConfig, @NotNull ModuleConfig nationsConfig,
                       @NotNull Messages messages, @NotNull GUIConfiguration guiConfiguration,
                       @NotNull LevelsHandler levelsHandler,
                       @NotNull LandsIntegration legacySupport,
                       @NotNull FlagRegistry flagRegistry,
                       @NotNull StringUtils stringUtils,
                       @NotNull PlayerUtils playerUtils) {
        this.config = config;
        this.playerUtils = playerUtils;
        this.legacySupport = legacySupport;
        this.warsConfig = warsConfig;
        this.nationsConfig = nationsConfig;
        this.plugin = plugin;
        this.messages = messages;
        this.flagRegistry = flagRegistry;
        this.guiConfiguration = guiConfiguration;
        this.levelsHandler = levelsHandler;
        this.stringUtils = stringUtils;
    }

    @NotNull
    public static LandsIntegrationFactory getLandsIntegrationFactory() {
        return landsIntegrationFactory;
    }

    public LandsIntegration getLegacySupport() {
        return legacySupport;
    }

    public @NotNull Plugin getPlugin() {
        return plugin;
    }

    public GUIConfiguration getGUIConfiguration() {
        return guiConfiguration;
    }

    public Messages getMessages() {
        return messages;
    }

    public PlayerUtils getPlayerUtils() {
        return playerUtils;
    }

    public LevelsHandler getLevelsHandler() {
        return levelsHandler;
    }

    public StringUtils getStringUtils() {
        return stringUtils;
    }

    public static FlagRegistry getFlagRegistry() {
        return flagRegistry;
    }

    public static APIHandler getInstance() {
        return instance;
    }

    public static void init(@NotNull Plugin plugin,
                            @NotNull Configuration config,
                            @NotNull ModuleConfig warsConfig, @NotNull ModuleConfig nationsConfig,
                            @NotNull Messages messages, @NotNull GUIConfiguration guiConfiguration,
                            @NotNull LevelsHandler levelsHandler,
                            @NotNull LandsIntegration legacySupport,
                            @NotNull FlagRegistry flagRegistry,
                            @NotNull StringUtils stringUtils,
                            @NotNull PlayerUtils playerUtils) {
        Objects.requireNonNull(config);
        Objects.requireNonNull(warsConfig);
        Objects.requireNonNull(nationsConfig);

        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }

        instance = new APIHandler(plugin,
                config, warsConfig, nationsConfig,
                messages, guiConfiguration,
                levelsHandler,
                legacySupport,
                flagRegistry,
                stringUtils,
                playerUtils);

        Flags.initializeLegacySupport();
    }
}
