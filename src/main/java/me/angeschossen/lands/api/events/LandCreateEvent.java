package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.land.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a land is being created. Lands won't have any ID at this stage.
 * If you need to lands ID ({@link Land#getId()}, listen to {@link me.angeschossen.lands.api.events.land.LandPostCreateEvent} instead.
 */
public class LandCreateEvent extends LandEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    /**
     * Create an instance of this event.
     *
     * @param landPlayer The player that initiated the creation. If null, the creation wasn't initiated by a player.
     * @param land       the land that is being created
     */
    public LandCreateEvent(@Nullable LandPlayer landPlayer, @NotNull Land land) {
        super(land, landPlayer);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
