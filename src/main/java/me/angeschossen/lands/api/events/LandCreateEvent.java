package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LandCreateEvent extends Event implements Cancellable {



    public Land getLand() {
        return null;
    }

    public LandPlayer getLandPlayer() {
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
}
