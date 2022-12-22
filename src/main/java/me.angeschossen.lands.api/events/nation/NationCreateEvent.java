package me.angeschossen.lands.api.events.nation;

import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class NationCreateEvent extends NationEditEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;


    public NationCreateEvent(LandPlayer landPlayer, @NotNull Nation nation) {
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
