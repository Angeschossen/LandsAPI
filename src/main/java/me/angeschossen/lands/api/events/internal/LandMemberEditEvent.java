package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class LandMemberEditEvent extends Event implements Cancellable {


    @NotNull
    public Land getLand() {
        return null;
    }

    @Nullable
    public Area getArea() {
        return null;
    }

    @NotNull
    @Deprecated
    public UUID getTargetUUID() {
        return null;
    }

    @NotNull
    public UUID getTarget() {
        return null;
    }

    @NotNull
    public UUID getTruster() {
        return null;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled) {

    }
}
