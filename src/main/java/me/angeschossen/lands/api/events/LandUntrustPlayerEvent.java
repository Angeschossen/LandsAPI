package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.land.member.LandManageMemberCancellableEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class LandUntrustPlayerEvent extends LandManageMemberCancellableEvent {

    public static HandlerList handlerList = new HandlerList();
    private final @NotNull
    UntrustReason reason;

    public LandUntrustPlayerEvent(@NotNull Land land, @Nullable Area area,  UUID initiator,  UUID targetUUID) {
        this(land, area, initiator, targetUUID, UntrustReason.DEFAULT);
    }

    public LandUntrustPlayerEvent(@NotNull Land land, @Nullable Area area,  UUID initiator,  UUID targetUUID, @NotNull UntrustReason reason) {
        super(land, area, initiator, targetUUID);

        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public UntrustReason getReason() {
        return reason;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        if (reason != UntrustReason.BAN) {
            super.setCancelled(cancelled);
        }
    }

    @Override
    public @NotNull
    HandlerList getHandlers() {
        return handlerList;
    }


    public enum UntrustReason {
        DEFAULT, BAN, TAXES, RENTAL_EXPIRED
    }
}
