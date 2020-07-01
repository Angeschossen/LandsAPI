package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.PlayerLocationAreaEvent;
import org.bukkit.event.HandlerList;

public class PlayerAreaLeaveEvent extends PlayerLocationAreaEvent {

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
