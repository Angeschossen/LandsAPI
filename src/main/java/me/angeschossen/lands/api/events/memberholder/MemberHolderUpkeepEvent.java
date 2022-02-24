package me.angeschossen.lands.api.events.memberholder;

import me.angeschossen.lands.api.MemberHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a land or nation needs to pay upkeep.
 */
public class MemberHolderUpkeepEvent extends Event implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private final @NotNull MemberHolder memberHolder;
    private final double upkeep;
    private boolean cancelled = false;
    private final double balance;

    public MemberHolderUpkeepEvent(@NotNull MemberHolder memberHolder, double upkeep, double balance) {
        super(!Bukkit.isPrimaryThread());

        this.memberHolder = memberHolder;
        this.upkeep = upkeep;
        this.balance = balance;
    }

    public boolean IsInsufficient() {
        return balance < upkeep;
    }

    public double getBalance() {
        return balance;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public MemberHolder getMemberHolder() {
        return memberHolder;
    }

    public double getUpkeep() {
        return upkeep;
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
