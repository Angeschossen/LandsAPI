package me.angeschossen.lands.api.player;

import me.angeschossen.lands.api.blockworks.BlockCoordinate;
import me.angeschossen.lands.api.handler.APIHandler;
import me.angeschossen.lands.api.land.ChunkCoordinate;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.claiming.ClaimResult;
import org.bukkit.Location;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiPredicate;

public interface Selection {

    /**
     * Get selection instance.
     * @param landPlayer The player
     * @param giveTool Should the tool be given to the player?
     * @param msg Should progress messages etc. be sent?
     * @param visualization Should the selection be visualized?
     * @return Selection instance
     */
    @NotNull
    static Selection of(@NotNull LandPlayer landPlayer, boolean giveTool, boolean msg, boolean visualization) {
        return APIHandler.getLandsIntegrationFactory().selectionOf(landPlayer, giveTool, msg, visualization);
    }

    /**
     * Is selection complete (pos 1 and pos 2)?
     *
     * @return Will return false if one position is missing.
     */
    boolean isComplete();

    /**
     * Claim all chunks in this selection.
     *
     * @param land The land
     * @param msg  Send success and failure messages?
     * @param cost Should it cost depending on the config?
     * @return The result of the claiming
     * @throws IllegalStateException If the selection isn't valid (or complete)
     */
    @NotNull
    CompletableFuture<ClaimResult> claim(@NotNull Land land, boolean msg, boolean cost) throws IllegalStateException;

    /**
     * Get pos 1
     *
     * @return Location of pos 1
     */
    BlockCoordinate getPos1();

    /**
     * Get pos 2
     *
     * @return Location of pos 2
     */
    BlockCoordinate getPos2();

    /**
     * Set pos 1
     *
     * @param location Location
     */
    void setPos1(@Nullable Location location);

    /**
     * Set pos 2
     *
     * @param location Location
     */
    void setPos2(@Nullable Location location);

    /**
     * Is valid?
     *
     * @param sendMessage Send not valid messages to player?
     * @return Will return false if selection is not complete, positions are not in the same world
     * or the selection is too big.
     */
    boolean isValid(boolean sendMessage);

    /**
     * Get chunks in this selection.
     *
     * @return Chunks in this selection
     */
    Collection<? extends ChunkCoordinate> getChunks();

    /**
     * Get size.
     *
     * @return Size
     */
    int getSize();

    boolean hasChunk(int x, int z);

    Collection<? extends ChunkCoordinate> getChunks(@NotNull BiPredicate<Integer, Integer> predicate);

    /**
     * Disable selection
     */
    void disable();
}
