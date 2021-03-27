package me.angeschossen.lands.api.flags.types;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class NationRoleFlag extends RoleFlag {

    public NationRoleFlag(@NotNull Plugin plugin, @NotNull String name) {
        super(plugin, Category.MANAGEMENT, name, false, true);
    }

    @Override
    public final @NotNull String getTogglePerm() {
        return null;
    }

    @Override
    public final @NotNull String getBypassPerm() {
        return null;
    }

    @Override
    public final @NotNull String getBypassPermWild() {
        return null;
    }

    @Override
    @NotNull
    public final Module getModule() {
        return Module.NATION;
    }
}
