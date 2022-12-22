package me.angeschossen.lands.api.events;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.internal.LandEditEvent;
import me.angeschossen.lands.api.events.land.DeleteReason;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandDeleteEvent extends LandEditEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final DeleteReason reason;
    private boolean cancelled;

    public LandDeleteEvent(@NotNull Land land, @NotNull DeleteReason reason, LandPlayer deleter) {
        super(land, deleter);

        this.reason = reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public DeleteReason getReason() {
        return reason;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) throws IllegalStateException {
        if (cancelled && reason == DeleteReason.ADMIN) {
            throw new IllegalStateException("Can't cancel event with reason 'ADMIN'");
        }

        this.cancelled = cancelled;
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("reason", reason);
    }

}