package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.land.Land;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class PlayerEditEvent extends Event implements Cancellable {

    @Nullable
    public Area getArea() {
        return null;
    }

    @NotNull
    public LandPlayer getLandPlayer() {
        return null;
    }

    @NotNull
    public Land getLand() {
        return null;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }
}
