package me.angeschossen.lands.api.events.war.captureflag;

import me.angeschossen.lands.api.war.captureflag.CaptureFlag;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * Called whenever a capture flag has been captured successfully.
 */
public class CaptureFlagCapturedEvent extends CaptureFlagEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();

    /**
     * Create instance of this event.
     * @param captureFlag the captured flag
     */
    public CaptureFlagCapturedEvent(@NotNull CaptureFlag captureFlag) {
        super(captureFlag, null);
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
