package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Area;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class AreaRentalExpiredEvent extends Event {
    public static HandlerList handlerList = new HandlerList();
    private final Area area;

    public AreaRentalExpiredEvent(Area area) {
        this.area = area;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Area getArea() {
        return area;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

}
