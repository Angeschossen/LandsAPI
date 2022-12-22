package me.angeschossen.lands.api.land;

import me.angeschossen.lands.api.blockworks.BoundingBox;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LandArea extends Area {


    @Nullable
    World getWorld();

    /**
     * Get the bounding box of the sub area.
     *
     * @return Will return null if the area is not setup {@link #isSetup()}.
     */
    @Nullable
    BoundingBox getBoundingBox();

    boolean setName(@NotNull String name);

    boolean contains(int x, int y, int z);

    boolean isSetup();

    @Nullable Container getContainer();

}
