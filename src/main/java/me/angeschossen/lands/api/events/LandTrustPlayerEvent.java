package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.LandMemberEditCancellableEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class LandTrustPlayerEvent extends LandMemberEditCancellableEvent {
    public static HandlerList handlerList = new HandlerList();

    public LandTrustPlayerEvent(@NotNull Land land,@NotNull  Area area,  UUID initiator,  UUID targetUUID) {
        super(land, area, initiator, targetUUID);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
