package me.angeschossen.lands.api.events.player;

import me.angeschossen.lands.api.land.Area;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called when a land member needs to pay taxes to the land.
 */
public class PlayerTaxEvent extends Event implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private final @NotNull Area area;
    private final @NotNull UUID playerUID;
    private boolean cancelled = false;
    private final double balance;

    public PlayerTaxEvent(@NotNull Area area, @NotNull UUID playerUID, double balance) {
        super(!Bukkit.isPrimaryThread());

        this.area = area;
        this.playerUID = playerUID;
        this.balance = balance;
    }

    public boolean IsInsufficient() {
        return balance < area.getTax();
    }

    public double getBalance() {
        return balance;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Area getArea() {
        return area;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public UUID getPlayer() {
        return playerUID;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
