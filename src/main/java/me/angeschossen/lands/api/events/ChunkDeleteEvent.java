package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChunkDeleteEvent extends Event {
    public static HandlerList handlerList = new HandlerList();
    private final int x, z;
    private final World world;
    private final Land land;
    private final Reason reason;
    private final @Nullable
    LandPlayer landPlayer;

    public ChunkDeleteEvent(@Nullable LandPlayer landPlayer, Reason reason, World world, Land land, int x, int z) {
        super(!Bukkit.isPrimaryThread());

        this.world = world;
        this.x = x;
        this.z = z;
        this.land = land;
        this.landPlayer = landPlayer;
        this.reason = reason;
    }

    public Reason getReason() {
        return reason;
    }

    @Nullable
    public LandPlayer getLandPlayer() {
        return landPlayer;
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

    public static enum Reason {
        LAND_DELETION, UNCLAIM, UPKEEP_FAILED
    }
}
