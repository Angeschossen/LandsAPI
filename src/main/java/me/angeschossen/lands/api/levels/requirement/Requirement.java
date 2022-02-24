package me.angeschossen.lands.api.levels.requirement;

import me.angeschossen.lands.api.MemberHolder;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class Requirement implements me.angeschossen.lands.api.levels.Requirement {


    public Requirement(@NotNull Plugin plugin, @NotNull String name, @NotNull String title, @NotNull List<String> description, float required, @NotNull String requiredDisplay) {

    }


    @Override
    public @NotNull Plugin getPlugin() {
        return null;
    }

    @Override
    public final float getRequired() {
        return 0;
    }

    @Override
    @NotNull
    public String getProgressDisplay(@NotNull MemberHolder memberHolder) {
        return null;
    }

    @Override
    public final float getProgress(@NotNull MemberHolder memberHolder) {
        return 0;
    }

    @Override
    public boolean matches(@NotNull MemberHolder memberHolder) {
        return false;
    }

    @Override
    public @NotNull List<String> getDescription() {
        return null;
    }

    @Override
    @NotNull
    public final String getName() {
        return null;
    }

    @Override
    public @NotNull String getTitle() {
        return null;
    }
}
