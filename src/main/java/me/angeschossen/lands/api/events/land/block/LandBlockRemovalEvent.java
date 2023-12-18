package me.angeschossen.lands.api.events.land.block;

import me.angeschossen.lands.api.events.land.LandEvent;
import me.angeschossen.lands.api.events.land.bank.BankEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.block.LandBlock;
import me.angeschossen.lands.api.land.block.removalreason.LandBlockRemovalReason;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LandBlockRemovalEvent extends LandBlockEvent {
    public static final HandlerList handlerList = new HandlerList();
    private final @NotNull LandBlockRemovalReason reason;

    /**
     * Create an instance of this event.
     *
     * @param landPlayer player that initiated the removal. If null, no player is involved.
     * @param landBlock  landblock that is being removed
     * @param reason     the reason of the removal
     */
    public LandBlockRemovalEvent(@Nullable LandPlayer landPlayer, @NotNull LandBlock landBlock, @NotNull LandBlockRemovalReason reason) {
        super(landBlock.getContainer().getLand(), landPlayer, landBlock);

        this.reason = reason;
    }

    /**
     * Get the reason of the removal.
     *
     * @return reason of removal
     */
    @NotNull
    public final LandBlockRemovalReason getReason() {
        return reason;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}