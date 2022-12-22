package me.angeschossen.lands.api.flags.types;

import me.angeschossen.lands.api.flags.DefaultStateFlag;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
@Deprecated
public class PlayerFlag extends DefaultStateFlag {

    public PlayerFlag(@NotNull Plugin plugin,@NotNull String name) {
        super(plugin, Target.PLAYER, name, true, false);
    }

    @Override
    public @NotNull Module getModule() {
        return Module.LAND;
    }

    @Override
    public @NotNull String getTogglePerm() {
        return "lands.player.setting." + name;
    }
}
