package me.angeschossen.lands.api.events.land.bank;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandBankWithdrawEvent extends BankEvent implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();

    public LandBankWithdrawEvent(@NotNull Land land, @NotNull LandPlayer landPlayer, double value) {
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
