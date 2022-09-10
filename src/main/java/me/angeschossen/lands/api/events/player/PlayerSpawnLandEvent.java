package me.angeschossen.lands.api.events.player;

import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerSpawnLandEvent extends LandsPlayerEvent implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private final @NotNull Land land;
    private boolean cancelled = false;

    public PlayerSpawnLandEvent(@NotNull Land land, LandPlayer landPlayer) {
        super(landPlayer);

        this.land = land;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
