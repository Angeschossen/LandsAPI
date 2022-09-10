package me.angeschossen.lands.api.land;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface Container {
    int getMinY();

    int getMaxY();

    @NotNull LandWorld getWorld();

    @NotNull Collection<? extends LandArea> getAreas();

    @NotNull Collection<? extends ChunkCoordinate> getChunks();

    boolean hasChunk(int x, int z);

    boolean isInYLevel(int y);
}
