package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class NationMemberEditEvent extends LandEditEvent {
    protected final UUID initiator;
    protected final Nation nation;
    protected final Land land;

    public NationMemberEditEvent(@NotNull Nation nation, @NotNull Land land, @Nullable UUID initiator) {
        super(land, initiator);

        this.initiator = initiator;
        this.land = land;
        this.nation = nation;
    }

    @NotNull
    @Deprecated
    public UUID getInitiator() {
        return initiator;
    }

    @NotNull
    public Nation getNation() {
        return nation;
    }

}
