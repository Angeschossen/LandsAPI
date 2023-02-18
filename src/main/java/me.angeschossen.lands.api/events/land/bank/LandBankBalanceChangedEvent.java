package me.angeschossen.lands.api.events.land.bank;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.internal.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class LandBankBalanceChangedEvent extends LandEvent {

    public static final HandlerList handlerList = new HandlerList();
    private final double prev, now;

    public LandBankBalanceChangedEvent(@NotNull Land land, double prev, double now) {
        super(land, (LandPlayer) null);

        this.prev = prev;
        this.now = now;
    }

    public double getNow() {
        return now;
    }

    public double getPrevious() {
        return prev;
    }


    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("previous", prev)
                .put("now", now);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
