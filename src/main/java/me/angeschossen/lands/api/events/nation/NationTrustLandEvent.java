package me.angeschossen.lands.api.events.nation;

import me.angeschossen.lands.api.events.internal.NationMemberEditCancellableEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class NationTrustLandEvent extends NationMemberEditCancellableEvent {

    public static HandlerList handlerList = new HandlerList();

    public NationTrustLandEvent(@NotNull Nation nation, @NotNull Land land, @Nullable UUID initiator) {
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
