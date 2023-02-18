package me.angeschossen.lands.api.events.player;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

/**
 * Deprecated. Use {@link me.angeschossen.lands.api.events.land.spawn.LandSpawnTeleportEvent} instead.
 */
@Deprecated
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

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        super.setAffectedPlayers(builder);

        land.setAffectedPlayers("land_",builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        land.setExpressionVariables("land_", builder,getPlayerUID());
    }

    @Override
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
