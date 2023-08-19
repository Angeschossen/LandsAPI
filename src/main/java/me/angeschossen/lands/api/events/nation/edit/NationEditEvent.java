package me.angeschossen.lands.api.events.nation.edit;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.player.PlayerNullableEvent;
import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.UUID;

public abstract class NationEditEvent extends PlayerNullableEvent {


    protected final @NotNull Nation nation;

    public NationEditEvent(@NotNull Nation nation, @Nullable LandPlayer landPlayer) {
        super(landPlayer);

        this.nation = nation;
    }

    public NationEditEvent(@NotNull Nation nation, @Nullable UUID landPlayer) {
        super(landPlayer);

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
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        nation.setExpressionVariables("nation_", builder, getPlayerUID());
    }
}
