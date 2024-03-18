package me.angeschossen.lands.api.events.player.area;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.player.PlayerEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

/**
 * Used for events where a player interacts with an area.
 */
public abstract class PlayerAreaEvent extends PlayerEvent {
    public static HandlerList handlerList = new HandlerList();
    protected final Area area;

    public PlayerAreaEvent(@NotNull Area area, LandPlayer landPlayer) {
        super(landPlayer);

        this.area = area;
    }

    public PlayerAreaEvent(@NotNull Area area, UUID player) {
        super(player);

        this.area = area;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    /**
     * Get the area. Can be entering or leaving, depending on the event.
     *
     * @return the affected area
     */
    @NotNull
    public Area getArea() {
        return area;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        super.setAffectedPlayers(builder);

        area.setAffectedPlayers("area_", builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        area.setExpressionVariables("area_", builder, getPlayerUID());
    }
}
