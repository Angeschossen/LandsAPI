package me.angeschossen.lands.api.events.nation.member;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called whenever a nation modifies one of its members (lands) and the event is cancellable.
 */
public abstract class NationEditMemberCancellableEvent extends NationEditMemberEvent implements Cancellable {

    protected boolean cancelled;

    public NationEditMemberCancellableEvent(@NotNull Nation nation,@NotNull  Land land, UUID initiator) {
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
