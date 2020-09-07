package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ChunkDeleteEvent extends Event {
    public static HandlerList handlerList = new HandlerList();
    private final int x, z;
    private final World world;
    private final Land land;

    public ChunkDeleteEvent(World world, Land land, int x, int z) {
        this.world = world;
        this.x = x;
        this.z = z;
        this.land = land;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Deprecated
    public String getWorldName() {
        return world.getName();
    }

    @NotNull
    public World getWorld() {
        return world;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
