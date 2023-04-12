package me.angeschossen.lands.api.levels;

import me.angeschossen.lands.api.levels.requirement.CachedRequirement;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;


public interface LevelsHandler {
    @NotNull List<? extends Level> getLandLevels();

    void registerCachedLandRequirement(CachedRequirement requirement);

    boolean isCachedLandRequirement(String name);

    boolean isCachedNationRequirement(String name);

    void registerCachedNationRequirement(CachedRequirement requirement);

    @NotNull List<? extends Level> getNationLevels();

    @Nullable Map<Level, ConfigurationSection> getLandSection();

    @Nullable Map<Level, ConfigurationSection> getNationSection();
}
