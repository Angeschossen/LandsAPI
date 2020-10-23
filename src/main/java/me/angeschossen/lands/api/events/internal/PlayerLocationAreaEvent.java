package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public abstract class PlayerLocationAreaEvent extends Event {
    public static HandlerList handlerList = new HandlerList();
    private final Area area;
    private final LandPlayer landPlayer;

    public PlayerLocationAreaEvent(Area area, LandPlayer landPlayer) {
        super(!Bukkit.isPrimaryThread());

        this.area = area;
        this.landPlayer = landPlayer;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    /**
     * Get the area. Can be entering or leaving, depending on the event.
     *
     * @return {@link Area}
     */
    @NotNull
    public Area getArea() {
        return area;
    }

    @NotNull
    public LandPlayer getLandPlayer() {
        return landPlayer;
    }
}
