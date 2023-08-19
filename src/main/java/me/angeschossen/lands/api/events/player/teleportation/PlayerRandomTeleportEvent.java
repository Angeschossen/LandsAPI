package me.angeschossen.lands.api.events.player.teleportation;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.player.PlayerEvent;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerRandomTeleportEvent extends PlayerEvent implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private final @NotNull Location destination;
    private boolean cancelled = false;

    public PlayerRandomTeleportEvent(@NotNull LandPlayer landPlayer, @NotNull Location location) {
        super(landPlayer);

        this.destination = location;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Location getDestination() {
        return destination;
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
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("destination_world", destination.getWorld().getName())
                .put("destination_x", destination.getBlockX())
                .put("destination_y", destination.getBlockY())
                .put("destination_z", destination.getBlockZ());
    }
}
