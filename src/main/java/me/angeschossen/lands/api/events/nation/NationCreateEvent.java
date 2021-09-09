package me.angeschossen.lands.api.events.nation;

import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class NationCreateEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    private final LandPlayer landPlayer;
    private final Nation nation;

    public NationCreateEvent(LandPlayer landPlayer, Nation nation) {
        this.nation = nation;
        this.landPlayer = landPlayer;
    }

    @NotNull
    public Nation getNation() {
        return nation;
    }

    @NotNull
    public LandPlayer getLandPlayer() {
        return landPlayer;
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
