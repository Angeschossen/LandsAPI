package me.angeschossen.lands.api.events.land.block;

import me.angeschossen.lands.api.events.land.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.land.block.LandBlock;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class LandBlockEvent extends LandEvent implements Cancellable {

    protected final @NotNull LandBlock landBlock;
    protected boolean cancelled;

    public LandBlockEvent(@NotNull Land land, @Nullable LandPlayer landPlayer, @NotNull LandBlock landBlock) {
        super(land, landPlayer);
        this.landBlock = landBlock;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @NotNull
    public final LandBlock getLandBlock() {
        return landBlock;
    }
}
