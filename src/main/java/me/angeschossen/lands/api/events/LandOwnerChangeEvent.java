package me.angeschossen.lands.api.events;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.land.member.LandEditMemberCancellableEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class LandOwnerChangeEvent extends LandEditMemberCancellableEvent {
    public static final HandlerList handlerList = new HandlerList();
    private final Reason reason;

    public LandOwnerChangeEvent(@NotNull Land land, @Nullable Area area, UUID initiator, @NotNull UUID newOwner, @NotNull Reason reason) {
        super(land, area, initiator, newOwner);

        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public Reason getReason() {
        return reason;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        if (cancelled && reason == Reason.ADMIN) {
            throw new IllegalStateException("Can't cancel event with reason 'ADMIN'");
        }

        super.setCancelled(cancelled);
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("reason", reason);
    }

    public enum Reason {
        RENT, RENT_EXPIRED, BOUGHT, BOUGHT_EXPIRED, DEFAULT, ADMIN, UPKEEP
    }
}
