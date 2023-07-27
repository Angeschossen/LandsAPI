package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public abstract class LandMemberEditCancellableEvent extends LandMemberEditEvent implements Cancellable {

    private boolean cancelled;

    public LandMemberEditCancellableEvent(@NotNull Land land, @Nullable Area area, UUID initiator, UUID target) {
        super(land, area, initiator, target);
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
