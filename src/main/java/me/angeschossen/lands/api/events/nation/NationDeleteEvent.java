package me.angeschossen.lands.api.events.nation;

import me.angeschossen.lands.api.events.land.DeleteReason;
import me.angeschossen.lands.api.nation.Nation;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NationDeleteEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final Nation nation;
    private final DeleteReason reason;
    private final @Nullable LandPlayer deleter;
    private boolean cancelled;

    public NationDeleteEvent(@NotNull Nation nation, @NotNull DeleteReason reason, @Nullable LandPlayer deleter) {
        super(!Bukkit.isPrimaryThread());

        this.nation = nation;
        this.reason = reason;
        this.deleter = deleter;
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

    @Nullable
    public CommandSender getDeleter() {
        return deleter == null ? null : deleter.getPlayer();
    }

    @Nullable
    public LandPlayer getLandPlayer() {
        return deleter;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

}