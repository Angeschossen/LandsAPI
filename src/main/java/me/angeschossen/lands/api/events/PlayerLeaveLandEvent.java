package me.angeschossen.lands.api.events;

import me.angeschossen.lands.api.events.internal.PlayerEditEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerLeaveLandEvent extends PlayerEditEvent {

    public static HandlerList handlerList = new HandlerList();

    public PlayerLeaveLandEvent(Land land, @Nullable Area area, LandPlayer landPlayer) {
        super(land, area, landPlayer);
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return handlerList;
    }
}
