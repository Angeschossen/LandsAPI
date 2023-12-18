package me.angeschossen.lands.api.events.land.block;

import me.angeschossen.lands.api.land.block.LandBlock;
import me.angeschossen.lands.api.land.block.removalreason.LandBlockRemovalReason;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LandBlockCreationEvent extends LandBlockEvent {
    public static final HandlerList handlerList = new HandlerList();

    /**
     * Create an instance of this event.
     *
     * @param landPlayer player that placed the landblock. If null, no player is involved.
     * @param landBlock  landblock that is being placed
     */
    public LandBlockCreationEvent(@Nullable LandPlayer landPlayer, @NotNull LandBlock landBlock) {
        super(landBlock.getContainer().getLand(), landPlayer, landBlock);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}