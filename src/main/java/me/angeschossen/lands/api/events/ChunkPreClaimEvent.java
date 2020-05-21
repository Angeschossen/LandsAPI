package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ChunkPreClaimEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    private LandPlayer landPlayer;
    private int x, z;
    private String worldName;

    public ChunkPreClaimEvent(LandPlayer landPlayer, String worldName, int x, int z) {
        this.landPlayer = landPlayer;

        this.worldName = worldName;
        this.x = x;
        this.z = z;
    }

    public int getX() {
        return x;
    }


    public int getZ() {
        return z;
    }

    public String getWorldName() {
        return worldName;
    }

    public LandPlayer getLandPlayer() {
        return landPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
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
