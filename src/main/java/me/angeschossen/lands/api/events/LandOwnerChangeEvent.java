package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.LandMemberEditCancellableEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class LandOwnerChangeEvent extends LandMemberEditCancellableEvent {
    public static final HandlerList handlerList = new HandlerList();
    private final Reason reason;
    private final UUID oldOwner;

    public LandOwnerChangeEvent(Land land, @Nullable Area area, @NotNull UUID initiator, @NotNull UUID oldOwner, @NotNull Reason reason) {
        super(land, area, initiator, area == null ? land.getOwnerUID() : area.getOwnerUID());

        this.oldOwner = oldOwner;
        this.reason = reason;
    }


    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Reason getReason() {
        return reason;
    }

    @NotNull
    public UUID getOld() {
        return oldOwner;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        if (cancelled && reason == Reason.ADMIN) {
            throw new IllegalStateException("Can't cancel event with reason 'ADMIN'");
        }

        super.setCancelled(cancelled);
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    public enum Reason {
        RENT, RENT_EXPIRED, BOUGHT, BOUGHT_EXPIRED, DEFAULT, ADMIN, UPKEEP
    }
}
