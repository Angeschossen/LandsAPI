package me.angeschossen.lands.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;


public class BroadcastEvent extends Event {

    @NotNull
    public String getMessageKey() {
        return null;
    }

    @NotNull
    public String getMessage() {
        return null;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}

