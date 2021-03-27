package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import me.angeschossen.lands.api.land.enums.LandSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LandWorld {

    /**
     * Check can execute action in wilderness
     *
     * @param player      Player
     * @param roleSetting Setting
     * @param sendMessage Send deny message?
     * @return Result
     */
    @Deprecated
    boolean canWildernessSetting(@NotNull Player player, @NotNull Location location, @NotNull RoleSetting roleSetting, boolean sendMessage);

    boolean hasWildernessFlag(@NotNull Player player, @NotNull Location location, @NotNull RoleFlag roleFlag, boolean sendMessage);

    /**
     * Check can execute action in wilderness
     *
     * @param player      Player
     * @param landsAction Setting
     * @return Result
     */
    @Deprecated
    boolean canActionWithResponse(@NotNull Player player, @NotNull Location location, RoleSetting landsAction);

    @Nullable
    Area getArea(Location location);

    @Nullable
    Land getLand(int x, int z);

    @Nullable
    Area getArea(int x, int y, int z);

    @Deprecated
    boolean canActionWithResponse(@NotNull Player player, @NotNull Location location, @Nullable Material material, RoleSetting landsAction);

    @Deprecated
    boolean hasLandSetting(@NotNull Location location, @NotNull LandSetting naturalFlags);

    boolean hasFlag(@NotNull Location location, @NotNull LandFlag flag);

    @Deprecated
    boolean canAction(@NotNull Player player, @NotNull Location location, @NotNull RoleSetting landsAction);

    /**
     * Check if player can action. This also contains the setting disallow-wilderness.
     *
     * @param player      Player
     * @param location    Location
     * @param landsAction Action
     * @return Will return false if he can't do this.
     */
    @Deprecated
    boolean canAction(@NotNull Player player, @NotNull Location location, @Nullable Material material, @NotNull RoleSetting landsAction);

    boolean hasFlag(@NotNull Player player, @NotNull Location location, @Nullable Material material, @NotNull RoleFlag flag, boolean sendMessage);

    /**
     * Get name of world.
     *
     * @return Name of world
     */
    @NotNull
    String getName();

    /**
     * Get world
     *
     * @return World
     */
    @NotNull
    World getWorld();

    /**
     * Is landChunk loaded?
     *
     * @param x X identifier
     * @param z Z identifier
     * @return Loaded
     */
    boolean isChunkLoaded(int x, int z);
}
