package me.angeschossen.lands.api.events.player;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.player.PlayerEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public abstract class PlayerLandEvent extends PlayerEvent implements Cancellable {
    private final @Nullable Area area;
    private final Land land;
    private boolean cancelled;

    public PlayerLandEvent(@NotNull Land land, @Nullable Area area, @NotNull LandPlayer landPlayer) {
        super(landPlayer);

        this.land = land;
        this.area = area;
        this.landPlayer = landPlayer;
    }

    @Nullable
    public Area getArea() {
        return area;
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
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        super.setAffectedPlayers(builder);
        land.setAffectedPlayers("land_", builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        UUID uuid = getPlayerUID();
        if (area != null) {
            area.setExpressionVariables("area_", builder, uuid);
        } else {
            land.setExpressionVariables("land_", builder, uuid);
        }
    }
}
