package me.angeschossen.lands.api.land;

import org.bukkit.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface LandArea extends Area {

    boolean contains(int x, int y, int z);

    @Nullable
    World getWorld();

    boolean setName(@NotNull String name);

    boolean isSetup();
}
