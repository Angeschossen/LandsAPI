package me.angeschossen.lands.api.events.internal;

import me.angeschossen.lands.api.land.Area;
import me.angeschossen.lands.api.player.LandPlayer;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

public abstract class PlayerLocationAreaEvent extends Event {

    @NotNull
    public Area getArea() {
        return null;
    }

    @NotNull
    public LandPlayer getLandPlayer() {
        return null;
    }
}
