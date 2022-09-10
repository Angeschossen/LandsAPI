package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerEvent;
import me.angeschossen.lands.api.events.internal.plugin.TargetableEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class LandMemberEditEvent extends LandsPlayerEvent implements TargetableEvent {
    protected final UUID initiator, target;
    protected final Land land;
    protected final @Nullable
    Area area;

    public LandMemberEditEvent(Land land, @Nullable Area area,@NotNull  UUID initiator,@NotNull  UUID target) {
        super(initiator);

        this.initiator = initiator;
        this.target = target;
        this.land = land;
        this.area = area;
    }

    @Nullable
    public Area getArea() {
        return area;
    }

    @NotNull
    public UUID getInitiator() {
        return initiator;
    }

    @NotNull
    public Land getLand() {
        return land;
    }

    @NotNull
    @Deprecated
    public UUID getTarget() {
        return target;
    }

    @NotNull
    public UUID getTargetUID() {
        return target;
    }

    @NotNull
    @Deprecated
    public UUID getTargetUUID() {
        return target;
    }

    @NotNull
    @Deprecated
    public UUID getTruster() {
        return getInitiator();
    }
}
