package me.angeschossen.lands.api.events.land.claiming;

import me.angeschossen.lands.api.events.internal.LandEditEvent;
import me.angeschossen.lands.api.land.ChunkCoordinate;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.Selection;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class LandUnclaimSelectionEvent extends LandEditEvent implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final Selection selection;
    private final Set<? extends ChunkCoordinate> unclaim;
    private boolean cancelled;

    public LandUnclaimSelectionEvent(@NotNull Land land, @Nullable LandPlayer landPlayer, @NotNull Selection selection, @NotNull Set<? extends ChunkCoordinate> unclaim) {
        super(land, landPlayer);

        this.selection = selection;
        this.unclaim = unclaim;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    @NotNull
    public Selection getSelection() {
        return selection;
    }

    @NotNull
    public Set<? extends ChunkCoordinate> getUnclaim() {
        return unclaim;
    }

    public boolean hasChunk(int x, int z) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }
}
