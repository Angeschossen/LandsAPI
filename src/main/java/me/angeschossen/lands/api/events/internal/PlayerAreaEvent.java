package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.LandArea;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public abstract class PlayerAreaEvent extends Event {
    public static HandlerList handlerList = new HandlerList();

    private final UUID target;
    private final LandArea area;

    public PlayerAreaEvent(LandArea area, UUID target) {
        this.area = area;
        this.target = target;
    }

    public LandArea getArea() {
        return area;
    }

    public UUID getTarget() {
        return target;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
