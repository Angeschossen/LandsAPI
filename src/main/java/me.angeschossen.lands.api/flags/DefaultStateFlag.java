package me.angeschossen.lands.api.flags;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
@Deprecated
public abstract class DefaultStateFlag extends Flag {

    protected boolean defaultState;

    public DefaultStateFlag(@NotNull Plugin plugin, @NotNull Target target, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {
        super(plugin, target, name, applyInSubAreas, alwaysAllowInWilderness);
    }

    public final boolean getDefaultState() {
        return defaultState;
    }

    @NotNull
    public final Flag setDefaultState(boolean defaultState) {
        this.defaultState = defaultState;
        return this;
    }
}
