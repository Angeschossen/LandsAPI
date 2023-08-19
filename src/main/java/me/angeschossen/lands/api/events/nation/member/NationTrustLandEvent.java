package me.angeschossen.lands.api.events.nation.member;

import me.angeschossen.lands.api.events.nation.member.NationManageMemberCancellableEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class NationTrustLandEvent extends NationManageMemberCancellableEvent {

    public static HandlerList handlerList = new HandlerList();

    public NationTrustLandEvent(@NotNull Nation nation, @NotNull Land land, UUID initiator) {
        super(nation, land, initiator);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull
    HandlerList getHandlers() {
        return handlerList;
    }
}
