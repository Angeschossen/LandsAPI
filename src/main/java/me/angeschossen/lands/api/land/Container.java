package me.angeschossen.lands.api.land;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Container {
    @NotNull Collection<? extends LandArea> getAreas();

    @NotNull Collection<? extends ChunkCoordinate> getChunks();

    int getMaxY();

    int getMinY();

    @NotNull LandWorld getWorld();

    boolean hasChunk(int x, int z);

    boolean isInYLevel(int y);
}
