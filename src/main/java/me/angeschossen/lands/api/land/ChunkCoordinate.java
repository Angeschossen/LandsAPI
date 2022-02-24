package me.angeschossen.lands.api.land;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public interface ChunkCoordinate {

    boolean equals(int x, int z);

    /**
     * Get world
     *
     * @return World
     */
    @NotNull
    World getWorld();

    /**
     * Get block x
     *
     * @return Block x
     */
    int getBlockX();


    /**
     * Get block z
     *
     * @return Block z
     */
    int getBlockZ();

    /**
     * Get chunk x
     *
     * @return Chunk x
     */
    int getX();

    /**
     * Get chunk z
     *
     * @return Chunk z
     */
    int getZ();

    /**
     * Check if chunk contains these parameters.
     *
     * @param worldName World
     * @param x         Chunk x
     * @param z         Chunk z
     * @return Will return false if not all parameters match.
     */
    boolean equals(@NotNull String worldName, int x, int z);
}
