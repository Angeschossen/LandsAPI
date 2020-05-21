package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.land.enums.LandSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface LandChunk {


    /**
     * Get status of setting
     *
     * @param landsSetting LandsSetting
     * @return true if setting enabled
     */
    boolean hasLandSetting(@NotNull Location location, LandSetting landsSetting);

    /**
     * Get UUID of owner of chunk
     *
     * @return UUID
     */
    @NotNull
    UUID getOwnerUID();

    /**
     * Get land of LandChunk
     *
     * @return Land the landChunk is in
     */
    @NotNull
    Land getLand();

    /**
     * Get X identifier
     *
     * @return X
     */
    int getX();

    /**
     * Get Z identifier
     *
     * @return Z
     */
    int getZ();

    /**
     * Check if player can action.
     *
     * @param player      Player
     * @param action      Action
     * @param sendMessage Send no access message?
     * @return Will return false if place has no access.
     */
    boolean canAction(@NotNull Location location, @NotNull Player player, @NotNull RoleSetting action, boolean sendMessage);

    /**
     * Check if landChunk is loaded
     *
     * @return Is claim loaded?
     */
    boolean isLoaded();

    /**
     * Get the land area
     *
     * @return Area
     */
    @NotNull
    LandArea getArea(int x, int y, int z);

    /**
     * Check if player trusted
     *
     * @param playerUUID UUID of player
     * @return true, if trusted
     */
    @Deprecated
    boolean isTrusted(@NotNull UUID playerUUID);

    /**
     * Check if player can do an action
     *
     * @param playerUUID UUID of player
     * @param action     Action
     * @return true, if he can do so
     */
    boolean canAction(@NotNull Location location, @NotNull UUID playerUUID, @NotNull RoleSetting action);
}
