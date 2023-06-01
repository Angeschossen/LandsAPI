package me.angeschossen.lands.api.events.war.captureflag;

import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.CaptureFlag;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CaptureFlagBreakEvent extends CaptureFlagEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();
    private final BreakReason breakReason;

    public CaptureFlagBreakEvent(@NotNull CaptureFlag captureFlag, @Nullable LandPlayer player, BreakReason breakReason) {
        super(captureFlag, player);

        this.breakReason = breakReason;
    }

    public BreakReason getBreakReason() {
        return breakReason;
    }

    /**
     * Get the player involved.
     * @return null, if {@link #getBreakReason()} doesn't return BLOCK_BREAK
     */
    @Nullable
    public LandPlayer getPlayer(){
        return player;
    }

    public enum BreakReason {
        CAPTURED, BLOCK_BREAK, EXPLOSION, DEFENDER_LOGOUT
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
