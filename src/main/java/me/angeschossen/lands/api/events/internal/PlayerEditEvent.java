package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PlayerEditEvent extends Event implements Cancellable {

    private boolean cancelled;
    private final Area area;
    private final Land land;
    private final LandPlayer landPlayer;

    public PlayerEditEvent(Land land, @Nullable Area area, LandPlayer landPlayer) {
        this.land = land;
        this.area = area;
        this.landPlayer = landPlayer;
    }

    @Nullable
    public Area getArea() {
        return area;
    }

    @NotNull
    public LandPlayer getLandPlayer() {
        return landPlayer;
    }

    @NotNull
    public Land getLand() {
        return land;
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
