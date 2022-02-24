package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.land.DeleteReason;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LandDeleteEvent extends Event implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final Land land;
    private final DeleteReason reason;
    private final @Nullable
    LandPlayer deleter;
    private boolean cancelled;


    public LandDeleteEvent(@NotNull Land land, @NotNull DeleteReason reason, @Nullable LandPlayer deleter) {
        super(!Bukkit.isPrimaryThread());

        this.land = land;
        this.reason = reason;
        this.deleter = deleter;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Land getLand() {
        return land;
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