package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerLeaveLandEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    private LandPlayer landPlayer;
    private Land land;

    public PlayerLeaveLandEvent(LandPlayer landPlayer, Land land) {
        this.land = land;
        this.landPlayer = landPlayer;
    }

    public Land getLand() {
        return land;
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
