package me.angeschossen.lands.api.blockworks;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public interface BlockCoordinate {
    @NotNull World getWorld();

    int getX();

    int getY();

    int getZ();

    int getChunkX();

    int getChunkZ();

    double getDistance(@NotNull Player player);

    Location toLocation();
}
