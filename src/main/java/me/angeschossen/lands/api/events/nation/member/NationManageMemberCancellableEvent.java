package me.angeschossen.lands.api.events.nation.member;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.event.Cancellable;

import java.util.UUID;

public abstract class NationManageMemberCancellableEvent extends NationManageMemberEvent implements Cancellable {

    protected boolean cancelled;

    public NationManageMemberCancellableEvent(Nation nation, Land land, UUID initiator) {
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
