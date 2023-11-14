package me.angeschossen.lands.api.land;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * A container includes claiming information of a land for a specific world.
 * This mainly includes the claimed chunks and sub areas.
 */
public interface Container {
    /**
     * Get minimum Y value. Depends on the servers config and land type.
     * @return In bound with the world's min. height.
     */
    int getMinY();

    /**
     * Get maximum Y value. Depends on the servers config and land type.
     * @return In bound with the world's max. height.
     */
    int getMaxY();

    /**
     * Get the world.
     * @return Never null
     */
    @NotNull LandWorld getWorld();

    /**
     * Get sub areas of this land in this world.
     * @return Collection of sub areas. Doesn't include the default area ({@link Land#getDefaultArea()}.
     */
    @NotNull Collection<? extends LandArea> getAreas();

    /**
     * Get claimed chunks of this land in this world.
     * @return Collection of claimed chunks.
     */
    @NotNull Collection<? extends ChunkCoordinate> getChunks();

    /**
     * Check if chunk is claimed by this land.
     * @param x Chunk x identifier
     * @param z Chunk z identifier
     * @return false, if not claimed by this land
     */
    boolean hasChunk(int x, int z);

    /**
     * Checks if y is in bounds with {@link #getMinY()} and {@link #getMaxY()}.
     * @param y Y value
     * @return false, if out of bounds
     */
    boolean isInYLevel(int y);

    /**
     * Get the land to which the container belongs.
     * @return land of the container
     */
    @NotNull
    Land getLand();
}
