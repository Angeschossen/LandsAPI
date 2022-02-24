package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LandWorld {

    boolean hasWildernessFlag(@NotNull Player player, @NotNull Location location, @NotNull RoleFlag roleFlag, boolean sendMessage);

    @Nullable
    Area getArea(Location location);

    @Nullable
    Land getLand(int x, int z);

    @Nullable
    Area getArea(int x, int y, int z);

    boolean hasFlag(@NotNull Location location, @NotNull LandFlag flag);

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
