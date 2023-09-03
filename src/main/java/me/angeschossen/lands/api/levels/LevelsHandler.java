package me.angeschossen.lands.api.levels;

import me.angeschossen.lands.api.levels.requirement.CachedRequirement;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Used to handle levels and their progression.
 */
public interface LevelsHandler {
    /**
     * Get all levels that can be applied to lands ({@link me.angeschossen.lands.api.land.Land}).
     * @return collection of levels that can be applied to lands
     */
    @NotNull List<? extends Level> getLandLevels();

    /**
     * Register a cached requirement that affects lands
     * @param requirement the cached requirement
     */
    void registerCachedLandRequirement(@NotNull CachedRequirement requirement);

    /**
     * Check if there's a cached requirement ({@link CachedRequirement}) with that name that affects lands.
     * @param name unique name
     * @return true, if there's an cached requirement with that name, that affects lands
     */
    boolean isCachedLandRequirement(@NotNull String name);

    /**
     * Check if there's a cached requirement ({@link CachedRequirement}) with that name that affects nations.
     * @param name unique name
     * @return true, if there's an cached requirement with that name, that affects nations
     */
    boolean isCachedNationRequirement(@NotNull String name);

    /**
     * Register a cached requirement that affects nations
     * @param requirement the cached requirement
     */
    void registerCachedNationRequirement(@NotNull CachedRequirement requirement);

    /**
     * Get all levels that can be applied to nations ({@link me.angeschossen.lands.api.nation.Nation}).
     * @return collection of levels that can be applied to nations
     */
    @NotNull List<? extends Level> getNationLevels();

    /**
     * Get the land configuration section from the "levels.yml" configuration file.
     * @return land level configuration section
     */
    @Nullable Map<Level, ConfigurationSection> getLandSection();

    /**
     * Get the nation configuration section from the "levels.yml" configuration file.
     * @return nation level configuration section
     */
    @Nullable Map<Level, ConfigurationSection> getNationSection();
}
