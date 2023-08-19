package me.angeschossen.lands.api.events.land.bank;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called whenever a player deposits money in the land bank.
 */
public class LandBankDepositEvent extends BankEvent implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();

    /**
     * Create an instance of this event.
     *
     * @param land       land to which this bank belongs to
     * @param landPlayer player that deposits money
     * @param value      deposited value
     */
    public LandBankDepositEvent(@NotNull Land land, @NotNull LandPlayer landPlayer, double value) {
        super(land, landPlayer, value);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
