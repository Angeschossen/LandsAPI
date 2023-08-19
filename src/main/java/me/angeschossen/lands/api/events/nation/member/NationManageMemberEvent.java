package me.angeschossen.lands.api.events.nation.member;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.land.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public abstract class NationManageMemberEvent extends LandEvent {
    protected final UUID initiator;
    protected final Nation nation;
    protected final Land land;

    public NationManageMemberEvent(@NotNull Nation nation, @NotNull Land land, @Nullable UUID initiator) {
        super(land, initiator);

        this.initiator = initiator;
        this.land = land;
        this.nation = nation;
    }

    @NotNull
    public Nation getNation() {
        return nation;
    }

    @Override
    public void setAffectedPlayers(ImmutableMap.@NotNull Builder<String, Collection<UUID>> builder) {
        super.setAffectedPlayers(builder);

        nation.setAffectedPlayers("nation_", builder);
        land.setAffectedPlayers("land_", builder);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        UUID uuid = getPlayerUID();
        nation.setExpressionVariables("nation_", builder, uuid);
        land.setExpressionVariables("land_", builder, uuid);
    }
}
