package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class LandTrustPlayerEvent extends Event implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    private UUID targetUUID;
    private Land land;

    public LandTrustPlayerEvent(UUID targetUUID, Land land) {
        this.land = land;
        this.targetUUID = targetUUID;
    }

    public Land getLand() {
        return land;
    }

    public UUID getTargetUUID(){return targetUUID;}

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
