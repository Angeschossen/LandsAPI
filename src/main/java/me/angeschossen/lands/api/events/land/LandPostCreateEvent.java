package me.angeschossen.lands.api.events.land;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called after land creation. At this stage the land received its ID.
 * If you don't need to ID and want to cancel land creation, use {@link me.angeschossen.lands.api.events.LandCreateEvent} instead.
 */
public class LandPostCreateEvent extends LandEvent {

    public static HandlerList handlerList = new HandlerList();

    /**
     * Create an instance of this event.
     *
     * @param landPlayer The player that initiated the creation. If null, the creation wasn't initiated by a player.
     * @param land       the land that is being created
     */
    public LandPostCreateEvent(@Nullable LandPlayer landPlayer, @NotNull Land land) {
        super(land, landPlayer);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
