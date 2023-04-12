package me.angeschossen.lands.api.flags;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

@Deprecated
public abstract class DefaultStateFlag<T> extends Flag<T> implements me.angeschossen.lands.api.flags.type.parent.DefaultStateFlag<T> {

    protected boolean defaultState;

    public DefaultStateFlag(@NotNull Plugin plugin, @NotNull Target target, @NotNull String name, boolean applyInSubAreas, boolean alwaysAllowInWilderness) {
        super(plugin, target, name, applyInSubAreas, alwaysAllowInWilderness);
    }

    @Override
    public final boolean getDefaultState() {
        return defaultState;
    }

    @NotNull
    @Override
    public final DefaultStateFlag<T> setDefaultState(boolean defaultState) {
        this.defaultState = defaultState;
        return this;
    }
}
