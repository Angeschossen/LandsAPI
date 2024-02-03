package me.angeschossen.lands.api.flags;

import me.angeschossen.lands.api.role.system.SystemFlagStates;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface SystemFlagStatesHolder {
    /**
     * Set system flag states for a player. System flag states can only be applied
     * to players that aren't trusted. This should only be used if you want some players
     * to bypass the regular role system. For example if you want to implement a war system
     * that allows players to grief land during war.
     * <p>
     * It's your responsibility to remove the flag states when they shouldn't be applied anymore. See {@link #removeSystemFlagStates(UUID)} for more info.
     * Also they aren't persistent and therefore reset at each server restart.
     *
     * @param player     the player for which the flags should be set
     * @param flagStates collection of flag states
     */
    void setSystemFlagStates(@NotNull Player player, @NotNull SystemFlagStates flagStates);

    /**
     * Remove system flag states for a player.
     *
     * @param player the player
     */
     void removeSystemFlagStates(@NotNull UUID player);
}
