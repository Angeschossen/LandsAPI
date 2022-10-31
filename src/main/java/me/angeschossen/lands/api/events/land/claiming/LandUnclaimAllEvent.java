package me.angeschossen.lands.api.events.land.claiming;

import me.angeschossen.lands.api.events.internal.LandEditEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LandUnclaimAllEvent extends LandEditEvent implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    public LandUnclaimAllEvent(@NotNull Land land, @Nullable LandPlayer landPlayer) {
        super(land, landPlayer);
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
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b){
        this.cancelled = b;
    }
}
