package me.angeschossen.lands.api.flags.types;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
@Deprecated
public class NationRoleFlag extends RoleFlag {

    public NationRoleFlag(@NotNull Plugin plugin, @NotNull String name) {
        super(plugin, Category.MANAGEMENT, name, false, true);
    }

    @Override
    public final @NotNull String getTogglePerm() {
        return "nations.setting." + name;
    }

    @Override
    public final @NotNull String getBypassPerm() {
        return "nations.bypass." + name;
    }

    @Override
    public final @NotNull String getBypassPermWild() {
        return "nations.bypass.wilderness." + name;
    }

    @Override
    @NotNull
    public final Module getModule() {
        return Module.NATION;
    }
}
