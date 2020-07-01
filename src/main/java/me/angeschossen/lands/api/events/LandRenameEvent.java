package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LandRenameEvent extends Event implements Cancellable {


    public Land getLand() {
        return null;
    }

    public String getCurrentName() {
        return null;
    }

    public String getNewName() {
        return null;
    }


    @Override
    public HandlerList getHandlers() {
        return null;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled) {
    }
}
