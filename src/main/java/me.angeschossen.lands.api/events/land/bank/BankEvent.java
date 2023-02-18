package me.angeschossen.lands.api.events.land.bank;

import com.google.common.collect.ImmutableMap;
import me.angeschossen.lands.api.events.internal.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BankEvent extends LandEvent implements Cancellable {
    private boolean cancelled = false;
    private final double value;

    public BankEvent(@NotNull Land land, @Nullable LandPlayer landPlayer, double value) {
        super(land, landPlayer);

        this.value = value;
    }

    public final double getValue() {
        return value;
    }

    @Override
    public final boolean isCancelled() {
        return cancelled;
    }

    @Override
    public final void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    @Override
    public void setExpressionVariables(ImmutableMap.@NotNull Builder<String, Object> builder) {
        super.setExpressionVariables(builder);

        builder.put("value", value);
    }
}
