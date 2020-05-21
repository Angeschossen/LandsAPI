package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LandRenameEvent extends Event implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private boolean cancelled = false;

    private final Land land;
    private final String oldName;
    private final String newName;

    public LandRenameEvent(Land land, String oldName, String newName) {
        this.land = land;
        this.oldName = oldName;
        this.newName = newName;
    }

    public Land getLand() {
        return land;
    }

    public String getCurrentName() {
        return oldName;
    }

    public String getNewName() {
        return newName;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
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
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
