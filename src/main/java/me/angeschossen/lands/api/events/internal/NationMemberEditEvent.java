package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class NationMemberEditEvent extends Event {
    protected final UUID initiator;
    protected final Nation nation;
    protected final Land land;

    public NationMemberEditEvent(Nation nation, Land land, UUID initiator) {
        super(!Bukkit.isPrimaryThread());

        this.initiator = initiator;
        this.land = land;
        this.nation = nation;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    @NotNull
    public Nation getNation() {
        return nation;
    }

    @NotNull
    public UUID getInitiator() {
        return initiator;
    }
}
