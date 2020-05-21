package me.angeschossen.lands.api.land;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public interface ChunkCoordinate {

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
    @NotNull
    int getBlockX();


    /**
     * Get block z
     *
     * @return Block z
     */
    @NotNull
    int getBlockZ();

    /**
     * Get chunk x
     *
     * @return Chunk x
     */
    @NotNull
    int getX();

    /**
     * Get chunk z
     *
     * @return Chunk z
     */
    @NotNull
    int getZ();

    /**
     * Check if chunk contains these parameters.
     *
     * @param worldName World
     * @param x         Chunk x
     * @param z         Chunk z
     * @return Will return false if not all parameters match.
     */
    @NotNull
    boolean equals(@NotNull String worldName, @NotNull int x, @NotNull int z);
}
