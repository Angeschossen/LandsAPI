package me.angeschossen.lands.api.events.land;

import me.angeschossen.lands.api.events.internal.LandEditEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.enums.LandType;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LandConvertEvent extends LandEditEvent implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final @NotNull LandType landType;
    private boolean cancelled;

    public LandConvertEvent(@NotNull Land land, @Nullable LandPlayer landPlayer, @NotNull LandType landType) {
        super(land, landPlayer);

        this.landType = landType;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public LandType getLandType() {
        return landType;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) throws IllegalStateException {
        this.cancelled = b;
    }
}
