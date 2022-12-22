package me.angeschossen.lands.api.events.internal;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerNullableEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

public abstract class LandEditEvent extends LandsPlayerNullableEvent {

    protected final @NotNull Land land;

    public LandEditEvent(@NotNull Land land, LandPlayer landPlayer) {
        super(landPlayer);

        this.land = land;
    }

    public LandEditEvent(@NotNull Land land, UUID landPlayer) {
        super(landPlayer);

        this.land = land;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        super.setAffectedPlayers(builder);

        land.setAffectedPlayers("land_", builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        land.setExpressionVariables("land_", builder, getPlayerUID());
    }
}
