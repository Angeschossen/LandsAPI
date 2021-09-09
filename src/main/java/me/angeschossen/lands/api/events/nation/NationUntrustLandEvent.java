package me.angeschossen.lands.api.events.nation;

import me.angeschossen.lands.api.events.internal.NationMemberEditCancellableEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.nation.Nation;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class NationUntrustLandEvent extends NationMemberEditCancellableEvent {

    public static HandlerList handlerList = new HandlerList();
    private final @NotNull UntrustReason reason;

    public NationUntrustLandEvent(@NotNull Nation nation, @NotNull Land land, @Nullable UUID initiator, @NotNull UntrustReason reason) {
        super(nation, land, initiator);
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
    public @NotNull
    HandlerList getHandlers() {
        return handlerList;
    }

    public enum UntrustReason {
        COMMAND, TAXES
    }
}
