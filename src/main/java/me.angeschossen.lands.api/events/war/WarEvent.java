package me.angeschossen.lands.api.events.war;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.internal.plugin.LandsEvent;
import me.angeschossen.lands.api.war.War;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.UUID;

public abstract class WarEvent extends LandsEvent {

    protected final War war;

    public WarEvent(@NotNull War war) {
        this.war = war;
    }

    @NotNull
    public War getWar() {
        return war;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        war.setAffectedPlayers("war_", builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        war.setExpressionVariables("war_", builder, null);
    }
}
