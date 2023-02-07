package me.angeschossen.lands.api.events.land.bank;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.internal.LandEditEvent;
import me.angeschossen.lands.api.events.memberholder.MemberHolderEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.memberholder.MemberHolder;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandBankDepositEvent extends BankEvent implements Cancellable {
    public static final HandlerList handlerList = new HandlerList();

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
