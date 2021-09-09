package me.angeschossen.lands.api.levels;

import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;


public interface LevelsHandler {
    @NotNull List<? extends Level> getLandLevels();

    @NotNull List<? extends Level> getNationLevels();



    @Nullable Map<Level, ConfigurationSection> getLandSection();

    @Nullable Map<Level, ConfigurationSection> getNationSection();
}
