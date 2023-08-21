package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.land.member.LandEditMemberCancellableEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class LandBanPlayerEvent extends LandEditMemberCancellableEvent {

    public static HandlerList handlerList = new HandlerList();

    public LandBanPlayerEvent(Land land, @Nullable Area area, UUID initiator, UUID targetUUID) {
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
