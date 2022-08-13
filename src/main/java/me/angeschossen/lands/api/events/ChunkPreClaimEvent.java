package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChunkPreClaimEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final @Nullable LandPlayer landPlayer;
    private final int x;
    private final int z;
    private final LandWorld world;
    private boolean cancelled;

    public ChunkPreClaimEvent(@Nullable LandPlayer landPlayer, LandWorld world, int x, int z) {
        super(!Bukkit.isPrimaryThread());

        this.landPlayer = landPlayer;
        this.world = world;
        this.x = x;
        this.z = z;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @NotNull
    public String getWorldName() {
        return world.getName();
    }

    @NotNull
    public LandWorld getWorld() {
        return world;
    }

    @Nullable
    public LandPlayer getLandPlayer() {
        return landPlayer;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
