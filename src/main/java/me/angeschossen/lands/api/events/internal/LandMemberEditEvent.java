package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class LandMemberEditEvent extends Event {
    protected final UUID initiator, target;
    protected final Land land;
    protected final @Nullable
    Area area;

    public LandMemberEditEvent(Land land, @Nullable Area area, UUID initiator, UUID target) {
        super(!Bukkit.isPrimaryThread());

        this.initiator = initiator;
        this.target = target;
        this.land = land;
        this.area = area;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    @Nullable
    public Area getArea() {
        return area;
    }

    @NotNull
    @Deprecated
    public UUID getTargetUUID() {
        return target;
    }

    @NotNull
    public UUID getTarget() {
        return target;
    }

    @NotNull
    @Deprecated
    public UUID getTruster() {
        return getInitiator();
    }

    @NotNull
    public UUID getInitiator() {
        return initiator;
    }
}
