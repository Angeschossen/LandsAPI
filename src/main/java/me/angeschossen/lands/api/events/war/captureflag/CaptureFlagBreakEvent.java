package me.angeschossen.lands.api.events.war.captureflag;

import com.github.angeschossen.pluginframework.api.utils.Checks;
import me.angeschossen.lands.api.land.block.removalreason.LandBlockRemovalReason;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.captureflag.CaptureFlag;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called whenever a capture flag is being removed.
 */
public class CaptureFlagBreakEvent extends CaptureFlagEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final @NotNull BreakReason breakReason;

    /**
     * Create an instance of this event.
     *
     * @param captureFlag the flag that is being removed
     * @param player      player that is involved in removing it
     * @param breakReason the reason of the removal
     */
    public CaptureFlagBreakEvent(@NotNull CaptureFlag captureFlag, @Nullable LandPlayer player, @NotNull BreakReason breakReason) {
        super(captureFlag, player);

        Checks.requireNonNull(breakReason, "reason");
        this.breakReason = breakReason;
    }

    /**
     * Get the reason of the removal.
     *
     * @return reason of removal
     */
    @NotNull
    public BreakReason getReason() {
        return breakReason;
    }

    /**
     * Describes the reason of removal.
     */
    public enum BreakReason implements LandBlockRemovalReason {
        /**
         * The capture flag has been captured by the invaders.
         */
        CAPTURED,
        /**
         * The capture flag has been broken by either the invaders or defenders.
         */
        BLOCK_BREAK,
        /**
         * An explosion broke the capture flag.
         */
        EXPLOSION,
        /**
         * If a player is currently defening a capture flag and quits the game, the capture flag
         * will be removed and the invaders will have captured the flag successfully.
         */
        DEFENDER_LOGOUT,
        /**
         * The war is over.
         */
        WAR_END,
        /**
         * At least one of the blocks of the capture flag don't exist anymore in the world.
         */
        BLOCK_INVALID
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }


    /**
     * Cancel the removal of the capture flag.
     *
     * @param cancelled true if you wish to cancel this event
     * @throws IllegalStateException if this capture flag is removed because of {@link BreakReason#BLOCK_INVALID} or {@link BreakReason#CAPTURED}.
     *                               For {@link BreakReason#CAPTURED}, please cancel {@link CaptureFlagCapturedEvent} instead.
     */
    @Override
    public void setCancelled(boolean cancelled) throws IllegalStateException {
        if (breakReason == BreakReason.BLOCK_INVALID || breakReason == BreakReason.CAPTURED) {
            throw new IllegalStateException("Can't cancel event with reason " + breakReason.toString());
        }

        super.setCancelled(cancelled);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
