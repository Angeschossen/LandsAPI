package me.angeschossen.lands.api.events.player;

import me.angeschossen.lands.api.events.internal.PlayerLocationAreaEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Nullable;

/**
 * This event is called when a player enters a area.
 * Please note that the player must not enter from wilderness.
 * They can also enter from a different area of the same or a different land.
 */
public class PlayerAreaEnterEvent extends PlayerLocationAreaEvent {
    public static HandlerList handlerList = new HandlerList();

    private final Area from;

    public PlayerAreaEnterEvent(@Nullable Area from, Area area, LandPlayer landPlayer) {
        super(area, landPlayer);

        this.from = from;
    }

    /**
     * Get the area from which the player is entering from.
     * This area can be from the same or from a different land as {@link #getArea}
     * @return This method will return null if the player is entering from the wilderness.
     */
    @Nullable
    public Area getFrom() {
        return from;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
