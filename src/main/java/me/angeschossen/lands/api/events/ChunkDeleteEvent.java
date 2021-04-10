package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.land.DeleteReason;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChunkDeleteEvent extends Event implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final int x, z;
    private final World world;
    private final Land land;
    private final DeleteReason reason;
    private final @Nullable
    LandPlayer landPlayer;
    private boolean cancelled;

    public ChunkDeleteEvent(@Nullable LandPlayer landPlayer,@NotNull DeleteReason reason,@NotNull World world,@NotNull Land land, int x, int z) {
        super(!Bukkit.isPrimaryThread());

        this.world = world;
        this.x = x;
        this.z = z;
        this.land = land;
        this.landPlayer = landPlayer;
        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public DeleteReason getReason() {
        return reason;
    }

    @Nullable
    public LandPlayer getLandPlayer() {
        return landPlayer;
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

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) throws IllegalStateException {
        if (b && reason == DeleteReason.ADMIN) {
            throw new IllegalStateException("Can't cancel event with reason 'ADMIN'.");
        }

        this.cancelled = b;
    }
}
