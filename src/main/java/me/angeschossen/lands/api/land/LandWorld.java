package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.land.enums.LandSetting;
import me.angeschossen.lands.api.role.enums.RoleSetting;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public interface LandWorld {


    @Nullable Land getLand(int x, int z);

    /**
     * Check can execute action in wilderness
     *
     * @param player      Player
     * @param roleSetting Setting
     * @param sendMessage Send deny message?
     * @return Result
     */
    boolean canWildernessSetting(@NotNull Player player, @NotNull RoleSetting roleSetting, boolean sendMessage);

    @NotNull
    Collection<Land> getLands();

    /**
     * Check can execute action in wilderness
     *
     * @param player      Player
     * @param landsAction Setting
     * @return Result
     */
    boolean canActionWithResponse(@NotNull Player player, @NotNull Location location, RoleSetting landsAction);

    @Nullable Area getArea(Location location);

    boolean canActionWithResponse(@NotNull Player player, @NotNull Location location, @Nullable Material material, RoleSetting landsAction);

    boolean hasLandSetting(@NotNull Location location, @NotNull LandSetting naturalFlags);

    boolean canAction(@NotNull Player player, @NotNull Location location, @NotNull RoleSetting landsAction);

    /**
     * Check if player can action. This also contains the setting disallow-wilderness.
     *
     * @param player      Player
     * @param location    Location
     * @param landsAction Action
     * @return Will return false if he can't do this.
     */
    boolean canAction(@NotNull Player player, @NotNull Location location, @Nullable Material material, @NotNull RoleSetting landsAction);

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

    @Nullable
    Land getLand(String name);

    /**
     * Is landChunk loaded?
     *
     * @param x X identifier
     * @param z Z identifier
     * @return Loaded
     */
    boolean isChunkLoaded( int x, int z);
}
