package me.angeschossen.lands.api.events.land.claiming;

import me.angeschossen.lands.api.blockworks.ChunkCoordinate;
import me.angeschossen.lands.api.events.land.LandEvent;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.player.Selection;
import org.bukkit.World;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

/**
 * Called whenever a selection of chunks is unclaimed from a land.
 * This usally involves a player executing entering the selection mode ({@link Selection}) and selecting a rectangle of chunks.
 */
public class LandUnclaimSelectionEvent extends LandEvent implements Cancellable {
    public static HandlerList handlerList = new HandlerList();
    private final Selection selection;
    private boolean cancelled;
    private final Set<? extends me.angeschossen.lands.api.land.ChunkCoordinate> unclaim;

    /**
     * Create an instance of this event.
     *
     * @param land       land for which the selection is about to become unclaimed
     * @param landPlayer player that triggered the selection unclaim
     * @param selection  the selection to be unclaimed
     * @param unclaim    the collection of chunks that are going to be unclaimed.
     *                   In contrast to {@link Selection#getChunks()} this doesn't include already unclaimed chunks etc.
     */
    public LandUnclaimSelectionEvent(@NotNull Land land, @Nullable LandPlayer landPlayer, @NotNull Selection selection, @NotNull Set<? extends me.angeschossen.lands.api.land.ChunkCoordinate> unclaim) {
        super(land, landPlayer);

        if (!selection.isValid(false)) {
            throw new IllegalArgumentException("The selection isn't valid");
        }

        this.selection = selection;
        this.unclaim = unclaim;
    }

    /**
     * Get the collection of chunks that is going to be unclaimed.
     *
     * @return this doesn't include already unclaimed chunks or chunks that the player isn't allowed to unclaim
     */
    @NotNull
    public Set<? extends me.angeschossen.lands.api.land.ChunkCoordinate> getUnclaimedChunks() {
        return unclaim;
    }

    /**
     * Get the involved selection. To retrieve chunks that are going to be unclaimed use {@link #getUnclaimedChunks()}.
     *
     * @return never null
     */
    @NotNull
    public Selection getSelection() {
        return selection;
    }

    /**
     * Check if a specific chunk is going to be unclaimed.
     *
     * @param world The world
     * @param x chunk X identifier
     * @param z chunk Z identifier
     * @return true, if {@link #getUnclaimedChunks()} contains this chunk
     */
    public boolean hasChunk(World world, int x, int z) {
        World w = selection.getPos1().getWorld();
        return world.equals(w) && unclaim.contains(new ChunkCoordinate(x, z));
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
