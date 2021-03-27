package me.angeschossen.lands.api.flags.types;

import me.angeschossen.lands.api.flags.Flag;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class LandFlag extends Flag {

    /**
     *
     * @param plugin Your plugin.
     * @param name The name of the flag.
     * @param applyInSubAreas Should this flag also be available in sub areas, not just the land in general?
     * @param alwaysAllowInWilderness Should this flag always be true in wilderness?
     */
    public LandFlag(@NotNull Plugin plugin, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {
        super(plugin, name, applyInSubAreas, alwaysAllowInWilderness);
    }

    public LandFlag(@NotNull Plugin plugin, @NotNull String name, boolean applyInSubAreas) {
        this(plugin, name, applyInSubAreas, false);
    }

    public LandFlag(@NotNull Plugin plugin, @NotNull String name) {
        this(plugin, name, true, false);
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
        return Module.LAND;
    }

    @Override
    public final @NotNull String getTogglePerm() {
        return null;
    }

    @Override
    public @NotNull Type getType() {
        return Type.LAND;
    }
}
