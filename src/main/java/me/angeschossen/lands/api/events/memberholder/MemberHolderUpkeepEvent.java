package me.angeschossen.lands.api.events.memberholder;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a land or nation needs to pay upkeep.
 */
public class MemberHolderUpkeepEvent extends MemberHolderEvent implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();
    private final double upkeep;
    private final double balance;
    private boolean cancelled = false;

    public MemberHolderUpkeepEvent(@NotNull MemberHolder memberHolder, double upkeep, double balance) {
        super(memberHolder);

        this.upkeep = upkeep;
        this.balance = balance;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public boolean IsInsufficient() {
        return balance < upkeep;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
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

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("upkeep", upkeep)
                .put(memberHolder.getExpressionPrefix() + "_balance", balance);
    }
}
