package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ChunkDeleteEvent extends Event {
    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    private final int x, z;
    private final String world;
    private final Land land;

    public ChunkDeleteEvent(String world, Land land, int x, int z) {
        super(true);

        this.world = world;
        this.x = x;
        this.z = z;
        this.land = land;
    }

    public Land getLand() {
        return land;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public String getWorldName() {
        return world;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
