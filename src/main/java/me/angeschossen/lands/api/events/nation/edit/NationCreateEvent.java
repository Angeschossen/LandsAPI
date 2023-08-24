package me.angeschossen.lands.api.events.nation.edit;

import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a player tries to create a nation.
 */
public class NationCreateEvent extends NationEditEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    /**
     * Create an instance of this event.
     * @param landPlayer null, if no player involved in creating this nation
     * @param nation the nation being created
     */
    public NationCreateEvent(@Nullable LandPlayer landPlayer, @NotNull Nation nation) {
        super(nation, landPlayer);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
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
}
