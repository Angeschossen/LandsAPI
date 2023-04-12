package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.event.Cancellable;

import java.util.UUID;

public abstract class NationMemberEditCancellableEvent extends NationMemberEditEvent implements Cancellable {

    protected boolean cancelled;

    public NationMemberEditCancellableEvent(Nation nation, Land land, UUID initiator) {
        super(nation, land, initiator);
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
