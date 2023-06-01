package me.angeschossen.lands.api.events.war.captureflag;

import me.angeschossen.lands.api.player.LandPlayer;
import me.angeschossen.lands.api.war.CaptureFlag;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class CaptureFlagPlaceEvent extends CaptureFlagEvent implements Cancellable {

    public static HandlerList handlerList = new HandlerList();

    public CaptureFlagPlaceEvent(@NotNull CaptureFlag captureFlag, @NotNull LandPlayer player) {
        super(captureFlag, player);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }


    @NotNull
    public LandPlayer getPlayer() {
        return player;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
