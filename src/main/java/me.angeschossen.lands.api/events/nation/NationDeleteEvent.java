package me.angeschossen.lands.api.events.nation;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.land.DeleteReason;
import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NationDeleteEvent extends NationEditEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final Nation nation;
    private final DeleteReason reason;
    private boolean cancelled;

    public NationDeleteEvent(@NotNull Nation nation, @NotNull DeleteReason reason,LandPlayer deleter) {
        super(nation, deleter);

        this.nation = nation;
        this.reason = reason;
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("reason", reason);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Nation getNation() {
        return nation;
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
    public HandlerList getHandlers() {
        return handlerList;
    }

}