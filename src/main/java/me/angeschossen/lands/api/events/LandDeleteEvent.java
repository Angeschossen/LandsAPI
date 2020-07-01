package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandDeleteEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final Land land;
    private final Reason reason;
    private boolean cancelled;

    public LandDeleteEvent(Land land, Reason reason) {
        super(!Bukkit.isPrimaryThread());

        this.land = land;
        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    @NotNull
    public Reason getReason() {
        return reason;
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

    public enum Reason {
        COMMAND, INACTIVITY
    }
}