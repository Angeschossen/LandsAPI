package me.angeschossen.lands.api.levels;

import me.angeschossen.lands.api.MemberHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Requirement {
    @NotNull
    String getName();

    @NotNull
    String getTitle();

    float getValue(@NotNull MemberHolder memberHolder);

    float getProgress(@NotNull MemberHolder memberHolder);

    @NotNull
    List<String> getDescription();

    float getRequired();

    @NotNull String getProgressDisplay(@NotNull MemberHolder memberHolder);

    @NotNull Plugin getPlugin();

    boolean matches(@NotNull MemberHolder memberHolder);
}
