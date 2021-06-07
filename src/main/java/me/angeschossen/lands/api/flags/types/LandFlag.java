package me.angeschossen.lands.api.flags.types;

import me.angeschossen.lands.api.flags.Flag;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class LandFlag extends Flag {


    /**
     * @param plugin                  Your plugin.
     * @param name                    The name of the flag.
     * @param applyInSubAreas         Should this flag also be available in sub areas, not just the land in general?
     * @param alwaysAllowInWilderness Should this flag always be true in wilderness?
     */
    public LandFlag(@NotNull Plugin plugin, @NotNull Target target, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {
        super(plugin, target, name, applyInSubAreas, alwaysAllowInWilderness);
    }

    public LandFlag(@NotNull Plugin plugin, @NotNull String name) {
        this(plugin, Target.PLAYER, name, true, false);
    }

    public boolean getDefaultState() {
        return false;
    }

    public Flag setDefaultState(boolean defaultState) {
        return this;
    }

    @NotNull
    @Override
    public final Module getModule() {
        return null;
    }

    @Override
    public final @NotNull String getTogglePerm() {
        return null;
    }
}
