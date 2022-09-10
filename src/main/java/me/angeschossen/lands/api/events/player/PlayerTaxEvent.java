package me.angeschossen.lands.api.events.player;

import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerEvent;
import me.angeschossen.lands.api.land.Area;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Called when a land member needs to pay taxes to the land.
 */
public class PlayerTaxEvent extends LandsPlayerEvent implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private final @NotNull Area area;
    private final double balance;
    private boolean cancelled = false;

    public PlayerTaxEvent(@NotNull Area area, UUID playerUID, double balance) {
        super(playerUID);

        this.area = area;
        this.balance = balance;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    public Area getArea() {
        return area;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isInsufficient() {
        return balance < area.getTax();
    }
}
