package me.angeschossen.lands.api.flags.types;

import me.angeschossen.lands.api.flags.DefaultStateFlag;
import me.angeschossen.lands.api.flags.enums.FlagModule;
import me.angeschossen.lands.api.handler.APIHandler;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Use {@link me.angeschossen.lands.api.flags.type.PlayerFlag} instead.
 */
@Deprecated
public class PlayerFlag extends DefaultStateFlag<me.angeschossen.lands.api.flags.type.PlayerFlag> implements me.angeschossen.lands.api.flags.type.PlayerFlag {

    public PlayerFlag(@NotNull Plugin plugin, @NotNull String name) {
        super(plugin, Target.PLAYER, name, true, false);
    }

    @Override
    public @NotNull FlagModule getModule() {
        return FlagModule.PLAYER;
    }

    @Override
    protected PlayerFlag self() {
        return this;
    }

    public static PlayerFlag of(String name) {
        me.angeschossen.lands.api.flags.type.PlayerFlag flag = Objects.requireNonNull(APIHandler.getFlagRegistry().getPlayer(name), "legacy flag: " + name);
        return new PlayerFlag(flag.getPlugin(), flag.getName());
    }

    @Override
    public @NotNull String getTogglePerm() {
        return "lands.player.setting." + name;
    }

    @Override
    public @NotNull String getTogglePermission() {
        return getTogglePerm();
    }
}
