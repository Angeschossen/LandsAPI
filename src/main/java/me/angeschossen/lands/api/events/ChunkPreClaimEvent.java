package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.LandEditEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.LandWorld;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ChunkPreClaimEvent extends LandEditEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final int x;
    private final int z;
    private final LandWorld world;
    private boolean cancelled;

    public ChunkPreClaimEvent(@NotNull Land land, LandPlayer landPlayer, LandWorld world, int x, int z) {
        super(land,landPlayer);

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
