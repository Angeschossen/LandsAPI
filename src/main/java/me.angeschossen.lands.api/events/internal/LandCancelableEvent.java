package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class LandCancelableEvent extends LandEvent implements Cancellable {

    private boolean cancelled;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    public LandCancelableEvent(@NotNull Land land, LandPlayer landPlayer) {
        super(land, landPlayer);
    }

    public LandCancelableEvent(@NotNull Land land, UUID landPlayer) {
        super(land, landPlayer);
    }
}