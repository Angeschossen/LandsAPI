package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.land.Land;
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
    private final Reason reason;
    private final @Nullable
    CommandSender deleter;
    private boolean cancelled;


    public LandDeleteEvent(Land land, Reason reason, @Nullable CommandSender deleter) {
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
    public Reason getReason() {
        return reason;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Nullable
    public CommandSender getDeleter() {
        return deleter;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public enum Reason {
        COMMAND, INACTIVITY
    }
}