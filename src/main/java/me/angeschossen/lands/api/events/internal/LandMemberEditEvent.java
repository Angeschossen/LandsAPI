package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class LandMemberEditEvent extends Event implements Cancellable {
    private final UUID initiator, target;
    private final Land land;
    private final @Nullable
    Area area;
    private boolean cancelled;

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

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
