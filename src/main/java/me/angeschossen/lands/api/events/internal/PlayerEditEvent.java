package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.events.internal.plugin.LandsPlayerEvent;
import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PlayerEditEvent extends LandsPlayerEvent implements Cancellable {
    private final @Nullable Area area;
    private final Land land;
    private boolean cancelled;

    public PlayerEditEvent(@NotNull Land land, @Nullable Area area, @NotNull LandPlayer landPlayer) {
        super(landPlayer);

        this.land = land;
        this.area = area;
        this.landPlayer = landPlayer;
    }

    @Nullable
    public Area getArea() {
        return area;
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
