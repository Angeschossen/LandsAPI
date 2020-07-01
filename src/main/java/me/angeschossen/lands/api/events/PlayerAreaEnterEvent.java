package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.PlayerLocationAreaEvent;
import me.angeschossen.lands.api.land.Area;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Nullable;

public class PlayerAreaEnterEvent extends PlayerLocationAreaEvent {

    @Nullable
    public Area getFrom() {
        return null;
    }

    @Override
    public HandlerList getHandlers() {
        return null;
    }
}
