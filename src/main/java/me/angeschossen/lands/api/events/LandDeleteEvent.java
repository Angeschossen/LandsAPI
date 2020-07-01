package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandDeleteEvent extends Event implements Cancellable {

    @NotNull
    public Land getLand() {
        return null;
    }

    @NotNull
    public Reason getReason() {
        return null;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled) {
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }

    public enum Reason {
        COMMAND, INACTIVITY
    }
}