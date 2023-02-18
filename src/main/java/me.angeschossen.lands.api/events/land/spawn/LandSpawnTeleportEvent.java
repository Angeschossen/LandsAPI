package me.angeschossen.lands.api.events.land.spawn;

import me.angeschossen.lands.api.events.internal.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class LandSpawnTeleportEvent extends LandEvent implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private boolean cancelled;

    public LandSpawnTeleportEvent(@NotNull Land land, @NotNull LandPlayer landPlayer) {
        super(land, landPlayer);

        Objects.requireNonNull(landPlayer, "LandPlayer can't be null");
    }

    @Override
    public @NotNull LandPlayer getLandPlayer() {
        assert super.getLandPlayer() != null;
        return super.getLandPlayer();
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
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
