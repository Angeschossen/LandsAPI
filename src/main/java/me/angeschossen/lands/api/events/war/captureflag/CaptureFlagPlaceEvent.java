package me.angeschossen.lands.api.events.war.captureflag;

import me.angeschossen.lands.api.events.land.block.LandBlockPlaceEvent;
import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.captureflag.CaptureFlag;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Use {@link LandBlockPlaceEvent} instead.
 */
@Deprecated
public class CaptureFlagPlaceEvent extends CaptureFlagEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();

    /**
     * Create instance of this event.
     *
     * @param captureFlag the capture flag that is being placed
     * @param player      the player that places it
     */
    public CaptureFlagPlaceEvent(@NotNull CaptureFlag captureFlag, @NotNull LandPlayer player) {
        super(captureFlag, player);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }


    /**
     * Get the player that places the flag.
     *
     * @return never null
     */
    @NotNull
    public final LandPlayer getLandPlayer() {
        assert player != null;
        return player;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
