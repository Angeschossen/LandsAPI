package me.angeschossen.lands.api.blockworks;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

public interface BoundingBox {
    @NotNull
    BlockCoordinate getMax();

    @NotNull
    BlockCoordinate getMin();

    boolean contains(int x, int y, int z);

    /**
     * Same as {@link #contains(int, int, int)}, but ignores y values.
     *
     * @param x Block coordinate X
     * @param z Block coordinate Z
     * @return true, if the boundingBox contains these coordinates.
     */
    boolean contains(int x, int z);

    @NotNull
    World getWorld();
}
