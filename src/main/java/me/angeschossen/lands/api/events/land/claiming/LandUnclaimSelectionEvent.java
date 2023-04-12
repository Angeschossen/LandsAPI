package me.angeschossen.lands.api.events.land.claiming;

import me.angeschossen.lands.api.blockworks.ChunkCoordinate;
import me.angeschossen.lands.api.events.internal.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.Selection;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public class LandUnclaimSelectionEvent extends LandEvent implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final Selection selection;
    private boolean cancelled;
    private final Set<? extends me.angeschossen.lands.api.land.ChunkCoordinate> unclaim;

    public LandUnclaimSelectionEvent(@NotNull Land land, @Nullable LandPlayer landPlayer, @NotNull Selection selection, @NotNull Set<? extends me.angeschossen.lands.api.land.ChunkCoordinate> unclaim) {
        super(land, landPlayer);

        this.selection = selection;
        this.unclaim = unclaim;
    }

    @NotNull
    public Set<? extends me.angeschossen.lands.api.land.ChunkCoordinate> getUnclaim() {
        return unclaim;
    }

    @NotNull
    public Selection getSelection() {
        return selection;
    }

    public boolean hasChunk(int x, int z){
        return unclaim.contains(new ChunkCoordinate(x, z));
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
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
