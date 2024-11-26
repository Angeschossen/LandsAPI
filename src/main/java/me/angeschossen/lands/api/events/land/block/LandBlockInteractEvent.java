package me.angeschossen.lands.api.events.land.block;

import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.block.LandBlock;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a player interacts with a mainblock or caputeflag etc.
 * Landblock types: {@link me.angeschossen.lands.api.land.block.LandBlockType}
 */
public class LandBlockInteractEvent extends LandBlockEvent {
    public static final HandlerList handlerList = new HandlerList();

    public LandBlockInteractEvent(@NotNull Land land, @Nullable LandPlayer landPlayer, @NotNull LandBlock landBlock) {
        super(land, landPlayer, landBlock);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
