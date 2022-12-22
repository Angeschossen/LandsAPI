package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.LandEditEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandCreateEvent extends LandEditEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;


    public LandCreateEvent(LandPlayer landPlayer,@NotNull Land land) {
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
    public HandlerList getHandlers() {
        return handlerList;
    }
}
